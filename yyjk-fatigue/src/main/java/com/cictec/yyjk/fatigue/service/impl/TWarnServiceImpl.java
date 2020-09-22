package com.cictec.yyjk.fatigue.service.impl;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.elasticsearch.client.Client;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cictec.yyjk.base.mapper.BusLineMapper;
import com.cictec.yyjk.base.mapper.BusMapper;
import com.cictec.yyjk.base.mapper.BusSysOrgMapper;
import com.cictec.yyjk.base.model.entity.Bus;
import com.cictec.yyjk.base.model.entity.BusLine;
import com.cictec.yyjk.base.model.entity.BusSysOrg;
import com.cictec.yyjk.base.model.vo.BusLineVo;
import com.cictec.yyjk.base.model.vo.TreeNode2;
import com.cictec.yyjk.base.utils.TreeUtils;
import com.cictec.yyjk.commons.core.AbstractService;
import com.cictec.yyjk.commons.utils.DateUtils;
import com.cictec.yyjk.commons.utils.PMSUtils;
import com.cictec.yyjk.commons.utils.RestUtils;
import com.cictec.yyjk.commons.utils.ShowDateTypes;
import com.cictec.yyjk.commons.utils.StringUtils;
import com.cictec.yyjk.commons.utils.TimerUtils;
import com.cictec.yyjk.commons.utils.gps.Gps;
import com.cictec.yyjk.commons.utils.gps.GpsSwitchUtils;
import com.cictec.yyjk.fatigue.common.base.BaseTreeNode;
import com.cictec.yyjk.fatigue.mapper.TWarnMapper;
import com.cictec.yyjk.fatigue.mapper.TWarnMediaMapper;
import com.cictec.yyjk.fatigue.model.entity.DwDimBusDriver;
import com.cictec.yyjk.fatigue.model.entity.TWarn;
import com.cictec.yyjk.fatigue.model.entity.TWarnMedia;
import com.cictec.yyjk.fatigue.model.entity.TempBusOverWarnTrail;
import com.cictec.yyjk.fatigue.model.view.CanDataValue;
import com.cictec.yyjk.fatigue.model.vo.QueryCondition;
import com.cictec.yyjk.fatigue.model.vo.TDeviceVo;
import com.cictec.yyjk.fatigue.model.vo.TWarnVo;
import com.cictec.yyjk.fatigue.model.vo.TWarnsAnalysisDto;
import com.cictec.yyjk.fatigue.service.DwDimBusDriverService;
import com.cictec.yyjk.fatigue.service.TDeviceService;
import com.cictec.yyjk.fatigue.service.TWarnService;
import com.cictec.yyjk.fatigue.service.TempBusOverWarnTrailService;
import com.cictec.yyjk.fatigue.utils.RunShell;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

/**
 * Created by Rwq on 2019/05/22.
 */
@Service
@Transactional
public class TWarnServiceImpl extends AbstractService<TWarn> implements TWarnService {
	private final Logger logger = LoggerFactory.getLogger(TWarnServiceImpl.class);

	@Resource(name = "client")
	private Client client;
	@Resource
	private TWarnMapper tWarnMapper;

	@Resource
	private TWarnMediaMapper tWarnMediaMapper; // 报警媒体dao

	@Resource
	private BusSysOrgMapper busSysOrgMapper;// 组织结构dao

	@Resource
	private BusLineMapper busLineMapper;// 线路dao

	@Resource
	private BusMapper busMapper;// 车辆dao

	@Autowired
	private TempBusOverWarnTrailService tempBusOverWarnTrailService;

	@Autowired
	private TDeviceService tDeviceService;

	@Value("${linux.file.shellDir}")
	private String shellDirPath; // ffmpeg 脚本路径

	@Autowired
	private Environment env;
	@Autowired
	private DwDimBusDriverService dwDimBusDriverService;

	@Override
	public List<TWarn> selectWarnPlatfromPage(TWarnVo vo) {
		return tWarnMapper.selectWarnInfo(vo);
	}

