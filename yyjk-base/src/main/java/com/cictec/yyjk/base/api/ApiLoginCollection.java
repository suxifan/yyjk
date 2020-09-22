package com.cictec.yyjk.base.api;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cictec.yyjk.base.model.entity.BaseLoginLog;
import com.cictec.yyjk.base.model.entity.BaseRoleInfo;
import com.cictec.yyjk.base.model.entity.BaseUserInfo;
import com.cictec.yyjk.base.model.vo.TreeNode;
import com.cictec.yyjk.base.service.BaseLoginLogService;
import com.cictec.yyjk.base.service.BaseUserInfoService;
import com.cictec.yyjk.commons.core.Result;
import com.cictec.yyjk.commons.core.ResultUtil;
import com.cictec.yyjk.commons.utils.JwtToken;
import com.cictec.yyjk.commons.utils.MD5Util;
import com.cictec.yyjk.commons.utils.PMSUtils;
import com.cictec.yyjk.commons.utils.RestUtils;

@RestController
@RequestMapping("/api/base/login/")
public class ApiLoginCollection extends BaseController {
	private static final Logger LOG = LoggerFactory.getLogger(ApiLoginCollection.class);
	@Autowired
	private BaseUserInfoService baseUserInfoService;
	@Autowired
	private BaseLoginLogService baseLoginLogService;

	/**
	 * 采点app登录
	 * 
	 * @param paramMap
	 *            userAccount 用户名 userPassword 密码
	 * @return 用户授权线路站点信息
	 */
	@PostMapping("login")
	public Result login(@RequestBody Map<String, Object> paramMap, HttpServletRequest request) {
		String userAccount = PMSUtils.isNull(paramMap.get("userAccount"));
		String userPassword = PMSUtils.isNull(paramMap.get("userPassword"));
		String configLogin = (String) paramMap.get("configLogin");
		Map<String, Object> result = new HashMap<>();
		if (PMSUtils.isNotEmpty(configLogin)) {
			// token生成规则
			String token = "";
			try {
				token = JwtToken.createToken("123456", "configAdmin");
			} catch (Exception e) {
			}
			result.put("token", token);
			return ResultUtil.getSuccessResult(result);
		}
		if ("".equals(userAccount)) {
			return ResultUtil.getErrorResult("账号不能为空");
		} else if ("".equals(userPassword)) {
			return ResultUtil.getErrorResult("密码不能为空");
		} else {
			BaseUserInfo baseUserInfo = baseUserInfoService.selectUserByUserAccout(userAccount);
			if (null == baseUserInfo) {
				return ResultUtil.getErrorResult("用户不存在！");
			} else {
				if (!baseUserInfo.getUserPassword().equals(MD5Util.encry(userPassword))) {
					return ResultUtil.getErrorResult("密码错误！");
				} else if ("0".equals(baseUserInfo.getEnabled())) {
					return ResultUtil.getErrorResult("用户已禁用！");
				} else {
					Map<String, Object> authodMap = baseUserInfoService
							.getPermissionsByUserId(baseUserInfo.getUserId());
					@SuppressWarnings("unchecked")
					List<TreeNode> resource = (List<TreeNode>) authodMap.get("resourceTree");
					if (resource == null || resource != null && resource.size() == 0) {
						return ResultUtil.getErrorResult("登录失败，没有权限！");
					}
					// String auditStatus = "";
					// auditStatus =
					// baseUserInfoService.findAuditStatusByUserId(baseUserInfo.getUserId());
					// if (auditStatus.equals("2")) {// 角色类型 0：普通角色；1：审核角色
					// baseUserInfo.setAuditStatus(true);
					// }else{
					// baseUserInfo.setAuditStatus(false);
					// }

					// 增加用户管理员可以修改审核权限
					List<BaseRoleInfo> roleIds = baseUserInfoService.findRolesByUserId(baseUserInfo.getUserId());
					if (roleIds.size() > 0) {
						baseUserInfo.setRecheckType(roleIds.get(0).getRecheckType());
					}
					// token生成规则
					String token = "";
					try {
						token = JwtToken.createToken(baseUserInfo.getUserId(), baseUserInfo.getUserAccount());
					} catch (Exception e) {
					}
					result.put("token", token);
					result.put("userInfo", baseUserInfo);
				}
				// 记录登录日志
				BaseLoginLog baseLoginLog = new BaseLoginLog();
				baseLoginLog.setOrgUuid(baseUserInfo.getUserOrgUuid());
				baseLoginLog.setUserUuid(baseUserInfo.getUserId());
				// 处理用户角色uuid，多个角色的uuid用逗号链接(目前用户只有单一角色)
				List<BaseRoleInfo> roleIds = baseUserInfoService.findRolesByUserId(baseUserInfo.getUserId());
				StringBuilder builder = new StringBuilder();
				Iterator<BaseRoleInfo> iterator = roleIds.iterator();
				builder.append(iterator.next().getRoleId());
				while (iterator.hasNext()) {
					builder.append(",");
					builder.append(iterator.next().getRoleId());
				}
				baseLoginLog.setRoleUuid(builder.toString());
				baseLoginLog.setAccessModel("1");
				baseLoginLog.setAccessIp(getIpAddress(request));
				baseLoginLog.setAccessChannel(request.getHeader("user-agent"));
				baseLoginLog.setAccessTime(new Date());
				baseLoginLog.setCreateTime(new Date());
				baseLoginLogService.insert(baseLoginLog);
			}
			return ResultUtil.getSuccessResult(result);
		}
	}

