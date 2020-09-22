package com.cictec.yyjk.timingtask.api;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cictec.yyjk.commons.core.Result;
import com.cictec.yyjk.commons.core.ResultUtil;
import com.cictec.yyjk.fatigue.model.entity.DwDimBusDriver;
import com.cictec.yyjk.fatigue.model.vo.DwDimBusDriverVo;
import com.cictec.yyjk.fatigue.service.DwDimBusDriverService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * Created by xpguo on 2020/06/29.
 */
@RestController
@RequestMapping("/api/dw/dim/bus/driver")
public class ApiDwDimBusDriver {
	@Resource
	private DwDimBusDriverService dwDimBusDriverService;

	@PostMapping("/add")
	public Result add(@RequestBody DwDimBusDriver dwDimBusDriver) {
		dwDimBusDriverService.insertSelective(dwDimBusDriver);
		return ResultUtil.getSuccessResult();
	}

	@PostMapping("/delete")
	public Result delete(@RequestParam Integer id) {
		dwDimBusDriverService.deleteByPrimaryKey(id);
		return ResultUtil.getSuccessResult();
	}

	@PostMapping("/update")
	public Result update(@RequestBody DwDimBusDriver dwDimBusDriver) {
		dwDimBusDriverService.updateByPrimaryKeySelective(dwDimBusDriver);
		return ResultUtil.getSuccessResult();
	}

	@PostMapping("/detail")
	public Result detail(@RequestParam Integer id) {
		DwDimBusDriver dwDimBusDriver = dwDimBusDriverService.selectByPrimaryKey(id);
		return ResultUtil.getSuccessResult(dwDimBusDriver);
	}

	@PostMapping("/list")
	public Result list(@RequestBody DwDimBusDriverVo dwDimBusDriverVo) {

		List<DwDimBusDriver> list = dwDimBusDriverService.selectAllBusDriver(dwDimBusDriverVo);

		return ResultUtil.getSuccessResult(list);
	}

	@PostMapping("/pageList")
	public Result pageList(@RequestBody DwDimBusDriverVo dwDimBusDriverVo) {
		/*
		 * 方法一：
		 */
		// 分页数据请求处理
		PageHelper.startPage(dwDimBusDriverVo.getPageNumber(), dwDimBusDriverVo.getPageSize());
		// TODO 根据具体业务重写
		List<DwDimBusDriver> list = dwDimBusDriverService.select(null);
		return ResultUtil.getSuccessResult(new PageInfo<DwDimBusDriver>(list));

		/*
		 * 方法二：
		 */
		// String orderBy = sort + " " + order;
		// PageInfo<DwDimBusDriver> pageInfo =
		// dwDimBusDriverService.selectPage(dwDimBusDriverVo.getPageNumber(),
		// dwDimBusDriverVo.getPageSize(), null);
		// return ResultUtil.getSuccessResult(pageInfo);

	}

}