	/**
	 * 获取报警信息
	 * 
	 * @return
	 */
	@Override
	public List<TWarn> getWarnInfo() {
		return tWarnMapper.getWarnInfo();
	}

	@Override
	public TWarn warnInfoDetailGet(TWarnVo vo) {
		TWarn warn = tWarnMapper.warnInfoDetailGet(vo);
		String warnType = warn.getWarnType();
		if ("OVERSPEED".equals(warnType)) {// 处理超速报警：（1）计算超速持续时间(2)获取can数据(3)获取超速轨迹信息
			overSpeedInfoHandle(warn);
		} else {
			// gps坐标转换
			String lngStr = warn.getLng();
			String latStr = warn.getLat();
			if (StringUtils.isNotEmpty(lngStr) && StringUtils.isNotEmpty(latStr)) {
				Gps gps = GpsSwitchUtils.wgs84tobd09(Double.valueOf(lngStr), Double.valueOf(latStr));
				warn.setLng(gps.getWgLon() + "");
				warn.setLat(gps.getWgLat() + "");
			}
			// 处理非超速报警：(1)获取媒体信息
			setWarnMediaInfo(warn);
		}
		// 设置抓拍图片
		// setWarnFignInfo(warn);
		return warn;
	}

	@Override
	public Date getWarnTimeByUuid(String warnUuid) {
		Date warnTime = tWarnMapper.getWarnTimeByUuid(warnUuid);
		return warnTime;
	}

	private TWarn overSpeedInfoHandle(TWarn tWarn) {
		// 增加计算报警时长
		String duration = "0";
		if (tWarn.getWarnStartTime() != null && tWarn.getWarnEndTime() != null) {
			duration = TimerUtils.dateDiffString(tWarn.getWarnStartTime().getTime(), tWarn.getWarnEndTime().getTime(),
					ShowDateTypes.SEC);
		}
		tWarn.setDuration(duration);

		// 根据超速报警主键获取超速报警轨迹
		TempBusOverWarnTrail tempBusOverWarnTrailTemp = new TempBusOverWarnTrail();
		tempBusOverWarnTrailTemp.setFkWarnUuid(tWarn.getWarnUuid());
		List<TempBusOverWarnTrail> trails = tempBusOverWarnTrailService.select(tempBusOverWarnTrailTemp);

		List<CanDataValue> canDatas = new ArrayList<>();
		for (TempBusOverWarnTrail bean : trails) {
			int speed = StringUtils.isEmpty(bean.getSpeed()) ? 0 : Integer.parseInt(bean.getSpeed());
			canDatas.add(new CanDataValue(speed, bean.getWarnTime()));
		}
		// 设置CNA数据
		tWarn.setCanDatas(canDatas);

		List<TempBusOverWarnTrail> overSpeedWarnTrails = trails.subList(6, trails.size() - 6);
		// GPS转换
		if (CollectionUtils.isNotEmpty(overSpeedWarnTrails)) {

			for (TempBusOverWarnTrail bean : overSpeedWarnTrails) {
				String lngStr = bean.getLng();
				String latStr = bean.getLat();
				if (StringUtils.isNotEmpty(lngStr) && StringUtils.isNotEmpty(latStr)) {
					Gps gps = GpsSwitchUtils.wgs84tobd09(Double.valueOf(lngStr), Double.valueOf(latStr));
					bean.setLng(gps.getWgLon() + "");
					bean.setLat(gps.getWgLat() + "");
				}
			}
			// 设置超速报警轨迹
			tWarn.setWarnTrails(overSpeedWarnTrails);
		}

		List<CanDataValue> srcList = new ArrayList<>(canDatas.subList(6, canDatas.size() - 6));
		// 计算最高报警速度
		Collections.sort(srcList, new Comparator<CanDataValue>() {
			@Override
			public int compare(CanDataValue arg0, CanDataValue arg1) {
				return arg1.getSpeed() - arg0.getSpeed();
			}
		});
		// 设置最高报警速度
		tWarn.setSpeed(srcList.get(0).getSpeed() + "");
		return tWarn;
	}

