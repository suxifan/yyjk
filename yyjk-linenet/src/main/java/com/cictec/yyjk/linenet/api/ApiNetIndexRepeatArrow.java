package com.cictec.yyjk.linenet.api;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cictec.yyjk.base.interceptors.AccessLogInfo;
import com.cictec.yyjk.commons.core.Result;
import com.cictec.yyjk.commons.core.ResultUtil;
import com.cictec.yyjk.linenet.model.entity.NetIndexRepeatArrow;
import com.cictec.yyjk.linenet.model.vo.NetDataBuslineVo;
import com.cictec.yyjk.linenet.model.vo.NetIndexRepeatArrowVo;
import com.cictec.yyjk.linenet.service.NetIndexRepeatArrowService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * Created by mao on 2019/10/14.
 */
@RestController
@RequestMapping("/api/net/index/repeat/arrow")
public class ApiNetIndexRepeatArrow {
	private static final Logger LOG = LoggerFactory.getLogger(ApiNetIndexRepeatArrow.class);
	@Resource
	private NetIndexRepeatArrowService netIndexRepeatArrowService;

	@PostMapping("/add")
	public Result add(@RequestBody NetIndexRepeatArrow netIndexRepeatArrow) {
		netIndexRepeatArrowService.insertSelective(netIndexRepeatArrow);
		return ResultUtil.getSuccessResult();
	}

	@PostMapping("/delete")
	public Result delete(@RequestParam Integer id) {
		netIndexRepeatArrowService.deleteByPrimaryKey(id);
		return ResultUtil.getSuccessResult();
	}

	@PostMapping("/update")
	public Result update(@RequestBody NetIndexRepeatArrow netIndexRepeatArrow) {
		netIndexRepeatArrowService.updateByPrimaryKeySelective(netIndexRepeatArrow);
		return ResultUtil.getSuccessResult();
	}

	@PostMapping("/detail")
	public Result detail(@RequestParam Integer id) {
		NetIndexRepeatArrow netIndexRepeatArrow = netIndexRepeatArrowService.selectByPrimaryKey(id);
		return ResultUtil.getSuccessResult(netIndexRepeatArrow);
	}

	@PostMapping("/list")
	public Result list(@RequestBody NetIndexRepeatArrowVo netIndexRepeatArrowVo) {

		// 判定是否包含分页参数，如果包含则为分页数据请求
		if (netIndexRepeatArrowVo.getPageSize() != null && netIndexRepeatArrowVo.getPageSize() != 0) {
			return pageList(netIndexRepeatArrowVo);
		}

		// TODO 根据具体业务重写
		List<NetIndexRepeatArrow> list = netIndexRepeatArrowService.select(null);

		return ResultUtil.getSuccessResult(list);
	}

	@PostMapping("/pageList")
	public Result pageList(@RequestBody NetIndexRepeatArrowVo netIndexRepeatArrowVo) {
		/*
		 * 方法一：
		 */
		// 分页数据请求处理
		PageHelper.startPage(netIndexRepeatArrowVo.getPageNumber(), netIndexRepeatArrowVo.getPageSize());
		// TODO 根据具体业务重写
		List<NetIndexRepeatArrow> list = netIndexRepeatArrowService.select(null);
		return ResultUtil.getSuccessResult(new PageInfo<NetIndexRepeatArrow>(list));

		/*
		 * 方法二：
		 */
		// String orderBy = sort + " " + order;
		// PageInfo<NetIndexRepeatArrow> pageInfo =
		// netIndexRepeatArrowService.selectPage(netIndexRepeatArrowVo.getPageNumber(),
		// netIndexRepeatArrowVo.getPageSize(), null);
		// return ResultUtil.getSuccessResult(pageInfo);

	}

	@AccessLogInfo(modelName = "数据分析", pageName = "重复度指标")
	@PostMapping("/getCompanyLineRepeatListData")
	public Result getCompanyLineRepeatListData(@RequestBody NetDataBuslineVo vo) {
		try {
			List<NetIndexRepeatArrow> list = netIndexRepeatArrowService.getCompanyLineRepeatListData(vo);
			LOG.info("获取分公司线路重复度listdata数据：{}", list.toString());
			return ResultUtil.getSuccessResult(list);
		} catch (Exception e) {
			LOG.error("获取分公司线路重复度listdata异常，原因：{}", e);
			return ResultUtil.getErrorResult();
		}
	}

	@AccessLogInfo(modelName = "数据分析", pageName = "数据总览页")
	@PostMapping("/getLineRepeatTOP10ListData")
	public Result getLineRepeatTOP10ListData(@RequestBody NetDataBuslineVo vo) {
		try {
			List<NetIndexRepeatArrow> list = netIndexRepeatArrowService.getLineRepeatTOP10ListData(vo);
			LOG.info("获取数据总览页线路重复度TOP10列表listdata数据：{}", list.toString());
			return ResultUtil.getSuccessResult(list);
		} catch (Exception e) {
			LOG.error("获取数据总览页线路重复度TOP10列表listdata异常，原因：{}", e);
			return ResultUtil.getErrorResult();
		}
	}

}
