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
import com.cictec.yyjk.linenet.model.entity.NetIndexPfOd;
import com.cictec.yyjk.linenet.model.view.GridChartOption;
import com.cictec.yyjk.linenet.model.view.NetIndexPfLineOdValue;
import com.cictec.yyjk.linenet.model.view.NodeLinkChart;
import com.cictec.yyjk.linenet.model.vo.NetIndexPfBaseVo;
import com.cictec.yyjk.linenet.model.vo.NetIndexPfOdVo;
import com.cictec.yyjk.linenet.service.NetIndexPfOdService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * Created by mao on 2019/10/16.
 */
@RestController
@RequestMapping("/api/net/index/pf/od")
public class ApiNetIndexPfOd {
	private static final Logger LOG = LoggerFactory.getLogger(ApiNetIndexPfOd.class);
	@Resource
	private NetIndexPfOdService netIndexPfOdService;

	// web映射地址
	@Value("${web.webrooturl}")
	private String webrooturl;

	@Autowired
	private Environment env;

	@PostMapping("/add")
	public Result add(@RequestBody NetIndexPfOd netIndexPfOd) {
		netIndexPfOdService.insertSelective(netIndexPfOd);
		return ResultUtil.getSuccessResult();
	}

	@PostMapping("/delete")
	public Result delete(@RequestParam Integer id) {
		netIndexPfOdService.deleteByPrimaryKey(id);
		return ResultUtil.getSuccessResult();
	}

	@PostMapping("/update")
	public Result update(@RequestBody NetIndexPfOd netIndexPfOd) {
		netIndexPfOdService.updateByPrimaryKeySelective(netIndexPfOd);
		return ResultUtil.getSuccessResult();
	}

	@PostMapping("/detail")
	public Result detail(@RequestParam Integer id) {
		NetIndexPfOd netIndexPfOd = netIndexPfOdService.selectByPrimaryKey(id);
		return ResultUtil.getSuccessResult(netIndexPfOd);
	}

	@PostMapping("/list")
	public Result list(@RequestBody NetIndexPfOdVo netIndexPfOdVo) {

		// 判定是否包含分页参数，如果包含则为分页数据请求
		if (netIndexPfOdVo.getPageSize() != null && netIndexPfOdVo.getPageSize() != 0) {
			return pageList(netIndexPfOdVo);
		}

		// TODO 根据具体业务重写
		List<NetIndexPfOd> list = netIndexPfOdService.select(null);

		return ResultUtil.getSuccessResult(list);
	}

	@PostMapping("/pageList")
	public Result pageList(@RequestBody NetIndexPfOdVo netIndexPfOdVo) {
		/*
		 * 方法一：
		 */
		// 分页数据请求处理
		PageHelper.startPage(netIndexPfOdVo.getPageNumber(), netIndexPfOdVo.getPageSize());
		// TODO 根据具体业务重写
		List<NetIndexPfOd> list = netIndexPfOdService.select(null);
		return ResultUtil.getSuccessResult(new PageInfo<NetIndexPfOd>(list));

		/*
		 * 方法二：
		 */
		// String orderBy = sort + " " + order;
		// PageInfo<NetIndexPfOd> pageInfo =
		// netIndexPfOdService.selectPage(netIndexPfOdVo.getPageNumber(),
		// netIndexPfOdVo.getPageSize(), null);
		// return ResultUtil.getSuccessResult(pageInfo);

	}

	@PostMapping("/getPfOdbrushCountListGridData")
	public Result getPfOdbrushCountListGridData(@RequestBody NetIndexPfBaseVo vo) {
		try {
			GridChartOption options = netIndexPfOdService.getPfOdbrushCountListGridData(vo);
			LOG.info("获取线路各时间段客流详情-刷卡总量Griddata数据：{}", options.toString());
			return ResultUtil.getSuccessResult(options);
		} catch (Exception e) {
			LOG.error("获取线路各时间段客流详情-刷卡总量Griddata异常，原因：{}", e);
			return ResultUtil.getErrorResult();
		}
	}

	@PostMapping("/getPfOdZZLListGridData")
	public Result getPfOdZZLListGridData(@RequestBody NetIndexPfBaseVo vo) {
		try {
			GridChartOption options = netIndexPfOdService.getPfOdZZLListGridData(vo);
			LOG.info("获取线路各时间段客流详情-周转量Griddata数据：{}", options.toString());
			return ResultUtil.getSuccessResult(options);
		} catch (Exception e) {
			LOG.error("获取线路各时间段客流详情-周转量Griddata异常，原因：{}", e);
			return ResultUtil.getErrorResult();
		}
	}

