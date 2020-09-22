package com.cictec.yyjk.report.model.vo;

import java.util.ArrayList;
import java.util.List;

/**
 * 直角坐标系option数据结构类
 * 
 */
public class GridChartOption {
	private List<String> legendNames = new ArrayList<>();
	private List<String> xAxisNames = new ArrayList<String>();
	private List<List<Object>> datas = new ArrayList<>();

	public List<String> getLegendNames() {
		return legendNames;
	}

	public GridChartOption setLegendNames(List<String> legendNames) {
		this.legendNames = legendNames;
		return this;
	}

	public List<String> getxAxisNames() {
		return xAxisNames;
	}

	public GridChartOption setxAxisNames(List<String> xAxisNames) {
		this.xAxisNames = xAxisNames;
		return this;
	}

	public List<List<Object>> getDatas() {
		return datas;
	}

	public GridChartOption setDatas(List<List<Object>> datas) {
		this.datas = datas;
		return this;
	}

}
