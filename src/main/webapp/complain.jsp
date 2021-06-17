<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ page import="com.brainy_beam.ahmlive.entity.User" %>
<%@ page import="java.util.*" %>
<%@ page import="com.brainy_beam.ahmlive.entity.Complain" %>
<%@ page import="com.brainy_beam.ahmlive.db.ComplainManagement" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
 <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@300;400;600;700;800&display=swap" rel="stylesheet">

    <title>Home Page</title>

    <!-- Bootstrap core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">


    <!-- Additional CSS Files -->
    <link rel="stylesheet" href="assets/css/fontawesome.css">
    <link rel="stylesheet" href="assets/css/templatemo-seo-dream.css">
    <link rel="stylesheet" href="assets/css/animated.css">
    <link rel="stylesheet" href="assets/css/owl.css">
</head>
<body>
<% response.setHeader("cache-control", "no-cache,no-store,must-revalidate");
	HttpSession sessionObj=request.getSession(false);

	List<Complain> complainList=new ArrayList<>();
	if(sessionObj.getAttribute("userData")==null){
		response.sendRedirect(request.getContextPath()+"/Login.jsp");
	}
	else{
		User user=(User)sessionObj.getAttribute("userData");
		complainList=new ComplainManagement().getAllComplainByUserId(user.getId());

	}
%>






  <!-- ***** Preloader Start ***** -->
  <div id="js-preloader" class="js-preloader">
    <div class="preloader-inner">
      <span class="dot"></span>
      <div class="dots">
        <span></span>
        <span></span>
        <span></span>
      </div>
    </div>
  </div>
  <!-- ***** Preloader End ***** -->

  <!-- ***** Header Area Start ***** -->
  <header class="header-area header-sticky wow slideInDown" data-wow-duration="0.75s" data-wow-delay="0s">
    <div class="container">
      <div class="row">
        <div class="col-12">
          <nav class="main-nav">
            <!-- ***** Logo Start ***** -->
            <a href="index.html" class="logo">
              <h4>SEO Dream <img src="assets/images/logo-icon.png" alt=""></h4>
            </a>
            <!-- ***** Logo End ***** -->
            <!-- ***** Menu Start ***** -->
            <ul class="nav">
              <li class="scroll-to-section"><a href="<%= request.getContextPath() %>/Home.jsp">Home</a></li>
              <li class="scroll-to-section"><a href="#top" class="active">Compaints</a></li>
              <li class="scroll-to-section"><a href="<%= request.getContextPath() %>/viewProfile.jsp">Profile</a></li>
              <li class="scroll-to-section"><a href="<%= request.getContextPath() %>/LogoutServlet">Sign Out</a></li>
             </ul>      
            <a class='menu-trigger'>
                <span>Menu</span>
            </a>
            <!-- ***** Menu End ***** -->
          </nav>
        </div>
      </div>
    </div>
  </header>
  <!-- ***** Header Area End ***** -->



  <div class="main-banner wow fadeIn" id="top" data-wow-duration="1s" data-wow-delay="0.5s">
    <div class="container">
      <div class="row">
        <div class="col-lg-12">
          <div class="row">
            <div class="col-lg-6 align-self-center">
              <div class="left-content header-text wow fadeInLeft" data-wow-duration="1s" data-wow-delay="1s">
                <div class="row">
                  
                  <div class="col-lg-4 col-sm-4">
                    <div class="info-stat">
                    <a href="#contact" class="tm-article-link"><h3 class="tm-article-title text-uppercase">Raise Complain</h3></a>
                    
                    </div>
                  </div>
                  <div class="col-lg-4 col-sm-4">
                    <div class="info-stat">
                     <a href="#displayComplain" class="tm-article-link"><h3 class="tm-article-title text-uppercase">Show Complain</h3></a>
                    
                    </div>
                  </div>
                 
                </div>
              </div>
            </div>
            <div class="col-lg-6">
              <div class="right-image wow fadeInRight" data-wow-duration="1s" data-wow-delay="0.5s">
                <img src="assets/images/banner-right-image.png" alt="">
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  


