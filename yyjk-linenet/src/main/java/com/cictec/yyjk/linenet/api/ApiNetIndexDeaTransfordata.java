package com.cictec.yyjk.linenet.api;

import java.util.ArrayList;
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

import com.cictec.yyjk.base.interceptors.AccessLogInfo;
import com.cictec.yyjk.commons.core.Result;
import com.cictec.yyjk.commons.core.ResultUtil;
import com.cictec.yyjk.linenet.mapper.NetIndexDeaTransfordataMapper;
import com.cictec.yyjk.linenet.model.entity.NetIndexDeaTransfordata;
import com.cictec.yyjk.linenet.model.view.DynamicViewMap;
import com.cictec.yyjk.linenet.model.view.NetIndexDeaTransfordataValue;
import com.cictec.yyjk.linenet.model.view.NetXmlConfigValue;
import com.cictec.yyjk.linenet.model.view.ValueList;
import com.cictec.yyjk.linenet.model.vo.NetIndexDeaTransfordataVo;
import com.cictec.yyjk.linenet.model.vo.NetXmlConfigVo;
import com.cictec.yyjk.linenet.service.NetIndexDeaTransfordataService;
import com.cictec.yyjk.linenet.service.NetXmlConfigService;
import com.cictec.yyjk.linenet.service.NetXmlDeaBaseConfigService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * Created by mao on 2019/10/18.
 */
@RestController
@RequestMapping("/api/net/index/dea/transfordata")
public class ApiNetIndexDeaTransfordata {
	private static final Logger LOG = LoggerFactory.getLogger(ApiNetIndexDeaTransfordata.class);
	@Resource
	private NetIndexDeaTransfordataService netIndexDeaTransfordataService;

	@Autowired
	private NetXmlConfigService netXmlConfigService;
	@Autowired
	private NetIndexDeaTransfordataMapper netIndexDeaTransfordataMapper;
	@Autowired
	private NetXmlDeaBaseConfigService netXmlDeaBaseConfigService;

	@PostMapping("/add")
	public Result add(@RequestBody NetIndexDeaTransfordata netIndexDeaTransfordata) {
		netIndexDeaTransfordataService.insertSelective(netIndexDeaTransfordata);
		return ResultUtil.getSuccessResult();
	}

	@PostMapping("/delete")
	public Result delete(@RequestParam Integer id) {
		netIndexDeaTransfordataService.deleteByPrimaryKey(id);
		return ResultUtil.getSuccessResult();
	}

	@PostMapping("/update")
	public Result update(@RequestBody NetIndexDeaTransfordata netIndexDeaTransfordata) {
		netIndexDeaTransfordataService.updateByPrimaryKeySelective(netIndexDeaTransfordata);
		return ResultUtil.getSuccessResult();
	}

	@PostMapping("/detail")
	public Result detail(@RequestParam Integer id) {
		NetIndexDeaTransfordata netIndexDeaTransfordata = netIndexDeaTransfordataService.selectByPrimaryKey(id);
		return ResultUtil.getSuccessResult(netIndexDeaTransfordata);
	}

	@PostMapping("/list")
	public Result list(@RequestBody NetIndexDeaTransfordataVo netIndexDeaTransfordataVo) {

		// 判定是否包含分页参数，如果包含则为分页数据请求
		if (netIndexDeaTransfordataVo.getPageSize() != null && netIndexDeaTransfordataVo.getPageSize() != 0) {
			return pageList(netIndexDeaTransfordataVo);
		}

		// TODO 根据具体业务重写
		List<NetIndexDeaTransfordata> list = netIndexDeaTransfordataService.select(null);

		return ResultUtil.getSuccessResult(list);
	}

