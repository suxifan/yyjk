package com.cictec.yyjk.base.api;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cictec.yyjk.base.model.entity.DwDimOtherBusDevice;
import com.cictec.yyjk.base.model.entity.DwDimOtherDevice;
import com.cictec.yyjk.base.model.vo.DwDimOtherDeviceVo;
import com.cictec.yyjk.base.service.DwDimOtherBusDeviceService;
import com.cictec.yyjk.base.service.DwDimOtherDeviceService;
import com.cictec.yyjk.commons.core.Result;
import com.cictec.yyjk.commons.core.ResultUtil;
import com.cictec.yyjk.commons.utils.PMSUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;


/**
* Created by xpguo on 2019/08/30.
*/
@RestController
@RequestMapping("/api/device")
public class ApiDwDimOtherDevice {
    @Resource
    private DwDimOtherDeviceService dwDimOtherDeviceService;
	@Resource
	private DwDimOtherBusDeviceService dwDimOtherBusDeviceService;

    @PostMapping("/add")
    public Result add(@RequestBody DwDimOtherDevice dwDimOtherDevice) {
		DwDimOtherDevice bean = new DwDimOtherDevice();
		bean.setDevCode(dwDimOtherDevice.getDevCode());
		int count = dwDimOtherDeviceService.selectCount(bean);
		if (count > 0) {
			return ResultUtil.getErrorResult(String.format("设备号'%s'已存在!", bean.getDevCode()));
		}
		dwDimOtherDevice.setDevOnlineStatus("0");
		dwDimOtherDevice.setDevKey(bean.getDevCode());
		dwDimOtherDevice.setDevCreateTime(new Date());
        dwDimOtherDeviceService.insertSelective(dwDimOtherDevice);
        return ResultUtil.getSuccessResult();
    }

	/**
	 * @param paramMap
	 * @return
	 */
    @PostMapping("/delete")
	public Result delete(@RequestBody Map<String, Object> paramMap) {
		String devUuid = PMSUtils.isNull(paramMap.get("devUuid"));
		DwDimOtherBusDevice condition = new DwDimOtherBusDevice();
		condition.setDevUuid(devUuid);
		int res = dwDimOtherBusDeviceService.selectCount(condition);
		if (res > 0) {
			return ResultUtil.getErrorResult("设备正在使用,不可被删除!");
		}
		dwDimOtherDeviceService.deleteByPrimaryKey(devUuid);
        return ResultUtil.getSuccessResult();
    }

    @PostMapping("/update")
    public Result update(@RequestBody DwDimOtherDevice dwDimOtherDevice) {
		String devCode = dwDimOtherDevice.getDevCode();
		if (PMSUtils.isNotEmpty(devCode)) {
			DwDimOtherDevice record = new DwDimOtherDevice();
			record.setDevCode(devCode);
			List<DwDimOtherDevice> res = dwDimOtherDeviceService.select(record);
			if (res != null && res.size() > 0 && !res.get(0).getDevUuid().equals(dwDimOtherDevice.getDevUuid())) {
				return ResultUtil.getErrorResult(String.format("设备号'%s'已存在!", dwDimOtherDevice.getDevCode()));
			}
		}
		dwDimOtherDevice.setDevUpdateTime(new Date());
        dwDimOtherDeviceService.updateByPrimaryKeySelective(dwDimOtherDevice);
        return ResultUtil.getSuccessResult();
    }

    @PostMapping("/detail")
	public Result detail(@RequestBody Map<String, Object> paramMap) {
		String devUuid = PMSUtils.isNull(paramMap.get("devUuid"));
		DwDimOtherDevice dwDimOtherDevice = dwDimOtherDeviceService.selectByPrimaryKey(devUuid);
        return ResultUtil.getSuccessResult(dwDimOtherDevice);
    }

	@PostMapping("/list")
    public Result list(@RequestBody DwDimOtherDeviceVo dwDimOtherDeviceVo) {
		// 判定是否包含分页参数，如果包含则为分页数据请求
    	if(dwDimOtherDeviceVo.getPageSize() != null && dwDimOtherDeviceVo.getPageSize() != 0){
    		return pageList(dwDimOtherDeviceVo);
    	}
		List<DwDimOtherDevice> list = dwDimOtherDeviceService.getDevicesBy(dwDimOtherDeviceVo);
		return ResultUtil.getSuccessResult(list);
    }
    
	@PostMapping("/pageList")
	public Result pageList (@RequestBody DwDimOtherDeviceVo dwDimOtherDeviceVo) {
		// 分页数据请求处理
		PageHelper.startPage(dwDimOtherDeviceVo.getPageNumber(), dwDimOtherDeviceVo.getPageSize());
		// 根据具体业务重写
		List<DwDimOtherDevice> list = dwDimOtherDeviceService.getDevicesBy(dwDimOtherDeviceVo);
    	return ResultUtil.getSuccessResult(new PageInfo<DwDimOtherDevice>(list));
	}
	
	@PostMapping("/nobindDevices")
	public Result getDevCodesList(@RequestBody Map<String, Object> paramMap) {
		String devUuid = PMSUtils.isNull(paramMap.get("devUuid"));
		String devClass = PMSUtils.isNull(paramMap.get("devClass"));
		List<DwDimOtherDevice> list = dwDimOtherDeviceService.getNoBindDevCodeList(devUuid, devClass);
		return ResultUtil.getSuccessResult(list);
	}

}
