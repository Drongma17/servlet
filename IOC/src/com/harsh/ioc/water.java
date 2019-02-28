package com.harsh.ioc;

public final class water {

	private String type ;
	private Fish f;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Fish getF() {
		return f;
	}
	public void setF(Fish f) {
		this.f = f;
	}
}


/*
 * autowired is used to perform dependency injection automatically   this is used in beans.xml
 * 
 * there are three type
 *   1   by tpye
 *   2   bye name
 *   3   constructor
 *    
 *    byType ::  should match the property in the heap memory
 *     byName --> the reference of my dependency object (in the bean tag and  ref=" same as variable ") should be matched to property of my own object
 *      
 *      SCOPE
 *      there are five scopes in Spring
 *      1 Singleton
 *      2 prototype
 *      3 request 
 *      4 session
 *      5 global      3,4 5 are used in web application
 *      singleton scope :: it is uesd to create only one object in entire life cycle
 *      prototype scope :: is used to create every time diffirence
 *      
*/
