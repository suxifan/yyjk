package com.cictec.yyjk.fatigue.utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;

/**
 * 根据经纬度获取地址
 */
public class GetLatAndLngByBaidu {

	public static void main(String[] args) {
		double lat = 31.931349213122;
		double lng = 120.96189745647;
		try {
			String s = getLocationByBaiduMap(lng, lat);
			System.out.println(s);
		} catch (Exception e) {
			// e.printStackTrace();
		}

	}

	public static String getLocationByBaiduMap(double longitude, double latitude) throws Exception {
		String addrJson = geturl(String.format(
				"http://api.map.baidu.com/geocoder?ak=f247cdb592eb43ebac6ccd27f796e2d2&location=%s,%s&language=CN",
				latitude, longitude));
		Document doc = null;
		String address = "";
		try {
			doc = DocumentHelper.parseText(addrJson);
			address = doc.getRootElement().element("result").element("formatted_address").getText();
		} catch (DocumentException e) {
			// e.printStackTrace();
		}
		return address;
	}

	private static String geturl(String geturl) throws Exception {
		// 请求的webservice的url
		URL url = new URL(geturl);
		// 创建http链接
		HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
		// 设置请求的方法类型
		httpURLConnection.setRequestMethod("POST");
		// 设置请求的内容类型
		httpURLConnection.setRequestProperty("Content-type", "application/x-www-form-urlencoded");
		// 设置发送数据
		httpURLConnection.setDoOutput(true);
		// 设置接受数据
		httpURLConnection.setDoInput(true);
		// 发送数据,使用输出流
		OutputStream outputStream = httpURLConnection.getOutputStream();
		// 发送的soap协议的数据
		// String requestXmlString = requestXml("北京");
		String content = "user_id=" + URLEncoder.encode("13846", "utf-8");
		// 发送数据
		outputStream.write(content.getBytes());
		// 接收数据
		InputStream inputStream = httpURLConnection.getInputStream();
		BufferedReader in = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
		StringBuffer buffer = new StringBuffer();
		String line = "";
		while ((line = in.readLine()) != null) {
			buffer.append(line);
		}
		String str = buffer.toString();
		return str;
	}

}
