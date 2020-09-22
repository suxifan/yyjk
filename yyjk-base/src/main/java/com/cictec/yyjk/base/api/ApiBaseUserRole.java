package com.cictec.yyjk.base.api;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cictec.yyjk.base.model.entity.BaseUserRole;
import com.cictec.yyjk.base.model.vo.BaseUserRoleVo;
import com.cictec.yyjk.base.service.BaseUserRoleService;
import com.cictec.yyjk.commons.core.Result;
import com.cictec.yyjk.commons.core.ResultUtil;
import com.cictec.yyjk.commons.utils.PMSUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;


/**
* Created by xpguo on 2019/05/28.
*/
@RestController
@RequestMapping("/api/base/user/role")
public class ApiBaseUserRole {
    @Resource
    private BaseUserRoleService baseUserRoleService;

    @PostMapping("/add")
    public Result add(@RequestBody BaseUserRole baseUserRole) {
        baseUserRoleService.insertSelective(baseUserRole);
        return ResultUtil.getSuccessResult();
    }

    @PostMapping("/delete")
	public Result delete(@RequestBody Map<String, Object> paramMap) {
		String id = PMSUtils.isNull(paramMap.get("id"));
        baseUserRoleService.deleteByPrimaryKey(id);
        return ResultUtil.getSuccessResult();
    }

    @PostMapping("/update")
    public Result update(@RequestBody BaseUserRole baseUserRole) {
        baseUserRoleService.updateByPrimaryKeySelective(baseUserRole);
        return ResultUtil.getSuccessResult();
    }

    @PostMapping("/detail")
	public Result detail(@RequestBody Map<String, Object> paramMap) {
		String id = PMSUtils.isNull(paramMap.get("id"));
        BaseUserRole baseUserRole = baseUserRoleService.selectByPrimaryKey(id);
        return ResultUtil.getSuccessResult(baseUserRole);
    }

	@PostMapping("/list")
    public Result list(@RequestBody BaseUserRoleVo baseUserRoleVo) {
    
		// 判定是否包含分页参数，如果包含则为分页数据请求
    	if(baseUserRoleVo.getPageSize() != null && baseUserRoleVo.getPageSize() != 0){
    		return pageList(baseUserRoleVo);
    	}
    	
		// TODO 根据具体业务重写
    	List<BaseUserRole> list = baseUserRoleService.select(null);
    	
		return ResultUtil.getSuccessResult(list);
    }
    
	@PostMapping("/pageList")
	public Result pageList (@RequestBody BaseUserRoleVo baseUserRoleVo) {
		/*
		 * 方法一：
		 */
		// 分页数据请求处理
		PageHelper.startPage(baseUserRoleVo.getPageNumber(), baseUserRoleVo.getPageSize());
		// TODO 根据具体业务重写
    	List<BaseUserRole> list = baseUserRoleService.select(null);
    	return ResultUtil.getSuccessResult(new PageInfo<BaseUserRole>(list));
	}
	
}
