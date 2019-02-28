package test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import DTO.WhatsAppDTO;

public class MainDao2 
{
	public static void main(String[] args)
	{

		Configuration cfg=new Configuration();
		cfg.configure();
		cfg.addAnnotatedClass(WhatsAppDTO.class);
		SessionFactory sf=cfg.buildSessionFactory();
		Session session=sf.openSession();
		// step1 preapere/create the qry
		String hql="from WhatsAppDTO";
		
		Query qry=session.createQuery(hql);
		
	    //ste2 process the result
		
		List<WhatsAppDTO> list =qry.list();
		for (WhatsAppDTO obj : list) 
		{
			
			System.out.println(obj.getStatus());
			System.out.println(obj.getColor());
			System.out.println(obj.getName());
		
			
			
		}
		
		
	}

	

}
