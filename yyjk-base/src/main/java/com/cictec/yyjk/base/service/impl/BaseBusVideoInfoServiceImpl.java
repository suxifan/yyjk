package com.cictec.yyjk.base.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cictec.yyjk.base.mapper.BaseBusVideoInfoMapper;
import com.cictec.yyjk.base.model.entity.BaseBusVideoInfo;
import com.cictec.yyjk.base.model.entity.Bus;
import com.cictec.yyjk.base.model.vo.BaseBusVideoInfoVo;
import com.cictec.yyjk.base.service.BaseBusVideoInfoService;
import com.cictec.yyjk.base.service.BusService;
import com.cictec.yyjk.commons.core.AbstractService;


/**
 * Created by xpguo on 2019/11/13.
 */
@Service
@Transactional
public class BaseBusVideoInfoServiceImpl extends AbstractService<BaseBusVideoInfo> implements BaseBusVideoInfoService {

	@Resource
    private BaseBusVideoInfoMapper baseBusVideoInfoMapper;
	@Resource
	private BusService busService;

	/**
	 * 批量更新,更新成功：返回值非负数，更新失败：-1
	 * 
	 * @param baseBusVideoInfos
	 * @return
	 */
	public int updateList(List<BaseBusVideoInfo> baseBusVideoInfos) {
		if (baseBusVideoInfos == null) {
			return 0;
		}
		try {
			for (BaseBusVideoInfo bean : baseBusVideoInfos) {
				baseBusVideoInfoMapper.updateByPrimaryKey(bean);
			}
		} catch (Exception e) {
			return -1;
		}
		return 1;
	}

	@Override
	public List<BaseBusVideoInfo> queryBusVideos(BaseBusVideoInfoVo vo) throws Exception {
		return baseBusVideoInfoMapper.queryBusVideos(vo);
	}

	@Override
	public void batchSet(List<BaseBusVideoInfo> datas) throws Exception {
		List<BaseBusVideoInfo> inserts = new ArrayList<>();
		List<BaseBusVideoInfo> updates = new ArrayList<>();
		if (datas != null && datas.size() > 0) {
			Map<String, Bus> busDic = busService.getBusDic();
			for (BaseBusVideoInfo bean : datas) {
				bean.setCreateTime(new Date());
				Bus bus = busDic.get(bean.getBusPlateNumber());
				if (bus != null) {
					bean.setBusUuid(bus.getBusUuid());
					// 根据车辆uuid查询是否该车已设置视频位置信息
					BaseBusVideoInfo record = new BaseBusVideoInfo();
					record.setBusUuid(bus.getBusUuid());
					BaseBusVideoInfo entity = baseBusVideoInfoMapper.selectOne(record);
					if (entity != null) {
						bean.setUuid(entity.getUuid());
						updates.add(bean);
					} else {
						inserts.add(bean);
					}
				} else {
					inserts.add(bean);
				}
			}
		}
		if (inserts.size() > 0) {
			insertList(inserts);
		}
		if (updates.size() > 0) {
			updateList(updates);
		}
	}

	@Override
	public Map<String, BaseBusVideoInfo> getBusVideoDisc() {
		List<BaseBusVideoInfo> list = baseBusVideoInfoMapper.selectAll();
		if (list == null) {
			return Collections.emptyMap();
		}
		Map<String, BaseBusVideoInfo> disc = new HashMap<>();
		for (BaseBusVideoInfo item : list) {
			String key = item.getBusUuid();
			if (!disc.containsKey(key)) {
				disc.put(key, item);
			}
		}
		return disc;
	}
}