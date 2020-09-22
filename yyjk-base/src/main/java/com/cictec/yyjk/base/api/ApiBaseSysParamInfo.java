package com.cictec.yyjk.base.api;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cictec.yyjk.base.interceptors.AccessLogInfo;
import com.cictec.yyjk.base.model.entity.BaseSysParamInfo;
import com.cictec.yyjk.base.model.vo.BaseSysParamInfoVo;
import com.cictec.yyjk.base.service.BaseSysParamInfoService;
import com.cictec.yyjk.commons.core.Result;
import com.cictec.yyjk.commons.core.ResultUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 系统参数---参数配置 Created by xpguo on 2019/11/07.
 */
@RestController
@RequestMapping("/api/base/sys/param/info")
public class ApiBaseSysParamInfo {
	private static final Logger LOG = LoggerFactory.getLogger(ApiBaseSysParamInfo.class);
	@Resource
	private BaseSysParamInfoService baseSysParamInfoService;

	@PostMapping("/add")
	public Result add(@RequestBody BaseSysParamInfo baseSysParamInfo) {
		Result result = null;
		try {
			// 1.先进行校验，
			BaseSysParamInfo param = new BaseSysParamInfo();
			param.setParamName(baseSysParamInfo.getParamName());
			int i = baseSysParamInfoService.selectCount(param);
			if (i > 0) {// 说明当前的编号的系统参数已存在，不能继续添加
				result = ResultUtil.getErrorResult("当前报警类型等级速度设置已存在，不能继续添加");
			} else {// 校验成功，继续添加
					// 2.在进行新增
				// baseSysParamInfo.setSysUuid(SidUtils.getSid());
				// baseSysParamInfo.setCrateTime(new Date());
				baseSysParamInfoService.insertSelective(baseSysParamInfo);
				result = ResultUtil.getSuccessResult();
			}
		} catch (Exception ex) {
			LOG.error("新增报警等级速度设置失败，原因{}", ex);
			result = ResultUtil.getErrorResult();
		}
		return result;
	}

	@PostMapping("/delete")
	public Result delete(@RequestBody BaseSysParamInfo baseSysParamInfo) {
		Result result = null;
		try {
			baseSysParamInfoService.deleteByPrimaryKey(baseSysParamInfo.getSysUuid());
			result = ResultUtil.getSuccessResult();
		} catch (Exception ex) {
			LOG.error("删除报警等级速度设置失败，原因{}", ex);
			result = ResultUtil.getErrorResult();
		}
		return result;
	}

	@PostMapping("/update")
	public Result update(@RequestBody BaseSysParamInfo baseSysParamInfo) {
		Result result = null;
		try {
			baseSysParamInfoService.updateByPrimaryKey(baseSysParamInfo);
			result = ResultUtil.getSuccessResult();
		} catch (Exception ex) {
			LOG.error("更新报警等级速度设置失败，原因{}", ex);
			result = ResultUtil.getErrorResult();
		}
		return result;

	}

	@AccessLogInfo(modelName = "系统管理", pageName = "报警等级速度设置")
	@PostMapping("/parampage/get")
	public Result pageList(@RequestBody BaseSysParamInfoVo baseSysParamInfoVo) {
		Result result = null;
		try {
			PageHelper.startPage(baseSysParamInfoVo.getPageNumber(), baseSysParamInfoVo.getPageSize());
			List<BaseSysParamInfo> list = baseSysParamInfoService.getBaseSysParamInfoByExample(baseSysParamInfoVo);
			return ResultUtil.getSuccessResult(new PageInfo<BaseSysParamInfo>(list));
		} catch (Exception ex) {
			LOG.error("分页查询报警等级速度设置失败，原因{}", ex);
			result = ResultUtil.getErrorResult();
		}
		return result;

	}

}
