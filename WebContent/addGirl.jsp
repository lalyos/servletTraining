<%@include file="/WEB-INF/boot-head" %>

<jsp:useBean id="girl" class="com.acme.servlet.Girl" />
<jsp:setProperty name="girl" property="*"  />
<jsp:useBean id="girls" class="java.util.ArrayList" type="java.util.List" scope="application" />
<% girls.add(girl); %>

New girl added: ${girl.name } 
(${girl.breastSize} cm - ${girl.basket} ) 


Second girl's name: ${girls[2].name}
<%@include file="/WEB-INF/boot-foot" %>
