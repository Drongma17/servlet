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
		
		
		int book_id;
		String usn=null;
		String doa=null;
		String dor=null;
		String book_type=null;
		
		String book_name=null;
		String author=null;
		String yop=null;
		
		String name=null;
			
		
			resp.setContentType("text/html");
			PrintWriter out=resp.getWriter();
			dispatcher=req.getRequestDispatcher("Header2.html");
			dispatcher.include(req, resp);
			
			
			try {
				
				Driver dr=new Driver();
				DriverManager.registerDriver(dr);
				
				String dburl="jdbc:mysql://localhost:3306/liberary?user=root&password=root";
				con=DriverManager.getConnection(dburl);
				
				
				String qury="select * from allot_book where Usn=?";
				
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
				out.println("Usn");
				out.println("</td>");
				
				out.println("<td>");
				out.println("Book_Id");
				out.println("</td>");
				
				out.println("<td>");
				out.println("BookName");
				out.println("</td>");
				
				out.println("<td>");
				out.println("Author");
				out.println("</td>");
				
				out.println("<td>");
				out.println("Year_of_publication");
				out.println("</td>");
				
				out.println("<td>");
				out.println("Date_of_Allot");
				out.println("</td>");
				
				out.println("<td>");
				out.println("Date_of_Receive");
				out.println("</td>");
				
				out.println("<td>");
				out.println("Book_Type");
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
					
					book_id=res.getInt("Book_id");
					usn=res.getString("Usn");
					book_type=res.getString("Book_type");
					doa=res.getString("Date_of_Allot");
					dor=res.getString("Date_of_Receive");
					
					String qury1="select * from book_info where Book_id=?";
					
					pstmt2=con.prepareStatement(qury1);
					
					pstmt2.setInt(1,book_id);
					
					res2=pstmt2.executeQuery();
					
					if(res2.next())
					{	
					
					book_name=res2.getString("Book_Name");
					author=res2.getString("Author");
					yop=res2.getString("Year_of_Publication");
				
					
					
					
					out.println("<tr>");
					
					out.println("<td>"+usn);
					
					out.println("</td>");
					out.println("<td>"+book_id);
					out.println("</td>");
				
					out.println("<td>"+book_name);
					out.println("</td>");
					
					out.println("<td>"+author);
					out.println("</td>");
					
					
					out.println("<td>"+yop);
					out.println("</td>");
					
					out.println("<td>"+doa);
					out.println("</td>");
					
					out.println("<td>"+dor);
					out.println("</td>");
					
					out.println("<td>"+book_type);
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
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
				
			}
			
			
			dispatcher=req.getRequestDispatcher("Footer.html");
			dispatcher.include(req, resp);
		
	}
}
