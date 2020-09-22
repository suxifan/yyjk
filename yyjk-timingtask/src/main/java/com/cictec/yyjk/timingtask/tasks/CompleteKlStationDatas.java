package com.cictec.yyjk.timingtask.tasks;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.cictec.yyjk.commons.utils.StringUtils;
import com.cictec.yyjk.commons.utils.sid.SidUtils;
import com.cictec.yyjk.timingtask.model.entity.DwDimLineStation;
import com.cictec.yyjk.timingtask.model.entity.TempTPassengerFlowResult;
import com.cictec.yyjk.timingtask.service.DwDimLineStationService;
import com.cictec.yyjk.timingtask.service.PassengerFlowResultService;
import com.cictec.yyjk.timingtask.service.TempTPassengerFlowResultService;

//@RestController
//@RequestMapping("/api/analysis")
@Component
public class CompleteKlStationDatas {
	private static final Logger LOG = LoggerFactory.getLogger(CompleteKlStationDatas.class);

	@Autowired
	private PassengerFlowResultService passengerFlowResultService;

	@Autowired
	private TempTPassengerFlowResultService tempTPassengerFlowResultService;

	@Autowired
	private DwDimLineStationService dwDimLineStationService;

	/**
	 * 按线路获取车辆到站时刻信息(获取前一天数据) pg批量插入时参数个数有限制，目前的版本最大限制50132
	 */
	// @PostMapping("/completeKl")
	@Scheduled(cron = "${jobs.schedule.passengerflow.completeKl}")
	public void start() {
		LOG.info("客流数据定时任务开始...");

		LOG.info("备份当天客流数据开始...");
		passengerFlowResultService.copyTable();
		LOG.info("备份当天客流数据结束...");

		// 对客流数据进行补全
		LOG.info("客流数据进行补全开始...");
		completeKlStationDatas();
		LOG.info("客流数据进行补全结束...");

	}

	/**
	 * 补全客流因到站后没有开关门丢失的站点客流数据
	 * 
	 * 因为丢失后统计的站点断面客流不正确
	 */
	private void completeKlStationDatas() {
		Map<String, DwDimLineStation> lineStaDisc = getLineStaDisc();
		List<String> lineIds = tempTPassengerFlowResultService.getLineIds();
		for (String lineUuid : lineIds) {
			// 保存补全的客流数据集合
			List<TempTPassengerFlowResult> results = new ArrayList<>();

			List<TempTPassengerFlowResult> delDatas = new ArrayList<>();

			List<TempTPassengerFlowResult> klDatas = tempTPassengerFlowResultService.getKlDataByLineUuid(lineUuid);
			if (CollectionUtils.isNotEmpty(klDatas)) {
				// 将客流按车辆设备编号分组
				Map<String, List<TempTPassengerFlowResult>> devCodeMap = klDatas.stream()
						.collect(Collectors.groupingBy(TempTPassengerFlowResult::getPrfDevCode));
				for (String devCode : devCodeMap.keySet()) {

					List<TempTPassengerFlowResult> devCodeKlList = devCodeMap.get(devCode);
					if (CollectionUtils.isNotEmpty(devCodeKlList)) {
						// 将客流数据按线路分组
						Map<String, List<TempTPassengerFlowResult>> lineTypeMap = devCodeKlList.stream()
								.collect(Collectors.groupingBy(TempTPassengerFlowResult::getPfrLineType));
						for (String lineType : lineTypeMap.keySet()) {
							// 根据线路类型及线路主键获取线路站序
							List<String> lineStaSeqs = dwDimLineStationService.getLineStaSeqs(lineUuid, lineType);

							List<TempTPassengerFlowResult> lineTypeKlList = lineTypeMap.get(lineType);
							if (CollectionUtils.isNotEmpty(lineTypeKlList)) {
								// 将客流数据按趟次分组
								Map<String, List<TempTPassengerFlowResult>> tripMap = lineTypeKlList.stream()
										.collect(Collectors.groupingBy(TempTPassengerFlowResult::getPfrTripTime));
								for (String trip : tripMap.keySet()) {
									List<TempTPassengerFlowResult> tripKlList = tripMap.get(trip);
									// 对车辆单趟数据进行补全处理
									if (tripKlList.size() > 2) {
										List<TempTPassengerFlowResult> singleTripList = completeKlMissStationHandle(
												tripKlList, lineStaSeqs, lineStaDisc);
										results.addAll(singleTripList);
									} else {
										delDatas.addAll(tripKlList);
									}
								}
							}
						}
					}
				}
			}
			// 将待补全的客流数据入库
			for (TempTPassengerFlowResult bean : results) {
				tempTPassengerFlowResultService.insertSelective(bean);
			}
			// 将废趟次更新为无效趟次
			for (TempTPassengerFlowResult bean : delDatas) {
				tempTPassengerFlowResultService.updateQuality(bean.getPfrUuid());
			}
		}
	}

