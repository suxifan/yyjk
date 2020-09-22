package com.cictec.yyjk.timingtask.api;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cictec.yyjk.base.interceptors.AccessLogInfo;
import com.cictec.yyjk.commons.core.Result;
import com.cictec.yyjk.commons.core.ResultUtil;
import com.cictec.yyjk.timingtask.model.entity.TSafeDeviceRidControl;
import com.cictec.yyjk.timingtask.model.viewdata.TSafeDeviceRidControlValue;
import com.cictec.yyjk.timingtask.model.vo.TSafeDeviceRidControlVo;
import com.cictec.yyjk.timingtask.service.TSafeDeviceRidControlService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * Created by xpguo on 2020/07/09.
 */
@RestController
@RequestMapping("/safe/control")
public class ApiTSafeDeviceRidControl {
	@Resource
	private TSafeDeviceRidControlService tSafeDeviceRidControlService;

	@PostMapping("/add")
	public Result add(@RequestBody TSafeDeviceRidControl tSafeDeviceRidControl) {
		tSafeDeviceRidControlService.insertSelective(tSafeDeviceRidControl);
		return ResultUtil.getSuccessResult();
	}

	@PostMapping("/delete")
	public Result delete(@RequestParam Integer id) {
		tSafeDeviceRidControlService.deleteByPrimaryKey(id);
		return ResultUtil.getSuccessResult();
	}

	@PostMapping("/update")
	public Result update(@RequestBody TSafeDeviceRidControl tSafeDeviceRidControl) {
		tSafeDeviceRidControlService.updateByPrimaryKeySelective(tSafeDeviceRidControl);
		return ResultUtil.getSuccessResult();
	}

	@PostMapping("/detail")
	public Result detail(@RequestParam Integer id) {
		TSafeDeviceRidControl tSafeDeviceRidControl = tSafeDeviceRidControlService.selectByPrimaryKey(id);
		return ResultUtil.getSuccessResult(tSafeDeviceRidControl);
	}

	@PostMapping("/list")
	@AccessLogInfo(modelName = "疲劳监测", pageName = "设备托管报警")
	public Result list(@RequestBody TSafeDeviceRidControlVo tSafeDeviceRidControlVo) {

		// 判定是否包含分页参数，如果包含则为分页数据请求
		if (tSafeDeviceRidControlVo.getPageSize() != null && tSafeDeviceRidControlVo.getPageSize() != 0) {
			return pageList(tSafeDeviceRidControlVo);
		}

		List<TSafeDeviceRidControlValue> list = tSafeDeviceRidControlService
				.getDeviceRidControlData(tSafeDeviceRidControlVo);

		return ResultUtil.getSuccessResult(list);
	}

	@PostMapping("/pageList")
	public Result pageList(@RequestBody TSafeDeviceRidControlVo tSafeDeviceRidControlVo) {
		/*
		 * 方法一：
		 */
		// 分页数据请求处理
		PageHelper.startPage(tSafeDeviceRidControlVo.getPageNumber(), tSafeDeviceRidControlVo.getPageSize());
		// TODO 根据具体业务重写
		List<TSafeDeviceRidControlValue> list = tSafeDeviceRidControlService
				.getDeviceRidControlData(tSafeDeviceRidControlVo);
		return ResultUtil.getSuccessResult(new PageInfo<TSafeDeviceRidControlValue>(list));

		/*
		 * 方法二：
		 */
		// String orderBy = sort + " " + order;
		// PageInfo<TSafeDeviceRidControl> pageInfo =
		// tSafeDeviceRidControlService.selectPage(tSafeDeviceRidControlVo.getPageNumber(),
		// tSafeDeviceRidControlVo.getPageSize(), null);
		// return ResultUtil.getSuccessResult(pageInfo);

	}

}
