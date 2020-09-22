package com.cictec.yyjk.base.api;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cictec.yyjk.base.model.entity.DwDimSysDatadict;
import com.cictec.yyjk.base.model.vo.DwDimSysDatadictVo;
import com.cictec.yyjk.base.service.DwDimOtherDeviceService;
import com.cictec.yyjk.base.service.DwDimSysDatadictService;
import com.cictec.yyjk.commons.core.Result;
import com.cictec.yyjk.commons.core.ResultUtil;
import com.cictec.yyjk.commons.utils.PMSUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;


/**
* Created by xpguo on 2019/08/29.
*/
@RestController
@RequestMapping("/api/sys/datadict")
public class ApiDwDimSysDatadict {
    @Resource
    private DwDimSysDatadictService dwDimSysDatadictService;

	@Autowired
	private DwDimOtherDeviceService dwDimOtherDeviceService;

    @PostMapping("/add")
    public Result add(@RequestBody DwDimSysDatadict dwDimSysDatadict) {
		DwDimSysDatadict condition = new DwDimSysDatadict();
		condition.setTypeValue(dwDimSysDatadict.getTypeValue());
		condition.setTypeCode(dwDimSysDatadict.getTypeCode());
		int res = dwDimSysDatadictService.selectCount(condition);
		if (res > 0) {
			return ResultUtil.getErrorResult(String.format("数据字典编码'%s'已存在，不能继续添加", condition.getTypeValue()));
		}
		dwDimSysDatadict.setCreateTime(new Date());
        dwDimSysDatadictService.insertSelective(dwDimSysDatadict);
        return ResultUtil.getSuccessResult();
    }

    @PostMapping("/delete")
	public Result delete(@RequestBody Map<String, Object> paramMap) {
		String uuid = PMSUtils.isNull(paramMap.get("uuid"));
		dwDimSysDatadictService.deleteByPrimaryKey(uuid);
        return ResultUtil.getSuccessResult();
    }

    @PostMapping("/update")
    public Result update(@RequestBody DwDimSysDatadict dwDimSysDatadict) {
		String typeCode = dwDimSysDatadict.getTypeCode();
		// 修改时判断字典编码是否已存在
		if (PMSUtils.isNotEmpty(typeCode)) {
			DwDimSysDatadict condition = new DwDimSysDatadict();
			condition.setTypeCode(typeCode);
			condition.setTypeValue(dwDimSysDatadict.getTypeValue());
			List<DwDimSysDatadict> res = dwDimSysDatadictService.select(condition);
			if (res != null && res.size() > 0 && !res.get(0).getUuid().equals(dwDimSysDatadict.getUuid())) {
				return ResultUtil.getErrorResult(String.format("数据字典编码%s已存在!", dwDimSysDatadict.getTypeValue()));
			}
		}
		// 启用禁用操作，当改字典编码被使用，则禁止设置禁用
		String typeValue = dwDimSysDatadict.getTypeValue();
		String display = dwDimSysDatadict.getDisplay();
		if (PMSUtils.isEmpty(display)) {
			Integer res = dwDimOtherDeviceService.getBindDevCodeByDevClass(typeValue, typeCode);
			if (res > 0) {
				return ResultUtil.getErrorResult(String.format("数据字典编码%s正在使用，不能禁用!", dwDimSysDatadict.getTypeValue()));
			}
		} else {
			if (dwDimSysDatadict.getIsvalid().equals("0")) {// 编辑设置禁用
				Integer res = dwDimOtherDeviceService.getBindDevCodeByDevClass(typeValue, typeCode);
				if (res > 0) {
					return ResultUtil
							.getErrorResult(String.format("数据字典编码%s正在使用，不能禁用!", dwDimSysDatadict.getTypeValue()));
				}
			}
		}
		dwDimSysDatadict.setUpdateTime(new Date());
        dwDimSysDatadictService.updateByPrimaryKeySelective(dwDimSysDatadict);
        return ResultUtil.getSuccessResult();
    }

    @PostMapping("/detail")
	public Result detail(@RequestBody Map<String, Object> paramMap) {
		String uuid = PMSUtils.isNull(paramMap.get("uuid"));
		DwDimSysDatadict dwDimSysDatadict = dwDimSysDatadictService.selectByPrimaryKey(uuid);
        return ResultUtil.getSuccessResult(dwDimSysDatadict);
    }

	@PostMapping("/list")
    public Result list(@RequestBody DwDimSysDatadictVo dwDimSysDatadictVo) {
		// 判定是否包含分页参数，如果包含则为分页数据请求
    	if(dwDimSysDatadictVo.getPageSize() != null && dwDimSysDatadictVo.getPageSize() != 0){
    		return pageList(dwDimSysDatadictVo);
    	}
    	
		List<DwDimSysDatadict> list = dwDimSysDatadictService.selectByVo(dwDimSysDatadictVo);
    	
		return ResultUtil.getSuccessResult(list);
    }
    
	@PostMapping("/pageList")
	public Result pageList (@RequestBody DwDimSysDatadictVo dwDimSysDatadictVo) {
		// 分页数据请求处理
		PageHelper.startPage(dwDimSysDatadictVo.getPageNumber(), dwDimSysDatadictVo.getPageSize());
		// 根据具体业务重写
		List<DwDimSysDatadict> list = dwDimSysDatadictService.selectByVo(dwDimSysDatadictVo);
    	return ResultUtil.getSuccessResult(new PageInfo<DwDimSysDatadict>(list));
	}
	
	@PostMapping("/getDatadicts")
	public Result getDatadicts(@RequestBody Map<String, Object> paramMap) {
		String typeCode = PMSUtils.isNull(paramMap.get("typeCode"));
		List<DwDimSysDatadict> list = dwDimSysDatadictService.queryDatadicts(typeCode);
		return ResultUtil.getSuccessResult(list);
	}

}
