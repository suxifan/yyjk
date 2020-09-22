package com.cictec.yyjk.base.api;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cictec.yyjk.base.interceptors.AccessLogInfo;
import com.cictec.yyjk.base.model.entity.BaseRoleInfo;
import com.cictec.yyjk.base.model.entity.BaseUserInfo;
import com.cictec.yyjk.base.model.vo.BaseUserInfoVo;
import com.cictec.yyjk.base.model.vo.BaseUserRoleVo;
import com.cictec.yyjk.base.model.vo.TreeNode2;
import com.cictec.yyjk.base.service.BaseUserInfoService;
import com.cictec.yyjk.base.service.BaseUserRoleService;
import com.cictec.yyjk.commons.core.Result;
import com.cictec.yyjk.commons.core.ResultUtil;
import com.cictec.yyjk.commons.utils.MD5Util;
import com.cictec.yyjk.commons.utils.PMSUtils;
import com.github.pagehelper.PageInfo;

/**
 * Created by xpguo on 2019/05/28.
 */
@RestController
@RequestMapping("/api/base/user")
public class ApiBaseUserInfo extends BaseController {
	private static final Logger LOG = LoggerFactory.getLogger(ApiBaseUserInfo.class);
	@Resource
	private BaseUserInfoService baseUserInfoService;

	@Resource
	private BaseUserRoleService baseUserRoleService;

	@PostMapping("/add")
	public Result add(@RequestBody BaseUserInfo baseUserInfo, HttpServletRequest request) {
		baseUserInfo.setCreateUser(getUserIdByToken(request).getUserAccount());
		BaseUserInfo result = baseUserInfoService.selectUserByUserAccout(baseUserInfo.getUserAccount());
		if (result != null) {
			return ResultUtil.getErrorResult("该用户账户已存在！");
		}
		// MD5加密
		baseUserInfo.setUserId(null);
		baseUserInfo.setUserPassword(MD5Util.encry(baseUserInfo.getUserPassword()));
		try {
			baseUserInfoService.addUser(baseUserInfo);
			return ResultUtil.getSuccessResult();
		} catch (Exception ex) {
			LOG.error("新增用户失败，原因{}", ex);
			return ResultUtil.getErrorResult("新增用户失败");
		}
	}

	@PostMapping("/delete")
	public Result delete(@RequestBody Map<String, Object> paramMap) {
		String userId = PMSUtils.isNull(paramMap.get("id"));
		boolean result = baseUserInfoService.delUserAndRoles(userId);
		if (result) {
			return ResultUtil.getSuccessResult();
		}
		return ResultUtil.getErrorResult();
	}

	@PostMapping("/update")
	public Result update(@RequestBody BaseUserInfo baseUserInfo, HttpServletRequest request) {
		baseUserInfo.setUpdateUser(getUserIdByToken(request).getUserAccount());
		baseUserInfo.setUpdateTime(new Date());
		// boolean result =
		// baseUserInfoService.updateUserAndRoles(baseUserInfo);
		// if (result) {
		// return ResultUtil.getSuccessResult();
		// }
		// return ResultUtil.getErrorResult();
		//
		try {
			boolean result = baseUserInfoService.updateUserAndRoles(baseUserInfo);
			if (result) {
				return ResultUtil.getSuccessResult();
			} else {
				return ResultUtil.getErrorResult("修改用户失败");
			}
		} catch (Exception ex) {
			LOG.error("修改用户失败，原因{}", ex);
			return ResultUtil.getErrorResult("修改用户失败");
		}

	}

	/**
	 * 重置密码接口
	 * 
	 * @param paramMap
	 * @return
	 */
	@PostMapping("/resetPassWord")
	public Result resetPassWord(@RequestBody Map<String, Object> paramMap) {
		String userId = PMSUtils.isNull(paramMap.get("id"));
		if ("".equals(userId)) {
			return ResultUtil.getErrorResult("用户id为空！");
		}
		BaseUserInfo userInfo = baseUserInfoService.selectByPrimaryKey(userId);
		String password = MD5Util.encry("123456");
		userInfo.setUserPassword(password);
		userInfo.setUpdateTime(new Date());
		userInfo.setUpdateUser(userInfo.getUserRealName());
		try {
			baseUserInfoService.updateByFieldSelective("userId", userInfo);
			return ResultUtil.getSuccessResult();
		} catch (Exception ex) {
			LOG.error("重置密码接口失败，原因{}", ex);
		}
		return ResultUtil.getErrorResult();
	}

	/**
	 * 修改密码接口
	 * 
	 * @param paramMap
	 * @return
	 */
	@PostMapping("/updatePassWord")
	public Result updatePassWord(@RequestBody Map<String, Object> paramMap, HttpServletRequest request) {
		String userId = getUserIdByToken(request).getUserId();
		String oldUserPassword = PMSUtils.isNull(paramMap.get("oldUserPassword"));
		String userPassword = PMSUtils.isNull(paramMap.get("userPassword"));
		BaseUserInfo baseUserInfo = baseUserInfoService.selectByPrimaryKey(userId);

		if (MD5Util.encry(oldUserPassword).equals(baseUserInfo.getUserPassword())) {
			baseUserInfo.setUserPassword(MD5Util.encry(userPassword));
			baseUserInfo.setUpdateTime(new Date());
			baseUserInfo.setUpdateUser(baseUserInfo.getUserRealName());
			baseUserInfoService.updateByFieldSelective("userId", baseUserInfo);
		} else {
			return ResultUtil.getErrorResult("旧密码错误");
		}
		return ResultUtil.getSuccessResult();
	}

