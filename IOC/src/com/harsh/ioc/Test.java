package com.harsh.ioc;


import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

 public class Test {

	public static void main(String[] args) {
	/*	
		Fish f=new Fish();
		f.setType("gold");
		
		if(f !=null)
		{
			water w=new water();
			w.setF(f);
		}
		String xml="E:\\ClassAssignment\\IOC\\src\\com\\beans.xml";
		
		FileSystemResource fileSystemResource=new FileSystemResource(xml);
		BeanFactory bean=new XmlBeanFactory(fileSystemResource);
		water water=(water)bean.getBean(water.class);
		System.out.println(water);
		System.out.println(water.getF());
		System.out.println(water.getType());
	
	*/
		
		Fish fish=new Fish();
		fish.setType("silver");
		
		if(fish != null)
		{
			water w= new water();
			// dependency injection
			w.setF(fish);
			
		}
		
		/*String s="E:\\ClassAssignment\\IOC\\src\\com\\beans.xml";
		FileSystemResource fileSystemResource=new FileSystemResource(s);
		BeanFactory bean=new XmlBeanFactory(fileSystemResource);
		water water =(water)bean.getBean(water.class);
		System.out.println(water);
		System.out.println(water.getF());*/
		
		ApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");
		
                      water w1 =(water) context.getBean(water.class);
                      System.out.println(w1);
                      System.out.println(w1.getType());  
                      System.out.println(w1.getF());
}
}