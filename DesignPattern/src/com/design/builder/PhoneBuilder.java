package com.design.builder;

public class PhoneBuilder{
	private String Os;
	 private String ram;
	 private String processor;
	 private double screnSize;
	 private String battery;
	public PhoneBuilder setOs(String os) {
		Os = os;
		return this;
	}
	public PhoneBuilder setRam(String ram) {
		this.ram = ram;
		return this;
	}
	public PhoneBuilder setProcessor(String processor) {
		this.processor = processor;
		return this;
	}
	public PhoneBuilder setScrenSize(double screnSize) {
		this.screnSize = screnSize;
		return this;
	}
	public PhoneBuilder setBattery(String battery) {
		this.battery = battery;
		return this;
	}
	
	public Phone getPhone(){
		return new Phone(Os, ram, processor, screnSize, battery);
	}
	
}
