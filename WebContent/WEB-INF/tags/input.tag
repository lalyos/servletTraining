<%@ tag language="java" pageEncoding="UTF-8" body-content="empty" dynamic-attributes="dinamitMap" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<%@ attribute name="name" required="true" type="java.lang.String" %>
<%@ attribute name="type" required="false" type="java.lang.String" %>
<%@ attribute name="placeholder" required="false" type="java.lang.String" %>
 
 
 <fmt:setBundle basename="messages"/>
 <fmt:message key="form.${name}.label" var="label"/>

<c:choose>
<c:when test="${type eq 'text' || empty type }">

  <div class="control-group">
    <label class="control-label" for="${name}"> ${label} </label>
    <div class="controls">
      <input type="text" id="${name}" name="${name}" placeholder="${placeholder}" 
      
 <c:forEach var="entry" items="${dinamitMap}">
 ${entry.key}="${entry.value}"
 </c:forEach>
      
      >
    </div>
  </div>
</c:when>
<c:otherwise>
 TODO ...
</c:otherwise>
 </c:choose>