package com.jspiders.libraryproject;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Driver;


public class Login extends HttpServlet
{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
    		throws ServletException, IOException {
    
    	 Connection con=null;
  	   PreparedStatement pstmt=null;
  	   ResultSet rs=null;
  	   
  	   resp.setContentType("text/html");
  	   PrintWriter out=resp.getWriter();
  	 String Name =req.getParameter("name");
  	 String Password =req.getParameter("password");
  	 
  	   Driver drif;
  	try {
  		drif = new Driver();

  		DriverManager.registerDriver(drif);
  		String Dburl ="jdbc:mysql://localhost:3306/library?user=root&password=root";
  		con=DriverManager.getConnection(Dburl);
  		String sql="select * from student_info where name=? and password=?";
  		pstmt=con.prepareStatement(sql);
  		
  		pstmt.setString(1,Name);
  		pstmt.setString(2,Password);
  		
  		rs=pstmt.executeQuery(); 
  		
  			out.println("<html>");
  		     out.println("<body>");
  		     out.println("<table>");
  	     /* Printing column names */
  		     
  		   RequestDispatcher dispatcher=req.getRequestDispatcher("Header1.html");
  	    dispatcher.include(req,resp); 
  	    
  	     
  	          System.out.println("regster is found");
  	           out.print("<center><h1>The records are</h1></center>");
  			   
  			   while(rs.next())
  			   {
  				 out.print("<table border=1>");

  			    
  			   int USN=rs.getInt("usn");
  			   String NAME=rs.getString("name");
  			   String Branch=rs.getString("branch");
  			   String SEMESTER=rs.getString("semester");
  			   String address=rs.getString("address");
  			 String IsAdmin=rs.getString("isadmin");
  			String password=rs.getString("password");
  			String ContactNo=rs.getString("contactno");
  			
  			
  			 out.println("<h3>Student Information</h3>");
  			 out.println("<tr >");
  			 out.println("<td>University Reg No  :  "+USN+"</td></tr>");
  			 out.println("<tr><td>Student Name :  "+NAME+"</td></tr>");
  			 out.println("<tr><td>Branch   :  "+Branch+"</td></tr>");
  			 out.println("<tr><td> On going Semester:  "+SEMESTER+"</td></tr>");
  			 out.println("<tr><td>Student Address  :  "+address+"</td></tr>");
  			out.println("<tr><td> Admin    :  "+IsAdmin+"</td></tr>");
  			out.println("<tr><td> pass word  :  "+password+"</td></tr>");
  			out.println("<tr><td> Contact No  :  "+ContactNo+"</td></tr>");
  			 out.println("</table>");
  		  
  			 out.println("<h1>Ngawang</h1>");
  			}
  		     out.println("</body>");
  		     out.println("</html>");
  		     out.println();
  		     out.println();
  		     
  	    
  	    System.out.println();
  	    
  	    RequestDispatcher dispatcher1=
  				req.getRequestDispatcher("Footer.html");
  	    dispatcher1.include(req,resp);

  	}catch (Exception e2)

  	{

  	    e2.printStackTrace();
  	  out.println("<h1>Eorr</h1>");

  	}



  	finally{
  	  //5. close the all db objects.
  	 
  		  try {
  			if(con!=null)
  			  {
  				  con.close();
  			  }
  			  
  			if(pstmt!=null)
  			{
  				pstmt.close();
  			}
  			  if(rs!=null)
  			  {
  				  rs.close();
  			  }
  		} catch (SQLException e) {
  			
  			e.printStackTrace();
  		}
  	   
  	  }
    	
    }	
}
 