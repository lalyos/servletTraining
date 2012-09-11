package com.acme.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GirlsServlet
 */
public class GirlsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GirlsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Girl> girls = (List<Girl>) getServletContext().getAttribute(CVServlet.GIRLS);
		if(girls == null || girls.isEmpty()) {
		    response.getOutputStream().println("<h2>No girls yet.</h2>");
		} else {
            response.getOutputStream().println("<h2>List of girls</h2> <ul>");
    		for (Girl girl : girls) {
                //response.getOutputStream().println("<li>" + girl + "</li>");
    		    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/showGirl");
    		    request.setAttribute("name", girl.getName());
    		    dispatcher.include(request, response);
            }
            response.getOutputStream().println("</ul");
            response.setContentType("text/html");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
