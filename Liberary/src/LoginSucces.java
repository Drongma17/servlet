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


public class LoginSucces extends HttpServlet {
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException
	{
		
		
		RequestDispatcher dispatcher=null;
		
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet res=null;
		
		
		String usn=null;
		String name=null;
		String isadmin=null;
		String password = null;
		
			resp.setContentType("text/html");
		   PrintWriter out=resp.getWriter();
		   
		
		
		name=req.getParameter("name");
		password=req.getParameter("password");
		
	
	
		try {
			
			Driver dr=new Driver();
			
			DriverManager.registerDriver(dr);
			
			
			String dburl="jdbc:mysql://localhost:3306/liberary?user=root&password=root";
			
			
			con=DriverManager.getConnection(dburl);
			
			
			String qur=" select isAdmin,Name,Usn from student_info where Name=? and password=? ";
			
			pstmt=con.prepareStatement(qur);
			pstmt.setString(1,name);
			pstmt.setString(2,password);
			
			res=pstmt.executeQuery();
			
			
			
			
			if(res.next())
			{
				
				isadmin=res.getString("isAdmin");
				
				if(isadmin.equals("Y"))
				{
					
					dispatcher=req.getRequestDispatcher("Header2.html");
					dispatcher.include(req, resp);
					

			        
			        out.println("<html>");
			        out.println("<body>");
			        
			        out.println("<br>");
			        
			        out.println("</br>");
			        out.println("<br>");
			        
			        
			        
			        out.println("</br>");		
			        
			        
			        out.println("<h2><center>---Welocome to Admin---</center></h1>");
			       
			        out.println("</body>");
			        
			        out.println("</html>");
			        
					
					
					dispatcher=req.getRequestDispatcher("AdminView.html");
					dispatcher.include(req, resp);
					
					

			        
			        out.println("<html>");
			        out.println("<body>");
			        
			        out.println("<br>");
			        
			        out.println("</br>");
			        out.println("<br>");
			        
			        out.println("</br>");
			        
			        out.println("</body>");
			        
			        out.println("</html>");
			        
			       
					
			        
					
				}
				
				
				else
				{
					
					dispatcher=req.getRequestDispatcher("Header2.html");
					dispatcher.include(req, resp);
					
					String name1=res.getString("Name");
					usn=res.getString("Usn");

			        
			        out.println("<html>");
			        out.println("<body>");
			        
			        out.println("<br>");
			        
			        out.println("</br>");
			        out.println("<br>");
			        
			        
			        
			        out.println("</br>");		
			        
			        
			        out.println("<h2><center>---Welocome to  " +name1+ "---</center></h1>");
			       
			        out.println("</body>");
			        
			        out.println("</html>");
			        
			        
			        ServletContext context=getServletContext();
			        context.setAttribute("cusn",usn);
					
					dispatcher=req.getRequestDispatcher("StudentView.html");
					dispatcher.include(req, resp);
					
					

			        
			        out.println("<html>");
			        out.println("<body>");
			        
			        out.println("<br>");
			        
			        out.println("</br>");
			        out.println("<br>");
			        
			        out.println("</br>");
			        
			        out.println("</body>");
			        
			        out.println("</html>");
			        
			       
					
				
				
				
				}
				
				
				
				
			}
			
			
			else
			{
				
				dispatcher=req.getRequestDispatcher("Header1.html");
				dispatcher.include(req, resp);
				

		        
		        out.println("<html>");
		        out.println("<body>");
		        
		        out.println("<br>");
		        
		        out.println("</br>");
		        out.println("<br>");
		        
		        dispatcher=req.getRequestDispatcher("Login.html");
				dispatcher.include(req, resp);
		        out.println("</br>");
		        out.println("<h><center>User name or Password worng</center></h1>");
		        
		        out.println("</br>");
		        
		        out.println("</body>");
		        
		        out.println("</html>");
			}
				
				
				
			
			
			
			
		} catch (SQLException e) {
		
				
				dispatcher=req.getRequestDispatcher("Header1.html");
				dispatcher.include(req, resp);
				

		        
		        out.println("<html>");
		        out.println("<body>");
		        
		        out.println("<br>");
		        
		        out.println("</br>");
		        out.println("<br>");
		        
		        
		        out.println("<h1>");
		        out.println("SQl error.......");
		        out.println("</h1>");
		        out.println("</br>");
		        
		        out.println("</body>");
		        
		        out.println("</html>");
		        
				
				
				
				

		        
		        out.println("<html>");
		        out.println("<body>");
		        
		        out.println("<br>");
		        
		        out.println("</br>");
		        out.println("<br>");
		        
		        out.println("</br>");
		        
		        out.println("</body>");
		        
		        out.println("</html>");
		        
		     
				
			
			e.printStackTrace();
		}
		
		finally
		{
			try {
				
				if(con!=null)
				{
				con.close();
				}
				 else if(pstmt!=null)
				{
					pstmt.close();
				}
				
				 else if(res!=null)
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
