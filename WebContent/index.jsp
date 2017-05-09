<%@page import="bean.Products"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@include file="templates/public/inc/header.jsp"%>
	<!-- banner-text -->
<%@include file="search-module/search-module.jsp"%>			
	<!-- //banner -->  
	 
	<!-- dishes -->
	<div class="w3agile-spldishes">
		<div class="container">
		<h4 class="w3ls-title">Mới Nhất</h4>
			<div class="spldishes-agileinfo"> 
				<div class="col-md-12 spldishes-grids">
					<!-- Owl-Carousel -->
					<div id="owl-demo" class="owl-carousel text-center agileinfo-gallery-row">
					<%ArrayList<Products> listProHome = (ArrayList<Products>)request.getAttribute("listProHome");
						if(!listProHome.isEmpty()){
							for(Products pro2 : listProHome){%>
						<a href="<%=request.getContextPath()%>/home/detail-products?id=<%=pro2.getId_product()%>" class="item g1">
							<img class="lazyOwl" src="<%=request.getContextPath()%>/files/<%=pro2.getPicture1_product() %>" title="<%=pro2.getName_product() %>" alt=""/>
							<div class="agile-dish-caption">
								<h4><%=pro2.getName_product() %></h4>
								<span><%=pro2.getAddress_product() %></span>
							</div>
						</a>
					<%}} %>	
					</div> 
				</div>  
				<div class="clearfix"> </div>
			</div>
			
			<div class="spldishes-agileinfo"> 
				<div class="col-md-12 spldishes-grids">
					<!-- Owl-Carousel -->
					<div id="owl-demo-i" class="owl-carousel text-center agileinfo-gallery-row">
					<%ArrayList<Products> listProHome2 = (ArrayList<Products>)request.getAttribute("listProHome2");
						if(!listProHome2.isEmpty()){
							for(Products pro3 : listProHome2){%>
						<a href="<%=request.getContextPath()%>/home/detail-products?id=<%=pro3.getId_product()%>" class="item g1">
							<img class="lazyOwl" src="<%=request.getContextPath()%>/files/<%=pro3.getPicture1_product() %>" title="<%=pro3.getName_product() %>" alt=""/>
							<div class="agile-dish-caption">
								<h4><%=pro3.getName_product() %></h4>
								<span><%=pro3.getAddress_product() %></span>
							</div>
						</a>
					<%}} %>	
					</div> 
				</div>  
				<div class="clearfix"> </div>
			</div>
		</div>
	</div>
	<!-- //dishes --> 	
	<!-- deals -->
	
	<!-- //deals --> 
	<!-- dishes -->
	<div class="w3agile-spldishes">
		<div class="container">
		<h4 class="w3ls-title">Đề Xuất</h4>
			<div class="spldishes-agileinfo"> 
				<div class="col-md-12 spldishes-grids">
					<!-- Owl-Carousel -->
					<div id="owl-demo-ii" class="owl-carousel text-center agileinfo-gallery-row">
					<%ArrayList<Products> listProDeXuat = (ArrayList<Products>)request.getAttribute("listProDeXuat");
						if(!listProDeXuat.isEmpty()){
							for(Products pro4 : listProDeXuat){%>
						<a href="<%=request.getContextPath()%>/home/detail-products?id=<%=pro4.getId_product()%>" class="item g1">
							<img class="lazyOwl" src="<%=request.getContextPath()%>/files/<%=pro4.getPicture1_product() %>" title="<%=pro4.getName_product() %>" alt=""/>
							<div class="agile-dish-caption">
								<h4><%=pro4.getName_product() %></h4>
								<span><%=pro4.getAddress_product() %></span>
							</div>
						</a>
					<%}} %>	
					</div> 
				</div>  
				<div class="clearfix"> </div>
			</div>
			<div class="spldishes-agileinfo"> 
				<div class="col-md-12 spldishes-grids">
					<!-- Owl-Carousel -->
					<div id="owl-demo-iii" class="owl-carousel text-center agileinfo-gallery-row">
					<%ArrayList<Products> listProDeXuat2 = (ArrayList<Products>)request.getAttribute("listProDeXuat2");
						if(!listProDeXuat2.isEmpty()){
							for(Products pro5 : listProDeXuat2){%>
						<a href="<%=request.getContextPath()%>/home/detail-products?id=<%=pro5.getId_product()%>" class="item g1">
							<img class="lazyOwl" src="<%=request.getContextPath()%>/files/<%=pro5.getPicture1_product() %>" title="<%=pro5.getName_product() %>" alt=""/>
							<div class="agile-dish-caption">
								<h4><%=pro5.getName_product() %></h4>
								<span><%=pro5.getAddress_product() %></span>
							</div>
						</a>
					<%}} %>	
					</div> 
				</div>  
				<div class="clearfix"> </div>
			</div>
		</div>
	</div>
	<!-- //dishes -->	
	<%@include file="templates/public/inc/footer.jsp"%>
	<!-- cart-js -->
	<script src="<%=request.getContextPath()%>/js/minicart.js"></script>
	<script>
        w3ls.render();

        w3ls.cart.on('w3sb_checkout', function (evt) {
        	var items, len, i;

        	if (this.subtotal() > 0) {
        		items = this.items();

        		for (i = 0, len = items.length; i < len; i++) { 
        		}
        	}
        });
    </script>  
	<!-- //cart-js -->	
	<!-- Owl-Carousel-JavaScript -->
	<script src="js/owl.carousel.js"></script>
	<script>
		$(document).ready(function() {
			$("#owl-demo").owlCarousel ({
				items : 4,
				lazyLoad : true,
				autoPlay : true,
				pagination : true,
			});
		});
	</script>
	<script>
		$(document).ready(function() {
			$("#owl-demo-i").owlCarousel ({
				items : 4,
				lazyLoad : true,
				autoPlay : true,
				pagination : true,
			});
		});
	</script>
	<script>
		$(document).ready(function() {
			$("#owl-demo-ii").owlCarousel ({
				items : 5,
				lazyLoad : true,
				autoPlay : true,
				pagination : true,
			});
		});
	</script>
	<script>
		$(document).ready(function() {
			$("#owl-demo-iii").owlCarousel ({
				items : 5,
				lazyLoad : true,
				autoPlay : true,
				pagination : true,
			});
		});
	</script>
	<!-- //Owl-Carousel-JavaScript -->  
	<!-- start-smooth-scrolling -->
	<script src="<%=request.getContextPath()%>/js/SmoothScroll.min.js"></script>  
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/move-top.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/easing.js"></script>	
	<script type="text/javascript">
			jQuery(document).ready(function($) {
				$(".scroll").click(function(event){		
					event.preventDefault();
			
			$('html,body').animate({scrollTop:$(this.hash).offset().top},1000);
				});
			});
	</script>
	<!-- //end-smooth-scrolling -->	  
	<!-- smooth-scrolling-of-move-up -->
	<script src="<%=request.getContextPath()%>/js/search-module.js"></script>
	<!-- //smooth-scrolling-of-move-up --> 
	<!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="<%=request.getContextPath()%>/js/bootstrap.js"></script>
</body>
</html>