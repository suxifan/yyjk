package com.cictec.yyjk.base.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cictec.yyjk.base.mapper.BaseLoginLogMapper;
import com.cictec.yyjk.base.model.entity.BaseLoginLog;
import com.cictec.yyjk.base.model.view.GridChartOption;
import com.cictec.yyjk.base.model.vo.BaseLoginLogVo;
import com.cictec.yyjk.base.service.BaseLoginLogService;
import com.cictec.yyjk.commons.core.AbstractService;


/**
 * Created by xpguo on 2020/04/02.
 */
@Service
@Transactional
public class BaseLoginLogServiceImpl extends AbstractService<BaseLoginLog> implements BaseLoginLogService {

    @Resource
    private BaseLoginLogMapper baseLoginLogMapper;

	/**
	 * 根据条件获取用户登录登出日志信息
	 * 
	 * @param vo
	 * @return
	 */
	public List<BaseLoginLog> getLoginLogs(BaseLoginLogVo vo) {
		return baseLoginLogMapper.getLoginLogs(vo);
	}

	/**
	 * 
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	public GridChartOption loginLogStatisticAnalysis(Date startTime, Date endTime) {
		List<Map<String, Object>> loginLogs = baseLoginLogMapper.loginLogStatisticAnalysis(startTime,
				endTime);
		if (CollectionUtils.isEmpty(loginLogs)) {
			return new GridChartOption();
		}
		 List<String> xAxisNames = new ArrayList<String>();
		List<Object> userCount = new ArrayList<>();
		List<Object> accessCount = new ArrayList<>();
		for (Map<String, Object> logMap : loginLogs) {
			xAxisNames.add((String) logMap.get("accessTime"));
			userCount.add(logMap.get("userCount"));
			accessCount.add(logMap.get("accessCount"));
		}
		
		List<List<Object>> datas = new ArrayList<>();
		datas.add(userCount);
		datas.add(accessCount);
		GridChartOption option = new GridChartOption();
		option.setDatas(datas);
		option.setxAxisNames(xAxisNames);
		return option;
	}

}
