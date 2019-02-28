package com.jspiders.libraryproject;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Driver;

public class LoginController extends HttpServlet
{
	
  @Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
	
	  
	  resp.setContentType("html/text");
	  PrintWriter out=resp.getWriter();
	  
	  
	  
	  String name =req.getParameter("name");
	  String password =req.getParameter("password");
	  

		Connection con=null;
		PreparedStatement pstmt = null;
		ResultSet rs =null;
	  
	  
	  try{
			/*Class.forName("com.mysql.jdbc.Driver").newInstance();*/
			Driver drif = new Driver();
			DriverManager.registerDriver(drif);
			String Dburl ="jdbc:mysql://localhost:3306/library?user=root&password=root";
			con=DriverManager.getConnection(Dburl);
			String sql="select * from student_info where usn=? and password =?";
			pstmt=con.prepareStatement(sql);

			pstmt.setString(1, name);
			pstmt.setString(2, password);
		
			
			rs =pstmt.executeQuery();
			
			if(rs !=null)
			{
				 RequestDispatcher dispatcher=req.getRequestDispatcher("StudentView.html");
				  dispatcher.forward(req, resp);
				
				
				
			}else
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

