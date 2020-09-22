package com.cictec.yyjk.fatigue.api;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cictec.yyjk.base.api.BaseController;
import com.cictec.yyjk.base.interceptors.AccessLogInfo;
import com.cictec.yyjk.base.model.entity.BaseUserInfo;
import com.cictec.yyjk.base.model.entity.Bus;
import com.cictec.yyjk.base.model.entity.DwDimOtherDevice;
import com.cictec.yyjk.base.model.vo.BusVo;
import com.cictec.yyjk.base.service.BusService;
import com.cictec.yyjk.base.service.DwDimOtherDeviceService;
import com.cictec.yyjk.commons.core.Result;
import com.cictec.yyjk.commons.core.ResultUtil;
import com.cictec.yyjk.fatigue.model.entity.TDevice;
import com.cictec.yyjk.fatigue.model.entity.TWarn;
import com.cictec.yyjk.fatigue.model.entity.TempPlTakePhotoSet;
import com.cictec.yyjk.fatigue.model.vo.TWarnVo;
import com.cictec.yyjk.fatigue.model.vo.TempPlTakePhotoSetVo;
import com.cictec.yyjk.fatigue.service.TWarnService;
import com.cictec.yyjk.fatigue.service.TempPlTakePhotoSetService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 设备抓拍及设置 Control Created by Rwq on 2020/03/09.
 */
@RestController
@RequestMapping("/takePhoto")
public class ApiTakePhoto extends BaseController {
	private static final Logger LOG = LoggerFactory.getLogger(ApiTakePhoto.class);

	@Resource
	private TWarnService tWarnService; // 报警服务service

	@Resource
	private TempPlTakePhotoSetService tempPlTakePhotoSetService;

	@Resource
	private DwDimOtherDeviceService dwDimOtherDeviceService;

	@Resource
	private BusService busService; // 车辆server

	/**
	 * 设备抓拍列表-列表查询（分页）
	 */
	@AccessLogInfo(modelName = "疲劳监测", pageName = "设备抓拍")
	@PostMapping("/warnPage/get")
	public Result pageList(@RequestBody TWarnVo vo, HttpServletRequest request) {
		BaseUserInfo userInfo = getUserIdByToken(request);
		/*
		 * boolean res = hasDataAuthority(userInfo); if (!res) { return
		 * ResultUtil.getErrorResult("用户没有查看报警数据的权限！"); }
		 */
		try {
			String[] warnTypes = vo.getWarnTypeId();
			if (ArrayUtils.isEmpty(warnTypes)) {
				return ResultUtil.getErrorResult("报警类型不能为空！");
			}
			PageHelper.startPage(vo.getPageNum(), vo.getPageSize());
			List<TWarn> list = tWarnService.selectWarnPlatfromPage(vo);
			return ResultUtil.getSuccessResult(new PageInfo<TWarn>(list));
		} catch (Exception ex) {
			LOG.error("驾驶行为设备抓拍分页查询异常，原因{}", ex);
			return ResultUtil.getErrorResult();
		}
	}

	/**
	 * 设备抓拍设置列表-手动抓拍
	 */
	@PostMapping("/manual")
	public Result manual(@RequestBody TempPlTakePhotoSetVo vo) {
		Result result = null;
		try {
			List<String> devCodes = new ArrayList<String>();
			List<TDevice> devList = vo.getDevList();
			List<TDevice> devNewList = new ArrayList<>();
			String msg = "";
			for (TDevice dev : devList) {
				List<DwDimOtherDevice> devInfo = dwDimOtherDeviceService.getDeviceInfoByDevCode(dev.getDevCode());
				String devOnlineStatus = devInfo.get(0).getDevOnlineStatus();
				if ("0".equals(devOnlineStatus)) {
					msg += "设备号" + dev.getDevCode() + ",";
				} else {
					devNewList.add(dev);
				}
			}
			if (msg != "") {
				msg += "设备不在线！";
				return ResultUtil.getFailResult(msg);
			}
			vo.setDevList(devNewList);
			tempPlTakePhotoSetService.devByManual(vo);
			result = ResultUtil.getSuccessResult();
		} catch (Exception e) {
			e.printStackTrace();
			result = ResultUtil.getFailResult();
		}
		return result;
	}

