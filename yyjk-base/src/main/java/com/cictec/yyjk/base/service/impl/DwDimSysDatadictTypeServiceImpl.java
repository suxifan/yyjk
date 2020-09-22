package com.cictec.yyjk.base.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cictec.yyjk.base.mapper.DwDimSysDatadictTypeMapper;
import com.cictec.yyjk.base.model.entity.DwDimSysDatadictType;
import com.cictec.yyjk.base.model.vo.DwDimSysDatadictTypeVo;
import com.cictec.yyjk.base.service.DwDimSysDatadictTypeService;
import com.cictec.yyjk.commons.core.AbstractService;
import com.cictec.yyjk.commons.utils.PMSUtils;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;


/**
 * Created by xpguo on 2019/08/29.
 */
@Service
@Transactional
public class DwDimSysDatadictTypeServiceImpl extends AbstractService<DwDimSysDatadictType> implements DwDimSysDatadictTypeService {

    @Resource
    private DwDimSysDatadictTypeMapper dwDimSysDatadictTypeMapper;

	@Override
	public List<DwDimSysDatadictType> selectByVo(DwDimSysDatadictTypeVo vo) {
		Example example = new Example(DwDimSysDatadictType.class);
		Criteria criteria = example.createCriteria();
		if (PMSUtils.isNotEmpty(vo.getTypeCode())) {
			criteria.andLike("typeCode", "%" + vo.getTypeCode() + "%");
		}
		if (PMSUtils.isNotEmpty(vo.getIsvalid())) {
			criteria.andEqualTo("isvalid", vo.getIsvalid());
		}
		example.setOrderByClause("create_time DESC");

		return dwDimSysDatadictTypeMapper.selectByExample(example);
	}

}
