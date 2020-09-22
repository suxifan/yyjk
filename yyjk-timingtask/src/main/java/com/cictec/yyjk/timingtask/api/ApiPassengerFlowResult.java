package com.cictec.yyjk.timingtask.api;

import java.io.File;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cictec.yyjk.base.api.BaseController;
import com.cictec.yyjk.base.interceptors.AccessLogInfo;
import com.cictec.yyjk.base.model.entity.BaseSysParamInfo;
import com.cictec.yyjk.base.model.vo.BaseSysParamInfoVo;
import com.cictec.yyjk.base.service.BaseSysParamInfoService;
import com.cictec.yyjk.commons.core.Result;
import com.cictec.yyjk.commons.core.ResultUtil;
import com.cictec.yyjk.commons.utils.DateUtils;
import com.cictec.yyjk.commons.utils.FileOperUtils;
import com.cictec.yyjk.commons.utils.PMSUtils;
import com.cictec.yyjk.timingtask.model.entity.PassengerFlowResult;
import com.cictec.yyjk.timingtask.model.viewdata.OnOffPsersonNumberValue;
import com.cictec.yyjk.timingtask.model.viewdata.PersonDetailValue;
import com.cictec.yyjk.timingtask.model.vo.PassengerFlowResultVo;
import com.cictec.yyjk.timingtask.service.PassengerFlowResultService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * Created by xpguo on 2019/05/21.
 */
@RestController
@RequestMapping("/api/passenger/flow/result")
public class ApiPassengerFlowResult extends BaseController {
	private static final Logger LOG = LoggerFactory.getLogger(ApiPassengerFlowResult.class);
	// web映射地址
	@Value("${web.webrooturl}")
	private String webrooturl;
	@Autowired
	private Environment env;
	@Autowired
	private BaseSysParamInfoService baseSysParamInfoService;
	@Resource
	private PassengerFlowResultService passengerFlowResultService;

	@PostMapping("/add")
	public Result add(@RequestBody PassengerFlowResult passengerFlowResult) {
		passengerFlowResultService.insertSelective(passengerFlowResult);
		return ResultUtil.getSuccessResult();
	}

	@PostMapping("/delete")
	public Result delete(@RequestParam Integer id) {
		passengerFlowResultService.deleteByPrimaryKey(id);
		return ResultUtil.getSuccessResult();
	}

	@PostMapping("/update")
	public Result update(@RequestBody PassengerFlowResult passengerFlowResult) {
		passengerFlowResultService.updateByPrimaryKeySelective(passengerFlowResult);
		return ResultUtil.getSuccessResult();
	}

	@PostMapping("/detail")
	public Result detail(@RequestParam Integer id) {
		PassengerFlowResult passengerFlowResult = passengerFlowResultService.selectByPrimaryKey(id);
		return ResultUtil.getSuccessResult(passengerFlowResult);
	}

	@AccessLogInfo(modelName = "运营分析", pageName = "客流数据明细查询")
	@PostMapping("/list")
	public Result list(@RequestBody PassengerFlowResultVo passengerFlowResultVo) {

		// 判定是否包含分页参数，如果包含则为分页数据请求
		if (passengerFlowResultVo.getPageSize() != null && passengerFlowResultVo.getPageSize() != 0) {
			return pageList(passengerFlowResultVo);
		}
		try {
			List<PassengerFlowResult> list = passengerFlowResultService
					.getPassengerFlowFromESNoPageStatic(passengerFlowResultVo);
			BigDecimal toatlOnNumber = new BigDecimal("0");
			BigDecimal toatlOffNumber = new BigDecimal("0");
			if (list != null && list.size() > 0) {
				for (PassengerFlowResult item : list) {
					toatlOnNumber = toatlOnNumber.add(new BigDecimal(item.getPfrGetOnNumber()));
					toatlOffNumber = toatlOffNumber.add(new BigDecimal(item.getPfrGetOffNumber()));
				}
			}
			PersonDetailValue result = new PersonDetailValue();
			result.setNoPageInfo(list);
			result.setTotalOnPersonCount(toatlOnNumber);
			result.setTotalOffPersonCount(toatlOffNumber);
			return ResultUtil.getSuccessResult(result);
		} catch (Exception ex) {
			LOG.error("历史客流明细异常，原因：{}", ex);
			return ResultUtil.getErrorResult();
		}
	}

