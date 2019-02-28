package com.jspider.project;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class First extends HttpServlet {

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        out.println("we are Developer in Bangalor");
        ServletContext sc = getServletContext();
        sc.setAttribute("user","Abhijit");	//setting attribute on context scope
    }
}
