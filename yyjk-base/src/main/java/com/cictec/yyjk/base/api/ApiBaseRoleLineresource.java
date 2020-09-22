package com.cictec.yyjk.base.api;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cictec.yyjk.base.model.entity.BaseRoleLineresource;
import com.cictec.yyjk.base.service.BaseRoleLineresourceService;
import com.cictec.yyjk.commons.core.Result;
import com.cictec.yyjk.commons.core.ResultUtil;


/**
* Created by xpguo on 2020/04/14.
*/
@RestController
@RequestMapping("/api/base/role/lineresource")
public class ApiBaseRoleLineresource {
    @Resource
    private BaseRoleLineresourceService baseRoleLineresourceService;

    @PostMapping("/add")
	public Result add(@RequestBody @Valid BaseRoleLineresource baseRoleLineresource) {
		baseRoleLineresourceService.insertSelective(baseRoleLineresource);
		return ResultUtil.getSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        baseRoleLineresourceService.deleteByPrimaryKey(id);
        return ResultUtil.getSuccessResult();
    }

    @PostMapping("/update")
    public Result update(@RequestBody BaseRoleLineresource baseRoleLineresource) {
        baseRoleLineresourceService.updateByPrimaryKeySelective(baseRoleLineresource);
        return ResultUtil.getSuccessResult();
    }
}
