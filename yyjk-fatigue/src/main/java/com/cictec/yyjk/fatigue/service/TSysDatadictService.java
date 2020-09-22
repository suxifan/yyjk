package com.cictec.yyjk.fatigue.service;

import java.util.List;
import java.util.Map;

import com.cictec.yyjk.base.model.entity.BaseUserInfo;
import com.cictec.yyjk.commons.core.Service;
import com.cictec.yyjk.fatigue.model.entity.TSysDatadict;
import com.cictec.yyjk.fatigue.model.vo.CommonVo;
import com.cictec.yyjk.fatigue.model.vo.TSysDatadictVo;

/**
 * Created by Rwq on 2019/05/22.
 */
public interface TSysDatadictService extends Service<TSysDatadict> {

	/**
	 * <p>
	 * Description: 报警列表查询
	 * </p>
	 * <p>
	 * Function: selectWarnTypeList
	 * </p>
	 * <p>
	 * return value:List<TSysDatadict>
	 * </p>
	 * <p>
	 * 
	 * @param vo
	 *            <p>
	 * @return
	 *         </p>
	 *         <p>
	 *         throws Exception:
	 *         </p>
	 *         <p>
	 *         History: 2019年5月22日 下午4:19:23 Rwq
	 *         </p>
	 *
	 */
	List<TSysDatadict> selectWarnTypeList(TSysDatadictVo vo);

	List<CommonVo> selectList(TSysDatadictVo vo, BaseUserInfo userInfo);

	/**
	 * 根据疲劳值获取疲劳配置信息
	 * 
	 * @param list
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	List<Map> queryByValues(List<String> list);

	/**
	 * 查询所有疲劳配置信息
	 * 
	 * @param list
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	List<Map> queryAll();

	/**
	 * 报警类型字典 code-name键值对
	 */

	Map<String, String> warnTypeDisc();
	
	
	List<TSysDatadict> selectWarnTypeNotEqualNow(TSysDatadict entiy);
}
