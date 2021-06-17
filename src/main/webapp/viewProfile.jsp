<%@page import="com.brainy_beam.ahmlive.entity.User"%>
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

    <title>Home Page</title>  
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">    
    <link rel="stylesheet" href="assets/css/fontawesome.css">
    <link rel="stylesheet" href="assets/css/templatemo-seo-dream.css">
    <link rel="stylesheet" href="assets/css/animated.css">
    <link rel="stylesheet" href="assets/css/owl.css">
</head>

<body>
<%response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
 HttpSession sessionObj = request.getSession(false);
 User user = new User();
 if(sessionObj.getAttribute("userData") == null){
	 response.sendRedirect(request.getContextPath()+"/Login.jsp");
 }
 else{
	 user = (User)sessionObj.getAttribute("userData");
 }
 if(request.getAttribute("error") != null){
 %>
 <div class="alert fixed-top alert-danger alert-dismissible fade show" role="alert">
		  <strong>Error! </strong> <%=request.getAttribute("error")  %>
		  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
		    <span aria-hidden="true">&times;</span>
		  </button>
	</div>
 <%
 }
 if(request.getAttribute("success") != null){
 %>
 <div class="alert fixed-top alert-success alert-dismissible fade show" role="alert">
		  <strong>Success! </strong> <%=request.getAttribute("success")  %>
		  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
		    <span aria-hidden="true">&times;</span>
		  </button>
	</div>
 <%
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
              <li class="scroll-to-section"><a href="<%= request.getContextPath()%>/complain.jsp">Compaints</a></li>
              <li class="scroll-to-section"><a href="#top" class="active">Profile</a></li>
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



  <div class="main-banner wow fadeIn" id="top" data-wow-duration="1s" data-wow-delay="0.5s">
    <div class="container">
      <div class="row">
        <div class="col-lg-12">
          <div class="row">
            <div class="col-lg-6 align-self-center">
              <div class="left-content header-text wow fadeInLeft" data-wow-duration="1s" data-wow-delay="1s">
                <div class="row">
						
						<p>hi</p>
               
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



	 <div id="services" class="our-services section">
    <div class="container">
      <div class="row">
        <div class="col-lg-6 offset-lg-3">
          <div class="section-heading wow bounceIn" data-wow-duration="1s" data-wow-delay="0.2s">
            <h6>Our Services</h6>
            <h2>Discover What We Do &amp; <span>Offer</span> To Our <em>Clients</em></h2>
          </div>
        </div>
      </div>
    </div>
    <div class="container-fluid">
      <div class="row">
        <div class="col-lg-4">
          <div class="service-item wow bounceInUp" data-wow-duration="1s" data-wow-delay="0.3s">
            <div class="row">
              <div class="col-lg-18">
                <div class="icon">
                  <img src="assets/images/profileimg.jfif" alt="">
                </div>
              </div>
              <div class="col-lg-8">
                <div class="right-content">
                  <h4>First Name</h4>
                  <p><%= user.getFname() %></p>
                </div>
              </div>
              
              <div class="col-lg-8">
                <div class="right-content">
                  <h4>Last Name</h4>
                  <p><%= user.getLname() %></p>
                </div>
              </div>
              
              <div class="col-lg-8">
                <div class="right-content">
                  <h4>Phone Number</h4>
                  <p><%= user.getPhoneNumber() %></p>
                </div>
              </div>
              
              
              <div class="col-lg-8">
                <div class="right-content">
                  <h4>Email</h4>
                  <p><%= user.getEmail() %></p>
                </div>
              </div>
              
               <div class="col-lg-8">
                <div class="right-content">
                  <h4>Address</h4>
                  <p><%= user.getAddress() %></p>
                </div>
              </div>
              
              <div class="col-lg-8">
                <div class="right-content">
                  <h4>Password</h4>
                  <p><%= user.getPassword() %></p>
                </div>
              </div>
            </div>
          </div>
        </div>




  <div id="contact" class="contact-us section">
    <div class="container">
      <div class="row">
        <div class="col-lg-12 wow fadeInUp" data-wow-duration="0.5s" data-wow-delay="0.25s">
          <form id="contact" action="UserServlet" method="post">
            <div class="row">
              <div class="col-lg-6 offset-lg-3">
                <div class="section-heading">
                  <h6>Contact Us</h6>
                  <h2>User <span>Profile</span></h2>
                </div>
              </div>
              <div class="col-lg-9">
                <div class="row">
                  <div class="col-lg-6">
                    <fieldset>
                      <label for="fname" class="form-label">First Name</label>
                      <input type="text" name="fname"  id="fname" placeholder="FirstName" value="<%= user.getFname() %>" autocomplete="on" required>
                    </fieldset>
                  </div>
                  <div class="col-lg-6">
                    <fieldset>
                    <label for="lname" class="form-label">First Name</label>
                      <input type="text" name="lname" id="lname" placeholder="LastName" value="<%=user.getLname() %>" autocomplete="on" required>
                    </fieldset>
                  </div>
                  <div class="col-lg-6">
                    <fieldset>
                     <label for="email" class="form-label">Email</label>
                      <input type="text" name="email" id="email" value="<%=user.getEmail() %>" placeholder="Your Email" required>
                    </fieldset>
                  </div>
                   <div class="col-lg-6">
                    <fieldset>
                     <label for="password" class="form-label">Email</label>
                      <input type="text" name="password" id="password" value="<%= user.getPassword() %>" placeholder="Your password" >
                    </fieldset>
                  </div>
                  <div class="col-lg-6">
                    <fieldset>
                     <label for="phoneNumber" class="form-label">Phone Number</label>
                      <input type="text" name="phoneNumber" id="subject" value="<%= user.getPhoneNumber() %>" autocomplete="on">
                    </fieldset>
                  </div>
                  <div class="col-lg-12">
                    <fieldset>
                     <label for="address" class="form-label">Address</label>
                      <textarea name="address" type="text" class="form-control" id="address"  required><%=user.getAddress() %></textarea>  
                    </fieldset>
                  </div>
                  <div class="col-lg-12">
                    <fieldset>
                      <button type="submit" id="form-submit" class="main-button ">Update Profile</button>
                    </fieldset>
                  </div>
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
          <p>Copyright © 2021 SEO Dream Co., Ltd. All Rights Reserved. 
          
          <br>Web Designed by <a rel="nofollow" href="https://templatemo.com" title="free CSS templates">TemplateMo</a></p>
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