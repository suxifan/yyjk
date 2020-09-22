package com.cictec.yyjk.commons.utils;


import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.helpers.FormattingTuple;
import org.slf4j.helpers.MessageFormatter;

@SuppressWarnings("rawtypes")
public class PMSUtils {
	
	
	/**
	 * 返回空字符串
	 * 
	 * @param str
	 * @return
	 * 
	 */
	public static String isNull(Object str) {
		if (isEmpty(String.valueOf(str))) {
			return "";
		} else {
			return String.valueOf(str);
		}
	}

	/**
	 * 判定对象不为空
	 * @param obj
	 * @return
	 */
	public static boolean isNotEmpty(Object obj){
		return !isEmpty(obj);
	}
	
	/**
	 * 判断对象是否为空
	 * 
	 * @param obj
	 * @return 空 true 非空 false
	 */
	public static boolean isEmpty(Object obj) {
		if(null == obj){
			return true;
		}
		
		if(obj instanceof String){
			if (StringUtils.isNotBlank((CharSequence) obj) && !"null".equals(obj) && !"undefined".equals(obj)) {
				return false;
			}
		}else if(obj instanceof Map){
			if(((Map) obj).size() > 0){
				return false;
			}
		}else if(obj instanceof List){
			if(((List) obj).size() > 0){
				return false;
			}
		}else if(obj instanceof Long){
			return false;
		}else if(obj instanceof Integer){
			return false;
		}else if(obj instanceof Date){
			return false;
		}
		return true;
	}
	
	/**
	 * 【正则】判定字符串是否是浮点类型字符串
	 * @param str
	 * @return
	 */
	public static boolean isDouble(String str) {  
	    if (null == str || "".equals(str)) {  
	        return false;  
	    }  
	    Pattern pattern = Pattern.compile("^[-\\+]?[.\\d]*$");  
	    return pattern.matcher(str).matches();  
	}  
	
	/**
	 * 将字符串 转换成double 为空 转换成 0.0
	 * @param obj
	 * @return
	 */
	public static Double parseDouble(Object obj){
		if (isEmpty(String.valueOf(obj))) {
			return 0.0;
		} else {
			return Double.parseDouble(String.valueOf(obj));
		}
	}
	
	
	/**
	 * 将字符串 转换成Integer 为空 转换成 0
	 * @param obj
	 * @return
	 */
	public static Integer parseInteger(Object obj){
		if (isEmpty(String.valueOf(obj))) {
			return 0;
		} else {
			try {
				return Integer.parseInt(String.valueOf(obj));
			} catch (Exception e) {
				// TODO: handle exception
				return 0;
			}
		}
	}
	
	/**
	 * 获得一个UUID【生成20字节的UUID字符串,不含'-'字符. TODO 未追加jvmId,ip和mac信息,需要完善】
	 * 
	 * @return String UUID
	 */
	public static String getUUID() {
		/*
		String s = UUID.randomUUID().toString();
		// 去掉“-”符号
		return s.substring(0, 8) + s.substring(9, 13) + s.substring(14, 18)
				+ s.substring(19, 23) + s.substring(24);
		 */
		return UUIDGenerator.genUuidStr();
	}

	/**
	 * 获得指定数目的UUID
	 * 
	 * @param number
	 *            int 需要获得的UUID数量
	 * @return String[] UUID数组
	 */
	public static String[] getUUID(int number) {
		if (number < 1) {
			return null;
		}
		String[] ss = new String[number];
		for (int i = 0; i < number; i++) {
			ss[i] = getUUID();
		}
		return ss;
	}
	
	/**
	 * 生成随机字符串(包括 字母、数字)
	 * @param length 字符串长度
	 * @return
	 */
	public static String getRandomStr(int length) {
		String str = "";
		String source = "0,1,2,3,4,5,6,7,8,9,a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z";
		String[] s = source.split(",");
		for (int i = 0; i < length; i++) {
			int rand = (int) (Math.random() * 35);
			str += s[rand];
		}
		return str;
	}
	
	/**
	 * 生成随机字符串(纯数字) 
	 * @param length	字符串长度
	 * @return
	 */
	public static String getRandomCode(int length) {
		Random random = new Random();
		String sRand = "";
		for (int i = 0; i < 6; i++) {
			String rand = String.valueOf(random.nextInt(10));
			sRand += rand;
		}
		return sRand;
	}

	/**
	 * 去除字符串开头和结尾的空格
	 * 
	 * @param str
	 * @return
	 */
	public static String trim(String str) {
		if (str.charAt(0) == ' ') {
			str = str.substring(1, str.length());
		}
		if (str.charAt(str.length() - 1) == ' ') {
			str = str.substring(0, str.length() - 1);
		}
		if (str.charAt(0) == ' ' || str.charAt(str.length() - 1) == ' ') {
			str = PMSUtils.trim(str);
		}

		return str;
	}

	

	/**
	 * 数字型字符串 流水号 自增
	 * @param liuShuiHao  例如 传入 '0001' 输出: '0002'
	 * @return
	 */
	public static String getSequenceNum(String liuShuiHao){
	    Integer intHao = Integer.parseInt(liuShuiHao);
	    intHao++;
	    String strHao = intHao.toString();
	    while (strHao.length() < liuShuiHao.length()){
	    	strHao = "0" + strHao;
	    }
	    return strHao;
	}
	
	
	