	@PostMapping("/pageList")
	public Result pageList(@RequestBody NetIndexDeaTransfordataVo netIndexDeaTransfordataVo) {
		// 分页数据请求处理
		PageHelper.startPage(netIndexDeaTransfordataVo.getPageNumber(), netIndexDeaTransfordataVo.getPageSize());
		// 根据具体业务重写
		List<NetIndexDeaTransfordata> list = netIndexDeaTransfordataService.select(null);
		return ResultUtil.getSuccessResult(new PageInfo<NetIndexDeaTransfordata>(list));

	}

	@AccessLogInfo(modelName = "数据分析", pageName = "线网评分详情")
	@PostMapping("/getNetIndexDeaData")
	public Result getNetIndexDeaData(@RequestBody NetXmlConfigVo vo) {
		try {
			List<NetXmlConfigValue> list = netXmlConfigService.getSelectColumnListData(vo);
			List<String> typeNameList = new ArrayList<>();
			List<ValueList> valueList = new ArrayList<>();
			NetIndexDeaTransfordataValue fristObj = getAllTips();
			for (NetXmlConfigValue netXmlConfigValue : list) {
				// 父列名
				typeNameList.add(netXmlConfigValue.getCodeTypeName());
				// 子列名
				List<String> codeValue = new ArrayList<>();
				codeValue.add("机构");
				codeValue.add("线路号");
				List<String> code = new ArrayList<>();
				code.add("company");
				code.add("lineNumber");
				// 获取需要查询的列名
				NetXmlConfigVo obj = new NetXmlConfigVo();
				obj.setCodeType(netXmlConfigValue.getCodeType());
				List<NetXmlConfigValue> list2 = netXmlConfigService.getCodeListData(obj);
				for (NetXmlConfigValue value2 : list2) {
					codeValue.add(value2.getCodeValue());
					code.add(value2.getCode());
				}
				ValueList valList = new ValueList();
				valList.setColumnList(code);
				valList.setColumnNameList(codeValue);
				List<NetIndexDeaTransfordataValue> data = new ArrayList<>();
				data.add(fristObj);
				// 根据列名查需要的data
				vo.setCodes(netXmlConfigValue.getCodes());
				data.addAll(netIndexDeaTransfordataMapper.getDeaDataList(vo));
				valList.setDataList(data);
				valueList.add(valList);
			}

			DynamicViewMap option = new DynamicViewMap();
			option.setTypeNameList(typeNameList);
			option.setValueList(valueList);
			LOG.info("获取线网评分指标链接-列表data数据：{}", option.toString());
			return ResultUtil.getSuccessResult(option);
		} catch (

		Exception e) {
			LOG.error("获取线网评分指标链接-列表data异常，原因：{}", e);
			return ResultUtil.getErrorResult();
		}
	}

	private NetIndexDeaTransfordataValue getAllTips() {
		// 获取列名提示字典
		Map<String, String> tipMaps = netXmlDeaBaseConfigService.getDeaBaseConfigListData();
		System.out.println(tipMaps);
		NetIndexDeaTransfordataValue fristObj = new NetIndexDeaTransfordataValue();
		fristObj.setObld(tipMaps.get("bld"));
		fristObj.setObrushcount(tipMaps.get("bld"));
		fristObj.setOfh(tipMaps.get("fh"));
		fristObj.setOfzx(tipMaps.get("fzx"));
		fristObj.setOiskt(tipMaps.get("iskt"));
		fristObj.setOjtxs(tipMaps.get("jtxs"));
		fristObj.setOlength(tipMaps.get("length"));
		fristObj.setOltd(tipMaps.get("ltd"));
		fristObj.setOmzl(tipMaps.get("mzl"));
		fristObj.setOp_distance(tipMaps.get("p_distance"));
		fristObj.setOpjpc(tipMaps.get("pjpc"));
		fristObj.setOsitecount(tipMaps.get("siteCount"));
		fristObj.setOspeed(tipMaps.get("speed"));
		fristObj.setOvehiclecou(tipMaps.get("vehicleCou"));
		fristObj.setOworktime(tipMaps.get("worktime"));
		return fristObj;
	}

}
