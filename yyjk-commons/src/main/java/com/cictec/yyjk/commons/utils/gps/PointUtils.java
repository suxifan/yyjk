package com.cictec.yyjk.commons.utils.gps;

import com.cictec.yyjk.commons.utils.gps.CoordinateConversion.UTMPoint;

public class PointUtils {
	
	/**
	 * 计算垂点
	 * 
	 * @param p1
	 * @param p2
	 * @param p3
	 * @return
	 */
	public static Point compute(Point p1,Point p2,Point p3){
		
		double k1 = (p1.getY()-p2.getY()) / (p1.getX()-p2.getX());
		Point p4 = new Point();
		if (k1 == 0.0) {
			p4.setY(p1.getY());
			p4.setX(p3.getX());
		}else {
			double k2 = -1/k1;
			
			double c1 = p1.getY() - k1*p1.getX();
			double c2 = p3.getY() - k2*p3.getX();
			
			p4.setX((c2-c1)/(k1-k2));
			p4.setY( k2*p4.getX()+c2);
		}
		
		return p4;		
	}

	public static UTMPoint compute(UTMPoint p1,UTMPoint p2,UTMPoint p3){
		
		double k1 = (p1.getY()-p2.getY()) / (p1.getX()-p2.getX());
		UTMPoint p4 = new UTMPoint();
		if (k1 == 0.0) {
			p4.setY(p1.getY());
			p4.setX(p3.getX());
		}else {
			double k2 = -1/k1;
			
			double c1 = p1.getY() - k1*p1.getX();
			double c2 = p3.getY() - k2*p3.getX();
			
			p4.setX((c2-c1)/(k1-k2));
			p4.setY( k2*p4.getX()+c2);
		}
		
		return p4;		
	}
	
	public static boolean pointInLine(UTMPoint p1,UTMPoint p2,UTMPoint p3){
		boolean xIn = false;
		if(p1.getX()<p2.getX()){
			xIn = p1.getX()<=p3.getX() && p3.getX()<=p2.getX();
		}else{
			xIn = p2.getX()<=p3.getX() && p3.getX()<=p1.getX();
		}
		boolean yIn = false;
		if(p1.getY()<p2.getY()){
			yIn = p1.getY()<=p3.getY() && p3.getY()<= p2.getY();
		}else{
			yIn = p2.getY()<=p3.getY() && p3.getY() <= p1.getY();
		}
		return xIn && yIn;
	}
}
