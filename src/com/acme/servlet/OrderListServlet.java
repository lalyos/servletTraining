package com.acme.servlet;

import java.io.IOException;
import java.util.Collection;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class OrderListServlet
 */
public class OrderListServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	       includeResource(response, "WEB-INF/boot-head");

	      Map<Long, Order> orders = getOrders();

	      response.setContentType("text/html");
          response.getWriter().println("<h2>list of Orders</h2> <table class=\"table table-striped\" >");

          response.getWriter().println("<thead><tr><th>#</th> <th>girl</th> <th>food</th> <th>state</th> </tr></thead>");

	      for (Order order : orders.values()) {
	           response.getWriter().println(String.format("<tr><td>%d</td> <td>%s</td> <td>%s</td> <td>%s</td> </tr>"
	                   ,order.getId() ,order.getGirl().getName() ,order.getFood() ,getStateHtml(order.getIsFulfilled()) ));
	      }
          response.getWriter().println("</table>");
          includeResource(response, "WEB-INF/boot-foot");

	}

	private Object getStateHtml(boolean isFulfilled) {
        if (isFulfilled) {
            return "<span class=\"label label-success\">Fulfilled</span>";
        } else {
            return "<span class=\"label label-warning\">Pending</span>";
            
        }
    }

    /**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
