package com.apssindia.hibernateframeworkclass.OneToMany.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.apssindia.hibernateframeworkclass.OneToMany.DTO.PlatformsDTO;
import com.apssindia.hibernateframeworkclass.OneToMany.DTO.RailwayStationDTO;
import com.apssindia.javaproject.Singleton.SessionFactorySingleton;

public class ManyToOne 
{
  public static void main(String[] args) {
	
	  SessionFactory sf = SessionFactorySingleton.getSf();
	    Session session = sf.openSession();
	    RailwayStationDTO railway = (RailwayStationDTO)session.load(RailwayStationDTO.class,1);
	  
	    PlatformsDTO plat1 = new PlatformsDTO();
	    plat1.setNoOfStalls(9);
		plat1.setTrainName("Shatabdi Express");    
	    plat1.setRailway(railway);
		
	    PlatformsDTO plat2 = new PlatformsDTO();
		plat2.setNoOfStalls(7);
		plat2.setTrainName("RajdhaniExpress");
	    plat2.setRailway(railway);
		
	    session.save(railway);
	    session.beginTransaction().commit();
	    
	    
	    /*// associated Entity
	  RailwayStationDTO railway = new RailwayStationDTO();
	  railway.setLocation("Banglore");
	  railway.setNoOfCounters(9);
	  railway.setStationName("SBC");
	  
	  RailwayStationDTO railway2 = new RailwayStationDTO();
	  railway2.setLocation("JHANSI");
	  railway2.setNoOfCounters(8);
	  railway2.setStationName("JHS");
	  //create object of Owning  Entity 
	
	
	
	
    //relate owning Entity with associeted Entity
	
	plat.setRailway(railway);
	plat2.setRailway(railway2);*/
	
	}
}
