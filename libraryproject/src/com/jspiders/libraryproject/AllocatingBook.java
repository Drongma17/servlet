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

public class AllocatingBook extends HttpServlet 
{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		Connection con=null;
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		
		resp.setContentType("text/html");
		PrintWriter out =resp.getWriter();
		
		String USN =req.getParameter("usn");
		String BookId=req.getParameter("bookid");
		//String BookAuthor=req.getParameter("author");
		//String yearpass=req.getParameter("yop");
		String datallot=req.getParameter("doa");
		String NameofBook=req.getParameter("bookName");
		String Typeofbook=req.getParameter("booktype");
		
		try{
			/*Class.forName("com.mysql.jdbc.Driver").newInstance();*/
			Driver drif = new Driver();
			DriverManager.registerDriver(drif);
			String Dburl ="jdbc:mysql://localhost:3306/library?user=root&password=root";
			con=DriverManager.getConnection(Dburl);
			String sql="insert into allot_books values(?,?,?,?,?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(BookId));
			pstmt.setInt(2, Integer.parseInt(USN));
			
			//pstmt.setString(3, BookAuthor);
			//pstmt.setString(3, yearpass);
		    pstmt.setString(3, datallot);
		    pstmt.setString(4,NameofBook );
			pstmt.setString(5, Typeofbook);
			
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
