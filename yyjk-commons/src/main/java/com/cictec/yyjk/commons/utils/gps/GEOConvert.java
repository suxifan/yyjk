package com.cictec.yyjk.commons.utils.gps;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GEOConvert {

	private static Logger logger = LoggerFactory.getLogger(GEOConvert.class);
	
	/**
	 * 百度坐标到火星坐标转换
	 * @param bp 百度坐标点
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
	 * @param hp 火星坐标
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
	 * @param dp 地球坐标点
	 * @return 火星坐标点
	 */
	public static Point diqiuToHuoxing(Point dp){
		DiqiuHuoxingConverter converter = new DiqiuHuoxingConverter();
		try{
			return converter.getEncryPoint(dp.getY(),dp.getX());
		}catch(Throwable e){
			return null;
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Point bp = new Point();
		
		//36.564949,109.478409

		bp.setX( 109.478409	);
		bp.setY(36.564949);
		
		Point hp = diqiuToHuoxing(bp);
		
		System.out.println(hp.getY()+","+hp.getX());

	}

}
