<%@page import="bean.About"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@include file="templates/public/inc/header.jsp"%>
		<!-- banner-text -->
		<div class="banner-text">	
			<div class="container">
				<h2>Delicious food from the <br> <span>Best Chefs For you.</span></h2> 
			</div>
		</div>
	</div>
	<!-- //banner -->    
	<!-- breadcrumb -->  
	<div class="container">	
		<ol class="breadcrumb w3l-crumbs">
			<li><a href="#"><i class="fa fa-home"></i> Home</a></li> 
			<li class="active">About</li>
		</ol>
	</div>
	<!-- //breadcrumb -->
	<!--  about-page -->
	<div class="about">
		<div class="container"> 
		<% ArrayList<About> listAbout = (ArrayList<About>)request.getAttribute("about");
			if(listAbout!=null){
				for(About about : listAbout){
					%>
			<h3 class="w3ls-title w3ls-title1"><%=about.getTitle()%></h3>
			<p><%=about.getDetail()%></p>
				<%}}%>
		</div>
		
	</div>
	<!-- //about-page --> 
	<%@include file="templates/public/inc/footer.jsp"%>
	<!-- //footer -->
	<!-- cart-js -->
	<script src="<%=request.getContextPath()%>/js/minicart.js"></script>
	<!-- //cart-js -->	
	<!-- start-smooth-scrolling -->
	<script src="<%=request.getContextPath()%>/js/SmoothScroll.min.js"></script>  
	<script src="<%=request.getContextPath()%>/js/move-top.js"></script>
	<script src="<%=request.getContextPath()%>/js/easing.js"></script>	
	<!-- //end-smooth-scrolling -->	  
	<!-- smooth-scrolling-of-move-up -->

	<!-- //smooth-scrolling-of-move-up --> 
	<!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="<%=request.getContextPath()%>/js/bootstrap.js"></script>
</body>
</html>