package com.apssindia.hibernateframeworkclass.POI.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.apssindia.hibernateframeworkclass.POI.DTO.DesignDTO;
import com.apssindia.hibernateframeworkclass.POI.DTO.GreetingsDTO;
import com.apssindia.hibernateframeworkclass.POI.DTO.LogoDTO;
import com.apssindia.javaproject.Singleton.SessionFactorySingleton;

public class DesignDAO
{
public static void main(String[] args) {
	
	DesignDTO designDTO =new  DesignDTO ();
	designDTO.setPrice("10cr");
	designDTO.setDesignType("CarType");
	
	LogoDTO logoDTO = new LogoDTO();
    logoDTO.setClientName("BMW");
    logoDTO.setShape("roundShape");
    logoDTO.setDesignType("CarType");
    logoDTO.setPrice("50cr");
    
    
    GreetingsDTO greetingsDTO = new GreetingsDTO();
    greetingsDTO.setColor("MidNightBlue");
    greetingsDTO.setSize(2);//in Inches
    greetingsDTO.setPrice("10cr");
    
    
    // hibernate stuff
    SessionFactory sf = SessionFactorySingleton.getSf();
    Session session = sf.openSession();
    
    session.save(designDTO);
    session.save(logoDTO);
    session.save(greetingsDTO);
    
    session.beginTransaction().commit();

}
}
