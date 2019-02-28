package test;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import DTO.WhatsAppDTO;


public class MainDao1 
{
	public static void main(String[] args)
	{

		Configuration cfg=new Configuration();
		cfg.configure();
		cfg.addAnnotatedClass(WhatsAppDTO.class);
		SessionFactory sf=cfg.buildSessionFactory();
		Session session=sf.openSession();
		// step1 preapere/create the qry
		String hql="select color,id from WhatsAppDTO where name='kishan'";
		
		Query qry=session.createQuery(hql);
		
	    //ste2 process the result
		
		Object[] obj=(Object[]) qry.uniqueResult();
		System.out.println(obj[0]);
		System.out.println(obj[1]);
		
		
		
	}

}