	@PostMapping("/getPfOdPJYJListGridData")
	public Result getPfOdPJYJListGridData(@RequestBody NetIndexPfBaseVo vo) {
		try {
			GridChartOption options = netIndexPfOdService.getPfOdPJYJListGridData(vo);
			LOG.info("获取线路各时间段客流详情-平均运距Griddata数据：{}", options.toString());
			return ResultUtil.getSuccessResult(options);
		} catch (Exception e) {
			LOG.error("获取线路各时间段客流详情-平均运距Griddata异常，原因：{}", e);
			return ResultUtil.getErrorResult();
		}
	}

	@AccessLogInfo(modelName = "数据分析", pageName = "线路OD")
	@PostMapping("/getPfLineOdCountListData")
	public Result getPfLineOdCountListData(@RequestBody NetIndexPfBaseVo vo) {
		try {
			List<NetIndexPfLineOdValue> list = netIndexPfOdService.getPfLineOdCountListData(vo);
			LOG.info("获取线路OD列表data数据：{}", list.toString());
			return ResultUtil.getSuccessResult(list);
		} catch (Exception e) {
			LOG.error("获取线路OD列表data异常，原因：{}", e);
			return ResultUtil.getErrorResult();
		}
	}

	@PostMapping("/export")
	public Result export(@RequestBody NetIndexPfBaseVo vo) {
		String envPath = env.getProperty("spring.resources.static-locations");
		String srcFilePath = envPath.substring(envPath.indexOf(":") + 1) + "lineODExport.xls";
		String fileName = String.format("lineODExport%s.xls",
				new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
		String tempFilePath = envPath.substring(envPath.indexOf(":") + 1) + "upload" + File.separator + fileName;
		List<NetIndexPfLineOdValue> list = netIndexPfOdService.getPfLineOdCountListData(vo);
		if (list != null && list.size() == 0) {
			return ResultUtil.getErrorResult("没有导出记录！");
		}
		if (list != null && list.size() > 65535) {
			list = list.subList(0, 65534);
		}
		List<List<String>> data = new ArrayList<List<String>>();
		for (NetIndexPfLineOdValue item : list) {
			List<String> row = new ArrayList<>();
			row.add(item.getCompany());
			row.add(item.getLineNumber());
			row.add(item.getArrow());
			row.add(item.getsStationName());
			row.add(item.getsStationIndex() + "");
			row.add(item.geteStationName());
			row.add(item.geteStationIndex() + "");
			row.add(item.getBrushCount() + "");
			row.add(item.getpDate());
			data.add(row);
		}
		File tempFile = new File(tempFilePath);
		try {
			FileOperUtils.writeExcel(new File(srcFilePath), tempFile, 0, 1, data);
			JSONObject json = new JSONObject();
			json.put("url", webrooturl + "exceltemplate/upload/" + fileName);
			LOG.info("导出线路OD数据下载文件:{}", fileName);
			return ResultUtil.getSuccessResult(json);
		} catch (Exception ex) {
			LOG.error("导出线路OD数据失败！{}", ex);
			return ResultUtil.getErrorResult("导出线路OD数据失败！");
		}
	}

	@PostMapping("/getPfODXCountListData")
	public Result getPfODXCountListData(@RequestBody NetIndexPfBaseVo vo) {
		try {
			List<NetIndexPfLineOdValue> list = netIndexPfOdService.getPfODXCountListData(vo);
			LOG.info("获取线路OD图X轴数据：{}", list.toString());
			return ResultUtil.getSuccessResult(list);
		} catch (Exception e) {
			LOG.error("获取线路OD图X轴数据异常，原因：{}", e);
			return ResultUtil.getErrorResult();
		}
	}

	@PostMapping("/getPfODYCountListData")
	public Result getPfODYCountListData(@RequestBody NetIndexPfBaseVo vo) {
		try {
			NodeLinkChart chart = netIndexPfOdService.getPfODYCountListData(vo);
			LOG.info("获取线路OD图data数据：{}", chart.toString());
			return ResultUtil.getSuccessResult(chart);
		} catch (Exception e) {
			LOG.error("获取线路OD图data数据异常，原因：{}", e);
			return ResultUtil.getErrorResult();
		}
	}

}
