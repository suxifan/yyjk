package com.cictec.yyjk.commons.core;

/**
 * 响应码枚举，参考HTTP状态码的语义
 * 
 * @author Administrator
 *
 */
public class ResultCode {
	
	/** 成功 200 */
	public static final String SUCCESS = "200";
	/** 失败 400 */
	public static final String FAIL = "400";
	/** 未认证（签名错误） 401 */
	public static final String UNAUTHORIZED = "401";
	/** 接口不存在 404 */
	public static final String NOT_FOUND = "404";
	/** 服务器内部错误 500 */
	public static final String INTERNAL_SERVER_ERROR = "500";

}