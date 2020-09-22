package com.cictec.yyjk.commons.configurer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

@Configuration
public class WebSocketConfig {
	/**
	 * ServerEndpointExporter 用于扫描和注册所有携带 ServerEndPoint 注解的实例， 若部署到外部容器
	 * 则无需提供此类。
	 *
	 * @return
	 */
	@Bean
	public ServerEndpointExporter serverEndpointExporter() {
		return new ServerEndpointExporter();
	}

	/**
	 * 因 SpringBoot WebSocket 对每个客户端连接都会创建一个 WebSocketServer（@ServerEndpoint
	 * 注解对应的） 对象，Bean 注入操作会被直接略过，因而手动注入一个全局变量
	 * 
	 * 注入代码也可以直接写到@ServerEndpoint 注解对应的） 对象内，本例就直接在WebSocketServlet内直接进行静态注入
	 *
	 * @param messageService
	 */
	// @Autowired
	// public void setTempPltwarnService(TempPltwarnService tempPltwarnService)
	// {
	// WebSocketServlet.tempPltwarnService = tempPltwarnService;
	// }

	// @Autowired
	// public void setBaseUserInfoService(BaseUserInfoService
	// baseUserInfoService) {
	// WebSocketServlet.baseUserInfoService = baseUserInfoService;
	// }
}