	@PostMapping("/pageList")
	public Result pageList(@RequestBody PassengerFlowResultVo passengerFlowResultVo) {
		// 分页数据请求处理
		try {
			PageInfo<PassengerFlowResult> pageInfo = passengerFlowResultService
					.getPassengerFlowFromES(passengerFlowResultVo);
			// 不分页结果求和
			List<PassengerFlowResult> list = passengerFlowResultService
					.getPassengerFlowFromESNoPageStatic(passengerFlowResultVo);
			BigDecimal toatlOnNumber = new BigDecimal("0");
			BigDecimal toatlOffNumber = new BigDecimal("0");
			if (list != null && list.size() > 0) {
				for (PassengerFlowResult item : list) {
					toatlOnNumber = toatlOnNumber.add(new BigDecimal(item.getPfrGetOnNumber()));
					toatlOffNumber = toatlOffNumber.add(new BigDecimal(item.getPfrGetOffNumber()));
				}
			}
			PersonDetailValue result = new PersonDetailValue();
			result.setPageInfo(pageInfo);
			result.setTotalOnPersonCount(toatlOnNumber);
			result.setTotalOffPersonCount(toatlOffNumber);
			return ResultUtil.getSuccessResult(result);
		} catch (Exception ex) {
			LOG.error("历史客流明细分页异常，原因：{}", ex);
			return ResultUtil.getErrorResult();
		}
	}

	@SuppressWarnings("rawtypes")
	@AccessLogInfo(modelName = "运营分析", pageName = "客流数据明细查询")
	@PostMapping("/todayList")
	public Result todayList(@RequestBody PassengerFlowResultVo passengerFlowResultVo) {

		// 判定是否包含分页参数，如果包含则为分页数据请求
		if (passengerFlowResultVo.getPageSize() != null && passengerFlowResultVo.getPageSize() != 0) {
			return pageTodayList(passengerFlowResultVo);
		}
		try {
			List<PassengerFlowResult> list = passengerFlowResultService.getTodayPassengerFlow(passengerFlowResultVo);
			Map map = passengerFlowResultService.getTodayTotalOnOffPassengerFlow(passengerFlowResultVo);
			PersonDetailValue result = new PersonDetailValue();
			result.setNoPageInfo(list);
			result.setTotalOnPersonCount(new BigDecimal((Long) map.get("totalOnPersonCount")));
			result.setTotalOffPersonCount(new BigDecimal((Long) map.get("totalOffPersonCount")));
			return ResultUtil.getSuccessResult(result);
		} catch (Exception ex) {
			LOG.error("今天客流明细分页异常，原因：{}", ex);
			return ResultUtil.getErrorResult();
		}
	}

	@SuppressWarnings("rawtypes")
	@PostMapping("/pageTodayList")
	public Result pageTodayList(@RequestBody PassengerFlowResultVo passengerFlowResultVo) {
		try {
			// 分页数据请求处理
			PageHelper.startPage(passengerFlowResultVo.getPageNumber(), passengerFlowResultVo.getPageSize());
			List<PassengerFlowResult> list = passengerFlowResultService.getTodayPassengerFlow(passengerFlowResultVo);
			PageInfo<PassengerFlowResult> pageInfo = new PageInfo<PassengerFlowResult>(list);
			Map map = passengerFlowResultService.getTodayTotalOnOffPassengerFlow(passengerFlowResultVo);
			PersonDetailValue result = new PersonDetailValue();
			result.setPageInfo(pageInfo);
			if (map != null && map.get("totalOnPersonCount") != null) {
				result.setTotalOnPersonCount(new BigDecimal((Long) map.get("totalOnPersonCount")));
			} else {
				result.setTotalOnPersonCount(new BigDecimal("0"));
			}
			if (map != null && map.get("totalOffPersonCount") != null) {
				result.setTotalOffPersonCount(new BigDecimal((Long) map.get("totalOffPersonCount")));
			} else {
				result.setTotalOffPersonCount(new BigDecimal("0"));
			}
			return ResultUtil.getSuccessResult(result);
		} catch (Exception ex) {
			LOG.error("今天单车客流统计分页异常，原因：{}", ex);
			return ResultUtil.getErrorResult();
		}
	}

