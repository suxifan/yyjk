package com.cictec.yyjk.commons.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * 日期工具类, 继承org.apache.commons.lang.time.DateUtils类
 */
public class DateUtils extends org.apache.commons.lang3.time.DateUtils {
	private static final Logger LOG = LoggerFactory.getLogger(DateUtils.class);
	public static final String YEAR = "year";

	public static final String MONTH = "month";

	public static final String DAY = "day";

	public static final String WEEK = "week";
	
	public static final String MINUTE = "minute";
	
	

	public static final String[] dayNames = { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" };

	private static final int[] days = { 7, 1, 2, 3, 4, 5, 6 };


	private static String[] parsePatterns = { "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", "yyyy/MM/dd",
			"yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm" };

	/**
	 * 得到当前日期字符串 格式（yyyy-MM-dd）
	 */
	public static String getDate() {
		return getDate("yyyy-MM-dd");
	}

	/**
	 * 得到当前日期字符串 格式（yyyy-MM-dd） pattern可以为："yyyy-MM-dd" "HH:mm:ss" "E"
	 */
	public static String getDate(String pattern) {
		return DateFormatUtils.format(new Date(), pattern);
	}

	/**
	 * 得到日期字符串 默认格式（yyyy-MM-dd） pattern可以为："yyyy-MM-dd" "HH:mm:ss" "E"
	 * 
	 * @param date
	 * @param pattern
	 *            自定义格式【默认yyyy-MM-dd】
	 * @return
	 */
	public static String formatDate(Date date, Object... pattern) {
		if(date == null){
			return "";
		}
		
		String formatDate = null;
		if (pattern != null && pattern.length > 0) {
			formatDate = DateFormatUtils.format(date, pattern[0].toString());
		} else {
			formatDate = DateFormatUtils.format(date, "yyyy-MM-dd");
		}
		return formatDate;
	}

	/**
	 * 得到日期时间字符串，转换格式（yyyy-MM-dd HH:mm）
	 */
	public static String formatDateTimeMinute(Date date) {
		return formatDate(date, "yyyy-MM-dd HH:mm");
	}
	
	/**
	 * 得到日期时间字符串，转换格式（yyyy-MM-dd HH:mm:ss）
	 */
	public static String formatDateTime(Date date) {
		return formatDate(date, "yyyy-MM-dd HH:mm:ss");
	}
	
	/**
	 * 得到日期时间字符串，转换格式（yyyy-MM-dd HH:mm:ss:SSS）
	 * 
	 * @param date
	 * @return yyyy-MM-dd HH:mm:ss:SSS
	 */
	public static String formatDateTimes(Date date) {
		return formatDate(date, "yyyy-MM-dd HH:mm:ss:SSS");
	}

	/**
	 * 得到日期时间字符串，转换格式（HH:mm:ss）
	 * 
	 * @param date
	 * @return HH:mm:ss
	 */
	public static String formatTime(Date date) {
		if(date == null){
			return "";
		}
		return formatDate(date, "HH:mm:ss");
	}

	/**
	 * 得到日期小时字符串，转换格式（HH）
	 * 
	 * @param date
	 * @return HH
	 */
	public static String formatHour(Date date) {
		if (date == null) {
			return "";
		}
		return formatDate(date, "HH");
	}

	/**
	 * 得到当前时间字符串 格式（HH:mm:ss）
	 */
	public static String getTime() {
		return formatDate(new Date(), "HH:mm:ss");
	}
	
	
	/**
	 * 获取两个时间之间的list集合，type可以指定返回格式
	 * 
	 * @param startDate
	 * @param endDate
	 * @param type
	 * @return
	 * @throws Exception
	 */
	public static List<String> getDateList(Date startDate, Date endDate, String type,
			String order) throws Exception {
		List<String> list = new ArrayList<String>();
		if ("desc".equals(order)) {
			while (startDate.compareTo(endDate) <= 0) {
				list.add(formatDate(endDate, type));
				endDate = get(DAY, "prev", endDate);
			}
		} else {
			while (startDate.compareTo(endDate) <= 0) {
				list.add(formatDate(startDate, type));
				startDate = get(DAY, "next", startDate);
			}
		}
		return list;
	}
	

	/**
	 * 获取一个日期的上一及下一月份,或者天数年等,如果获取是上一周,则获取上周的周一的日期
	 * 
	 * @param type
	 *            类别,年月日周
	 * @param act
	 *            动作,上月或者下月,prev,next
	 * @param date
	 * @return
	 * @throws Exception
	 */
	public static Date get(String type, String act, Date date) throws Exception {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		if (DateUtils.MONTH.equals(type)) {
			if ("prev".equals(act)) {
				c.add(Calendar.MONTH, -1);
			} else {
				c.add(Calendar.MONTH, 1);
			}
		} else if (DateUtils.YEAR.equals(type)) {
			if ("prev".equals(act)) {
				c.add(Calendar.YEAR, -1);
			} else {
				c.add(Calendar.YEAR, 1);
			}
		} else if (DateUtils.WEEK.equals(type)) {
			c.setFirstDayOfWeek(Calendar.MONDAY);
			if ("prev".equals(act)) {
				c.add(Calendar.WEEK_OF_MONTH, -1);
			} else {
				c.add(Calendar.WEEK_OF_MONTH, 1);
			}
			c.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
			return c.getTime();
		} else if (DateUtils.DAY.equals(type)) {
			if ("prev".equals(act)) {
				c.add(Calendar.DATE, -1);
			} else {
				c.add(Calendar.DATE, 1);
			}
			return c.getTime();
		}
		c.set(Calendar.DATE, 1);
		return c.getTime();
	}

	/**
	 * 得到当前日期和时间字符串 格式（yyyy-MM-dd HH:mm:ss）
	 */
	public static String getDateTime() {
		return formatDate(new Date(), "yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * 得到当前日期和时间字符串 格式（yyyy-MM-dd HH:mm:ss:SSS）
	 */
	public static String getDateTimes() {
		return formatDate(new Date(), "yyyy-MM-dd HH:mm:ss:SSS");
	}

	/**
	 * 得到当前年份字符串 格式（yyyy）
	 */
	public static String getYear() {
		return formatDate(new Date(), "yyyy");
	}

	/**
	 * 得到当前月份字符串 格式（MM）
	 */
	public static String getMonth() {
		return formatDate(new Date(), "MM");
	}

	/**
	 * 得到当天字符串 格式（dd）
	 */
	public static String getDay() {
		return formatDate(new Date(), "dd");
	}

	/**
	 * 得到当前星期字符串 格式（E）星期几
	 */
	public static String getWeek() {
		return formatDate(new Date(), "E");
	}

	/**
	 * 日期型字符串转化为日期 格式 { "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm",
	 * "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm"}
	 */
	public static Date parseDate(Object str) {
		if (str == null) {
			return null;
		}
		try {
			return parseDate(str.toString(), parsePatterns);
		} catch (ParseException e) {
			return null;
		}
	}

	/**
	 * 日期转换
	 * 
	 * @param date
	 *            yyyy-MM-dd HH:mm:ss:SSS
	 * @return
	 */
	public static Date parseDateTimes(String date) {
		SimpleDateFormat timeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
		 try {
			return timeFormat.parse(date);
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 日期转换
	 * 
	 * @param dateStr
	 *            yyyy-MM-dd HH:mm:ss
	 * @return
	 */
	public static Date parseDateTime(String dateStr) {
		SimpleDateFormat timeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 try {
			return timeFormat.parse(dateStr);
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
	}
	
	

	/**
	 * 获取过去的天数
	 * 
	 * @param date
	 * @return
	 */
	public static long pastDays(Date date) {
		long t = new Date().getTime() - date.getTime();
		return t / (24 * 60 * 60 * 1000);
	}

	/**
	 * 获取指定日期 开始时间
	 * 
	 * @param date
	 * @return 返回 "yyyy-MM-dd 00:00:00"
	 */
	public static Date getStartDateTime(Date date) {
		if (date == null) {
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			date = sdf.parse(formatDate(date, "yyyy-MM-dd") + " 00:00:00");
		} catch (ParseException e) {
			LOG.error(e.getMessage(), e);
		}
		return date;
	}
	
	/**
	 * 获取昨天
	 * 
	 * @param date
	 * @return
	 */
	public static Date getYesterday() {
		Date date = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DATE, -1);
		return calendar.getTime();
	}
	
	/**
	 * 获取指定日期 开始时间
	 * 
	 * @param date
	 *            yyyy-MM-dd格式字符串
	 * @return 返回 "yyyy-MM-dd 00:00:00"
	 */
	public static Date getStartDateTime(String date) {
		if (date == null) {
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		try {
			return sdf.parse(date + " 00:00:00");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return null;
		}
	}
	
	

	/**
	 * 获取指定日期 结束时间
	 * 
	 * @param date
	 * @return 返回 "yyyy-MM-dd 23:59:59"
	 */
	public static Date getEndDateTime(Date date) {
		if (date == null) {
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			date = sdf.parse(formatDate(date, "yyyy-MM-dd") + " 23:59:59");
		} catch (ParseException e) {
			LOG.error("获取指定日期 结束时间异常，原因{}", e);
		}
		return date;
	}

	/**
	 * 获取指定日期 结束时间
	 * 
	 * @param date
	 *            yyyy-MM-dd格式字符串
	 * @return 返回 "yyyy-MM-dd 23:59:59" 的日期
	 */
	public static Date getEndDateTime(String date) {
		if (date == null) {
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		try {
			return sdf.parse(date + " 23:59:59");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 判定时间，是否在给定时间区间范围内，包含两个端点
	 * 
	 * @param time
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	public static boolean isInBetweenDate(Date time, Date startTime, Date endTime){

		if(endTime.getTime() > startTime.getTime()){
			return startTime.getTime() <= time.getTime() && time.getTime() <= endTime.getTime();
		}
		return endTime.getTime() <= time.getTime() && time.getTime() <= startTime.getTime();
		
	}

//	/** Transform ISO 8601 string to Calendar. */
//	public static Calendar IOS8601toCalendar(final String iso8601string) {
//		Calendar calendar = GregorianCalendar.getInstance();
//		Date date = IOS8601toDate(iso8601string);
//		calendar.setTime(date);
//		return calendar;
//	}

//	/** Transform ISO 8601 string to Date. */
//	public static Date IOS8601toDate(final String iso8601string) {
//		Date date = null;
//		try {
//			ISO8601DateFormat df = new ISO8601DateFormat();
//			// Date d = df.parse("2010-07-28T22:25:51Z");
//			date = df.parse(PMSUtils.isNull(iso8601string));
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
//		return date;
//	}

	/**
	 * 根据开始时间和结束时间返回时间段内的日期集合 【日期先后顺序不限制】
	 * 
	 * @param startDate
	 * @param endDate
	 *            为null时候返回startDate的日期list
	 * @return List
	 */
	public static List<Date> getDatesBetweenTwoDate(Date startDate, Date endDate) {
		List<Date> list = new ArrayList<Date>();
		list.add(startDate);// 把开始时间加入集合
		
		if(endDate == null || startDate.equals(endDate)){
			return list;
		}
		Date tmp = null;
		if(endDate.before(startDate)){
			tmp = startDate;
			startDate = endDate;
			endDate = tmp;
		}
		
		Calendar cal = Calendar.getInstance();
		// 使用给定的 Date 设置此 Calendar 的时间
		cal.setTime(startDate);
		boolean bContinue = true;
		while (bContinue) {
			// 根据日历的规则，为给定的日历字段添加或减去指定的时间量
			cal.add(Calendar.DAY_OF_MONTH, 1);
			// 测试此日期是否在指定日期之后
			if (endDate.after(cal.getTime())) {
				if (!isSameDay(cal.getTime(), endDate)) {
					cal.set(Calendar.HOUR_OF_DAY, 0);
					cal.set(Calendar.MINUTE, 0);
					cal.set(Calendar.SECOND, 0);
					list.add(cal.getTime());
				} else {
					break;
				}
			} else {
				break;
			}
		}
		list.add(endDate);// 把结束时间加入集合
		return list;
	}
	
	
	/**
	 * 获取两个日期的时间间隔 秒
	 * 
	 * @param startTime
	 * @param endTime
	 * @return 时间差（秒） 【绝对值】
	 */
	public static long secondInterval(String startTime,String endTime){
		return  secondInterval(parseDateTimes(startTime),parseDateTimes(endTime));
	}
	
	/**
	 * 获取两个日期的时间间隔 秒
	 * 
	 * @param startTime
	 * @param endTime
	 * @return 时间差（秒） 【绝对值】
	 */
	public static long secondInterval(Date startTime,Date endTime){
		return Math.abs((endTime.getTime() - startTime.getTime()) / 1000);
	}

	/**
	 * 获取两个日期相差的天数
	 * 
	 * @param startTime
	 *            { "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm",
	 *            "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm"}
	 * @param endTime
	 *            { "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm",
	 *            "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm"}
	 * @return 时间差（天） 【绝对值】
	 */
	public static long dayInterval(String startTime,String endTime){
		return dayInterval(parseDate(startTime), parseDate(endTime));
	}
	
	/**
	 * 获取两个日期相差的天数
	 * 
	 * @param startTime
	 * @param endTime
	 * @return 时间差（天） 【绝对值】
	 */
	public static long dayInterval(Date startTime, Date endTime) {
		Calendar aCalendar = Calendar.getInstance();

		aCalendar.setTime(startTime);
		int day1 = aCalendar.get(Calendar.DAY_OF_YEAR);

		aCalendar.setTime(endTime);
		int day2 = aCalendar.get(Calendar.DAY_OF_YEAR);

		return Math.abs(day2 - day1);
	}
	
	
	/**
	 * 获取指定日期 相隔 days天的日期字符串 yyyy-mm-dd
	 * 
	 * @param date
	 *            指定日期
	 * @param days
	 *            days > 0 表示 date日期 days天后的日期， days<0 表示 date日期 days天前的日期， 0
	 *            表示当天
	 * @return
	 */
	public static String getDateFormatFromDate(Date date, int days){
		if(null == date){
			date = new Date();
		}
		if(days == 0){
			return DateFormatUtils.format(date, "yyyy-MM-dd");
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, days);
		
		return DateFormatUtils.format(cal.getTime(), "yyyy-MM-dd");
	}
	
	/**
	 * 获取指定日期 相隔 days天的日期
	 * 
	 * @param date
	 *            指定日期
	 * @param days
	 *            days > 0 表示 date日期 days天后的日期， days<0 表示 date日期 days天前的日期， 0
	 *            表示当天
	 * @return
	 */
	public static Date getDateFromDate(Date date, int days){
		if(null == date){
			date = new Date();
		}
		if(days == 0){
			return date;
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, days);
		
		return cal.getTime();
	}
	
	/**
	 * 获取日期 前（后） 指定秒数的 时间
	 * 
	 * @param date
	 *            日期（为null时候，表示当前日期）
	 * @param seconds
	 *            seconds > 0 表示 date日期 后seconds秒的日期， days<0 表示 date日期
	 *            前seconds秒的日期， 0 表示没有变化
	 * @return
	 */
	public static Date getDateFromSeconds(Date date, int seconds){
		
		if(null == date){
			date = new Date();
		}
		if(seconds == 0){
			return date;
		}
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.SECOND, seconds);
		
		return cal.getTime();
	}
	
	/*
	 * 时刻计算专用 time 格式 yyyy-MM-dd HH:mm runTime 时长
	 */
	public static String getTimeByTimeAndRunTime(String time, int runTime) throws ParseException{
		
		Date date = DateUtils.parseDate(time,"yyyy-MM-dd HH:mm");
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MINUTE,runTime);
		
		return DateUtils.formatDate(cal.getTime(), "yyyy-MM-dd HH:mm");
	}
	
	/*
	 * 时刻计算专用 startTime 格式 yyyy-MM-dd HH:mm endTime 格式 yyyy-MM-dd HH:mm
	 */
	public static int getTimeDifferenceByTime(String startTime, String endTime) throws ParseException{
	    try {
			int startDate = (int) DateUtils.parseDate(startTime, "yyyy-MM-dd HH:mm").getTime();
			int endDate = (int) DateUtils.parseDate(endTime, "yyyy-MM-dd HH:mm").getTime();
			
			return (endDate - startDate)/1000/60;
		} catch (Exception e) {
			LOG.error("时刻计算异常，原因{}", e);
			return 0;
		}
	}
	
	/**
	 * 获取日期 前（后） 指定分钟数的 时间
	 * 
	 * @param date
	 *            日期（为null时候，表示当前日期）
	 * @param minute
	 *            minute > 0 表示 date日期 minute分钟后的日期， days<0 表示 date日期
	 *            minute分钟的日期， 0 表示没有变化
	 * @return
	 */
	public static Date getDateFromMinute(Date date, int minute){
		
		if(null == date){
			date = new Date();
		}
		if(minute == 0){
			return date;
		}
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MINUTE, minute);
		
		return cal.getTime();
	}
	
	
	/**
	 * 是否与当前系统时间一致【毫秒】（给定误差范围内）
	 * 
	 * @param date
	 * @param secondRange
	 *            误差秒数。给定时间和当前时间秒数差的绝对值小于该值认为一致。(为0表示当前系统时间)
	 * @return
	 */
	public static boolean isCurrentSystemTime(Date date, int deviationSecondRange) {

		long offset = date.getTime() / 1000 - (System.currentTimeMillis()) / 1000;

		return 0 <= offset && offset <= deviationSecondRange;
	}
	
	
	/**
	 * 是否是系统当前日期
	 * 
	 * @param date
	 * @return
	 */
	public static boolean isSystemDay(Date date){
		
		String systemDate = getDate();
		String cdate = formatDate(date, "yyyy-MM-dd");
		return systemDate.equals(cdate);
		
	}
	
	/**
	 * 获得该月第一天
	 * 
	 * @param year
	 * @param month
	 * @return
	 */
	public static Date getFirstDayOfMonth(int year,int month){
	        Calendar cal = Calendar.getInstance();
		// 设置年份
	        cal.set(Calendar.YEAR,year);
		// 设置月份
	        cal.set(Calendar.MONTH, month-1);
		// 获取某月最小天数
	        int firstDay = cal.getActualMinimum(Calendar.DAY_OF_MONTH);
		// 设置日历中月份的最小天数
	        cal.set(Calendar.DAY_OF_MONTH, firstDay);
		// 格式化日期
//	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//	        String firstDayOfMonth = sdf.format(cal.getTime());
//	        return firstDayOfMonth;
	        return cal.getTime();
	    }
	
	/**
	 * 获得该月最后一天
	 * 
	 * @param year
	 * @param month
	 * @return
	 */
	public static Date getLastDayOfMonth(int year,int month){
	        Calendar cal = Calendar.getInstance();
		// 设置年份
	        cal.set(Calendar.YEAR,year);
		// 设置月份
	        cal.set(Calendar.MONTH, month-1);
		// 获取某月最大天数
	        int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		// 设置日历中月份的最大天数
	        cal.set(Calendar.DAY_OF_MONTH, lastDay);
		// 格式化日期
//	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//	        String lastDayOfMonth = sdf.format(cal.getTime());
//	        return lastDayOfMonth;
	        return cal.getTime();
	}
	

	/**
	 * @param args
	 * @throws ParseException
	 */
	public static void main(String[] args) throws ParseException {
		// System.out.println(formatDate(parseDate("2010/3/6")));
		// System.out.println(getDate("yyyy年MM月dd日 E"));
		// long time = new Date().getTime()-parseDate("2012-11-19").getTime();
		// System.out.println(time/(24*60*60*1000));
		
//		Date date = new Date();
//		System.out.println(formatDateTimes(date));
//		System.out.println(formatDateTimes(getDateFromDate(date, 5)));
		
//		Date date = new Date();
//		Date date1 = getStartDateTime(date);
//		System.out.println(getSecondsBetwen(date1, date));
		
		/*
		 * System.out.println(formatDateTimes(parseDateTimes(
		 * "2016-12-12 00:00:00:132")));
		 * System.out.println(formatDateTime(parseDateTime(
		 * "2016-12-12 00:00:00:789"))); System.out.println(formatDate(new
		 * Date(), "yyyy-MM-dd HH:mm")); System.out.println(formatDate(new
		 * Date(), "yyyy年MM月dd日"));
		 * System.out.println(formatDateTimeMinute(parseDate("2016-12-12 12:59"
		 * ))); System.out.println(getDateTimes());
		 * System.out.println(formatDateTimes(parseDate("2016-12-12")));
		 * 
		 * Date startDate = parseDate("2016-12-11"); Date nowDate =
		 * parseDate("2016-12-12"); Date endDate = parseDate("2016-12-13");
		 * 
		 * System.out.println(formatHour(new Date()));
		 * System.out.println("当前时间是否小于开始运营时间:" + startDate.before(nowDate));
		 * System.out.println("当前时间是否大于结束运营时间:" + nowDate.after(endDate));
		 * 
		 * System.out.println(getTimeDifferenceByTime("2016-12-12 12:59",
		 * "2016-12-12 15:59"));
		 */
//		int dateDiff =  (int)dayInterval(parseDateTime("2019-07-01 00:00:00"),parseDateTime("2019-07-15 00:00:00"))+1;
//		System.out.println(dateDiff);
//		System.out.println(getDateFromDate(parseDateTime("2019-07-01 00:00:00"),(0-dateDiff)));
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.set(Calendar.HOUR_OF_DAY, 24);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		Date start = calendar.getTime();//当天的24点
//		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		Date date2 = format.parse(start);
		String a=formatDate(start,"yyyy-MM-dd HH:mm:ss");
		System.out.println(a);
	}
}
