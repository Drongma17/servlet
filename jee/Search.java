import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Search extends HttpServlet{
	
	RequestDispatcher dispatcher=null;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException 
		{
		PrintWriter out=resp.getWriter();
		
		
		
		HttpSession session=req.getSession(false);
		if(session==null)
		{
			
		
		
		dispatcher = req.getRequestDispatcher("Header.html");
        dispatcher.include(req,resp);
		}
		else
		{
			dispatcher = req.getRequestDispatcher("Header2.html");
	        dispatcher.include(req,resp);
		}
			
			
			String htmlres="<html>"+
					"<body>"+
					
					"<br></br>"+
					
					"</body>"+
					"</html>";
		
			out.print(htmlres);
       
        
        dispatcher=req.getRequestDispatcher("StudentSearch.html");
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
