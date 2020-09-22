package com.cictec.yyjk.commons.utils.gps;

/**
 * GPS不同坐标标准相互转换工具类
 * 
 * WGS84坐标（ios世界标准）
 * 
 * BD-09坐标（百度坐标）
 * 
 * GCJ-02坐标系（中国特色的火星坐标系）
 * 
 * iPhone的GPS定位(CLLocationManager)获得的经纬坐标是基于WGS-84坐标系（世界标准）
 * 
 * Google地图使用的是GCJ-02坐标系（中国特色的火星坐标系）
 * 
 * 百度的经纬坐标在GCJ-02的基础上再做了次加密，就是BD-09坐标系
 * 
 * @author gxp
 *
 */
public class GpsSwitchUtils {

	static double x_PI = 3.14159265358979324 * 3000.0 / 180.0;
	static double PI = 3.1415926535897932384626;
	static double a = 6378245.0;
	static double ee = 0.00669342162296594323;

	/**
	 * 百度坐标系 (BD-09) 与 火星坐标系 (GCJ-02)的转换 即 百度 转 谷歌、高德
	 * 
	 * @param bd_lon
	 * @param bd_lat
	 * @returns Gps
	 */
	public Gps bd09togcj02(double bd_lon, double bd_lat) {
		double x = bd_lon - 0.0065;
		double y = bd_lat - 0.006;
		double z = Math.sqrt(x * x + y * y) - 0.00002 * Math.sin(y * x_PI);
		double theta = Math.atan2(y, x) - 0.000003 * Math.cos(x * x_PI);
		double mglng = z * Math.cos(theta);
		double mglat = z * Math.sin(theta);
		return new Gps(mglat, mglng);
	}

	/**
	 * 火星坐标系 (GCJ-02) 与百度坐标系 (BD-09) 的转换 即谷歌、高德 转 百度
	 * 
	 * @param lng
	 * @param lat
	 * @returns Gps
	 */
	public static Gps gcj02tobd09(double lng, double lat) {
		double z = Math.sqrt(lng * lng + lat * lat) + 0.00002 * Math.sin(lat * x_PI);
		double theta = Math.atan2(lat, lng) + 0.000003 * Math.cos(lng * x_PI);
		double mglng = z * Math.cos(theta) + 0.0065;
		double mglat = z * Math.sin(theta) + 0.006;
		return new Gps(mglat, mglng);
	};

	/**
	 * WGS84转GCj02
	 * 
	 * @param lng
	 * @param lat
	 * @returns Gps
	 */
	public static Gps wgs84togcj02(double lng, double lat) {
		double dlat = transformlat(lng - 105.0, lat - 35.0);
		double dlng = transformlng(lng - 105.0, lat - 35.0);
		double radlat = lat / 180.0 * PI;
		double magic = Math.sin(radlat);
		magic = 1 - ee * magic * magic;
		double sqrtmagic = Math.sqrt(magic);
		dlat = (dlat * 180.0) / ((a * (1 - ee)) / (magic * sqrtmagic) * PI);
		dlng = (dlng * 180.0) / (a / sqrtmagic * Math.cos(radlat) * PI);
		double mglat = lat + dlat;
		double mglng = lng + dlng;
		return new Gps(mglat, mglng);
	};

	/**
	 * GCJ02 转换为 WGS84
	 * 
	 * @param lng
	 * @param lat
	 * @returns Gps
	 */
	public Gps gcj02towgs84(double lng, double lat) {
		double dlat = transformlat(lng - 105.0, lat - 35.0);
		double dlng = transformlng(lng - 105.0, lat - 35.0);
		double radlat = lat / 180.0 * PI;
		double magic = Math.sin(radlat);
		magic = 1 - ee * magic * magic;
		double sqrtmagic = Math.sqrt(magic);
		dlat = (dlat * 180.0) / ((a * (1 - ee)) / (magic * sqrtmagic) * PI);
		dlng = (dlng * 180.0) / (a / sqrtmagic * Math.cos(radlat) * PI);
		double mglat = lat + dlat;
		double mglng = lng + dlng;
		return new Gps(mglat, mglng);
	};

	/**
	 * WGS84坐标（ios世界标准） 转换百度坐标系 (BD-09)
	 * 
	 * @param lng
	 * @param lat
	 * @returns Gps
	 * 
	 */
	public static Gps wgs84tobd09(double lng, double lat) {
		// 第一次转换
		double dlat = transformlat(lng - 105.0, lat - 35.0);
		double dlng = transformlng(lng - 105.0, lat - 35.0);
		double radlat = lat / 180.0 * PI;
		double magic = Math.sin(radlat);
		magic = 1 - ee * magic * magic;
		double sqrtmagic = Math.sqrt(magic);
		dlat = (dlat * 180.0) / ((a * (1 - ee)) / (magic * sqrtmagic) * PI);
		dlng = (dlng * 180.0) / (a / sqrtmagic * Math.cos(radlat) * PI);
		double mglat = lat + dlat;
		double mglng = lng + dlng;

		// 第二次转换
		double z = Math.sqrt(mglng * mglng + mglat * mglat) + 0.00002 * Math.sin(mglat * x_PI);
		double theta = Math.atan2(mglat, mglng) + 0.000003 * Math.cos(mglng * x_PI);
		double bd_lng = z * Math.cos(theta) + 0.0065;
		double bd_lat = z * Math.sin(theta) + 0.006;

		return new Gps(bd_lat, bd_lng);
	}

	private static double transformlat(double lng, double lat) {
		double ret = -100.0 + 2.0 * lng + 3.0 * lat + 0.2 * lat * lat + 0.1 * lng * lat
				+ 0.2 * Math.sqrt(Math.abs(lng));
		ret += (20.0 * Math.sin(6.0 * lng * PI) + 20.0 * Math.sin(2.0 * lng * PI)) * 2.0 / 3.0;
		ret += (20.0 * Math.sin(lat * PI) + 40.0 * Math.sin(lat / 3.0 * PI)) * 2.0 / 3.0;
		ret += (160.0 * Math.sin(lat / 12.0 * PI) + 320 * Math.sin(lat * PI / 30.0)) * 2.0 / 3.0;
		return ret;
	}

	private static double transformlng(double lng, double lat) {
		double ret = 300.0 + lng + 2.0 * lat + 0.1 * lng * lng + 0.1 * lng * lat + 0.1 * Math.sqrt(Math.abs(lng));
		ret += (20.0 * Math.sin(6.0 * lng * PI) + 20.0 * Math.sin(2.0 * lng * PI)) * 2.0 / 3.0;
		ret += (20.0 * Math.sin(lng * PI) + 40.0 * Math.sin(lng / 3.0 * PI)) * 2.0 / 3.0;
		ret += (150.0 * Math.sin(lng / 12.0 * PI) + 300.0 * Math.sin(lng / 30.0 * PI)) * 2.0 / 3.0;
		return ret;
	}

	public static void main(String[] args) {
		// 两次谷歌转换为百度坐标
		// 第一次 WGS84转GCj02
		Gps gps = wgs84togcj02(117.20296517261839, 31.841652709281103);
		double lng = gps.getWgLon();
		double lat = gps.getWgLat();
		System.out.println("第一次转换的结果:" + lng + "," + lat);
		// 第二次 gcj02tobd09
		System.out.println("第二次转换的结果:" + gcj02tobd09(lng, lat));

		// 谷歌转百度一次转换
		System.out.println("谷歌转换为百度一次转换的结果:" + wgs84tobd09(117.20296517261839, 31.841652709281103));
	}
}
