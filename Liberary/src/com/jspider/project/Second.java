package com.jspider.project;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Second extends HttpServlet {

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        ServletContext sc = getServletContext();
 
        String str =(String) sc.getAttribute("user");  //getting attribute from context scope
	
        out.println("Welcome"+str);  // Prints : Welcome Abhijit   
    }
}