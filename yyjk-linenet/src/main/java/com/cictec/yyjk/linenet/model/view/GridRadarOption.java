package com.cictec.yyjk.linenet.model.view;

import java.util.ArrayList;
import java.util.List;

public class GridRadarOption {
	private List<String> legendNames = new ArrayList<>();
	private List<String> radarNames = new ArrayList<String>();
	private List<List<Float>> datas = new ArrayList<>();

	public List<String> getLegendNames() {
		return legendNames;
	}

	public void setLegendNames(List<String> legendNames) {
		this.legendNames = legendNames;
	}

	public List<String> getRadarNames() {
		return radarNames;
	}

	public void setRadarNames(List<String> radarNames) {
		this.radarNames = radarNames;
	}

	public List<List<Float>> getDatas() {
		return datas;
	}

	public void setDatas(List<List<Float>> datas) {
		this.datas = datas;
	}

}
