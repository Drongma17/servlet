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

public class AddBookToTable extends HttpServlet{
  @Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
	
	  resp.setContentType("text/html");
	  PrintWriter out=resp.getWriter();
	  
	  RequestDispatcher dispatcher =req.getRequestDispatcher("Header.html2");
	  dispatcher.include(req, resp);
	  Connection con=null;
	  PreparedStatement pstmt=null;
	  

		int bookid=0;
		String bookName=null;
		String author=null;
		String yop=null;
		String Availability="Y";
		
		
	    bookid=Integer.parseInt(req.getParameter("book_id"));
	    bookName=req.getParameter("bookName");
	    author=req.getParameter("author");
	    yop=req.getParameter("yop");
	    
	    
	    try {
			Driver drif = new Driver();
			DriverManager.registerDriver(drif);
			String dburl="jdbc:mysql://localhost:3306/library?user=root&password=root";
			con=DriverManager.getConnection(dburl);
			
			con.setAutoCommit(false);
			String sql="insert into book_info values(?,?,?,?,?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, bookid);
			pstmt.setString(2, bookName);
			pstmt.setString(3, author);
			pstmt.setString(4, yop);
			pstmt.setString(5, Availability);
			
			int Count=pstmt.executeUpdate();
			
			if(Count !=0)
			{
				
				RequestDispatcher disp=req.getRequestDispatcher("Header1.html");
				disp.include(req, resp);
				con.commit();
				out.println("<html>");
				out.println("<body>");
				out.println("<br>");
				out.println("</br>");
				out.println("<br>");
				out.println("</br>");
				out.println("<br>");
				out.println("</br>");
				out.println("<br>");
				out.println("<h2><center>Book is added successfully !!!!!.... </center></h2>");
				out.println("<br>");
				out.println("</br>");
				out.println("<br>");
				out.println("</br>"); 
				out.println("</html>");
				out.println("</body>");
			}
			
			else
			{
				out.println("<html>");
				out.println("<body>");
				out.println("<br>");
				out.println("</br>");
				out.println("<br>");
				out.println("</br>");
				out.println("<h2><center> </center></h2>");
				out.println("<br>");
				out.println("</br>");
				out.println("</body>");
				out.println("</html>");
			}
		} catch (SQLException e) {
			
			out.println("<html>");
			out.println("<body>");
			out.println("<br>");
			out.println("</br>");
			out.println("<br>");
			out.println("</br>");
			out.println("<h2><center>Book id is already present!!!!!....</center></h2>");
			out.println("<br>");
			out.println("</br>");
			out.println("</body>");
			out.println("</html>");
			e.printStackTrace();
			
			try{
				con.rollback();
			}catch(SQLException eq)
			{
				eq.printStackTrace();
			}
			
			finally
			{
				try {
						if(con!=null)
						{
						con.close();
						}

						else if(pstmt !=null)
						{
							pstmt.close();
						}
						
						
						
					} catch (SQLException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
				
				}
			
			
			
			dispatcher=req.getRequestDispatcher("Footer.html");
			dispatcher.include(req, resp);
			
		}
    }
}
