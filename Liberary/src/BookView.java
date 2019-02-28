import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Driver;


public class BookView extends HttpServlet

{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException
	{
	
		
		RequestDispatcher dispatcher=null;
		Connection con =null;
		Statement stmt=null;
		ResultSet res=null;
		
		
	
		
		String bookId=null;
		String bookName=null;
		String author=null;
		String yop=null;
		String availablity=null;
		
		
				
		
			resp.setContentType("text/html");
			PrintWriter out=resp.getWriter();
			
			dispatcher=req.getRequestDispatcher("Header2.html");
			dispatcher.include(req, resp);
			
			
			try {
				
				Driver dr=new Driver();
				DriverManager.registerDriver(dr);
				
				//Class.forName("com.mysql.jdbc.Driver").newInstance();---one more way two load the drive
				
				String dburl="jdbc:mysql://localhost:3306/liberary?user=root&password=root";
				con=DriverManager.getConnection(dburl);
				
				
				String qury="select * from book_info";
				
				stmt=con.createStatement();
				
				res=stmt.executeQuery(qury);
				
				
				out.println("<html>");
				out.println("<head>");
				out.println("<style type =\"text/css\">");
				out.println(".t{");
				out.println("margin-top:100px;");
				out.println("margin-left:350px;"); 
				//out.println("padding-left:50px;");
				out.println("width:300px;");
				out.println("background-color: burlywood;");
				out.println("}");
				out.println("</style>");
				out.println("<body>");
				
				out.println("<br>");
				out.println("</br>");
				out.println("<br>");
				out.println("</br>");
				
				out.println("<h2><center>-----All Book info--------</center></h2>");
				out.println("<table class=\"t\" border =\"5\">");
				out.println("<tr><td>");
				out.println("Book Id");
				out.println("</td>");
				
				out.println("<td>");
				out.println("Book Name");
				out.println("</td>");
				
				out.println("<td>");
				out.println("Author");
				out.println("</td>");
				
				out.println("<td>");
				out.println("Year of Publication");
				out.println("</td>");
				
				
				out.println("<td>");
				out.println("Availability");
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
				
				out.println("</tr>");
				
				
				while(res.next())
				{
					
					bookId=res.getString("Book_id");
					bookName=res.getString("Book_Name");
					author=res.getString("Author");
					yop=res.getString("Year_of_Publication");
					availablity=res.getString("Availability");
					
					
					
					
					out.println("<tr>");
					
					out.println("<td>"+bookId);
					
					out.println("</td>");
					out.println("<td>"+bookName);
					out.println("</td>");
				
					out.println("<td>"+author);
					out.println("</td>");
					
					out.println("<td>"+yop);
					out.println("</td>");
					
					
					out.println("<td>"+availablity);
					out.println("</td>");
					
								
				}
				
				
				out.println("</td></tr>");
				out.println("</table>");
				out.println("</body>");
				out.println("</html>");
				
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

				out.println("<html>");
				out.println("<body>");
				out.println("oooooo");
				
				
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

						else if(stmt !=null)
						{
							stmt.close();
						}
						else if (res!=null)
						{
							res.close();
						}
						
						
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
				
			}
			
			
			
			
			dispatcher=req.getRequestDispatcher("Footer.html");
			dispatcher.include(req, resp);
			
			
			
		
	}
	
	
}
