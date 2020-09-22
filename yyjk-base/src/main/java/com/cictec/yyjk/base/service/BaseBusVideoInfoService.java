package com.cictec.yyjk.base.service;

import java.util.List;
import java.util.Map;

import com.cictec.yyjk.base.model.entity.BaseBusVideoInfo;
import com.cictec.yyjk.base.model.vo.BaseBusVideoInfoVo;
import com.cictec.yyjk.commons.core.Service;


/**
 * Created by xpguo on 2019/11/13.
 */
public interface BaseBusVideoInfoService extends Service<BaseBusVideoInfo> {
	/**
	 * 设备设备批量设置，如果某个批次的车辆已设置，则更新
	 * 
	 * @param datas
	 * @throws Exception
	 */
	public void batchSet(List<BaseBusVideoInfo> datas) throws Exception;

	/**
	 * 批量更新,更新成功：返回值非负数，更新失败：-1
	 * 
	 * @param baseBusVideoInfos
	 * @return
	 */
	public int updateList(List<BaseBusVideoInfo> baseBusVideoInfos);

	/**
	 * 根据条件查询车辆视频配置信息
	 * 
	 * @param vo
	 * @return
	 */
	public List<BaseBusVideoInfo> queryBusVideos(BaseBusVideoInfoVo vo) throws Exception;

	/**
	 * 获取车辆视频配置字典，key为busUUid
	 * 
	 * @return
	 * @throws Exception
	 */
	public Map<String, BaseBusVideoInfo> getBusVideoDisc();
}
