package com.cictec.yyjk.report.api;

import java.util.LinkedList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cictec.yyjk.commons.core.Result;
import com.cictec.yyjk.commons.core.ResultUtil;
import com.cictec.yyjk.commons.utils.PMSUtils;
import com.cictec.yyjk.commons.utils.RestUtils;

@RestController
@RequestMapping("/video/")
public class ApiVideoController {
	private static final Logger logger = LoggerFactory.getLogger(ApiVideoController.class);
	@Autowired
	private Environment env;

	@RequestMapping(value = "getVideoFile")
	public Result getVideoFile(@RequestParam String terid) {
		String baseUrl = env.getProperty("video.baseurl");
		String username = env.getProperty("video.username");
		String password = env.getProperty("video.password");
		String key = null;
		try {
			StringBuilder urlBuilder = new StringBuilder();
			urlBuilder.append(baseUrl).append("key?username=").append(username).append("&password=").append(password);
			String result = RestUtils.getRestData(urlBuilder.toString());
			JSONObject jsonObject = JSON.parseObject(result);
			JSONObject keyObj = (JSONObject) jsonObject.get("data");
			key = keyObj.getString("key");
			if (PMSUtils.isEmpty(key)) {
				return ResultUtil.getErrorResult("获取key值异常！");
			}
		} catch (Exception ex) {

		}
		//http://192.168.10.40:12056/api/v1/basic/live/port?key=123aaeq3jjkljrqweoiu
		List<String> videoUrls = new LinkedList<>();
		try{
			StringBuilder urlBuilder = new StringBuilder();
			urlBuilder.append(baseUrl).append("live/port?key=").append(key);
			String result = RestUtils.getRestData(urlBuilder.toString());
			JSONObject jsonObject = JSON.parseObject(result);
			JSONArray arrays = (JSONArray) jsonObject.get("data");
			if (PMSUtils.isEmpty(arrays)) {
				return ResultUtil.getErrorResult("获取视频端口信息异常！");
			}
			String firstPort = ((JSONObject)arrays.get(0)).getString("port");
			String secendPort = ((JSONObject)arrays.get(1)).getString("port");
			
			//http://192.168.10.40:12056/api/v1/basic/live/video?key=123aaeq3jjkljrqweoiu&terid=00830007CB&chl=1&audio=1&st=0&port=12060
			for(int i = 0;i<8;i++){
				StringBuilder videoUrlBuilder = new StringBuilder();
				videoUrlBuilder.append(baseUrl).append("live/video?key=").append(key).append("&terid=").append(terid).append("&audio=1&st=0");
				if(i<=3){
					videoUrlBuilder.append("&chl=").append(i).append("&port=").append(firstPort);
				}else{
					videoUrlBuilder.append("&chl=").append(i).append("&port=").append(secendPort);
				}
				videoUrls.add(videoUrlBuilder.toString());
			}
			List<String> results = new LinkedList<>();
			for (String videoUrl : videoUrls) {
				String videoAddrObj = RestUtils.getRestData(videoUrl);
				JSONObject videoObj = JSON.parseObject(videoAddrObj);
				JSONObject urlObj = (JSONObject) videoObj.get("data");
				results.add((String) urlObj.getString("url"));
			}
			return ResultUtil.getSuccessResult(results);
		}catch(Exception ex){
			logger.error("获取视频端口信息异常！错误信息{}", ex);
		}
		return ResultUtil.getErrorResult();
	}
}
