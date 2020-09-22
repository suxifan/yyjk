package com.cictec.yyjk.base.api;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cictec.yyjk.base.interceptors.AccessLogInfo;
import com.cictec.yyjk.base.model.entity.BaseRoleInfo;
import com.cictec.yyjk.base.model.entity.BaseUserInfo;
import com.cictec.yyjk.base.model.vo.BaseRoleInfoVo;
import com.cictec.yyjk.base.model.vo.BaseRoleResourceVo;
import com.cictec.yyjk.base.service.BaseRoleInfoService;
import com.cictec.yyjk.commons.core.Result;
import com.cictec.yyjk.commons.core.ResultUtil;
import com.cictec.yyjk.commons.utils.PMSUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * Created by xpguo on 2019/05/28.
 */
@RestController
@RequestMapping("/api/base/role")
public class ApiBaseRoleInfo extends BaseController {
	private static final Logger LOG = LoggerFactory.getLogger(ApiBaseRoleInfo.class);
	@Resource
	private BaseRoleInfoService baseRoleInfoService;

	@PostMapping("/add")
	public Result add(@RequestBody BaseRoleInfo baseRoleInfo, HttpServletRequest request) {
		baseRoleInfo.setCreateUser(getUserIdByToken(request).getUserAccount());
		// BaseRoleInfo result = baseRoleInfoService.selectOneBy("roleName",
		// baseRoleInfo.getRoleName());
		// if (result != null) {
		// return ResultUtil.getErrorResult("该角色已存在！");
		// }
		try {
			baseRoleInfoService.insertSelective(baseRoleInfo);
			return ResultUtil.getSuccessResult();
		} catch (Exception ex) {
			LOG.error("新增角色失败，原因{}", ex);
			return ResultUtil.getErrorResult("新增角色失败");
		}
	}

	@PostMapping("/delete")
	public Result delete(@RequestBody Map<String, Object> paramMap) {
		String roleId = PMSUtils.isNull(paramMap.get("id"));
		List<BaseUserInfo> result = baseRoleInfoService.deleteRole(roleId);
		if (result == null || (result != null && result.size() == 0)) {
			return ResultUtil.getSuccessResult();
		} else {
			StringBuilder names = new StringBuilder();
			Iterator<BaseUserInfo> iterator = result.iterator();
			names.append(iterator.next().getUserRealName());
			while (iterator.hasNext()) {
				names.append(",").append(iterator.next().getUserRealName());
			}
			return ResultUtil.getErrorResult(names.toString());
		}
	}

	@PostMapping("/update")
	public Result update(@RequestBody BaseRoleInfo baseRoleInfo, HttpServletRequest request) {
		baseRoleInfo.setUpdateUser(getUserIdByToken(request).getUserAccount());
		baseRoleInfo.setUpdateTime(new Date());
		try {
			baseRoleInfoService.updateByPrimaryKeySelective(baseRoleInfo);
			return ResultUtil.getSuccessResult();
		} catch (Exception ex) {
			LOG.error("修改角色失败，原因{}", ex);
			return ResultUtil.getErrorResult("修改角色失败");
		}
	}

	@PostMapping("/detail")
	public Result detail(@RequestBody Map<String, Object> paramMap) {
		String id = PMSUtils.isNull(paramMap.get("id"));
		BaseRoleInfo baseRoleInfo = baseRoleInfoService.selectByPrimaryKey(id);
		return ResultUtil.getSuccessResult(baseRoleInfo);
	}

	@AccessLogInfo(modelName = "权限管理", pageName = "角色列表")
	@PostMapping("/list")
	public Result list(@RequestBody BaseRoleInfoVo baseRoleInfoVo, HttpServletRequest request) {
		String userAccount = getUserIdByToken(request).getUserAccount();
		baseRoleInfoVo.setTokenUserAccount(userAccount);
		// 判定是否包含分页参数，如果包含则为分页数据请求
		if (baseRoleInfoVo.getPageSize() != null && baseRoleInfoVo.getPageSize() != 0) {
			return pageList(baseRoleInfoVo);
		}
		// 根据具体业务重写
		List<BaseRoleInfo> list = baseRoleInfoService.getRoleInfoByVo(baseRoleInfoVo);

		return ResultUtil.getSuccessResult(list);
	}

