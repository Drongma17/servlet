import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Driver;


public class StudentView  extends HttpServlet
{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException 
			
	{
		
		
		RequestDispatcher dispatcher=null;
		Connection con =null;
		PreparedStatement pstmt=null;
		ResultSet res=null;
		
		
		String usn=null;
		String name=null;
		String branch=null;
		String semister=null;
		String contactNo=null;
		String address=null;
		String isAdmin=null;
		String password=null;
		
		
				
		
			resp.setContentType("text/html");
			PrintWriter out=resp.getWriter();
			dispatcher=req.getRequestDispatcher("Header2.html");
			dispatcher.include(req, resp);
			
			try {
				
				Driver dr=new Driver();
				DriverManager.registerDriver(dr);
				
				String dburl="jdbc:mysql://localhost:3306/liberary?user=root&password=root";
				con=DriverManager.getConnection(dburl);
				
				
				String qury="select * from student_info where usn=?";
				
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
				out.println("margin-left:300px;");
				out.println("width:200px;");
				out.println("background-color: burlywood;");
				out.println("}");
				
				out.println(".image{");

				out.println("margin-left:10px");

				out.println("margin-top:100px");

				out.println("}");
				
				out.println("</style>");
				out.println("<body>");
				out.println("<br>");
				out.println("</br>");
				out.println("<br>");
				out.println("</br>");
				out.println("<br>");
				out.println("</br>");
				out.println("<h2><center>----- it is"+name+" registration information--- </center></h2>");
				out.println("<table class=\"t\" border =\"5\">");
				out.println("<tr><td>");
				out.println("Usn");
				out.println("</td>");
				
				
				
				out.println("<div class=\"image\"><img src =\"020.jpg\" width=\"200px\" height= \"200px\" />");
				
				
				out.println("<td>");
				out.println("Name");
				out.println("</td>");
				
				out.println("<td>");
				out.println("Branch");
				out.println("</td>");
				
				out.println("<td>");
				out.println("Semister");
				out.println("</td>");
				out.println("<td>");
				out.println("ContactNo");
				out.println("</td>");
				
				out.println("<td>");
				out.println("Address");
				out.println("</td>");
				
				out.println("<td>");
				out.println("isAdmin");
				out.println("</td>");
				
				out.println("<td>");
				out.println("Password");
				out.println("</td></tr>");
				
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
					
					usn=res.getString("usn");
					name=res.getString("Name");
					branch=res.getString("Brach");
					semister=res.getString("semister");
					contactNo=res.getString("ContactNo");
					address=res.getString("Address");
					isAdmin=res.getString("isAdmin");
					password=res.getString("password");
					
					
					
					out.println("<tr>");
					
					out.println("<td>"+usn);
					
					out.println("</td>");
					out.println("<td>"+name);
					out.println("</td>");
				
					out.println("<td>"+branch);
					out.println("</td>");
					
					out.println("<td>"+semister);
					out.println("</td>");
					
					
					out.println("<td>"+contactNo);
					out.println("</td>");
					
					out.println("<td>"+address);
					out.println("</td>");
					
					out.println("<td>"+isAdmin);
					out.println("</td>");
					
					out.println("<td>"+password);
					out.println("</td></tr>");
					
					out.println("</table>");
					out.println("</body>");
					out.println("</html>");
							
					
					
				}
				
				else
				{
					 out.println("<html>");
				        out.println("<body>");
				        
				        out.println("<br>");
				        
				        out.println("</br>");
				        out.println("<br>");
				        
				        
				        
				        out.println("</br>");		
				        
				        
				        out.println("<h2><center>Error data ....</center></h1>");
				       
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
