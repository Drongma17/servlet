import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.print.attribute.standard.MediaSize.Other;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Blob;
import com.mysql.jdbc.Driver;


public class Displayimage extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException
		{
			
			
			Connection con=null;
		Statement stmt=null;
			ResultSet res=null;
			
			InputStream inputStream=null;		
			
		

			
			
			try {
				
				Driver dr=new Driver();
				DriverManager.registerDriver(dr);
				
				
				String dburl="jdbc:mysql://localhost:3306/liberary?user=root&password=root";
				con=DriverManager.getConnection(dburl);
				
				con.setAutoCommit(false);
				String qury="select  image from image where id=1";
				stmt=con.createStatement();
				
				
				res=stmt.executeQuery(qury);
				
				
				
				/*		
				if(res.next())
				{
					String imlen=res.getString("image");
					int len =imlen.length();
					byte[] rd=new byte[len];
					InputStream readImage=res.getBinaryStream("image");
					
					int index=readImage.read(rd,0,len);
					System.out.println("Index......"+index);
					resp.reset();
					resp.setContentType("image/jpg");
					resp.getOutputStream().write(rd,0,len);
					resp.getOutputStream().flush();
					
				
					
				}*/	
				ServletOutputStream out=resp.getOutputStream();
				java.sql.Blob image=null;
				if(res.next())
				{
					 image=res.getBlob(1);
					
					
				}
					
					
					
					
		
				
				else
				{
					System.err.println("nooo");
				}
				
				
				resp.setContentType("image/jpg");
				
				InputStream in=image.getBinaryStream();
				int length=(int)image.length();
				int bufferSize=1024;
				byte[] buffer=new byte[bufferSize];
				
				while((length=in.read(buffer))!=-1)
				{
					out.write(buffer,0,length);
					
				}
				in.close();
				out.flush();
			
			
			
			
			
			
			
			
			} 
			catch (SQLException e) 
			{
				
				System.err.println("sql");
				
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

						else if(stmt !=null)
						{
							stmt.close();
						}
						
						
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
				
			}
			
			
			
			
			
		}

}
