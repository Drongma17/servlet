import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Lpage extends HttpServlet{
	RequestDispatcher dispatcher=null;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException 
		{
		
		PrintWriter out=resp.getWriter();
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("Header.html");
        dispatcher.include(req,resp);
        
       
		
			Cookie myCookie=new Cookie("name","Yes I am present");
			resp.addCookie(myCookie);
			
			String htmlres="<html>"+
					"<body>"+
					
					"<br></br>"+
					"<br></br>"+
					"<br></br>"+
					"<br></br>"+
					"</body>"+
					"</html>";
		
			out.print(htmlres);
//_-------------------------------------------------------------------------			
       
    /*  //assignment login page display user  
        dispatcher=req.getRequestDispatcher("Login.html");
        dispatcher.include(req,resp);*/
			
			String regNo=null;
			Cookie [] clearCookie=req.getCookies();
			if(clearCookie!=null)
			{
				
				for(Cookie recvdCookie:clearCookie)
				{
					String name=recvdCookie.getName();
				
					
					if(name.equals("uregno"))
					{
						String name1=recvdCookie.getValue();
						regNo=name1;
						String htmlres2="<body bgcolor=\"gray\">"+
								"<form action =\"http://localhost:8080/ClassAssignment/loginpage\" method=\"post\" >"+
			
	 
	 						"<h1> Login Page </h1>"+
	 
	 						"<table>"+
	 						"<tr>"+
	 						"<td >Reg.No:</td>"+ 
	 						"<td> <input type =\"text\" name =\"regNo\"  placeholder=\"Enter the Reg.No\"  value=\""+regNo+"\"+required/></td> "+
	 						"</tr>"+
	 						"<tr>"+
	 						"<td >Password:</td>" +
	 						"<td> <input type =\"password\" name =\"password\"  placeholder=\"Enter the Password\" required/></td>"+ 
	 						"</tr>"+
	 
							/*<tr >
	 						<td>
	 						</td>
							<td>
							<tr >
	 						<td>
	 						</td>
							<td>*/

							"<tr >"+
							"<td> <a href=\"http://localhost:8080/ClassAssignment/cookie\">Check Cookie??</a>"+
							"</td>"+
							"<td>"+
							"<tr >"+
							" <td>"+
							"</td>"+
							"<td>"+
							"<tr>"+
							"<td>"+
							"</td>"+
	 
	 						"<br>"+
	 						"<br>"+
	 						"<br>"+
	 						"<br>"+
	 
	 
	 
	 						"<tr >"+
	 						"<td> <input type=\"checkbox\" name=\"remember\"/>Remember Me?"+
	 						"</td>"+
	 						"<td>"+
	 						"<tr>"+
	 						"<td>"+
	 						" </td>"+
	 
							"<td>"+
							"<input type=\"submit\" value=\"Sgin In\">"+
							"</td>"+
	  
	 						"</tr>"+
	 						"</table>"+
	 						"</form>"+
	 
							"</body>"+
							"</html>";
					out.print(htmlres2);
						break;
					}
					
					else
					{
						dispatcher=req.getRequestDispatcher("Login.html");
				        dispatcher.include(req,resp);
				        
					}
					
				}
			}
			else
			{
				dispatcher=req.getRequestDispatcher("Login.html");
		        dispatcher.include(req,resp);
		        
			}
						
			
			
        
 //-------------------------------------------------------       
        String htmlres1="<html>"+
				"<body>"+
				
				"<br></br>"+
				"<br></br>"+
				"<br></br>"+
				"<br></br>"+
				
				"</body>"+
				"</html>";
	
		out.print(htmlres1);
        
        dispatcher=req.getRequestDispatcher("Footer.html");
        dispatcher.include(req,resp);
		
		
		
	}
	

}
