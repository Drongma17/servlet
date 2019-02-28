import java.io.IOException;
import java.io.PrintWriter;
import java.nio.channels.SeekableByteChannel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.Driver;


public class Loginpage extends HttpServlet {
	
	private static final long serialVersionUID =1L;
	RequestDispatcher dispatcher=null;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException
			
	{
		
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		HttpSession session=null;
		
		String firstname=null;
		String middlename=null;
		String lastname=null;
		String gfirstname=null;
		String gmiddlename=null;
		String glastname=null;
		String isadmin=null;
		String password = null;
		int regno2 = 0;
		
		
		
		resp.setContentType("html");
		PrintWriter out=resp.getWriter();
		
		
		
        String regno1=req.getParameter("regNo");
		int regno=Integer.parseInt(regno1);
		String password1=req.getParameter("password");
		String remember=req.getParameter("remember");
		
		
		
		
		try {
			
			//1.
			Driver dr= new Driver();
			DriverManager.registerDriver(dr);
			
			//2.
			String dburl="jdbc:mysql://localhost:3306/bece5_db?user=root&password=root";
			con=DriverManager.getConnection(dburl);
			
			//3.
			//here only both value checking
			String query=" select * from student_info as a, "
					+" student_otherinfo as b,"
					+" guardian_info as c "
					+" where a.regno =b.regno and c.regno=b.regno and b.regno=?  and b.password=?";
			
			pstmt=con.prepareStatement(query);
			
			pstmt.setInt(1, regno);
			pstmt.setString(2, password1);
			rs=pstmt.executeQuery();
			
				if(rs.next())
			{			
					
					Cookie uregno=new Cookie("uregno", ""+regno);
					Cookie upassword=new Cookie("upassword", ""+password1);
					
					uregno.setMaxAge(24*60);
					upassword.setMaxAge(24*60);
					
				if(remember!=null)
				{	
					resp.addCookie(uregno);
					resp.addCookie(upassword);
					uregno.setMaxAge(24*60);
					upassword.setMaxAge(24*60);
					
				}
				
					session=req.getSession(true);
					session.setMaxInactiveInterval(7*24*60*60);
					
					if(session!=null)
					{
						
					
					
					dispatcher = req.getRequestDispatcher("Header2.html");
			        dispatcher.include(req,resp);
					}
				
					String htmlres3="<html>"+
							"<body>"+
							"<h>"+"Successful login "+
							
							"</h>"+
							"</body>"+
							"</html>";
					out.print(htmlres3);
			
					
				regno=rs.getInt("regno");
				 firstname=rs.getString("firstname");
				 middlename=rs.getString("middlename");
				 lastname=rs.getString("lastname");
				
				 gfirstname=rs.getString("gfirstname");
				 gmiddlename=rs.getString("gmiddlename");
				 glastname=rs.getString("glastname");
				
				 isadmin=rs.getString("isadmin");
				 password=rs.getString("password");
				
				 if(isadmin.equals("Y"))
				 {
					 /*String htmlres1="<html>"+
							"<body>"+
							
							"<a href="+
							"http://localhost:8080/ClassAssignment/EditStudentinfo.html"+
							">"+
							"EditProfile"+
							"</a>"+
							"<br>"+
							"<br>";
						
						out.print(htmlres1);*/
						
						String htmlres2="<html>"+
								"<body>"+
								
								"<a href="+
								"http://localhost:8080/ClassAssignment/view"+
								">"+
								"ViewAllData"+
								"</a>"+
								"<br>"+
								"<br>";
							
							out.print(htmlres2);
							
							
					 

					
						 String htmlres="<html>"+
									"<body>"+
									"<table>"+
									"<tr>"+
									"<td>s"+
									"Student regno</td>"+
									"<td> Student First Name </td>" +
									"<td> Student Middle Name </td>"+
									"<td> Student Last Name </td>"+
									"<td> Guardian First Name </td>"+
									"<td> Guardian Middle Name </td>"+
									"<td> Guardian Last Name </td>"+
									"<td> iadmin</td>"+
									"<td> Password</td>"+
									"</td>"+
									"</tr>"+
									
									
									"<tr>"+
									"<td>"+regno+"</td>"+
									"<td>"+firstname+"</td>"+
									"<td>"+middlename+"</td>"+
									"<td>"+lastname+"</td>"+
									"<td>"+gfirstname+"</td>"+
									"<td>"+gmiddlename+"</td>"+
									"<td>"+glastname+"</td>"+
									"<td>"+isadmin+"</td>"+
									"<td>"+password+"</td>"+
									"</tr>"+
									"<br>"+
									"<br>"+
									"<br>"+
									"<br>"+
									
									"</body>"+
									"</html>";
					
					
					
					out.print(htmlres);
					
				 }
				 
				 else
				 {

						
						regno=rs.getInt("regno");
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
									"<table>"+
									"<tr>"+
									"<td>s"+
									"Student regno</td>"+
									"<td> Student First Name </td>" +
									"<td> Student Middle Name </td>"+
									"<td> Student Last Name </td>"+
									"<td> Guardian First Name </td>"+
									"<td> Guardian Middle Name </td>"+
									"<td> Guardian Last Name </td>"+
									"<td> iadmin</td>"+
									"<td> Password</td>"+
									"</td>"+
									"</tr>"+
									
									
									"<tr>"+
									"<td>"+regno+"</td>"+
									"<td>"+firstname+"</td>"+
									"<td>"+middlename+"</td>"+
									"<td>"+lastname+"</td>"+
									"<td>"+gfirstname+"</td>"+
									"<td>"+gmiddlename+"</td>"+
									"<td>"+glastname+"</td>"+
									"<td>"+isadmin+"</td>"+
									"<td>"+password+"</td>"+
									"</tr>"+
									"<br>"+
									"<br>"+
									"<br>"+
									"<br>"+
									
									"</body>"+
									"</html>";
					
					
					
					out.print(htmlres);
					
				 }
					 
			}
			
			else
			{
				
				
					dispatcher = req.getRequestDispatcher("Header.html");
			        dispatcher.include(req,resp);
			        
			        
			
		        
				String htmlres="<html>"+
						"<body>"+
						"<br>"+
				"<br>"+
				"<br>"+
						"<h>"+" Reg.no Found"+
						
						"</h>"+
						"<br>"+
						"<br>"+
						"</body>"+
						"</html>";
				
				out.print(htmlres);
				
				
				
					/*dispatcher=req.getRequestDispatcher("Login.html");
			        dispatcher.include(req,resp);*/
				

				dispatcher=req.getRequestDispatcher("loginp");
		        dispatcher.include(req,resp);
		
		
		
	
			
		
			
			}
			}
			
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
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
					else if (rs!=null)
						{
						rs.close();
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
