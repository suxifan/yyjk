package com.cictec.yyjk.commons.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellRangeAddress;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import com.cictec.yyjk.commons.core.AFile;

/**
 * 文件操作服务api
 * 
 * @author 01114203
 * @version 2014年12月 01114203 创建
 * 
 */
public class FileOperUtils {
	// 文件行号属性名称常量
	public static final String ROW_NUM = "rowNum";

	/**
	 * 读取文件内容到流
	 * 
	 * @param file
	 * @param ostream
	 * @throws IOException
	 */
	public static void read(AFile file, OutputStream ostream) throws IOException {
		FileCopyUtils.copy(file.getBytes(), ostream);
	}

	/**
	 * 拷贝文件到指定位置
	 * 
	 * @param src
	 * @param path
	 * @return
	 * @throws IOException
	 */
	public static AFile copy(AFile src, String path) throws IOException {
		AFile des = new AFile(path);
		if (!des.getFile().exists()) {
			des.getFile().createNewFile();
		}
		FileCopyUtils.copy(src.getFile(), des.getFile());
		des.setMIMEType(src.getMIMEType());
		return des;
	}

	/**
	 * 下载文件到临时文件夹
	 * 
	 * @param mFile
	 * @param ctxPath
	 * @param tempPath
	 * @return
	 * @throws IllegalStateException
	 * @throws IOException
	 */
	public static AFile copy(MultipartFile mFile, String ctxPath, String tempPath)
			throws IllegalStateException, IOException {
		AFile file = new AFile(
				ctxPath + tempPath + File.separator + +System.currentTimeMillis() + "_" + mFile.getOriginalFilename());
		file.setMIMEType(mFile.getContentType());
		file.setFileLabel(mFile.getOriginalFilename());
		file.getFile().mkdirs();
		// 将文件copy上传到服务器
		mFile.transferTo(file.getFile());
		return file;
	}

	/**
	 * 读取excel文件，并保存为[属性名：属性值]的map
	 * 
	 * @param file
	 *            excel文件
	 * @param sheetIndex
	 *            要读取的sheet
	 * @param startRow
	 *            从第几行开始读
	 * @param columns
	 *            对应列顺序的属性名称
	 * @return
	 * @throws InvalidFormatException
	 * @throws IOException
	 */
	public static List<Map<String, String>> readExcel(File file, int sheetIndex, int startRow, String... columns)
			throws InvalidFormatException, IOException {
		FileInputStream inp = new FileInputStream(file);
		return readExcel(inp, sheetIndex, startRow, columns);
	}

	public static List<Map<String, String>> readExcel(InputStream inp) throws InvalidFormatException, IOException {
		Workbook workbook = WorkbookFactory.create(inp);
		Sheet sheet = workbook.getSheetAt(0);
		Row row = sheet.getRow(0);
		if (row == null) {
			return Collections.emptyList();
		}
		List<String> columns = new ArrayList<String>();
		for (int cn = row.getFirstCellNum(); cn < row.getFirstCellNum() + 100; cn++) {
			Cell cell = row.getCell(cn, Row.CREATE_NULL_AS_BLANK);
			cell.setCellType(Cell.CELL_TYPE_STRING);
			String cellValue = cell.getStringCellValue().trim();
			if (cellValue.isEmpty()) {
				break;
			}
			columns.add(cellValue);
		}
		if (columns.isEmpty()) {
			return Collections.emptyList();
		}
		return read(workbook, sheet, 1, columns.toArray(new String[columns.size()]));
	}

	public static List<Map<String, String>> readExcel(InputStream inp, int sheetIndex, int startRow, String... columns)
			throws InvalidFormatException, IOException {
		Workbook workbook = WorkbookFactory.create(inp);
		Sheet sheet = workbook.getSheetAt(sheetIndex);
		return read(workbook, sheet, startRow, columns);
	}

