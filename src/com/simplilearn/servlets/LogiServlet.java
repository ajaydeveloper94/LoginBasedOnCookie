package com.simplilearn.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LogiServlet
 */
@WebServlet("/login")
public class LogiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogiServlet() {}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//load login page
		response.setContentType("text/html");
		response.sendRedirect("login.html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		request.getRequestDispatcher("navigate.html").include(request, response);
		
		// collect user info
		String userName= request.getParameter("userName");
		String password= request.getParameter("password");
		
		if(userName.equals("admin@gmail.com") && password.equals("admin123")) {
			out.println("You are successfully Logged In !");
			out.println("Welcome to User app : "+ userName);
			
			// create cookie
			Cookie ck = new Cookie("uname", userName);
			response.addCookie(ck);
		}else {
			out.print("Sorry, Invalid credentials !");
			response.sendRedirect("login.html");
		}
	}

}