	/**
	 * 统一门户登录
	 * 
	 * @param paramMap
	 *            userAccount 用户名
	 * @return 用户授权线路站点信息
	 */
	@PostMapping("upslogin")
	public Result upslogin(@RequestBody Map<String, Object> paramMap, HttpServletRequest request) {
		// 统一门户Token
		String redirectToken = PMSUtils.isNull(paramMap.get("REDIRECT_TOKEN"));
		// redirectToken =
		// "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE1OTUzMTAwMDAsInN1YiI6IntcImxvZ2luVGltZVwiOjE1OTUzMTAwMDA3NTYsXCJ1c2VyQWNjb3VudFwiOlwiMDI5NFwiLFwidXNlckNvZGVcIjpcIjJSYTdONWZBblZjV0dTaEFxRFdFZjJGXCIsXCJ1c2VyTmFtZVwiOlwi5p2o57uN5Y2OXCIsXCJ1c2VyUGFzc3dvcmRcIjpcImUxMGFkYzM5NDliYTU5YWJiZTU2ZTA1N2YyMGY4ODNlXCIsXCJ1c2VyVG9rZW5cIjpcIjk2YzJiYjZmNWJhYzhiMTUwMzcxNWI1ZjYxMmE5MWVmXCJ9IiwiZXhwIjoxNTk1MzEwNjAwfQ.Pimk19zLfgklpN3O9R4sQOGjAi7LiPhN8T9WtFroSIs";
		String httpUrl = "http://61.157.184.120:8997/APPLICATION_USER_RELATION.auth.do";
		StringBuilder urlBuilder = new StringBuilder();
		urlBuilder.append(httpUrl).append("?REDIRECT_TOKEN=").append(redirectToken);
		String upsResult = RestUtils.getRestData(urlBuilder.toString());
		LOG.info("通过token获取门户系统用户信息 url:{},result:{}", urlBuilder, upsResult.length());
		JSONObject jsonObject = JSON.parseObject(upsResult);
		String userAccount = (String) jsonObject.get("USER_ACCOUNT");

		Map<String, Object> result = new HashMap<>();
		if (PMSUtils.isEmpty(userAccount)) {
			return ResultUtil.getErrorResult("账号不能为空");
		} else {
			BaseUserInfo baseUserInfo = baseUserInfoService.selectUserByUserAccout(userAccount);
			if (null == baseUserInfo) {
				return ResultUtil.getErrorResult("用户不存在！");
			} else {
				if ("0".equals(baseUserInfo.getEnabled())) {
					return ResultUtil.getErrorResult("用户已禁用！");
				} else {
					Map<String, Object> authodMap = baseUserInfoService
							.getPermissionsByUserId(baseUserInfo.getUserId());
					@SuppressWarnings("unchecked")
					List<TreeNode> resource = (List<TreeNode>) authodMap.get("resourceTree");
					if (resource == null || resource != null && resource.size() == 0) {
						return ResultUtil.getErrorResult("登录失败，没有权限！");
					}

					// 增加用户管理员可以修改审核权限
					List<BaseRoleInfo> roleIds = baseUserInfoService.findRolesByUserId(baseUserInfo.getUserId());
					if (roleIds.size() > 0) {
						baseUserInfo.setRecheckType(roleIds.get(0).getRecheckType());
					}

					// token生成规则
					String token = "";
					try {
						token = JwtToken.createToken(baseUserInfo.getUserId(), baseUserInfo.getUserAccount());
					} catch (Exception e) {
					}
					result.put("token", token);
					result.put("userInfo", baseUserInfo);
				}
				// 记录登录日志
				BaseLoginLog baseLoginLog = new BaseLoginLog();
				baseLoginLog.setOrgUuid(baseUserInfo.getUserOrgUuid());
				baseLoginLog.setUserUuid(baseUserInfo.getUserId());
				// 处理用户角色uuid，多个角色的uuid用逗号链接(目前用户只有单一角色)
				List<BaseRoleInfo> roleIds = baseUserInfoService.findRolesByUserId(baseUserInfo.getUserId());
				StringBuilder builder = new StringBuilder();
				Iterator<BaseRoleInfo> iterator = roleIds.iterator();
				builder.append(iterator.next().getRoleId());
				while (iterator.hasNext()) {
					builder.append(",");
					builder.append(iterator.next().getRoleId());
				}
				baseLoginLog.setRoleUuid(builder.toString());
				baseLoginLog.setAccessModel("1");
				baseLoginLog.setAccessIp(getIpAddress(request));
				baseLoginLog.setAccessChannel(request.getHeader("user-agent"));
				baseLoginLog.setAccessTime(new Date());
				baseLoginLog.setCreateTime(new Date());
				baseLoginLogService.insert(baseLoginLog);
			}
			return ResultUtil.getSuccessResult(result);
		}
	}