	/**
	 * 字符串【右侧】补0
	 * @param str		原始字符串
	 * @param strLength	目标字符串长度
	 * @return
	 */
	public static String addZeroRForString(String str, int strLength) {
		return addZeroForString(str, strLength, "R");
	}
	
	/**
	 * 字符串【左侧】补0
	 * @param str		原始字符串
	 * @param strLength	目标字符串长度
	 * @return
	 */
	public static String addZeroLForString(String str, int strLength) {
		return addZeroForString(str, strLength, "L");
	}
	
	/**
	 * 字符串补0，长度不够时候补0
	 * @param str		原始字符串
	 * @param strLength	目标字符串长度
	 * @param lOrR	“L”时候左侧补0，“R”时候右侧补0
	 * @return
	 */
	public static String addZeroForString(String str, int strLength, String lOrR) {
		int strLen = str.length();
		StringBuffer sb = new StringBuffer(str);
		while (strLen < strLength) {
			if(lOrR.equals("R")){
				sb.append("0");
			}else{
				sb.insert(0, "0");
			}
			str = sb.toString();
			strLen = str.length();
		}
		return str;
	}
	
	/**
	 * 首字母转小写 
	 * @param str
	 * @return
	 */
	public static String toLowerCaseFirstOne(String str) {
		if (Character.isLowerCase(str.charAt(0)))
			return str;
		else
			return (new StringBuilder()).append(Character.toLowerCase(str.charAt(0))).append(str.substring(1)).toString();
	}

	/**
	 * 首字母转大写
	 * @param strs
	 * @return
	 */
	public static String toUpperCaseFirstOne(String strs) {
		if (Character.isUpperCase(strs.charAt(0)))
			return strs;
		else
			return (new StringBuilder()).append(Character.toUpperCase(strs.charAt(0))).append(strs.substring(1)).toString();
	}
	

	
	/**
	 * 正则匹配字符串内容  以 'prefix'为开始， 'suffix'为结尾 的内容
	 	<li> (?=exp) 	匹配exp前面的位置 
		<li> (?<=exp) 	匹配exp后面的位置 
		<li> (?!exp) 	匹配后面跟的不是exp的位置 
		<li> (?< !exp) 	匹配前面不是exp的位置
		<li> 例如： '你好${userName},你的工号是${userNo}！！' --> [userName, userNo]
	 * @param prefix	要截取的字符串前缀
	 * @param suffix	截取字符串的后缀
	 * @param str		待截取字符串
	 * @return
	 * 
	 */
	public static List<String> getSubstringByRegular(String prefix, String suffix, String str){
		char[] pre = prefix.toCharArray();
		char[] suff = suffix.toCharArray();
		String ppre = null;
		for (char c : pre) {
			if(ppre == null){
				ppre = "";
			}
			ppre += "\\"+c;
		}
		String ssuff = null;
		for (char c : suff) {
			if(ssuff == null){
				ssuff = "";
			}
			ssuff += "\\"+c;
		}
		
        List<String> ls=new ArrayList<String>();
        Pattern pattern = Pattern.compile("(?<="+ppre+")(.+?)(?="+ssuff+")");
        Matcher matcher = pattern.matcher(str);
        while(matcher.find())
            ls.add(matcher.group());
        return ls;
    }
	
	/**
	 * 分页截取数据对象
	 * @param list
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public static List subListPage(List list, int pageNum, int pageSize){
		int fromIndex = (pageNum - 1) * pageSize;
        if (fromIndex >= list.size()) {
            return Collections.emptyList();
        }
 
        int toIndex = pageNum * pageSize;
        if (toIndex >= list.size()) {
            toIndex = list.size();
        }
        return list.subList(fromIndex, toIndex);
	}
	
	/**
	 * 获取分页
	 * @param totals
	 * @param PageSize
	 */
	public static int pages(int totals, int pageSize){
		if(pageSize == 0){
			pageSize = 1;
		}
		int pages = totals % pageSize == 0 ? totals / pageSize : totals / pageSize + 1;
		return pages;
	}
	
	/**
	 * 格式化字符串输出，类似self4j(也是借用self4j的实现)
	 * @param format
	 * @param arguments
	 * @return
	 */
	public static String format(String format, Object... arguments) {
		FormattingTuple ft = MessageFormatter.arrayFormat(format, arguments);
		return ft.getMessage();
	}

	public static void main(String[] args) {
		System.out.println( getSubstringByRegular("${", "}","你好${userName},你的工号是${userNo}"));
		System.out.println( getSubstringByRegular("#{", "}","你好#{userName},你的工号是#{userNo}"));
		
		/*Map<String, Long> m = new TreeMap<String, Long>();
		for (long i = 10000L; i < 99999L; i++) {
			String code = String.valueOf(i);
			String key = String.valueOf(code.hashCode() % 20);
			if (key.length() >= 2)
				key = key.substring(0, 2);
			else {
				while (key.length() < 2) {
					key = new StringBuffer("0").append(key).toString();
				}
			}
			if (m.containsKey(key)) {
				long value = m.get(key);
				m.put(key, value + 1);
			} else {
				m.put(key, 1L);
			}
			System.out.println(key);
		}
		System.out.println(m.toString());*/
	}
	 public static String formatDouble3(double d) {
	        NumberFormat nf = NumberFormat.getNumberInstance();
	        

	        // 保留两位小数
	        nf.setMaximumFractionDigits(2); 

	        
	        // 如果不需要四舍五入，可以使用RoundingMode.DOWN
	        nf.setRoundingMode(RoundingMode.UP);

	        
	        return nf.format(d);
	    }
}