	private void setWarnMediaInfo(TWarn warn) {
		List<Map<String, Object>> picList = new ArrayList<Map<String, Object>>();
		List<Map<String, Object>> medList = new ArrayList<Map<String, Object>>();
		List<TWarnMedia> medisList = tWarnMediaMapper.warnMediaList(warn.getWarnUuid());
		if (null != medisList && medisList.size() > 0) {
			for (TWarnMedia temp : medisList) {
				int type = temp.getMediaType();
				if (type == 0) {// 图片
					Map<String, Object> map = new HashMap<String, Object>();
					String url = StringUtils.isNotEmpty(temp.getDownloadUrl()) ? temp.getDownloadUrl() : "";
					String prefix = url.substring(url.lastIndexOf(".") + 1);
					map.put("url", url);
					map.put("mediaEncoding", prefix);
					picList.add(map);
				} else if (type == 2) { // 视频
					Map<String, Object> map = new HashMap<String, Object>();
					String url = StringUtils.isNotEmpty(temp.getDownloadUrl()) ? temp.getDownloadUrl() : "";
					String prefix = url.substring(url.lastIndexOf(".") + 1);
					// h264视频处理，转码MP4，更新数据库
					if (prefix.toLowerCase().equals("h264")) {
						// 得到文件真实保存路径
						String savePath = StringUtils.isNotEmpty(temp.getSavePath()) ? temp.getSavePath() : "";
						String coverPath = coverPathToMp4(savePath);
						int k = RunShell.runShell(shellDirPath, savePath, coverPath);
						logger.info("H264视频转换MP4地址{},线程终止{} ", coverPath, k);
						if (k >= 0) {
							url = coverPathToMp4(url);
							prefix = "mp4";
							TWarnMedia param = new TWarnMedia();
							param.setMediaUuid(temp.getMediaUuid());
							param.setDownloadUrl(url);
							param.setMediaEncoding(prefix);
							tWarnMediaMapper.updateByPrimaryKeySelective(param);
						}
					}
					map.put("url", url);
					map.put("mediaEncoding", prefix);
					medList.add(map);
				}
			}

			if (picList.size() > 0) {
				warn.setWarnPicList(picList.toArray());
			}

			if (medList.size() > 0) {
				warn.setWarnMediaList(medList.toArray());
			}

			// //设置抓拍
			// String devCode=warn.getDevCode();
			// List<TWarn> mapWarn=this.getWarnFigndetail(devCode);
			// List<Map<String,Object>> pic=new ArrayList<>();
			// for(TWarn twarn:mapWarn){
			// Map<String, Object> map = new HashMap<String, Object>();
			// String url = StringUtils.isNotEmpty(twarn.getMediaUrl()) ?
			// twarn.getMediaUrl() : "";
			// String prefix = url.substring(url.lastIndexOf(".") + 1);
			// map.put("url", url);
			// map.put("mediaEncoding", prefix);
			// picList.add(map);
			//
			// }
			// warn.setPigePicList(picList.toArray());
		}
	}

	private void setWarnFignInfo(TWarn warn) {
		List<Map<String, Object>> picList = new ArrayList<Map<String, Object>>();
		// 设置抓拍

		String devCode = warn.getDevCode();
		Date date = warn.getWarnTime();
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = formatter.format(date);
		Timestamp alarmStartTime = Timestamp.valueOf(dateString);
		List<TWarn> mapWarn = this.getWarnFigndetail(devCode, alarmStartTime);
		List<Map<String, Object>> pic = new ArrayList<>();
		for (TWarn twarn : mapWarn) {
			Map<String, Object> map = new HashMap<String, Object>();
			String url = StringUtils.isNotEmpty(twarn.getMediaUrl()) ? twarn.getMediaUrl() : "";
			String prefix = url.substring(url.lastIndexOf(".") + 1);
			map.put("url", url);
			map.put("mediaEncoding", prefix);
			picList.add(map);

		}
		warn.setPigePicList(picList.toArray());
	}

