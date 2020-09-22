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

import com.cictec.yyjk.commons.core.Result;
import com.cictec.yyjk.commons.core.ResultUtil;
import com.cictec.yyjk.linenet.model.entity.NetDataBasestation;
import com.cictec.yyjk.linenet.model.view.GridChartOption;
import com.cictec.yyjk.linenet.model.view.NetDataBasestationValue;
import com.cictec.yyjk.linenet.model.vo.NetDataBasestationVo;
import com.cictec.yyjk.linenet.service.NetDataBasestationService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * Created by xpguo on 2019/10/12.
 */
@RestController
@RequestMapping("/api/net/data/basestation")
public class ApiNetDataBasestation {
	private static final Logger LOG = LoggerFactory.getLogger(ApiNetDataBasestation.class);
	@Resource
	private NetDataBasestationService netDataBasestationService;

	@PostMapping("/add")
	public Result add(@RequestBody NetDataBasestation netDataBasestation) {
		netDataBasestationService.insertSelective(netDataBasestation);
		return ResultUtil.getSuccessResult();
	}

	@PostMapping("/delete")
	public Result delete(@RequestParam Integer id) {
		netDataBasestationService.deleteByPrimaryKey(id);
		return ResultUtil.getSuccessResult();
	}

	@PostMapping("/update")
	public Result update(@RequestBody NetDataBasestation netDataBasestation) {
		netDataBasestationService.updateByPrimaryKeySelective(netDataBasestation);
		return ResultUtil.getSuccessResult();
	}

	@PostMapping("/detail")
	public Result detail(@RequestParam Integer id) {
		NetDataBasestation netDataBasestation = netDataBasestationService.selectByPrimaryKey(id);
		return ResultUtil.getSuccessResult(netDataBasestation);
	}

	@PostMapping("/list")
	public Result list(@RequestBody NetDataBasestationVo netDataBasestationVo) {

		// 判定是否包含分页参数，如果包含则为分页数据请求
		if (netDataBasestationVo.getPageSize() != null && netDataBasestationVo.getPageSize() != 0) {
			return pageList(netDataBasestationVo);
		}

		// TODO 根据具体业务重写
		List<NetDataBasestation> list = netDataBasestationService.select(null);

		return ResultUtil.getSuccessResult(list);
	}

	@PostMapping("/pageList")
	public Result pageList(@RequestBody NetDataBasestationVo netDataBasestationVo) {
		/*
		 * 方法一：
		 */
		// 分页数据请求处理
		PageHelper.startPage(netDataBasestationVo.getPageNumber(), netDataBasestationVo.getPageSize());
		// TODO 根据具体业务重写
		List<NetDataBasestation> list = netDataBasestationService.select(null);
		return ResultUtil.getSuccessResult(new PageInfo<NetDataBasestation>(list));

		/*
		 * 方法二：
		 */
		// String orderBy = sort + " " + order;
		// PageInfo<NetDataBasestation> pageInfo =
		// netDataBasestationService.selectPage(netDataBasestationVo.getPageNumber(),
		// netDataBasestationVo.getPageSize(), null);
		// return ResultUtil.getSuccessResult(pageInfo);

	}

	@PostMapping("/getCompanyEchartData")
	public Result getCompanyEchartData(@RequestBody NetDataBasestationVo vo) {
		try {
			GridChartOption options = netDataBasestationService.getCompanyEchartData(vo);
			LOG.info("获取机构站点数echartsdata数据：{}", options.toString());
			return ResultUtil.getSuccessResult(options);
		} catch (Exception e) {
			LOG.error("获取机构站点数echartsdata异常，原因：{}", e);
			return ResultUtil.getErrorResult();
		}
	}

	@PostMapping("/getAllBaseStationNamesListData")
	public Result getAllBaseStationNamesListData(@RequestBody NetDataBasestationVo vo) {
		try {
			List<NetDataBasestationValue> list = netDataBasestationService.getAllBaseStationNamesListData(vo);
			LOG.info("获取所有站位名Listdata数据：{}", list.size());
			return ResultUtil.getSuccessResult(list);
		} catch (Exception e) {
			LOG.error("获取所有站位名Listdata数据异常，原因：{}", e);
			return ResultUtil.getErrorResult();
		}
	}

}
