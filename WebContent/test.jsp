<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="/WEB-INF/boot-head" %>

<c:set var="x" scope="session" value="5" />

v1.1
<c:url value="fire.jsp" var="fireUrl" >
  <c:param name="girlName" value="suzy"></c:param>
</c:url>

<jsp:include page=""></jsp:include>


<hr/>
<a href="${fireUrl}" >delete</a>
<hr/>


<c:forEach  var="girl" items="${applicationScope.girls}" varStatus="status">
<div class="row"> 
  <a href="fire.jsp?girlName=${girl.name}" class="btn btn-danger">
  <i class="icon-remove" ></i> fire
  </a>
  
  <jsp:include page="showGirl.jsp">
    <jsp:param name="color" value="green"/>
    <jsp:param name="girlName" value="${girl.name}"/>
    
  </jsp:include>
</div>
</c:forEach>



<c:forEach var="next" items="${cookie}">
  <li> ${next.key} = ${next.value}
</c:forEach>
<hr/>

<%@include file="/WEB-INF/boot-foot" %>

