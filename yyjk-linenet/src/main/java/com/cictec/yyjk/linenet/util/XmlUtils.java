package com.cictec.yyjk.linenet.util;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.xml.sax.InputSource;

public class XmlUtils {

	public static List<Map<String, String>> xmlElementDeaReslut(String xmlDoc) throws JDOMException, IOException {
		// 创建一个新的字符串
		xmlDoc = xmlDoc.substring("<?xml version='1.0' encoding='utf-8'?>".length());
		System.out.println(xmlDoc);
		StringReader read = new StringReader(xmlDoc);
		// 创建新的输入源SAX 解析器将使用 InputSource 对象来确定如何读取 XML 输入
		InputSource source = new InputSource(read);
		// 创建一个新的SAXBuilder
		SAXBuilder sb = new SAXBuilder();

		// 通过输入源构造一个Document
		Document doc = sb.build(source);
		// 取的根元素
		Element root = doc.getRootElement();
		// 得到根元素所有子元素的集合

		List resultEel = root.getChild("DEAResult").getChild("DEAIndexResult").getChildren();
		List<Map<String, String>> resultMap = new ArrayList<Map<String, String>>();
		if (resultEel != null && resultEel.size() > 0) {
			Iterator iterator = resultEel.iterator();
			while (iterator.hasNext()) {
				Element et = (Element) iterator.next();
				List children = et.getChildren();
				if (children != null && children.size() > 0) {
					int index = 1;
					Iterator childIter = children.iterator();
					while (childIter.hasNext()) {
						Element nextChild = (Element) childIter.next();
						Map<String, String> eleMap = new HashMap<String, String>();
						eleMap.put("codeType", et.getAttribute("typeName").getValue());
						eleMap.put("codeTypeName", et.getAttribute("typeDescribe").getValue());
						// 把N打头转换成O打头
						eleMap.put("code", "O" + (nextChild.getAttribute("indexName").getValue()).substring(1));
						eleMap.put("codeValue", nextChild.getAttribute("indexDescirbe").getValue());
						eleMap.put("codeIndex", index + "");
						resultMap.add(eleMap);
						index++;
					}
				}
			}
		}
		return resultMap;

	}

	public static List<Map<String, String>> xmlElementsBaseIndex(String xmlDoc) throws JDOMException, IOException {
		// 创建一个新的字符串
		xmlDoc = xmlDoc.substring("<?xml version='1.0' encoding='utf-8'?>".length());
		System.out.println(xmlDoc);
		StringReader read = new StringReader(xmlDoc);
		// 创建新的输入源SAX 解析器将使用 InputSource 对象来确定如何读取 XML 输入
		InputSource source = new InputSource(read);
		// 创建一个新的SAXBuilder
		SAXBuilder sb = new SAXBuilder();

		// 通过输入源构造一个Document
		Document doc = sb.build(source);
		// 取的根元素
		Element root = doc.getRootElement();
		// 得到根元素所有子元素的集合

		List resultEel = root.getChild("DEABaseIndex").getChildren();
		List<Map<String, String>> resultMap = new ArrayList<Map<String, String>>();
		if (resultEel != null && resultEel.size() > 0) {
			Iterator iterator = resultEel.iterator();
			while (iterator.hasNext()) {
				Element et = (Element) iterator.next();
				List children = et.getChildren();
				if (children != null && children.size() > 0) {
					int index = 1;
					Iterator childIter = children.iterator();
					while (childIter.hasNext()) {
						Element nextChild = (Element) childIter.next();
						Map<String, String> eleMap = new HashMap<String, String>();
						eleMap.put("deaTableName", et.getAttribute("TableName").getValue());
						eleMap.put("pKey", et.getAttribute("PKey").getValue());
						eleMap.put("colName", nextChild.getAttribute("ColName").getValue());
						eleMap.put("oType", nextChild.getAttribute("OType").getValue());
						eleMap.put("nType", nextChild.getAttribute("NType").getValue());
						eleMap.put("minV", nextChild.getAttribute("MinV").getValue());
						eleMap.put("maxV", nextChild.getAttribute("MaxV").getValue());
						eleMap.put("optV", nextChild.getAttribute("OptV").getValue());
						eleMap.put("deaIndex", index + "");
						resultMap.add(eleMap);
						index++;
					}
				}
			}
		}
		return resultMap;

	}

}
