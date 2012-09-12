package com.acme.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyOrdersServlet
 */
public class MyOrdersServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyOrdersServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<Long, Order> orders = getOrders();
        List<Order> myOrders = new ArrayList<Order>();
        
        String myName = getUserName(request);
        response.setContentType("text/html");

        for (Order order : orders.values()) {
            if (order.getGirl().getName().equals(myName) && ! order.getIsFulfilled()) {
                myOrders.add(order);
            }
        }
        
        response.getWriter().println("<h2>list of MY Orders</h2> <ul>");
        for (Order order : myOrders) {
             response.getWriter().println("<li> <a href='fulfill?orderId=" + order.getId() 
        + "'>fulfill </a>" + order.toString() + "</li>");
        }
        response.getWriter().println("</ul>");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