	/**
	 * 补全客流丢失站点数据处理函数
	 * 
	 * 补全业务逻辑
	 * 
	 * 用相邻的站点补全丢失客流数据
	 * 
	 * 1、根据线路ID，线路类型，站序查询线路站点信息，补全丢失的线路站点ID及站点ID
	 * 
	 * 2、上车人数、下车人数补0,前门上车补0，前门下车补0，后门上车补0，后门下车补0。车内人数不变
	 * 
	 * 3、客流发生时间不能侵入上下相邻的趟次
	 * 
	 * @param tripKlList
	 * @param lineStaSeqs
	 * @param lineStaDisc
	 */
	private List<TempTPassengerFlowResult> completeKlMissStationHandle(List<TempTPassengerFlowResult> tripKlList,
			List<String> lineStaSeqs, Map<String, DwDimLineStation> lineStaDisc) {
		// 过滤非法数据并补全头部丢失的客流数据
		List<TempTPassengerFlowResult> filterList = filterKlDatas(tripKlList, lineStaSeqs, lineStaDisc);
		// 补全客流数据
		List<TempTPassengerFlowResult> fullList = completeKlMissDatas(filterList, lineStaSeqs, lineStaDisc);
		// TODO 处理时间，待处理的数据以按站序升序排序
		List<TempTPassengerFlowResult> resulList = setKLDataUploadTime(fullList, lineStaSeqs);
		return resulList;
	}

	/**
	 * 合理设置补全数据时间，防止本趟次时间侵入其他趟次中
	 * 
	 * @param fullList
	 * @return
	 */
	private List<TempTPassengerFlowResult> setKLDataUploadTime(List<TempTPassengerFlowResult> fullList,
			List<String> lineStaSeqs) {
		// 用来保存补全后结果
		List<TempTPassengerFlowResult> completionList = new ArrayList<>();
		// 按时间分组，每个分组里可能有多个元素
		Map<Date, List<TempTPassengerFlowResult>> dateMap = fullList.stream()
				.collect(Collectors.groupingBy(TempTPassengerFlowResult::getPfrUploadTime));
		// 按站序分组，每个分组里只有一个元素
		Map<String, List<TempTPassengerFlowResult>> seqMap = fullList.stream()
				.collect(Collectors.groupingBy(TempTPassengerFlowResult::getPfrStationSeq));

		String s = lineStaSeqs.get(0);// 首站
		String e = lineStaSeqs.get(lineStaSeqs.size() - 1);// 末站

		for (Date datekey : dateMap.keySet()) {
			List<TempTPassengerFlowResult> dateKLList = dateMap.get(datekey);
			if (dateKLList.size() >= 2) {

				String s1 = dateKLList.get(0).getPfrStationSeq();// 补全时间首站站序
				String e1 = dateKLList.get(dateKLList.size() - 1).getPfrStationSeq();// 补全时间末站站序
				String status = dateKLList.get(dateKLList.size() - 1).getType();
				if (status == null) {
					continue;
				}

				if (!s1.equals(s) && !e1.equals(e)) {// 不包含首战和末站
					String seq = (Integer.parseInt(e1) + 1) + "";
					Date startDate = dateKLList.get(0).getPfrUploadTime();// 补全开始时间
					Date endDate = seqMap.get(seq).get(0).getPfrUploadTime();// 补全结束时间
					List<TempTPassengerFlowResult> tempList = timeDivided(dateKLList, startDate, endDate, "1");
					completionList.addAll(tempList);
				} else if (s1.equals(s)) {// 包含首战
					String seq = (Integer.parseInt(e1) + 1) + "";
					LOG.debug(dateKLList.get(0).getPrfDevCode() + "**********" + dateKLList.get(0).getPfrTripTime());
					Date startDate = dateKLList.get(0).getPfrUploadTime();// 补全开始时间
					Date endDate = seqMap.get(seq).get(0).getPfrUploadTime();// 补全结束时间
					List<TempTPassengerFlowResult> tempList = timeDivided(dateKLList, startDate, endDate, "1");
					completionList.addAll(tempList);
				} else if (e1.equals(e)) {// 包含末站
					Date startDate = dateKLList.get(0).getPfrUploadTime();// 补全开始时间
					Date endDate = seqMap.get(e1).get(0).getPfrUploadTime();// 补全结束时间
					List<TempTPassengerFlowResult> tempList = timeDivided(dateKLList, startDate, endDate, "3");
					completionList.addAll(tempList);
				}
			}
		}
		for (TempTPassengerFlowResult TempTPassengerFlowResult : fullList) {// 将首战数据添加到completionList
			String status = TempTPassengerFlowResult.getType();
			if (status != null && status.equals("1")) {
				completionList.add(TempTPassengerFlowResult);
			}
		}

		return completionList;
	}

