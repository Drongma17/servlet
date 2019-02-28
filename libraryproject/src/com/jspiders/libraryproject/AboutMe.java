package com.jspiders.libraryproject;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AboutMe extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		
		RequestDispatcher dispatcher =req.getRequestDispatcher("Header1.html");
		dispatcher.include(req, resp);
		out.println("<br>");
		out.println(("</br>"));
		out.println("<br>");
		out.println(("</br>"));
		out.println("<br>");
		out.println(("</br>"));
		out.println("<br>");
		out.println(("</br>"));
		out.println("<html>");
		out.println("<body>");
		out.println("<center> <h1> My Name is Ngawang Yeshi </h1><center>");
		out.println("<h2> I came to India in year of 2000 <h2>");
		out.println("<h2> I am pure Tibetan only <h2>");
		out.println("<h3> currently i am searching job <h3>");
		out.println("<h3> if i get job in software developer role <h3>");
		out.println("<h3> i will be very happy  <h3>");
		out.println("<br>");
		out.println(("</br>"));
		out.println("</body>");
		out.println("</html>");
		
		out.println(("</br>"));RequestDispatcher disp=req.getRequestDispatcher("Footer.html");
		disp.include(req, resp);
		
	}
}
