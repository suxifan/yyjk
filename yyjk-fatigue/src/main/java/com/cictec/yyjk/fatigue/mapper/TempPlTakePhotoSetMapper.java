package com.cictec.yyjk.fatigue.mapper;

import java.util.List;

import com.cictec.yyjk.commons.core.Mapper;
import com.cictec.yyjk.fatigue.model.entity.TempPlTakePhotoSet;
import com.cictec.yyjk.fatigue.model.vo.TempPlTakePhotoSetVo;

public interface TempPlTakePhotoSetMapper extends Mapper<TempPlTakePhotoSet> {
	
	
	/**
	 * <p>
	 * Description: 疲劳检测列表
	 * </p>
	 * <p>
	 * Function: selectTakePhotoSetPage
	 * </p>
	 *
	 */
	List<TempPlTakePhotoSet> selectTakePhotoSetPage(TempPlTakePhotoSetVo vo);
	
	/**
	 * <p>
	 * Description: 获取每天可用的任务
	 * </p>
	 * <p>
	 * Function: selectScheduledList
	 * </p>
	 *
	 */
	List<TempPlTakePhotoSet> selectScheduledList();
}