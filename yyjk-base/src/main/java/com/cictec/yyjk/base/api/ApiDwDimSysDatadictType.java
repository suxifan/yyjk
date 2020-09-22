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

import com.cictec.yyjk.base.model.entity.DwDimSysDatadictType;
import com.cictec.yyjk.base.model.vo.DwDimSysDatadictTypeVo;
import com.cictec.yyjk.base.service.DwDimOtherDeviceService;
import com.cictec.yyjk.base.service.DwDimSysDatadictTypeService;
import com.cictec.yyjk.commons.core.Result;
import com.cictec.yyjk.commons.core.ResultUtil;
import com.cictec.yyjk.commons.utils.PMSUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;


/**
* Created by xpguo on 2019/08/29.
*/
@RestController
@RequestMapping("/api/sys/datadict/type")
public class ApiDwDimSysDatadictType {
    @Resource
    private DwDimSysDatadictTypeService dwDimSysDatadictTypeService;
	@Autowired
	private DwDimOtherDeviceService dwDimOtherDeviceService;

    @PostMapping("/add")
    public Result add(@RequestBody DwDimSysDatadictType dwDimSysDatadictType) {
		DwDimSysDatadictType bean = new DwDimSysDatadictType();
		bean.setTypeCode(dwDimSysDatadictType.getTypeCode());
		int result = dwDimSysDatadictTypeService.selectCount(bean);
		if (result > 0) {
			return ResultUtil.getErrorResult(String.format("数据字典类型编码'%s'已存在，不能继续添加", bean.getTypeCode()));
		}
		dwDimSysDatadictType.setCreateTime(new Date());
        dwDimSysDatadictTypeService.insertSelective(dwDimSysDatadictType);
        return ResultUtil.getSuccessResult();
    }

    @PostMapping("/delete")
	public Result delete(@RequestBody Map<String, Object> pramMap) {
		String uuid = PMSUtils.isNull(pramMap.get("uuid"));
		dwDimSysDatadictTypeService.deleteByPrimaryKey(uuid);
        return ResultUtil.getSuccessResult();
    }

    @PostMapping("/update")
    public Result update(@RequestBody DwDimSysDatadictType dwDimSysDatadictType) {
		String typeCode = dwDimSysDatadictType.getTypeCode();
		String typeName = dwDimSysDatadictType.getTypeName();
		// 启用禁用操作
		if (PMSUtils.isEmpty(typeName)) {
			Integer res = dwDimOtherDeviceService.getBindDevCodeByDevClass(null, typeCode);
			if (res > 0) {
				return ResultUtil
						.getErrorResult(String.format("数据字典类型编码%s正在使用，不能禁用!", dwDimSysDatadictType.getTypeCode()));
			}
		} else {
			if (dwDimSysDatadictType.getIsvalid().equals("0")) {// 编辑设置禁用
				Integer res = dwDimOtherDeviceService.getBindDevCodeByDevClass(null, typeCode);
				if (res > 0) {
					return ResultUtil
							.getErrorResult(String.format("数据字典类型编码%s正在使用，不能禁用!", dwDimSysDatadictType.getTypeCode()));
				}
			}
		}
		dwDimSysDatadictType.setUpdateTime(new Date());
		dwDimSysDatadictTypeService.updateByPrimaryKeySelective(dwDimSysDatadictType);
        return ResultUtil.getSuccessResult();
    }

    @PostMapping("/detail")
	public Result detail(@RequestBody Map<String, Object> pramMap) {
		String uuid = PMSUtils.isNull(pramMap.get("uuid"));
		if (PMSUtils.isEmpty(uuid)) {
			return ResultUtil.getErrorResult("主键不能为空！");
		}
		DwDimSysDatadictType dwDimSysDatadictType = dwDimSysDatadictTypeService
				.selectByPrimaryKey(uuid);
        return ResultUtil.getSuccessResult(dwDimSysDatadictType);
    }

	@PostMapping("/list")
    public Result list(@RequestBody DwDimSysDatadictTypeVo dwDimSysDatadictTypeVo) {
    
		// 判定是否包含分页参数，如果包含则为分页数据请求
    	if(dwDimSysDatadictTypeVo.getPageSize() != null && dwDimSysDatadictTypeVo.getPageSize() != 0){
    		return pageList(dwDimSysDatadictTypeVo);
    	}
    	
		List<DwDimSysDatadictType> list = dwDimSysDatadictTypeService.selectByVo(dwDimSysDatadictTypeVo);
		return ResultUtil.getSuccessResult(list);
    }
    
	@PostMapping("/pageList")
	public Result pageList (@RequestBody DwDimSysDatadictTypeVo dwDimSysDatadictTypeVo) {
		// 分页数据请求处理
		PageHelper.startPage(dwDimSysDatadictTypeVo.getPageNumber(), dwDimSysDatadictTypeVo.getPageSize());
		List<DwDimSysDatadictType> list = dwDimSysDatadictTypeService.selectByVo(dwDimSysDatadictTypeVo);
    	return ResultUtil.getSuccessResult(new PageInfo<DwDimSysDatadictType>(list));
		
	}
	
}
