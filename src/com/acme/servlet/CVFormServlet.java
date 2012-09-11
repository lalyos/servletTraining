package com.acme.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CVFormServlet
 */
public class CVFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CVFormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        generateForm(response);	
    }

    private void generateForm(HttpServletResponse response) throws IOException {
        response.getOutputStream().println("<!DOCTYPE html>");
        response.getOutputStream().println("<html>");
        response.getOutputStream().println("<head>");
        response.getOutputStream().println("<meta charset=\"UTF-8\">");
        response.getOutputStream().println("<title>Insert title here</title>");
        response.getOutputStream().println("</head>");
        response.getOutputStream().println("<body>");
        response.getOutputStream().println("");
        response.getOutputStream().println("<form action=\"CVServlet\" method=\"post\">");
        response.getOutputStream().println(" <br>Name: <input type=\"text\" name=\"name\" />");
        response.getOutputStream().println(" <br>Breast Size: <input type=\"text\" name=\"breast\" />");
        response.getOutputStream().println(" <br>Basket type: <select name=\"basket\">");
        response.getOutputStream().println(" <option value=\"A\" >A</option>");
        response.getOutputStream().println(" <option value=\"B\" >B</option>");
        response.getOutputStream().println(" <option value=\"C\" >C</option>");
        response.getOutputStream().println(" <option value=\"D\" >D</option>");
        response.getOutputStream().println("</select>");
        response.getOutputStream().println(" <br><input type=\"submit\" value=\"Send\"/>");
        response.getOutputStream().println("</form>");
        response.getOutputStream().println("");
        response.getOutputStream().println("</body>");
        response.getOutputStream().println("</html>");
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        generateForm(response);   
	}

}
