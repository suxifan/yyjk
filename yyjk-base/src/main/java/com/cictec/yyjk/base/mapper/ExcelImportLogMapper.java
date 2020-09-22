package com.cictec.yyjk.base.mapper;

import java.util.List;

import com.cictec.yyjk.base.model.entity.ExcelImportLog;
import com.cictec.yyjk.base.model.vo.ExcelImportLogVo;
import com.cictec.yyjk.commons.core.Mapper;

public interface ExcelImportLogMapper extends Mapper<ExcelImportLog> {
	/**
	 * 分页查询excel导入日志
	 * 
	 * @param vo
	 * @return
	 */
	List<ExcelImportLog> selectByVo(ExcelImportLogVo vo);
}