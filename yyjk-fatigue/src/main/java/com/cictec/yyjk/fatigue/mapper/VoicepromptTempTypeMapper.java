package com.cictec.yyjk.fatigue.mapper;

import java.util.List;

import com.cictec.yyjk.commons.core.Mapper;
import com.cictec.yyjk.fatigue.model.entity.VoicepromptTemp;
import com.cictec.yyjk.fatigue.model.entity.VoicepromptTempType;
import com.cictec.yyjk.fatigue.model.vo.VoicepromptTempTypeVo;

public interface VoicepromptTempTypeMapper extends Mapper<VoicepromptTempType> {

	List<VoicepromptTempType> selectVoicepromptType(VoicepromptTempTypeVo vo);

	List<VoicepromptTemp> getVmContentsByVtUuid(VoicepromptTempTypeVo vo);

}