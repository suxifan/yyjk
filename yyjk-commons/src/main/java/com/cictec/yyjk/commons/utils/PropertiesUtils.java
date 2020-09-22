package com.cictec.yyjk.commons.utils;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.StandardServletEnvironment;


/**
 * 加载配置文件工具类，需要配置到spring的xml中
 * @author qilei
 *
 */
@Component
//public class PropertiesUtils extends PropertyPlaceholderConfigurer implements Map<String, String> {
public class PropertiesUtils {

	private static Environment env;

	@Autowired
	protected void set(Environment env) throws IOException {
		PropertiesUtils.env = env;
	}
	   
	
	private static final Logger logger = LoggerFactory.getLogger(PropertiesUtils.class);

//	protected void processProperties(ConfigurableListableBeanFactory beanFactoryToProcess, Properties props)
//			throws BeansException {
//		super.processProperties(beanFactoryToProcess, props);
//		if (ctxPropertiesMap != null) {
//			logger.warn("The property map will be override!");
//		}
//		ctxPropertiesMap = new HashMap<String, String>();
//		for (Object key : props.keySet()) {
//			String keyStr = key.toString();
//			String value = props.getProperty(keyStr);
//			ctxPropertiesMap.put(keyStr, value);
//		}
//	}

	public static String getString(String name) {
		if(env == null){
			env = new StandardServletEnvironment();
			logger.warn("The property Environment is Null");
		}
		return env.getProperty(name);
	}
	
	public static String getString(String name, String defaultValue) {
		String v = env.getProperty(name);
		if(v != null){
			return v;
		}
		
		return defaultValue;
	}

	public static boolean getBoolean(String name, boolean defaultValue) {
		String v = getString(name);
		if (v == null) {
			return defaultValue;
		}
		try {
			return Boolean.parseBoolean(v);
		} catch (Exception e) {
		}
		return defaultValue;
	}

	public static int getIntValue(String name, int defaultValue) {
		String v = getString(name);
		if (v == null) {
			return defaultValue;
		}
		try {
			return Integer.parseInt(v);
		} catch (Exception e) {
		}
		return defaultValue;
	}

	public static long getLongValue(String name, long defaultValue) {
		String v = getString(name);
		if (v == null) {
			return defaultValue;
		}
		try {
			return Long.parseLong(v);
		} catch (Exception e) {
		}
		return defaultValue;
	}

	public static short getShortValue(String name, short defaultValue) {
		String v = getString(name);
		if (v == null) {
			return defaultValue;
		}
		try {
			return Short.parseShort(v);
		} catch (Exception e) {
		}
		return defaultValue;
	}

	public static double getDoubleValue(String name, double defaultValue) {
		String v = getString(name);
		if (v == null) {
			return defaultValue;
		}
		try {
			return Double.parseDouble(v);
		} catch (Exception e) {
		}
		return defaultValue;
	}

	public static float getFloatValue(String name, float defaultValue) {
		String v = getString(name);
		if (v == null) {
			return defaultValue;
		}
		try {
			return Float.parseFloat(v);
		} catch (Exception e) {
		}
		return defaultValue;
	}

	public boolean containsKey(Object key) {
		return env.containsProperty((String) key);
	}

}