package com.cictec.yyjk.report.model.vo;

import java.util.ArrayList;
import java.util.List;

public class HeatmapOption {
	private List<String> xAxisNames = new ArrayList<String>();
	private List<String> yAxisNames = new ArrayList<String>();
	private List<List<Float>> datas = new ArrayList<>();

	public List<String> getxAxisNames() {
		return xAxisNames;
	}

	public void setxAxisNames(List<String> xAxisNames) {
		this.xAxisNames = xAxisNames;
	}

	public List<String> getyAxisNames() {
		return yAxisNames;
	}

	public void setyAxisNames(List<String> yAxisNames) {
		this.yAxisNames = yAxisNames;
	}

	public List<List<Float>> getDatas() {
		return datas;
	}

	public void setDatas(List<List<Float>> datas) {
		this.datas = datas;
	}
}
