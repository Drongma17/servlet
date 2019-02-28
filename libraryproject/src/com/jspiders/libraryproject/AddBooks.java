package com.jspiders.libraryproject;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Driver;

public class AddBooks extends HttpServlet
{  
	@Override
	protected void doPost(HttpServletRequest req,
			HttpServletResponse resp)
			throws ServletException, IOException {
		
		Connection con=null; 
		PreparedStatement pstmt=null;
		
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		
		
		out.println("<html>");
		out.println("<body>");
		out.println("<br>");
		out.println("</br>");
		out.println("<br>");
		out.println("</br>");
		out.println("<br>");
		out.println("</br>");
		out.println("<br>");
		out.println("</br>");
		out.println("<br>");
		out.println("</br>");
		out.println("<br>");
		out.println("</br>");
		out.println("<h1> Hello Every One </h>");
		out.println("/body");
		out.println("</html>");
		
		
		RequestDispatcher dispatcher=req.getRequestDispatcher("Header2.html");
		dispatcher.include(req, resp);
	
		String bookId =req.getParameter("book_id");
		String bookName =req.getParameter("bookName");
		String Author =req.getParameter("author");
		String yearofpub = req.getParameter("yop");
		String availability =req.getParameter("availability");
		
		
		try {
			Driver drif=new Driver();

		DriverManager.registerDriver(drif);
		
		String dburl ="jdbc:mysql://localhost:3306/library?user=root&password=root";
		
		con=DriverManager.getConnection(dburl);
		
		String sql="insert into book_info values(?,?,?,?,?)";
		
		pstmt=con.prepareStatement(sql);
		pstmt.setInt(1, Integer.parseInt(bookId));
		pstmt.setString(2, bookName);
		pstmt.setString(3, Author);
		pstmt.setString(4, yearofpub);
		pstmt.setString(5, availability);
			
		int count=pstmt.executeUpdate();
		
		
		
		out.println("<html>");
		out.println("<body>");
		out.println("<br>");
		out.println("</br>");
		out.println("<br>");
		out.println("</br>");
		out.println("<br>");
		out.println("</br>");
		out.println("/body");
		out.println("</html>");
		
		if(count !=0)
		{
			  RequestDispatcher dispatcher1=req.getRequestDispatcher("Footer.html");
			  dispatcher1.forward(req, resp);
					
		}
		} catch (SQLException e) {
			
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
			
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
       }
	}
   

