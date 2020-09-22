package com.cictec.yyjk.base.api;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cictec.yyjk.base.model.entity.BusSysOrg;
import com.cictec.yyjk.base.model.vo.BusSysOrgVo;
import com.cictec.yyjk.base.service.BusSysOrgService;
import com.cictec.yyjk.commons.core.Result;
import com.cictec.yyjk.commons.core.ResultUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;


/**
* Created by xpguo on 2019/05/20.
*/
@RestController
@RequestMapping("/api/bus/sysorg")
public class ApiBusSysOrg {
    @Resource
    private BusSysOrgService busSysOrgService;

    @PostMapping("/add")
    public Result add(@RequestBody BusSysOrg busSysOrg) {
        busSysOrgService.insertSelective(busSysOrg);
        return ResultUtil.getSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        busSysOrgService.deleteByPrimaryKey(id);
        return ResultUtil.getSuccessResult();
    }

    @PostMapping("/update")
    public Result update(@RequestBody BusSysOrg busSysOrg) {
        busSysOrgService.updateByPrimaryKeySelective(busSysOrg);
        return ResultUtil.getSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        BusSysOrg busSysOrg = busSysOrgService.selectByPrimaryKey(id);
        return ResultUtil.getSuccessResult(busSysOrg);
    }

	@PostMapping("/list")
    public Result list(@RequestBody BusSysOrgVo busSysOrgVo) {
		// 判定是否包含分页参数，如果包含则为分页数据请求
    	if(busSysOrgVo.getPageSize() != null && busSysOrgVo.getPageSize() != 0){
    		return pageList(busSysOrgVo);
    	}
		List<BusSysOrg> list = busSysOrgService.getBusSysOrgByExample(busSysOrgVo);
		return ResultUtil.getSuccessResult(list);
    }
    
	@PostMapping("/pageList")
	public Result pageList (@RequestBody BusSysOrgVo busSysOrgVo) {
		// 分页数据请求处理
		PageHelper.startPage(busSysOrgVo.getPageNumber(), busSysOrgVo.getPageSize());
		List<BusSysOrg> list = busSysOrgService.getBusSysOrgByExample(busSysOrgVo);
    	return ResultUtil.getSuccessResult(new PageInfo<BusSysOrg>(list));
	}
	
}
