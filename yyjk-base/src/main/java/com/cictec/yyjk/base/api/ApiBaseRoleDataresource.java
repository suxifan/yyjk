package com.cictec.yyjk.base.api;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cictec.yyjk.base.model.entity.BaseRoleDataresource;
import com.cictec.yyjk.base.service.BaseRoleDataresourceService;
import com.cictec.yyjk.commons.core.Result;
import com.cictec.yyjk.commons.core.ResultUtil;


/**
* Created by xpguo on 2019/11/20.
*/
@RestController
@RequestMapping("/api/base/role/dataresource")
public class ApiBaseRoleDataresource {
    @Resource
    private BaseRoleDataresourceService baseRoleDataresourceService;

    @PostMapping("/add")
    public Result add(@RequestBody BaseRoleDataresource baseRoleDataresource) {
        baseRoleDataresourceService.insertSelective(baseRoleDataresource);
        return ResultUtil.getSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        baseRoleDataresourceService.deleteByPrimaryKey(id);
        return ResultUtil.getSuccessResult();
    }

    @PostMapping("/update")
    public Result update(@RequestBody BaseRoleDataresource baseRoleDataresource) {
        baseRoleDataresourceService.updateByPrimaryKeySelective(baseRoleDataresource);
        return ResultUtil.getSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        BaseRoleDataresource baseRoleDataresource = baseRoleDataresourceService.selectByPrimaryKey(id);
        return ResultUtil.getSuccessResult(baseRoleDataresource);
    }
	
}
