<%@include file="/WEB-INF/boot-head" %>

<h2>Add girl</h2>

<form class="form-horizontal" action="addGirl.jsp" method="POST">
  <div class="control-group">
    <label class="control-label" for="name">Name</label>
    <div class="controls">
      <input type="text" id="name" name="name" placeholder="First name">
    </div>
  </div>
  <div class="control-group ">
    <label class="control-label" for="breastSize">Breast</label>
    <div class="controls">
      <input type="text" id="breastSize" name="breastSize" placeholder="breast size in cm">      
    </div>
  </div>

  <div class="control-group">
    <label class="control-label" for="basket">Basket</label>
    <div class="controls">
      <select id="basket" name="basket">
 <option value="A" >A</option>
 <option value="B" >B</option>
 <option value="C" >C</option>
 <option value="D" >D</option>
</select>
    </div>
  </div>

  <div class="control-group">
    <div class="controls">
      <button type="submit" class="btn">Add</button>
    </div>
  </div>
</form>

<%@include file="/WEB-INF/boot-foot" %>
