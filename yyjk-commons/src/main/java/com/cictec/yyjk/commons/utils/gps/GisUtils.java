package com.cictec.yyjk.commons.utils.gps;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cictec.yyjk.commons.utils.PMSUtils;
import com.cictec.yyjk.commons.utils.gps.CoordinateConversion.UTMPoint;
import com.vividsolutions.jts.geom.LineSegment;

public class GisUtils {

	static Logger logger = LoggerFactory.getLogger(GisUtils.class);
	
	public static final double EARTH_RADIUS = 6378.1370;
	
	/**
	 * 纬度转换
	 * 
	 * @param latitude
	 * @return
	 */
	public static String convertLatitude(String latitude){
		String newLatitude = "";
		try {
			if (latitude != null && !"".equals(latitude)) {
				String du = latitude.substring(0,2);
				Double douDu = Double.valueOf(du);
				String fen = latitude.substring(2);
				Double douFen = Double.valueOf(fen);
				Double newFen = douFen/60;
				Double douLat = douDu+newFen;
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
	public static String convertLongitude(String longitude){
		String newLongitude = "";
		try {
			if (longitude != null && !"".equals(longitude)) {
				String du = longitude.substring(0,3);
				Double douDu = Double.valueOf(du);
				String fen = longitude.substring(3);
				Double douFen = Double.valueOf(fen);
				Double newFen = douFen/60;
				Double douLat = douDu+newFen;
				newLongitude = String.valueOf(douLat);
			}
		} catch (NumberFormatException e) {
			logger.error("转换经度时异常:经度{},异常原因{}", longitude, e);
		}
		return newLongitude;
	}
	
	/**
	 * 获取线段的角度，正北为零度顺时针旋转
	 * 
	 * @param ls
	 * @return [0,360)
	 */
	  public static double lineAngle(LineSegment ls){
		  return angleConvert(ls.angle());
	  }
	  
	/**
	 * 将JTS计算出的直线角度转换成以正北为零度顺时针递增的角度
	 * 
	 * @param a
	 * @return [0,360) 0 ~ 360 度
	 */
	  public static double angleConvert(double a){
		  if(a<0){
			  return (a+2*Math.PI)*180 / Math.PI;
		  }else{
			  return a * 180 / Math.PI;
		  }
	  }
	  
		/**
	 * 百度坐标到火星坐标转换
	 * 
	 * @param bp
	 *            百度坐标点
	 * @return 火星坐标点
	 */
		public static Point baiduToHuoxing(Point bp){

			double x = bp.getX() - 0.0065, y = bp.getY() - 0.006;
			double z = Math.sqrt(x * x + y * y) - 0.00002 * Math.sin(y * Math.PI);  
			double theta = Math.atan2(y, x) - 0.000003 * Math.cos(x * Math.PI);  
			double   gg_lon = z * Math.cos(theta);  
			double   gg_lat = z * Math.sin(theta);  
			
			Point hp = new Point();
			hp.setX(gg_lon);
			hp.setY(gg_lat);
			
			return hp;
		}
		
		/**
	 * 火星坐标到百度坐标转换
	 * 
	 * @param hp
	 *            火星坐标
	 * @return 百度坐标
	 */
		public static Point huoxingToBaidu(Point hp){
			
			
		    double x = hp.getX(), y = hp.getY();  
		    double z = Math.sqrt(x * x + y * y) + 0.00002 * Math.sin(y * Math.PI);  
		    double theta = Math.atan2(y, x) + 0.000003 * Math.cos(x * Math.PI);  
		    double bd_lon = z * Math.cos(theta) + 0.0065;  
		    double bd_lat = z * Math.sin(theta) + 0.006;  
			
			
			Point bp = new Point();
			bp.setX(bd_lon);
			bp.setY(bd_lat);
			
			return hp;
		}
		
		/**
	 * 地球坐标转换成火星坐标
	 * 
	 * @param dp
	 *            地球坐标点
	 * @return 火星坐标点
	 */
		public static Point diqiuToHuoxing(Point dp){
			DiqiuHuoxingConverter converter = new DiqiuHuoxingConverter();
			Point p = converter.getEncryPoint(dp.getY(),dp.getX());
			
			return p;
		}
		
	/**
	 * GPS坐标转化为火星坐标
	 * 
	 * @param longitude
	 *            经度
	 * @param latitude
	 * @return
	 */
	public static Point diqiuToHuoxing(String latitude,String longitude){
		Point point = new Point(Double.valueOf(longitude),Double.valueOf(latitude));
		return diqiuToHuoxing(point);
		
	}
	
	static public double[] utm2LatLon(String UTM) {
		return CoordinateConversion.utm2LatLon(UTM);
	}

	static public UTMPoint latLon2UTM(String latitude, String longitude) {
		return CoordinateConversion.latLon2UTM(latitude, longitude);
	}

	static public UTMPoint latLon2UTM(double latitude, double longitude) {
		return CoordinateConversion.latLon2UTM(latitude, longitude);
	}

	static public String latLon2MGRUTM(double latitude, double longitude) {
		return CoordinateConversion.latLon2MGRUTM(latitude, longitude);
	}

	static public double[] mgrutm2LatLon(String MGRUTM) {
		return CoordinateConversion.mgrutm2LatLon(MGRUTM);
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
	public static double calcTwoPointMiles(Point p1,Point p2){
		UTMPoint pa = latLon2UTM(p1.getX(),p1.getY());
		UTMPoint pb = latLon2UTM(p2.getX(),p2.getY());
		return Math.sqrt((pa.getY()-pb.getY())*(pa.getY()-pb.getY())+(pa.getX()-pb.getX())*(pa.getX()-pb.getX()));
	}
	
	/**
	 * 直接计算两个坐标点的距离
	 * 
	 * @param pa
	 * @param pb
	 * @return
	 */
	public static double calcTwoPointLength(Point pa,Point pb){
		return Math.sqrt((pa.getY()-pb.getY())*(pa.getY()-pb.getY())+(pa.getX()-pb.getX())*(pa.getX()-pb.getX()));
	}
	
	public static double calcTwoUtmPointMiles(UTMPoint pa,UTMPoint pb){
		return Math.sqrt((pa.getY()-pb.getY())*(pa.getY()-pb.getY())+(pa.getX()-pb.getX())*(pa.getX()-pb.getX()));
	}
	
	/**
	 * 计算两个坐标点之间的点
	 * 
	 * @param p1
	 * @param p2
	 * @return
	 */
	public static Point getMiddlePoint(Point p1,Point p2){
		double x = (p1.getX()+p2.getX())/2;
		double y = (p1.getY()+p2.getY())/2;
		
		return new Point(x, y);
	}
	
	private static double rad(double d)	{
	   return d * Math.PI / 180.0;
	}

	public static double getDistance(String lat1, String lng1, String lat2, String lng2){
		return getDistance(Double.valueOf(lat1),Double.valueOf(lng1),Double.valueOf(lat2),Double.valueOf(lng2));
	}
	
	public static double getDistance( double lat1,double lng1, double lat2,	double lng2) {			
	    
		double radLat1 = rad(lat1);
		double radLat2 = rad(lat2);
		double a = radLat1 - radLat2;
		double b = rad(lng1) - rad(lng2);
		double s =  2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2) + Math.cos(radLat1) * Math.cos(radLat2) * Math.pow(Math.sin(b / 2), 2)));
		s = s * EARTH_RADIUS;// 取WGS84标准参考椭球中的地球长半径(单位:m)
		s = (s * 10000) / 10;		
		return new BigDecimal(s).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue();
	}
	
	/**
	 * 
	 * @param json
	 *            数据格式：109.45798873901369,36.61063610832001;109.46210861206056,
	 *            36.60291927220537;109.45798873901369,36.61063610832001
	 * @return
	 */
	public static List<Point> popPoint(String json){
		String[] strPoint = json.split(";");
		
		List<Point> points = new ArrayList();
		for (String sp : strPoint) {
			if(PMSUtils.isEmpty(sp)){
				continue;
			}
			String[] p = sp.split(",");
			Point point = new Point();
			point.setX(Double.parseDouble(p[0]));
			point.setY(Double.parseDouble(p[1]));
			points.add(point);
		}
		return points;
	}
	public static void main(String[] args){
		
		double dy = EARTH_RADIUS*1000 * Math.PI*2 / 360;
		double dx1 = EARTH_RADIUS*1000 * Math.cos(36.0d/180) *Math.PI*2 / 360;
		double dx2 = EARTH_RADIUS*1000 * Math.cos(37.0d/180) *Math.PI*2 / 360;
		System.out.println(dx1-dx2);
		
//		39.932611, 116.356158
//		39.922606, 116.434436
		
//		System.out.println(getDistance(39.924120, 116.356330, 39.941166, 116.434436));
		
//		double p1y =39.924120d * dy;
//		double p1x =
//		
//		double d = dy*(39.924120-39.941166);
		
	}
}
