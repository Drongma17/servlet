package com.design.factory;

public class FactoryMain {
 
	public static void main(String[] args) {
		
		OperatingSystemFactory osf=new OperatingSystemFactory();
		OS ojb=osf.getInstance("secure");
		ojb.spec();
		
	}
}
