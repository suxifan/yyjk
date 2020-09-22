package com.cictec.yyjk.commons.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MD5Util {
	private static final Logger LOG = LoggerFactory.getLogger(MD5Util.class);
	public final static String encry(String str) {
		try {
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			md5.update(str.getBytes());
			byte b[] = md5.digest();

			StringBuffer sb = new StringBuffer("");
			for (int n = 0; n < b.length; n++) {
				int i = b[n];
				if (i < 0)
					i += 256;
				if (i < 16)
					sb.append("0");
				sb.append(Integer.toHexString(i));
			}
			return sb.toString(); // 32位加密
		} catch (NoSuchAlgorithmException e) {
			LOG.error("MD5加密失败，原因{}", e);
			return null;
		}
	}

	public static void main(String[] args) {
		System.out.println(MD5Util.encry("111111"));
	}
}
