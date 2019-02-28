


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Driver;


public class StudentCreationProfile extends HttpServlet{

	
	private static final long serialVersionUID =1L;
	RequestDispatcher dispatcher=null;
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException
			
	{
		
			resp.setContentType("text/html");
		   PrintWriter out=resp.getWriter();
		
		   String firstname=null;
		String middlename=null;
		String lastname=null;
		String gfirstname=null;
		String gmiddlename=null;
		String glastname=null;
		String isadmin=null;
		String password = null;
		
		
		String regno1=req.getParameter("regNo");
		int regno=Integer.parseInt(regno1);
		firstname=req.getParameter("fname");
		middlename=req.getParameter("mname");
		lastname=req.getParameter("lname");
		 gfirstname=req.getParameter("gfname");
		 gmiddlename=req.getParameter("gmname");
		 glastname=req.getParameter("glname");
		 isadmin=req.getParameter("admin");
		 password=req.getParameter("password");
		 


		 dispatcher=req.getRequestDispatcher("Header.html");
		        dispatcher.include(req,resp);
		        
		        
		      
	
		
		
		
		
		Connection con=null;
		PreparedStatement pstmt1 = null,pstmt2 = null,pstmt3=null;
		
		int count1,count2,count3=0;
		
		try {
			
			//1.
			Driver dr= new Driver();
			DriverManager.registerDriver(dr);
			
			//2.
			String dburl="jdbc:mysql://localhost:3306/bece5_db?user=root&password=root";
			con=DriverManager.getConnection(dburl);
			
			con.setAutoCommit(false);
			
			//3.
			//here only both value checking
			String query1 =" insert into student_info "
							+" values (?,?,?,?) ";
			String query2 =" insert into guardian_info "
					+" values (?,?,?,?) ";
			String query3=" insert into student_otherinfo "
					+" values (?,?,?) ";
			
		
			
			pstmt1=con.prepareStatement(query1);
			
			pstmt1.setInt(1, regno);
			pstmt1.setString(2,firstname );
			pstmt1.setString(3,middlename);
			pstmt1.setString(4,lastname);
			
		
			pstmt2=con.prepareStatement(query2);
			
			pstmt2.setInt(1,regno);
			pstmt2.setString(2,gfirstname);
			pstmt2.setString(3,gmiddlename);
			pstmt2.setString(4, glastname);
			
		
			pstmt3=con.prepareStatement(query3);
			 
			pstmt3.setInt(1,regno);
			pstmt3.setString(2,isadmin);
			pstmt3.setString(3,password);
			
			count1=pstmt1.executeUpdate();
			count2=pstmt2.executeUpdate();
			count3=pstmt3.executeUpdate();
			
			
			
			if(count1!=0 && count2!=0 && count3!=0)
			{
				
				con.commit();
			/*	regno2=rs.getInt("regno");
				 firstname=rs.getString("firstname");
				 middlename=rs.getString("middlename");
				 lastname=rs.getString("lastname");
				
				 gfirstname=rs.getString("gfirstname");
				 gmiddlename=rs.getString("gmiddlename");
				 glastname=rs.getString("glastname");
				
				 isadmin=rs.getString("isadmin");
				 password=rs.getString("password");
				 String htmlres="<html>"+
							"<body>"+
							"<h>"+
							"Student regno="+regno2+"<br>"+
							"Student First Name="+firstname+"<br>"+
							"Student Middle Name="+middlename+"<br>"+
							"Student Last Name="+lastname+"<br>"+
							"Guardian First Name="+gfirstname+"<br>"+
							"Guardian Middle Name="+gmiddlename+"<br>"+
							"Guardian Last Name="+glastname+"<br>"+
							"iadmin="+isadmin+"<br>"+
							"Password="+password+"<br>"+ 
							"</h>"+
							"</body>"+
							"</html>";
			
			
			resp.setContentType("html");
			PrintWriter out=resp.getWriter();
			out.print(htmlres);*/
				
				
				String htmlres="<html>"+
						"<body>"+
						"<br>"+
						"<br>"+
						"<br>"+
						"<br>"+
						"<br>"+
						"<br>"+
						"<br>"+
						"<h>"+"Wow....!!!Successfull created profile"+
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
				String htmlres="<html>"+
						"<body>"+
						"<br>"+
						"<br>"+
						"<br>"+
						"<br>"+
						"<br>"+
						"<br>"+
						"<br>"+
						"<h>"+"Profile is not created"+
						
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
						"<h>"+"Reg.No already exists....!!!!"+
						"</h>"+
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
					else if(pstmt2 !=null)
					{
						pstmt2.close();
					}
					else if(pstmt3!=null)
					{
						pstmt3.close();
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
