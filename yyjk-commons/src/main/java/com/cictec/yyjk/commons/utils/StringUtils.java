package com.cictec.yyjk.commons.utils;

import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringEscapeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * 字符串工具类, 继承org.apache.commons.lang3.StringUtils类
 * 
 * @author ThinkGem
 * @version 2013-05-22
 */
public class StringUtils extends org.apache.commons.lang3.StringUtils {
	private static final Logger LOG = LoggerFactory.getLogger(StringUtils.class);
	
	public static String lowerFirst(String str){
		if(StringUtils.isBlank(str)) {
			return "";
		} else {
			return str.substring(0,1).toLowerCase() + str.substring(1);
		}
	}
	
	public static String upperFirst(String str){
		if(StringUtils.isBlank(str)) {
			return "";
		} else {
			return str.substring(0,1).toUpperCase() + str.substring(1);
		}
	}

	/**
	 * 替换掉HTML标签方法
	 */
	public static String replaceHtml(String html) {
		if (isBlank(html)){
			return "";
		}
		String regEx = "<.+?>";
		Pattern p = Pattern.compile(regEx);
		Matcher m = p.matcher(html);
		String s = m.replaceAll("");
		return s;
	}

	/**
	 * 缩略字符串（不区分中英文字符）
	 * 
	 * @param str
	 *            目标字符串
	 * @param length
	 *            截取长度
	 * @return
	 */
	public static String abbr(String str, int length) {
		if (str == null) {
			return "";
		}
		try {
			StringBuilder sb = new StringBuilder();
			int currentLength = 0;
			for (char c : replaceHtml(StringEscapeUtils.unescapeHtml4(str)).toCharArray()) {
				currentLength += String.valueOf(c).getBytes("GBK").length;
				if (currentLength <= length - 3) {
					sb.append(c);
				} else {
					sb.append("...");
					break;
				}
			}
			return sb.toString();
		} catch (UnsupportedEncodingException e) {
			LOG.error("缩略字符串失败，原因{}", e);
		}
		return "";
	}

	/**
	 * 缩略字符串（替换html）
	 * 
	 * @param str
	 *            目标字符串
	 * @param length
	 *            截取长度
	 * @return
	 */
	public static String rabbr(String str, int length) {
        return abbr(replaceHtml(str), length);
	}
		
	
	/**
	 * 转换为Double类型
	 */
	public static Double toDouble(Object val){
		if (val == null){
			return 0D;
		}
		try {
			return Double.valueOf(trim(val.toString()));
		} catch (Exception e) {
			return 0D;
		}
	}

	/**
	 * 转换为Float类型
	 */
	public static Float toFloat(Object val){
		return toDouble(val).floatValue();
	}

	/**
	 * 转换为Long类型
	 */
	public static Long toLong(Object val){
		return toDouble(val).longValue();
	}

	/**
	 * 转换为Integer类型
	 */
	public static Integer toInteger(Object val){
		return toLong(val).intValue();
	}
	
	public static String StringArrtoStr(String[] ary){
	
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < ary.length; i++){
		 sb. append(ary[i]);
		}
     return sb.toString();
	}
	
	
	public static String charArrtoStr(char[] ary){
		
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < ary.length; i++){
		 sb. append(ary[i]);
		}
     return sb.toString();
	}
    
	/**
	 * 给字符串加上引号 如：[1,2，3] -->'1','2'
	 *
	 * @param
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static String likeNumber2String(Set set) {
	        StringBuffer sb = new StringBuffer();
	        Iterator<String> it = set.iterator();  
	        while (it.hasNext()) {  
	          String str = it.next();  
		          if (sb.length() != 0) {
	                  sb.append("," + "'" + str + "'");
	              }
		          if (sb.length() == 0) {
		              sb.append("'" + str + "'");
		          }
	        }  
	        System.out.println(sb);
	        return sb.toString();
	    }

	   /**
	 * 使用java正则表达式去掉多余的.与0
	 * 
	 * @param s
	 * @return
	 */    
	    public static String subZeroAndDot(String s){    
	        if(s.indexOf(".") > 0){    
	          s =  s.substring(0, s.indexOf("."));
	        }    
	       
	        return s;    
	    } 

		/**
	 * 换行符javajava去除字符串中的空格、回车、换行符、制表符
	 * 
	 * @param
	 * @return
	 */
		public static String replaceBlank(String str) {
			if(StringUtils.isEmpty(str)){
				return "";
			}
			str = str.replaceAll(" ", "");
			str = str.replaceAll("	", "");
			str = str.replaceAll("\\s", "");
			str = str.replaceAll("\n", "");
			str = str.replaceAll("\t", "");
			str = str.replaceAll("\r", "");
			str = str.replaceAll("\r\n", "");
			return str;
		}

	public static String replaceBlankReg(String str) {
		String dest = "";
		if (str != null) {
			Pattern p = Pattern.compile("\\s*|\t|\r|\n");
			Matcher m = p.matcher(str);
			dest = m.replaceAll("");
		}
		return dest;
	}

	/**
	 * 手机号码校验
	 * 
	 * @param phoneNumber
	 * @return
	 */
	public static boolean cellPhoneNumberCheck(String phoneNumber){
		boolean flag = false;

		Pattern p = Pattern
				.compile("^((1[0-9][0-9]))\\d{8}$");
		Matcher m = p.matcher(phoneNumber);
		flag = m.matches();
		return flag;
	}

	   public static void main(String[] args) {
		    
		System.out.println(subZeroAndDot("1"));
		; // 转换后为1
		System.out.println(subZeroAndDot("10"));
		; // 转换后为10
		System.out.println(subZeroAndDot("1.0"));
		; // 转换后为1
		System.out.println(subZeroAndDot("1.010"));
		; // 转换后为1.01
		System.out.println(subZeroAndDot("1.01"));
		; // 转换后为1.01
	}

}
