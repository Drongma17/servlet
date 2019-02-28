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


public class AllocatingBookToTable extends HttpServlet
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
		PreparedStatement pstmt=null,pstmt2=null ,pstmt3=null;
		ResultSet res=null;
		int count2=0;
		
		
		int bookId;
		String usn=null;
		String doa=null;
		String dor=null;
		String book_type=null;
		String N="N";
		
		try {
			
			Driver dr=new Driver();
			DriverManager.registerDriver(dr);
			
			
			
			
			
			String dburl="jdbc:mysql://localhost:3306/liberary?user=root&password=root";
			con=DriverManager.getConnection(dburl);
			con.setAutoCommit(false);
			
			
			
			String query1="insert into allot_book values(?,?,?,?,?)";
			pstmt=con.prepareStatement(query1);
			
			
			
			
			bookId=Integer.parseInt(req.getParameter("bookId"));
			usn=req.getParameter("usn");
			doa=req.getParameter("doa");
			dor=req.getParameter("dor");
			book_type=req.getParameter("bookType");
			
			
			pstmt.setInt(1,bookId);
			pstmt.setString(2,usn);
			pstmt.setString(3,doa);
			pstmt.setString(4,dor);
			pstmt.setString(5,book_type);
			int count=pstmt.executeUpdate();
			
			
			/*String query3="select Availability from book_info where book_id=?";
			pstmt3=con.prepareStatement(query3);
			pstmt3.setInt(1,bookId);
			res=pstmt3.executeQuery();
			*/
			
			/*if(res.next())
			{
				String availablity=res.getString("Availability");
				
				if(availablity.equals(N))
				{
					
					out.println("<html>");
					out.println("<body>");
					out.println("<br>");
					out.println("</br>");
					out.println("<br>");
					out.println("</br>");
					out.println("<h2><center>Book not available!!!!!!--</center></h2>");
					out.println("<br>");
					out.println("</br>");
					out.println("</body>");
					out.println("</html>");
					
				}
				*/
				
			
					String query2="update book_info set Availability='N' where book_id=?";
					pstmt2=con.prepareStatement(query2);
					pstmt2.setInt(1,bookId);
					count2=pstmt2.executeUpdate();
				
			
			
			
			
			
			
			
			
			
			
		
			
			if(count!=0 && count2!=0)
			{
			
				out.println("<html>");
				out.println("<body>");
				out.println("<br>");
				out.println("</br>");
				out.println("<br>");
				out.println("</br>");
				out.println("<h2><center>Successful inserted and updated!!!!!!--</center></h2>");
				out.println("<br>");
				out.println("</br>");
				out.println("</body>");
				out.println("</html>");
				con.commit();
			}
			else
			{
				
				out.println("<html>");
				out.println("<body>");
				out.println("<br>");
				out.println("</br>");
				out.println("<br>");
				out.println("</br>");
				out.println("<h2><center>Book id not available.......!!!!!!--</center></h2>");
				out.println("<br>");
				out.println("</br>");
				out.println("</body>");
				out.println("</html>");
			}
			
			
		
		
		
		
		
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			out.println("<html>");
			out.println("<body>");
			out.println("<br>");
			out.println("</br>");
			out.println("<br>");
			out.println("</br>");
			out.println("<h2><center>Book is not available.......!!!!!!--</center></h2>");
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
		}
		
		finally{
			//5.
			
				try {
					if(con!=null)
					{
					con.close();
					}
					
					if(pstmt!=null)
					{
					pstmt.close();
					}
					if(pstmt2!=null)
					{
					pstmt2.close();
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
