package com.acme.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CVServlet
 */
public class CVServlet extends HttpServlet {
    static final String GIRLS = "girls";
    private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CVServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		checkAplicant(request, response);
	}

    private void checkAplicant(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String breastString = request.getParameter("breast");
		Integer breast = Integer.valueOf(breastString);
		
		String name = request.getParameter("name");
		
		if (breast > 90) {
		    response.getOutputStream().println("Welcome in the Hooters team : " + name );
		    
		    Girl girl = new Girl(name, breast, request.getParameter("basket"));
		    List<Girl> girls = (List<Girl>) getServletContext().getAttribute(GIRLS);
		    if (girls == null) {
		        girls = new ArrayList<Girl>();
		        getServletContext().setAttribute(GIRLS, girls);
		    }
		    girls.add(girl);
		    
		} else{
            response.getOutputStream().println("Sorry " + name + " we don't have any open position.");
		    
		}
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    checkAplicant(request, response);
	}

}
