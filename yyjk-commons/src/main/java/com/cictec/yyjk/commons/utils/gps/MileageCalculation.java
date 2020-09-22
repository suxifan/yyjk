package com.cictec.yyjk.commons.utils.gps;

public class MileageCalculation {

	public final static double EARTH_RADIUS = 6378.1370;
	private static double rad(double d) {
		return d * Math.PI / 180.0;
		}
	
		public static double  distanceOfTwoPoints( double lng1,double lat1,
				double lng2, double lat2) {			
		    
		    double radLat1 = rad(lat1);
		    double radLat2 = rad(lat2);
		    double a = radLat1 - radLat2;
		    double b = rad(lng1) - rad(lng2);
		    double s =  2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2) + Math.cos(radLat1) * Math.cos(radLat2) * Math.pow(Math.sin(b / 2), 2)));
		    s = s * EARTH_RADIUS;// 取WGS84标准参考椭球中的地球长半径(单位:m)
		    s = (s * 10000) / 10000;		
		    
		    return s; 		
		}
		
		public static void main(String[] s){
			MileageCalculation y =new MileageCalculation();
			double s1 = y.distanceOfTwoPoints(
//					116.3496452380,39.9693891070,
//					108.8700943060,34.2674589506
					Double.parseDouble("109.4792386613387"),Double.parseDouble("36.594956016965845"),
					Double.parseDouble("109.47796571987246"),Double.parseDouble("36.593919730624954")
					);
			
			System.out.println(s1);
		}
	
}
