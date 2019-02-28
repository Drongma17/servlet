import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class AllocatingBook extends HttpServlet
{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException
	{
		
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		
		RequestDispatcher dispatcher=null;
		
		dispatcher=req.getRequestDispatcher("Header2.html");
		dispatcher.include(req, resp);
		
		out.println("<html>");
		out.println("<body>");
		out.println("<br>");
		out.println("</br>");
		out.println("<br>");
		out.println("</br>");
		out.println("</body>");
		out.println("</html>");
		
		
		
		dispatcher=req.getRequestDispatcher("AllocatingBook.html");
		dispatcher.include(req, resp);
		
		out.println("<html>");
		out.println("<body>");
		out.println("<br>");
		out.println("</br>");
		out.println("<br>");
		out.println("</br>");
		out.println("</body>");
		out.println("</html>");
		
		dispatcher=req.getRequestDispatcher("Footer.html");
		dispatcher.include(req, resp);
		
		
		
		
	}
	
}
