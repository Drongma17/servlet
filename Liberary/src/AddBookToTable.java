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


public class AddBookToTable extends HttpServlet
{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException
	{
		
		RequestDispatcher dispatcher=null;
		
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		
		dispatcher=req.getRequestDispatcher("Header2.html");
		dispatcher.include(req, resp);
		Connection con=null;
		PreparedStatement pstmt=null;
		 
		
		
		
		int bookid=0;
		String bookNmae=null;
		String author=null;
		String yop=null;
		String Availability="Y";
		
		
		
		bookid=Integer.parseInt(req.getParameter("book_id"));
		bookNmae=req.getParameter("bookName");
		author=req.getParameter("author");
		yop=req.getParameter("yop");
		
		
		
		
		try {
			
			Driver dr=new Driver();
			DriverManager.registerDriver(dr);
			
			String dburl="jdbc:mysql://localhost:3306/liberary?user=root&password=root";
			con=DriverManager.getConnection(dburl);
			
			con.setAutoCommit(false);
			
			
			String query="insert into book_info values(?,?,?,?,?)";
			
		pstmt=con.prepareStatement(query);
		
		
		pstmt.setInt(1,bookid);
		pstmt.setString(2,bookNmae);
		pstmt.setString(3,author);
		pstmt.setString(4,yop);
		pstmt.setString(5,Availability);
		
		int count=pstmt.executeUpdate();
		
		
		if(count!=0)
		{
			con.commit();
			
			out.println("<html>");
			out.println("<body>");
			out.println("<br>");
			out.println("</br>");
			out.println("<br>");
			out.println("</br>");
			out.println("<h2><center>Book is added successfully !!!!!.... </center></h2>");
			out.println("<br>");
			out.println("</br>");
			out.println("</body>");
			out.println("</html>");
			
			
		}
		
		else
		{
			out.println("<html>");
			out.println("<body>");
			out.println("<br>");
			out.println("</br>");
			out.println("<br>");
			out.println("</br>");
			out.println("<h2><center> </center></h2>");
			out.println("<br>");
			out.println("</br>");
			out.println("</body>");
			out.println("</html>");
			
		}
		
		
				
			
			
			
		} 
		catch (SQLException e) {
			
			out.println("<html>");
			out.println("<body>");
			out.println("<br>");
			out.println("</br>");
			out.println("<br>");
			out.println("</br>");
			out.println("<h2><center>Book id is already present!!!!!....</center></h2>");
			out.println("<br>");
			out.println("</br>");
			out.println("</body>");
			out.println("</html>");
			e.printStackTrace();
			
			
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
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

					else if(pstmt !=null)
					{
						pstmt.close();
					}
					
					
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			
		}
		
		
		
		dispatcher=req.getRequestDispatcher("Footer.html");
		dispatcher.include(req, resp);
		
	}
	
}
