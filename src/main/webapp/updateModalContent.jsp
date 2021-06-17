<%@page import="com.brainy_beam.ahmlive.entity.Complain"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <!DOCTYPE html>
<html lang="en">

  <head>

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@300;400;600;700;800&display=swap" rel="stylesheet">

    <title>SEO Dream - Creative SEO HTML5 Template by TemplateMo</title>

    <!-- Bootstrap core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">


    <link rel="stylesheet" href="assets/css/fontawesome.css">
    <link rel="stylesheet" href="assets/css/templatemo-seo-dream.css">
    <link rel="stylesheet" href="assets/css/animated.css">
    <link rel="stylesheet" href="assets/css/owl.css">


</head>
    	<body>
    	<% 
	  Complain complainObj  = new Complain();
	  if(request.getAttribute("complain") != null){
	  	complainObj = (Complain)request.getAttribute("complain");
		%>
		<div class="modal-header">
             <h5 class="modal-title" id="exampleModalLabel">Update Complain</h5>
             <button type="button" class="btn-close btn" data-bs-dismiss="modal" aria-label="Close">
             	<span aria-hidden="true">&times;</span>
             </button>
         </div>
         <form action="comlainServlet" method="post">
          <div class="modal-body">
                  <div class="mb-3">
                      <label for="title" class="form-label">Title</label>
                      <input type="text" class="form-control py-0" id="title" name="title" value="<%= complainObj.getTitle() %>"
                  placeholder="Enter Title ..." required>
          </div>
          <div class="mb-3">
              <label for="description" class="form-label">Description</label>
              <textarea class="form-control py-0" rows="1" id="description" name="description"
                  placeholder="Enter Description ..." required><%= complainObj.getDescription()%></textarea>
          </div>
          <div class="mb-3">
              <label for="phoneNo" class="form-label">Mobile No.</label>
              <input type="text" class="form-control py-0" id="phoneNo" name="phoneNo"
                  placeholder="Enter Mobile No. ..." value="<%= complainObj.getMobileNo() %>" required>
          </div>
          <div class="mb-3">
              <label for="address" class="form-label">Address</label>
              <textarea class="form-control py-0" rows="1" id="address" name="address"
                  placeholder="Enter Address ..." required><%= complainObj.getAddress() %></textarea>
          </div>
          <input type="hidden" name="id" value="<%= complainObj.getId() %>">
  </div>
  <div class="modal-footer">
      <button type="Submit" class="btn btn-primary">Update Complain</button>
  </div>
 </form>
 <%}%>
 
 
 
 </body>
 </html>