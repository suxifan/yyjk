package com.cictec.yyjk.base.api;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RestController;

import com.auth0.jwt.interfaces.Claim;
import com.cictec.yyjk.base.model.entity.BaseDataResourceInfo;
import com.cictec.yyjk.base.model.entity.BaseUserInfo;
import com.cictec.yyjk.base.service.BaseUserInfoService;
import com.cictec.yyjk.commons.core.Constants;
import com.cictec.yyjk.commons.utils.JwtToken;
import com.github.pagehelper.util.StringUtil;

@RestController
public class BaseController {
	@Autowired
	private BaseUserInfoService baseUserInfoService;
	
	/**
	 * jwt 根据token获取用户信息
	 * 
	 * @param request
	 * @return
	 */
	public BaseUserInfo getUserIdByToken(HttpServletRequest request) {
		String token = request.getHeader("authorization");
		Map<String, Claim> claim = null;
		try {
			claim = JwtToken.verifyToken(token);
		} catch (Exception e) {

		}
		BaseUserInfo baseUserInfo = new BaseUserInfo();
		if (null != claim) {
			baseUserInfo.setUserId(claim.get(Constants.USERID).asString());
			baseUserInfo.setUserAccount(claim.get(Constants.USERNAME).asString());
		}
		return baseUserInfo;
	}

	/**
	 * 下载文件
	 * 
	 * @param file
	 * @throws IOException
	 */
	protected void download(File file, String fileName, HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		if (StringUtil.isEmpty(fileName)) {
			fileName = file.getName();
		}
		response.setContentType("application/octet-stream;charset=UTF-8");
		response.setHeader("Content-Length", String.valueOf(file.length()));
		response.setHeader("Content-disposition",
				"attachment; filename=" + new String(fileName.getBytes("gbk"), "ISO8859-1"));
		FileCopyUtils.copy(FileCopyUtils.copyToByteArray(file), response.getOutputStream());
	}

	public boolean hasDataAuthority(BaseUserInfo userInfo) {
		List<BaseDataResourceInfo> dataAuths = baseUserInfoService.getDataAuthByUserId(userInfo.getUserId());
		if (CollectionUtils.isNotEmpty(dataAuths)) {
			return true;
		} else {
			return false;
		}
	}
}
