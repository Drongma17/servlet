package com.design.builder;

public class Shop {

	public static void main(String[] args) {
		
		Phone pon=new PhoneBuilder().setBattery("max").setRam("4").setScrenSize(8).setOs("Android").getPhone();
		System.out.println(pon);
	}
}
