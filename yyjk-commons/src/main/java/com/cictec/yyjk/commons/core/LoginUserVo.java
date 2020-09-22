package com.cictec.yyjk.commons.core;

import java.util.Map;

import com.auth0.jwt.interfaces.Claim;
import com.cictec.yyjk.commons.utils.JwtToken;
import com.cictec.yyjk.commons.utils.StringUtils;


/**
 * <p>
 * Description: 登录信息
 * </p>
 * <p>
 * Title: LoginUserVo.java
 * </p>
 * 
 * @author Rwq
 */
public class LoginUserVo {
	/**
	 * 得到用户Id
	 * 
	 * @param token
	 * @return
	 * @throws Exception
	 */
	public static String getUserId(String token) throws Exception{
		if(StringUtils.isEmpty(token)){
			return "";
		}
		Map<String,Claim> claim = JwtToken.verifyToken(token);
		String userId = claim.get(Constants.USERID).asString();
		return userId;
	}
	
	/**
	 * 得到用户名称
	 * 
	 * @param token
	 * @return
	 * @throws Exception
	 */
	public static String getUserName(String token) throws Exception{
		if(StringUtils.isEmpty(token)){
			return "";
		}
		Map<String,Claim> claim = JwtToken.verifyToken(token);
		String userName = claim.get(Constants.USERNAME).asString();
		return userName;
	}
	
	/**
	 * 得到用户权限ids
	 * 
	 * @param token
	 * @return
	 * @throws Exception
	 */
	public static String getRoleIds(String token) throws Exception{
		if(StringUtils.isEmpty(token)){
			return "";
		}
		Map<String,Claim> claim = JwtToken.verifyToken(token);
		String roleIds = claim.get(Constants.ROLEIDS).asString();
		return roleIds;
	}
	
	
}
