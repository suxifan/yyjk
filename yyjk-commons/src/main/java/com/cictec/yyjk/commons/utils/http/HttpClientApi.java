package com.cictec.yyjk.commons.utils.http;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSON;
import com.cictec.yyjk.commons.utils.PropertiesUtils;

public class HttpClientApi {

	private static Logger logger = LoggerFactory.getLogger(HttpClientApi.class);
	
	public static String HOST_BASE = "dispatch-base-host";
	public static String HOST_REAL_SCHEDULE =  "dispatch-real-schedule-host";
	public static String HOST_SCHEDULE =  "dispatch-schedule-host";
	public static String HOST_REPORT =  "dispatch-report-host";
	// 默认超时时间
	public static int CONNECT_TIME_OUT = 1000;
	// 默认读取资源时间
	public static int READ_TIME_OUT = 1000;
	
	
	
//	private String host = "http://117.34.118.30:9091/";
	/**
	 * 使用RestTemplate发送HTTP POST请求
	 * 
	 * @param url
	 *            请求地址
	 * @param reqStr
	 *            请求参数
	 * @param connectionTimeout
	 *            连接超时时间
	 * @param socketTimeout
	 *            socket超时时间
	 * @return String 返回报文
	 */
//	public String postRest(String url, String reqStr, int connetionTimeOut, int socketTimeOut) {
//
//		ResponseEntity<String> responseEntity0 = null;
//		HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
//		requestFactory.setConnectTimeout(connetionTimeOut);
//		requestFactory.setReadTimeout(socketTimeOut);
//		RestTemplate restTemplate = new RestTemplate(requestFactory);
//		HttpHeaders headers = new HttpHeaders();
	// headers.set("Content-Type", "text/plain;charset=UTF-8");// 解决请求乱码问题
//		headers.set("Accept", "text/plain;charset=UTF-8");
//		headers.set("User-Agent", "CLIENT(zk/1.2.1;android/1.0;640*480;MOT-XT800)");
//		String body = null;
//		try {
//			responseEntity0 = restTemplate.postForEntity(url, new HttpEntity<String>(reqStr, headers), String.class);
	// logger.debug("响应标头：responseEntity0.getHeaders=" +
	// responseEntity0.getHeaders());
	// body = new String(responseEntity0.getBody().getBytes("ISO-8859-1"),
	// "utf-8");// 解决返回报文的乱码问题
	// logger.debug("响应字符串：responseEntity0.getBody()=" +
	// responseEntity0.getBody());
//		} catch (Exception e) {
//			logger.error(" errpr happened in postRest(),", e);
//		}
//		return body;
//	}

	public static Map postJson(String serverHost,String url, Object obj) {
		
		String serverHostStr = PropertiesUtils.getString(serverHost, "127.0.0.1:8081");
		
		
		String _url = "http://"+serverHostStr+"/"+url;
		String requestJson = JSON.toJSONString(obj);
//
		HttpHeaders headers = new HttpHeaders();
		MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
		headers.setContentType(type);

		HttpEntity<String> entity = new HttpEntity<String>(requestJson, headers);
		SimpleClientHttpRequestFactory  requestFactory = new SimpleClientHttpRequestFactory();
		requestFactory.setConnectTimeout(HttpClientApi.CONNECT_TIME_OUT);
		requestFactory.setReadTimeout(HttpClientApi.READ_TIME_OUT);
		RestTemplate restTemplate = new RestTemplate(requestFactory);
		String result = null;
		try {
			result = restTemplate.postForObject(_url, entity, String.class);
		} catch (Exception e) {
			logger.error(" errpr happened in postRest(),", e);
			Map resultErrorMap = new HashMap();
			resultErrorMap.put("code", "400");
			// resultErrorMap.put("message", "请求超时");
			
			return resultErrorMap;
		} 
		return JSON.parseObject(result, Map.class);
	}

//	public String postJson1(String url, Object obj) {
//		String _url = url;
//		String requestJson = JSON.toJSONString(obj);
//
//		System.out.println("url:" + _url);
//		System.out.println("request:" + requestJson);
//
//		RestTemplate restTemplate = new RestTemplate();
//		String result = restTemplate.postForObject(_url, obj, String.class);
//		System.out.println("response:" + result);
//		System.out.println();
//		return result;
//	}
}
