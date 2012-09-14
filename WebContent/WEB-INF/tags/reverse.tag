<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%@ tag language="java" pageEncoding="UTF-8" %>
<%@ attribute name="top" description="" required="false" type="java.lang.Integer" %>
<%@ attribute name="bottom" description="" required="false" type="java.lang.Integer" %>
<%@ attribute name="var" description="" required="true" type="java.lang.String" rtexprvalue="false" %>
<%@ variable variable-class="java.lang.Integer" name-from-attribute="var" alias="myVar" scope="AT_BEGIN"%>

<c:forEach begin="${bottom }" end="${top}" varStatus="internalVar">
<c:set var="myVar" value="${top-internalVar.count+1}"></c:set>
<jsp:doBody/>

</c:forEach>