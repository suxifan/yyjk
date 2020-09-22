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
import com.cictec.yyjk.linenet.model.entity.NetDataBusline;
import com.cictec.yyjk.linenet.model.view.GridChartOption;
import com.cictec.yyjk.linenet.model.view.NetDataBuslineValue;
import com.cictec.yyjk.linenet.model.vo.NetDataBuslineVo;
import com.cictec.yyjk.linenet.service.NetDataBuslineService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * Created by xpguo on 2019/10/12.
 */
@RestController
@RequestMapping("/api/net/data/busline")
public class ApiNetDataBusline {
	private static final Logger LOG = LoggerFactory.getLogger(ApiNetDataBusline.class);
	@Resource
	private NetDataBuslineService netDataBuslineService;

	@PostMapping("/add")
	public Result add(@RequestBody NetDataBusline netDataBusline) {
		netDataBuslineService.insertSelective(netDataBusline);
		return ResultUtil.getSuccessResult();
	}

	@PostMapping("/delete")
	public Result delete(@RequestParam Integer id) {
		netDataBuslineService.deleteByPrimaryKey(id);
		return ResultUtil.getSuccessResult();
	}

	@PostMapping("/update")
	public Result update(@RequestBody NetDataBusline netDataBusline) {
		netDataBuslineService.updateByPrimaryKeySelective(netDataBusline);
		return ResultUtil.getSuccessResult();
	}

	@PostMapping("/detail")
	public Result detail(@RequestParam Integer id) {
		NetDataBusline netDataBusline = netDataBuslineService.selectByPrimaryKey(id);
		return ResultUtil.getSuccessResult(netDataBusline);
	}

	@PostMapping("/list")
	public Result list(@RequestBody NetDataBuslineVo netDataBuslineVo) {

		// 判定是否包含分页参数，如果包含则为分页数据请求
		if (netDataBuslineVo.getPageSize() != null && netDataBuslineVo.getPageSize() != 0) {
			return pageList(netDataBuslineVo);
		}

		// TODO 根据具体业务重写
		List<NetDataBusline> list = netDataBuslineService.select(null);

		return ResultUtil.getSuccessResult(list);
	}

	@PostMapping("/pageList")
	public Result pageList(@RequestBody NetDataBuslineVo netDataBuslineVo) {
		/*
		 * 方法一：
		 */
		// 分页数据请求处理
		PageHelper.startPage(netDataBuslineVo.getPageNumber(), netDataBuslineVo.getPageSize());
		// TODO 根据具体业务重写
		List<NetDataBusline> list = netDataBuslineService.select(null);
		return ResultUtil.getSuccessResult(new PageInfo<NetDataBusline>(list));

		/*
		 * 方法二：
		 */
		// String orderBy = sort + " " + order;
		// PageInfo<NetDataBusline> pageInfo =
		// netDataBuslineService.selectPage(netDataBuslineVo.getPageNumber(),
		// netDataBuslineVo.getPageSize(), null);
		// return ResultUtil.getSuccessResult(pageInfo);

	}

	@PostMapping("/getCompanyListData")
	public Result getCompanyListData(@RequestBody NetDataBuslineVo vo) {
		try {
			List<NetDataBusline> list = netDataBuslineService.getCompanyListData(vo);
			LOG.info("获取机构Listdata数据：{}", list.toString());
			return ResultUtil.getSuccessResult(list);
		} catch (Exception e) {
			LOG.error("获取机构Listdata异常，原因：{}", e);
			return ResultUtil.getErrorResult();
		}
	}

	@PostMapping("/getLineListData")
	public Result getLineListData(@RequestBody NetDataBuslineVo vo) {
		try {
			List<NetDataBusline> list = netDataBuslineService.getLineListData(vo);
			LOG.info("获取线路Listdata数据：{}", list.toString());
			return ResultUtil.getSuccessResult(list);
		} catch (Exception e) {
			LOG.error("获取线路Listdata异常，原因：{}", e);
			return ResultUtil.getErrorResult();
		}
	}

	@PostMapping("/getCompanyEchartData")
	public Result getCompanyEchartData(@RequestBody NetDataBuslineVo vo) {
		try {
			GridChartOption options = netDataBuslineService.getCompanyEchartData(vo);
			LOG.info("获取机构线路条数echaresdata数据：{}", options.toString());
			return ResultUtil.getSuccessResult(options);
		} catch (Exception e) {
			LOG.error("获取机构线路条数echaresdata异常，原因：{}", e);
			return ResultUtil.getErrorResult();
		}
	}

	@AccessLogInfo(modelName = "数据分析", pageName = "线路情况")
	@PostMapping("/getLineOnOrDownEchartData")
	public Result getLineOnOrDownEchartData(@RequestBody NetDataBuslineVo vo) {
		try {
			GridChartOption options = netDataBuslineService.getLineOnOrDownEchartData(vo);
			LOG.info("获取机构线路上下行长度echaresdata数据：{}", options.toString());
			return ResultUtil.getSuccessResult(options);
		} catch (Exception e) {
			LOG.error("获取机构线路上下行长度echaresdata异常，原因：{}", e);
			return ResultUtil.getErrorResult();
		}
	}

	@PostMapping("/getCompanyLineListsData")
	public Result getCompanyLineListsData(@RequestBody NetDataBuslineVo vo) {
		try {
			List<NetDataBuslineValue> list = netDataBuslineService.getCompanyLineListsData(vo);
			LOG.info("获取机构线路情况data数据：{}", list.toString());
			return ResultUtil.getSuccessResult(list);
		} catch (Exception e) {
			LOG.error("获取机构线路情况data异常，原因：{}", e);
			return ResultUtil.getErrorResult();
		}
	}

	@PostMapping("/getCompanyLineCountsListData")
	public Result getCompanyLineCountsListData(@RequestBody NetDataBuslineVo vo) {
		try {
			List<NetDataBuslineValue> list = netDataBuslineService.getCompanyLineCountsListData(vo);
			LOG.info("获取线路条数data数据：{}", list.toString());
			return ResultUtil.getSuccessResult(list);
		} catch (Exception e) {
			LOG.error("获取线路条数data异常，原因：{}", e);
			return ResultUtil.getErrorResult();
		}
	}

}