	/**
	 * 单车客流统计
	 * 
	 * @param passengerFlowResultVo
	 * @return
	 */
	@AccessLogInfo(modelName = "运营分析", pageName = "单车客流统计")
	@SuppressWarnings("rawtypes")
	@PostMapping("/pageBusPersonTotalList")
	public Result pageBusPersonTotalList(@RequestBody PassengerFlowResultVo passengerFlowResultVo) {
		// if (passengerFlowResultVo.getPageSize() == null) {
		// return ResultUtil.getErrorResult("没有分页参数！");
		// }
		try {
			// 分页数据请求处理
			// PageHelper.startPage(passengerFlowResultVo.getPageNumber(),
			// passengerFlowResultVo.getPageSize());
			List<Map> resultDatas = null;
			if ("1".equals(passengerFlowResultVo.getIsHistory())) {
				resultDatas = passengerFlowResultService.getBusKlStatisticalFromDb(passengerFlowResultVo);
			} else {
				resultDatas = passengerFlowResultService.getBusKlStatisticalFromES(passengerFlowResultVo, false);
			}

			for (Map map : resultDatas) {
				if ("1".equals(passengerFlowResultVo.getIsHistory())) {
					Long upCount = (Long) map.get("pfrGetOnNumber");
					Long downCount = (Long) map.get("pfrGetOffNumber");
					BigDecimal countcaleBig = new BigDecimal("100");
					if (upCount != 0) {
						countcaleBig = (new BigDecimal(upCount + "").subtract(new BigDecimal(downCount + "")))
								.divide(new BigDecimal(upCount + ""), 4, BigDecimal.ROUND_HALF_UP)
								.multiply(new BigDecimal("100"));
					}
					map.put("pfrpassengerDif", Float.toString(Math.abs(countcaleBig.floatValue())) + "%");
				} else {
					Integer upCount = (Integer) map.get("pfrGetOnNumber");
					Integer downCount = (Integer) map.get("pfrGetOffNumber");
					BigDecimal countcaleBig = new BigDecimal("100");
					if (upCount != 0) {
						countcaleBig = (new BigDecimal(upCount + "").subtract(new BigDecimal(downCount + "")))
								.divide(new BigDecimal(upCount + ""), 4, BigDecimal.ROUND_HALF_UP)
								.multiply(new BigDecimal("100"));
					}
					map.put("pfrpassengerDif", Float.toString(Math.abs(countcaleBig.floatValue())) + "%");
				}
			}

			// return ResultUtil.getSuccessResult(new
			// PageInfo<Map>(resultDatas));
			return ResultUtil.getSuccessResult(resultDatas);
		} catch (Exception ex) {
			LOG.error("历史单车客流统计分页异常，原因：{}", ex);
			return ResultUtil.getErrorResult();
		}
	}

