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
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.Driver;


public class HEdit extends HttpServlet{
	
	
	RequestDispatcher dispatcher=null;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException 
		{
		
		
		
		
		
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		   
		Connection con=null;
		PreparedStatement pstmt1 = null,pstmt2 = null,pstmt3=null;
		
		
		
		
			dispatcher = req.getRequestDispatcher("Header2.html");
	        dispatcher.include(req,resp);
		
        
       
		
			
			
			String htmlres="<html>"+
					"<body>"+
					
					"<br></br>"+
					
					"</body>"+
					"</html>";
		
			out.print(htmlres);
       
	//---------------------------------------------------------------------------------		
		
			

			try {
				
				//1.
				Driver dr= new Driver();
				DriverManager.registerDriver(dr);
				
				//2.
				String dburl="jdbc:mysql://localhost:3306/bece5_db?user=root&password=root";
				con=DriverManager.getConnection(dburl);
				
				con.setAutoCommit(false);
			
			String firstname=null;
			String middlename=null;
			String lastname=null;
			String gfirstname=null;
			String gmiddlename=null;
			String glastname=null;
			String isadmin=null;
			String password = null;
			
			
			String regno1=req.getParameter("regno");
			int regno=Integer.parseInt(regno1);
			firstname=req.getParameter("fname");
			middlename=req.getParameter("mname");
			lastname=req.getParameter("lname");
			gfirstname=req.getParameter("gfname");
			gmiddlename=req.getParameter("gmname");
			glastname=req.getParameter("glname");
			isadmin=req.getParameter("isadmin");
			password=req.getParameter("password");
			
			String htmlres3="<html>"+
							"<body>"+
							"<Br>"+
							
							"<Br>"+
							"</body>"+
							"</html>";

					out.print(htmlres3);
			        
			      
//-------------------Query--------------------------------------------	
		
		String query1 =" update student_info "
						+" set regno=?, firstname=?,middlename=?,lastname=? "+
						" where regno=? ";
		pstmt1=con.prepareStatement(query1);
		
		pstmt1.setInt(1, regno);
		pstmt1.setString(2,firstname );
		pstmt1.setString(3,middlename);
		pstmt1.setString(4,lastname);
		pstmt1.setInt(5, regno);
		
		String query2 =" update guardian_info "
				+" set regno=?, gfirstname=?,gmiddlename=?,glastname=? "+
				"where regno=?";
		
		pstmt2=con.prepareStatement(query2);
		
		pstmt2.setInt(1,regno);
		pstmt2.setString(2,gfirstname);
		pstmt2.setString(3,gmiddlename);
		pstmt2.setString(4, glastname);
		pstmt2.setInt(5, regno);
		
	
		
		
		String query3=" update student_otherinfo"
				+" set regno=?, isadmin=?,password=? "+
				" where regno=?";
		

		pstmt3=con.prepareStatement(query3);
		 
		pstmt3.setInt(1,regno);
		pstmt3.setString(2,isadmin);
		pstmt3.setString(3,password);
		pstmt3.setInt(4, regno);
		
		
		int count1=pstmt1.executeUpdate();
		int count2=pstmt2.executeUpdate();
		int count3=pstmt3.executeUpdate();
		
		
		
		if(count1>0 && count2>0 && count3>0)
		{
			
			con.commit();
			
			String htmlres1="<html>"+
					"<body>"+
					"<h>"+"Successfull Edited"+
					
					"</h>"+
					"</body>"+
					"</html>";
			out.print(htmlres1);
			
		}
		
		else
		{
			String htmlres2="<html>"+
					"<body>"+
					"<h>"+"Failed to Edit"+
					
					"</h>"+
					"</body>"+
					"</html>";
	
	
	
			out.print(htmlres2);
		}
	}
			
			catch (SQLException e)
			{
				out.println("Unbale to Edit the Profile !!!");
				// TODO Auto-generated catch block
				e.printStackTrace();
				try {
					con.rollback();//do not execute catch table data and destroy it.
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					System.err.println("Unbale to create the Profile !!!");
					out.println("Unbale to Edit the Profile !!!");
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
				
     
        
    //----------------------------------------------------------------------------------    
       String htmlres3="<html>"+
				"<body>"+
				
				"<br></br>"+
				
				"</body>"+
				"</html>";
	
		out.print(htmlres3);
        
        dispatcher=req.getRequestDispatcher("Footer.html");
        dispatcher.include(req,resp);	
		
	}
	


}
