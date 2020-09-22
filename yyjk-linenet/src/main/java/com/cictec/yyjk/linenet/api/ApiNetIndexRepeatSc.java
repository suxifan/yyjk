package com.cictec.yyjk.linenet.api;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.cictec.yyjk.base.interceptors.AccessLogInfo;
import com.cictec.yyjk.commons.core.Result;
import com.cictec.yyjk.commons.core.ResultUtil;
import com.cictec.yyjk.commons.utils.FileOperUtils;
import com.cictec.yyjk.linenet.model.entity.NetIndexRepeatSc;
import com.cictec.yyjk.linenet.model.view.NetIndexRepeatScValue;
import com.cictec.yyjk.linenet.model.vo.NetIndexRepeatScVo;
import com.cictec.yyjk.linenet.service.NetIndexRepeatScService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * Created by mao on 2019/10/14.
 */
@RestController
@RequestMapping("/api/net/index/repeat/sc")
public class ApiNetIndexRepeatSc {
	private static final Logger LOG = LoggerFactory.getLogger(ApiNetIndexRepeatSc.class);
	@Resource
	private NetIndexRepeatScService netIndexRepeatScService;

	// web映射地址
	@Value("${web.webrooturl}")
	private String webrooturl;

	@Autowired
	private Environment env;

	@PostMapping("/add")
	public Result add(@RequestBody NetIndexRepeatSc netIndexRepeatSc) {
		netIndexRepeatScService.insertSelective(netIndexRepeatSc);
		return ResultUtil.getSuccessResult();
	}

	@PostMapping("/delete")
	public Result delete(@RequestParam Integer id) {
		netIndexRepeatScService.deleteByPrimaryKey(id);
		return ResultUtil.getSuccessResult();
	}

	@PostMapping("/update")
	public Result update(@RequestBody NetIndexRepeatSc netIndexRepeatSc) {
		netIndexRepeatScService.updateByPrimaryKeySelective(netIndexRepeatSc);
		return ResultUtil.getSuccessResult();
	}

	@PostMapping("/detail")
	public Result detail(@RequestParam Integer id) {
		NetIndexRepeatSc netIndexRepeatSc = netIndexRepeatScService.selectByPrimaryKey(id);
		return ResultUtil.getSuccessResult(netIndexRepeatSc);
	}

	@PostMapping("/list")
	public Result list(@RequestBody NetIndexRepeatScVo netIndexRepeatScVo) {

		// 判定是否包含分页参数，如果包含则为分页数据请求
		if (netIndexRepeatScVo.getPageSize() != null && netIndexRepeatScVo.getPageSize() != 0) {
			return pageList(netIndexRepeatScVo);
		}

		// TODO 根据具体业务重写
		List<NetIndexRepeatSc> list = netIndexRepeatScService.select(null);

		return ResultUtil.getSuccessResult(list);
	}

	@PostMapping("/pageList")
	public Result pageList(@RequestBody NetIndexRepeatScVo netIndexRepeatScVo) {
		/*
		 * 方法一：
		 */
		// 分页数据请求处理
		PageHelper.startPage(netIndexRepeatScVo.getPageNumber(), netIndexRepeatScVo.getPageSize());
		// TODO 根据具体业务重写
		List<NetIndexRepeatSc> list = netIndexRepeatScService.select(null);
		return ResultUtil.getSuccessResult(new PageInfo<NetIndexRepeatSc>(list));

		/*
		 * 方法二：
		 */
		// String orderBy = sort + " " + order;
		// PageInfo<NetIndexRepeatSc> pageInfo =
		// netIndexRepeatScService.selectPage(netIndexRepeatScVo.getPageNumber(),
		// netIndexRepeatScVo.getPageSize(), null);
		// return ResultUtil.getSuccessResult(pageInfo);

	}

	@AccessLogInfo(modelName = "数据分析", pageName = "重复度指标详情")
	@PostMapping("/getCompanyLineRepeatScListData")
	public Result getCompanyLineRepeatScListData(@RequestBody NetIndexRepeatScVo vo) {
		try {
			// 分页数据请求处理
			PageHelper.startPage(vo.getPageNumber(), vo.getPageSize());
			List<NetIndexRepeatScValue> list = netIndexRepeatScService.getCompanyLineRepeatScListData(vo);
			LOG.info("获取重复度指标链接列表Listdata数据：{}", list.toString());
			return ResultUtil.getSuccessResult(new PageInfo<NetIndexRepeatScValue>(list));
		} catch (Exception e) {
			LOG.error("获取分公司下线路重复度Listdata异常，原因：{}", e);
			return ResultUtil.getErrorResult();
		}
	}

	@PostMapping("/export")
	public Result export(@RequestBody NetIndexRepeatScVo vo) {
		String envPath = env.getProperty("spring.resources.static-locations");
		String srcFilePath = envPath.substring(envPath.indexOf(":") + 1) + "repeatScDetailExport.xls";
		String fileName = String.format("repeatScDetailExport%s.xls",
				new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
		String tempFilePath = envPath.substring(envPath.indexOf(":") + 1) + "upload" + File.separator + fileName;
		List<NetIndexRepeatScValue> list = netIndexRepeatScService.getCompanyLineRepeatScListData(vo);
		if (list != null && list.size() == 0) {
			return ResultUtil.getErrorResult("没有导出记录！");
		}
		if (list != null && list.size() > 65535) {
			list = list.subList(0, 65534);
		}
		List<List<String>> data = new ArrayList<List<String>>();
		for (NetIndexRepeatScValue item : list) {
			List<String> row = new ArrayList<>();
			row.add(item.getCompany());
			row.add(item.getLineNumber());
			row.add(item.getArrow());
			row.add(item.getLinename());
			row.add(item.getsStationIndex() + "");
			row.add(item.geteStationIndex() + "");
			row.add(item.getsStation());
			row.add(item.geteStation());
			row.add(item.getRepeatLine());
			row.add(item.getRepeatLineCount() + "");
			data.add(row);
		}
		File tempFile = new File(tempFilePath);
		try {
			FileOperUtils.writeExcel(new File(srcFilePath), tempFile, 0, 1, data);
			JSONObject json = new JSONObject();
			json.put("url", webrooturl + "exceltemplate/upload/" + fileName);
			LOG.info("导出重复度指标详情查询数据下载文件:{}", fileName);
			return ResultUtil.getSuccessResult(json);
		} catch (Exception ex) {
			LOG.error("导出重复度指标详情查询数据失败！{}", ex);
			return ResultUtil.getErrorResult("导出重复度指标详情查询数据失败！");
		}
	}

}
