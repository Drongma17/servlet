import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.mysql.jdbc.Driver;


public class CurrentDate extends HttpServlet 
{

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException 
			{

		
		Date dateRef =new Date();
		String currDate=dateRef.toString();
		
		String htmlRes="<html>"+
						"<head>" 
						+"<title>Date and Time</title>"
						+"</head>"
						+"<body>"
						+"<h1>Currrent Date and Time is : " 
						+"<font color=\" red\">"+currDate+"</font>"       
						+"</h1>"
						+"</body>"
						+"</html>";
		
		resp.setContentType("text/html");
		PrintWriter out =resp.getWriter();
		out.println(htmlRes);
		
		Connection con=null;
		PreparedStatement pstmt=null;
		
		
		InputStream inputStream=null;		
		resp.setContentType("text/html");
		PrintWriter out1=resp.getWriter();

		
		
		try {
			
			Driver dr=new Driver();
			DriverManager.registerDriver(dr);
			
			
			String dburl="jdbc:mysql://localhost:3306/liberary?user=root&password=root";
			con=DriverManager.getConnection(dburl);
			
			con.setAutoCommit(false);
			String qury="insert into image values(?,?)";
			pstmt=con.prepareStatement(qury);
			
			Part filePart=req.getPart("filename");
			if (filePart != null) {
	            // prints out some information for debugging
	            System.out.println(filePart.getName());
	            System.out.println(filePart.getSize());
	            System.out.println(filePart.getContentType());

	            //obtains input stream of the upload file
	            //the InputStream will point to a stream that contains
	            //the contents of the file
	            inputStream = filePart.getInputStream();
	        }
			String id=req.getParameter("id");
			
			
			
			pstmt.setInt(1,Integer.parseInt(id));
			
			if (inputStream != null) {
                //files are treated as BLOB objects in database
                //here we're letting the JDBC driver
                //create a blob object based on the
                //input stream that contains the data of the file
                pstmt.setBlob(2, inputStream);
            }
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
				out.println("<h2><center>Successful image.......!!!!!!--</center></h2>");
				out.println("<br>");
				out.println("</br>");
				out.println("</body>");
				out.println("</html>");
				
			}
			
		}
			
			
	}
}
		
		
		
		

