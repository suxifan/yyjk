package com.cictec.yyjk.base.api;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cictec.yyjk.base.model.entity.BaseDataResourceInfo;
import com.cictec.yyjk.base.model.vo.BaseDataResourceInfoVo;
import com.cictec.yyjk.base.service.BaseDataResourceInfoService;
import com.cictec.yyjk.commons.core.Result;
import com.cictec.yyjk.commons.core.ResultUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;


/**
* Created by xpguo on 2019/11/18.
*/
@RestController
@RequestMapping("/api/base/data/resource/info")
public class ApiBaseDataResourceInfo {
    @Resource
    private BaseDataResourceInfoService baseDataResourceInfoService;

    @PostMapping("/add")
    public Result add(@RequestBody BaseDataResourceInfo baseDataResourceInfo) {
        baseDataResourceInfoService.insertSelective(baseDataResourceInfo);
        return ResultUtil.getSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        baseDataResourceInfoService.deleteByPrimaryKey(id);
        return ResultUtil.getSuccessResult();
    }

    @PostMapping("/update")
    public Result update(@RequestBody BaseDataResourceInfo baseDataResourceInfo) {
        baseDataResourceInfoService.updateByPrimaryKeySelective(baseDataResourceInfo);
        return ResultUtil.getSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        BaseDataResourceInfo baseDataResourceInfo = baseDataResourceInfoService.selectByPrimaryKey(id);
        return ResultUtil.getSuccessResult(baseDataResourceInfo);
    }

	@PostMapping("/list")
    public Result list(@RequestBody BaseDataResourceInfoVo baseDataResourceInfoVo) {
		// 判定是否包含分页参数，如果包含则为分页数据请求
    	if(baseDataResourceInfoVo.getPageSize() != null && baseDataResourceInfoVo.getPageSize() != 0){
    		return pageList(baseDataResourceInfoVo);
    	}
    	List<BaseDataResourceInfo> list = baseDataResourceInfoService.select(null);
    	
		return ResultUtil.getSuccessResult(list);
    }
    
	@PostMapping("/pageList")
	public Result pageList (@RequestBody BaseDataResourceInfoVo baseDataResourceInfoVo) {
		// 分页数据请求处理
		PageHelper.startPage(baseDataResourceInfoVo.getPageNumber(), baseDataResourceInfoVo.getPageSize());
		// TODO 根据具体业务重写
    	List<BaseDataResourceInfo> list = baseDataResourceInfoService.select(null);
    	return ResultUtil.getSuccessResult(new PageInfo<BaseDataResourceInfo>(list));
	}
	
}
