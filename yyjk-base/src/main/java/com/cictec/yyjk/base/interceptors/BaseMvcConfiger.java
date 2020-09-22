package com.cictec.yyjk.base.interceptors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.cictec.yyjk.base.service.BaseAccessLogService;
import com.cictec.yyjk.base.service.impl.BaseAccessLogServiceImpl;

//@Configuration
public class BaseMvcConfiger  extends WebMvcConfigurerAdapter {
	private final Logger logger = LoggerFactory.getLogger(BaseMvcConfiger.class);

	@Bean
	public BaseAccessLogService getBaseAccessLogService() {
		return new BaseAccessLogServiceImpl();
	}

	// 添加拦截器
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		logger.info("进入访问拦截器");
		registry.addInterceptor(new ApiAccessInterceptor(getBaseAccessLogService())).addPathPatterns("/**");
	}
}
