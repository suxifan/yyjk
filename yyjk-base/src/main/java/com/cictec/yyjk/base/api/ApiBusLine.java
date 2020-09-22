package com.cictec.yyjk.base.api;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cictec.yyjk.base.model.entity.BusLine;
import com.cictec.yyjk.base.model.view.BusLineView;
import com.cictec.yyjk.base.model.vo.BaseUserInfoVo;
import com.cictec.yyjk.base.model.vo.BusLineVo;
import com.cictec.yyjk.base.service.BaseUserInfoService;
import com.cictec.yyjk.base.service.BusLineService;
import com.cictec.yyjk.commons.core.Result;
import com.cictec.yyjk.commons.core.ResultUtil;

/**
 * Created by xpguo on 2019/05/21.
 */
@RestController
@RequestMapping("/api/bus/line")
public class ApiBusLine extends BaseController {
	@Resource
	private BusLineService busLineService;
	@Autowired
	private BaseUserInfoService baseUserInfoService;

	@PostMapping("/add")
	public Result add(@RequestBody BusLine busLine) {
		busLineService.insertSelective(busLine);
		return ResultUtil.getSuccessResult();
	}

	@PostMapping("/delete")
	public Result delete(@RequestParam Integer id) {
		busLineService.deleteByPrimaryKey(id);
		return ResultUtil.getSuccessResult();
	}

	@PostMapping("/update")
	public Result update(@RequestBody BusLine busLine) {
		busLineService.updateByPrimaryKeySelective(busLine);
		return ResultUtil.getSuccessResult();
	}

	@PostMapping("/detail")
	public Result detail(@RequestParam Integer id) {
		BusLine busLine = busLineService.selectByPrimaryKey(id);
		return ResultUtil.getSuccessResult(busLine);
	}

	@PostMapping("/list")
	public Result list(@RequestBody BusLineVo busLineVo, HttpServletRequest request) {
		// BaseUserInfo userInfo = getUserIdByToken(request);
		// userInfo.setOrgId(busLineVo.getOrgId());
		// userInfo.setLineUuids(busLineVo.getLineUuids());
		// BusLineVo vo = new BusLineVo();
		// vo.setOrgId(busLineVo.getOrgId());
		// vo.setLineUuids(busLineVo.getLineUuids());
		// List<BusLine> list = null;

		BaseUserInfoVo user = new BaseUserInfoVo();
		user.setPersonId(busLineVo.getPersonId());
		List<BusLineView> lineList = baseUserInfoService.getLineListByUserId(user);
		List<String> lineUuids = new ArrayList<>();
		for (BusLineView busLineView : lineList) {
			lineUuids.add(busLineView.getLineUuid());
		}
		if (busLineVo.getLineUuids().size() == 0) {
			busLineVo.setLineUuids(lineUuids);
		}

		BusLineVo vo = new BusLineVo();
		vo.setOrgId(busLineVo.getOrgId());
		vo.setLineUuids(busLineVo.getLineUuids());
		List<BusLine> list = busLineService.getBusLineByExample(vo);

		// if ("123456".equals(userInfo.getUserId())) {
		// list = busLineService.getBusLineByExample(vo);
		// } else {
		// list = busLineService.getBusLineByUserAuths(userInfo);
		// if (CollectionUtils.isEmpty(list)) {
		// return ResultUtil.getErrorResult("用户没有线路权限！");
		// }
		// }
		return ResultUtil.getSuccessResult(list);
	}

}
