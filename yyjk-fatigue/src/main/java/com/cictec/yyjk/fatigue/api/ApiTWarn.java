package com.cictec.yyjk.fatigue.api;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cictec.yyjk.base.api.BaseController;
import com.cictec.yyjk.base.interceptors.AccessLogInfo;
import com.cictec.yyjk.base.model.entity.BaseUserInfo;
import com.cictec.yyjk.commons.core.Result;
import com.cictec.yyjk.commons.core.ResultUtil;
import com.cictec.yyjk.commons.utils.DateUtils;
import com.cictec.yyjk.commons.utils.FileOperUtils;
import com.cictec.yyjk.commons.utils.PMSUtils;
import com.cictec.yyjk.commons.utils.RestUtils;
import com.cictec.yyjk.commons.utils.StringUtils;
import com.cictec.yyjk.commons.utils.gps.Gps;
import com.cictec.yyjk.commons.utils.gps.GpsSwitchUtils;
import com.cictec.yyjk.fatigue.common.base.BaseTreeNode;
import com.cictec.yyjk.fatigue.model.entity.TWarn;
import com.cictec.yyjk.fatigue.model.entity.TempBusOverWarnTrail;
import com.cictec.yyjk.fatigue.model.view.CanDataValue;
import com.cictec.yyjk.fatigue.model.vo.QueryCondition;
import com.cictec.yyjk.fatigue.model.vo.TWarnVo;
import com.cictec.yyjk.fatigue.service.TVoicePromptService;
import com.cictec.yyjk.fatigue.service.TWarnService;
import com.cictec.yyjk.fatigue.service.TempBusOverWarnTrailService;
import com.cictec.yyjk.fatigue.utils.GetLatAndLngByBaidu;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 报警中心Control Created by Rwq on 2019/05/22.
 */
@RestController
@RequestMapping("/warns")
public class ApiTWarn extends BaseController {
	private static final Logger LOG = LoggerFactory.getLogger(ApiTWarn.class);
	// web映射地址
	@Value("${web.webrooturl}")
	private String webrooturl;

	@Autowired
	private Environment env;

	@Resource
	private TWarnService tWarnService;

	@Autowired
	private TempBusOverWarnTrailService tempBusOverWarnTrailService;

	@Autowired
	private TVoicePromptService tVoicePromptService;

