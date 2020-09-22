package com.cictec.yyjk.base.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cictec.yyjk.base.mapper.BusMapper;
import com.cictec.yyjk.base.mapper.DwDimOtherBusDeviceMapper;
import com.cictec.yyjk.base.model.entity.BaseUserInfo;
import com.cictec.yyjk.base.model.entity.Bus;
import com.cictec.yyjk.base.model.entity.BusLine;
import com.cictec.yyjk.base.model.entity.BusSysOrg;
import com.cictec.yyjk.base.model.entity.DwDimOtherBusDevice;
import com.cictec.yyjk.base.model.entity.DwDimOtherDevice;
import com.cictec.yyjk.base.model.vo.BusDeviceVo;
import com.cictec.yyjk.base.model.vo.BusVo;
import com.cictec.yyjk.base.service.BusLineService;
import com.cictec.yyjk.base.service.BusService;
import com.cictec.yyjk.base.service.BusSysOrgService;
import com.cictec.yyjk.base.service.DwDimOtherDeviceService;
import com.cictec.yyjk.commons.core.AbstractService;
import com.cictec.yyjk.commons.utils.BaseTreeNode;
import com.cictec.yyjk.commons.utils.PMSUtils;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

/**
 * Created by xpguo on 2019/05/20.
 */
@Service
@Transactional
public class BusServiceImpl extends AbstractService<Bus> implements BusService {

	@Resource
	private BusMapper busMapper;

	@Autowired
	private DwDimOtherBusDeviceMapper dwDimOtherBusDeviceMapper;

	@Autowired
	private DwDimOtherDeviceService dwDimOtherDeviceService;

	@Autowired
	private BusSysOrgService busOrgService;

	@Autowired
	private BusLineService busLineService;

	@Override
	public List<Bus> getBusByExample(BusVo busVo) {
		Example example = new Example(Bus.class);
		Criteria criteria = example.createCriteria();
		if (PMSUtils.isNotEmpty(busVo.getOrgId())) {
			criteria.andEqualTo("busOrgUuid", busVo.getOrgId());
		}
		if (PMSUtils.isNotEmpty(busVo.getLineId())) {
			criteria.andEqualTo("busLineUuid", busVo.getLineId());
		}
		criteria.andEqualTo("busIsvalid", "1");
		criteria.andEqualTo("busDropFlag", "0");
		return busMapper.selectByExample(example);
	}

	@Override
	public Integer getTotalBus(String orgId) {
		return busMapper.getTotalBus(orgId);
	}

	@Override
	public Bus getBusInfo(String busPlateNumber) {
		return busMapper.getBusInfo(busPlateNumber);
	}

	@Override
	public String getBusDevRefId(String busUuid) {
		return busMapper.getBusDevRefId(busUuid);
	}

