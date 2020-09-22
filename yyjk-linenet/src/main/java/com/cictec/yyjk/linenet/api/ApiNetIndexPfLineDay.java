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
import com.cictec.yyjk.linenet.model.entity.NetIndexPfLineDay;
import com.cictec.yyjk.linenet.model.view.NetIndexPfLineDayValue;
import com.cictec.yyjk.linenet.model.vo.NetIndexPfBaseVo;
import com.cictec.yyjk.linenet.model.vo.NetIndexPfLineDayVo;
import com.cictec.yyjk.linenet.service.NetIndexPfLineDayService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * Created by mao on 2019/10/16.
 */
@RestController
@RequestMapping("/api/net/index/pf/line/day")
public class ApiNetIndexPfLineDay {
	private static final Logger LOG = LoggerFactory.getLogger(ApiNetIndexPfLineDay.class);
	@Resource
	private NetIndexPfLineDayService netIndexPfLineDayService;

	// web映射地址
	@Value("${web.webrooturl}")
	private String webrooturl;

	@Autowired
	private Environment env;

	@PostMapping("/add")
	public Result add(@RequestBody NetIndexPfLineDay netIndexPfLineDay) {
		netIndexPfLineDayService.insertSelective(netIndexPfLineDay);
		return ResultUtil.getSuccessResult();
	}

	@PostMapping("/delete")
	public Result delete(@RequestParam Integer id) {
		netIndexPfLineDayService.deleteByPrimaryKey(id);
		return ResultUtil.getSuccessResult();
	}

	@PostMapping("/update")
	public Result update(@RequestBody NetIndexPfLineDay netIndexPfLineDay) {
		netIndexPfLineDayService.updateByPrimaryKeySelective(netIndexPfLineDay);
		return ResultUtil.getSuccessResult();
	}

	@PostMapping("/detail")
	public Result detail(@RequestParam Integer id) {
		NetIndexPfLineDay netIndexPfLineDay = netIndexPfLineDayService.selectByPrimaryKey(id);
		return ResultUtil.getSuccessResult(netIndexPfLineDay);
	}

	@PostMapping("/list")
	public Result list(@RequestBody NetIndexPfLineDayVo netIndexPfLineDayVo) {

		// 判定是否包含分页参数，如果包含则为分页数据请求
		if (netIndexPfLineDayVo.getPageSize() != null && netIndexPfLineDayVo.getPageSize() != 0) {
			return pageList(netIndexPfLineDayVo);
		}

		// TODO 根据具体业务重写
		List<NetIndexPfLineDay> list = netIndexPfLineDayService.select(null);

		return ResultUtil.getSuccessResult(list);
	}

	@PostMapping("/pageList")
	public Result pageList(@RequestBody NetIndexPfLineDayVo netIndexPfLineDayVo) {
		/*
		 * 方法一：
		 */
		// 分页数据请求处理
		PageHelper.startPage(netIndexPfLineDayVo.getPageNumber(), netIndexPfLineDayVo.getPageSize());
		// TODO 根据具体业务重写
		List<NetIndexPfLineDay> list = netIndexPfLineDayService.select(null);
		return ResultUtil.getSuccessResult(new PageInfo<NetIndexPfLineDay>(list));

		/*
		 * 方法二：
		 */
		// String orderBy = sort + " " + order;
		// PageInfo<NetIndexPfLineDay> pageInfo =
		// netIndexPfLineDayService.selectPage(netIndexPfLineDayVo.getPageNumber(),
		// netIndexPfLineDayVo.getPageSize(), null);
		// return ResultUtil.getSuccessResult(pageInfo);

	}

	@AccessLogInfo(modelName = "数据分析", pageName = "线路客流综合查询")
	@PostMapping("/getIndexPfLineDayListData")
	public Result getIndexPfLineDayListData(@RequestBody NetIndexPfBaseVo vo) {
		try {
			List<NetIndexPfLineDayValue> list = netIndexPfLineDayService.getIndexPfLineDayListData(vo);
			LOG.info("获取线路客流综合查询列表listdata数据：{}", list.toString());
			return ResultUtil.getSuccessResult(list);
		} catch (Exception e) {
			LOG.error("获取线路客流综合查询列表listdata异常，原因：{}", e);
			return ResultUtil.getErrorResult();
		}
	}

	@PostMapping("/export")
	public Result export(@RequestBody NetIndexPfBaseVo vo) {
		String envPath = env.getProperty("spring.resources.static-locations");
		String srcFilePath = envPath.substring(envPath.indexOf(":") + 1) + "linePFComprehensiveExport.xls";
		String fileName = String.format("linePFComprehensiveExport%s.xls",
				new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
		String tempFilePath = envPath.substring(envPath.indexOf(":") + 1) + "upload" + File.separator + fileName;
		List<NetIndexPfLineDayValue> list = netIndexPfLineDayService.getIndexPfLineDayListData(vo);
		if (list != null && list.size() == 0) {
			return ResultUtil.getErrorResult("没有导出记录！");
		}
		if (list != null && list.size() > 65535) {
			list = list.subList(0, 65534);
		}
		List<List<String>> data = new ArrayList<List<String>>();
		for (NetIndexPfLineDayValue item : list) {
			List<String> row = new ArrayList<>();
			row.add(item.getCompany());
			row.add(item.getLineNumber());
			row.add(item.getArrow());
			row.add(item.getBrushCount() + "");
			row.add(item.getZzl() + "");
			row.add(item.getPjyj() + "");
			data.add(row);
		}
		File tempFile = new File(tempFilePath);
		try {
			FileOperUtils.writeExcel(new File(srcFilePath), tempFile, 0, 1, data);
			JSONObject json = new JSONObject();
			json.put("url", webrooturl + "exceltemplate/upload/" + fileName);
			LOG.info("导出线路客流综合查询数据下载文件:{}", fileName);
			return ResultUtil.getSuccessResult(json);
		} catch (Exception ex) {
			LOG.error("导出线路客流综合查询数据失败！{}", ex);
			return ResultUtil.getErrorResult("导出线路客流综合查询数据失败！");
		}
	}

	@PostMapping("/getDayPfTOP10ListData")
	public Result getDayPfTOP10ListData(@RequestBody NetIndexPfBaseVo vo) {
		try {
			List<NetIndexPfLineDayValue> list = netIndexPfLineDayService.getDayPfTOP10ListData(vo);
			LOG.info("获取数据总览线路日均客流TOP10列表listdata数据：{}", list.toString());
			return ResultUtil.getSuccessResult(list);
		} catch (Exception e) {
			LOG.error("获取数据总览线路日均客流TOP10列表listdata异常，原因：{}", e);
			return ResultUtil.getErrorResult();
		}
	}

}
