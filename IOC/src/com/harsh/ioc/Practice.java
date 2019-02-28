package com.harsh.ioc;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;


import org.springframework.core.io.FileSystemResource;

public class Practice 
{
	public static void main(String[] args) {
		
	
   Fish fish=new Fish();
   fish.setType("yello");
   
   water water=new water();
   
   if(fish!=null)
   {
	   water.setF(fish);
   }
	
	String file="E:/";
	FileSystemResource fsr=new FileSystemResource(file);
	BeanFactory bean=new XmlBeanFactory(fsr);
	
	water w1=(water)bean.getBean(water.class);
	w1.getType();
	w1.getF();
}
}