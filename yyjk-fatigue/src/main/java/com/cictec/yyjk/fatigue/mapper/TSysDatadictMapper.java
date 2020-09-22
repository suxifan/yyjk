package com.cictec.yyjk.fatigue.mapper;

import java.util.List;
import java.util.Map;

import com.cictec.yyjk.commons.core.Mapper;
import com.cictec.yyjk.fatigue.model.entity.TSysDatadict;
import com.cictec.yyjk.fatigue.model.vo.CommonVo;
import com.cictec.yyjk.fatigue.model.vo.TSysDatadictVo;

public interface TSysDatadictMapper extends Mapper<TSysDatadict> {

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

	List<CommonVo> selectList(TSysDatadictVo vo);

	/**
	 * 根据疲劳值获取疲劳配置信息
	 * 
	 * @param list
	 * @return
	 */
	List<Map> queryByValues(List<String> list);

	/**
	 * 查询所有疲劳配置信息
	 * 
	 * @param list
	 * @return
	 */
	List<Map> queryAll();
	
	List<TSysDatadict> selectWarnTypeNotEqualNow(TSysDatadict entiy);
}