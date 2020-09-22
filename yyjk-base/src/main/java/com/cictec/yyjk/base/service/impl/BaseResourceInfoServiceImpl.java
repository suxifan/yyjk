package com.cictec.yyjk.base.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cictec.yyjk.base.mapper.BaseResourceInfoMapper;
import com.cictec.yyjk.base.mapper.BaseRoleResourceMapper;
import com.cictec.yyjk.base.model.entity.BaseResourceInfo;
import com.cictec.yyjk.base.model.entity.BaseRoleResource;
import com.cictec.yyjk.base.model.vo.BaseResourceInfoVo;
import com.cictec.yyjk.base.service.BaseResourceInfoService;
import com.cictec.yyjk.commons.core.AbstractService;
import com.cictec.yyjk.commons.utils.PMSUtils;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;


/**
 * Created by xpguo on 2019/05/28.
 */
@Service
@Transactional
public class BaseResourceInfoServiceImpl extends AbstractService<BaseResourceInfo> implements BaseResourceInfoService {

    @Resource
    private BaseResourceInfoMapper baseResourceInfoMapper;
	@Resource
	private BaseRoleResourceMapper baseRoleResourceMapper;

	@Override
	public List<BaseResourceInfo> getResourceInfoByVo(BaseResourceInfoVo baseResourceInfoVo) {
		Example example = new Example(BaseResourceInfo.class);
		Criteria criteria = example.createCriteria();
		if (PMSUtils.isNotEmpty(baseResourceInfoVo.getResourceName())) {
			criteria.andLike("resourceName", baseResourceInfoVo.getResourceName());
		}
		if (PMSUtils.isNotEmpty(baseResourceInfoVo.getResourceType())) {
			criteria.andEqualTo("resourceType", baseResourceInfoVo.getResourceType());
		}
		if (PMSUtils.isNotEmpty(baseResourceInfoVo.getResourceTitle())) {
			criteria.andLike("resourceTitle", baseResourceInfoVo.getResourceTitle());
		}
		if (PMSUtils.isNotEmpty(baseResourceInfoVo.getEnabled())) {
			criteria.andEqualTo("enabled", baseResourceInfoVo.getEnabled());
		}
		if (PMSUtils.isNotEmpty(baseResourceInfoVo.getStartTime())) {
			criteria.andGreaterThanOrEqualTo("updateTime", baseResourceInfoVo.getStartTime());
		}
		if (PMSUtils.isNotEmpty(baseResourceInfoVo.getEndTime())) {
			criteria.andLessThanOrEqualTo("updateTime", baseResourceInfoVo.getEndTime());
		}
		example.setOrderByClause(" resource_sort desc");
		return baseResourceInfoMapper.selectByExample(example);
	}

	public void addResource(BaseResourceInfo baseResourceInfo) {
		baseResourceInfoMapper.insertSelective(baseResourceInfo);
		BaseRoleResource record = new BaseRoleResource();
		record.setCreateTime(new Date());
		record.setRoleId("1");
		record.setResourceId(baseResourceInfo.getResourceId());
		record.setCreateUser("admin");
		baseRoleResourceMapper.insertSelective(record);
	}

}
