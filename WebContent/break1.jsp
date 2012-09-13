<%@taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
anyad-2

<fmt:parseDate var="goHome" pattern="yyyy-MM-dd HH:mm"  value="2012-09-13 17:00"/>
<fmt:formatDate value="${goHome}" pattern="yyyy-MM-dd HH:mm" var="formattedGoHome"/> 
gohome:  ${formattedGoHome}

<jsp:useBean id="now" class="java.util.Date"/>

<fmt:formatNumber />
<h1>minutes left till gohome ${(goHome.time-now.time) / 60000}</h1>