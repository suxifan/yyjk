package com.cictec.yyjk.base.service.impl;

import com.cictec.yyjk.base.mapper.BaseAccessPageLogMapper;
import com.cictec.yyjk.base.model.entity.BaseAccessPageLog;
import com.cictec.yyjk.base.model.vo.BaseAccessPageLogVo;
import com.cictec.yyjk.base.service.BaseAccessPageLogService;
import com.cictec.yyjk.commons.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import javax.annotation.Resource;


/**
 * Created by xpguo on 2020/04/13.
 */
@Service
@Transactional
public class BaseAccessPageLogServiceImpl extends AbstractService<BaseAccessPageLog> implements BaseAccessPageLogService {

    @Resource
    private BaseAccessPageLogMapper baseAccessPageLogMapper;

	public List<BaseAccessPageLog> getAccessPageLogs(BaseAccessPageLogVo vo) {
		return baseAccessPageLogMapper.getAccessPageLogs(vo);
	}
}
