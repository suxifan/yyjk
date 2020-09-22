package com.cictec.yyjk.base.interceptors;

import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.cictec.yyjk.base.model.entity.BaseAccessLog;
import com.cictec.yyjk.base.model.entity.BaseUserInfo;
import com.cictec.yyjk.base.service.BaseAccessLogService;
import com.cictec.yyjk.commons.utils.IpUtils;

public class ApiAccessInterceptor implements HandlerInterceptor {
	public AtomicLong atomicLong = new AtomicLong();// 计数器

	private BaseAccessLogService baseAccessLogService;

	public ApiAccessInterceptor(BaseAccessLogService baseAccessLogService) {
		this.baseAccessLogService = baseAccessLogService;
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		long startTime = System.nanoTime();
		String ipAddress = IpUtils.getIpAddress(request);
		request.setAttribute("ipAddress", ipAddress);
		request.setAttribute("startTime", startTime);
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		String ipAddress = (String) request.getAttribute("ipAddress");
		long startTime = (Long) request.getAttribute("startTime");
		// SessionInfo session = (SessionInfo) request.getSession();
		BaseUserInfo baseUserInfo = (BaseUserInfo) request.getSession().getAttribute("userInfo");
		String roleUuid = (String) request.getSession().getAttribute("roleUuid");
		long interval = (System.nanoTime() - startTime) / 1000000;// 毫秒
		String uri = request.getRequestURI();
		BaseAccessLog bean = new BaseAccessLog();
		bean.setOrgUuid(baseUserInfo.getUserOrgUuid());
		bean.setUserUuid(baseUserInfo.getUserId());
		bean.setRoleUuid(roleUuid);
		bean.setAccessIp(ipAddress);
		bean.setAccessDuration(interval);
		bean.setAccessTime(new Date());
		bean.setCreateTime(new Date());
		baseAccessLogService.insert(bean);
	}

}
