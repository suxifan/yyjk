package com.cictec.yyjk.timingtask.model.vo;

public enum LineType {
	UP("1"), DOWN("2");

	private String type;

	private LineType(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}

}
