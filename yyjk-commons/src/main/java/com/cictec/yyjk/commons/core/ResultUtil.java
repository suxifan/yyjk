package com.cictec.yyjk.commons.core;

import java.util.Map;

import org.slf4j.helpers.FormattingTuple;
import org.slf4j.helpers.MessageFormatter;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;

/**
 * 响应结果生成工具
 * 
 * @author Administrator
 *
 */
@SuppressWarnings("rawtypes")
public class ResultUtil {
	private static final String DEFAULT_SUCCESS_MESSAGE = "成功";
	private static final String DEFAULT_FAIL_MESSAGE = "失败";
	private static final String DEFAULT_ERROR_MESSAGE = "服务器内部错误";
	
	// 下边的没意思
	private static final String SUCCESS = "true";
	private static final String FALSE = "false";
	

	public static Result getSuccessResult() {
		Head head = new Head(ResultCode.SUCCESS, DEFAULT_SUCCESS_MESSAGE, SUCCESS);
		return new Result().setCode(ResultCode.SUCCESS).setMessage(DEFAULT_SUCCESS_MESSAGE).setHead(head);
	}

	public static Result getSuccessResult(Object data) {
		return getSuccessResult(DEFAULT_SUCCESS_MESSAGE, data);
	}

	public static Result getSuccessResult(String message, Object data) {
		Result result = new Result().setCode(ResultCode.SUCCESS).setMessage(message);

		Head head = new Head(ResultCode.SUCCESS, message, SUCCESS);
		result.setHead(head);
		/*
		 * 返回信息结果集合,如果是集合默认key值为'list' {'list' : list集合}
		 */
		result = getResultData(result, data);
		return result;
	}

	/**
	 * 失败 错误码 400
	 * 
	 * @return
	 */
	public static Result getFailResult() {
		return getFailResult(DEFAULT_FAIL_MESSAGE);
	}

	/**
	 * 失败 错误码 400
	 * 
	 * @param message
	 * @return
	 */
	public static Result getFailResult(String message) {
//		return new Result().setCode(ResultCode.FAIL).setMessage(message);
		
		Head head = new Head(ResultCode.FAIL, message, FALSE);
		return new Result().setCode(ResultCode.FAIL).setMessage(message).setHead(head);
	}

	/**
	 * 服务器内部错误 错误码 400
	 * 
	 * @param
	 * @return
	 */
	public static Result getErrorResult() {
//		return new Result().setCode(ResultCode.INTERNAL_SERVER_ERROR).setMessage(DEFAULT_ERROR_MESSAGE);
		
		Head head = new Head(ResultCode.INTERNAL_SERVER_ERROR, DEFAULT_ERROR_MESSAGE, FALSE);
		return new Result().setCode(ResultCode.INTERNAL_SERVER_ERROR).setMessage(DEFAULT_ERROR_MESSAGE).setHead(head);
	}

	/**
	 * 服务器内部错误 错误码 400
	 * 
	 * @param message
	 * @return
	 */
	public static Result getErrorResult(String message) {
//		return new Result().setCode(ResultCode.INTERNAL_SERVER_ERROR).setMessage(message);
		
		Head head = new Head(ResultCode.INTERNAL_SERVER_ERROR, message, FALSE);
		return new Result().setCode(ResultCode.INTERNAL_SERVER_ERROR).setMessage(message).setHead(head);
	}

	/**
	 * 服务器内部错误 错误码 400
	 * @param format	格式化输出消息，类似self4j
	 * @param arguments
	 * @return
	 */
	public static Result getErrorResult(String format, Object... arguments) {
		FormattingTuple ft = MessageFormatter.arrayFormat(format, arguments);
		String msg = ft.getMessage();
//		return new Result().setCode(ResultCode.INTERNAL_SERVER_ERROR).setMessage(msg);

		Head head = new Head(ResultCode.INTERNAL_SERVER_ERROR, msg, FALSE);
		return new Result().setCode(ResultCode.INTERNAL_SERVER_ERROR).setMessage(msg).setHead(head);
	}

	/**
	 * 服务器内部错误 错误码 400
	 * @param format	格式化输出消息，类似self4j
	 * @param arguments
	 * @return
	 */
	public static Result getErrorResult(String errorCode, String format, Object... arguments) {
		FormattingTuple ft = MessageFormatter.arrayFormat(format, arguments);
		String msg = ft.getMessage();
		
//		return new Result().setCode(errorCode).setMessage(msg);
		
		Head head = new Head(errorCode, msg, FALSE);
		return new Result().setCode(errorCode).setMessage(msg).setHead(head);
	}

	// public static void main(String[] args) {
	// List list = new ArrayList();
	// list.add("abc");
	//
	// PageInfo page = new PageInfo();
	// page.setTotal(100);
	// page.setList(list);
	// Result result = getSuccessResult();
	// result = getSuccessResult(list);
	// result = getSuccessResult(page);
	// System.out.println(JSON.toJSONString(result));
	// System.out.println(result);
	// }

	/**
	 * 判定返回结果是否成功
	 * 
	 * @param result
	 * @return
	 */
	public static boolean isSuccess(Result result) {
		if (ResultCode.SUCCESS.equals(result.getCode())) {
			return true;
		}

		return false;
	}

	/**
	 * 请求成功返回信息结果集合,如果是集合默认key值为'list' {'list' : list集合}
	 * 
	 * @param result
	 * @param
	 * @param
	 * @return
	 */
	private static Result getResultData(Result result, Object objectData) {
		if (objectData == null) {
			return result;
		}

		if (objectData instanceof PageInfo) {
			pagehandler(result, (PageInfo) objectData);
		} else if (objectData instanceof JSONObject) {
			// 实体对象都继承自JSONObject，而JSONObject 实现了map接口，所以能这么写
			result.put("data", (Map) objectData);
		} else {
			result.put("data", objectData);
		}

		return result;
	}

	private static void pagehandler(Result result, PageInfo page) {

//		result.put("total", page.getTotal()); // 重新定义分页数据key
//		result.put("rows", page.getList()); // easyui 分页数据
		result.put("data", page);

	}

}