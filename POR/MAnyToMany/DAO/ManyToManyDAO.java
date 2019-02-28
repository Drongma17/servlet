package com.apssindia.hibernateframeworkclass.MAnyToMany.DAO;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.apssindia.hibernateframeworkclass.MAnyToMany.DTO.CompetetionDTO;
import com.apssindia.hibernateframeworkclass.MAnyToMany.DTO.ParticipantsDTO;
import com.apssindia.javaproject.Singleton.SessionFactorySingleton;

public class ManyToManyDAO
{
public static void main(String[] args) {
	//create of object of DTO
	CompetetionDTO football = new CompetetionDTO();
	football.setEventName("Football");
	football.setLocation("India");
	football.setNoOfParticipants(11);
	
	CompetetionDTO kababadi = new CompetetionDTO();
	kababadi.setEventName("Kabbadi");
	kababadi.setLocation("India");
	kababadi.setNoOfParticipants(11);
	
	ParticipantsDTO part = new ParticipantsDTO();
	part.setName("Guddu");
	part.setNoOfEvents(2);
	part.setRating(9);
	
	ParticipantsDTO part2 = new ParticipantsDTO();
	part2.setName("Chanky");
	part2.setNoOfEvents(4);
	part2.setRating(8);
	
	
	//collection Of participants
	List<ParticipantsDTO> l1 = new ArrayList<ParticipantsDTO>();
	l1.add(part);
	l1.add(part2);
	
	// relate competetion with participants
	football.setParticipants(l1);
	kababadi.setParticipants(l1);
	
	//collection of competetions
	List<CompetetionDTO> l2 = new ArrayList<CompetetionDTO>();
	l2.add(football);
	l2.add(kababadi);
	
	//relate participants with competetions
	part.setComp(l2);
	part2.setComp(l2);
	
	//Hibernate Stuff
	 SessionFactory sf = SessionFactorySingleton.getSf();
	 Session session = sf.openSession();
	 
	 // load the object from the data base
	 CompetetionDTO comp = (CompetetionDTO)session.load(CompetetionDTO.class,1);
	 List<ParticipantsDTO> list = (List<ParticipantsDTO>)comp.getParticipants();
	 for (ParticipantsDTO participantsDTO : list) 
	 {
	System.out.println(participantsDTO.getName());	
	}
	
	 
	 
	 /* 
	 session.save(football);
	 session.save(kababadi);
	 session.save(part2);
	 session.save(part);
	 
	 session.beginTransaction().commit();
	 */
	
	
	
	
	
	
	
}
}
