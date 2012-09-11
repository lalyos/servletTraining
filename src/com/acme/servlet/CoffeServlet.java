package com.acme.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.SingleThreadModel;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CoffeServlet
 */
public class CoffeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CoffeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Date now = new Date();
        Date coffee = null;
        try {
            coffee = sdf.parse(getInitParameter("coffeeTime"));
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        long minutesLeft = (coffee.getTime() - now.getTime()) / 60000;
        response.getOutputStream().println("<!DOCTYPE html><html><head><meta charset=\"UTF-8\"><title>Servlet Training</title></head><body>");
        response.getOutputStream().println("Minutes left till coffee break: " + minutesLeft);
        response.getOutputStream().println("</body></html>");

    }


    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        // TODO Auto-generated method stub
    }

}
