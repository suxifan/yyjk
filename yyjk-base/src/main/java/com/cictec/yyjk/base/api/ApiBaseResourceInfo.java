package com.cictec.yyjk.base.api;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cictec.yyjk.base.model.entity.BaseResourceInfo;
import com.cictec.yyjk.base.model.vo.BaseResourceInfoVo;
import com.cictec.yyjk.base.service.BaseResourceInfoService;
import com.cictec.yyjk.commons.core.Result;
import com.cictec.yyjk.commons.core.ResultUtil;
import com.cictec.yyjk.commons.utils.PMSUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;


/**
* Created by xpguo on 2019/05/28.
*/
@RestController
@RequestMapping("/api/base/resource")
public class ApiBaseResourceInfo extends BaseController {
    @Resource
    private BaseResourceInfoService baseResourceInfoService;

    @PostMapping("/add")
	public Result add(@RequestBody BaseResourceInfo baseResourceInfo, HttpServletRequest request) {
		baseResourceInfo.setCreateUser(getUserIdByToken(request).getUserAccount());
		// baseResourceInfoService.insertSelective(baseResourceInfo);
		baseResourceInfoService.addResource(baseResourceInfo);
        return ResultUtil.getSuccessResult();
    }

    @PostMapping("/delete")
	public Result delete(@RequestBody Map<String, Object> paramMap) {
		String id = PMSUtils.isNull(paramMap.get("id"));
        baseResourceInfoService.deleteByPrimaryKey(id);
        return ResultUtil.getSuccessResult();
    }

    @PostMapping("/update")
	public Result update(@RequestBody BaseResourceInfo baseResourceInfo, HttpServletRequest request) {
		baseResourceInfo.setUpdateUser(getUserIdByToken(request).getUserAccount());
        baseResourceInfoService.updateByPrimaryKeySelective(baseResourceInfo);
        return ResultUtil.getSuccessResult();
    }

    @PostMapping("/detail")
	public Result detail(@RequestBody Map<String, Object> paramMap) {
		String id = PMSUtils.isNull(paramMap.get("id"));
        BaseResourceInfo baseResourceInfo = baseResourceInfoService.selectByPrimaryKey(id);
        return ResultUtil.getSuccessResult(baseResourceInfo);
    }

	@PostMapping("/list")
    public Result list(@RequestBody BaseResourceInfoVo baseResourceInfoVo) {
    
		// 判定是否包含分页参数，如果包含则为分页数据请求
    	if(baseResourceInfoVo.getPageSize() != null && baseResourceInfoVo.getPageSize() != 0){
    		return pageList(baseResourceInfoVo);
    	}
    	
		// 根据具体业务重写
		List<BaseResourceInfo> list = baseResourceInfoService.getResourceInfoByVo(baseResourceInfoVo);
    	
		return ResultUtil.getSuccessResult(list);
    }
    
	@PostMapping("/pageList")
	public Result pageList (@RequestBody BaseResourceInfoVo baseResourceInfoVo) {
		// 分页数据请求处理
		PageHelper.startPage(baseResourceInfoVo.getPageNumber(), baseResourceInfoVo.getPageSize());
		// 根据具体业务重写
		List<BaseResourceInfo> list = baseResourceInfoService.getResourceInfoByVo(baseResourceInfoVo);
    	return ResultUtil.getSuccessResult(new PageInfo<BaseResourceInfo>(list));
	}
	
}
