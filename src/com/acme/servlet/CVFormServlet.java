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
        generateForm(request, response);	
    }

    private void generateForm(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.getWriter().println("<!DOCTYPE html>");
        response.getWriter().println("<html>");
        response.getWriter().println("<head>");
        response.getWriter().println("<meta charset=\"UTF-8\">");
        response.getWriter().println("<title>Insert title here</title>");
        response.getWriter().println("</head>");
        response.getWriter().println("<body>");
        response.getWriter().println("");
        
        String msg = (String) request.getAttribute("errorMessage");
        if (msg != null) {
            response.getWriter().println("<div style='color: red;'>"
                    + msg + " </div>");
        }
        
        String value = request.getParameter("name");
        if (value == null) {
            value="";
        }
        
        response.getWriter().println("<form action=\"CVServlet\" method=\"post\">");
        response.getWriter().println(" <br>Name: <input type=\"text\" name=\"name\" value=\"" + value + "\" />");
        response.getWriter().println(" <br>Breast Size: <input type=\"text\" name=\"breast\" />");
        response.getWriter().println(" <br>Basket type: <select name=\"basket\">");
        response.getWriter().println(" <option value=\"A\" >A</option>");
        response.getWriter().println(" <option value=\"B\" >B</option>");
        response.getWriter().println(" <option value=\"C\" >C</option>");
        response.getWriter().println(" <option value=\"D\" >D</option>");
        response.getWriter().println("</select>");
        response.getWriter().println(" <br><input type=\"submit\" value=\"Send\"/>");
        response.getWriter().println("</form>");
        response.getWriter().println("");
        response.getWriter().println("</body>");
        response.getWriter().println("</html>");
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        generateForm(request, response);   
	}

}
