package com.cictec.yyjk.commons.utils.baseMessage;

import java.lang.reflect.Field;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cictec.yyjk.commons.utils.HttpClientUtils;
import com.cictec.yyjk.commons.utils.PropertiesUtils;

public class BaseMessageUtil {
	private static final Logger LOG = LoggerFactory.getLogger(BaseMessageUtil.class);
	
	/**
	 * 
	 * @param id
	 *            消息模板编码
	 * @param model
	 * @return
	 */
  public static String createMessage(String id,BaseMessageModel model) {

	  String str = "";
	  try {
		  String ip = PropertiesUtils.getString("server.ip","127.0.0.1");
		  String port = PropertiesUtils.getString("server.port","8081");
		  String url = "http://"+ip+":"+port+"/api/messageManagement/v1.0/selectById";
		  String res = HttpClientUtils.sendJSONPostRequest(url, "{\"id\":"+id+"}", "UTF-8");
		  if(res!=null) {
			  JSONObject obj = JSON.parseObject(res);
			  JSONObject data = obj.getJSONObject("data");
			  String msgContent = data.getString("msgContent");
			  Class cls = model.getClass();
			  Field[] fields = cls.getDeclaredFields(); 
			  for(int i=0; i<fields.length; i++){  
		          Field f = fields[i];  
		          f.setAccessible(true);  
					// System.out.println("属性名:" + f.getName() + " 属性值:" +
					// f.get(model));
				  if(f.get(model)!=null&&!"".equals((f.get(model)))){
					  msgContent = msgContent.replace(f.getName(), (String)f.get(model));
				  }else {
					  msgContent = msgContent.replace(f.getName(), "");
				  }
		      } 
			  if(msgContent.indexOf("$")>=0) {
					str = "请按模板传入元素参数！！！";
			  }else {
				  str = msgContent;
			  }
		  }
		  
	  } catch (IllegalArgumentException e) {
			LOG.error(e.getMessage(), e);
	  } catch (IllegalAccessException e) {
			LOG.error(e.getMessage(), e);
	  }
	  return str;
  }
  
  
  public static String createMessageByContent(String content,BaseMessageModel model) {
	  String str = "";
	  try {
			  Class cls = model.getClass();
			  Field[] fields = cls.getDeclaredFields(); 
			  for(int i=0; i<fields.length; i++){  
		          Field f = fields[i];  
		          f.setAccessible(true);  
				// System.out.println("属性名:" + f.getName() + " 属性值:" +
				// f.get(model));
				  if(f.get(model)!=null&&!"".equals((f.get(model)))){
					  content = content.replace(f.getName(), (String)f.get(model));
				  }else {
					  content = content.replace(f.getName(), "");
				  }
		      } 
			  if(content.indexOf("$")>=0) {
				str = "请按模板传入元素参数！！！";
			  }else {
				  str = content;
			  }
		  
	  } catch (IllegalArgumentException e) {
			LOG.error(e.getMessage(), e);
	  } catch (IllegalAccessException e) {
			LOG.error(e.getMessage(), e);
	  }
	  return str;
  }
}