	@PostMapping("/detail")
	public Result detail(@RequestBody Map<String, Object> paramMap) {
		try {
			String userId = PMSUtils.isNull(paramMap.get("id"));
			if (PMSUtils.isEmpty(userId)) {
				return ResultUtil.getErrorResult("用户id为空！");
			}
			BaseUserInfo baseUserInfo = baseUserInfoService.getDetail(userId);
			return ResultUtil.getSuccessResult(baseUserInfo);
		} catch (Exception ex) {

		}
		return ResultUtil.getErrorResult();
	}

	@AccessLogInfo(modelName = "权限管理", pageName = "用户列表")
	@PostMapping("/list")
	public Result list(@RequestBody BaseUserInfoVo baseUserInfoVo, HttpServletRequest request) {
		String userAccount = getUserIdByToken(request).getUserAccount();
		baseUserInfoVo.setTokenUserAccount(userAccount);
		// 判定是否包含分页参数，如果包含则为分页数据请求
		if (baseUserInfoVo.getPageSize() != null && baseUserInfoVo.getPageSize() != 0) {
			return pageList(baseUserInfoVo);
		}

		// 根据具体业务重写
		// PageInfo<BaseUserInfo> pageInfo =
		// baseUserInfoService.getUserInfoByVo(baseUserInfoVo);
		List<BaseUserInfo> list = baseUserInfoService.getUsersByOrgId(baseUserInfoVo.getOrgId());
		return ResultUtil.getSuccessResult(list);
	}

	@PostMapping("/pageList")
	public Result pageList(@RequestBody BaseUserInfoVo baseUserInfoVo) {
		// 分页数据请求处理
		// PageHelper.startPage(baseUserInfoVo.getPageNumber(),
		// baseUserInfoVo.getPageSize());
		// 分页
		PageInfo<BaseUserInfo> pageInfo = baseUserInfoService.getUserInfoByVo(baseUserInfoVo);
		return ResultUtil.getSuccessResult(pageInfo);
	}

	@PostMapping("/getUserList")
	public Result getUserList(@RequestBody Map<String, Object> param) {
		String orgId = (String) param.get("orgId");
		List<BaseUserInfo> list = baseUserInfoService.getUsersByOrgId(orgId);
		return ResultUtil.getSuccessResult(list);
	}

	/**
	 * 获取用户角色信息
	 * 
	 * @param id
	 * @return
	 */
	@PostMapping("/getRolesByUserId")
	public Result getRolesByUserId(@RequestParam String id) {
		List<BaseRoleInfo> userRoles = baseUserInfoService.findRolesByUserId(id);
		return ResultUtil.getSuccessResult(userRoles);
	}

	/**
	 * 根据用户id获取用户权限（用户所有角色权限）
	 * 
	 * @param id
	 * @return
	 */
	@PostMapping("/getPermissionsByUserId")
	public Result getPermissionsByUserId(@RequestBody Map<String, Object> paramMap) {
		if (PMSUtils.isEmpty(paramMap.get("id"))) {
			return ResultUtil.getErrorResult("用户id不能为空！");
		}
		Map<String, Object> result = baseUserInfoService.getPermissionsByUserId((String) paramMap.get("id"));
		return ResultUtil.getSuccessResult(result);
	}

	/**
	 * 根据用户id获取用户数据权限（用户所有角色权限）
	 * 
	 * @param id
	 * @return
	 */
	@PostMapping("/getDataPermissionsByUserId")
	public Result getDataPermissionsByUserId(@RequestBody Map<String, Object> paramMap) {
		if (PMSUtils.isEmpty(paramMap.get("id"))) {
			return ResultUtil.getErrorResult("用户id不能为空！");
		}
		Map<String, Object> result = baseUserInfoService.getDataPermissionsByUserId((String) paramMap.get("id"));
		return ResultUtil.getSuccessResult(result);
	}

	/**
	 * 获取机构线路树
	 * 
	 * @param id
	 * @return
	 */
	@PostMapping("/getOrgLineAuths")
	public Result getOrgLineAuths(@RequestBody Map<String, Object> paramMap) {
		List<TreeNode2> result = baseUserInfoService.getLineAuthsByOrgUuid((String) paramMap.get("orgUuid"));
		return ResultUtil.getSuccessResult(result);
	}

	/**
	 * 绑定用户角色
	 * 
	 * @param baseUserRoleVo
	 * @return
	 */
	@PostMapping("/correlationRoles")
	public Result correlationRoles(@RequestBody BaseUserRoleVo baseUserRoleVo) {
		String[] roleIds = new String[baseUserRoleVo.getRoleIds().size()];
		baseUserRoleVo.getRoleIds().toArray(roleIds);
		try {
			baseUserInfoService.correlationRoles(baseUserRoleVo.getUserId(), roleIds);
			return ResultUtil.getSuccessResult();
		} catch (Exception ex) {
			return ResultUtil.getFailResult();
		}
	}

	/**
	 * 解绑用户角色
	 * 
	 * @param baseUserRoleVo
	 * @return
	 */
	@PostMapping("/uncorrelationRoles")
	public Result uncorrelationRoles(@RequestBody BaseUserRoleVo baseUserRoleVo) {
		String[] roleIds = new String[baseUserRoleVo.getRoleIds().size()];
		baseUserRoleVo.getRoleIds().toArray(roleIds);
		try {
			baseUserInfoService.uncorrelationRoles(baseUserRoleVo.getUserId(), roleIds);
			return ResultUtil.getSuccessResult();
		} catch (Exception ex) {
			return ResultUtil.getFailResult();
		}
	}
}
