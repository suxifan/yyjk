package com.cictec.yyjk.base.mapper;

import java.util.List;

import com.cictec.yyjk.base.model.entity.BaseBusVideoInfo;
import com.cictec.yyjk.base.model.vo.BaseBusVideoInfoVo;
import com.cictec.yyjk.commons.core.Mapper;

public interface BaseBusVideoInfoMapper extends Mapper<BaseBusVideoInfo> {
	/**
	 * 根据条件查询车辆视频配置信息
	 * 
	 * @param vo
	 * @return
	 */
	public List<BaseBusVideoInfo> queryBusVideos(BaseBusVideoInfoVo vo);

}