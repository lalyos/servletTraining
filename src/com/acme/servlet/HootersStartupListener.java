package com.acme.servlet;

import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Application Lifecycle Listener implementation class HootersStartupListener
 *
 */
public class HootersStartupListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public HootersStartupListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent event) {
        ServletContext servletContext = event.getServletContext();
        ArrayList<Girl> girls = new ArrayList<Girl>();
        servletContext.setAttribute(BaseServlet.GIRLS, girls);
        
        Girl suzy = new Girl("suzy", 95, "B");
        girls.add(suzy);
        girls.add(new Girl("lucy", 100, "B"));
        girls.add(new Girl("sindy", 120, "D"));
        girls.add(new Girl("michelle", 92, "C"));
        girls.add(new Girl("Árvíztűrő tükörfúrógép", 80, "B"));
        
        Map<Long, Order> orders = new ConcurrentHashMap<Long, Order>();
        servletContext.setAttribute("orders", orders);
        
        addOrder(suzy, orders, "jeno", "pacal");
        addOrder(suzy, orders, "geza", "gyufa");
        addOrder(suzy, orders, "balamber", "sport froccs");
        
    }

    private void addOrder(Girl suzy, Map<Long, Order> orders, String customer, String food) {
        Order order = new Order(customer, suzy, food);
        orders.put(order.getId(), order);
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0) {
        // TODO Auto-generated method stub
    }
	
}
