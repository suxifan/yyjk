package com.cictec.yyjk.linenet.api;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.cictec.yyjk.commons.core.Result;
import com.cictec.yyjk.commons.core.ResultUtil;
import com.cictec.yyjk.linenet.model.entity.NetDataConfig;
import com.cictec.yyjk.linenet.model.entity.NetXmlConfig;
import com.cictec.yyjk.linenet.model.view.NetDataConfigValue;
import com.cictec.yyjk.linenet.model.vo.NetDataConfigVo;
import com.cictec.yyjk.linenet.service.NetDataConfigService;
import com.cictec.yyjk.linenet.service.NetXmlConfigService;
import com.cictec.yyjk.linenet.util.XmlUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * Created by mao on 2019/10/17.
 */
@RestController
@RequestMapping("/api/net/data/config")
public class ApiNetDataConfig {
	private static final Logger LOG = LoggerFactory.getLogger(ApiNetDataConfig.class);
	@Resource
	private NetDataConfigService netDataConfigService;

	@Autowired
	private NetXmlConfigService netXmlConfigService;

	@PostMapping("/add")
	public Result add(@RequestBody NetDataConfig netDataConfig) {
		netDataConfigService.insertSelective(netDataConfig);
		return ResultUtil.getSuccessResult();
	}

	@PostMapping("/delete")
	public Result delete(@RequestParam Integer id) {
		netDataConfigService.deleteByPrimaryKey(id);
		return ResultUtil.getSuccessResult();
	}

	@PostMapping("/update")
	public Result update(@RequestBody NetDataConfig netDataConfig) {
		netDataConfigService.updateByPrimaryKeySelective(netDataConfig);
		return ResultUtil.getSuccessResult();
	}

	@PostMapping("/detail")
	public Result detail(@RequestParam Integer id) {
		NetDataConfig netDataConfig = netDataConfigService.selectByPrimaryKey(id);
		return ResultUtil.getSuccessResult(netDataConfig);
	}

	@PostMapping("/list")
	public Result list(@RequestBody NetDataConfigVo netDataConfigVo) {

		// 判定是否包含分页参数，如果包含则为分页数据请求
		if (netDataConfigVo.getPageSize() != null && netDataConfigVo.getPageSize() != 0) {
			return pageList(netDataConfigVo);
		}

		// TODO 根据具体业务重写
		List<NetDataConfig> list = netDataConfigService.select(null);

		return ResultUtil.getSuccessResult(list);
	}

	@PostMapping("/pageList")
	public Result pageList(@RequestBody NetDataConfigVo netDataConfigVo) {
		/*
		 * 方法一：
		 */
		// 分页数据请求处理
		PageHelper.startPage(netDataConfigVo.getPageNumber(), netDataConfigVo.getPageSize());
		// TODO 根据具体业务重写
		List<NetDataConfig> list = netDataConfigService.select(null);
		return ResultUtil.getSuccessResult(new PageInfo<NetDataConfig>(list));

		/*
		 * 方法二：
		 */
		// String orderBy = sort + " " + order;
		// PageInfo<NetDataConfig> pageInfo =
		// netDataConfigService.selectPage(netDataConfigVo.getPageNumber(),
		// netDataConfigVo.getPageSize(), null);
		// return ResultUtil.getSuccessResult(pageInfo);

	}

	@PostMapping("/getDeareslutConfigXMLData")
	public Result getDeareslutConfigXMLData(@RequestBody NetDataConfig vo) {
		try {
			// 清空表
			netDataConfigService.clearTabel();
			vo.setConfigName("deareslutconfig.xml");
			NetDataConfigValue naConfigValue = netDataConfigService.getDeareslutConfigXMLData(vo);
			String xmlStr = naConfigValue.getConfigFile();
			List<Map<String, String>> maps = XmlUtils.xmlElementDeaReslut(xmlStr);
			for (Map<String, String> map : maps) {
				NetXmlConfig obj = JSON.parseObject(JSON.toJSONString(map), NetXmlConfig.class);
				netXmlConfigService.insertSelective(obj);
			}
			LOG.info("获取线网评分xmldata数据：{}", naConfigValue.toString());
			return ResultUtil.getSuccessResult(naConfigValue);
		} catch (Exception e) {
			LOG.error("获取线网评分xmldata异常，原因：{}", e);
			return ResultUtil.getErrorResult();
		}
	}

}
