package com.cictec.yyjk.linenet.model.view;

import java.util.ArrayList;
import java.util.List;

public class ValueList {

	private List<String> columnNameList = new ArrayList<>();
	private List<String> columnList = new ArrayList<>();
	private List<NetIndexDeaTransfordataValue> dataList = new ArrayList<>();

	public List<String> getColumnNameList() {
		return columnNameList;
	}

	public void setColumnNameList(List<String> columnNameList) {
		this.columnNameList = columnNameList;
	}

	public List<String> getColumnList() {
		return columnList;
	}

	public void setColumnList(List<String> columnList) {
		this.columnList = columnList;
	}

	public List<NetIndexDeaTransfordataValue> getDataList() {
		return dataList;
	}

	public void setDataList(List<NetIndexDeaTransfordataValue> dataList) {
		this.dataList = dataList;
	}

}