<table id="displayComplain" width="100%" cellspacing="10" cellpadding="10" border="3" align="center">
	<tr>
		<th>Id</th>
		<th>Title</th>
		<th>Description</th>
		<th>Address</th>
		<th>Mobile No</th>
		<th>Update</th>
		<th>Delete</th>
	</tr>
	
	<% int count=1; %>
	<c:forEach var="complain" items="<%=complainList %>">
		<tr>
			<td><c:out value="<%= count++ %>"/></td>
			<td><c:out value="${complain.title}"/></td>
			<td><c:out value="${complain.description} "/></td>
			<td><c:out value="${complain.address} "/></td>
			<td><c:out value="${complain.mobileNo} "/></td>
			<td><a href="<%= request.getContextPath() %>/comlainServlet?id=${complain.id}&action=update">Update</a></td>
			<td><a href="<%= request.getContextPath() %>/comlainServlet?id=${complain.id}&action=delete">Delete</a></td>
		</tr>
	</c:forEach>
</table>



 <div id="contact" class="contact-us section">
    <div class="container">
      <div class="row">
        <div class="col-lg-12 wow fadeInUp" data-wow-duration="0.5s" data-wow-delay="0.25s">
          <form id="contact" action="comlainServlet" method="post">
            <div class="row">
              <div class="col-lg-6 offset-lg-3">
                <div class="section-heading">
                  <h6>Contact Us</h6>
                  <h2>Fill Out The Form Below To <span>Get</span> In <em>Touch</em> With Us</h2>
                </div>
              </div>
              <div class="col-lg-9">
                <div class="row">
                  <div class="col-lg-6">
                    <fieldset>
                      <input type="text" name="title" id="title" placeholder="Enter title" autocomplete="on" required>
                    </fieldset>
                  </div>
                  
                   <div class="col-lg-6">
                    <fieldset>
                      <input type="text" name="phoneNo" id="phoneNo" placeholder="Enter phone" autocomplete="on" required>
                    </fieldset>
                  </div>
                 
                 
                 
                  <div class="col-lg-12">
                    <fieldset>
                      <textarea name="address" type="text" class="form-control" id="address" placeholder="address" required></textarea>  
                    </fieldset>
                  </div>
                   <div class="col-lg-12">
                    <fieldset>
                      <textarea name="description" type="text" class="form-control" id="description" placeholder="description" required></textarea>  
                    </fieldset>
                  </div>
                  <div class="col-lg-12">
                    <fieldset>
                      <button type="submit" id="form-submit" class="main-button ">Send Comp</button>
                    </fieldset>
                  </div>
                </div>
              </div>
              <div class="col-lg-3">
                <div class="contact-info">
                  <ul>
                    <li>
                      <div class="icon">
                        <img src="assets/images/contact-icon-01.png" alt="email icon">
                      </div>
                      <a href="#">info@company.com</a>
                    </li>
                    <li>
                      <div class="icon">
                        <img src="assets/images/contact-icon-02.png" alt="phone">
                      </div>
                      <a href="#">+001-002-0034</a>
                    </li>
                    <li>
                      <div class="icon">
                        <img src="assets/images/contact-icon-03.png" alt="location">
                      </div>
                      <a href="#"></a>
                    </li>
                  </ul>
                </div>
              </div>
            </div>
          </form>
        </div>
      </div>
    </div>
  </div>




  <footer>
    <div class="container">
      <div class="row">
        <div class="col-lg-12">
          <p>Copyright © 2021 Saumil Shah Dream Co., Ltd. All Rights Reserved. 
          <br>Web Designed by <a rel="nofollow" href="https://templatemo.com" title="free CSS templates">Shah Saumil</a></p>
        </div>
      </div>
    </div>
  </footer>

  <!-- Scripts -->
  <script src="vendor/jquery/jquery.min.js"></script>
  <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  <script src="assets/js/owl-carousel.js"></script>
  <script src="assets/js/animation.js"></script>
  <script src="assets/js/imagesloaded.js"></script>
  <script src="assets/js/custom.js"></script>

</body>
</html>