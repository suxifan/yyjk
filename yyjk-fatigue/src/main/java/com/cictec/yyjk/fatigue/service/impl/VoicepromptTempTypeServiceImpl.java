package com.cictec.yyjk.fatigue.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cictec.yyjk.commons.core.AbstractService;
import com.cictec.yyjk.fatigue.mapper.VoicepromptTempTypeMapper;
import com.cictec.yyjk.fatigue.model.entity.VoicepromptTemp;
import com.cictec.yyjk.fatigue.model.entity.VoicepromptTempType;
import com.cictec.yyjk.fatigue.model.vo.VoicepromptTempTypeVo;
import com.cictec.yyjk.fatigue.service.VoicepromptTempTypeService;

/**
 * Created by xpguo on 2020/07/21.
 */
@Service
@Transactional
public class VoicepromptTempTypeServiceImpl extends AbstractService<VoicepromptTempType>
		implements VoicepromptTempTypeService {

	@Resource
	private VoicepromptTempTypeMapper dwVoicepromptTempTypeMapper;

	/**
	 * 获取提醒类型数据
	 * 
	 * @param vo
	 * @return
	 */
	public List<VoicepromptTempType> selectVoicepromptType(VoicepromptTempTypeVo vo) {
		return dwVoicepromptTempTypeMapper.selectVoicepromptType(vo);
	}

	/**
	 * 根据提醒类型ID查询提醒内容列表
	 */
	public List<VoicepromptTemp> getVmContentsByVtUuid(VoicepromptTempTypeVo vo) {
		return dwVoicepromptTempTypeMapper.getVmContentsByVtUuid(vo);
	}

}