	@Override
	public Object listPiplePic(Map mapparam) {
		List<Map<String, Object>> picList = new ArrayList<Map<String, Object>>();
		// 设置抓拍
		String devCode = String.valueOf((mapparam.get("devCode")));
		String dateString = String.valueOf((mapparam.get("warnTime")));
		Timestamp alarmStartTime = Timestamp.valueOf(dateString);
		List<TWarn> mapWarn = this.getWarnFigndetail(devCode, alarmStartTime);
		// 如果查不到则把时间往前推迟10秒
		if (mapWarn.size() <= 0) {
			logger.info("没有查到图片则往前在推20秒，再查一下");
			Long start = alarmStartTime.getTime() - 20000;
			Timestamp ts = new Timestamp(start);// 2018-08-25 09:37:09
			mapWarn = this.getWarnFigndetail(devCode, ts);
		}
		List<Map<String, Object>> pic = new ArrayList<>();
		for (TWarn twarn : mapWarn) {
			Map<String, Object> map = new HashMap<String, Object>();
			String url = StringUtils.isNotEmpty(twarn.getMediaUrl()) ? twarn.getMediaUrl() : "";
			String prefix = url.substring(url.lastIndexOf(".") + 1);
			map.put("url", url);
			map.put("mediaEncoding", prefix);
			map.put("warnType", twarn.getWarnType());
			picList.add(map);

		}
		return picList.toArray();
	}

	private List<Map<String, Object>> setWarnFignInfo(String devCode, Timestamp dateTime) {
		List<Map<String, Object>> picList = new ArrayList<Map<String, Object>>();
		// 设置抓拍
		List<TWarn> mapWarn = this.getWarnFigndetail(devCode, dateTime);
		List<Map<String, Object>> pic = new ArrayList<>();
		for (TWarn twarn : mapWarn) {
			Map<String, Object> map = new HashMap<String, Object>();
			String url = StringUtils.isNotEmpty(twarn.getMediaUrl()) ? twarn.getMediaUrl() : "";
			String prefix = url.substring(url.lastIndexOf(".") + 1);
			map.put("url", url);
			map.put("mediaEncoding", prefix);
			picList.add(map);

		}
		return picList;
	}

	private String coverPathToMp4(String oldPath) {
		if (StringUtils.isEmpty(oldPath)) {
			return "";
		}
		String newPath = "";
		if (oldPath.toLowerCase().endsWith("h264")) {
			oldPath = StringUtils.removeEndIgnoreCase(oldPath, "h264");
			newPath = oldPath + "mp4";
		}
		return newPath;
	}

	@Override
	public List<TreeNode2> orgLineBusTreeGet(TWarnVo param) {
		BusSysOrg vo = new BusSysOrg();
		vo.setOrgUuid(param.getOrgId());
		vo.setOrgDropFlag("0");
		// vo.setOrgType(1);
		List<BusSysOrg> list = busSysOrgMapper.selectTBusSysOrgList(vo);
		if (list != null && list.size() > 0) {
			List<TreeNode2> trees = TreeUtils.buildTree2(list);
			for (TreeNode2 node : trees) {
				if (node.getpId() == null) {// 总公司
					node.setLevelsType("0");
					node.setOpen(true);
				}
				// getAllChilrens(node);
				if (node.getChildren().size() > 0) {
					Set<TreeNode2> childs = node.getChildren();
					for (TreeNode2 child : childs) {
						addLineAndBusNodes(child);
					}
				} else {
					addLineAndBusNodes(node);
				}
			}
			return trees;
		}
		return Collections.emptyList();
	}

	public void getAllChilrens(TreeNode2 node) {
		Set<TreeNode2> childs = node.getChildren();
		if (childs.size() == 0) {
			addLineAndBusNodes(node);
		} else {
			for (TreeNode2 child : childs) {
				addLineAndBusNodes(child);
				getAllChilrens(child);
			}
		}
	}

