package com.cictec.yyjk.fatigue.api;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cictec.yyjk.base.interceptors.AccessLogInfo;
import com.cictec.yyjk.commons.core.Result;
import com.cictec.yyjk.commons.core.ResultUtil;
import com.cictec.yyjk.commons.utils.UUIDGenerator;
import com.cictec.yyjk.fatigue.model.entity.TSysDatadict;
import com.cictec.yyjk.fatigue.model.vo.TSysDatadictVo;
import com.cictec.yyjk.fatigue.service.TSysDatadictService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;


/**
 * 报警类型管理Control Created by Rwq on 2019/05/22.
 */
@RestController
@RequestMapping("/warntype")
public class ApiTSysDatadict {
	private static final Logger LOG = LoggerFactory.getLogger(ApiTSysDatadict.class);
    @Resource
    private TSysDatadictService tSysDatadictService;
    
    /**
	 * 报警类型管理--新增
	 */
    @PostMapping("/create")
    public Result add(@RequestBody TSysDatadict tSysDatadict) {
    	Result result = null;
        try {
        	tSysDatadict.setPlUuid(UUIDGenerator.genUuidStr());
			TSysDatadict record = new TSysDatadict();
			record.setPlValue(tSysDatadict.getPlValue());
			List<TSysDatadict> list = tSysDatadictService.select(record);
			if (CollectionUtils.isNotEmpty(list)) {
				return ResultUtil.getErrorResult(String.format("报警类型编码'%s'已存在!", tSysDatadict.getPlValue()));
			}
            tSysDatadictService.insertSelective(tSysDatadict);
            result = ResultUtil.getSuccessResult();
		} catch (Exception e) {
			LOG.error("新增报警类型异常，原因{}", e);
			result = ResultUtil.getFailResult();
		}
        return result;
    }

    
    /**
	 * 报警类型管理--删除（单删）
	 */
    @PostMapping("/delete")
    public Result delete(@RequestParam String id) {
    	Result result = null;
        try {
			tSysDatadictService.deleteByPrimaryKey(id);
        	result = ResultUtil.getSuccessResult();
		} catch (Exception e) {
			LOG.error("删除报警类型异常，原因{}", e);
			result = ResultUtil.getFailResult();
		}
        return result;
    }

    /**
	 * 报警类型管理--修改
	 */
    @PostMapping("/update")
    public Result update(@RequestBody TSysDatadict tSysDatadict) {
    	Result result = null;
        try {
			TSysDatadict record = new TSysDatadict();
			record.setPlValue(tSysDatadict.getPlValue());
			record.setPlUuid(tSysDatadict.getPlUuid());
			List<TSysDatadict> list = tSysDatadictService.selectWarnTypeNotEqualNow(record);
			if (CollectionUtils.isEmpty(list)) {
				tSysDatadictService.updateByPrimaryKeySelective(tSysDatadict);
			} else {
				return ResultUtil.getErrorResult(String.format("报警类型编码'%s'已存在!", tSysDatadict.getPlValue()));
			}
        	result = ResultUtil.getSuccessResult();
		} catch (Exception e) {
			LOG.error("修改报警类型异常，原因{}", e);
			result = ResultUtil.getFailResult();
		}
        return result;
    }
    
 

    /**
	 * 报警类型管理--启用/禁用
	 */
    @PostMapping("/isvalid/update")
    public Result isvalid(@RequestBody TSysDatadict tSysDatadict) {
    	Result result = null;
        try {
        	tSysDatadictService.updateByPrimaryKeySelective(tSysDatadict);
        	result = ResultUtil.getSuccessResult();
		} catch (Exception e) {
			LOG.error("启用禁用报警类型异常，原因{}", e);
			result = ResultUtil.getFailResult();
		}
        return result;
    }
    
    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        TSysDatadict tSysDatadict = tSysDatadictService.selectByPrimaryKey(id);
        return ResultUtil.getSuccessResult(tSysDatadict);
    }

	@PostMapping("/list")
    public Result list(@RequestBody TSysDatadictVo tSysDatadictVo) {
    
		// 判定是否包含分页参数，如果包含则为分页数据请求
    	if(tSysDatadictVo.getPageSize() != null && tSysDatadictVo.getPageSize() != 0){
    		return pageList(tSysDatadictVo);
    	}
    	
		// TODO 根据具体业务重写
    	List<TSysDatadict> list = tSysDatadictService.select(null);
    	
		return ResultUtil.getSuccessResult(list);
    }
    
	
    /**
	 * 报警类型管理--列表（分页）
	 */
	@AccessLogInfo(modelName = "系统管理", pageName = "报警类型管理")
	@PostMapping("/warnTypePage/get")
	public Result pageList (@RequestBody TSysDatadictVo tSysDatadictVo) {
    	Result result = null;
        try {
    		PageHelper.startPage(tSysDatadictVo.getPageNum(), tSysDatadictVo.getPageSize());
        	List<TSysDatadict> list = tSysDatadictService.selectWarnTypeList(null);
        	result = ResultUtil.getSuccessResult(new PageInfo<TSysDatadict>(list));
		} catch (Exception e) {
			LOG.error("分页查询报警类型异常，原因{}", e);
			result = ResultUtil.getFailResult();
		}
        return result;
	}
	
}