	private static List<Map<String, String>> read(Workbook workbook, Sheet sheet, int startRow, String... columns) {
		List<Map<String, String>> rows = new ArrayList<Map<String, String>>();
		for (int rn = startRow; rn <= sheet.getLastRowNum(); rn++) {
			Map<String, String> jRow = new HashMap<String, String>();
			jRow.put(ROW_NUM, rn + 1 + "");
			Row row = sheet.getRow(rn);
			if (row == null) {
				continue;
			}
			StringBuilder test = new StringBuilder();
			if (row.getFirstCellNum() < 0) {
				continue;
			}
			for (int cn = row.getFirstCellNum(); cn < row.getFirstCellNum() + columns.length; cn++) {
				Cell cell = row.getCell(cn, Row.CREATE_NULL_AS_BLANK);
				cell.setCellType(Cell.CELL_TYPE_STRING);
				String cellValue = cell.getStringCellValue().trim();
				test.append(cellValue);
				if (columns != null && columns.length > cn) {
					if (cellValue.length() == 0) {
						jRow.put(columns[cn], null);
					} else {
						jRow.put(columns[cn], cellValue);
					}
				}
			}
			if (test.toString().length() > 0) {
				rows.add(jRow);
			}
		}
		return rows;
	}

	/**
	 * 将数据写入excel
	 * 
	 * @param file
	 *            模板文件
	 * @param file
	 *            临时文件
	 * @param sheetIndex
	 *            要写入的sheet
	 * @param startLine
	 *            开始写入的行
	 * @param data
	 *            数据
	 * @throws IOException
	 * @throws InvalidFormatException
	 */
	public static void writeExcel(File file, File tempFile, int sheetIndex, int startLine, List<List<String>> data)
			throws IOException, InvalidFormatException {
		FileInputStream inp = new FileInputStream(file);
		Workbook workbook = WorkbookFactory.create(inp);
		Sheet sheet = workbook.getSheetAt(sheetIndex);
		Cell cell;
		for (int i = 0; i < data.size(); i++) {
			List<String> rowData = data.get(i);
			if (rowData == null || rowData.isEmpty()) {
				continue;
			}
			Row row = sheet.getRow(i + startLine);
			if (row == null) {
				row = sheet.createRow(i + startLine);
			}
			for (int j = 0; j < rowData.size(); j++) {
				cell = row.getCell(j, Row.CREATE_NULL_AS_BLANK);
				String strValue = rowData.get(j);
				Double doubleValue = null;
				try {
					doubleValue = Double.parseDouble(strValue);
				} catch (Exception e) {
				}
				if (doubleValue != null) {
					cell.setCellValue(doubleValue);
				} else {
					cell.setCellValue(strValue);
				}
			}

		}
		inp.close();
		FileOutputStream out = new FileOutputStream(tempFile);
		workbook.write(out);
		out.close();
	}

	/**
	 * 将数据写入两个sheet工作页excel
	 * 
	 * @param file
	 *            模板文件
	 * @param file
	 *            临时文件
	 * @param startLine
	 *            开始写入的行
	 * @param data
	 *            数据
	 * @throws IOException
	 * @throws InvalidFormatException
	 */
	public static void writeExcelForAlarmUpload(String tital, File file, File tempFile, int startLine,
			List<List<String>> data, List<List<String>> secondData) throws IOException, InvalidFormatException {
		FileInputStream inp = new FileInputStream(file);
		Workbook workbook = WorkbookFactory.create(inp);
		Sheet sheet = workbook.getSheetAt(0);
		Cell cell;
		Cell cellFrist = sheet.createRow(0).getCell(0, Row.CREATE_NULL_AS_BLANK);
		CellStyle setBorder = workbook.createCellStyle();
		setBorder.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 居中
		Font font = workbook.createFont();
		font.setFontName("黑体");
		font.setFontHeightInPoints((short) 16);// 设置字体大小
		Font font2 = workbook.createFont();
		font2.setFontName("仿宋_GB2312");
		font2.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);// 粗体显示
		font2.setFontHeightInPoints((short) 12);
		setBorder.setFont(font);// 选择需要用到的字体格式
		cellFrist.setCellValue(tital);
		cellFrist.setCellStyle(setBorder);
		for (int i = 0; i < data.size(); i++) {
			List<String> rowData = data.get(i);
			if (rowData == null || rowData.isEmpty()) {
				continue;
			}
			Row row = sheet.getRow(i + startLine);
			if (row == null) {
				row = sheet.createRow(i + startLine);
			}
			for (int j = 0; j < rowData.size(); j++) {
				cell = row.getCell(j, Row.CREATE_NULL_AS_BLANK);
				String strValue = rowData.get(j);
				Double doubleValue = null;
				try {
					doubleValue = Double.parseDouble(strValue);
				} catch (Exception e) {
				}
				if (doubleValue != null) {
					cell.setCellValue(doubleValue);
				} else {
					cell.setCellValue(strValue);
				}
			}
		}
		// 合并主配列
		if (data.size() > 3) {
			CellRangeAddress region = new CellRangeAddress(startLine, data.size(), 0, 0);
			sheet.addMergedRegion(region);
		}
		// 合并共计行
		CellRangeAddress totalTimesregion = new CellRangeAddress(data.size() + 1, data.size() + 1, 0, 2);
		sheet.addMergedRegion(totalTimesregion);
		// 合并总计行
		CellRangeAddress totalCountsregion = new CellRangeAddress(data.size() + 2, data.size() + 2, 0, 2);
		sheet.addMergedRegion(totalCountsregion);
		int index = 5;
		int k = 3;
		for (int j = 0; j < (data.size() - 2) / 3; j++) {
			sheet.addMergedRegion(new CellRangeAddress(k, index, 1, 1));
			index = index + 3;
			k = k + 3;
		}

