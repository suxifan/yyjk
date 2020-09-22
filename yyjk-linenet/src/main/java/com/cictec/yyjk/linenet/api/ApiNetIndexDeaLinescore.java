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
import com.cictec.yyjk.linenet.model.entity.NetIndexDeaLinescore;
import com.cictec.yyjk.linenet.model.view.GridChartOption;
import com.cictec.yyjk.linenet.model.view.NetIndexDeaLinescoreValue;
import com.cictec.yyjk.linenet.model.vo.NetDataBuslineVo;
import com.cictec.yyjk.linenet.model.vo.NetIndexDeaLinescoreVo;
import com.cictec.yyjk.linenet.service.NetIndexDeaLinescoreService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * Created by mao on 2019/10/17.
 */
@RestController
@RequestMapping("/api/net/index/dea/linescore")
public class ApiNetIndexDeaLinescore {
	private static final Logger LOG = LoggerFactory.getLogger(ApiNetIndexDeaLinescore.class);
	@Resource
	private NetIndexDeaLinescoreService netIndexDeaLinescoreService;

	@PostMapping("/add")
	public Result add(@RequestBody NetIndexDeaLinescore netIndexDeaLinescore) {
		netIndexDeaLinescoreService.insertSelective(netIndexDeaLinescore);
		return ResultUtil.getSuccessResult();
	}

	@PostMapping("/delete")
	public Result delete(@RequestParam Integer id) {
		netIndexDeaLinescoreService.deleteByPrimaryKey(id);
		return ResultUtil.getSuccessResult();
	}

	@PostMapping("/update")
	public Result update(@RequestBody NetIndexDeaLinescore netIndexDeaLinescore) {
		netIndexDeaLinescoreService.updateByPrimaryKeySelective(netIndexDeaLinescore);
		return ResultUtil.getSuccessResult();
	}

	@PostMapping("/detail")
	public Result detail(@RequestParam Integer id) {
		NetIndexDeaLinescore netIndexDeaLinescore = netIndexDeaLinescoreService.selectByPrimaryKey(id);
		return ResultUtil.getSuccessResult(netIndexDeaLinescore);
	}

	@PostMapping("/list")
	public Result list(@RequestBody NetIndexDeaLinescoreVo netIndexDeaLinescoreVo) {

		// 判定是否包含分页参数，如果包含则为分页数据请求
		if (netIndexDeaLinescoreVo.getPageSize() != null && netIndexDeaLinescoreVo.getPageSize() != 0) {
			return pageList(netIndexDeaLinescoreVo);
		}

		// TODO 根据具体业务重写
		List<NetIndexDeaLinescore> list = netIndexDeaLinescoreService.select(null);

		return ResultUtil.getSuccessResult(list);
	}

	@PostMapping("/pageList")
	public Result pageList(@RequestBody NetIndexDeaLinescoreVo netIndexDeaLinescoreVo) {
		/*
		 * 方法一：
		 */
		// 分页数据请求处理
		PageHelper.startPage(netIndexDeaLinescoreVo.getPageNumber(), netIndexDeaLinescoreVo.getPageSize());
		// TODO 根据具体业务重写
		List<NetIndexDeaLinescore> list = netIndexDeaLinescoreService.select(null);
		return ResultUtil.getSuccessResult(new PageInfo<NetIndexDeaLinescore>(list));

		/*
		 * 方法二：
		 */
		// String orderBy = sort + " " + order;
		// PageInfo<NetIndexDeaLinescore> pageInfo =
		// netIndexDeaLinescoreService.selectPage(netIndexDeaLinescoreVo.getPageNumber(),
		// netIndexDeaLinescoreVo.getPageSize(), null);
		// return ResultUtil.getSuccessResult(pageInfo);

	}

	@PostMapping("/getDeaLineScoreGrid")
	public Result getDeaLineScoreGrid(@RequestBody NetDataBuslineVo vo) {
		try {
			GridChartOption options = netIndexDeaLinescoreService.getDeaLineScoreGrid(vo);
			LOG.info("获取数据总览-线路评分展示gridData数据：{}", options.toString());
			return ResultUtil.getSuccessResult(options);
		} catch (Exception e) {
			LOG.error("获取数据总览-线路评分展示gridData异常，原因：{}", e);
			return ResultUtil.getErrorResult();
		}
	}

	@AccessLogInfo(modelName = "数据分析", pageName = "线网评分")
	@PostMapping("/getDeaLineScoreListData")
	public Result getDeaLineScoreListData(@RequestBody NetDataBuslineVo vo) {
		try {
			List<NetIndexDeaLinescoreValue> list = netIndexDeaLinescoreService.getDeaLineScoreListData(vo);
			LOG.info("获取获取线网评分-列表Data数据：{}", list.toString());
			return ResultUtil.getSuccessResult(list);
		} catch (Exception e) {
			LOG.error("获取获取线网评分-列表Data异常，原因：{}", e);
			return ResultUtil.getErrorResult();
		}
	}

}
