<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:if test="${sessionScope.userName ne 'manager' }">
  <jsp:forward page="norights.jsp" />
</c:if>

You are to fire : ${param.girlName}