package com.cictec.yyjk.base.api;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cictec.yyjk.base.model.entity.ExcelImportLog;
import com.cictec.yyjk.base.model.vo.ExcelImportLogVo;
import com.cictec.yyjk.base.service.ExcelImportLogService;
import com.cictec.yyjk.commons.core.Result;
import com.cictec.yyjk.commons.core.ResultUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;


/**
* Created by xpguo on 2019/09/10.
*/
@RestController
@RequestMapping("excel/log")
public class ApiExcelImportLog {
	private static final Logger LOG = LoggerFactory.getLogger(ApiExcelImportLog.class);
    @Resource
    private ExcelImportLogService excelImportLogService;


	/**
	 * 分页查询导入日志
	 * 
	 * @param vo
	 * @return
	 */
	@PostMapping("/logpage/get")
	public Result page(@RequestBody ExcelImportLogVo vo) {
		Result result = null;
		try {
			PageHelper.startPage(vo.getPageNum(), vo.getPageSize());
			List<ExcelImportLog> list = excelImportLogService.selectByVo(vo);
			PageInfo<ExcelImportLog> pageInfo = new PageInfo<ExcelImportLog>(list);
			result = ResultUtil.getSuccessResult(pageInfo);
		} catch (Exception ex) {
			LOG.error("分页查询导入日志失败，原因{}", ex);
			result = ResultUtil.getErrorResult();
		}
		return result;
    }
	
}
