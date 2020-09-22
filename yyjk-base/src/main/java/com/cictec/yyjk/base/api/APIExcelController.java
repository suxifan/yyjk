package com.cictec.yyjk.base.api;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.alibaba.fastjson.JSONObject;
import com.cictec.yyjk.base.service.ExcelImportService;
import com.cictec.yyjk.commons.core.Result;
import com.cictec.yyjk.commons.core.ResultUtil;
import com.cictec.yyjk.commons.utils.FileOperUtils;
import com.cictec.yyjk.commons.utils.PMSUtils;



/**
 * Created by xpguo on 2019/08/29.
 */
@RestController
@RequestMapping("/excel")
public class APIExcelController extends BaseController {
	private static final Logger LOG = LoggerFactory.getLogger(APIExcelController.class);
	// 模板文件夹
	@Value("${spring.resources.static-locations}")
	private String templateDir;

	// 上传文件目录
	@Value("${spring.file.upload.temp}")
	private String uploadTempDir;

	// web映射地址
	@Value("${web.webrooturl}")
	private String webrooturl;
    
	@Autowired
	private ExcelImportService excelImportService;
    
	/**
	 * 上传文件，并验证
	 * 
	 * @throws Exception
	 */
	@PostMapping("/uploadFile")
	public Result uploadFile(HttpServletRequest request) throws Exception {
		String type = request.getParameter("type");
		String[] columns = null;
		if (type.equalsIgnoreCase("busdevice")) {
			columns = new String[] { "orgName", "lineName", "busPlateNumber", "busSelfCode", "devCode", "devClass" };
		} else if (type.equalsIgnoreCase("device")) {
			columns = new String[] { "devCode", "devModelNum", "devVersion", "devSimNum", "devPhone", "devClass" };
		}
		MultipartHttpServletRequest mulRequest = (MultipartHttpServletRequest) request;
		MultipartFile multipartFile = mulRequest.getFile("file");
		// 上传文件
		String oldfilename = multipartFile.getOriginalFilename();
		// 获取上传文件的后缀，并进行判断
		if (!oldfilename.contains("xls")) {
			return ResultUtil.getErrorResult("文件格式错误，只支持.xls格式的文件");
		}
		String now = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
		String fileName = now + ".xls";
		Result result = null;
		LOG.info("上传文件路径：" + uploadTempDir + ",文件名称：" + fileName);
		if (multipartFile != null) {
			// 上传到服务器临时文件目录
			multipartFile.transferTo(new File(uploadTempDir, fileName));
			// 开始读取服务器上的文件
			File tempFile = new File(uploadTempDir, fileName);
			try {
				// 读取Excel文件内容
				String userAccount = (String) request.getSession().getAttribute("userAccount");
				List<Map<String, String>> datas = FileOperUtils.readExcel(tempFile, 0, 1, columns);
				if (type.equalsIgnoreCase("busdevice")) {
					result = excelImportService.importBusDevice(datas, fileName,
							userAccount);
				} else if (type.equalsIgnoreCase("device")) {
					result = excelImportService.importDeviceInfo(datas, fileName,
							userAccount);
				}
			} catch (Exception ex) {
				LOG.error("导入失败！{}", ex);
			}
		}
		return result;
	}
	
	/**
	 * Excel模板下载
	 * 
	 * @param tdeviceList
	 * @return
	 */
	@PostMapping("/template/download")
	public Result templatedownload(@RequestBody Map<String, Object> paramMap) {
		String title = "";
		String type = PMSUtils.isNull(paramMap.get("type"));
		if (type.equalsIgnoreCase("busdevice")) {
			title = "busDeviceInfoImportModel.xls";
		} else if (type.equalsIgnoreCase("device")) {
			title = "deviceInfoImportModel.xls";
		}
		try {
			String templatePath = templateDir.substring(0, templateDir.length() - 1);
			String path = webrooturl + templatePath.substring(templatePath.lastIndexOf("/"), templatePath.length())
					+ File.separator + title;
			JSONObject json = new JSONObject();
			json.put("url", path);
			LOG.info("下载模板文件{}，文件路径{}", title, path);
			return ResultUtil.getSuccessResult(json);
		} catch (Exception e) {
			LOG.error("下载模板失败！{}", e);
			return ResultUtil.getErrorResult("下载模板文件异常！");
		}
	}

}
