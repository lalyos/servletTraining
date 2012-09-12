package com.acme.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class OrderFormServlet
 */
public class OrderFormServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderFormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    response.setContentType("text/html");
		response.getWriter().println();

        response.getWriter().println("<form action='orderForm'  method='post' >");
        response.getWriter().println("<br/>Food: <input type=\"text\" name=\"food\" />");
        
        List<Girl> girls = getGirls();
        for (Girl girl : girls) {
            response.getWriter().println("<br/><input type=\"image\" src=\"" 
        + girl.getImageUrl() 
        + "\" width=\"100\" height=\"100\" name=\"girl\" value=\""
        + girl.getName()
        + "\" />");            
        }
        response.getWriter().println("</form>");		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String food = request.getParameter("food");
		String girlName = request.getParameter("girl");
		String customer = getUserName(request);
		
		
		Girl girl = getGirlByName(girlName);
		Order order = new Order(customer, girl, food);
		Map<Long, Order> orders = getOrders();
		orders.put(order.getId(), order);
		
		response.getWriter().println(String.format("Dear %s your order of %s has been accepted. %s will serv you. <br/>",
		        customer, food, girlName ));
		
		doGet(request, response);
	}

}