	/**
	 * 导出单车客流明细
	 * 
	 * @param passengerFlowResultVo
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@PostMapping("/busTotalPerson/export")
	public Result busTotalPersonDetail(@RequestBody PassengerFlowResultVo passengerFlowResultVo) {
		String envPath = env.getProperty("spring.resources.static-locations");
		String srcFilePath = envPath.substring(envPath.indexOf(":") + 1) + "busPersonDataExportModel.xls";
		String fileName = String.format("busPersonData%s.xls",
				new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
		String tempFilePath = envPath.substring(envPath.indexOf(":") + 1) + "upload" + File.separator + fileName;
		List<Map> list = null;
		if ("1".equals(passengerFlowResultVo.getIsHistory())) {
			list = passengerFlowResultService.getBusKlStatisticalFromDb(passengerFlowResultVo);
		} else {
			list = passengerFlowResultService.getBusKlStatisticalFromES(passengerFlowResultVo, false);
		}
		if (list != null && list.size() == 0) {
			return ResultUtil.getErrorResult("没有导出记录！");
		}
		if (list != null && list.size() > 65536) {
			list = list.subList(0, 65535);
		}
		List<List<String>> data = new ArrayList<List<String>>();
		for (Map item : list) {
			List<String> row = new ArrayList<>();
			row.add((String) item.get("orgName"));
			row.add((String) item.get("pfrLineName"));
			row.add((String) item.get("prfBusPlateNumber"));
			row.add((String) item.get("busSelfCode"));
			row.add((String) item.get("prfDevCode"));
			row.add(item.get("pfrGetOnNumber") + "");
			row.add(item.get("pfrGetOffNumber") + "");
			if ("1".equals(passengerFlowResultVo.getIsHistory())) {
				Long upCount = (Long) item.get("pfrGetOnNumber");
				Long downCount = (Long) item.get("pfrGetOffNumber");
				BigDecimal countcaleBig = new BigDecimal("100");
				if (upCount != 0) {
					countcaleBig = (new BigDecimal(upCount + "").subtract(new BigDecimal(downCount + "")))
							.divide(new BigDecimal(upCount + ""), 4, BigDecimal.ROUND_HALF_UP)
							.multiply(new BigDecimal("100"));
				}
				row.add(Float.toString(Math.abs(countcaleBig.floatValue())) + "%");
			} else {
				Integer upCount = (Integer) item.get("pfrGetOnNumber");
				Integer downCount = (Integer) item.get("pfrGetOffNumber");
				BigDecimal countcaleBig = new BigDecimal("100");
				if (upCount != 0) {
					countcaleBig = (new BigDecimal(upCount + "").subtract(new BigDecimal(downCount + "")))
							.divide(new BigDecimal(upCount + ""), 4, BigDecimal.ROUND_HALF_UP)
							.multiply(new BigDecimal("100"));
				}
				row.add(Float.toString(Math.abs(countcaleBig.floatValue())) + "%");
			}
			data.add(row);
		}
		File tempFile = new File(tempFilePath);
		try {
			FileOperUtils.writeExcel(new File(srcFilePath), tempFile, 0, 1, data);
			JSONObject json = new JSONObject();
			json.put("url", webrooturl + "exceltemplate/upload/" + fileName);
			LOG.info("导出单车客流明细数据下载文件:{}", fileName);
			return ResultUtil.getSuccessResult(json);
		} catch (Exception ex) {
			LOG.error("导出单车客流明细数据失败！{}", ex);
			return ResultUtil.getErrorResult("导出单车客流明细数据失败！");
		}
	}

	/**
	 * 导出客流明细
	 * 
	 * @param passengerFlowResultVo
	 * @return
	 */
	@PostMapping("/detail/export")
	public Result exportDetail(@RequestBody PassengerFlowResultVo passengerFlowResultVo) {
		String envPath = env.getProperty("spring.resources.static-locations");
		String srcFilePath = envPath.substring(envPath.indexOf(":") + 1) + "personDataExportModel.xls";
		String fileName = String.format("personDetailData%s.xls",
				new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
		String tempFilePath = envPath.substring(envPath.indexOf(":") + 1) + "upload" + File.separator + fileName;
		List<PassengerFlowResult> list = null;
		try {
			if ("1".equals(passengerFlowResultVo.getIsHistory())) {
				list = passengerFlowResultService.getTodayPassengerFlow(passengerFlowResultVo);
			} else {
				list = passengerFlowResultService.getPassengerFlowFromESNoPageExport(passengerFlowResultVo);
			}
		} catch (Exception e) {
			LOG.error("从ES中获取导出客流明细异常，错误原因：{}", e);
		}
		if (list != null && list.size() == 0) {
			return ResultUtil.getErrorResult("没有导出记录！");
		}
		if (list != null && list.size() > 65536) {
			list = list.subList(0, 65535);
		}
		List<List<String>> data = new ArrayList<List<String>>();
		for (PassengerFlowResult item : list) {
			List<String> row = new ArrayList<>();
			row.add(item.getOrgName());
			row.add(item.getPfrLineName());
			row.add(item.getPrfBusPlateNumber());
			row.add(item.getPfrLineType() == 1 ? "上行" : "下行");
			row.add(item.getPfrStationSeq() + "");
			row.add(item.getPfrStationName());
			row.add(item.getPfrTripTime());
			row.add(DateUtils.formatDate(item.getPfrUploadTime(), "yyyy-MM-dd HH:mm:ss"));
			row.add(item.getPrfGetPersonCount() + "");
			row.add(item.getPfrGetOnNumber() + "");
			row.add(item.getPfrGetOffNumber() + "");
			row.add(item.getPrfGetFOnNumber() + "");
			row.add(item.getPrfGetFOffNumber() + "");
			row.add(item.getPrfGetEOnNumber() + "");
			row.add(item.getPrfGetEOffNumber() + "");
			data.add(row);
		}
		File tempFile = new File(tempFilePath);
		try {
			FileOperUtils.writeExcel(new File(srcFilePath), tempFile, 0, 1, data);
			JSONObject json = new JSONObject();
			json.put("url", webrooturl + "exceltemplate/upload/" + fileName);
			LOG.info("导出客流明细数据下载文件:{}", fileName);
			return ResultUtil.getSuccessResult(json);
		} catch (Exception ex) {
			LOG.error("导出客流明细数据失败！{}", ex);
			return ResultUtil.getErrorResult("导出客流明细数据失败！");
		}
	}

	@AccessLogInfo(modelName = "运营分析", pageName = "客流数据查询")
	@PostMapping("/getOnOffPersonCountlist")
	public Result getOnOffPersonCountlist(@RequestBody PassengerFlowResultVo passengerFlowResultVo) {
		String startTime = passengerFlowResultVo.getStartDate() + " 00:00:00";
		String endTime = passengerFlowResultVo.getEndDate() + " 23:59:59";
		passengerFlowResultVo.setStartTime(DateUtils.parseDateTime(startTime));
		passengerFlowResultVo.setEndTime(DateUtils.parseDateTime(endTime));
		try {
			List<OnOffPsersonNumberValue> result = null;
			List<String> lineIds = passengerFlowResultVo.getLineIds();
			if (lineIds != null && lineIds.size() > 0) {
				result = passengerFlowResultService.getOnOffPersonCount(passengerFlowResultVo);
			} else {
				if (PMSUtils.isNotEmpty(passengerFlowResultVo.getOrgId())) {
					result = passengerFlowResultService.getOnOffPersonCountByCompany(passengerFlowResultVo);
				} else {// 总公司合并
					List<OnOffPsersonNumberValue> temp = passengerFlowResultService
							.getOnOffPersonCountByCompany(passengerFlowResultVo);
					BaseSysParamInfoVo baseSysParamInfoVo = new BaseSysParamInfoVo();
					baseSysParamInfoVo.setParamName("showPersonCountOrgName");
					baseSysParamInfoVo.setParamIsvalid("1");
					List<BaseSysParamInfo> sysConfig = baseSysParamInfoService
							.getBaseSysParamInfoByExample(baseSysParamInfoVo);
					String orgName = "总公司";
					if (sysConfig != null && sysConfig.size() > 0) {
						String value = sysConfig.get(0).getParamValue();
						if (PMSUtils.isNotEmpty(value)) {
							orgName = value;
						}
					}
					result = staticSum(temp, orgName);
				}
			}
			return ResultUtil.getSuccessResult(result);
		} catch (Exception ex) {
			LOG.error("统计历史客流上下车人数异常，原因：{}", ex);
			return ResultUtil.getErrorResult();
		}
	}

	@AccessLogInfo(modelName = "运营分析", pageName = "客流数据查询")
	@PostMapping("/getTodayOnOffPersonCountlist")
	public Result getTodayOnOffPersonCountlist(@RequestBody PassengerFlowResultVo passengerFlowResultVo) {
		String startTime = passengerFlowResultVo.getStartDate() + " 00:00:00";
		String endTime = passengerFlowResultVo.getEndDate() + " 23:59:59";
		passengerFlowResultVo.setStartTime(DateUtils.parseDateTime(startTime));
		passengerFlowResultVo.setEndTime(DateUtils.parseDateTime(endTime));
		try {
			List<OnOffPsersonNumberValue> result = null;
			List<String> lineIds = passengerFlowResultVo.getLineIds();
			if (lineIds != null && lineIds.size() > 0) {
				result = passengerFlowResultService.getTodayOnOffPersonCount(passengerFlowResultVo);
			} else {
				if (PMSUtils.isNotEmpty(passengerFlowResultVo.getOrgId())) {
					result = passengerFlowResultService.getTodayOnOffPersonCountByCompany(passengerFlowResultVo);
				} else {// 总公司合并
					List<OnOffPsersonNumberValue> temp = passengerFlowResultService
							.getTodayOnOffPersonCountByCompany(passengerFlowResultVo);
					BaseSysParamInfoVo baseSysParamInfoVo = new BaseSysParamInfoVo();
					baseSysParamInfoVo.setParamName("showPersonCountOrgName");
					baseSysParamInfoVo.setParamIsvalid("1");
					List<BaseSysParamInfo> sysConfig = baseSysParamInfoService
							.getBaseSysParamInfoByExample(baseSysParamInfoVo);
					String orgName = "总公司";
					if (sysConfig != null && sysConfig.size() > 0) {
						String value = sysConfig.get(0).getParamValue();
						if (PMSUtils.isNotEmpty(value)) {
							orgName = value;
						}
					}
					result = staticSum(temp, orgName);
				}
			}
			return ResultUtil.getSuccessResult(result);
		} catch (Exception ex) {
			LOG.error("统计今天客流上下车人数异常，原因：{}", ex);
			return ResultUtil.getErrorResult();
		}
	}

	/**
	 * 按日期分类求和
	 * 
	 * @param temp
	 * @return
	 */
	private List<OnOffPsersonNumberValue> staticSum(List<OnOffPsersonNumberValue> temp, String orgName) {
		Map<String, List<OnOffPsersonNumberValue>> map = new TreeMap<String, List<OnOffPsersonNumberValue>>();
		List<OnOffPsersonNumberValue> resultList = new ArrayList<>();
		if (temp != null && temp.size() > 0) {
			for (OnOffPsersonNumberValue bean : temp) {
				String key = bean.getUploadTime();
				if (map.containsKey(key)) {
					map.get(key).add(bean);
				} else {
					List<OnOffPsersonNumberValue> tlist = new ArrayList<>();
					tlist.add(bean);
					map.put(key, tlist);
				}
			}
			for (String tempKey : map.keySet()) {
				BigDecimal totalOnPersonCount = new BigDecimal("0");
				BigDecimal totalOffPersonCount = new BigDecimal("0");
				List<OnOffPsersonNumberValue> subList = map.get(tempKey);
				for (OnOffPsersonNumberValue item : subList) {
					totalOnPersonCount = totalOnPersonCount.add(new BigDecimal(item.getOnPersonCount()));
					totalOffPersonCount = totalOffPersonCount.add(new BigDecimal(item.getOffPersonCount()));
				}
				OnOffPsersonNumberValue entity = new OnOffPsersonNumberValue();
				entity.setOrgName(orgName);
				entity.setUploadTime(tempKey);
				entity.setOnPersonCount(totalOnPersonCount.toString());
				entity.setOffPersonCount(totalOffPersonCount.toString());
				resultList.add(entity);
			}
		}
		return resultList;
	}

	/**
	 * 导出客流上下车人数
	 * 
	 * @param passengerFlowResultVo
	 * @return
	 */
	@PostMapping("/export")
	public Result export(@RequestBody Map<String, String> paramMap) {
		String envPath = env.getProperty("spring.resources.static-locations");
		String srcFilePath = envPath.substring(envPath.indexOf(":") + 1) + "onOffPersonStatitcModel.xls";
		String fileName = String.format("onOffPersonData%s.xls",
				new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
		String tempFilePath = envPath.substring(envPath.indexOf(":") + 1) + "upload" + File.separator + fileName;

		String datas = paramMap.get("data");
		if (PMSUtils.isEmpty(datas)) {
			return ResultUtil.getErrorResult("没有导出记录！");
		}
		List<OnOffPsersonNumberValue> list = JSON.parseArray(datas, OnOffPsersonNumberValue.class);
		if (list != null && list.size() > 65536) {
			list = list.subList(0, 65535);
		}
		List<List<String>> data = new ArrayList<List<String>>();
		// 求客流等降量总计变量
		Integer totalOnPersonCount = 0;
		Integer totalOffPersonCount = 0;
		for (OnOffPsersonNumberValue item : list) {
			if ("合计".equals(item.getOrgName())) {
				totalOnPersonCount += Integer.parseInt(item.getOnPersonCount());
				totalOffPersonCount += Integer.parseInt(item.getOffPersonCount());
			}
			List<String> row = new ArrayList<>();
			row.add(item.getOrgName());
			row.add(item.getLineName());
			row.add(item.getUploadTime());
			row.add(item.getOnPersonCount());
			row.add(item.getOffPersonCount());
			data.add(row);
		}
		// 添加总计行
		List<String> totalRow = new ArrayList<>();
		totalRow.add("总计");
		totalRow.add("——");
		totalRow.add("——");
		totalRow.add(totalOnPersonCount + "");
		totalRow.add(totalOffPersonCount + "");
		data.add(totalRow);

		File tempFile = new File(tempFilePath);
		try {
			FileOperUtils.writeExcel(new File(srcFilePath), tempFile, 0, 1, data);
			JSONObject json = new JSONObject();
			json.put("url", webrooturl + "exceltemplate/upload/" + fileName);
			LOG.info("导出客流上下车人数下载文件:{}", fileName);
			return ResultUtil.getSuccessResult(json);
		} catch (Exception ex) {
			LOG.error("导出客流上下车人数数据失败！{}", ex);
			return ResultUtil.getErrorResult("导出客流上下车人数数据失败！");
		}
	}

}
