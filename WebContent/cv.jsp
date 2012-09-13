<%@page import="com.acme.servlet.BaseServlet"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.acme.servlet.Girl"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="b" %>


<%!protected List<Girl> getGirls() {
        List<Girl> girls = (List<Girl>) getServletContext().getAttribute(BaseServlet.GIRLS);
        if (girls == null) {
            girls = new ArrayList<Girl>();
            getServletContext().setAttribute(BaseServlet.GIRLS, girls);
        }
        return girls;
    }%>    
    
    
    
<%
    String errorMessage = null;
    String applyMessage = null;
    int breast = -1;
    if (request.getMethod().equalsIgnoreCase("post")) {
        try {
            breast = Integer.valueOf(request.getParameter("breast"));

            if (breast < 90) {
                applyMessage = "Sorry " + request.getParameter("name") + " all jobs are taken ...";
            } else {
                getGirls().add(new Girl(request.getParameter("name"), breast, request.getParameter("basket")));
                applyMessage = "Welcome " + request.getParameter("name")
                            + " please contact Bela to receive your working instructions, and your new t-shirt.";
                }

            } catch (Exception e) {
                errorMessage = "please enter a valid number";
            }

        }
%>

<%@include file="/WEB-INF/boot-head" %>




<%
    if (errorMessage != null) {
%>
<div class="alert alert-error">
<%=errorMessage%>
</div>
<%
    }
%>

<%
    if (applyMessage != null) {
%>
<div class="alert alert-success">
<%=applyMessage%>
</div>
<%
    }
%>

v1.12
<form class="form-horizontal" method="POST">

<b:input name="name" placeholder="Your focking name" onclick="kaka" onVerySpecialFokinAttribute="true" />
  
  
  
  <div class="control-group  <%=errorMessage != null ? "error" : ""%>">
    <label class="control-label" for="breast">Breast</label>
    <div class="controls">
      <input type="text" id="breast" name="breast" placeholder="breast size in cm">
      
      
<%
                if (errorMessage != null) {
            %>
      <span class="help-inline"><%=errorMessage%></span>      
<%
          }
      %>
      
    </div>
  </div>

  <div class="control-group">
    <label class="control-label" for="basket">Basket</label>
    <div class="controls">
      <select id="basket" name="basket">
 <option value="A" >A</option>
 <option value="B" >B</option>
 <option value="C" >C</option>
 <option value="D" >D</option>
</select>
    </div>
  </div>

  <div class="control-group">
    <div class="controls">
      <button type="submit" class="btn">Apply</button>
    </div>
  </div>
</form>
<%@include file="/WEB-INF/boot-foot" %>