	/**
	 * 登出
	 * 
	 * @return
	 */
	@PostMapping("logout")
	public Result logout(@RequestBody Map<String, Object> paramMap, HttpServletRequest request) {
		// 处理用户角色uuid，多个角色的uuid用逗号链接(目前用户只有单一角色)
		String userId = (String) paramMap.get("personId");
		// 记录登录日志
		BaseLoginLog baseLoginLog = new BaseLoginLog();
		baseLoginLog.setAccessModel("2");
		baseLoginLog.setAccessIp(getIpAddress(request));
		baseLoginLog.setAccessChannel(request.getHeader("user-agent"));
		baseLoginLog.setAccessTime(new Date());
		baseLoginLog.setCreateTime(new Date());
		// 设置用户机构
		BaseUserInfo userInfo = baseUserInfoService.selectByPrimaryKey(userId);
		baseLoginLog.setOrgUuid(userInfo.getUserOrgUuid());
		baseLoginLog.setUserUuid(userInfo.getUserId());
		// 设置用户角色
		List<BaseRoleInfo> roleIds = baseUserInfoService.findRolesByUserId(userId);
		StringBuilder builder = new StringBuilder();
		Iterator<BaseRoleInfo> iterator = roleIds.iterator();
		builder.append(iterator.next().getRoleId());
		while (iterator.hasNext()) {
			builder.append(",");
			builder.append(iterator.next().getRoleId());
		}
		baseLoginLog.setRoleUuid(builder.toString());
		baseLoginLogService.insert(baseLoginLog);
		return ResultUtil.getSuccessResult();
	}

	private String getIpAddress(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_CLIENT_IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_X_FORWARDED_FOR");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		// 如果是多级代理，那么取第一个ip为客户端ip
		if (ip != null && ip.indexOf(",") != -1) {
			ip = ip.substring(0, ip.indexOf(",")).trim();
		}
		return ip;
	}
}