	/**
	 * 报警中心-列表查询（分页）
	 */
	@AccessLogInfo(modelName = "疲劳监测", pageName = "驾驶行为监测")
	@PostMapping("/warnPage/get")
	public Result pageList(@RequestBody TWarnVo vo, HttpServletRequest request) {
		String[] warnTypes = vo.getWarnTypeId();
		if (ArrayUtils.isEmpty(warnTypes)) {
			return ResultUtil.getErrorResult("报警类型不能为空！");
		}
		BaseUserInfo userInfo = getUserIdByToken(request);
		boolean res = hasDataAuthority(userInfo);
		if (!res) {
			return ResultUtil.getErrorResult("用户没有查看报警数据的权限！");
		}
		try {
			PageHelper.startPage(vo.getPageNum(), vo.getPageSize());
			List<TWarn> list = tWarnService.selectWarnPlatfromPage(vo);
			// 处理超时
			for (TWarn tWarn : list) {
				// 如果是超速报警，根据can线获取最大速度
				String warnType = tWarn.getWarnType();

				// gps坐标转换
				String lngStr = tWarn.getLng();
				String latStr = tWarn.getLat();
				if (StringUtils.isNotEmpty(lngStr) && StringUtils.isNotEmpty(latStr)) {
					Gps gps = GpsSwitchUtils.wgs84tobd09(Double.valueOf(lngStr), Double.valueOf(latStr));
					tWarn.setLng(gps.getWgLon() + "");
					tWarn.setLat(gps.getWgLat() + "");
					// 增加报警地址
					try {
						tWarn.setWarnAddress(GetLatAndLngByBaidu.getLocationByBaiduMap(gps.getWgLon(), gps.getWgLat()));
					} catch (Exception e) {
						tWarn.setWarnAddress("暂无地址");
					}
				}

				// 处理超速报警
				if ("OVERSPEED".equals(warnType)) {
					TempBusOverWarnTrail tempBusOverWarnTrailTemp = new TempBusOverWarnTrail();
					tempBusOverWarnTrailTemp.setFkWarnUuid(tWarn.getWarnUuid());
					List<TempBusOverWarnTrail> trails = tempBusOverWarnTrailService.select(tempBusOverWarnTrailTemp);
					List<CanDataValue> canDatas = new ArrayList<>();
					for (TempBusOverWarnTrail bean : trails) {
						int speed = StringUtils.isEmpty(bean.getSpeed()) ? 0 : Integer.parseInt(bean.getSpeed());
						canDatas.add(new CanDataValue(speed, bean.getWarnTime()));
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
				}

				tWarn.setOverTime(checkOverTime(tWarn.getWarnTime()));
			}
			return ResultUtil.getSuccessResult(new PageInfo<TWarn>(list));
		} catch (Exception ex) {
			LOG.error("驾驶行为检测分页查询异常，原因{}", ex);
			return ResultUtil.getErrorResult();
		}
	}

	private boolean checkOverTime(Date date) {
		boolean b = false;
		Date ydate = DateUtils.getYesterday();// 当前时间减24小时
		if (date.compareTo(ydate) < 0) {
			b = true;
		}
		return b;
	}

	/**
	 * 报警中心-报警详情
	 */
	@PostMapping("/warnInfoDetail/get")
	public Result warnInfoDetail(@RequestBody TWarnVo vo) {
		Result result = null;
		try {
			// 根据报警id获取报警时间
			Date warnTime = tWarnService.getWarnTimeByUuid(vo.getWarnUuid());
			vo.setWarnTime(warnTime);
			TWarn warn = tWarnService.warnInfoDetailGet(vo);
			// gps坐标转换
			String lngStr = warn.getLng();
			String latStr = warn.getLat();
			if (StringUtils.isNotEmpty(lngStr) && StringUtils.isNotEmpty(latStr)) {
				Gps gps = GpsSwitchUtils.wgs84tobd09(Double.valueOf(lngStr), Double.valueOf(latStr));
				warn.setLng(gps.getWgLon() + "");
				warn.setLat(gps.getWgLat() + "");
			}
			// 增加车辆状态字段，判断车辆是否在线，如果在线才能下发语音通话。
			/*
			 * warn.setBusState("0"); String httpUrl =
			 * env.getProperty("gjdd.http.url") + "/getBusPosition?busNumber=" +
			 * warn.getBusPlateNumber(); String busResult =
			 * RestUtils.getPostData(httpUrl, "", false); if
			 * (PMSUtils.isNotEmpty(busResult)) { JSONArray arrys =
			 * JSON.parseArray(busResult); if (arrys.size() > 0) {
			 * warn.setBusState("1"); } }
			 */
			result = ResultUtil.getSuccessResult(warn);
		} catch (Exception e) {
			LOG.error("获取报警详情异常，原因{}", e);
			result = ResultUtil.getFailResult();
		}
		return result;
	}

	/**
	 * 获取车辆是否在线
	 */
	@PostMapping("/warnInfoDetail/getBusIsOnLine")
	public Result getBusIsOnLine(@RequestBody TWarnVo vo) {
		Result result = null;
		try {
			if (PMSUtils.isNotEmpty(vo.getBusPlateNumber())) {
				Map<String, String> warn = new HashMap<String, String>();
				// 增加车辆状态字段，判断车辆是否在线，如果在线才能下发语音通话。
				warn.put("busState", "0");
				String httpUrl = env.getProperty("gjdd.http.url") + "/getBusPosition?busNumber="
						+ vo.getBusPlateNumber();
				String busResult = RestUtils.getPostData(httpUrl, "", false);
				if (PMSUtils.isNotEmpty(busResult)) {
					JSONArray arrys = JSON.parseArray(busResult);
					if (arrys.size() > 0) {
						warn.put("busState", "1");
					}
				}
				result = ResultUtil.getSuccessResult(warn);
			} else {
				result = ResultUtil.getFailResult("车牌号不能为空");
			}
		} catch (Exception e) {
			LOG.error("获取车辆在线状态异常，原因{}", e);
			result = ResultUtil.getFailResult();
		}
		return result;
	}

	@PostMapping("/warnInfoDetail/pigePicList")
	public Result pigePicList(@RequestBody Map vo) {
		Result result = null;
		try {
			// 根据报警id获取报警时间
			Object obj = tWarnService.listPiplePic(vo);
			result = ResultUtil.getSuccessResult(obj);
		} catch (Exception e) {
			LOG.error("获取报警详情异常，原因{}", e);
			result = ResultUtil.getFailResult();
		}
		return result;
	}

	@PostMapping("/warnHandle")
	public Result warnHandle(@RequestBody TWarn tWarn, HttpServletRequest request) {
		BaseUserInfo userInfo = getUserIdByToken(request);
		if (userInfo != null) {
			tWarn.setHandleUser(userInfo.getUserAccount());
		}
		tWarn.setHandleTime(new Date());
		tWarnService.updateByPrimaryKeySelective(tWarn);
		return ResultUtil.getSuccessResult();
	}

	@PostMapping("/warnAudit")
	public Result update(@RequestBody TWarn tWarn, HttpServletRequest request) {
		BaseUserInfo userInfo = getUserIdByToken(request);
		if (userInfo != null) {
			tWarn.setHandleUser(userInfo.getUserAccount());
		}
		tWarn.setAuditTime(new Date());
		tWarnService.updateByPrimaryKeySelective(tWarn);
		return ResultUtil.getSuccessResult();
	}

	@PostMapping("/warnCc")
	public Result warnCc(@RequestBody TWarn tWarn, HttpServletRequest request) {
		// BaseUserInfo userInfo = getUserIdByToken(request);
		// if (userInfo != null) {
		// tWarn.setHandleUser(userInfo.getUserAccount());
		// }
		// tWarn.setAuditTime(new Date());
		// tWarnService.updateByPrimaryKeySelective(tWarn);
		tWarnService.updateWarnCc(tWarn);
		return ResultUtil.getSuccessResult();
	}

	/**
	 * 报警中心-组织结构线路树结构
	 */
	@AccessLogInfo(modelName = "疲劳监测", pageName = "车辆实时监控")
	@PostMapping("/orgLineBusTree/get")
	@ResponseBody
	public Result orgLineBusTree() {
		Result result = null;
		try {
			// 查询设备在线
			List<BaseTreeNode> list = tWarnService.orgLineBusTreeGet2(null);
			//
			result = ResultUtil.getSuccessResult(list);
		} catch (Exception e) {
			LOG.error("获取报警中心-组织结构线路树结构异常，原因{}", e);
			result = ResultUtil.getFailResult();
		}
		return result;
	}

	@PostMapping(value = "/orgLineBusTree/getbus")
	@ResponseBody
	public Result getDrvList(@RequestBody QueryCondition queryCondition) {
		Result result = null;
		try {
			// 查询设备在线

			Map busTree = tWarnService.orgLineBusTreeGet3(queryCondition);
			//
			result = ResultUtil.getSuccessResult(busTree);
		} catch (Exception e) {
			LOG.error("获取报警中心-组织结构线路树结构异常，原因{}", e);
			result = ResultUtil.getFailResult();
		}
		return result;
	}

	@PostMapping("/export")
	public Result export(@RequestBody TWarnVo vo) throws Exception {
		String envPath = env.getProperty("spring.resources.static-locations");
		String srcFilePath = envPath.substring(envPath.indexOf(":") + 1) + "warnInfoModel.xls";

		String fileName = String.format("warnInofData%s.xls",
				new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
		String tempFilePath = envPath.substring(envPath.indexOf(":") + 1) + "upload" + File.separator + fileName;
		String[] warnTypes = vo.getWarnTypeId();
		if (ArrayUtils.isEmpty(warnTypes)) {
			return ResultUtil.getErrorResult("报警类型不能为空！");
		}
		List<TWarn> list = tWarnService.selectWarnPlatfromPage(vo);

		if (list != null && list.size() == 0) {
			return ResultUtil.getErrorResult("没有导出记录！");
		}
		if (list != null && list.size() > 65535) {
			list = list.subList(0, 65534);
		}
		List<List<String>> data = new ArrayList<List<String>>();
		for (TWarn item : list) {
			List<String> row = new ArrayList<>();
			// 如果是超速报警，根据can线获取最大速度
			String warnType = item.getWarnType();
			// gps坐标转换
			String lngStr = item.getLng();
			String latStr = item.getLat();
			if (StringUtils.isNotEmpty(lngStr) && StringUtils.isNotEmpty(latStr)) {
				Gps gps = GpsSwitchUtils.wgs84tobd09(Double.valueOf(lngStr), Double.valueOf(latStr));
				item.setLng(gps.getWgLon() + "");
				item.setLat(gps.getWgLat() + "");
				// 增加报警地址
				// item.setWarnAddress(GetLatAndLngByBaidu.getLocationByBaiduMap(gps.getWgLon(),
				// gps.getWgLat()));
				item.setWarnAddress("");
			}

			// 处理超速报警
			if ("OVERSPEED".equals(warnType)) {
				TempBusOverWarnTrail tempBusOverWarnTrailTemp = new TempBusOverWarnTrail();
				tempBusOverWarnTrailTemp.setFkWarnUuid(item.getWarnUuid());
				List<TempBusOverWarnTrail> trails = tempBusOverWarnTrailService.select(tempBusOverWarnTrailTemp);
				List<CanDataValue> canDatas = new ArrayList<>();
				for (TempBusOverWarnTrail bean : trails) {
					int speed = StringUtils.isEmpty(bean.getSpeed()) ? 0 : Integer.parseInt(bean.getSpeed());
					canDatas.add(new CanDataValue(speed, bean.getWarnTime()));
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
				item.setSpeed(srcList.get(0).getSpeed() + "");
			}

			item.setOverTime(checkOverTime(item.getWarnTime()));
			row.add(item.getOrgName());
			row.add(item.getLineName());
			row.add(item.getBusPlateNumber());
			row.add(item.getBusSelfCode());
			row.add(item.getDriverName());
			// row.add(item.getDevCode());
			row.add(item.getWarnTypeName());
			row.add(item.getWarnLevel() + "级");
			row.add(item.getWarnNumber());
			row.add(item.getSpeed());
			row.add(DateUtils.formatDate(item.getWarnTime(), "yyyy-MM-dd HH:mm:ss"));
			// row.add(item.getWarnAddress());// 报警位置
			row.add(item.getAuditUser());// 审核人
			if ("1".equals(item.getAuditStatus())) {
				row.add("属实");// 审核结果
			} else if ("2".equals(item.getAuditStatus())) {
				row.add("误报");// 审核结果
			} else if ("3".equals(item.getAuditStatus())) {
				row.add("其他");// 审核结果
			} else {
				row.add("未审核");
			}
			row.add(item.getAuditSuggestion());
			row.add(DateUtils.formatDate(item.getAuditTime(), "yyyy-MM-dd HH:mm:ss"));
			row.add(item.getHandleUser());
			row.add(DateUtils.formatDate(item.getHandleTime(), "yyyy-MM-dd HH:mm:ss"));
			row.add(item.getHandleSuggestion());// 处理意见
			data.add(row);
		}
		File tempFile = new File(tempFilePath);
		try {
			FileOperUtils.writeExcel(new File(srcFilePath), tempFile, 0, 1, data);
			JSONObject json = new JSONObject();
			json.put("url", webrooturl + "exceltemplate/upload/" + fileName);
			LOG.info("导出报警信息数据下载文件:{}", fileName);
			return ResultUtil.getSuccessResult(json);
		} catch (Exception ex) {
			LOG.error("导出报警信息数据失败！{}", ex);
			return ResultUtil.getErrorResult("导出报警信息数据失败！");
		}
	}

	@PostMapping("/deviceExport")
	public Result deviceExport(@RequestBody TWarnVo vo) {
		String envPath = env.getProperty("spring.resources.static-locations");
		String srcFilePath = envPath.substring(envPath.indexOf(":") + 1) + "warnInfoDeviceModel.xls";

		String fileName = String.format("warnInfoDeviceModel%s.xls",
				new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
		String tempFilePath = envPath.substring(envPath.indexOf(":") + 1) + "upload" + File.separator + fileName;
		String[] warnTypes = vo.getWarnTypeId();
		if (ArrayUtils.isEmpty(warnTypes)) {
			return ResultUtil.getErrorResult("报警类型不能为空！");
		}
		List<TWarn> list = tWarnService.selectWarnPlatfromPage(vo);

		if (list != null && list.size() == 0) {
			return ResultUtil.getErrorResult("没有导出记录！");
		}
		if (list != null && list.size() > 65535) {
			list = list.subList(0, 65534);
		}
		List<List<String>> data = new ArrayList<List<String>>();
		for (TWarn item : list) {
			List<String> row = new ArrayList<>();
			row.add(item.getOrgName());
			row.add(item.getLineName());
			row.add(item.getBusPlateNumber());
			row.add(item.getBusSelfCode());
			row.add(item.getDevCode());
			row.add(item.getWarnTypeName());
			row.add(item.getSpeed());
			row.add(DateUtils.formatDate(item.getWarnTime(), "yyyy-MM-dd HH:mm:ss"));
			data.add(row);
		}
		File tempFile = new File(tempFilePath);
		try {
			FileOperUtils.writeExcel(new File(srcFilePath), tempFile, 0, 1, data);
			JSONObject json = new JSONObject();
			json.put("url", webrooturl + "exceltemplate/upload/" + fileName);
			LOG.info("导出设备抓拍信息数据下载文件:{}", fileName);
			return ResultUtil.getSuccessResult(json);
		} catch (Exception ex) {
			LOG.error("导出设备抓拍信息数据失败！{}", ex);
			return ResultUtil.getErrorResult("导出设备抓拍信息数据失败！");
		}
	}

	/**
	 * 语音提示
	 * 
	 * @param tWarn
	 * @param request
	 * @return
	 */
	@PostMapping("/Voiceprompt")
	public Result Voiceprompt(@RequestBody Map<String, Object> tWarn) {
		tWarn.put("messageType", "1");
		tWarn.put("messageClass", "send");
		tVoicePromptService.sendVoiceprompt(tWarn);
		return ResultUtil.getSuccessResult();
	}

	/**
	 * 语音提示 批量下发
	 * 
	 * @param tWarn
	 * @param request
	 * @return
	 */
	@PostMapping("/voicepromptBatch")
	public Result voicepromptBatch(@RequestBody Map<String, Object> tWarn) {
		tWarn.put("messageType", "1");
		tWarn.put("messageClass", "send");
		tVoicePromptService.sendVoicepromptBatch(tWarn);
		return ResultUtil.getSuccessResult();
	}

	/**
	 * 语音提示 批量下发
	 * 
	 * @param tWarn
	 * @param request
	 * @return
	 */
	@PostMapping("/allVoicepromptBatch")
	public Result allVoicepromptBatch(@RequestBody Map<String, Object> tWarn) {
		tWarn.put("messageType", "1");
		tWarn.put("messageClass", "send");
		tVoicePromptService.sendAllVoicepromptBatch(tWarn);
		return ResultUtil.getSuccessResult();
	}
}
