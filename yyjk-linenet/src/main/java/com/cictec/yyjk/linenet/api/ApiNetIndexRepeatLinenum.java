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
import com.cictec.yyjk.linenet.model.entity.NetIndexRepeatLinenum;
import com.cictec.yyjk.linenet.model.view.GridRadarOption;
import com.cictec.yyjk.linenet.model.vo.NetDataBuslineVo;
import com.cictec.yyjk.linenet.model.vo.NetIndexRepeatLinenumVo;
import com.cictec.yyjk.linenet.service.NetIndexRepeatLinenumService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * Created by mao on 2019/10/14.
 */
@RestController
@RequestMapping("/api/net/index/repeat/linenum")
public class ApiNetIndexRepeatLinenum {
	private static final Logger LOG = LoggerFactory.getLogger(ApiNetIndexRepeatLinenum.class);
	@Resource
	private NetIndexRepeatLinenumService netIndexRepeatLinenumService;

	@PostMapping("/add")
	public Result add(@RequestBody NetIndexRepeatLinenum netIndexRepeatLinenum) {
		netIndexRepeatLinenumService.insertSelective(netIndexRepeatLinenum);
		return ResultUtil.getSuccessResult();
	}

	@PostMapping("/delete")
	public Result delete(@RequestParam Integer id) {
		netIndexRepeatLinenumService.deleteByPrimaryKey(id);
		return ResultUtil.getSuccessResult();
	}

	@PostMapping("/update")
	public Result update(@RequestBody NetIndexRepeatLinenum netIndexRepeatLinenum) {
		netIndexRepeatLinenumService.updateByPrimaryKeySelective(netIndexRepeatLinenum);
		return ResultUtil.getSuccessResult();
	}

	@PostMapping("/detail")
	public Result detail(@RequestParam Integer id) {
		NetIndexRepeatLinenum netIndexRepeatLinenum = netIndexRepeatLinenumService.selectByPrimaryKey(id);
		return ResultUtil.getSuccessResult(netIndexRepeatLinenum);
	}

	@PostMapping("/list")
	public Result list(@RequestBody NetIndexRepeatLinenumVo netIndexRepeatLinenumVo) {

		// 判定是否包含分页参数，如果包含则为分页数据请求
		if (netIndexRepeatLinenumVo.getPageSize() != null && netIndexRepeatLinenumVo.getPageSize() != 0) {
			return pageList(netIndexRepeatLinenumVo);
		}

		// TODO 根据具体业务重写
		List<NetIndexRepeatLinenum> list = netIndexRepeatLinenumService.select(null);

		return ResultUtil.getSuccessResult(list);
	}

	@PostMapping("/pageList")
	public Result pageList(@RequestBody NetIndexRepeatLinenumVo netIndexRepeatLinenumVo) {
		/*
		 * 方法一：
		 */
		// 分页数据请求处理
		PageHelper.startPage(netIndexRepeatLinenumVo.getPageNumber(), netIndexRepeatLinenumVo.getPageSize());
		// TODO 根据具体业务重写
		List<NetIndexRepeatLinenum> list = netIndexRepeatLinenumService.select(null);
		return ResultUtil.getSuccessResult(new PageInfo<NetIndexRepeatLinenum>(list));

		/*
		 * 方法二：
		 */
		// String orderBy = sort + " " + order;
		// PageInfo<NetIndexRepeatLinenum> pageInfo =
		// netIndexRepeatLinenumService.selectPage(netIndexRepeatLinenumVo.getPageNumber(),
		// netIndexRepeatLinenumVo.getPageSize(), null);
		// return ResultUtil.getSuccessResult(pageInfo);

	}

	@PostMapping("/getCompanyLineNumRepeatPieData")
	public Result getCompanyLineNumRepeatPieData(@RequestBody NetDataBuslineVo vo) {
		try {
			GridRadarOption gridRadarOption = netIndexRepeatLinenumService.getCompanyLineNumRepeatPieData(vo);
			LOG.info("获取分公司下线路重复度Radardata数据：{}", gridRadarOption.toString());
			return ResultUtil.getSuccessResult(gridRadarOption);
		} catch (Exception e) {
			LOG.error("获取分公司下线路重复度Radardata异常，原因：{}", e);
			return ResultUtil.getErrorResult();
		}
	}

}
