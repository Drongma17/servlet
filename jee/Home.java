import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Home extends HttpServlet {
	
	
	
	private static final long serialVersionUID =1L;
	RequestDispatcher dispatcher=null;
    
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws 
	ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter out=resp.getWriter();
		String htmlres="<html>"+
				"<body>"+
				
				"<br></br>"+
				
				"</body>"+
				"</html>";
	
		out.print(htmlres);


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
		        
		    	
				
				String htmlres1="<html>"+
						"<body>"+
						
						"<br></br>"+
						"</body>"+
						"</html>";
			
				out.print(htmlres1);
				
				
				
				

				 dispatcher=req.getRequestDispatcher("Image.html");
				        dispatcher.include(req,resp);

						String htmlres2="<html>"+
								"<body>"+
								
								"<br></br>"+
								"<br></br>"+
								
								
								"</body>"+
								"</html>";
					
						out.print(htmlres2);
		        
		        dispatcher=req.getRequestDispatcher("Footer.html");
		        dispatcher.include(req,resp);
	
		
	}

}
