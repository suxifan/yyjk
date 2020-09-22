package com.cictec.yyjk.commons.utils.sid;

import com.cictec.yyjk.commons.utils.SnowflakeIdWorker;

public class SidUtils {

	private static SnowflakeIdWorker worker;

	public static SnowflakeIdWorker getInstance() {
		if (worker == null) {
			worker = new SnowflakeIdWorker(0, 1);
		}
		return worker;
	}

	public static String getSid() {
		return SidUtils.getInstance().nextId() + "";
	}
}
