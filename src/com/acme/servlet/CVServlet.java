package com.acme.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CVServlet
 */
public class CVServlet extends BaseServlet {
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
        Integer breast = -1;
        try {
		  breast = Integer.valueOf(breastString);
        } catch(NumberFormatException e) {
            
        }
		log("breast size:" + breast);
		
		if (breast < 50) {
		    try {
		        log("tryind to forward... to '/cv'");
		        request.setAttribute("errorMessage", "Please enter a valid number into the breast field!");
                getServletContext().getRequestDispatcher("/cv").forward(request, response);
            } catch (ServletException e) {
                e.printStackTrace();
            }
		}
		String name = request.getParameter("name");
		
		if (breast > 90) {
		    response.getWriter().println("Welcome in the Hooters team : " + name );
		    
		    Girl girl = new Girl(name, breast, request.getParameter("basket"));
		    List<Girl> girls = getGirls();
		    girls.add(girl);
		    
		} else{
            response.getWriter().println("Sorry " + name + " we don't have any open position.");
		    
		}
    }

    /**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
	    log("choosen: " + request.getParameter("sub"));
	    checkAplicant(request, response);
	}

}
