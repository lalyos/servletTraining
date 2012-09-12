package com.acme.servlet;

import java.util.ArrayList;

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
        
        girls.add(new Girl("suzy", 95, "B"));
        girls.add(new Girl("lucy", 100, "B"));
        girls.add(new Girl("sindy", 120, "D"));
        girls.add(new Girl("michelle", 92, "C"));
        girls.add(new Girl("lacy", 80, "B"));
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0) {
        // TODO Auto-generated method stub
    }
	
}
