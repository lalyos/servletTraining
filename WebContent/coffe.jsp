<!DOCTYPE html>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page pageEncoding="UTF-8" %>
<%!
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");

long getMinutes() {
    Date coffe = null;
    try {
   	  coffe = sdf.parse("2012-09-12 15:45");
    } catch(Exception e) {
        e.printStackTrace();
    }
    Date now = new Date();
    return (coffe.getTime() - now.getTime()) / 60000;

}
%>

<%@include file="/WEB-INF/boot-head" %>


<!-- micsoda? -->
<%-- 

ez hova megy?
--%>

<%
/*
ez belemegy a servicebe ...
*/
%>

  <div class="row">
  <div class="alert alert-info span3">
   <button type="button" class="close" data-dismiss="alert">×</button>
  Minutes left till Árvíztűrő tükörfúrógép coffee break: <%= getMinutes() %>
  
  </div>
</div>
  

  <%@include file="/WEB-INF/boot-foot" %>
  