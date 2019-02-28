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


public class EditStudentData extends HttpServlet{
	
	
	private static final long serialVersionUID =1L;
	RequestDispatcher dispatcher=null;
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException
			
	{
		
	//Global Variable-------------------------------------	
		String fname=null;
		String mname=null;
		String lname=null;
		String gfname=null;
		String gmname=null;
		String glname=null;
		String isadmin=null;
		String password = null;
		
		
	//getParameter-------------------------------------------------
		String regno1=req.getParameter("regno");
		int regno=Integer.parseInt(regno1);
		fname=req.getParameter("fname");
		mname=req.getParameter("mname");
		lname=req.getParameter("lname");

		gfname=req.getParameter("gfname");
		gmname=req.getParameter("gmname");
		glname=req.getParameter("glname");

		isadmin=req.getParameter("isadmin");
		password=req.getParameter("password");
	//------------------------------------------------------------------	
		String action=req.getParameter("action");
		
		
			resp.setContentType("text/html");
		   PrintWriter out=resp.getWriter();
		   
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
			
			
		String edit="edit";
		if(action.equals(edit))	
		{
			
			String htmlres5=  "<html>"+
			        "<head>"+
			        	"<style type =\"text/css\">"+
			        	
			        	".body{    margin-right: 150;}"+
			        	".H{"+    
			        	"padding: 100;"+
			        	"border:2px solid brown"+
			        	"border-radius:10px;"+
			        	"box-shadow:5px 5px 10px black;"+
			        	 "background-color: burlywood;"+
			        		"text-align: -webkit-center;}"+
			        	".f{ padding-left: 200;"+
			        	 "   margin-left: 100;}"+
			        	".t{padding-top: 50;}"+
			        	
			        	".tr1{    font-family: cursive;"+
			            "color: snow;"+
			            "font-style: italic;}"+
			        	".tr2{    font-family: cursive;"+
			            "color: snow;"+
			            "font-style: italic;}"+
			        	".tr3{    font-family: cursive;"+
			            "color: snow;"+
			            "font-style: italic;}"+
			        	".tr4{    font-family: cursive;"+
			            "color: snow;"+
			            "font-style: italic;}"+
			        	".tr5{    font-family: cursive;"+
			            "color: snow;"+
			            "font-style: italic;}"+
			        	".tr6{    font-family: cursive;"+
			            "color: snow;"+
			            "font-style: italic;}"+
			        	".tr7{    font-family: cursive;"+
			            "color: snow;"+
			            "font-style: italic;}"+
			        	".tr8{    font-family: cursive;"+
			            "color: snow;"+
			            "font-style: italic;}"+
			        	".tr9{    font-family: cursive;"+
			            "color: snow;"+
			            "font-style: italic;}"+
			        	"value.tr1{    font-family: cursive;"+
			            "color: snow;"+
			            "font-style: italic;}"+
			        	".tr10{    font-family: cursive;"+
			            "color: snow;"+
			            "font-style: italic;}"+
			        	".tr11{    font-family: cursive;"+
			            "color: snow;"+
			            "font-style: italic;}"+
			        	
			        "</style>"	+

			        	"</head>"+
			        	"<body class=\"body\" bgcolor=\"purple\" >"+
			      "<form class=\"f\" action =\"http://localhost:8080/ClassAssignment/edit\" method=\"post\">"+
			        		
			         
			         "<h1 class=\"H\">Edit Student profile </h1>"+
			         
			         "<table class=\"t\">"+
			         
			         "<tr class=\"tr1\">"+
			         "<td >Reg.No:</td>"+
			         
			        	"<td> <input type =\"text\" name =\"regno\" value=\""+regno+"\" "  +" readonly=\"true" + 
			        	
			         "</tr>"+
			         
			         
			         
			         "<tr class=\"tr2\">"+
			         "<td>First Name:</td>"+
			         "<td><input type =\"text\""+
			         "name =\"fname\"  value=\""+fname+"\" placeholder=\"Enter the First name\"/></td>"+
			         "</tr>"+
			         
			        "<tr class=\"tr2\">" +
			         "<td>Middle Name:</td>"+
			         "<td><input type =\"text\""+
			         "name =\"mname\" value=\""+mname+"\" placeholder=\"Enter the Middle name\"/></td>"+
			         "</tr>"+
			         "<tr class=\"tr2\">"+
			         "<td>Last Name:</td>"+
			         "<td><input type =\"text\""+
			         "name =\"lname\" value=\""+lname+"\"  placeholder=\"Enter the Last name\"/></td>"+
			         "</tr>"+
			         "<tr class=\"tr2\">"+
			         "<td>Guardian First Name:</td>"+
			         "<td><input type =\"text\""+
			         "name =\"gfname\" value=\""+gfname+"\" placeholder=\"Enter the Guardian First Name\"/></td>"+
			         "</tr>"+
			         "<tr class=\"tr2\">"+
			         "<td>Guardian Middle Name :</td>"+
			         "<td><input type =\"text\""+
			         "name =\"gmname\" value=\""+gmname+"\" placeholder=\"Enter the Guardian Middle Name\"/></td>"+
			         "</tr>"+
			         "<tr class=\"tr2\">"+
			         "<td>Guardian Last Name:</td>"+
			         "<td><input type =\"text\""+
			         "name =\"glname\" value=\""+glname+"\"  placeholder=\"Enther Guardian Last Name\"/></td>"+
			         "</tr>"+
			         
			        "<tr class =\"tr10\">"+
			         "<td>"+
			          "<p> Admin? :</p></td>"+
			          "<td>"+
			          "<select name =\"isadmin\"> value=\""+isadmin+"\" "+
			          //"<option>----Select----</option>"+
			         "<option> Y</option>"+
			         "<option> N</option>"+
			         "</select>"+
			        "</td></tr>"+
			         
			         
			         
			        "<tr class=\"tr4\">" +
			        "<td>Password:</td>"+
			        "<td><input type =\"password\" name =\"password\" value=\""+password+"\"  placeholder=\"Enter the Password\"/><td>"+
			         "</tr>"+
			      
			         
			         
			         
			         
			        "<tr class=\"tr11\">" +
			         "<td></td>"+
			         
			        "<td>" +
			         "<input type=\"submit\">"+
			         "<INPUT TYPE =\"RESET\">"+
			         "</td>"+
			         "</tr>"+
			         "</table>"+
			         "</body>"+
			         "</html>";
					
			out.print(htmlres5);	
					
					
//--------------       Taking From data     -----------------------------------------------------------------
				
				
				
			/*	
				firstname=req.getParameter("fname");
				middlename=req.getParameter("mname");
				lastname=req.getParameter("lname");
				gfirstname=req.getParameter("gfname");
				gmiddlename=req.getParameter("gmname");
				glastname=req.getParameter("glname");
				isadmin=req.getParameter("admin");
				password=req.getParameter("password");*/
				
				String htmlres3="<html>"+
								"<body>"+
								"<Br>"+
								
								"<Br>"+
								"</body>"+
								"</html>";

						out.print(htmlres3);
				        
				      
	//-------------------Query--------------------------------------------	
			
			/*String query1 =" update students_info "
							+" set regno=?, firstname=?,middlename=?,lastname=? "+
							" where regno=regno";
			pstmt1=con.prepareStatement(query1);
			
			pstmt1.setInt(1, regno);
			pstmt1.setString(2,firstname );
			pstmt1.setString(3,middlename);
			pstmt1.setString(4,lastname);
			
			String query2 =" update guardian_info "
					+" set regno=?, gfirstname=?,gmiddlename=?,glastname=?) "+
					"where regno=regno";
			
			pstmt2=con.prepareStatement(query2);
			
			pstmt2.setInt(1,regno);
			pstmt2.setString(2,gfirstname);
			pstmt2.setString(3,gmiddlename);
			pstmt2.setString(4, glastname);
			
		
			
			
			String query3=" update student_otherinfo"
					+" set regno=?, isadmin=?,password=? "+
					"where regno=regno";
			

			pstmt3=con.prepareStatement(query3);
			 
			pstmt3.setInt(1,regno);
			pstmt3.setString(2,isadmin);
			pstmt3.setString(3,password);
			
			
			count1=pstmt1.executeUpdate();
			count2=pstmt2.executeUpdate();
			count3=pstmt3.executeUpdate();
			
			
			
			if(count1>0 && count2>0 && count3>0)
			{
				
				con.commit();
				
				String htmlres="<html>"+
						"<body>"+
						"<h>"+"Successfull Edited"+
						
						"</h>"+
						"</body>"+
						"</html>";
				out.print(htmlres);
				
			}
			
			else
			{
				String htmlres="<html>"+
						"<body>"+
						"<h>"+"Profile is not created"+
						
						"</h>"+
						"</body>"+
						"</html>";
		
		
		
				out.print(htmlres);
			}
		}//action edit if	
*/		
		}//delete
		else
		{
			
			String deleteQuery1="delete from student_info where regno=?";
			  String deleteQuery2="delete from guardian_info where regno=?";
			  String deleteQuery3="delete from student_otherinfo where regno=?";
			  pstmt1=con.prepareStatement(deleteQuery1);
			  pstmt2=con.prepareStatement(deleteQuery2);
			  pstmt3=con.prepareStatement(deleteQuery3);
			  pstmt1.setInt(1,regno);
			  pstmt2.setInt(1,regno);
			  pstmt3.setInt(1,regno);
			   int count4=pstmt1.executeUpdate();
			   int count5= pstmt2.executeUpdate();
			   int count6= pstmt3.executeUpdate();
			  
			   
			
			   if(count4!=0 && count5!=0 && count6!=0)
			   {
				   con.commit();
				   out.println("<BR><BR>");
			       out.println("Successfully deleted the regno="+regno);
			   }	
			   else{
				   out.println("<BR><BR><BR>");
				   out.println("unable to Delete ur regno!!!!");
			   }
					 
			
			
		}
			}
			
		
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			out.println("Unbale to create the Profile !!!");
			try {
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
			
			
			dispatcher=req.getRequestDispatcher("Footer.html");
	        dispatcher.include(req,resp);
				
		
		
			
		
	}
	
	}


}