	private void addLineAndBusNodes(TreeNode2 node) {
		// 分公司
		node.setLevelsType("1");
		node.setOpen(false);
		Example example = new Example(BusLine.class);
		Criteria criteria = example.createCriteria();
		criteria.andEqualTo("lineOrgUuid", node.getId());
		criteria.andEqualTo("lineIsvalid", "1");
		criteria.andEqualTo("lineDropFlag", "0");
		List<BusLine> lineList = busLineMapper.selectByExample(example);
		if (lineList != null && lineList.size() > 0) {
			for (BusLine line : lineList) {
				TreeNode2 lineNode = new TreeNode2();
				lineNode.setId(line.getLineUuid());
				lineNode.setName(line.getLineName());
				lineNode.setpId(node.getId());
				lineNode.setOpen(false);
				lineNode.setLevelsType("2");
				node.addChild(lineNode);
				// 查询线路下的车辆
				Example busExample = new Example(Bus.class);
				Criteria busCriteria = busExample.createCriteria();
				busCriteria.andEqualTo("busLineUuid", line.getLineUuid());
				busCriteria.andEqualTo("busIsvalid", "1");
				busCriteria.andEqualTo("busDropFlag", "0");
				List<Bus> busList = busMapper.selectByExample(busExample);
				if (busList != null && busList.size() > 0) {
					for (Bus bus : busList) {
						TreeNode2 busNode = new TreeNode2();
						busNode.setId(bus.getBusUuid());
						busNode.setName(bus.getBusPlateNumber());
						busNode.setpId(line.getLineUuid());
						busNode.setOpen(false);
						busNode.setLevelsType("3");
						lineNode.addChild(busNode);
					}
				}
			}
		}
	}

	@Override
	public List<BaseTreeNode> orgLineBusTreeGet2(TWarnVo param1) {
		List<BaseTreeNode> basetree = new ArrayList<BaseTreeNode>();
		// int flag = 0;
		int flags = 0;
		BusSysOrg vo = new BusSysOrg();
		// vo.setOrgSql(param.getOrgId());
		vo.setOrgDropFlag("0");
		vo.setOrgType(1);
		List<BusSysOrg> list = busSysOrgMapper.selectTBusSysOrgList(vo);
		// List<BusSysOrg> orgList=new ArrayList<BusSysOrg>();
		if (list != null && list.size() > 0) {
			List<BusLineVo> lineList = busLineMapper.getAllBusLines();
			BaseTreeNode besat;
			for (BusSysOrg sorg : list) {
				// 排序线路上的机构信息
				besat = new BaseTreeNode();
				besat.setId(sorg.getOrgUuid());
				besat.setName(sorg.getOrgName());
				besat.setpId(sorg.getOrgParentUuid());
				String orgParentUuid = sorg.getOrgParentUuid();
				if (orgParentUuid != null && !"".equals(orgParentUuid)) {// 不是总公司
					besat.setLevelsType("1");
				} else {// 是总公司
					besat.setLevelsType("0");
				}
				BaseTreeNode lineBesat = new BaseTreeNode();
				if (lineList != null && lineList.size() > 0) {
					for (int i = 0; i < lineList.size(); i++) {
						BusLineVo line = lineList.get(i);
						if (line.getOrgId().equals(sorg.getOrgUuid())) {
							lineBesat = new BaseTreeNode();
							lineBesat.setId(line.getLineId());
							lineBesat.setName(line.getLineName());
							lineBesat.setpId(sorg.getOrgUuid());
							lineBesat.setLevelsType("2");
							basetree.add(lineBesat);
							// 查询线路下的车辆
							List<Bus> tBusDtoList = new ArrayList<Bus>();
							Example example = new Example(Bus.class);
							Criteria criteria = example.createCriteria();
							if (PMSUtils.isNotEmpty(line.getLineId())) {
								criteria.andEqualTo("busLineUuid", line.getLineId());
							}
							criteria.andEqualTo("busIsvalid", "1");
							criteria.andEqualTo("busDropFlag", "0");
							tBusDtoList = busMapper.selectByExample(example);
							if (tBusDtoList != null && tBusDtoList.size() > 0) {
								BaseTreeNode busBesat;
								for (int m = 0; m < tBusDtoList.size(); m++) {
									Bus busTmp = tBusDtoList.get(m);
									busBesat = new BaseTreeNode();
									busBesat.setId(busTmp.getBusUuid());
									busBesat.setName(busTmp.getBusPlateNumber());
									busBesat.setpId(line.getLineId());
									busBesat.setLevelsType("3");
									basetree.add(busBesat);
								}
							}
						}
					}
				}
				besat.setOpen(flags == 0 ? true : false);
				basetree.add(besat);
				flags++;
			}
		}
		// System.out.println(JSONObject.toJSONString(basetree,
		// SerializerFeature.WriteNullStringAsEmpty));
		return basetree;
	}

