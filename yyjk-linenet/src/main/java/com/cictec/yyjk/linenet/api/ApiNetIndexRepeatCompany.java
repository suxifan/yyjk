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
import com.cictec.yyjk.linenet.model.entity.NetIndexRepeatCompany;
import com.cictec.yyjk.linenet.model.view.GridChartOption;
import com.cictec.yyjk.linenet.model.vo.NetDataBuslineVo;
import com.cictec.yyjk.linenet.model.vo.NetIndexRepeatCompanyVo;
import com.cictec.yyjk.linenet.service.NetIndexRepeatCompanyService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * Created by mao on 2019/10/14.
 */
@RestController
@RequestMapping("/api/net/index/repeat/company")
public class ApiNetIndexRepeatCompany {
	private static final Logger LOG = LoggerFactory.getLogger(ApiNetIndexRepeatCompany.class);
	@Resource
	private NetIndexRepeatCompanyService netIndexRepeatCompanyService;

	@PostMapping("/add")
	public Result add(@RequestBody NetIndexRepeatCompany netIndexRepeatCompany) {
		netIndexRepeatCompanyService.insertSelective(netIndexRepeatCompany);
		return ResultUtil.getSuccessResult();
	}

	@PostMapping("/delete")
	public Result delete(@RequestParam Integer id) {
		netIndexRepeatCompanyService.deleteByPrimaryKey(id);
		return ResultUtil.getSuccessResult();
	}

	@PostMapping("/update")
	public Result update(@RequestBody NetIndexRepeatCompany netIndexRepeatCompany) {
		netIndexRepeatCompanyService.updateByPrimaryKeySelective(netIndexRepeatCompany);
		return ResultUtil.getSuccessResult();
	}

	@PostMapping("/detail")
	public Result detail(@RequestParam Integer id) {
		NetIndexRepeatCompany netIndexRepeatCompany = netIndexRepeatCompanyService.selectByPrimaryKey(id);
		return ResultUtil.getSuccessResult(netIndexRepeatCompany);
	}

	@PostMapping("/list")
	public Result list(@RequestBody NetIndexRepeatCompanyVo netIndexRepeatCompanyVo) {

		// 判定是否包含分页参数，如果包含则为分页数据请求
		if (netIndexRepeatCompanyVo.getPageSize() != null && netIndexRepeatCompanyVo.getPageSize() != 0) {
			return pageList(netIndexRepeatCompanyVo);
		}

		// TODO 根据具体业务重写
		List<NetIndexRepeatCompany> list = netIndexRepeatCompanyService.select(null);

		return ResultUtil.getSuccessResult(list);
	}

	@PostMapping("/pageList")
	public Result pageList(@RequestBody NetIndexRepeatCompanyVo netIndexRepeatCompanyVo) {
		/*
		 * 方法一：
		 */
		// 分页数据请求处理
		PageHelper.startPage(netIndexRepeatCompanyVo.getPageNumber(), netIndexRepeatCompanyVo.getPageSize());
		// TODO 根据具体业务重写
		List<NetIndexRepeatCompany> list = netIndexRepeatCompanyService.select(null);
		return ResultUtil.getSuccessResult(new PageInfo<NetIndexRepeatCompany>(list));

		/*
		 * 方法二：
		 */
		// String orderBy = sort + " " + order;
		// PageInfo<NetIndexRepeatCompany> pageInfo =
		// netIndexRepeatCompanyService.selectPage(netIndexRepeatCompanyVo.getPageNumber(),
		// netIndexRepeatCompanyVo.getPageSize(), null);
		// return ResultUtil.getSuccessResult(pageInfo);

	}

	@PostMapping("/getCompanyLineRepeatEchartData")
	public Result getCompanyLineRepeatEchartData(@RequestBody NetDataBuslineVo vo) {
		try {
			GridChartOption options = netIndexRepeatCompanyService.getCompanyLineRepeatEchartData(vo);
			LOG.info("获取分公司线路重复度echartsdata数据：{}", options.toString());
			return ResultUtil.getSuccessResult(options);
		} catch (Exception e) {
			LOG.error("获取分公司线路重复度echartsdata异常，原因：{}", e);
			return ResultUtil.getErrorResult();
		}
	}

}
