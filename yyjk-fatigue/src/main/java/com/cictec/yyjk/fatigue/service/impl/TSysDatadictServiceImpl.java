package com.cictec.yyjk.fatigue.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cictec.yyjk.base.model.entity.BaseDataResourceInfo;
import com.cictec.yyjk.base.model.entity.BaseUserInfo;
import com.cictec.yyjk.base.service.BaseUserInfoService;
import com.cictec.yyjk.commons.core.AbstractService;
import com.cictec.yyjk.fatigue.mapper.TSysDatadictMapper;
import com.cictec.yyjk.fatigue.model.entity.TSysDatadict;
import com.cictec.yyjk.fatigue.model.vo.CommonVo;
import com.cictec.yyjk.fatigue.model.vo.TSysDatadictVo;
import com.cictec.yyjk.fatigue.service.TSysDatadictService;

/**
 * Created by Rwq on 2019/05/22.
 */
@Service
@Transactional
public class TSysDatadictServiceImpl extends AbstractService<TSysDatadict> implements TSysDatadictService {

	@Resource
	private TSysDatadictMapper dwDimPlSysDatadictMapper;
	@Autowired
	private BaseUserInfoService baseUserInfoService;

	@Override
	public List<TSysDatadict> selectWarnTypeList(TSysDatadictVo vo) {
		return dwDimPlSysDatadictMapper.selectWarnTypeList(vo);
	}

	@Override
	public List<CommonVo> selectList(TSysDatadictVo vo, BaseUserInfo userInfo) {
		List<CommonVo> list = dwDimPlSysDatadictMapper.selectList(vo);
		List<CommonVo> result = new ArrayList<>();
		if (userInfo != null) {
			List<BaseDataResourceInfo> dataAuths = baseUserInfoService.getDataAuthByUserId(userInfo.getUserId());
			if (dataAuths != null && dataAuths.size() > 0) {
				Set<String> authSet = listToSet(dataAuths);
				Iterator<CommonVo> iterator = list.iterator();
				while (iterator.hasNext()) {
					CommonVo next = iterator.next();
					if (authSet.contains(next.getCode())) {
						result.add(next);
					}
				}
			}
		}
		return result;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List<Map> queryByValues(List<String> list) {
		return dwDimPlSysDatadictMapper.queryByValues(list);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List<Map> queryAll() {
		return dwDimPlSysDatadictMapper.queryAll();
	}

	private Set<String> listToSet(List<BaseDataResourceInfo> dataAuths) {
		Set<String> authsSet = new HashSet<>();
		for (BaseDataResourceInfo baseDataResourceInfo : dataAuths) {
			authsSet.add(baseDataResourceInfo.getDataResourceName());
		}
		return authsSet;
	}

	/**
	 * 报警类型字典 code-name键值对
	 */

	public Map<String, String> warnTypeDisc() {
		List<TSysDatadict> list = dwDimPlSysDatadictMapper.selectAll();
		Map<String, String> disc = new HashMap<>();
		if (CollectionUtils.isEmpty(list)) {
			return Collections.emptyMap();
		}
		for (TSysDatadict tSysDatadict : list) {
			if (!disc.containsKey(tSysDatadict.getPlValue())) {
				disc.put(tSysDatadict.getPlValue(), tSysDatadict.getPlDisplay());
			}
		}
		return disc;
	}

	@Override
	public List<TSysDatadict> selectWarnTypeNotEqualNow(TSysDatadict vo) {
		return dwDimPlSysDatadictMapper.selectWarnTypeNotEqualNow(vo);
	}
}
