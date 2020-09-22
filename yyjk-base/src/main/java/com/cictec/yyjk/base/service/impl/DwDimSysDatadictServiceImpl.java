package com.cictec.yyjk.base.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cictec.yyjk.base.mapper.DwDimSysDatadictMapper;
import com.cictec.yyjk.base.model.entity.DwDimSysDatadict;
import com.cictec.yyjk.base.model.vo.DwDimSysDatadictVo;
import com.cictec.yyjk.base.service.DwDimSysDatadictService;
import com.cictec.yyjk.commons.core.AbstractService;
import com.cictec.yyjk.commons.utils.PMSUtils;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;


/**
 * Created by xpguo on 2019/08/29.
 */
@Service
@Transactional
public class DwDimSysDatadictServiceImpl extends AbstractService<DwDimSysDatadict> implements DwDimSysDatadictService {

    @Resource
    private DwDimSysDatadictMapper dwDimSysDatadictMapper;

	@Override
	public List<DwDimSysDatadict> selectByVo(DwDimSysDatadictVo vo) {
		Example example = new Example(DwDimSysDatadict.class);
		Criteria criteria = example.createCriteria();
		if (PMSUtils.isNotEmpty(vo.getTypeCode())) {
			criteria.andEqualTo("typeCode", vo.getTypeCode());
		} else {
			criteria.andEqualTo("typeCode", "B005");
		}
		if (PMSUtils.isNotEmpty(vo.getIsvalid())) {
			criteria.andEqualTo("isvalid", vo.getIsvalid());
		}
		example.setOrderByClause("create_time DESC");
		List<DwDimSysDatadict> list = dwDimSysDatadictMapper.selectByExample(example);

		if (list != null && list.size() > 0) {
			for (DwDimSysDatadict bean : list) {
				bean.setTypeName(vo.getTypeName());
			}
		}
		return list;
	}

	@Override
	public List<DwDimSysDatadict> queryDatadicts(String typeCode) {
		return dwDimSysDatadictMapper.queryDatadicts(typeCode);
	}

}
