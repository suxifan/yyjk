package com.cictec.yyjk.base.utils;

public class ExcelConstants {
	public static String XLS_NAME;
	public static int XLS_STARTROW;
	
	public final static String ERR_CODE_NULL = "0001" ;
	public final static String ERR_MSG_DEV_NULL = "设备编号为空或该列未对应至设备编号,已跳过！";
	public final static String ERR_MSG_DEV_CLASS_NULL = "设备类别为空或该列未对应至设备类别,已跳过！";
	public final static String ERR_MSG_BUS_NULL = "车牌号为空或该列未对应至车牌号,已跳过！";
	public static final String ERR_MSG_BUSCODE_NULL = "车辆自编号为空或该列未对应至车辆自编号,已跳过！";
	public final static String ERR_MSG_ORG_NULL = "所属机构为空或该列未对应至所属机构,可以通过系统修改该记录！";
	public final static String ERR_MSG_LINE_NULL = "所属线路为空或该列未对应至所属线路,可以通过系统修改该记录！";
	
	public final static String ERR_CODE_DUPLICATE = "0002" ;
	public final static String ERR_MSG_DEV_DUPLICATE = "设备编号已存在,已跳过！";
	public final static String ERR_MSG_BUS_DEV_DUPLICATE = "车辆信息中,设备编号已存在,已跳过！";
	public final static String ERR_MSG_BUS_DUPLICATE = "该车牌号已存在,已跳过！";
	public final static String ERR_MSG_BUS_LINE_DUPLICATE = "该线路已存在,已跳过！";
	
	public final static String ERR_CODE_BIND = "0003";
	public final static String ERR_MSG_BUS_CONDITION = "根据给定的机构、线路、车牌号和自编号信息,查询不到车辆记录！";
	public final static String ERR_MSG_DEVICE_CONDITION = "根据给定的设备编码和设备类型信息,查询不到设备记录！";
	
	public static final String ERR_CODE_SIM = "0004";
	public static final String ERR_MSG_SIM = "SIM卡号只能为数字,可以通过系统修改该记录！";
}
