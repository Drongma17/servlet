import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class CookiesCheck extends HttpServlet{

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		
		HttpSession session =req.getSession(false);
	
		RequestDispatcher dispatcher = req.getRequestDispatcher("Header.html");
        dispatcher.include(req,resp);
		
		
	
		Cookie[] readCookie=req.getCookies();
		
		
		
		if(readCookie==null)
		{
			String htmlres="<html>"+
					"<body>"+
					"<br>"+
					"<br>"+
					"<br>"+
					"<br>"+
					"<h>"+"Cookie is Disable"+
					
					"</h>"+
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
			String htmlres="<html>"+
					"<body>"+
					"<br>"+
					"<br>"+
					"<br>"+
					"<br>"+
					"<h>"+"Cookie is Enable"+
					
					"</h>"+
					"<br>"+
					"<br>"+
					"<br>"+
					"<br>"+
					"</body>"+
					"</html>";
	
	
	
	out.print(htmlres);
		}
		
		
		RequestDispatcher dispatcher2  = req.getRequestDispatcher("Footer.html");
        dispatcher2.include(req,resp);
		
	}
}
