<!DOCTYPE html>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page pageEncoding="UTF-8" %>

<!-- useBean begin -->
<jsp:useBean id="now" class="java.util.Date" />
<!-- useBean end -->

<%!
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
%>

<%@include file="/WEB-INF/boot-head" %>

<%
Date coffe = null;
try {
    coffe = sdf.parse("2012-09-13 10:45");
} catch(Exception e) {
    e.printStackTrace();
}
long minutes =  (coffe.getTime() - now.getTime()) / 60000;

%>
  <div class="row">
  <div class="alert alert-info span3">
   <button type="button" class="close" data-dismiss="alert">×</button>
  Minutes left till Árvíztűrő tükörfúrógép coffee break: <%= minutes %>
  
  </div>
  </div>
  
  <div class="row">
    <div class="progress progress-striped active span3">
    <div class="bar" style="width: <%=100 - minutes * 100 / 60%>%;"></div>
    </div>
</div>
</div>
  

  <%@include file="/WEB-INF/boot-foot" %>
  