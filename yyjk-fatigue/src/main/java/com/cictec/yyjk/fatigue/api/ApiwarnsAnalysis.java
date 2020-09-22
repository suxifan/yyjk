package com.cictec.yyjk.fatigue.api;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cictec.yyjk.commons.core.Result;
import com.cictec.yyjk.commons.core.ResultUtil;
import com.cictec.yyjk.fatigue.model.vo.TWarnVo;
import com.cictec.yyjk.fatigue.model.vo.TWarnsAnalysisDto;
import com.cictec.yyjk.fatigue.service.TWarnService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 报警分析Control Created by Rwq on 2019/05/28.
 */
@RestController
@RequestMapping("/warnsAnalysis")
public class ApiwarnsAnalysis {
	private static final Logger LOG = LoggerFactory.getLogger(ApiwarnsAnalysis.class);
	
    @Resource
	private TWarnService tWarnService; // 报警server
    
    
	/**
	 * 报警分析-等级占比
	 */
	@PostMapping("/warnPie/echar/get")
	public Result warnPieEchar(@RequestBody TWarnVo vo) {
		Result result = null;
		try {
			if(StringUtils.isNotEmpty(vo.getOrgId()) && "1".equals(vo.getOrgId())){
				vo.setOrgId(null);
			}
			List<TWarnsAnalysisDto> list = tWarnService.getWarnLevelPie(vo);
			result = ResultUtil.getSuccessResult(list);
		} catch (Exception e) {
			LOG.error("报警分析-等级占比异常，原因{}", e);
			result = ResultUtil.getFailResult();
		}
        return result;
	}
	
	/**
	 * 报警分析-列表
	 */
	@PostMapping("/warnLevelPage/get")
	public Result warnLevelPage(@RequestBody TWarnVo vo) {
		Result result = null;
		try {
			PageHelper.startPage(vo.getPageNum(), vo.getPageSize());
			if(StringUtils.isNotEmpty(vo.getOrgId()) && "1".equals(vo.getOrgId())){
				vo.setOrgId(null);
			}
			List<TWarnsAnalysisDto> list = tWarnService.getWarnLevelNumToBusPage(vo);
			result = ResultUtil.getSuccessResult(new PageInfo<TWarnsAnalysisDto>(list));
		} catch (Exception e) {
			LOG.error("报警分析-列表异常，原因{}", e);
			result = ResultUtil.getFailResult();
		}
        return result;
	}
	
	
	/**
	 * 报警分析-报警排序
	 */
	@PostMapping("/warnSort/echar/get")
	public Result warnSortEchar(@RequestBody TWarnVo vo) {
		Result result = null;
		try {
			if(StringUtils.isNotEmpty(vo.getOrgId()) && "1".equals(vo.getOrgId())){
				vo.setOrgId(null);
			}
			List<TWarnsAnalysisDto> list = tWarnService.getWarnTypeNum(vo);
			result = ResultUtil.getSuccessResult(list);
		} catch (Exception e) {
			LOG.error("报警分析-报警排序异常，原因{}", e);
			result = ResultUtil.getFailResult();
		}
        return result;
	}
	
	
	/**
	 * 报警分析-次数趋势折线图
	 */
	@PostMapping("/warnLine/echar/get")
	public Result warnLineEchar(@RequestBody TWarnVo vo) {
		Result result = null;
		try {
			if(StringUtils.isNotEmpty(vo.getOrgId()) && "1".equals(vo.getOrgId())){
				vo.setOrgId(null);
			}
			List<TWarnsAnalysisDto> list = tWarnService.getWarnNumByDate(vo);
			result = ResultUtil.getSuccessResult(list);
		} catch (Exception e) {
			LOG.error("报警分析-次数趋势折线图异常，原因{}", e);
			result = ResultUtil.getFailResult();
		}
        return result;
	}
	
	
	
}
