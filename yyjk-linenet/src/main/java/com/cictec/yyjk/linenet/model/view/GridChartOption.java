package com.cictec.yyjk.linenet.model.view;

import java.util.ArrayList;
import java.util.List;

/**
 * 直角坐标系option数据结构类
 * 
 */
public class GridChartOption {
	private List<String> legendNames = new ArrayList<>();
	private List<String> xAxisNames = new ArrayList<String>();
	private List<List<Float>> datas = new ArrayList<>();

	public List<String> getLegendNames() {
		return legendNames;
	}

	public void setLegendNames(List<String> legendNames) {
		this.legendNames = legendNames;
	}

	public List<String> getxAxisNames() {
		return xAxisNames;
	}

	public void setxAxisNames(List<String> xAxisNames) {
		this.xAxisNames = xAxisNames;
	}

	public List<List<Float>> getDatas() {
		return datas;
	}

	public void setDatas(List<List<Float>> datas) {
		this.datas = datas;
	}

}
