package com.cictec.yyjk.commons.utils.sid;

import tk.mybatis.mapper.genid.GenId;

public class GenSid implements GenId<String> {


	@Override
	public synchronized String genId(String table, String column) {
		// 这里先用 SnowflakeIdWorker 实现，后边在做修改
		return SidUtils.getSid();
	}
}
