<%@include file="/WEB-INF/boot-head" %>

<jsp:useBean id="girl" class="com.acme.servlet.Girl" />
<jsp:setProperty name="girl" property="name"  />
<jsp:setProperty name="girl" property="breastSize" param="breast" />
<jsp:setProperty name="girl" property="basket"  />


New girl added: <jsp:getProperty property="name" name="girl"/> 
(<jsp:getProperty name="girl" property="breastSize" /> cm - <jsp:getProperty name="girl" property="basket" />) 

<%@include file="/WEB-INF/boot-foot" %>
