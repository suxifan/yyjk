package com.cictec.yyjk.base.service;

import java.util.List;

import com.cictec.yyjk.base.model.entity.ExcelImportLog;
import com.cictec.yyjk.base.model.vo.ExcelImportLogVo;
import com.cictec.yyjk.commons.core.Service;


/**
 * Created by xpguo on 2019/09/10.
 */
public interface ExcelImportLogService extends Service<ExcelImportLog> {
	/**
	 * 插入excel导入日志
	 * 
	 * @param string
	 * @param errCodeNull
	 * @param string2
	 * @param filename
	 */
	void addLogs(String model, String errcode, String errmsg, String filename, String userName);

	/**
	 * 分页查询导入日志
	 * 
	 * @param vo
	 * @return
	 */
	List<ExcelImportLog> selectByVo(ExcelImportLogVo vo);
}
