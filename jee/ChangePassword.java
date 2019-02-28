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


public class ChangePassword  extends HttpServlet{
	
	
	Connection con=null;
	PreparedStatement pstmt=null;
	
	private static final long serialVersionUID =1L;
	RequestDispatcher dispatcher=null;
		
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException  {
		
		
		
		resp.setContentType("html");
		PrintWriter out=resp.getWriter();
		
		dispatcher=req.getRequestDispatcher("Header.html");
        dispatcher.include(req,resp);
			
		String regno1=req.getParameter("RegNo");
		int regno=Integer.parseInt(regno1);
		
		String currentPassword=req.getParameter("currentPassword");
		String newPassword=req.getParameter("newPassword");
		String retypeNewPassword=req.getParameter("retypeNewPassword");
			
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
				
				if(newPassword.equals(retypeNewPassword))
				{
					
					String query=" update student_otherinfo "
							+" set password=? "
							+" where regno=? and password=? ";
				
				pstmt=con.prepareStatement(query);
				
				//4.
				pstmt.setString(1, newPassword);
				pstmt.setInt(2,regno);
				pstmt.setString(3, currentPassword);
				
				int i=pstmt.executeUpdate();
				
				
				
				if(i>0)
					
				{
					con.commit();
					String htmlres="<html>"+
							"<body>"+
							"<h>"+i+" Row Affected Successfully"+
							
							"</h>"+
							"</body>"+
							"</html>";
			
			
					
					out.print(htmlres);
				
				}
				
				else
				{
					String htmlres="<html>"+
							"<body>"+
							"<h>"+"No row Affected"+
							
							"</h>"+
							"</body>"+
							"</html>";
			
			
				
				out.print(htmlres);
				}
				
				}
				
				
				else
				{
					String htmlres="<html>"+
							"<body>"+
							"<h>"+"New passwprd or retypepassword is missmatch"+
							
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
				
				try {
					con.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			
			finally{
				//5.
				
					try {
						if(con!=null)
						{
						con.close();
						}
						
						if(pstmt!=null)
						{
						pstmt.close();
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


