package com.jspiders.libraryproject;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.DriverManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import com.mysql.jdbc.Driver;





public class ViewStudent extends HttpServlet 
{
	protected void doGet(javax.servlet.http.HttpServletRequest req, 
	javax.servlet.http.HttpServletResponse resp) 	
	throws ServletException ,IOException 
	{
   Connection con=null;
   Statement stmt=null;
   ResultSet rs=null;
   
   resp.setContentType("text/html");
   PrintWriter out=resp.getWriter();
   Driver drif;
try {
	drif = new Driver();

	DriverManager.registerDriver(drif);
	String Dburl ="jdbc:mysql://localhost:3306/library?user=root&password=root";
	con=DriverManager.getConnection(Dburl);
	String sql="select * from student_info";
	stmt=con.createStatement();
	rs=stmt.executeQuery(sql);
	 out.println("<html>");
	     out.println("<body>");
	     out.println("<table>");
     /* Printing column names */
	     
	   RequestDispatcher dispatcher=
			req.getRequestDispatcher("Header1.html");
    dispatcher.include(req,resp);
    
     
          System.out.println("regster is found");
           out.print("<center><h1>The records are</h1></center>");
		   
		   while(rs.next())
		   {
			 out.print("<table border=1>");

		    
		   int Rgnum1=rs.getInt("usn");
		   String name=rs.getString("name");
		   String branch=rs.getString("branch");
		   String semester=rs.getString("semester");
		   
		 out.println("<h3>Student Information</h3>");
		 out.println("<tr >");
		 out.println("<td>Regno:"+Rgnum1+"</td></tr>");
		 out.println("<tr><td>Student name:"+name+"</td></tr>");
		 out.println("<tr><td>Branch  :"+branch+"</td></tr>");
		 out.println("<tr><td>Semester  :"+semester+"</td></tr>");
		 out.println("</table>");
	  
     
	
	     out.println("</body>");
	     out.println("</html>");
	     out.println();
	     out.println();
	     
     }	
   
    System.out.println();
    
    RequestDispatcher dispatcher1=
			req.getRequestDispatcher("Footer.html");
    dispatcher1.include(req,resp);

}catch (Exception e2)

{

    e2.printStackTrace();

}



finally{
  //5. close the all db objects.
 
	  try {
		if(con!=null)
		  {
			  con.close();
		  }
		  
		  if(rs!=null)
		  {
			  rs.close();
		  }
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
   
  }

}//end of doGet

	}
