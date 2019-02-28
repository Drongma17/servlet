package com.design.builder;

public class Phone {
 private String Os;
 private String ram;
 private String processor;
 private double screnSize;
 private String battery;
public Phone(String os, String ram, String processor, double screnSize,
		String battery) {
	super();
	Os = os;
	this.ram = ram;
	this.processor = processor;
	this.screnSize = screnSize;
	this.battery = battery;
}
public String toString() {
	return "Phone [Os=" + Os + ", ram=" + ram + ", processor=" + processor
			+ ", screnSize=" + screnSize + ", battery=" + battery + "]";
}


}
