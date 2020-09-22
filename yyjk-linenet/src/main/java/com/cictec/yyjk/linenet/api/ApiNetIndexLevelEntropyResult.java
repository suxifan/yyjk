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
import com.cictec.yyjk.linenet.model.entity.NetIndexLevelEntropyResult;
import com.cictec.yyjk.linenet.model.view.NetIndexLevelEntropyResultVoValue;
import com.cictec.yyjk.linenet.model.vo.NetDataBuslineVo;
import com.cictec.yyjk.linenet.model.vo.NetIndexLevelEntropyResultVo;
import com.cictec.yyjk.linenet.service.NetIndexLevelEntropyResultService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * Created by mao on 2019/10/17.
 */
@RestController
@RequestMapping("/api/net/index/level/entropy/result")
public class ApiNetIndexLevelEntropyResult {
	private static final Logger LOG = LoggerFactory.getLogger(ApiNetIndexLevelEntropyResult.class);
	@Resource
	private NetIndexLevelEntropyResultService netIndexLevelEntropyResultService;

	@PostMapping("/add")
	public Result add(@RequestBody NetIndexLevelEntropyResult netIndexLevelEntropyResult) {
		netIndexLevelEntropyResultService.insertSelective(netIndexLevelEntropyResult);
		return ResultUtil.getSuccessResult();
	}

	@PostMapping("/delete")
	public Result delete(@RequestParam Integer id) {
		netIndexLevelEntropyResultService.deleteByPrimaryKey(id);
		return ResultUtil.getSuccessResult();
	}

	@PostMapping("/update")
	public Result update(@RequestBody NetIndexLevelEntropyResult netIndexLevelEntropyResult) {
		netIndexLevelEntropyResultService.updateByPrimaryKeySelective(netIndexLevelEntropyResult);
		return ResultUtil.getSuccessResult();
	}

	@PostMapping("/detail")
	public Result detail(@RequestParam Integer id) {
		NetIndexLevelEntropyResult netIndexLevelEntropyResult = netIndexLevelEntropyResultService
				.selectByPrimaryKey(id);
		return ResultUtil.getSuccessResult(netIndexLevelEntropyResult);
	}

	@PostMapping("/list")
	public Result list(@RequestBody NetIndexLevelEntropyResultVo netIndexLevelEntropyResultVo) {

		// 判定是否包含分页参数，如果包含则为分页数据请求
		if (netIndexLevelEntropyResultVo.getPageSize() != null && netIndexLevelEntropyResultVo.getPageSize() != 0) {
			return pageList(netIndexLevelEntropyResultVo);
		}

		// TODO 根据具体业务重写
		List<NetIndexLevelEntropyResult> list = netIndexLevelEntropyResultService.select(null);

		return ResultUtil.getSuccessResult(list);
	}

	@PostMapping("/pageList")
	public Result pageList(@RequestBody NetIndexLevelEntropyResultVo netIndexLevelEntropyResultVo) {
		/*
		 * 方法一：
		 */
		// 分页数据请求处理
		PageHelper.startPage(netIndexLevelEntropyResultVo.getPageNumber(), netIndexLevelEntropyResultVo.getPageSize());
		// TODO 根据具体业务重写
		List<NetIndexLevelEntropyResult> list = netIndexLevelEntropyResultService.select(null);
		return ResultUtil.getSuccessResult(new PageInfo<NetIndexLevelEntropyResult>(list));

		/*
		 * 方法二：
		 */
		// String orderBy = sort + " " + order;
		// PageInfo<NetIndexLevelEntropyResult> pageInfo =
		// netIndexLevelEntropyResultService.selectPage(netIndexLevelEntropyResultVo.getPageNumber(),
		// netIndexLevelEntropyResultVo.getPageSize(), null);
		// return ResultUtil.getSuccessResult(pageInfo);

	}

	@PostMapping("/getLevelLineCountListData")
	public Result getLevelLineCountListData(@RequestBody NetDataBuslineVo vo) {
		try {
			List<NetIndexLevelEntropyResultVoValue> list = netIndexLevelEntropyResultService
					.getLevelLineCountListData(vo);
			LOG.info("获取线路时段登降量griddata数据：{}", list.toString());
			return ResultUtil.getSuccessResult(list);
		} catch (Exception e) {
			LOG.error("获取线路时段登降量griddata异常，原因：{}", e);
			return ResultUtil.getErrorResult();
		}
	}

}
