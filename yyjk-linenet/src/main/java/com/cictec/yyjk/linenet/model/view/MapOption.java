package com.cictec.yyjk.linenet.model.view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapOption {
	private Map<String, List<String>> columnNameMaps = new HashMap<>();
	private Map<String, List<String>> columnMaps = new HashMap<>();
	private List<List<NetIndexDeaTransfordataValue>> datas = new ArrayList<>();

	public Map<String, List<String>> getColumnMaps() {
		return columnMaps;
	}

	public void setColumnMaps(Map<String, List<String>> columnMaps) {
		this.columnMaps = columnMaps;
	}

	public List<List<NetIndexDeaTransfordataValue>> getDatas() {
		return datas;
	}

	public void setDatas(List<List<NetIndexDeaTransfordataValue>> datas) {
		this.datas = datas;
	}

	public Map<String, List<String>> getColumnNameMaps() {
		return columnNameMaps;
	}

	public void setColumnNameMaps(Map<String, List<String>> columnNameMaps) {
		this.columnNameMaps = columnNameMaps;
	}

}