		// 插入第二个工作簿
		Sheet sheet1 = workbook.getSheetAt(1);
		Cell cellFrist1 = sheet1.createRow(0).getCell(0, Row.CREATE_NULL_AS_BLANK);
		cellFrist1.setCellValue(tital);
		cellFrist1.setCellStyle(setBorder);
		for (int i = 0; i < secondData.size(); i++) {
			List<String> rowData = secondData.get(i);
			if (rowData == null || rowData.isEmpty()) {
				continue;
			}
			Row row = sheet1.getRow(i + startLine);
			if (row == null) {
				row = sheet1.createRow(i + startLine);
			}
			for (int j = 0; j < rowData.size(); j++) {
				cell = row.getCell(j, Row.CREATE_NULL_AS_BLANK);
				String strValue = rowData.get(j);
				Double doubleValue = null;
				try {
					doubleValue = Double.parseDouble(strValue);
				} catch (Exception e) {
				}
				if (doubleValue != null) {
					cell.setCellValue(doubleValue);
				} else {
					cell.setCellValue(strValue);
				}
			}

		}
		// 合并主配列
		if (secondData.size() > 3) {
			CellRangeAddress region1 = new CellRangeAddress(startLine, secondData.size(), 0, 0);
			sheet1.addMergedRegion(region1);
		}
		// 合并合计行
		CellRangeAddress totalTimesregion1 = new CellRangeAddress(secondData.size() + 1, secondData.size() + 1, 0, 2);
		sheet1.addMergedRegion(totalTimesregion1);
		// 合并总计行
		CellRangeAddress totalCountsregion1 = new CellRangeAddress(secondData.size() + 2, secondData.size() + 2, 0, 2);
		sheet1.addMergedRegion(totalCountsregion1);
		int index1 = 5;
		int k1 = 3;
		for (int j = 0; j < (secondData.size() - 2) / 3; j++) {
			sheet1.addMergedRegion(new CellRangeAddress(k1, index1, 1, 1));
			index1 = index1 + 3;
			k1 = k1 + 3;
		}
		inp.close();
		FileOutputStream out = new FileOutputStream(tempFile);
		workbook.write(out);
		out.close();
	}

	/**
	 * 创建excel文件和指定名称的空sheet
	 * 
	 * @param file
	 *            要创建的文件
	 * @param sheetNames
	 *            要创建的sheet名
	 * @throws IOException
	 * @throws InvalidFormatException
	 */
	public static void createExcel(File file, String... sheetNames) throws IOException, InvalidFormatException {
		HSSFWorkbook workbook = new HSSFWorkbook();
		for (String sheetName : sheetNames) {
			workbook.createSheet(sheetName);
		}
		FileOutputStream out = new FileOutputStream(file);
		workbook.write(out);
		out.close();
		workbook.close();
	}

}
