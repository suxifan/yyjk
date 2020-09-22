package com.cictec.yyjk.base.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cictec.yyjk.base.mapper.ExcelImportLogMapper;
import com.cictec.yyjk.base.model.entity.ExcelImportLog;
import com.cictec.yyjk.base.model.vo.ExcelImportLogVo;
import com.cictec.yyjk.base.service.ExcelImportLogService;
import com.cictec.yyjk.commons.core.AbstractService;


/**
 * Created by xpguo on 2019/09/10.
 */
@Service
@Transactional
public class ExcelImportLogServiceImpl extends AbstractService<ExcelImportLog> implements ExcelImportLogService {

    @Resource
	private ExcelImportLogMapper excelImportLogMapper;

	@Override
	public void addLogs(String model, String errcode, String errmsg, String filename, String userName) {
		ExcelImportLog xlsLogs = new ExcelImportLog();
		xlsLogs.setXlsFilename(filename);
		xlsLogs.setXlsLogModel(model);
		xlsLogs.setXlsErrCode(errcode);
		xlsLogs.setXlsErrMsg(errmsg);
		xlsLogs.setXlsLogDate(new Date());
		xlsLogs.setXlsLogCreateTime(new Date());
		xlsLogs.setXlsLogCreateUser(userName);
		excelImportLogMapper.insertSelective(xlsLogs);
	}

	@Override
	public List<ExcelImportLog> selectByVo(ExcelImportLogVo vo) {
		return excelImportLogMapper.selectByVo(vo);
	}
}
