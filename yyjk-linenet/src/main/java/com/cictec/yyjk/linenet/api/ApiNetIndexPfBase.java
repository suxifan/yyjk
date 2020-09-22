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
import com.cictec.yyjk.commons.core.Result;
import com.cictec.yyjk.commons.core.ResultUtil;
import com.cictec.yyjk.commons.utils.FileOperUtils;
import com.cictec.yyjk.linenet.model.entity.NetIndexPfBase;
import com.cictec.yyjk.linenet.model.view.GridChartOption;
import com.cictec.yyjk.linenet.model.view.NetIndexPfBaseValue;
import com.cictec.yyjk.linenet.model.vo.NetIndexPfBaseVo;
import com.cictec.yyjk.linenet.service.NetIndexPfBaseService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * Created by mao on 2019/10/14.
 */
@RestController
@RequestMapping("/api/net/index/pf/base")
public class ApiNetIndexPfBase {
	private static final Logger LOG = LoggerFactory.getLogger(ApiNetIndexPfBase.class);
	@Resource
	private NetIndexPfBaseService netIndexPfBaseService;
	// web映射地址
	@Value("${web.webrooturl}")
	private String webrooturl;

	@Autowired
	private Environment env;

	@PostMapping("/add")
	public Result add(@RequestBody NetIndexPfBase netIndexPfBase) {
		netIndexPfBaseService.insertSelective(netIndexPfBase);
		return ResultUtil.getSuccessResult();
	}

	@PostMapping("/delete")
	public Result delete(@RequestParam Integer id) {
		netIndexPfBaseService.deleteByPrimaryKey(id);
		return ResultUtil.getSuccessResult();
	}

	@PostMapping("/update")
	public Result update(@RequestBody NetIndexPfBase netIndexPfBase) {
		netIndexPfBaseService.updateByPrimaryKeySelective(netIndexPfBase);
		return ResultUtil.getSuccessResult();
	}

	@PostMapping("/detail")
	public Result detail(@RequestParam Integer id) {
		NetIndexPfBase netIndexPfBase = netIndexPfBaseService.selectByPrimaryKey(id);
		return ResultUtil.getSuccessResult(netIndexPfBase);
	}

	@PostMapping("/list")
	public Result list(@RequestBody NetIndexPfBaseVo netIndexPfBaseVo) {

		// 判定是否包含分页参数，如果包含则为分页数据请求
		if (netIndexPfBaseVo.getPageSize() != null && netIndexPfBaseVo.getPageSize() != 0) {
			return pageList(netIndexPfBaseVo);
		}

		// TODO 根据具体业务重写
		List<NetIndexPfBase> list = netIndexPfBaseService.select(null);

		return ResultUtil.getSuccessResult(list);
	}

	@PostMapping("/pageList")
	public Result pageList(@RequestBody NetIndexPfBaseVo netIndexPfBaseVo) {
		/*
		 * 方法一：
		 */
		// 分页数据请求处理
		PageHelper.startPage(netIndexPfBaseVo.getPageNumber(), netIndexPfBaseVo.getPageSize());
		// TODO 根据具体业务重写
		List<NetIndexPfBase> list = netIndexPfBaseService.select(null);
		return ResultUtil.getSuccessResult(new PageInfo<NetIndexPfBase>(list));

		/*
		 * 方法二：
		 */
		// String orderBy = sort + " " + order;
		// PageInfo<NetIndexPfBase> pageInfo =
		// netIndexPfBaseService.selectPage(netIndexPfBaseVo.getPageNumber(),
		// netIndexPfBaseVo.getPageSize(), null);
		// return ResultUtil.getSuccessResult(pageInfo);

	}

	@PostMapping("/getPfBaseListData")
	public Result getPfBaseListData(@RequestBody NetIndexPfBaseVo vo) {
		try {
			List<NetIndexPfBaseValue> list = netIndexPfBaseService.getPfBaseListData(vo);
			LOG.info("获取线路站点客流综合listdata数据：{}", list.toString());
			return ResultUtil.getSuccessResult(list);
		} catch (Exception e) {
			LOG.error("获取线路站点客流综合listdata异常，原因：{}", e);
			return ResultUtil.getErrorResult();
		}
	}

	@PostMapping("/export")
	public Result export(@RequestBody NetIndexPfBaseVo vo) {
		String envPath = env.getProperty("spring.resources.static-locations");
		String srcFilePath = envPath.substring(envPath.indexOf(":") + 1) + "dataSynthesisQueryExport.xls";
		String fileName = String.format("dataSynthesisQueryExport%s.xls",
				new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
		String tempFilePath = envPath.substring(envPath.indexOf(":") + 1) + "upload" + File.separator + fileName;
		List<NetIndexPfBaseValue> list = netIndexPfBaseService.getPfBaseListData(vo);
		if (list != null && list.size() == 0) {
			return ResultUtil.getErrorResult("没有导出记录！");
		}
		if (list != null && list.size() > 65535) {
			list = list.subList(0, 65534);
		}
		List<List<String>> data = new ArrayList<List<String>>();
		for (NetIndexPfBaseValue item : list) {
			List<String> row = new ArrayList<>();
			row.add(item.getCompany());
			row.add(item.getLineNumber());
			row.add(item.getArrow());
			row.add(item.getStationIndex() + "");
			row.add(item.getStationName());
			row.add(item.getUpCount() + "");
			row.add(item.getDownCount() + "");
			row.add(item.getPassCount() + "");
			row.add(item.getApproval() + "");
			data.add(row);
		}
		File tempFile = new File(tempFilePath);
		try {
			FileOperUtils.writeExcel(new File(srcFilePath), tempFile, 0, 1, data);
			JSONObject json = new JSONObject();
			json.put("url", webrooturl + "exceltemplate/upload/" + fileName);
			LOG.info("导出数据综合查询数据下载文件:{}", fileName);
			return ResultUtil.getSuccessResult(json);
		} catch (Exception ex) {
			LOG.error("导出数据综合查询数据失败！{}", ex);
			return ResultUtil.getErrorResult("导出数据综合查询数据失败！");
		}
	}

	@PostMapping("/getPfBaseApprovalGrid")
	public Result getPfBaseApprovalGrid(@RequestBody NetIndexPfBaseVo vo) {
		try {
			GridChartOption options = netIndexPfBaseService.getPfBaseApprovalGrid(vo);
			LOG.info("获取线路时段满载率griddata数据：{}", options.toString());
			return ResultUtil.getSuccessResult(options);
		} catch (Exception e) {
			LOG.error("获取线路时段满载率griddata异常，原因：{}", e);
			return ResultUtil.getErrorResult();
		}
	}

	@PostMapping("/getPfBaseUpDownGrid")
	public Result getPfBaseUpDownGrid(@RequestBody NetIndexPfBaseVo vo) {
		try {
			GridChartOption options = netIndexPfBaseService.getPfBaseUpDownGrid(vo);
			LOG.info("获取线路时段登降量griddata数据：{}", options.toString());
			return ResultUtil.getSuccessResult(options);
		} catch (Exception e) {
			LOG.error("获取线路时段登降量griddata异常，原因：{}", e);
			return ResultUtil.getErrorResult();
		}
	}

}
