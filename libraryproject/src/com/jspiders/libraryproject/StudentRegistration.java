package com.jspiders.libraryproject;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.mysql.jdbc.Driver;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StudentRegistration extends HttpServlet {
	
	  @Override
	 protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	
		  resp.setContentType("text/html");
			PrintWriter out = resp.getWriter();
			
			Connection con=null;
			PreparedStatement pstmt = null;
			ResultSet rs =null;
			String USN = req.getParameter("usn");
			String UserName = req.getParameter("name");
			String contact = req.getParameter("contactNo");
			String password = req.getParameter("password");
			//String education = req.getParameter("education");
			String branches = req.getParameter("branch");
			String semester = req.getParameter("sem");
            String Address = req.getParameter("Address");
			//String spacefortext = req.getParameter("textarea");
			try{
			/*Class.forName("com.mysql.jdbc.Driver").newInstance();*/
			Driver drif = new Driver();
			DriverManager.registerDriver(drif);
			String Dburl ="jdbc:mysql://localhost:3306/library?user=root&password=root";
			con=DriverManager.getConnection(Dburl);
			String sql="insert into student_info values(?,?,?,?,?,?,?,?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(USN));
			pstmt.setString(2, UserName);
			pstmt.setString(3, branches);
			pstmt.setString(4, semester);
		    pstmt.setString(5, Address);
		    pstmt.setString(6,null );
			pstmt.setString(7, password);
			pstmt.setString(8, null);
			
			int count =pstmt.executeUpdate();
			
			if(count !=0)
			{
			  RequestDispatcher dispatcher=req.getRequestDispatcher("Login.html");
			  dispatcher.forward(req, resp);
				
				
			}
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			
			finally{
				try{
					
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
				}catch(Exception e)
				{
					e.printStackTrace();
				}
			}
	  }
}


