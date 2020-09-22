package com.cictec.yyjk.base.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cictec.yyjk.base.interceptors.AccessLogInfo;
import com.cictec.yyjk.base.model.entity.BaseUserInfo;
import com.cictec.yyjk.base.model.entity.Bus;
import com.cictec.yyjk.base.model.entity.DwDimOtherDevice;
import com.cictec.yyjk.base.model.view.BusLineView;
import com.cictec.yyjk.base.model.vo.BaseUserInfoVo;
import com.cictec.yyjk.base.model.vo.BusVo;
import com.cictec.yyjk.base.service.BaseUserInfoService;
import com.cictec.yyjk.base.service.BusService;
import com.cictec.yyjk.base.service.DwDimOtherDeviceService;
import com.cictec.yyjk.commons.core.Result;
import com.cictec.yyjk.commons.core.ResultUtil;
import com.cictec.yyjk.commons.utils.PMSUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * Created by xpguo on 2019/05/20.
 */
@RestController
@RequestMapping("/api/bus")
public class ApiBus extends BaseController {
	private static final Logger LOG = LoggerFactory.getLogger(ApiBus.class);
	@Resource
	private BusService busService;

	@Autowired
	private DwDimOtherDeviceService dwDimOtherDeviceService;

	@Autowired
	private BaseUserInfoService baseUserInfoService;

	@PostMapping("/add")
	public Result add(@RequestBody Bus bus) {
		busService.insertSelective(bus);
		return ResultUtil.getSuccessResult();
	}

	@PostMapping("/delete")
	public Result delete(@RequestBody Map<String, Object> paramMap) {
		String busUuid = PMSUtils.isNull(paramMap.get("busUuid"));
		busService.deleteByPrimaryKey(busUuid);
		return ResultUtil.getSuccessResult();
	}

	@PostMapping("/update")
	public Result update(@RequestBody Bus bus) {
		busService.updateByPrimaryKeySelective(bus);
		return ResultUtil.getSuccessResult();
	}

	@PostMapping("/detail")
	public Result detail(@RequestBody Map<String, Object> paramMap) {
		String busUuid = PMSUtils.isNull(paramMap.get("busUuid"));
		Bus bus = busService.selectByPrimaryKey(busUuid);
		if (bus != null) {
			List<DwDimOtherDevice> deviceList = dwDimOtherDeviceService.getDeviceInfoByBusUuid(busUuid);
			bus.setDeviceList(deviceList);
		}
		return ResultUtil.getSuccessResult(bus);
	}

	@PostMapping("/list")
	public Result list(@RequestBody BusVo busVo) {
		// 判定是否包含分页参数，如果包含则为分页数据请求
		if (busVo.getPageSize() != null && busVo.getPageSize() != 0) {
			return pageList(busVo);
		}

		// 增加用户线路权限设置
		BaseUserInfoVo user = new BaseUserInfoVo();
		user.setPersonId(busVo.getPersonId());
		List<BusLineView> lineList = baseUserInfoService.getLineListByUserId(user);
		List<String> lineUuids = new ArrayList<>();
		for (BusLineView busLineView : lineList) {
			lineUuids.add(busLineView.getLineUuid());
		}
		if (busVo.getLineUuids().size() == 0) {
			busVo.setLineUuids(lineUuids);
		}

		List<Bus> list = busService.getBusesBy(busVo);
		return ResultUtil.getSuccessResult(list);
	}

	@PostMapping("/pageList")
	public Result pageList(@RequestBody BusVo busVo) {
		// 分页数据请求处理
		PageHelper.startPage(busVo.getPageNumber(), busVo.getPageSize());
		List<Bus> list = busService.getBusesBy(busVo);
		return ResultUtil.getSuccessResult(new PageInfo<Bus>(list));
	}

	@PostMapping("/safelist")
	@AccessLogInfo(modelName = "疲劳监测", pageName = "安全信息下发")
	public Result safelist(@RequestBody BusVo busVo) {
		// 判定是否包含分页参数，如果包含则为分页数据请求
		PageHelper.startPage(busVo.getPageNumber(), busVo.getPageSize());
		List<Bus> list = busService.getSafeBuses(busVo);
		return ResultUtil.getSuccessResult(new PageInfo<Bus>(list));
	}

	@PostMapping("/device/binding")
	public Result deviceBinding(@RequestBody Bus bus, HttpServletRequest request) {
		BaseUserInfo userInfo = getUserIdByToken(request);
		try {
			busService.bindingBusDeviceInfo(bus, userInfo);
		} catch (Exception ex) {
			LOG.error("绑定车辆设备失败！原因：{}", ex);
		}
		return ResultUtil.getSuccessResult();
	}

	/**
	 * 根据车辆id获取绑定的设备信息
	 * 
	 * @param paramMap
	 * @return
	 */
	@PostMapping("/getDeviceInfos")
	public Result getDeviceInfosByBusUuid(@RequestBody Map<String, Object> paramMap) {
		String busUuid = PMSUtils.isNull(paramMap.get("busUuid"));
		List<DwDimOtherDevice> result = dwDimOtherDeviceService.getDeviceInfoByBusUuid(busUuid);
		return ResultUtil.getSuccessResult(result);
	}

	/**
	 * 根据车辆id获取绑定的设备信息
	 * 
	 * @param paramMap
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@PostMapping("/getBusByLineIds")
	public Result getBusByLineIds(@RequestBody Map<String, Object> paramMap) {
		List<String> lineUuids = (List<String>) paramMap.get("lineUuids");
		List<Bus> result = busService.getBusByLineIds(lineUuids);
		return ResultUtil.getSuccessResult(result);
	}

	@PostMapping("/carNo")
	public Result carNo(@RequestBody BusVo busVo) {
		// 判定是否包含分页参数，如果包含则为分页数据请求
		if (busVo.getPageSize() != null && busVo.getPageSize() != 0) {
			return pageList(busVo);
		}
		List<Bus> list = busService.getCarNoList(busVo);
		return ResultUtil.getSuccessResult(list);
	}

}
