package com.cictec.yyjk.fatigue.mapper;

import java.util.List;

import com.cictec.yyjk.commons.core.Mapper;
import com.cictec.yyjk.fatigue.model.entity.TWarnMedia;

public interface TWarnMediaMapper extends Mapper<TWarnMedia> {
	
	//报警中心列表详情   获取报警信息对应的详情信息
	List<TWarnMedia> warnMediaList(String warnUuid);
}