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
import javax.swing.text.html.HTMLDocument.HTMLReader.PreAction;

import com.mysql.jdbc.Driver;


public class ReceiveBookToTable extends HttpServlet
{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException
	{
		
		RequestDispatcher dispatcher=null;
		Connection con=null;
		PreparedStatement pstmt=null ,pstmt2=null,pstmt3=null;
		ResultSet res=null;
		
		String usn=null;
		int bookId;
		
		
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();

		dispatcher=req.getRequestDispatcher("Header2.html");
		dispatcher.include(req, resp);
		
		
		try {
			
			Driver dr=new Driver();
			DriverManager.registerDriver(dr);
			
			
			String dburl="jdbc:mysql://localhost:3306/liberary?user=root&password=root";
			con=DriverManager.getConnection(dburl);
			
			con.setAutoCommit(false);
			String qury="select Book_id,usn from allot_books where Book_id=? and usn=?";
			pstmt=con.prepareStatement(qury);
			
			bookId=Integer.parseInt(req.getParameter("bookId"));
			usn=req.getParameter("usn");
			
			pstmt.setInt(1,bookId);
			pstmt.setString(2, usn);
			
			res=pstmt.executeQuery();
			
			
			if(res.next())
			{
				
			String query2="Delete from allot_book where Book_id=?";
			pstmt2=con.prepareStatement(query2);
			pstmt2.setInt(1,bookId);
			
			int count1=pstmt2.executeUpdate();
			
			
			String query3="Update book_info set Availability ='y' where Book_id=?";
			pstmt3=con.prepareStatement(query3);
			pstmt3.setInt(1,bookId);
			
			int count2=pstmt3.executeUpdate();
					
			if(count1!=0 && count2!=0)
			{
				con.commit();
				out.println("<html>");
				out.println("<body>");
				out.println("<br>");
				out.println("</br>");
				out.println("<br>");
				out.println("</br>");
				out.println("<h2><center>Successful received Book.......!!!!!!--</center></h2>");
				out.println("<br>");
				out.println("</br>");
				out.println("</body>");
				out.println("</html>");
				
			}
			
				
			}
			
			else
			{
				out.println("<html>");
				out.println("<body>");
				out.println("<br>");
				out.println("</br>");
				out.println("<br>");
				out.println("</br>");
				out.println("<h2><center>Book_id and usn not found.......!!!!!!--</center></h2>");
				out.println("<br>");
				out.println("</br>");
				out.println("</body>");
				out.println("</html>");
			}
			
			
		
		
		
		
		
		
		
		
		} 
		catch (SQLException e) 
		{
			out.println("<html>");
			out.println("<body>");
			out.println("<br>");
			out.println("</br>");
			out.println("<br>");
			out.println("</br>");
			out.println("<h2><center>Sql error.......!!!!!!--</center></h2>");
			out.println("<br>");
			out.println("</br>");
			out.println("</body>");
			out.println("</html>");
			
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
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
					else if(pstmt2 !=null)
					{
						pstmt2.close();
					}
					else if(pstmt3 !=null)
					{
						pstmt3.close();
					}
					else if (res!=null)
					{
						res.close();
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
