package com.acme.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BaseServlet extends HttpServlet {

    protected static final String GIRLS = "girls";

    String getUserName(HttpServletRequest request) {
        return (String) request.getSession().getAttribute("userName");
    }

    protected Map<Long, Order> getOrders() {
        Map<Long, Order> orders = (Map<Long, Order>) getServletContext().getAttribute("orders");
    	if (orders == null) {
    	    orders = new ConcurrentHashMap<Long, Order>();
    	    getServletContext().setAttribute("orders", orders);
    	}
        return orders;
    }

    protected List<Girl> getGirls() {
        List<Girl> girls = (List<Girl>) getServletContext().getAttribute(GIRLS);
        if (girls == null) {
            girls = new ArrayList<Girl>();
            getServletContext().setAttribute(GIRLS, girls);
        }
        return girls;
    }

    protected Girl getGirlByName(String name) {
        List<Girl> girls = getGirls();
        for (Girl girl : girls) {
            if (girl.getName().equals(name)) {
                return girl;
            }
        }
        throw new RuntimeException("No SuchGirl: " + name);
    }

    protected Order getOrderById(String orderId) {
        Order order = getOrders().get(Long.valueOf(orderId));
        if (order == null) {
            throw new RuntimeException("No Such Order, id:" + orderId);
        }
        return order;
    }
    
    protected void includeResource(HttpServletResponse response, String resourcePath) {
        InputStream inputStream = getServletContext().getResourceAsStream(resourcePath);
        InputStreamReader isr = new InputStreamReader(inputStream);
        BufferedReader reader = new BufferedReader(isr);
        String text = "";

        try {
            while ((text = reader.readLine()) != null) {
                response.getWriter().println(text);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    
}