	/**
	 * 车辆监控查询树结构
	 */
	@Override
	public Map orgLineBusTreeGet3(QueryCondition queryCondition) {
		// List<BaseTreeNode> list
		TDeviceVo tDevicetotal = new TDeviceVo();
		Map<String, String> mapTotalStatus = tDeviceService.countDeviceStatus(tDevicetotal);
		Map<String, Object> busPosition = new HashMap<>();
		// queryCondition.setOrgId("599198124510150656");
		String httpUrl = env.getProperty("gjdd.http.url") + "/getBusPosition";
		String result = RestUtils.getPostData(httpUrl, queryCondition.toString(), false);
		JSONArray arrys = null;

		List<DwDimBusDriver> drvInfo = dwDimBusDriverService.selectAllBusDriverInfo();
		// 全部司机信息
		Map<String, String> drvMap = new HashMap<>();
		for (DwDimBusDriver bean : drvInfo) {
			drvMap.put(bean.getDrvIcCard(), bean.getDrvEmployeeId());
		}

		int n = 0;
		int k = 0;
		if (PMSUtils.isNotEmpty(result)) {
			arrys = JSON.parseArray(result);
			for (int i = 0; i < arrys.size(); i++) {
				// 查询车辆的当前客流和当前趟次
				JSONObject model = (JSONObject) arrys.get(i);
				String busNumber = model.getString("busNumber");
				String currenttrip = model.getString("currenttrip");
				Integer totalPerson = this.getTotalPerson(busNumber, null) == null ? 0
						: this.getTotalPerson(busNumber, null);
				Integer currentPerson = this.getCurrentPerson(busNumber, null, currenttrip) == null ? 0
						: this.getCurrentPerson(busNumber, null, currenttrip);
				model.put("totalPerson", totalPerson);
				model.put("currentPerson", currentPerson);
				// 重新给司机工号赋值
				model.put("drvIccard", drvMap.get(model.getString("drvIccard")));
				busPosition.put(model.getString("busNumber"), model);
			}
			logger.info("在线车辆数：" + arrys.size());
		}
		List<Map> busStatus = this.selectDevstatus();
		Map<String, Object> status = new HashMap<String, Object>();
		Map<String, Object> busUuidtorefId = new HashMap<String, Object>();
		Map<String, Object> busUuidtdevUuid = new HashMap<String, Object>();
		Map<String, Object> busUuidtdevCode = new HashMap<String, Object>();
		for (Map a : busStatus) {
			status.put(String.valueOf(a.get("busuuid")), a.get("devstatus"));
			busUuidtorefId.put(String.valueOf(a.get("busuuid")), a.get("devrefid"));
			busUuidtdevUuid.put(String.valueOf(a.get("busuuid")), a.get("devuuid"));
			busUuidtdevCode.put(String.valueOf(a.get("busuuid")), a.get("devcode"));
		}

		Map map = new HashMap<>();
		List<BaseTreeNode> basetree = new ArrayList<BaseTreeNode>();
		int flags = 0;
		BusSysOrg vo = new BusSysOrg();
		vo.setOrgDropFlag("0");
		vo.setOrgType(1);
		vo.setOrgUuid(queryCondition.getOrgId());
		List<BusSysOrg> list = busSysOrgMapper.selectTBusSysOrgList(vo);

		if (list != null && list.size() > 0) {
			List<BusLineVo> lineList = busLineMapper.getAllBusLines();

			for (BusSysOrg sorg : list) {

				BaseTreeNode besat = new BaseTreeNode();
				TDeviceVo tDevice = new TDeviceVo();
				// tDevice.setLineId(vo.getLineId());
				tDevice.setOrgId(sorg.getOrgUuid());
				Map<String, String> mapStatus = tDeviceService.countDeviceStatus(tDevice);
				besat = new BaseTreeNode();
				besat.setId(sorg.getOrgUuid());
				besat.setName(sorg.getOrgName());
				besat.setpId(sorg.getOrgParentUuid());
				String orgParentUuid = sorg.getOrgParentUuid();
				if (orgParentUuid != null && !"".equals(orgParentUuid)) {// 不是总公司
					besat.setLevelsType("1");
				} else {// 是总公司
					besat.setLevelsType("0");
				}
				BaseTreeNode lineBesat = new BaseTreeNode();
				if (lineList != null && lineList.size() > 0) {
					for (int i = 0; i < lineList.size(); i++) {
						BusLineVo line = lineList.get(i);
						TDeviceVo tDeviceLine = new TDeviceVo();
						tDevice.setLineId(line.getLineId());
						Map<String, String> mapStatusLine = tDeviceService.countDeviceStatus(tDeviceLine);

						if (line.getOrgId().equals(sorg.getOrgUuid())) {
							lineBesat = new BaseTreeNode();
							lineBesat.setId(line.getLineId());
							lineBesat.setName(line.getLineName());
							lineBesat.setpId(sorg.getOrgUuid());
							lineBesat.setLevelsType("2");
							lineBesat.setOnLines(
									Integer.parseInt(String.valueOf(mapStatusLine.get("onlineDeviceCount"))));
							lineBesat.setUnLines(Integer.parseInt(String.valueOf(mapStatusLine.get("deviceCount"))));
							basetree.add(lineBesat);
							// 查询线路下的车辆
							List<Bus> tBusDtoList = new ArrayList<Bus>();
							Example example = new Example(Bus.class);
							Criteria criteria = example.createCriteria();
							if (PMSUtils.isNotEmpty(line.getLineId())) {
								criteria.andEqualTo("busLineUuid", line.getLineId());
							}
							criteria.andEqualTo("busIsvalid", "1");
							criteria.andEqualTo("busDropFlag", "0");
							tBusDtoList = busMapper.selectByExample(example);

							if (tBusDtoList != null && tBusDtoList.size() > 0) {
								BaseTreeNode busBesat;
								for (int m = 0; m < tBusDtoList.size(); m++) {

									Bus busTmp = tBusDtoList.get(m);
									busBesat = new BaseTreeNode();
									busBesat.setId(busTmp.getBusUuid());
									busBesat.setName(busTmp.getBusPlateNumber());
									busBesat.setpId(line.getLineId());
									busBesat.setLevelsType("3");
									busBesat.setBusFuelType(busTmp.getBusFuelType());
									busBesat.setBusLoadNumber(busTmp.getBusLoadNumber());
									busPosition.get(busTmp.getBusLoadNumber());
									busBesat.setBusState(String.valueOf(status.get(busTmp.getBusUuid())) == "null" ? "0"
											: String.valueOf(status.get(busTmp.getBusUuid())));
									busBesat.setBusStatus(
											busPosition.get(busTmp.getBusPlateNumber()) != null ? "1" : "0");
									if ("1".equals(busBesat.getBusStatus())) {
										n++;
									}
									k++;
									busBesat.setOrgName(sorg.getOrgName());
									busBesat.setLineName(line.getLineName());
									busBesat.setDevRefId(String.valueOf(busUuidtorefId.get(busTmp.getBusUuid())));
									busBesat.setDevUuid(String.valueOf(busUuidtdevUuid.get(busTmp.getBusUuid())));
									busBesat.setDevCode(String.valueOf(busUuidtdevCode.get(busTmp.getBusUuid())));
									List<Map<String, Object>> picList = this.setWarnFignInfo(
											String.valueOf(busUuidtdevUuid.get(busTmp.getBusUuid())), null);
									busBesat.setPigePicList(picList.toArray());
									JSONObject busPositionObject = (JSONObject) busPosition
											.get(busTmp.getBusPlateNumber());
									busBesat.setBusPosition(busPositionObject);
									basetree.add(busBesat);

								}
							}
						}
					}
				}
				besat.setOpen(flags == 0 ? true : false);
				basetree.add(besat);
				flags++;
			}
		}
		mapTotalStatus.remove("deviceCount");
		mapTotalStatus.remove("onlineDeviceCount");
		mapTotalStatus.put("onlineDeviceCount", String.valueOf(n));
		mapTotalStatus.put("deviceCount", String.valueOf(k));
		map.put("list", basetree);
		map.put("onlines", mapTotalStatus);
		return map;
	}

