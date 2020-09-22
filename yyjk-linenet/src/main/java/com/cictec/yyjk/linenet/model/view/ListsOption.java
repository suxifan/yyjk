package com.cictec.yyjk.linenet.model.view;

import java.util.ArrayList;
import java.util.List;

public class ListsOption {

	private List<String> codeTypeNames = new ArrayList<>();
	private List<String> codeTypes = new ArrayList<>();
	private List<List<String>> codeValues = new ArrayList<>();
	private List<List<String>> codes = new ArrayList<>();
	private List<List<NetIndexDeaTransfordataValue>> datas = new ArrayList<>();

	public List<List<String>> getCodeValues() {
		return codeValues;
	}

	public void setCodeValues(List<List<String>> codeValues) {
		this.codeValues = codeValues;
	}

	public List<List<String>> getCodes() {
		return codes;
	}

	public void setCodes(List<List<String>> codes) {
		this.codes = codes;
	}

	public List<List<NetIndexDeaTransfordataValue>> getDatas() {
		return datas;
	}

	public void setDatas(List<List<NetIndexDeaTransfordataValue>> datas) {
		this.datas = datas;
	}

	public List<String> getCodeTypeNames() {
		return codeTypeNames;
	}

	public void setCodeTypeNames(List<String> codeTypeNames) {
		this.codeTypeNames = codeTypeNames;
	}

	public List<String> getCodeTypes() {
		return codeTypes;
	}

	public void setCodeTypes(List<String> codeTypes) {
		this.codeTypes = codeTypes;
	}

}
