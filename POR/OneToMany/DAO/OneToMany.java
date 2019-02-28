package com.apssindia.hibernateframeworkclass.OneToMany.DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.apssindia.hibernateframeworkclass.OneToMany.DTO.PlatformsDTO;
import com.apssindia.hibernateframeworkclass.OneToMany.DTO.RailwayStationDTO;
import com.apssindia.javaproject.Singleton.SessionFactorySingleton;

public class OneToMany 
{
public static void main(String[] args) 
{
	//owning entity
	RailwayStationDTO railway = new RailwayStationDTO();
	railway.setStationName("CNB");
	railway.setNoOfCounters(10);
	railway.setLocation("Kanpur");
	
	//associated entity
	PlatformsDTO plat = new PlatformsDTO();
	plat.setNoOfStalls(25);
	plat.setTrainName("UdyogNagriExpess");
	
	PlatformsDTO plat2 = new PlatformsDTO();
	plat2.setNoOfStalls(20);
	plat2.setTrainName("PuspakExpess");
	
	// create Collection of assosiated Entities
	 List<PlatformsDTO> l1 = new ArrayList();
	 l1.add(plat);
	 l1.add(plat2);
	
	//relate owning with associated entity
	// railway.setPlatforms(l1); 
	 
	 
	 SessionFactory sf = SessionFactorySingleton.getSf();
	 Session session = sf.openSession();
	 session.save(railway);
	 
	 session.beginTransaction().commit();
	
     }
}
