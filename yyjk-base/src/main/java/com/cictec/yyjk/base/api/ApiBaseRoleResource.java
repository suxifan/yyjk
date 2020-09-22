package com.cictec.yyjk.base.api;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cictec.yyjk.base.model.entity.BaseRoleResource;
import com.cictec.yyjk.base.model.vo.BaseRoleResourceVo;
import com.cictec.yyjk.base.service.BaseRoleResourceService;
import com.cictec.yyjk.commons.core.Result;
import com.cictec.yyjk.commons.core.ResultUtil;
import com.cictec.yyjk.commons.utils.PMSUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;


/**
* Created by xpguo on 2019/05/28.
*/
@RestController
@RequestMapping("/api/base/role/resource")
public class ApiBaseRoleResource {
    @Resource
    private BaseRoleResourceService baseRoleResourceService;

    @PostMapping("/add")
    public Result add(@RequestBody BaseRoleResource baseRoleResource) {
        baseRoleResourceService.insertSelective(baseRoleResource);
        return ResultUtil.getSuccessResult();
    }

    @PostMapping("/delete")
	public Result delete(@RequestBody Map<String, Object> paramMap) {
		String id = PMSUtils.isNull(paramMap.get("id"));
        baseRoleResourceService.deleteByPrimaryKey(id);
        return ResultUtil.getSuccessResult();
    }

    @PostMapping("/update")
    public Result update(@RequestBody BaseRoleResource baseRoleResource) {
        baseRoleResourceService.updateByPrimaryKeySelective(baseRoleResource);
        return ResultUtil.getSuccessResult();
    }

    @PostMapping("/detail")
	public Result detail(@RequestBody Map<String, Object> paramMap) {
		String id = PMSUtils.isNull(paramMap.get("id"));
        BaseRoleResource baseRoleResource = baseRoleResourceService.selectByPrimaryKey(id);
        return ResultUtil.getSuccessResult(baseRoleResource);
    }

	@PostMapping("/list")
    public Result list(@RequestBody BaseRoleResourceVo baseRoleResourceVo) {
    
		// 判定是否包含分页参数，如果包含则为分页数据请求
    	if(baseRoleResourceVo.getPageSize() != null && baseRoleResourceVo.getPageSize() != 0){
    		return pageList(baseRoleResourceVo);
    	}
    	
		// TODO 根据具体业务重写
    	List<BaseRoleResource> list = baseRoleResourceService.select(null);
    	
		return ResultUtil.getSuccessResult(list);
    }
    
	@PostMapping("/pageList")
	public Result pageList (@RequestBody BaseRoleResourceVo baseRoleResourceVo) {
		/*
		 * 方法一：
		 */
		// 分页数据请求处理
		PageHelper.startPage(baseRoleResourceVo.getPageNumber(), baseRoleResourceVo.getPageSize());
		// TODO 根据具体业务重写
    	List<BaseRoleResource> list = baseRoleResourceService.select(null);
    	return ResultUtil.getSuccessResult(new PageInfo<BaseRoleResource>(list));
    	
    	/*
		 * 方法二：
		 */
//		String orderBy = sort + " " + order;
// 		PageInfo<BaseRoleResource> pageInfo = baseRoleResourceService.selectPage(baseRoleResourceVo.getPageNumber(), baseRoleResourceVo.getPageSize(), null);
//		return ResultUtil.getSuccessResult(pageInfo);
		
	}
	
}
