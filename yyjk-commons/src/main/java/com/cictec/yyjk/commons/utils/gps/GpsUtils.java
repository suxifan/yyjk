package com.cictec.yyjk.commons.utils.gps;

import java.math.BigDecimal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cictec.yyjk.commons.utils.gps.CoordinateConversion.UTMPoint;

public class GpsUtils {

	private static final Logger logger = LoggerFactory.getLogger(GpsUtils.class);

	

	/**
	 * GPS纬度格式化（度分秒）（）
	 * <p>
	 * 将GPS纬度转换成 ==》(格式ddmm.mmmm:即dd 度，mm.mmmm 分)，例如 34.112233 ==》
	 * 
	 * @param latitude
	 * @param formater
	 *            目前支持dm(度分) 或dms(度分秒)
	 * @return 格式dd,mm.mmmm:即dd 度，mm.mmmm 分
	 */
	public static String formateLatitude(String latitude, String formater) {
//		formater = "dm";
		// String fdd = "°";
		// String fmm = "′";
		// String fss = "″";
		String fdd = ",";
		String fmm = ",";
		String fss = ",";
		String newLatitude = "";

		try {
			if (latitude != null && !"".equals(latitude)) {
				int idx = latitude.lastIndexOf(".");// 查找小数点的位置
				String dd = latitude.substring(0, idx);
				String mm = latitude.substring(idx);

				if (formater.equals("dm")) {
					// 度分形式返回，分可能有小数位
					Double newFen = Double.valueOf(mm) * 60;

					// newLatitude = dd + "°" + String.valueOf(newFen);
					newLatitude = dd + fdd + String.valueOf(newFen) + fmm;
					newLatitude = dd + fdd + String.valueOf(newFen);
				} else if (formater.equals("dms")) {
					Double newFen = Double.valueOf(mm) * 60;
					String fen = String.valueOf(newFen);
					int ssIndex = fen.lastIndexOf(".");
					String newfen = fen.substring(0, ssIndex);
					String ss = fen.substring(ssIndex);
					Double newss = Double.valueOf(ss) * 60;
//					newLatitude = dd + fdd + newfen + fmm + String.valueOf(newss) + fss;
					newLatitude = dd + fdd + newfen + fmm + String.valueOf(newss);
				}
				
			}
		} catch (NumberFormatException e) {
			logger.error("转换纬度时异常:纬度{},异常原因{}", latitude, e);
		}
		return newLatitude;
	}
	
	/**
	 * GPS经度格式化
	 * <p>
	 * 将GPS纬度转换成 ==》(格式ddmm.mmmm:即dd 度，mm.mmmm 分)，例如 108.112233 ==》
	 * 
	 * @param longitude
	 * @param formater
	 *            目前支持dm(度分) 或dms(度分秒)
	 * @return 格式ddmm.mmmm:即dd 度，mm.mmmm 分
	 */
	public static String formatLongitude(String longitude, String formater) {
		formater = "dm";
		// String fdd = "°";
		// String fmm = "′";
		// String fss = "″";
		String fdd = ",";
		String fmm = ",";
		String fss = ",";
		String newLngitude = "";

		try {
			if (longitude != null && !"".equals(longitude)) {
				int idx = longitude.lastIndexOf(".");// 查找小数点的位置
				String dd = longitude.substring(0, idx);
				String mm = longitude.substring(idx);

				if (formater.equals("dm")) {
					// 度分形式返回，分可能有小数位
					Double newFen = Double.valueOf(mm) * 60;

					// newLatitude = dd + "°" + String.valueOf(newFen);
					newLngitude = dd + fdd + String.valueOf(newFen) + fmm;
					newLngitude = dd + fdd + String.valueOf(newFen);
				} else if (formater.equals("dms")) {
					Double newFen = Double.valueOf(mm) * 60;
					String fen = String.valueOf(newFen);
					int ssIndex = fen.lastIndexOf(".");
					String newfen = fen.substring(0, ssIndex);
					String ss = fen.substring(ssIndex);
					Double newss = Double.valueOf(ss) * 60;
//					newLatitude = dd + fdd + newfen + fmm + String.valueOf(newss) + fss;
					newLngitude = dd + fdd + newfen + fmm + String.valueOf(newss);
				}
				
			}
		} catch (NumberFormatException e) {
			logger.error("转换纬度时异常:纬度{},异常原因{}" + longitude, e);
		}
		return newLngitude;
	}

	
	/**
	 * 纬度转换
	 * 
	 * @param latitude
	 * @return
	 */
	public static String convertLatitude(String latitude) {
		String newLatitude = "";
		try {
			if (latitude != null && !"".equals(latitude)) {
				String du = latitude.substring(0, 2);
				Double douDu = Double.valueOf(du);
				String fen = latitude.substring(2);
				Double douFen = Double.valueOf(fen);
				Double newFen = douFen / 60;
				Double douLat = douDu + newFen;
				newLatitude = String.valueOf(douLat);
			}
		} catch (NumberFormatException e) {
			logger.error("转换纬度时异常:纬度{},异常原因{}", latitude, e);
		}
		return newLatitude;
	}

