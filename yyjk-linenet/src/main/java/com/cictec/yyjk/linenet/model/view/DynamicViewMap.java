package com.cictec.yyjk.linenet.model.view;

import java.util.ArrayList;
import java.util.List;

public class DynamicViewMap {
	private List<String> typeNameList = new ArrayList<>();
	private List<ValueList> valueList = new ArrayList<>();

	public List<String> getTypeNameList() {
		return typeNameList;
	}

	public void setTypeNameList(List<String> typeNameList) {
		this.typeNameList = typeNameList;
	}

	public List<ValueList> getValueList() {
		return valueList;
	}

	public void setValueList(List<ValueList> valueList) {
		this.valueList = valueList;
	}

}
