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


public class StudentSearch extends HttpServlet {


	RequestDispatcher dispatcher=null;


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException 

			{

		resp.setContentType("html");
		PrintWriter out=resp.getWriter();

		dispatcher = req.getRequestDispatcher("Header.html");
		dispatcher.include(req,resp);



		String firstname=null;
		String middlename=null;
		String lastname=null;
		String gfirstname=null;
		String gmiddlename=null;
		String glastname=null;
		String isadmin=null;
		String password = null;


		String regno1=req.getParameter("RegNo");
		int regno=Integer.parseInt(regno1);

		Connection con=null;
		PreparedStatement pstmt=null;

		ResultSet rs=null;

		try {

			//1.
			Driver dr= new Driver();
			DriverManager.registerDriver(dr);

			//2.
			String dburl="jdbc:mysql://localhost:3306/bece5_db?user=root&password=root";
			con=DriverManager.getConnection(dburl);

			//3.
			//here only both value checking
			String query="select * from student_info as a, "
					+" student_otherinfo as b,"
					+" guardian_info as c "
					+" where b.regno =a.regno and c.regno=a.regno and a.regno=?";

			pstmt=con.prepareStatement(query);

			pstmt.setInt(1, regno);
			rs=pstmt.executeQuery();
			
			
			String htmlres1="<html>"+
					"<body>"+
					"<br>"+
					"<br>"+
					"<br>"+
					"<br>"+
					"<br>"+
					"<br>"+
					"</body>"+
					"</html>";
			out.print(htmlres1);

			if(rs.next())
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
				
				
			

				
				out.println("<html>");
				out.println("<body>");
				out.println	("<table>");
				out.println("<tr>");
				out.println("<td>");
				out.println("Student regno</td>");
				out.println("<td> Student First Name </td>") ;
				out.println("<td> Student Middle Name </td>");
				out.println("<td> Student Last Name </td>");
				out.println("<td> Guardian First Name </td>");
				out.println("<td> Guardian Middle Name </td>");
				out.println("<td> Guardian Last Name </td>");
				out.println("<td> iadmin</td>");
				out.println("<td> Password</td>");
				
				out.println("</td>");
				out.println("</tr>");


				out.println("<tr>");
				out.println("<td>"+regno+"</td>");
				out.println("<td>"+firstname+"</td>");
				out.println("<td>"+middlename+"</td>");
				out.println("<td>"+lastname+"</td>");
				out.println("<td>"+gfirstname+"</td>");
				out.println("<td>"+gmiddlename+"</td>");
				out.println("<td>"+glastname+"</td>");
				out.println("<td>"+isadmin+"</td>");
				out.println("<td>"+password+"</td>");
						
			out.println("</tr>");
			out.println("<br>");
			out.println("<br>");
			out.println("<br>");
			out.println("<br>");
			out.println("</table>");
			

			

		}

			else
			{
				out.println("<html>");
				out.println	("<body>");
				out.println("<h>"+"ooooo!!!! Reg.no Not Found");

				out.println("</h>");
						
			}
			
			out.println("</body>");
			out.println("</html>");
			
			out.println("<html>");
			out.println("<body>");
			out.println("<Br>");
			out.println("</br>");
			out.println("<Br>");
			out.println("</br>");
			out.println("<Br>");
			out.println("</br>");
			out.println("<Br>");
			out.println("</br>");
			
			out.println("</body>");
			out.println("</html>");
			
			
			
			
			dispatcher=req.getRequestDispatcher("Footer.html");
			dispatcher.include(req,resp);


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
	



		}//finally
		
		/*String htmlres1="<html>"+
		"<body>"+
		"<br>"+
		"<br>"+
		"<br>"+
		"<br>"+
		"<br>"+
		"<br>"+
		"</body>"+
		"</html>";
		out.print(htmlres1);
		
		dispatcher=req.getRequestDispatcher("Footer.html");
		dispatcher.include(req,resp);
*/
		
		
	

	}//dopost
}//class


