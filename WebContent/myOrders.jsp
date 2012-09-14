<h2><fmt:message key="title.myorders" /></h2>

<c:if test="${not empty param.orderId }">
  <e:fullfill orderId="${param.orderId}" />
</c:if>

<table class="table table-striped table-condensed table-hover">
<thead>
  <tr>
    <c:forEach items="id, food, customer, state, action" var="nextHead">
      <th>${nextHead }</th>
    </c:forEach>
  </tr>
</thead>
<c:forEach items="${orders}" var="orderEntry">
<c:if test="${orderEntry.value.girl.name eq sessionScope.userName && not orderEntry.value.isFulfilled }">
  <tr>
    <td>${orderEntry.value.id }</td>
    <td>${orderEntry.value.food }</td>
    <td>${orderEntry.value.customer }</td>
    <td>${orderEntry.value.state }</td>
    <c:url var="deliverUrl" value="">
      <c:param name="orderId" value="${orderEntry.value.id }" />
    </c:url>
    <td><a href="${deliverUrl}" class="btn  ">Delivered</a></td>
  <tr>
</c:if>
</c:forEach>
</table>