	/**
	 * 根据开始、结束时间进行进出站时间分割、重置
	 * 
	 * @param results
	 * @param d1
	 * @param d2
	 */
	private List<TempTPassengerFlowResult> timeDivided(List<TempTPassengerFlowResult> results, Date sd, Date ed,
			String type) {
		List<TempTPassengerFlowResult> newCompletionList = new ArrayList<>();// 将补全数据设置时间，并剔除重复数据，只保留补全得数据。
		if (type.equals("1")) {// 中间站处理
			long stime = sd.getTime();// 开始时间
			long etime = ed.getTime();// 结束时间
			Long time = (etime - stime);// 相差毫秒数
			long splitValue = time / results.size();// 时间间隔

			for (int i = 1; i < results.size(); i++) {

				long section = splitValue * i;

				String status = results.get(i).getType();

				if (status != null && status.equals("0")) {
					results.get(i).setPfrUploadTime(getDate(stime, section));
					newCompletionList.add(results.get(i));
				}
			}
		} else if (type.equals("3")) {// 包含末站的处理

			long time = sd.getTime();

			for (int i = 1; i < results.size(); i++) {

				long time2 = time + (60 * 1000) * (i);
				Calendar calendar = Calendar.getInstance();
				calendar.setTimeInMillis(time2);

				String status = results.get(i).getType();
				if (status != null && status.equals("0")) {
					results.get(i).setPfrUploadTime(calendar.getTime());
					newCompletionList.add(results.get(i));
				}
			}
		}
		return newCompletionList;
	}

	/**
	 * 根据开始、结束时间进行进出站时间分割、重置
	 * 
	 * @param results
	 * @param d1
	 * @param d2
	 */
	private Date getDate(long d1, long d2) {
		Long time = (d1 + d2);
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(time);
		return calendar.getTime();
	}

	/**
	 * 过滤车辆单个趟次客流数据，去掉不实站点数据，并将头部缺失的站点补全，保证所有趟次的客流都是有头部数据的
	 * 
	 * @param tripKlList
	 * @param lineStaSeqs
	 * @param lineStaDisc
	 * @return
	 */
	private List<TempTPassengerFlowResult> filterKlDatas(List<TempTPassengerFlowResult> tripKlList,
			List<String> lineStaSeqs, Map<String, DwDimLineStation> lineStaDisc) {
		// 对数据按时间升序排序
		List<TempTPassengerFlowResult> klList = tripKlList.stream()
				.sorted(Comparator.comparing(TempTPassengerFlowResult::getPfrUploadTime)).collect(Collectors.toList());

		// 根据线路站点站序过滤客流数据
		List<TempTPassengerFlowResult> tempList = new ArrayList<>();
		for (TempTPassengerFlowResult item : klList) {
			String seq = item.getPfrStationSeq();
			if (lineStaSeqs.contains(seq)) {
				tempList.add(item);
			}
		}

		if (tempList.isEmpty()) {
			return tempList;
		}

		// 获取第一个站点客流数据的站序
		TempTPassengerFlowResult passengerFlow = tempList.get(0);
		String seqStr = passengerFlow.getPfrStationSeq();

		int seq = StringUtils.isNotEmpty(seqStr) ? Integer.parseInt(seqStr) : 1;
		// *******
		long time = passengerFlow.getPfrUploadTime().getTime();
		// *******
		List<TempTPassengerFlowResult> resultList = new ArrayList<>();
		// 如果站序大于1，说明丢失了最前面的站点，将前面的数据补全
		if (seq > 1) {
			for (int i = 1; i < seq; i++) {
				TempTPassengerFlowResult bean = new TempTPassengerFlowResult();
				BeanUtils.copyProperties(passengerFlow, bean);
				// 设置主键
				bean.setPfrUuid(SidUtils.getSid());
				// 设置站序，线路站点id,站点id
				bean.setPfrStationSeq(i + "");
				String key = bean.getPfrLineUuid() + bean.getPfrLineType() + i;
				DwDimLineStation dwDimLineStation = lineStaDisc.get(key);
				if (dwDimLineStation != null) {
					bean.setPfrStationUuid(dwDimLineStation.getLsStaUuid());
					bean.setPfrLineStationUuid(dwDimLineStation.getLsUuid());
				}
				// 将上下车客流量设置为零
				bean.setPfrGetOffNumber(0);
				bean.setPfrGetOnNumber(0);
				bean.setPrfGetFOnNumber(0);
				bean.setPrfGetFOffNumber(0);
				bean.setPrfGetEOnNumber(0);
				bean.setPrfGetEOffNumber(0);
				bean.setType("1");// 0为补录数据
				// *******
				long time2 = time - (60 * 1000) * (seq - i);
				Calendar calendar = Calendar.getInstance();
				calendar.setTimeInMillis(time2);
				bean.setPfrUploadTime(calendar.getTime());
				// *******
				resultList.add(bean);
			}
		}
		resultList.addAll(tempList);

		return resultList;
	}

