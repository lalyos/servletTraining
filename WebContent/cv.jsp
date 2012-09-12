<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%@include file="/WEB-INF/boot-head" %>



<form class="form-horizontal" method="get">
  <div class="control-group">
    <label class="control-label" for="name">Name</label>
    <div class="controls">
      <input type="text" id="name" name="name" placeholder="Your name">
    </div>
  </div>
  <div class="control-group">
    <label class="control-label" for="breast">Breast</label>
    <div class="controls">
      <input type="text" id="breast" name="breast" placeholder="breast size in cm">
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
      <button type="submit" class="btn">Apply to JOB</button>
    </div>
  </div>
</form>
<%@include file="/WEB-INF/boot-foot" %>
