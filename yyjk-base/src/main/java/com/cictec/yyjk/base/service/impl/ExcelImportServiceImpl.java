package com.cictec.yyjk.base.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.cictec.yyjk.base.model.entity.DwDimOtherBusDevice;
import com.cictec.yyjk.base.model.entity.DwDimOtherDevice;
import com.cictec.yyjk.base.model.vo.BusDeviceVo;
import com.cictec.yyjk.base.service.BusService;
import com.cictec.yyjk.base.service.DwDimOtherBusDeviceService;
import com.cictec.yyjk.base.service.DwDimOtherDeviceService;
import com.cictec.yyjk.base.service.ExcelImportLogService;
import com.cictec.yyjk.base.service.ExcelImportService;
import com.cictec.yyjk.base.utils.ExcelConstants;
import com.cictec.yyjk.commons.core.Result;
import com.cictec.yyjk.commons.core.ResultUtil;

@Service
public class ExcelImportServiceImpl implements ExcelImportService {
	private static final Logger LOG = LoggerFactory.getLogger(ExcelImportServiceImpl.class);

	@Autowired
	private BusService busService;

	@Autowired
	private DwDimOtherDeviceService deviceService;

	@Autowired
	private DwDimOtherBusDeviceService dwDimOtherBusDeviceService;

	@Autowired
	private ExcelImportLogService xlsLogService;

	@SuppressWarnings("rawtypes")
	@Override
	public Result importBusDevice(List<Map<String, String>> busDevices, String fileName, String userName)
			throws Exception {
		if (busDevices == null || busDevices.size() <= 0) {
			return ResultUtil.getErrorResult("导入的车辆设备关联信息为空!");
		}
		int succ = 0;
		BusDeviceVo vo;
		for (Map<String, String> busDevice : busDevices) {
			vo = JSONObject.parseObject(JSONObject.toJSONString(busDevice), BusDeviceVo.class);

			Map bus = busService.getBusInfoByVo(vo);
			if (bus == null) {
				xlsLogService.addLogs("车辆设备绑定批量导入", ExcelConstants.ERR_CODE_BIND,
						"第" + (vo.getRowNum()) + "行：" + ExcelConstants.ERR_MSG_BUS_CONDITION, fileName,
						userName);
				continue;
			} else {
				DwDimOtherDevice condition = new DwDimOtherDevice();
				condition.setDevClass(vo.getDevClass());
				condition.setDevCode(vo.getDevCode());
				List<DwDimOtherDevice> devices = deviceService.select(condition);
				if (devices != null && devices.size() > 0) {
					DwDimOtherBusDevice bean = new DwDimOtherBusDevice();
					bean.setBusUuid((String) bus.get("busUuid"));
					bean.setDevUuid(devices.get(0).getDevUuid());
					bean.setCreateTime(new Date());
					bean.setCreateUser(userName);
					dwDimOtherBusDeviceService.insertSelective(bean);
					succ++;
				} else {
					xlsLogService.addLogs("车辆设备绑定批量导入", ExcelConstants.ERR_CODE_BIND,
							"第" + (vo.getRowNum()) + "行：" + ExcelConstants.ERR_MSG_DEVICE_CONDITION, fileName,
							userName);
					continue;
				}
			}
		}
		LOG.info("共" + busDevices.size() + "条记录,成功导入" + succ + ",失败" + (busDevices.size() - succ) + "条");
		Map<String, Integer> resultMap = new HashMap<String, Integer>();
		resultMap.put("count", busDevices.size());
		resultMap.put("succ", succ);
		return ResultUtil.getSuccessResult(resultMap);
	}

	@Override
	public Result importDeviceInfo(List<Map<String, String>> importDatas, String fileName, String userName)
			throws Exception {
		if (importDatas == null || importDatas.size() <= 0) {
			return ResultUtil.getErrorResult("导入的设备信息为空!");
		}
		String devcode = null;
		int i = 0, succ = 0;
		DwDimOtherDevice po;
		for (Map<String, String> device : importDatas) {
			i++;
			po = JSONObject.parseObject(JSONObject.toJSONString(device), DwDimOtherDevice.class);
			devcode = po.getDevCode();
			if (StringUtils.isEmpty(devcode)) {
				// 将问题数据记录至excel日志表
				xlsLogService.addLogs("设备信息批量导入", ExcelConstants.ERR_CODE_NULL,
						"第" + (ExcelConstants.XLS_STARTROW + i - 1) + "行：" + ExcelConstants.ERR_MSG_DEV_NULL, fileName,
						userName);
				continue;
			} else {
				if (StringUtils.isEmpty(po.getDevClass())) {
					// 将问题数据记录至excel日志表
					xlsLogService.addLogs("设备信息批量导入", ExcelConstants.ERR_CODE_NULL,
							"第" + (ExcelConstants.XLS_STARTROW + i - 1) + "行：" + ExcelConstants.ERR_MSG_DEV_CLASS_NULL,
							fileName, userName);
					continue;
				} else {
					DwDimOtherDevice condition = new DwDimOtherDevice();
					condition.setDevCode(devcode);
					List<DwDimOtherDevice> list = deviceService.select(condition);
					if (list != null && list.size() > 0) {
						xlsLogService
								.addLogs("设备信息批量导入", ExcelConstants.ERR_CODE_DUPLICATE,
										"第" + (ExcelConstants.XLS_STARTROW + i - 1) + "行：【" + devcode + "】"
												+ ExcelConstants.ERR_MSG_DEV_DUPLICATE,
										fileName, userName);
						continue;
					}
					// 验证SIM卡号，只能是数字
					if (StringUtils.isNotEmpty(po.getDevSimNum()) && !isNumber(po.getDevSimNum())) {
						xlsLogService.addLogs("设备信息批量导入", ExcelConstants.ERR_CODE_SIM,
								"第" + (ExcelConstants.XLS_STARTROW + i - 1) + "行：【" + po.getDevSimNum() + "】"
										+ ExcelConstants.ERR_MSG_SIM,
								fileName, userName);
						po.setDevSimNum(null);
					}
					po.setDevCreateTime(new Date());
					po.setDevCreateUser(userName);
					po.setDevDropFlag("0");
					po.setDevIsvalid("1");
					po.setDevOnlineStatus("0");// 断开
					deviceService.insertSelective(po);
					succ++;
				}
			}
		}
		LOG.info("共" + importDatas.size() + "条记录,成功导入" + succ + ",失败" + (importDatas.size() - succ) + "条");
		Map<String, Integer> resultMap = new HashMap<String, Integer>();
		resultMap.put("count", importDatas.size());
		resultMap.put("succ", succ);
		return ResultUtil.getSuccessResult(resultMap);
	}

	/**
	 * 判断字符串是否是整数
	 */
	private static boolean isNumber(String value) {
		try {
			Long.parseLong(value);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
}