	/**
	 * 根据最近客流数据补全
	 * 
	 * @param tripKlList
	 * @param lineStaSeqs
	 * @param lineStaDisc
	 * @return
	 */
	private List<TempTPassengerFlowResult> completeKlMissDatas(List<TempTPassengerFlowResult> filterList,
			List<String> lineStaSeqs, Map<String, DwDimLineStation> lineStaDisc) {
		// 用来保存补全后结果
		List<TempTPassengerFlowResult> fullList = new ArrayList<>();
		// 按站序分组，每个分组里只有一个元素
		Map<String, List<TempTPassengerFlowResult>> seqMap = filterList.stream()
				.collect(Collectors.groupingBy(TempTPassengerFlowResult::getPfrStationSeq));
		Set<String> seqSet = seqMap.keySet();
		TempTPassengerFlowResult flagBean = null;
		for (String seq : lineStaSeqs) {
			// 因为一个趟次补全的头部数据，最坏的情况从第二个站点丢失
			if (!seqSet.contains(seq)) {
				// 用前一个数据拷贝并修改相关数据
				String perSeq = (Integer.parseInt(seq) - 1) + "";
				boolean containsKey = seqMap.containsKey(perSeq);
				TempTPassengerFlowResult perBean = null;
				if (containsKey) {
					perBean = seqMap.get(perSeq).get(0);
				} else {
					perBean = null;
				}
				if (perBean != null) {
					flagBean = perBean;
				}
				TempTPassengerFlowResult bean = new TempTPassengerFlowResult();
				BeanUtils.copyProperties(flagBean, bean);
				// 设置主键
				bean.setPfrUuid(SidUtils.getSid());
				// 设置站序，线路站点ID,站点ID
				bean.setPfrStationSeq(seq);
				String key = bean.getPfrLineUuid() + bean.getPfrLineType() + seq;
				DwDimLineStation dwDimLineStation = lineStaDisc.get(key);
				if (dwDimLineStation != null) {
					bean.setPfrStationUuid(dwDimLineStation.getLsStaUuid());
					bean.setPfrLineStationUuid(dwDimLineStation.getLsUuid());
				}
				// 将上下车客流量设置为零
				bean.setPfrGetOffNumber(0);
				bean.setPfrGetOnNumber(0);
				bean.setPrfGetFOnNumber(0);
				bean.setPrfGetFOffNumber(0);
				bean.setPrfGetEOnNumber(0);
				bean.setPrfGetEOffNumber(0);
				bean.setType("0");// 0为补录数据
				fullList.add(bean);
			} else {
				TempTPassengerFlowResult bean = seqMap.get(seq).get(0);
				fullList.add(bean);
			}
		}
		return fullList;
	}

	/**
	 * 返回已线路id，lineType，seq为键的线路站点字典表
	 * 
	 * @return
	 */
	private Map<String, DwDimLineStation> getLineStaDisc() {
		List<DwDimLineStation> list = dwDimLineStationService.getAll();
		if (list == null) {
			return Collections.emptyMap();
		}
		Map<String, DwDimLineStation> lineStationMap = new HashMap<>();
		for (DwDimLineStation item : list) {
			String key = item.getLsLineUuid() + item.getLsLineType() + item.getLsSequence();
			if (!lineStationMap.keySet().contains(key)) {
				lineStationMap.put(key, item);
			}
		}
		return lineStationMap;
	}

}