	@Override
	public List<TWarnsAnalysisDto> getWarnLevelPie(TWarnVo vo) {
		return tWarnMapper.getWarnLevelPie(vo);
	}

	@Override
	public List<TWarnsAnalysisDto> getWarnLevelNumToBusPage(TWarnVo vo) {
		return tWarnMapper.getWarnLevelNumToBus(vo);
	}

	@Override
	public List<TWarnsAnalysisDto> getWarnTypeNum(TWarnVo vo) {
		return tWarnMapper.getWarnTypeNum(vo);
	}

	@Override
	public List<TWarnsAnalysisDto> getWarnNumByDate(TWarnVo vo) {
		int dateDiff = 0;
		dateDiff = (int) DateUtils.dayInterval(vo.getStartTime(), vo.getEndTime()) + 1;
		vo.setDateDiff(dateDiff);
		vo.setContrastStartTime(DateUtils.getDateFromDate(vo.getStartTime(), (0 - dateDiff)));
		vo.setContrastEndTime(DateUtils.getDateFromDate(vo.getEndTime(), (0 - dateDiff)));
		return tWarnMapper.getWarnNumByDate(vo);
	}

	@Override
	public List<TWarn> getLimitWarnInfoDetail(String deviceCode, List<String> auditStatus, List<String> handleResults,
			Integer total) {
		if (total == null) {
			total = 4;
		}
		List<TWarn> warns = tWarnMapper.getWarnInfoBy(deviceCode, auditStatus, handleResults, total);
		if (warns == null) {
			return Collections.emptyList();
		}
		for (TWarn warn : warns) {
			setWarnMediaInfo(warn);
		}
		return warns;
	}

	@Override
	public String getDevCodeByBusPlateNumber(String busPlateNumber) {
		return tWarnMapper.getDevCodeByBusPlateNumber(busPlateNumber);
	}

	@Override
	public void updateWarnCc(TWarn vo) {
		tWarnMapper.updateWarnCc(vo);
	}

	@Override
	public List<TWarn> getWarnFigndetail(String devCode, Timestamp warnTime) {
		// TODO Auto-generated method stub
		return tWarnMapper.getWarnFigndetail(devCode, warnTime);
	}

	@Override
	public List<Map> selectDevstatus() {
		// TODO Auto-generated method stub
		return tWarnMapper.selectDevstatus();
	}

	@Override
	public Integer getTotalPerson(String busNumber, String samplingTime) {
		// TODO Auto-generated method stub
		return tWarnMapper.getTotalPerson(busNumber, samplingTime);
	}

	@Override
	public Integer getCurrentPerson(String busNumber, String samplingTime, String currenttrip) {
		// TODO Auto-generated method stub
		return tWarnMapper.getCurrentPerson(busNumber, samplingTime, currenttrip);
	};

}