	/**
	 * 获取设备是否在线
	 */
	@PostMapping("/manual/getDevIsOnLine")
	public Result getDevIsOnLine(@RequestBody TempPlTakePhotoSetVo vo) {
		Result result = null;
		try {
			List<TDevice> devList = vo.getDevList();
			List<TDevice> devNewList = new ArrayList<>();
			String msg = "";
			if (devList.size() > 0) {
				for (TDevice dev : devList) {
					List<DwDimOtherDevice> devInfo = dwDimOtherDeviceService.getDeviceInfoByDevCode(vo.getDevCode());
					String devOnlineStatus = devInfo.get(0).getDevOnlineStatus();
					if ("0".equals(devOnlineStatus)) {
						msg += "设备" + dev.getDevCode() + ",";
					} else {
						devNewList.add(dev);
					}
				}
				if (msg != "") {
					msg += "不在线,不能抓拍！";
					return ResultUtil.getErrorResult(msg);
				}
			} else {
				result = ResultUtil.getFailResult("设备号不能为空");
			}
		} catch (Exception e) {
			LOG.error("获取设备是否在线异常，原因{}", e);
			result = ResultUtil.getFailResult();
		}
		return result;
	}

	/**
	 * 设备抓拍设置列表-新增
	 */
	@PostMapping("/add")
	public Result add(@RequestBody TempPlTakePhotoSet tempPlTakePhotoSet, HttpServletRequest request) {
		Result result = null;
		try {
			BaseUserInfo userInfo = getUserIdByToken(request);
			tempPlTakePhotoSet.setCreateUser(userInfo.getUserAccount());
			tempPlTakePhotoSet.setCreateTime(new Date());
			tempPlTakePhotoSetService.saveDevTakePhoto(tempPlTakePhotoSet);
			result = ResultUtil.getSuccessResult();
		} catch (Exception e) {
			e.printStackTrace();
			result = ResultUtil.getFailResult();
		}
		return result;
	}

	/**
	 * 设备抓拍设置列表-删除
	 */
	@PostMapping("/delete")
	public Result delete(@RequestBody TempPlTakePhotoSetVo vo) {
		String[] ids = vo.getTakePhotoUuids();
		Result result = null;
		if (ids != null && ids.length > 0) {
			for (int i = 0; i < ids.length; i++) {
				tempPlTakePhotoSetService.deleteDevTakePhoto(ids[i]);
			}
			result = ResultUtil.getSuccessResult();
		}
		return result;
	}

	/**
	 * 设备抓拍设置列表-修改
	 */
	@PostMapping("/update")
	public Result update(@RequestBody TempPlTakePhotoSet tempPlTakePhotoSet) {
		tempPlTakePhotoSetService.updateDevTakePhoto(tempPlTakePhotoSet);
		return ResultUtil.getSuccessResult();
	}

	/**
	 * 设备抓拍设置列表-列表查询（分页）
	 */
	@AccessLogInfo(modelName = "系统管理", pageName = "设备抓拍配置")
	@PostMapping("/takephotoPage/get")
	public Result takePageList(@RequestBody TempPlTakePhotoSetVo vo) {
		Result result = null;
		try {
			PageHelper.startPage(vo.getPageNum(), vo.getPageSize());
			List<TempPlTakePhotoSet> list = tempPlTakePhotoSetService.selectTakePhotoSetPage(vo);
			result = ResultUtil.getSuccessResult(new PageInfo<TempPlTakePhotoSet>(list));
		} catch (Exception e) {
			e.printStackTrace();
			result = ResultUtil.getFailResult();
		}
		return result;
	}

	/**
	 * 获取绑定minieye设备的车辆信息
	 */
	@PostMapping("/minieyeBusList/get")
	public Result minieyeBusList(@RequestBody BusVo busVo) {
		Result result = null;
		try {
			List<Bus> list = busService.getMinieyeBus(busVo);
			result = ResultUtil.getSuccessResult(list);
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
			result = ResultUtil.getFailResult();
		}
		return result;
	}

}
