<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ attribute name="orderId" description="" required="true" type="java.lang.Long" %>

<c:set var="order" value="${orders[orderId]}"></c:set>
<%
com.acme.servlet.Order order = (com.acme.servlet.Order) jspContext.getAttribute("order");
order.fullfill();
%>
