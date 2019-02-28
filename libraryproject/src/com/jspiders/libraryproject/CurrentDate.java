package com.jspiders.libraryproject;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Driver;

public class CurrentDate extends HttpServlet
{
   @Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
	
	   resp.setContentType("text/html");
	   PrintWriter out=resp.getWriter();
	   
	   Date date=new Date();
	   String currentDate=date.toString();
	   
	   String htmlref="<html>" +
	                         "<head>"
			                 +"<title> Date & Time </title>"
	                         +"</head>"
			                 +"<body>"
	                         +"<h1> Current Date and Time is </h>"
			                 +"<form color=\"red\"> + currentDate + </form>"
	                         +"</h1>"
			                 +"</body>"
	                         +"</html>";
	   out.println(htmlref);
	   
	   Connection con=null;
	   PreparedStatement psmt=null;
	   
	   
	   try {
		   
		Driver driveref= new Driver();
		DriverManager.registerDriver(driveref);
		String dburl="jdbc:mysql://localhost:3306/library?user=root&password=root";
		
		con=DriverManager.getConnection(dburl);
		
		String sql="";
		
		
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
}
}