	@PostMapping("/pageList")
	public Result pageList(@RequestBody BaseRoleInfoVo baseRoleInfoVo) {
		// 分页数据请求处理
		PageHelper.startPage(baseRoleInfoVo.getPageNumber(), baseRoleInfoVo.getPageSize());
		// 根据具体业务重写
		List<BaseRoleInfo> list = baseRoleInfoService.getRoleInfoByVo(baseRoleInfoVo);
		return ResultUtil.getSuccessResult(new PageInfo<BaseRoleInfo>(list));
	}

	/**
	 * 绑定角色权限
	 * 
	 * @param baseRoleResourceVo
	 * @return
	 */
	@PostMapping("/correlationPermissions")
	public Result correlationPermissions(@RequestBody BaseRoleResourceVo baseRoleResourceVo) {
		String[] resourceIds = new String[baseRoleResourceVo.getResourceIds().size()];
		baseRoleResourceVo.getResourceIds().toArray(resourceIds);
		try {
			baseRoleInfoService.correlationPermissions(baseRoleResourceVo.getRoleId(), resourceIds);
			return ResultUtil.getSuccessResult();
		} catch (Exception ex) {
			LOG.error("绑定角色权限失败，原因{}", ex);
			return ResultUtil.getFailResult();
		}
	}

	/**
	 * 绑定角色数据权限
	 * 
	 * @param baseRoleResourceVo
	 * @return
	 */
	@PostMapping("/correlationDataPermissions")
	public Result correlationDataPermissions(@RequestBody BaseRoleResourceVo baseRoleResourceVo) {
		String[] resourceIds = new String[baseRoleResourceVo.getResourceIds().size()];
		baseRoleResourceVo.getResourceIds().toArray(resourceIds);
		try {
			baseRoleInfoService.correlationDataPermissions(baseRoleResourceVo.getRoleId(), resourceIds);
			return ResultUtil.getSuccessResult();
		} catch (Exception ex) {
			LOG.error("绑定角色数据权限失败，原因{}", ex);
			return ResultUtil.getFailResult();
		}
	}

	/**
	 * 绑定线路数据权限
	 * 
	 * @param baseRoleResourceVo
	 * @return
	 */
	@PostMapping("/correlationLinePermissions")
	public Result correlationLinePermissions(@RequestBody BaseRoleResourceVo baseRoleResourceVo) {
		String[] resourceIds = new String[baseRoleResourceVo.getResourceIds().size()];
		baseRoleResourceVo.getResourceIds().toArray(resourceIds);
		try {
			baseRoleInfoService.correlationLinePermissions(baseRoleResourceVo.getRoleId(), resourceIds);
			return ResultUtil.getSuccessResult();
		} catch (Exception ex) {
			LOG.error("绑定线路数据权限失败，原因{}", ex);
			return ResultUtil.getFailResult();
		}
	}

	/**
	 * 解绑角色权限
	 * 
	 * @param baseRoleResourceVo
	 * @return
	 */
	@PostMapping("/uncorrelationPermissions")
	public Result uncorrelationPermissions(@RequestBody BaseRoleResourceVo baseRoleResourceVo) {
		String[] resourceIds = new String[baseRoleResourceVo.getResourceIds().size()];
		baseRoleResourceVo.getResourceIds().toArray(resourceIds);
		try {
			baseRoleInfoService.uncorrelationPermissions(baseRoleResourceVo.getRoleId(), resourceIds);
			return ResultUtil.getSuccessResult();
		} catch (Exception ex) {
			return ResultUtil.getFailResult();
		}
	}
}
