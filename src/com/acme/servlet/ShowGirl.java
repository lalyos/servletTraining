package com.acme.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShowGirl
 */
public class ShowGirl extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowGirl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
	    
        InputStream inputStream = getServletContext().getResourceAsStream("/WEB-INF/mystyle");
        InputStreamReader isr = new InputStreamReader(inputStream);
        BufferedReader reader = new BufferedReader(isr);
        String text = "";
         
        while ((text = reader.readLine()) != null) {
            response.getWriter().println(text);
        }

		List<Girl> girls = getGirls();
		String name = request.getParameter("name");
		if (name == null) {
		    name = (String) request.getAttribute("name");
		}
		
		if (girls == null || girls.isEmpty()) {
		    response.getWriter().println("no such girl found: " + name);
		} else {
	        for (Girl girl : girls) {
	            if (girl.getName().equals(name)) {
	                
	                //response.getWriter().println("<style>.box {  text-shadow: 0 1px 0 rgba(255, 255, 255, 0.5);  width: 180px;   float: left;    margin: 8px;    padding: 8px;   -moz-box-shadow: 5px 5px 10px 3px #ccc; -webkit-box-shadow: 5px 5px 10px 3px #CCC;  box-shadow: 5px 5px 10px 3px #CCC;      padding: 8px 35px 8px 14px; margin-bottom: 18px;    text-shadow: 0 1px 0 rgba(255, 255, 255, 0.5);  background-color: #FCF8E3;  border: 1px solid #FBEED5;  -webkit-border-radius: 4px; -moz-border-radius: 4px;    border-radius: 4px; color: #C09853;}</style>");
                    response.getWriter().println("<div class='box' >");
                    response.getWriter().println("<img class=\"img-rounded\" width='100px' height='100px'  src='" + girl.getImageUrl() + "' />");
                    response.getWriter().println(girl.getName());
                    response.getWriter().println("</div>");
	            }
	        }
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