	@Override
	public List<Bus> getBusesBy(BusVo vo) {
		List<Bus> busList = busMapper.getBuses(vo);
		return busList;
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public List<Bus> getSafeBuses(BusVo vo) {
		List<Bus> busList = busMapper.getBuses(vo);
		// 设置车辆的安全的下发信息
		List<Map> voices = busMapper.selectvoiceprompt();
		Map<String, List<Map>> disc = new HashMap<>();
		if (CollectionUtils.isNotEmpty(voices)) {
			for (Map item : voices) {
				String key = (String)item.get("bus_uuid");
				if (disc.keySet().contains(key)) {
					disc.get(key).add(item);
				} else {
					List<Map> cList = new ArrayList<>();
					cList.add(item);
					disc.put(key, cList);
				}
			}
		}

		for (Bus bus : busList) {
			List<Map> list = disc.get(bus.getBusUuid());
			if (CollectionUtils.isNotEmpty(list)) {
				bus.setVoiceMap(list);
			} else {
				bus.setVoiceMap(new ArrayList<>());
			}
		}
		
		return busList;
	}

	@Override
	public void bindingBusDeviceInfo(Bus bus, BaseUserInfo userInfo) throws Exception {
		// 车辆设备绑定表，先清除绑定关系，再将新的绑定关系入库
		DwDimOtherBusDevice entity = new DwDimOtherBusDevice();
		entity.setBusUuid(bus.getBusUuid());
		dwDimOtherBusDeviceMapper.delete(entity);
		List<DwDimOtherDevice> deviceList = bus.getDeviceList();
		if (deviceList != null && deviceList.size() > 0) {
			// 绑定设备车辆关系
			List<DwDimOtherBusDevice> targetList = new ArrayList<>();
			for (DwDimOtherDevice bean : deviceList) {
				DwDimOtherBusDevice item = new DwDimOtherBusDevice();
				item.setBusUuid(bus.getBusUuid());
				item.setDevUuid(bean.getDevUuid());
				item.setCreateUser(userInfo.getUserAccount());
				item.setCreateTime(new Date());
				targetList.add(item);
			}
			dwDimOtherBusDeviceMapper.insertList(targetList);

			// 更新设备信息车牌号
			for (DwDimOtherDevice bean : deviceList) {
				bean.setDevBusPlateNumber(bus.getBusPlateNumber());
				dwDimOtherDeviceService.updateByPrimaryKeySelective(bean);
			}
		}
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Map getBusInfoByVo(BusDeviceVo vo) {
		return busMapper.getBusInfoByVo(vo);
	}

	@Override
	public List<Map<String, String>> getBusOrgInfo() {
		return busMapper.getBusOrgInfo();
	}

	@Override
	public Map<String, Bus> getBusDic() {
		List<Bus> busList = busMapper.selectAll();
		if (busList == null) {
			return Collections.emptyMap();
		}
		Map<String, Bus> resultMap = new HashMap<>();
		Iterator<Bus> iterator = busList.iterator();
		while (iterator.hasNext()) {
			Bus next = iterator.next();
			String key = next.getBusPlateNumber();
			if (!resultMap.containsKey(key)) {
				resultMap.put(key, next);
			}
		}
		return resultMap;
	}

	@Override
	public List<Bus> getMinieyeBus(BusVo vo) {
		String[] lineIds = vo.getLineIds();
		String lineIdsStr = "";
		if (lineIds != null && lineIds.length > 0) {
			for (int i = 0; i < lineIds.length; i++) {
				lineIdsStr += "'" + lineIds[i] + "',";
			}
		}
		vo.setLineIdsStr(StringUtils.removeEnd(lineIdsStr, ","));
		List<Bus> busList = busMapper.getMinieyeBus(vo);
		return busList;
	}

	@Override
	public List<Bus> getBusByLineIds(List<String> lineUuids) {
		return busMapper.getBusByLineIds(lineUuids);
	}

	@Override
	public List<BaseTreeNode> getBus() {
		// TODO Auto-generated method stub
		// 机构
		List<BaseTreeNode> basetree = new ArrayList<BaseTreeNode>();
		List<BusSysOrg> orglist = busOrgService.selectAll();
		for (BusSysOrg orglists : orglist) {
			// 排序线路上的机构信息
			BaseTreeNode besat = new BaseTreeNode();
			besat.setId(orglists.getOrgUuid());
			besat.setName(orglists.getOrgName());
			besat.setpId(orglists.getOrgParentUuid());
			besat.setChecked(false);
			Map map = new HashMap();
			map.put("lineorguuid", orglists.getOrgUuid());
			BusLine BusLine = new BusLine();
			BusLine.setLineOrgUuid(orglists.getOrgUuid());
			List<BusLine> lists = busLineService.select(BusLine);
			for (int i = 0; i < lists.size(); i++) {
				BusLine line = lists.get(i);
				BaseTreeNode lineBesat = new BaseTreeNode();
				lineBesat.setId(line.getLineUuid());
				lineBesat.setName(line.getLineName());
				lineBesat.setpId(orglists.getOrgUuid());
				lineBesat.setChecked(false);
				basetree.add(lineBesat);
				Map map1 = new HashMap();
				map1.put("busLineUuid", line.getLineUuid());
				Bus bus = new Bus();
				bus.setBusLineUuid(line.getLineUuid());
				List<Bus> tbusList = this.select(bus);
				for (int j = 0; j < tbusList.size(); j++) {
					Bus tbus = tbusList.get(j);
					BaseTreeNode busBesat = new BaseTreeNode();
					busBesat.setId(tbus.getBusUuid());
					busBesat.setName(tbus.getBusSelfCode());
					busBesat.setpId(line.getLineUuid());
					busBesat.setChecked(false);
					basetree.add(busBesat);
				}
			}
			besat.setOpen(true);
			basetree.add(besat);
		}
		return basetree;
	}

	@Override
	public List<Bus> getCarNoList(BusVo vo) {
		return busMapper.getCarNoList(vo);
	}

}