	/**
	 * 精度转换
	 * 
	 * @param longitude
	 * @return
	 */
	public static String convertLongitude(String longitude) {
		String newLongitude = "";
		try {
			if (longitude != null && !"".equals(longitude)) {
				String du = longitude.substring(0, 3);
				Double douDu = Double.valueOf(du);
				String fen = longitude.substring(3);
				Double douFen = Double.valueOf(fen);
				Double newFen = douFen / 60;
				Double douLat = douDu + newFen;
				newLongitude = String.valueOf(douLat);
			}
		} catch (NumberFormatException e) {
			logger.error("转换经度时异常:经度{},异常原因{}" + longitude, e);
		}
		return newLongitude;
	}

	/**
	 * GPS坐标转化为火星坐标
	 * 
	 * @param longitude
	 *            经度
	 * @param latitude
	 * @return
	 */
	public static Point diqiuToHuoxing(String latitude, String longitude) {
		Point point = new Point(Double.valueOf(longitude), Double.valueOf(latitude));
		return GEOConvert.diqiuToHuoxing(point);

	}

	public static Point diqiuToHuoxing(double latitude, double longitude) {
		Point point = new Point(longitude, latitude);
		return GEOConvert.diqiuToHuoxing(point);

	}

	/**
	 * 计算两个坐标点之间的距离 需先将坐标点转换成utm坐标点
	 * 
	 * @param pa
	 *            坐标点A
	 * @param pb
	 *            坐标点B
	 * @return
	 */
	public static double calcTwoPointMiles(Point p1, Point p2) {
		UTMPoint pa = CoordinateConversion.latLon2UTM(p1.getX(), p1.getY());
		UTMPoint pb = CoordinateConversion.latLon2UTM(p2.getX(), p2.getY());
		return Math.sqrt(
				(pa.getY() - pb.getY()) * (pa.getY() - pb.getY()) + (pa.getX() - pb.getX()) * (pa.getX() - pb.getX()));
	}

	/**
	 * 直接计算两个坐标点的距离
	 * 
	 * @param pa
	 * @param pb
	 * @return
	 */
	public static double calcTwoPointLength(Point pa, Point pb) {
		return Math.sqrt(
				(pa.getY() - pb.getY()) * (pa.getY() - pb.getY()) + (pa.getX() - pb.getX()) * (pa.getX() - pb.getX()));
	}

	public static double calcTwoUtmPointMiles(UTMPoint pa, UTMPoint pb) {
		return Math.sqrt(
				(pa.getY() - pb.getY()) * (pa.getY() - pb.getY()) + (pa.getX() - pb.getX()) * (pa.getX() - pb.getX()));
	}

	/**
	 * 计算两个坐标点之间的点
	 * 
	 * @param p1
	 * @param p2
	 * @return
	 */
	public static Point getMiddlePoint(Point p1, Point p2) {
		double x = (p1.getX() + p2.getX()) / 2;
		double y = (p1.getY() + p2.getY()) / 2;

		return new Point(x, y);
	}

	public static final double EARTH_RADIUS = 6378.1370;

	private static double rad(double d) {
		return d * Math.PI / 180.0;
	}

	public static double getDistance(String lat1, String lng1, String lat2, String lng2) {
		return getDistance(Double.valueOf(lat1), Double.valueOf(lng1), Double.valueOf(lat2), Double.valueOf(lng2));
	}

	public static double getDistance(double lat1, double lng1, double lat2, double lng2) {

		double radLat1 = rad(lat1);
		double radLat2 = rad(lat2);
		double a = radLat1 - radLat2;
		double b = rad(lng1) - rad(lng2);
		double s = 2 * Math.asin(Math.sqrt(
				Math.pow(Math.sin(a / 2), 2) + Math.cos(radLat1) * Math.cos(radLat2) * Math.pow(Math.sin(b / 2), 2)));
		s = s * EARTH_RADIUS;// 取WGS84标准参考椭球中的地球长半径(单位:m)
		s = (s * 10000) / 10;
		return new BigDecimal(s).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue();
	}
	
	public static GeoCoordinate GetCenterPointFromListOfCoordinates(List<GeoCoordinate> geoCoordinateList)
	{
		// 以下为简化方法（400km以内）
	    int total = geoCoordinateList.size();
	    double lat = 0, lon = 0;
	    for(GeoCoordinate g : geoCoordinateList)
	    {
	        lat += g.getLatitude() * Math.PI / 180;
	        lon += g.getLongitude() * Math.PI / 180;
	    }
	    lat /= total;
	    lon /= total;
	    return new GeoCoordinate(lat * 180 / Math.PI, lon * 180 / Math.PI);
	}
	
	public static void main(String[] args) {

		// long beignTime = System.currentTimeMillis();
		//
		// Point p1 = new
		// Point(Double.valueOf(convertLatitude("3635.4984")),Double.valueOf(convertLongitude("10929.1191"))
		// );
		// Point p2 = new
		// Point(Double.valueOf(convertLatitude("3635.4980")),Double.valueOf(convertLongitude("10929.1187"))
		// );
		//
		// double trueLeng1 = GpsUtils.calcTwoPointMiles(p2, p1);
		// double trueLeng2 = getDistance(
		// Double.valueOf(convertLatitude("3635.5197"))
		// ,Double.valueOf(convertLongitude("10928.1921"))
		// ,Double.valueOf(convertLatitude("3635.5094"))
		// ,Double.valueOf(convertLongitude("10928.1831")) );
		//
		// System.out.println( "distacne:"+trueLeng2 );
		//
		// System.out.println(System.currentTimeMillis() - beignTime);

		Point p = diqiuToHuoxing(convertLatitude("3635.5903"), convertLongitude("10928.3434"));
		System.out.println(p.getY() + "," + p.getX());
	}
}
