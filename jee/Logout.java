import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Logout extends HttpServlet{
	
	RequestDispatcher dispatcher=null;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException 
		{
		PrintWriter out=resp.getWriter();
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("Header.html");
        dispatcher.include(req,resp);
        
       
			Cookie [] clearCookie=req.getCookies();
			if(clearCookie!=null)
			{
				
				for(Cookie recvdCookie:clearCookie)
				{
					String name=recvdCookie.getName();
				
					
					if(name.equals("uregno"))
					{
						recvdCookie.setMaxAge(0);
						resp.addCookie(recvdCookie);
					
					}
					else if(name.equals("upassword"))
					{
						recvdCookie.setMaxAge(0);
						resp.addCookie(recvdCookie);
					}
					
				}
				
			}
			
			
			String htmlres="<html>"+
					"<body>"+
					
					"<B><h> Successful Logout"+
					
					"<br></br>"+
					
					"</body>"+
					"</html>";
		
			out.print(htmlres);
			
			
			HttpSession session=req.getSession(false);
			
			if(session!=null)
			{
				session.invalidate();
			}
       
        
        dispatcher=req.getRequestDispatcher("Login.html");
        dispatcher.include(req,resp);
        
        
        String htmlres1="<html>"+
				"<body>"+
				
				"<br></br>"+
				
				"</body>"+
				"</html>";
	
		out.print(htmlres);
        
        dispatcher=req.getRequestDispatcher("Footer.html");
        dispatcher.include(req,resp);

}
}