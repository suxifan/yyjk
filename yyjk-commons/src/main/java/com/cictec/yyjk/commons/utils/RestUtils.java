package com.cictec.yyjk.commons.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RestUtils {
	private static final Logger logger = LoggerFactory.getLogger(RestUtils.class);
	
	/**
	 * 超时时间
	 */
	private static final int timeoutInMilliSeconds = 1000 * 60 * 2; // 2 MINUTE

	/**
	 * REST post请求服务获取数据,支持json请求参数及字符串格式请求参数
	 * 
	 * @param httpUrl
	 * @param queryStr
	 *            请求字符串 json格式：{"":"","":""...} 或字符串格式：xxx=xxxx&xxx=xxx
	 * @return isJsonContent 请求字符串类型 json:true ;String:false
	 * @throws IOException
	 */
	public static String getPostData(String httpUrl, String queryStr, boolean isJsonContent) {
		StringBuilder resStr = new StringBuilder();
		BufferedReader reader = null;
		try {
			long start = System.currentTimeMillis();
			URL url = new URL(httpUrl);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setConnectTimeout(timeoutInMilliSeconds);
			connection.setRequestMethod("POST");
			connection.setDoOutput(true);
			connection.setDoInput(true);
			connection.setUseCaches(false);
			connection.setRequestProperty("Charset", "UTF-8");
			if (isJsonContent) {
				connection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
				connection.setRequestProperty("accept", "application/json");
			} else {
				connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
				connection.setRequestProperty("accept", "application/x-www-form-urlencoded");
			}
			// 往服务器里面发送数据
			if (!StringUtils.isEmpty(queryStr)) {
				byte[] querySetting = queryStr.getBytes();
				// 设置文件长度
				connection.setRequestProperty("Content-Length", String.valueOf(querySetting.length));
				OutputStream outwritestream = connection.getOutputStream();
				outwritestream.write(querySetting);
				outwritestream.flush();
				outwritestream.close();
				logger.info("connection success!" + connection.getResponseCode());
				long endTime = System.currentTimeMillis();
				logger.info(httpUrl + " 链接时间:" + (endTime - start) + "");
			}
			if (connection.getResponseCode() == 200) {
				long startTime = System.currentTimeMillis();
				reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				String line = null;
				while ((line = reader.readLine()) != null) {
					resStr.append(line);
				}
				long httpTime = System.currentTimeMillis();
				logger.info(httpUrl + " 读取   时间:" + (httpTime - startTime) + "");
			}
		} catch (Exception e) {
			logger.error("获取数据异常！原因：{}", e);
		} finally {
			try {
				if (reader != null) {
					reader.close();
				}
			} catch (IOException e) {
			}
		}
		return resStr.toString();
	}

	/**
	 * 
	 * REST get请求服务，获取数据
	 * 
	 * @param httpUrl
	 *            带查询字符串的url
	 * @return json字符串
	 * @throws IOException
	 */
	public static String getRestData(String httpUrl) {
		StringBuilder retStr = new StringBuilder();
		BufferedReader reader = null;
		URLConnection con;
		try {
			URL url = new URL(httpUrl);
			con = url.openConnection();
			con.setConnectTimeout(timeoutInMilliSeconds);
			reader = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
			String line = reader.readLine();
			while (line != null) {
				retStr.append(line).append("\r\n");
				line = reader.readLine();
			}
		} catch (Exception e) {
			logger.error("获取数据异常！原因：{}", e);
		} finally {
			if (null != reader) {
				try {
					reader.close();
				} catch (IOException e) {
				}
			}
		}
		return retStr.toString();
	}

}
