package com.cictec.yyjk.base.service.impl;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cictec.yyjk.base.mapper.DwDimOtherDeviceMapper;
import com.cictec.yyjk.base.model.entity.DwDimOtherDevice;
import com.cictec.yyjk.base.model.vo.DwDimOtherDeviceVo;
import com.cictec.yyjk.base.service.DwDimOtherDeviceService;
import com.cictec.yyjk.commons.core.AbstractService;

/**
 * Created by xpguo on 2019/08/30.
 */
@Service
@Transactional
public class DwDimOtherDeviceServiceImpl extends AbstractService<DwDimOtherDevice> implements DwDimOtherDeviceService {

	@Resource
	private DwDimOtherDeviceMapper dwDimOtherDeviceMapper;

	@Override
	public List<DwDimOtherDevice> getDevicesBy(DwDimOtherDeviceVo vo) {
		return dwDimOtherDeviceMapper.getDevices(vo);
	}

	@Override
	public List<DwDimOtherDevice> getDeviceInfoByBusUuid(String busUuid) {
		return dwDimOtherDeviceMapper.getDeviceInfoByBusUuid(busUuid);
	}

	@Override
	public List<DwDimOtherDevice> getDeviceInfoByDevCode(String devCode) {
		return dwDimOtherDeviceMapper.getDeviceInfoByDevCode(devCode);
	}

	@Override
	public List<DwDimOtherDevice> getNoBindDevCodeList(String devUuid, String devClass) {
		return dwDimOtherDeviceMapper.getNoBindDevCodeList(devUuid, devClass);
	}

	@Override
	public Integer getBindDevCodeByDevClass(String typeValue, String typeCode) {
		return dwDimOtherDeviceMapper.getBindDevCodeByDevClass(typeValue, typeCode);
	}

	/**
	 * 获取设备信息字典
	 * 
	 * @return
	 */
	public Map<String, String> devInfoMap() {
		List<DwDimOtherDevice> selectAll = dwDimOtherDeviceMapper.selectAll();
		if (CollectionUtils.isEmpty(selectAll)) {
			return Collections.emptyMap();
		}
		Map<String, String> disc = new HashMap<>();
		for (DwDimOtherDevice bean : selectAll) {
			String devUuid = bean.getDevUuid();
			if (!disc.containsKey(devUuid)) {
				disc.put(devUuid, bean.getDevCode());
			}
		}
		return disc;
	}
}
