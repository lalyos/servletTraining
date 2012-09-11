package com.acme.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BreakServlet
 */
public class BreakServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private Date breakTime;

    private String message;
    
    private boolean isBefore = true;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BreakServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Date now = new Date();
        long minutesLeft = (breakTime.getTime() - now.getTime()) / 60000;
        minutesLeft = (isBefore ? minutesLeft : -1 * minutesLeft);
        
        response.getOutputStream().println("<!DOCTYPE html><html><head><meta charset=\"UTF-8\"><title>Servlet Training</title></head><body>");
        response.getOutputStream().println(message + " : " + minutesLeft);
        response.getOutputStream().println("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        message = config.getInitParameter("message");
        
        String isLateParamValue = config.getInitParameter("isLate");
        if (isLateParamValue != null && isLateParamValue.trim().equalsIgnoreCase("true")) {
            isBefore = false;
        }
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        try {
            breakTime = sdf.parse(config.getInitParameter("breakTime"));
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
