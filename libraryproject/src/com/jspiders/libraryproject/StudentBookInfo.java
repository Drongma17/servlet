package com.jspiders.libraryproject;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Driver;


public class StudentBookInfo extends HttpServlet
{

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException
	{
		
		RequestDispatcher dispatcher=null;
		Connection con =null;
		PreparedStatement pstmt=null ,pstmt2=null;
		ResultSet res=null,res2=null;
		
		
		int Book_Id;
		String Usn=null;
		String Doa=null;
		String Dor=null;
		String Book_Type=null;
		
		String Book_Name=null;
		String Author=null;
		String Yop=null;
		
		String Name=null;
			
		
			resp.setContentType("text/html");
			PrintWriter out=resp.getWriter();
			dispatcher=req.getRequestDispatcher("Header1.html");
			dispatcher.include(req, resp);
			
			
			try {
				
				Driver dr=new Driver();
				DriverManager.registerDriver(dr);
				
				String dburl="jdbc:mysql://localhost:3306/library?user=root&password=root";
				con=DriverManager.getConnection(dburl);
				
				
				String qury="select * from allot_books where usn=?";
				
				pstmt=con.prepareStatement(qury);
				
				ServletContext context=getServletContext();
				String cusn=(String)context.getAttribute("cusn");
				
				pstmt.setString(1,cusn);
				
				res=pstmt.executeQuery();
				
				
				out.println("<html>");
				out.println("<head>");
				out.println("<style type =\"text/css\">");
				out.println(".t{");
				out.println("margin-top:200px;");
				out.println("margin-left:200px;");
				out.println("width:400px;");
				out.println("background-color: burlywood;");
				out.println("}");
				out.println("</style>");
				out.println("<body>");
				out.println("<br>");
				out.println("</br>");
				out.println("<br>");
				out.println("</br>");
				out.println("<h2><center>U have this many book in account</center></h2>");
				out.println("<table class=\"t\" border =\"5\">");
				
				out.println("<tr><td>");
				out.println("usn");
				out.println("</td>");
				
				out.println("<td>");
				out.println("book_id");
				out.println("</td>");
				
				out.println("<td>");
				out.println("bookname");
				out.println("</td>");
				
				out.println("<td>");
				out.println("author");
				out.println("</td>");
				
				out.println("<td>");
				out.println("year_of_publication");
				out.println("</td>");
				
				out.println("<td>");
				out.println("Date_of_allot");
				out.println("</td>");
				
				out.println("<td>");
				out.println("date_of_receive");
				out.println("</td>");
				
				out.println("<td>");
				out.println("book_type");
				out.println("</td>");
				
				
				
				out.println("<tr>");
				out.println("<td>");
				
				out.println("<hr>");
				out.println("</hr>");
				
				out.println("</td>");
				out.println("<td>");
				
				out.println("<hr>");
				out.println("</hr>");
				
				out.println("</td>");
				out.println("<td>");
				
				out.println("<hr>");
				out.println("</hr>");
				
				out.println("</td>");
				out.println("<td>");
				
				out.println("<hr>");
				out.println("</hr>");
				
				out.println("</td>");
				out.println("<td>");
				
				out.println("<hr>");
				out.println("</hr>");
				
				out.println("</td>");
				out.println("<td>");
				
				out.println("<hr>");
				out.println("</hr>");
				
				out.println("</td>");
				out.println("<td>");
				
				out.println("<hr>");
				out.println("</hr>");
				
				out.println("</td>");
				out.println("<td>");
				
				out.println("<hr>");
				out.println("</hr>");
				
				out.println("</td>");
				out.println("</tr>");
				
				
				if(res.next())
				{
					
					Book_Id=res.getInt(Integer.parseInt("book_id"));
					Usn=res.getString("usn");
					Book_Type=res.getString("book_type");
					Doa=res.getString("date_of_allot");
					Dor=res.getString("date_of_receive");
					
					String qury1="select * from book_info where book_id=?";
					
					pstmt2=con.prepareStatement(qury1);
					
					pstmt2.setInt(1,Book_Id);
					
					res2=pstmt2.executeQuery();
					
					if(res2.next())
					{	
					
					Book_Name=res2.getString("book_name");
					Author=res2.getString("author");
					Yop=res2.getString("year_of_publication");
				
					
					
					
					out.println("<tr>");
					
					out.println("<td>"+Usn);
					
					out.println("</td>");
					out.println("<td>"+Book_Id);
					out.println("</td>");
				
					out.println("<td>"+Book_Name);
					out.println("</td>");
					
					out.println("<td>"+Author);
					out.println("</td>");
					
					
					out.println("<td>"+Yop);
					out.println("</td>");
					
					out.println("<td>"+Doa);
					out.println("</td>");
					
					out.println("<td>"+Dor);
					out.println("</td>");
					
					out.println("<td>"+Book_Type);
					out.println("</td></tr>");
					
					out.println("</table>");
					out.println("</body>");
					out.println("</html>");
								
					}	
					
					
				}
				
				else
				{
					 out.println("<html>");
				        out.println("<body>");
				        
				        out.println("<br>");
				        
				        out.println("</br>");
				        out.println("<br>");
				        
				        
				        
				        out.println("</br>");		
				        
				        
				        out.println("<h2><center>NO....Book ....</center></h1>");
				       
				        out.println("</body>");
				        
				        out.println("</html>");
					
					
					
				}
				
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

				out.println("<html>");
				out.println("<body>");
				out.println("SQl");
				
				
				out.println("</body>");
				out.println("</html>");
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
						else if(pstmt2 !=null)
						{
							pstmt2.close();
						}
						else if (res!=null)
						{
							res.close();
						}
						else if (res2!=null)
						{
							res2.close();
						}
						
						
					} catch (SQLException e) {
						
						e.printStackTrace();
					}
				
				
			}
			
			
			dispatcher=req.getRequestDispatcher("Footer.html");
			dispatcher.include(req, resp);
		
	}
}
