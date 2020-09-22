package com.cictec.yyjk.commons.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WeatherUtils {
	private static final Logger logger = LoggerFactory.getLogger(WeatherUtils.class);

	/**
	 * 获取天气请求接口
	 * 
	 * 参数二选一 只填写一个，另外一个直接不传递
	 * 
	 * @param{ "city": "@city", "cityCode":"Number" } 城市名称，只能是 市级别，或者县级别，不能使用区
	 * 6位行政编码，可直接进行获取。
	 * 
	 * @return json字符串
	 * @throws IOException
	 */
	public static String requestWeather(String queryJson) {
		String httpUrl = "http://life.yebus.cn:8787/life/city/weather/get";
		BufferedReader reader = null;
		try {
			URL url = new URL(httpUrl);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("POST");
			connection.setDoOutput(true);
			connection.setDoInput(true);
			connection.setUseCaches(false);
			connection.setRequestProperty("Charset", "UTF-8");
			connection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
			connection.setRequestProperty("accept", "application/json");
			// 往服务器里面发送数据
			if (!StringUtils.isEmpty(queryJson)) {
				byte[] querySetting = queryJson.getBytes();
				// 设置文件长度
				connection.setRequestProperty("Content-Length", String.valueOf(querySetting.length));
				OutputStream outwritestream = connection.getOutputStream();
				outwritestream.write(queryJson.getBytes());
				outwritestream.flush();
				outwritestream.close();
				logger.info("get connection success!" + connection.getResponseCode());
			}
			if (connection.getResponseCode() == 200) {
				reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			}
			return reader.readLine();
		} catch (Exception e) {
			logger.error("获取天气异常！原因{}", e);
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				logger.error("{}", e);
			}
		}
		return null;
	}

	public static void main(String[] args) throws Exception {
		String weather = requestWeather("{\"city\":\"东营\",\"cityCode\":\"\"}");
		System.out.println(weather);

		// System.out.println(new SimpleDateFormat("HH").format(new Date()));

	}
	// 东营,邢台,三亚,南阳,延安,西安,三门峡
}
