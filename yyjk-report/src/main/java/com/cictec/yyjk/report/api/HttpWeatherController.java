package com.cictec.yyjk.report.api;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cictec.yyjk.commons.core.Result;
import com.cictec.yyjk.commons.core.ResultUtil;
import com.cictec.yyjk.commons.utils.RestUtils;

/**
 * 天气预报相关HTTP获取实时数据控制类
 * 
 * @author gxp
 *
 */
@RestController
@RequestMapping(value = "/zhfxpt/")
public class HttpWeatherController {
	@Autowired
	private Environment env;

	/**
	 * 第一次查询天气失败，需要过一段时间在查询
	 * 
	 * 原因：第一次查询如果没有，服务会调用相关城市天气，这个过程有延迟，等5秒以后再次获取
	 * 
	 * 我们这里为了较高的成功率，失败后再做2次查询，第一次延迟5秒，第二次延迟1分钟
	 */
	@RequestMapping(value = "weather/getNowWeather")
	public Result getNowWeather(@RequestBody Map<String, Object> paramMap) {
		String httpUrl = env.getProperty("weather.http.url");
		String cityName = env.getProperty("weather.query.cityname");
		// cityName = new String(cityName.getBytes(StandardCharsets.ISO_8859_1),
		// StandardCharsets.UTF_8);
		String jsonString = "{\"city\":\"" + cityName + "\",\"cityCode\":\"\"}";
		String result = RestUtils.getPostData(httpUrl, jsonString, true);
		JSONObject jsonObject = JSON.parseObject(result);
		if (!"0".equals(jsonObject.get("status"))) {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {

			}
			result = RestUtils.getPostData(httpUrl, jsonString, true);
			jsonObject = JSON.parseObject(result);
			if (!"0".equals(jsonObject.get("status"))) {
				try {
					Thread.sleep(60000);
				} catch (InterruptedException e) {

				}
				result = RestUtils.getPostData(httpUrl, jsonString, true);
				jsonObject = JSON.parseObject(result);
			}
		}
		return ResultUtil.getSuccessResult(jsonObject);
	}
}
