package com.cictec.yyjk.fatigue.utils;

import java.util.Date;

import com.cictec.yyjk.commons.utils.DateUtils;

public class Test {

	public static void main(String[] args) {
		// List<Integer> list = new ArrayList<Integer>();
		// for(int i=1; i<14; i++){
		// list.add(i);
		// }
		// System.out.println("list集合:" + list);
		//
		//
		// List<Integer> subList = list.subList(6, list.size()-6);
		// System.out.println("subList集合:" + subList);
		ttt();
	}

	public static void ttt() {
		String warnDate = "2020-04-16 16:27:20";
		Date dateTime = DateUtils.parseDateTime(warnDate);
		System.out.println(checkOverTime(dateTime));
		System.out.println(checkOverTime2(dateTime));
	}

	private static boolean checkOverTime(Date date) {
		boolean b = false;
		Date ydate = DateUtils.getYesterday();// 当前时间减24小时
		if (date.compareTo(ydate) < 0) {
			b = true;
		}
		return b;
	}

	private static boolean checkOverTime2(Date date) {
		long nd = 1000 * 24 * 60 * 60;// 一天的毫秒数
		long endTime = new Date().getTime();
		long startTime = date.getTime();
		return (endTime - startTime) > nd;
	}

}
