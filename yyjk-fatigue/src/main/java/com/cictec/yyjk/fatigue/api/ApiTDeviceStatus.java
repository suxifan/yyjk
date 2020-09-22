package com.cictec.yyjk.fatigue.api;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.cictec.yyjk.base.interceptors.AccessLogInfo;
import com.cictec.yyjk.commons.core.Result;
import com.cictec.yyjk.commons.core.ResultUtil;
import com.cictec.yyjk.commons.utils.DateUtils;
import com.cictec.yyjk.commons.utils.FileOperUtils;
import com.cictec.yyjk.fatigue.model.entity.TDevice;
import com.cictec.yyjk.fatigue.model.vo.TDeviceVo;
import com.cictec.yyjk.fatigue.service.TDeviceService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 设备状态control Created by Rwq on 2019/05/23.
 */
@RestController
@RequestMapping("/deviceStatus")
public class ApiTDeviceStatus {
	private static final Logger LOG = LoggerFactory.getLogger(ApiTDeviceStatus.class);
	// web映射地址
	@Value("${web.webrooturl}")
	private String webrooturl;
	@Autowired
	private Environment env;

	@Resource
	private TDeviceService tDeviceService;

	/**
	 * 设备状态--设备在线率
	 */
	@PostMapping("/online/get")
	public Result onlineGet(@RequestBody TDeviceVo param) {
		Result result = null;
		try {
			Map<String, String> vo = tDeviceService.countDeviceStatus(param);
			result = ResultUtil.getSuccessResult(vo);
		} catch (Exception ex) {
			LOG.error("设备状态--设备在线率查询异常，原因：{}", ex);
			result = ResultUtil.getFailResult();
		}
		return result;
	}

	/**
	 * 线路设备列表查询
	 */
	@AccessLogInfo(modelName = "疲劳监测", pageName = "设备状态")
	@PostMapping("/list")
	public Result list(@RequestBody TDeviceVo vo) {
		// 判定是否包含分页参数，如果包含则为分页数据请求
		if ((vo.getPageSize() != null && vo.getPageSize() != 0)
				&& (vo.getPageNumber() != null && vo.getPageNumber() > 0)) {
			// 设备在线时，分页查询
			return pageList(vo);
		}
		try {
			List<TDevice> noPageList = tDeviceService.queryDeviveInfo(vo);
			// 设备在线状态时非分页查询，不要计算设备离线时间
			// if ("1".equals(vo.getDevOnlineStatus())) {
			// noPageList = tDeviceService.queryDeviveInfo(vo);
			// } else {
			// // 设备离线状态时非分页查询，要计算设备离线时间
			// noPageList =
			// tDeviceService.queryDeviveInfoByCountOffLineTime(vo);
			// }
			return ResultUtil.getSuccessResult(noPageList);
		} catch (Exception ex) {
			LOG.error("设备状态查询异常，原因：{}", ex);
			return ResultUtil.getErrorResult();
		}

	}

	@PostMapping("/pageList")
	public Result pageList(@RequestBody TDeviceVo vo) {
		try {
			// 分页数据请求处理
			PageHelper.startPage(vo.getPageNumber(), vo.getPageSize());
			List<TDevice> list = tDeviceService.queryDeviveInfo(vo);
			// if ("1".equals(vo.getDevOnlineStatus())) {
			// list = tDeviceService.queryDeviveInfo(vo);
			// } else {
			// // 设备离线状态时，要计算设备离线时间
			// list = tDeviceService.queryDeviveInfoByCountOffLineTime(vo);
			// }
			return ResultUtil.getSuccessResult(new PageInfo<TDevice>(list));
		} catch (Exception ex) {
			LOG.error("设备状态分页查询异常，原因：{}", ex);
			return ResultUtil.getErrorResult();
		}
	}

	/**
	 * 导出设备状态信息
	 */
	@PostMapping("/export")
	public Result export(@RequestBody TDeviceVo vo) {
		String envPath = env.getProperty("spring.resources.static-locations");
		String srcFilePath = envPath.substring(envPath.indexOf(":") + 1) + "deviceStatusInfoModel.xls";
		String fileName = String.format("deviceStatusInfoData%s.xls",
				new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
		String tempFilePath = envPath.substring(envPath.indexOf(":") + 1) + "upload" + File.separator + fileName;

		List<TDevice> list = tDeviceService.queryDeviveInfo(vo);
		// try {
		// // 设备在线状态时非分页查询，不要计算设备离线时间
		// if ("1".equals(vo.getDevOnlineStatus()) ||
		// StringUtils.isEmpty(vo.getDevOnlineStatus())) {
		// list = tDeviceService.queryDeviveInfo(vo);
		// } else {
		// // 设备离线状态时非分页查询，要计算设备离线时间
		// list = tDeviceService.queryDeviveInfoByCountOffLineTime(vo);
		// }
		// } catch (Exception e) {
		// LOG.error("获取设备状态明细异常，错误原因：{}", e);
		// }
		if (list != null && list.size() == 0) {
			return ResultUtil.getErrorResult("没有导出记录！");
		}
		if (list != null && list.size() > 65536) {
			list = list.subList(0, 65535);
		}
		List<List<String>> data = new ArrayList<List<String>>();
		for (TDevice item : list) {
			List<String> row = new ArrayList<>();
			row.add("'" + item.getDevCode());
			row.add(item.getOrgName());
			row.add(item.getLineName());
			row.add(item.getBusSelfCode());
			row.add(item.getBusPlateNumber());
			row.add(item.getDevOnlineStatus());
			row.add(item.getDevModel());
			row.add(item.getDevIsvalid());
			row.add(DateUtils.formatDateTime(item.getDevOnlineTime()));
			row.add(item.getOfflineTimeLabel());
			data.add(row);
		}
		File tempFile = new File(tempFilePath);
		try {
			FileOperUtils.writeExcel(new File(srcFilePath), tempFile, 0, 1, data);
			JSONObject json = new JSONObject();
			json.put("url", webrooturl + "exceltemplate/upload/" + fileName);
			LOG.info("导出设备状态明细数据下载文件:{}", fileName);
			return ResultUtil.getSuccessResult(json);
		} catch (Exception ex) {
			LOG.error("导出设备状态明细数据失败！{}", ex);
			return ResultUtil.getErrorResult("导出设备状态明细数据失败！");
		}
	}
}
