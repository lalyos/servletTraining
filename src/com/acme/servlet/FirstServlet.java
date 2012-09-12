package com.acme.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FirstServlet
 */
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FirstServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
	    //response.getWriter().println("<!DOCTYPE html><html><head><meta charset=\"UTF-8\"><title>Servlet Training</title></head><body>");
        response.getWriter().println("my first eclipse servlet");
        String servletContext = request.getContextPath();
        response.getWriter().println("<br> <a href=\"" + servletContext  + "/index.html\"> home</a>");
        //response.getWriter().println("</body></html>");
        
        //response.setContentType("text/html");
        response.setHeader("Content-Type", "text/html");
        response.setHeader("CoffeTYime", "13:45");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
