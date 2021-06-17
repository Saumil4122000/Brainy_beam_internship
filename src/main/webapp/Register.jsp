<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register User</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>
</head>
<body>

<% if(request.getAttribute("error")!=null)
{
out.print(request.getAttribute("error"));
}
	
	%>

<div class="container">
<form class="row g-3 mt-3" method="post" action="RegistrationServlet">

 <fieldset style="border:1px solid #999; border-radius:8px; box-shadow:0 0 8px #999;padding:6px;">
  <legend style="text-align: left;margin-top:-5px;">Registration Form</legend>
	
  <div class="col-md-6">
    <label for="fname" class="form-label">First Name</label>
    <input type="text" class="form-control" id="fname" name="fname">
  </div>
  
  <div class="col-md-6">
    <label for="lname" class="form-label">Last Name</label>
    <input type="text" class="form-control" id="lname" name="lname">
  </div>
  
  <div class="col-md-6">
    <label for="inputEmail4" class="form-label">Email</label>
    <input type="email" class="form-control" id="inputEmail4" name="email">
  </div>
  <div class="col-md-6">
    <label for="inputPassword4" class="form-label">Password</label>
    <input type="password" class="form-control" id="inputPassword4" name="password">
  </div>
  
  <div class="col-12">
    <label for="inputAddress" class="form-label">Address</label>
    <input type="text" class="form-control" id="inputAddress" placeholder="1234 Main St" name="address">
  </div>

 
  <div class="col-12">
    <label for="phonenumber" class="form-label">Phone Number</label>
    <input type="phonenumber" type="tel"  pattern="[+]{1}[0-9]{11,14}"  class="form-control" id="phonenumber" name="phoneNumber" required>
  </div>
  <div class="col-12 mt-5">
    <button type="submit" class="btn btn-primary">Register</button>
  </div>
  </fieldset>
</form>
</div>
</body>
</html>