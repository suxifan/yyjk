package com.cictec.yyjk.commons.utils;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 计时器 秒表，记录耗时
 * 
 * @author qilei
 * 
 * @date 2016年7月6日
 */
@SuppressWarnings({ "rawtypes", "unchecked" })
public class TimerUtils {

	private long startTime; // 开始时间
	private long endTime; // 结束时间
	private List<Long> times = new ArrayList<Long>(); // 次数

	public TimerUtils() {
		startTime = System.currentTimeMillis(); // 排序前取得当前时间
		times.add(startTime);
	}

	/**
	 * 获取 使用的时间【从上一次计时时间算起】，可以连续适用多次
	 */
	public String getLostTimes() {
		long _startTime = startTime;
		if (times.size() > 1) {
			_startTime = times.get(times.size() - 1);
		}
		long _endTime = System.currentTimeMillis();
		times.add(_endTime);

		return dateDiffString(_startTime, _endTime, ShowDateTypes.MSC);
	}
	public String getLostTimeMillis() {
		long _startTime = startTime;
		if (times.size() > 1) {
			_startTime = times.get(times.size() - 1);
		}
		long _endTime = System.currentTimeMillis();
		times.add(_endTime);
		long diff = _endTime - _startTime;
		return diff + "毫秒";
	}

	/**
	 * 计算 开始计时到结束的时间
	 * 
	 * @return
	 */
	public String getTotalLostTimes() {
		this.endTime = System.currentTimeMillis();
		times.add(endTime);

		return dateDiffString(startTime, endTime, ShowDateTypes.MSC);
	}
	

	public static String dateDiffString(long startTime, long endTime, ShowDateTypes showTypes) {
		long diff = 0;
		// 按照传入的格式生成一个simpledateformate对象
		long nd = 1000 * 24 * 60 * 60;// 一天的毫秒数
		long nh = 1000 * 60 * 60;// 一小时的毫秒数
		long nm = 1000 * 60;// 一分钟的毫秒数
		long ns = 1000;// 一秒钟的毫秒数long diff;try {
		// 获得两个时间的毫秒时间差异
		diff = endTime - startTime;

		long day = 0l;
		long hour = 0l;// 计算差多少小时
		long min = 0l;// 计算差多少分钟
		long sec = 0l;// 计算差多少秒//输出结果
		long msc = 0l;// 计算差多少毫秒//输出结果
		switch (showTypes) {
		case DAY:
			day = diff / nd;
			break;
		case HOUR:
			day = diff / nd;
			hour = diff % nd / nh;
			break;
		case MIN:
			day = diff / nd;
			hour = diff % nd / nh;
			min = diff % nd % nh / nm;
			break;
		case SEC:
			day = diff / nd;
			hour = diff % nd / nh;
			min = diff % nd % nh / nm;
			sec = diff % nd % nh % nm / ns;
			break;
		default:
			day = diff / nd;
			hour = diff % nd / nh;
			min = diff % nd % nh / nm;
			sec = diff % nd % nh % nm / ns;
			msc = diff % nd % nh % nm % ns % 1000;
			break;
		}

		StringBuilder builder = new StringBuilder();
		if (day > 0) {
			builder.append(day).append("天");
		}
		if (hour > 0) {
			builder.append(hour).append("小时");
		}
		if (min > 0) {
			builder.append(min).append("分钟");
		}
		if (sec > 0) {
			builder.append(sec).append("秒");
		}
		if (msc > 0) {
			builder.append(msc).append("毫秒");
		}
		return builder.toString();
	}
	
	/**
	 * 
	 * 获取时间差, 返回 {day=-1, hour=0, minute=-1, second=0, millisecond=0,
	 * timestamp=1234123, stringInfo=-1天0小时-1分钟0秒0毫秒} 数据
	 * 
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	public static Map dateDiff(long startTime, long endTime) {
		long diff = 0;
		// 按照传入的格式生成一个simpledateformate对象
		long nd = 1000 * 24 * 60 * 60;// 一天的毫秒数
		long nh = 1000 * 60 * 60;// 一小时的毫秒数
		long nm = 1000 * 60;// 一分钟的毫秒数
		long ns = 1000;// 一秒钟的毫秒数long diff;try {
		// 获得两个时间的毫秒时间差异
		diff = endTime - startTime;
		long day = diff / nd;// 计算差多少天
		long hour = diff % nd / nh;// 计算差多少小时
		long min = diff % nd % nh / nm;// 计算差多少分钟
		long sec = diff % nd % nh % nm / ns;// 计算差多少秒//输出结果
		long msc = diff % nd % nh % nm % ns % 1000;// 计算差多少毫秒//输出结果
		String stringInfo = day + "天" + hour + "小时" + min + "分钟" + sec + "秒" + msc + "毫秒";
		Map data = new HashMap();
		data.put("day", day);
		data.put("hour", hour);
		data.put("minute", min);
		data.put("second", msc);
		data.put("millisecond", msc);
		data.put("timestamp", diff);
		data.put("stringInfo", stringInfo);
		return data;
	}
	
	/**
	 * 日期 加 时间戳返回新的日期
	 * 
	 * @param date
	 * @param timestamp
	 * @return
	 */
	public static Date dateAddTimestamp(Date date, long timestamp) {
		long tm = date.getTime();
		long ntm = tm + timestamp;
		return new Date(ntm);
	}

	@SuppressWarnings("static-access")
	public static void main(String[] args) {

		TimerUtils lt = new TimerUtils();

		for (int i = 0; i < 1; i++) {
			try {
				Thread.currentThread().sleep(3160);

				System.out.println(lt.getLostTimes());;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(lt.getTotalLostTimes());
	}

}
