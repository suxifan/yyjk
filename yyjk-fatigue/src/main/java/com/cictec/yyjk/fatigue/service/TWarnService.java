package com.cictec.yyjk.fatigue.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.cictec.yyjk.base.model.vo.TreeNode2;
import com.cictec.yyjk.commons.core.Service;
import com.cictec.yyjk.fatigue.common.base.BaseTreeNode;
import com.cictec.yyjk.fatigue.model.entity.TWarn;
import com.cictec.yyjk.fatigue.model.vo.QueryCondition;
import com.cictec.yyjk.fatigue.model.vo.TWarnVo;
import com.cictec.yyjk.fatigue.model.vo.TWarnsAnalysisDto;

/**
 * Created by Rwq on 2019/05/22.
 */
public interface TWarnService extends Service<TWarn> {

	/**
	 * <p>
	 * Description: 疲劳检测列表
	 * </p>
	 * <p>
	 * Function: selectWarnPlatfromPage
	 * </p>
	 *
	 */
	List<TWarn> selectWarnPlatfromPage(TWarnVo vo);

	/**
	 * 获取前10分钟报警信息
	 * 
	 * @return
	 */
	List<TWarn> getWarnInfo();

	/**
	 * <p>
	 * Description: 报警中心列表详情
	 * </p>
	 * <p>
	 * Function: warnInfoDetailGet
	 * </p>
	 *
	 */
	TWarn warnInfoDetailGet(TWarnVo vo);

	Date getWarnTimeByUuid(String warnUuid);

	// 组织线路车辆树
	List<TreeNode2> orgLineBusTreeGet(TWarnVo vo);

	// 组织线路车辆树
	List<BaseTreeNode> orgLineBusTreeGet2(TWarnVo vo);

	/**
	 * <p>
	 * Description: 报警等级占比
	 * </p>
	 * <p>
	 * Function: getWarnLevelPie
	 * </p>
	 *
	 */
	List<TWarnsAnalysisDto> getWarnLevelPie(TWarnVo vo);

	/**
	 * <p>
	 * Description: 查询车辆报警级别数量列表
	 * </p>
	 * <p>
	 * Function: getWarnLevelNumToBusPage
	 * </p>
	 *
	 */
	List<TWarnsAnalysisDto> getWarnLevelNumToBusPage(TWarnVo vo);

	/**
	 * <p>
	 * Description: 查询报警类型数量
	 * </p>
	 * <p>
	 * Function: getWarnTypeNum
	 * </p>
	 *
	 */
	List<TWarnsAnalysisDto> getWarnTypeNum(TWarnVo vo);

	/**
	 * <p>
	 * Description: 报警次数趋势环比
	 * </p>
	 * <p>
	 * Function: getWarnNumByDate
	 * </p>
	 *
	 */
	List<TWarnsAnalysisDto> getWarnNumByDate(TWarnVo vo);

	/**
	 * 根据设备号获取指定记录数的报警详情
	 * 
	 * @param deviceCode
	 * @param total
	 * @return
	 */
	List<TWarn> getLimitWarnInfoDetail(String deviceCode, List<String> auditStatus, List<String> handleResults,
			Integer total);

	/**
	 * 根据车牌号查车辆设备号
	 * 
	 * @param busPlateNumber
	 */
	String getDevCodeByBusPlateNumber(String busPlateNumber);

	void updateWarnCc(TWarn vo);

	/**
	 * 根据设备号查找抓拍 图片
	 * 
	 * 
	 */
	List<TWarn> getWarnFigndetail(String devCode, Timestamp warnTime);

	/**
	 * 车辆运营监控树结构
	 * 
	 */
	public Map orgLineBusTreeGet3(QueryCondition queryCondition);

	/**
	 * 车辆在线状态
	 * 
	 */
	public List<Map> selectDevstatus();

	/**
	 * 查询当日车辆客流累积
	 */
	public Integer getTotalPerson(String busNumber, String samplingTime);

	/**
	 * 查询趟次车辆客流累积
	 */
	public Integer getCurrentPerson(String busNumber, String samplingTime, String currenttrip);

	public Object listPiplePic(Map map);

}
