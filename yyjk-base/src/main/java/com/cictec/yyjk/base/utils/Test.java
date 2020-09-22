package com.cictec.yyjk.base.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Test {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("1111");
		list.add("2222");
		list.add("3333");
		StringBuilder builder = new StringBuilder();
		Iterator<String> iterator = list.iterator();
		builder.append(iterator.next());
		while (iterator.hasNext()) {
			builder.append(",");
			builder.append(iterator.next());
		}
		System.out.println(builder.toString());
	}
}
