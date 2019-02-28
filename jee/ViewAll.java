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


public class ViewAll extends HttpServlet {

	
	RequestDispatcher dispatcher=null;


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException 

			{

		resp.setContentType("html");
		PrintWriter out=resp.getWriter();

		dispatcher = req.getRequestDispatcher("Header2.html");
		dispatcher.include(req,resp);



		String firstname=null;
		String middlename=null;
		String lastname=null;
		String gfirstname=null;
		String gmiddlename=null;
		String glastname=null;
		String isadmin=null;
		String password = null;
		int regno;

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
			
			String query=" select * from student_info as a ," +
					" student_otherinfo as b,guardian_info as c " +
					" where a.regno =c.regno and b.regno=c.regno and c.regno>0 ";

			pstmt=con.prepareStatement(query);
			rs=pstmt.executeQuery();
			
			
			
			String htmlres="<html>"+
					"<body>"+
					"<br>"+
					"<br>"+
					"<br>"+
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
					"<td> Opertion</td>"+
					"<td> </td>"+
					"</td>"+
					"</tr>"+
					"<br>"+
					"<br>"+
					"<br>"+
					"</body>"+
					"</html>";
			out.print(htmlres);

			while(rs.next())
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
				
				String editUrl = " http://localhost:8080/ClassAssignment/EditDelete?action=edit&regno="+regno+"&fname="+firstname+"&mname="+middlename+"&lname="+lastname+"&gfname="+gfirstname+"&gmname="+gmiddlename+"&glname="+glastname+"&admin="+isadmin+"&password="+password;
				String deleteUrl = "http://localhost:8080/ClassAssignment/EditDelete?action=delete&regno="+rs.getInt("regno");
				


				String htmlres2="<html>"+
						"<body>"+
						
						"<table>"+

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
							"<td> <a href=\""+editUrl+"\" > Edit </a></td>"+
							"<td> <a href=\""+deleteUrl+"\"> Delete </a></td>"+
							"</tr>"+
							
							"</body>"+
							"</html>";
				
							out.print(htmlres2);
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
			
			String res="<html>"+
						"<body>"+
								
						"<br>"+
						"<br>"+
						"<br>"+
						"<br>"+
						"<br>"+
						"<br>"+
						"<html>"+
						"<body>";
			out.println(res);
			
			}

		dispatcher=req.getRequestDispatcher("Footer.html");
		dispatcher.include(req,resp);

	}//dopost
	
}
