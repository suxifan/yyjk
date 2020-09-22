package com.cictec.yyjk.fatigue.service;

import com.cictec.yyjk.fatigue.model.entity.TempPlTakePhotoSet;
import com.cictec.yyjk.fatigue.model.vo.TempPlTakePhotoSetVo;

import java.util.List;

import com.cictec.yyjk.commons.core.Service;


/**
 * Created by Rwq on 2020/03/10.
 */
public interface TempPlTakePhotoSetService extends Service<TempPlTakePhotoSet> {
	
	/**
	 * <p>
	 * Description: 设备抓拍列表
	 * </p>
	 * <p>
	 * Function: selectTakePhotoSetPage
	 * </p>
	 *
	 */
	List<TempPlTakePhotoSet> selectTakePhotoSetPage(TempPlTakePhotoSetVo vo);
	
	/**
	 * <p>
	 * Description: 设备手动抓拍设置
	 * </p>
	 * <p>
	 * Function: devByManual
	 * </p>
	 *
	 */
	void devByManual(TempPlTakePhotoSetVo vo);
	
	/**
	 * <p>
	 * Description: 设备抓拍设置保存
	 * </p>
	 * <p>
	 * Function: saveDevTakePhoto
	 * </p>
	 *
	 */
	void saveDevTakePhoto(TempPlTakePhotoSet vo);
	
	
	/**
	 * <p>
	 * Description: 设备抓拍设置修改保存
	 * </p>
	 * <p>
	 * Function: updateDevTakePhoto
	 * </p>
	 *
	 */
	void updateDevTakePhoto(TempPlTakePhotoSet vo);
	
	/**
	 * <p>
	 * Description: 设备抓拍设置删除保存
	 * </p>
	 * <p>
	 * Function: deleteDevTakePhoto
	 * </p>
	 *
	 */
	void deleteDevTakePhoto(String takePhotoUuid);
	
	/**
	 * <p>
	 * Description: 加载可用定时任务
	 * </p>
	 * <p>
	 * Function: loadTakePhotoScheduledTask
	 * </p>
	 *
	 */
	void loadTakePhotoScheduledTask();
}
