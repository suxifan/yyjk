package com.cictec.yyjk.fatigue.service;

import java.util.List;
import java.util.Map;

import com.cictec.yyjk.commons.core.Service;
import com.cictec.yyjk.fatigue.model.entity.TDevice;
import com.cictec.yyjk.fatigue.model.vo.TDeviceVo;
import com.github.pagehelper.PageInfo;


/**
 * Created by xpguo on 2019/11/16.
 */
public interface TDeviceService extends Service<TDevice> {
	/**
	 * 设备在线率状态统计
	 */
	Map<String, String> countDeviceStatus(TDeviceVo vo);

	/**
	 * 按条件查询设备在线情况
	 */
	List<TDevice> queryDeviveInfo(TDeviceVo vo);

	/**
	 * 查询设备离线情况，计算离线时间,并按离线时间倒序排序，且将一直没有上线的记录放在最前面
	 */
	List<TDevice> queryDeviveInfoByCountOffLineTime(TDeviceVo vo);

	/**
	 * 内存分页
	 * 
	 */
	PageInfo<TDevice> selfPageList(TDeviceVo vo);
}
