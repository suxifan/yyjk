package com.cictec.yyjk.linenet.model.view;

import java.util.ArrayList;
import java.util.List;

public class NodeLinkChart {

	private List<NetIndexPfLineOdValue> edges = new ArrayList<>();
	private List<NetIndexPfLineOdValue> nodes = new ArrayList<>();

	public List<NetIndexPfLineOdValue> getEdges() {
		return edges;
	}

	public void setEdges(List<NetIndexPfLineOdValue> edges) {
		this.edges = edges;
	}

	public List<NetIndexPfLineOdValue> getNodes() {
		return nodes;
	}

	public void setNodes(List<NetIndexPfLineOdValue> nodes) {
		this.nodes = nodes;
	}

}
