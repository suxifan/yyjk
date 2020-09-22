package com.cictec.yyjk.base.interceptors;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import com.alibaba.fastjson.JSON;
import com.cictec.yyjk.base.model.entity.BaseAccessLog;
import com.cictec.yyjk.base.model.entity.BaseRoleInfo;
import com.cictec.yyjk.base.model.entity.BaseUserInfo;
import com.cictec.yyjk.base.model.vo.BusVo;
import com.cictec.yyjk.base.service.BaseAccessLogService;
import com.cictec.yyjk.base.service.BaseUserInfoService;
import com.cictec.yyjk.commons.utils.IpUtils;

@Aspect
@Component
public class LogAspect {
	private static final Logger LOG = LoggerFactory.getLogger(LogAspect.class);
	@Autowired
	private BaseAccessLogService baseAccessLogService;
	@Autowired
	private BaseUserInfoService baseUserInfoService;

	/**
	 * 此处的切点是注解的方式，也可以用包名的方式达到相同的效果 '@Pointcut(
	 * "execution(* com.wwj.springboot.service.impl.*.*(..))")'
	 */
	@Pointcut("execution(* com.cictec.yyjk.**.api.*.*(..))")
	public void operationLog() {

	}

	@Before("operationLog()")
	public void doBeforeAdvice(JoinPoint joinPoint) {
		Object[] args = joinPoint.getArgs();
		Object object = args[0];
		if (object instanceof BusVo) {

		}

		// System.out.println("进入方法前执行.....");

	}

	/**
	 * 后置最终通知,final增强，不管是抛出异常或者正常退出都会执行
	 */
	@After("operationLog()")
	public void after(JoinPoint jp) {
		// System.out.println("方法最后执行.....");
	}

	/**
	 * 环绕增强，相当于MethodInterceptor
	 */
	@Around("operationLog()")
	public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
		Object res = null;
		long interval = System.currentTimeMillis();
		try {
			res = joinPoint.proceed();
			interval = System.currentTimeMillis() - interval;
			return res;
		} finally {
			try {
				// 方法执行完成后增加日志
				addOperationLog(joinPoint, res, interval);
			} catch (Exception e) {
				LOG.info("LogAspect 操作失败：", e);
			}
		}
	}

	@SuppressWarnings("rawtypes")
	private void addOperationLog(JoinPoint joinPoint, Object res, long interval) {
		// 获取注解信息
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		AccessLogInfo annotation = signature.getMethod().getAnnotation(AccessLogInfo.class);
		if (annotation == null) {
			return;
		}
		// 通过RequestContextHolder获取request,session信息
		RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = (HttpServletRequest) requestAttributes
				.resolveReference(RequestAttributes.REFERENCE_REQUEST);

		// HttpSession session = (HttpSession)
		// requestAttributes.resolveReference(RequestAttributes.REFERENCE_SESSION);
		//
		String method = request.getMethod();
		String queryString = request.getQueryString();
		Object[] args = joinPoint.getArgs();
		String params = "";
		Map postParrams = null;
		// 获取请求参数集合并进行遍历拼接
		if (args.length > 0) {
			if ("POST".equals(method)) {
				Object object = args[0];
				postParrams = getKeyAndValue(object);
				params = JSON.toJSONString(postParrams);
			} else if ("GET".equals(method)) {
				params = queryString;
			}
		}

		BaseAccessLog accessLog = new BaseAccessLog();
		// 获取IP地址
		String ipAddress = IpUtils.getIpAddress(request);
		accessLog.setAccessIp(ipAddress);

		String userId = (String) postParrams.get("personId");
		if(StringUtils.isEmpty(userId)){
			return ;
		}
		// 设置用户机构
		BaseUserInfo userInfo = baseUserInfoService.selectByPrimaryKey(userId);
		if (userInfo != null) {
			accessLog.setOrgUuid(userInfo.getUserOrgUuid());
			accessLog.setUserUuid(userInfo.getUserId());
		}
		// 设置用户角色
		List<BaseRoleInfo> roleIds = baseUserInfoService.findRolesByUserId(userId);
		if (CollectionUtils.isNotEmpty(roleIds)) {
			StringBuilder builder = new StringBuilder();
			Iterator<BaseRoleInfo> iterator = roleIds.iterator();
			builder.append(iterator.next().getRoleId());
			while (iterator.hasNext()) {
				builder.append(",");
				builder.append(iterator.next().getRoleId());
			}
			accessLog.setRoleUuid(builder.toString());
		}

		accessLog.setAccessDuration(interval);
		accessLog.setAccessTime(new Date());
		accessLog.setCreateTime(new Date());
		accessLog.setAccessModelName(annotation.modelName());
		accessLog.setAccessPageName(annotation.pageName());
		// 这里保存日志
		baseAccessLogService.insert(accessLog);
	}

	@SuppressWarnings("rawtypes")
	public static Map<String, Object> getKeyAndValue(Object obj) {
		if (obj == null) {
			return Collections.emptyMap();
		}
		// 得到类中的所有属性集合
		List<Field> fields = new ArrayList<>();
		// 得到类对象
		Class clazz = (Class) obj.getClass();
		while (clazz != null) {
			fields.addAll(new ArrayList<>(Arrays.asList(clazz.getDeclaredFields())));
			clazz = clazz.getSuperclass();
		}

		Map<String, Object> map = new HashMap<>();

		for (int i = 0; i < fields.size(); i++) {
			Field f = fields.get(i);
			f.setAccessible(true); // 设置些属性是可以访问的
			Object val = new Object();
			try {
				val = f.get(obj);
				// 得到此属性的值
				map.put(f.getName(), val);// 设置键值
			} catch (Exception e) {
				LOG.error("获取属性值失败！", e);
			}
		}
		return map;
	}

	/**
	 * 处理完请求，返回内容
	 * 
	 * @param ret
	 */
	@AfterReturning(returning = "ret", pointcut = "operationLog()")
	public void doAfterReturning(Object ret) {
		// System.out.println("方法的返回值 : " + ret);
	}

	/**
	 * 后置异常通知
	 */
	@AfterThrowing("operationLog()")
	public void throwss(JoinPoint jp) {
		// System.out.println("方法异常时执行.....");
	}

}
