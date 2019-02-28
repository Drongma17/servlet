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


public class Registration extends HttpServlet{
	
	
	
	private static final long serialVersionUID =1L;
	RequestDispatcher dispatcher=null;
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException
			
	{
		
			resp.setContentType("text/html");
		   PrintWriter out=resp.getWriter();
		
		   String usn=null;
		   String name=null;
	
		String contactNo=null;
		String branch=null;
		String sem=null;
		String address=null;
		String isadmin=null;
		String password = null;
		
		
		 usn=req.getParameter("usn");

		name=req.getParameter("name");
		branch=req.getParameter("branch");
		sem=req.getParameter("sem");
		 contactNo=req.getParameter("contactNo");
		 address=req.getParameter("address");
		
		 isadmin="N";
		 password=req.getParameter("password");
		 


		        
		        
		      
	
		
		
		
		
		Connection con=null;
		PreparedStatement pstmt1 = null,pstmt2 = null,pstmt3=null;
		
		int count1,count2,count3=0;
		
		try {
			
			//1.
			Driver dr= new Driver();
			DriverManager.registerDriver(dr);
			
			//2.
			String dburl="jdbc:mysql://localhost:3306/Liberary?user=root&password=root";
			con=DriverManager.getConnection(dburl);
			
			con.setAutoCommit(false);
			
			//3.
			//here only both value checking
			String query =" insert into student_info "
							+" values (?,?,?,?,?,?,?,?) ";
			
		
			
			pstmt1=con.prepareStatement(query);
			
			pstmt1.setString(1, usn);
			pstmt1.setString(2,name);
			pstmt1.setString(3,branch);
			pstmt1.setString(4,sem);
			pstmt1.setString(5,contactNo);
			pstmt1.setString(6,address);
			pstmt1.setString(7,isadmin);
			pstmt1.setString(8,password);
			
			
		
		
				
		int	count=pstmt1.executeUpdate();
		
			
			
			
			if(count>0)
			{
				
				con.commit();
				

				 dispatcher=req.getRequestDispatcher("Header1.html");
				        dispatcher.include(req,resp);
			
				
				String htmlres="<html>"+
						"<body>"+
						"<br>"+
						"<br>"+
						"<br>"+
						"<br>"+
						"<br>"+
						"<br>"+
						"<br>"+
						"<h>"+"Wow....!!!Registration is Successfull "+
						"<br>"+
						"<br>"+
						"<br>"+
						"<br>"+
						"<br>"+
						"<br>"+
						"<br>"+
						
						"</h>"+
						"</body>"+
						"</html>";
		
		
		
		out.print(htmlres);
				
				
				
				
			}
			
			else
			{
				

				 dispatcher=req.getRequestDispatcher("Header1.html");
				        dispatcher.include(req,resp);
				String htmlres="<html>"+
						"<body>"+
						"<br>"+
						"<br>"+
						"<br>"+
						"<br>"+
						"<br>"+
						"<br>"+
						"<br>"+
						"<h>"+"Registeration is faild!!!!!!!!"+
						
						"</h>"+
						"</body>"+
						"</html>";
		
		
		
				out.print(htmlres);
			
			
			
			}
			}
			
		
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {

				

				 dispatcher=req.getRequestDispatcher("Header1.html");
				        dispatcher.include(req,resp);
				String htmlres="<html>"+
						"<body>"+
						"<br>"+
						"<br>"+
						"<br>"+
						"<br>"+
						"<br>"+
						"<br>"+
						"<br>"+
						"<h>"+"Profile is not created ....!!!!"+
						"<br>"+
						"<h>"+"plz Enter all field"+
						"<br>"+
						"<h>"+"Or"+
						"<br>"+
						
						"<br>"+
						"<br>"+
						"<br>"+
						"<br>"+
						"<br>"+
						"<br>"+
						"<br>"+
						
						
						"</body>"+
						"</html>";
				out.print(htmlres);
				con.rollback();//do not execute catch table data and destroy it.
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				System.err.println("Unbale to create the Profile !!!");
				out.println("Unbale to create the Profile !!!");
				e1.printStackTrace();
			}
		}
		finally
		{
			try {
					if(con!=null)
					{
					con.close();
					}

					else if(pstmt1 !=null)
					{
						pstmt1.close();
					}
					
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			
			
		
		
			
		
	}
		
		
		
		
		dispatcher=req.getRequestDispatcher("Footer.html");
        dispatcher.include(req,resp);
				
	
	}

}

