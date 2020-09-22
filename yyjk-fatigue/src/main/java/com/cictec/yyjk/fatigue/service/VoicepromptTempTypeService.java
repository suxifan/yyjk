package com.cictec.yyjk.fatigue.service;

import java.util.List;

import com.cictec.yyjk.commons.core.Service;
import com.cictec.yyjk.fatigue.model.entity.VoicepromptTemp;
import com.cictec.yyjk.fatigue.model.entity.VoicepromptTempType;
import com.cictec.yyjk.fatigue.model.vo.VoicepromptTempTypeVo;

/**
 * Created by xpguo on 2020/07/21.
 */
public interface VoicepromptTempTypeService extends Service<VoicepromptTempType> {

	/**
	 * 获取提醒类型数据
	 */
	List<VoicepromptTempType> selectVoicepromptType(VoicepromptTempTypeVo vo);

	/**
	 * 根据提醒类型ID查询提醒内容列表
	 */
	List<VoicepromptTemp> getVmContentsByVtUuid(VoicepromptTempTypeVo vo);

}
