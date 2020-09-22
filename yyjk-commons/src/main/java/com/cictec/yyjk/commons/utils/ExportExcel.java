package com.cictec.yyjk.commons.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFRow;

import jxl.SheetSettings;
import jxl.Workbook;
import jxl.format.CellFormat;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

/**
 * @RuleName:导出Excel带表头
 * @author admin
 * @version: 8.0
 * @Created: 2018-03-01 17:53:55
 */
public class ExportExcel {
	private static final String SEPARATOR = "_";

	// String[] targetNames = {
	// "机构","线路","配车数","计划趟次","实际趟次","车次率(%)","计划里程","实际里程","GPS非营运里程","GPS总里程",
	// "普票_人次","普票_金额",
	// "市民卡_普通卡_人次","市民卡_普通卡_金额",
	// "市民卡_成人卡_人次","市民卡_成人卡_金额",
	// "市民卡_学生卡_人次","市民卡_学生卡_金额",
	// "市民卡_八折卡_人次","市民卡_八折卡_金额",
	// "市民卡_免费卡_人次","市民卡_微信_人次","市民卡_微信_金额",
	// "合计_人次",
	// "合计_金额"
	// };
	public static void ExportExcel1(String sheetName, String[] targetNames, int line, String[] field,
			List<Map> paramArrayOfDocument, File paramOutputStream) throws Exception {
		final int firstTreeRowIndex = 0;
		int rowSize = getRowSize(targetNames);
		List<SplitCell> cellContents = new ArrayList<>();
		for (int i = 0; i < targetNames.length; i++) {
			String[] values = targetNames[i].split(SEPARATOR);
			for (int k = 0; k < values.length; k++) {
				String value = values[k];
				String key = getKey(values, k);
				String parentKey = getParentKey(values, k);
				SplitCell cellContent = new SplitCell(key, parentKey, value, i, k + firstTreeRowIndex);
				cellContents.add(cellContent);
			}
		}
		WritableWorkbook workbook = Workbook.createWorkbook(paramOutputStream);
		CellFormat cellFormat = getCellFormat();
		WritableSheet sheet = workbook.createSheet(sheetName, 0);
		SheetSettings ss = sheet.getSettings();
		ss.setVerticalFreeze(line);// 冻结表头
		// 树形表头
		CellTransformer cellInfoManager = new CellTransformer(cellContents, firstTreeRowIndex, rowSize);
		Map<String, MergedCell> map = cellInfoManager.transform();
		for (MergedCell cellInfo : map.values()) {
			Label label = new Label(cellInfo.getStartC(), cellInfo.getStartR(), cellInfo.getValue(), cellFormat);
			if (cellInfo.getStartC() != cellInfo.getEndC() || cellInfo.getStartR() != cellInfo.getEndR()) {
				sheet.mergeCells(cellInfo.getStartC(), cellInfo.getStartR(), cellInfo.getEndC(), cellInfo.getEndR());
			}
			sheet.addCell(label);
		}
		HSSFRow localHSSFRow = null;
		int rowIndex = line;
		for (Map localObject2 : paramArrayOfDocument) {
			for (int n = 0; n < field.length; n = (short) (n + 1)) {
				Label label1 = new Label(n, rowIndex, (String) localObject2.get(field[n]));
				sheet.addCell(label1);
			}
			rowIndex++;
		}
		workbook.write();
		workbook.close();
	}

	private static CellFormat getCellFormat() throws Exception {
		WritableFont font = new WritableFont(WritableFont.ARIAL, 12, WritableFont.BOLD);
		WritableCellFormat cellFormat = new WritableCellFormat();
		cellFormat.setFont(font);
		cellFormat.setAlignment(jxl.format.Alignment.CENTRE);
		cellFormat.setVerticalAlignment(jxl.format.VerticalAlignment.CENTRE);
		cellFormat.setWrap(false);
		return cellFormat;
	}

	private static int getRowSize(String[] targetNames) {
		int rowSize = 0;
		for (String t : targetNames) {
			rowSize = Math.max(rowSize, t.split(SEPARATOR).length);
		}
		return rowSize;
	}

	private static String getKey(String[] values, int index) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < (index + 1); i++) {
			sb.append(values[i] + SEPARATOR);
		}
		sb.deleteCharAt(sb.length() - 1);
		return sb.toString();
	}

	private static String getParentKey(String[] values, int index) {
		if (index == 0) {
			return null;
		}
		return getKey(values, index - 1);
	}

}