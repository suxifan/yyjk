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
import com.cictec.yyjk.linenet.model.entity.NetIndexPfStationDay;
import com.cictec.yyjk.linenet.model.view.GridChartOption;
import com.cictec.yyjk.linenet.model.vo.NetIndexPfBaseVo;
import com.cictec.yyjk.linenet.model.vo.NetIndexPfStationDayVo;
import com.cictec.yyjk.linenet.service.NetIndexPfStationDayService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * Created by mao on 2019/10/15.
 */
@RestController
@RequestMapping("/api/net/index/pf/station/day")
public class ApiNetIndexPfStationDay {
	private static final Logger LOG = LoggerFactory.getLogger(ApiNetIndexPfStationDay.class);
	@Resource
	private NetIndexPfStationDayService netIndexPfStationDayService;

	@PostMapping("/add")
	public Result add(@RequestBody NetIndexPfStationDay netIndexPfStationDay) {
		netIndexPfStationDayService.insertSelective(netIndexPfStationDay);
		return ResultUtil.getSuccessResult();
	}

	@PostMapping("/delete")
	public Result delete(@RequestParam Integer id) {
		netIndexPfStationDayService.deleteByPrimaryKey(id);
		return ResultUtil.getSuccessResult();
	}

	@PostMapping("/update")
	public Result update(@RequestBody NetIndexPfStationDay netIndexPfStationDay) {
		netIndexPfStationDayService.updateByPrimaryKeySelective(netIndexPfStationDay);
		return ResultUtil.getSuccessResult();
	}

	@PostMapping("/detail")
	public Result detail(@RequestParam Integer id) {
		NetIndexPfStationDay netIndexPfStationDay = netIndexPfStationDayService.selectByPrimaryKey(id);
		return ResultUtil.getSuccessResult(netIndexPfStationDay);
	}

	@PostMapping("/list")
	public Result list(@RequestBody NetIndexPfStationDayVo netIndexPfStationDayVo) {

		// 判定是否包含分页参数，如果包含则为分页数据请求
		if (netIndexPfStationDayVo.getPageSize() != null && netIndexPfStationDayVo.getPageSize() != 0) {
			return pageList(netIndexPfStationDayVo);
		}

		// TODO 根据具体业务重写
		List<NetIndexPfStationDay> list = netIndexPfStationDayService.select(null);

		return ResultUtil.getSuccessResult(list);
	}

	@PostMapping("/pageList")
	public Result pageList(@RequestBody NetIndexPfStationDayVo netIndexPfStationDayVo) {
		/*
		 * 方法一：
		 */
		// 分页数据请求处理
		PageHelper.startPage(netIndexPfStationDayVo.getPageNumber(), netIndexPfStationDayVo.getPageSize());
		// TODO 根据具体业务重写
		List<NetIndexPfStationDay> list = netIndexPfStationDayService.select(null);
		return ResultUtil.getSuccessResult(new PageInfo<NetIndexPfStationDay>(list));

		/*
		 * 方法二：
		 */
		// String orderBy = sort + " " + order;
		// PageInfo<NetIndexPfStationDay> pageInfo =
		// netIndexPfStationDayService.selectPage(netIndexPfStationDayVo.getPageNumber(),
		// netIndexPfStationDayVo.getPageSize(), null);
		// return ResultUtil.getSuccessResult(pageInfo);

	}

	@AccessLogInfo(modelName = "数据分析", pageName = "数据综合查询")
	@PostMapping("/getPfStationDayListGridData")
	public Result getPfStationDayListGridData(@RequestBody NetIndexPfBaseVo vo) {
		try {
			GridChartOption options = netIndexPfStationDayService.getPfStationDayListGridData(vo);
			LOG.info("线路站点登降量列表Griddata数据：{}", options.toString());
			return ResultUtil.getSuccessResult(options);
		} catch (Exception e) {
			LOG.error("线路站点登降量列表Griddata异常，原因：{}", e);
			return ResultUtil.getErrorResult();
		}
	}
}
