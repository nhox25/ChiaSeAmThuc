<%@page import="bean.Products"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@include file="templates/public/inc/header.jsp"%>
	<!-- banner-text -->
<%@include file="search-module/search-module.jsp"%>				
	<!-- //banner -->
	<div class="offers about"> 
		<div class="container"> 
			<h3 class="w3ls-title w3ls-title1">Our Offers</h3>  
			<div class="offers-wthreerow">  
				<div class="offers-right"> 
					<h5>10% Discount</h5>
					<p class="w3ls-offertext">Order Using Credit Card Get 10% Cashback</p>
					<br>
					<h5>5% Discount</h5>
					<p>The best Food Offer On Our Store</p>
				</div>
				<div class="clearfix"> </div>    
			</div>
			<div style="color:red">
					<%String msg = request.getParameter("msg");
					if(msg!=null){
					out.print(msg);}%></div>
			<div class="offers-wthreerow2">
			<%ArrayList<Products> listPro = (ArrayList<Products>)request.getAttribute("listPro");
					if(!listPro.isEmpty()){
						for(Products pro : listPro){%>
				<div class="add-products-row">
					<div class="w3ls-add-grids" style="background: url(<%=request.getContextPath()%>/files/<%=pro.getPicture1_product()%>)no-repeat 5px;">
						<a href="products.html"> 
							<h4>Price <span><%=pro.getPrice_product() %></span> vnđ</h4>
							<h5><%=pro.getName_product() %></h5>
							<h4>Active :<%=pro.getTimecreate_product() %><i class="fa fa-arrow-circle-right" aria-hidden="true"></i></h4>
							
						</a>
						<a class="del-products" href="<%=request.getContextPath()%>/home/del-product-user?id_product=<%=pro.getId_product() %>" onclick="return confirm('Bạn muốn xóa : <%=pro.getName_product()%> ?')">Delete
						</a>
						<a class="del-products" href="">
						Update
						</a>
					</div>
					<%}%>
					<div class="clearfix"> </div> 
				</div>
					<%}else{%>
					<div class="add-products-row">
					<h3>
					<a href="<%=request.getContextPath()%>/home/create-product?type=load">Bạn chưa có địa điểm nào, thêm địa điểm mới?</a>
					</h3>
					</div>
					<%}%>			 
			</div>
		</div>
	</div>
	
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
	<!-- //Owl-Carousel-JavaScript -->  
	<!-- start-smooth-scrolling -->
	<script src="<%=request.getContextPath()%>/js/SmoothScroll.min.js"></script>  
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/move-top.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/easing.js"></script>	
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