<%@page import="bean.Products"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@include file="templates/public/inc/header.jsp"%>
<%@include file="search-module/search-module.jsp"%>	
	<!-- banner-text -->
	<div class="products">	 
		<div class="container">
			<div class="col-md-9 product-w3ls-right"> 
				<div class="product-top">
					<h4>Food Collection</h4>
					<ul> 
						<li class="dropdown head-dpdn">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown">Filter By<span class="caret"></span></a>
							<ul class="dropdown-menu">
								<li><a href="#">Low price</a></li> 
								<li><a href="#">High price</a></li>
								<li><a href="#">Latest</a></li>  
							</ul> 
						</li>
						<li class="dropdown head-dpdn">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown">Food Type<span class="caret"></span></a>
							<ul class="dropdown-menu">
								<li><a href="#">Breakfast</a></li> 
								<li><a href="#">Lunch</a></li>
								<li><a href="#">Dinner</a></li>  
							</ul> 
						</li>
					</ul> 
					<div class="clearfix"> </div>
				</div>
				<div class="products-row">
				<%ArrayList<Products> listProDictrict = (ArrayList<Products>)request.getAttribute("listProType");
						if(!listProDictrict.isEmpty()){
							for(Products pro : listProDictrict){%>
					<div class="col-xs-6 col-sm-4 product-grids">
						<div class="flip-container">
							<div class="flipper agile-products">
								<div class="front"> 
									<img src="<%=request.getContextPath()%>/files/<%=pro.getPicture1_product() %>" class="img-responsive" alt="img">
									<div class="agile-product-text">              
										<h5><%=pro.getName_product() %></h5>  
									</div>  
								</div>
								<div class="back">
									<h4><%=pro.getName_product() %></h4>
									<h3><%=pro.getNameDictricts() %></h3>
									<p class="des-back-pro"><%=pro.getDescription_product() %></p>
									<h6><%=pro.getPrice_product() %><sup>vnđ</sup></h6>
									<h5><%=pro.getTimecreate_product() %></h5>
									<form action="#" method="post">
										<a href="" data-toggle="modal" data-target="#myModal1"
										data-whatever='{"id_history" : "<%=pro.getId_product()%>", "address" : "<%=pro.getAddress_product() %>",
										 "dictric": "<%=pro.getNameDictricts() %>", "typepro" : "<%=pro.getNameCat()%>",
										 "description": "<%= pro.getDescription_product() %>", "name":"<%= pro.getName_product() %>",
										 "price" : "<%=pro.getPrice_product() %>", "phone" : "<%=pro.getPhone_product() %>",
										 "date" : "<%=pro.getTimecreate_product() %>",
										 "picture": "<%=request.getContextPath()%>/files/<%= pro.getPicture1_product() %>"}'>
											Xem chi tiết
										</a>
									</form>
								</div>
							</div>
						</div> 
					</div>
					<%}}else{ %>
					<a href="<%=request.getContextPath()%>/home/create-product?type=load">Chưa có địa điểm phù hợp, thêm địa điểm mới?</a>
					<%} %> 
					<div class="clearfix"> </div>
				</div>
			</div>
			<div class="col-md-3 rsidebar">
				<div class="rsidebar-top">
					<div class="slider-left">
						<h4>CHOOSE BY AGE</h4>            
						<div class="row row1 scroll-pane">
							<label class="checkbox"><input type="checkbox" name="checkbox"><i></i>Kids</label>
							<label class="checkbox"><input type="checkbox" name="checkbox"><i></i>Youngers</label>  
							<label class="checkbox"><input type="checkbox" name="checkbox"><i></i>Adults</label> 
							<label class="checkbox"><input type="checkbox" name="checkbox"><i></i>Senior Citizen</label>  
						</div> 
					</div>
					<div class="sidebar-row">
						<h4>By Cuisine</h4>
						<ul class="faq">
							<li class="item1"><a href="#">Indian Food<span class="glyphicon glyphicon-menu-down"></span></a>
								<ul>
									<li class="subitem1"><a href="#">Breakfast</a></li>										
									<li class="subitem1"><a href="#">Lunch</a></li>										
									<li class="subitem1"><a href="#">Dinner</a></li>										
									<li class="subitem1"><a href="#">Trending Food</a></li>										
								</ul>
							</li>
							<li class="item2"><a href="#">Italian Food<span class="glyphicon glyphicon-menu-down"></span></a>
								<ul>
									<li class="subitem1"><a href="#">Panzanella</a></li>										
									<li class="subitem1"><a href="#">Margherita Pizza </a></li>										
									<li class="subitem1"><a href="#">Panna Cotta</a></li>										
									<li class="subitem1"><a href="#">Corn Cannelloni</a></li>										
								</ul>
							</li>
							<li class="item3"><a href="#">American Food<span class="glyphicon glyphicon-menu-down"></span></a>
								<ul>
									<li class="subitem1"><a href="#">Sandwiches</a></li>										
									<li class="subitem1"><a href="#">Hot dog</a></li>										
									<li class="subitem1"><a href="#">Chicken bog</a></li>										
								</ul>
							</li>
						</ul>
						<div class="clearfix"> </div> 
						<!-- script for tabs -->
						<script type="text/javascript">
							$(function() {
							
								var menu_ul = $('.faq > li > ul'),
									   menu_a  = $('.faq > li > a');
								
								menu_ul.hide();
							
								menu_a.click(function(e) {
									e.preventDefault();
									if(!$(this).hasClass('active')) {
										menu_a.removeClass('active');
										menu_ul.filter(':visible').slideUp('normal');
										$(this).addClass('active').next().stop(true,true).slideDown('normal');
									} else {
										$(this).removeClass('active');
										$(this).next().stop(true,true).slideUp('normal');
									}
								});
							
							});
						</script>
						<!-- script for tabs -->
					</div>
					<div class="sidebar-row">
						<h4>DISCOUNTS</h4>
						<div class="row row1 scroll-pane">  
							<label class="checkbox"><input type="checkbox" name="checkbox"><i></i>30% - 20% (2)</label>
							<label class="checkbox"><input type="checkbox" name="checkbox"><i></i>10% - 5% (5)</label>
							<label class="checkbox"><input type="checkbox" name="checkbox"><i></i>30% - 20% (7)</label>
							<label class="checkbox"><input type="checkbox" name="checkbox"><i></i>10% - 5% (2)</label>
							<label class="checkbox"><input type="checkbox" name="checkbox"><i></i>Other(50)</label>
						</div>
					</div>
					<div class="sidebar-row">
						<h4>DELIVERY TIME</h4>
						<div class="row row1 scroll-pane">
							<label class="checkbox"><input type="checkbox" name="checkbox" checked=""><i></i>6.30 am to 8.30 am</label>
							<label class="checkbox"><input type="checkbox" name="checkbox"><i></i>11.30 am to 1.30 pm</label>
							<label class="checkbox"><input type="checkbox" name="checkbox"><i></i>7.30 pm to 10.00 pm</label> 
						</div>
					</div>			 
				</div>
				<div class="related-row">
					<h4>Related Searches</h4>
					<ul>
						<li><a href="products.html">Salads </a></li>
						<li><a href="products.html">Vegetarian</a></li>
						<li><a href="products.html">Dinner</a></li>
						<li><a href="products.html">Diet Soup</a></li>
						<li><a href="products.html">Sweets</a></li>
						<li><a href="products.html">Seasonal</a></li>
						<li><a href="products.html">Breakfast</a></li>
						<li><a href="products.html">Italian Food</a></li>
						<li><a href="products.html">Meals</a></li> 
					</ul>
				</div>
			</div>
			<div class="clearfix"> </div> 
		</div>
	</div>
	<!-- //products --> 
	<!-- dishes -->
	<div class="w3agile-spldishes">
		<div class="container">
		<h4 class="w3ls-title">Đề Xuất</h4>
			<div class="spldishes-agileinfo"> 
				<div class="col-md-12 spldishes-grids">
					<!-- Owl-Carousel -->
					<div id="owl-demo" class="owl-carousel text-center agileinfo-gallery-row">
					<%ArrayList<Products> listProDeXuat = (ArrayList<Products>)request.getAttribute("listProDeXuat");
						if(!listProDeXuat.isEmpty()){
							for(Products pro : listProDeXuat){%>
						<a href="<%=request.getContextPath()%>/home/detail-products?id=<%=pro.getId_product()%>" class="item g1">
							<img class="lazyOwl" src="<%=request.getContextPath()%>/files/<%=pro.getPicture1_product() %>" title="<%=pro.getName_product() %>" alt=""/>
							<div class="agile-dish-caption">
								<h4><%=pro.getName_product() %></h4>
								<span><%=pro.getAddress_product() %></span>
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
	<!-- modal --> 
	<div class="modal video-modal fade" id="myModal1" tabindex="-1" role="dialog" aria-labelledby="myModal1">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>						
				</div>
				<section>
					<div class="modal-body">
						<div class="col-md-5 modal_body_left">
							<img src="" alt=" " class="img-responsive item_picture">
						</div>
						<div class="col-md-7 modal_body_right single-top-right"> 
							<h3 class="item_name"></h3>
							<div class="single-price">
								<ul>
									<li><span hidden="true"></span></li>  
									<li><span class="item_address"></span></li>
									<li><span class="item_dictric"></span></li>
									<li><span class="item_typepro"></span></li>
								</ul>	
							</div> 
							<div class="single-rating">
								<ul>
									<li><i class="fa fa-star-o" aria-hidden="true"></i></li>
									<li><i class="fa fa-star-o" aria-hidden="true"></i></li>
									<li><i class="fa fa-star-o" aria-hidden="true"></i></li>
									<li><i class="fa fa-star-o" aria-hidden="true"></i></li>
									<li class="w3act"><i class="fa fa-star-o" aria-hidden="true"></i></li>
									<li class="rating">20 reviews</li>
									<li><a href="#">Add your review</a></li>
								</ul> 
							</div>
							<div class="single-price">
								<ul>
									<li><span class="item_price"></span><sub>vnđ</sub></li>
									<li>Phone : <span class="item_phone"></span></li>  
									<li>Date :<span class="item_date"></span></li>
								</ul>	
							</div> 
							<p class="item_description"></p>
							<br>
							<a class="w3ls-cart w3ls-cart-like item_id_history" href="<%=request.getContextPath()%>/home/save-products?id="><i class="fa fa-heart-o" aria-hidden="true"></i> Lưu địa điểm</a>
							<div  class="single-page-icons social-icons"> 
								<ul>
									<li><h4>Share on</h4></li>
									<li><a id="shareBtn" href="#" class="fa fa-facebook icon facebook" data-href="https://developers.facebook.com/docs/plugins/" data-layout="button_count" data-size="small" data-mobile-iframe="true"> </a></li>
									<li><a href="#" class="fa fa-twitter icon twitter"> </a></li>
									<li><a href="#" class="fa fa-google-plus icon googleplus"> </a></li>
									<li><a href="#" class="fa fa-dribbble icon dribbble"> </a></li>
									<li><a href="#" class="fa fa-rss icon rss"> </a></li> 
								</ul>
							</div> 
						</div> 
						<div class="clearfix"> </div>
					</div>
				</section>
			</div>
		</div>
	</div> 
	<!-- //modal -->
	<script type="text/javascript">
		$(function()
		{
			$('.scroll-pane').jScrollPane();
		});
	</script>
	<script type="text/javascript">
			jQuery(document).ready(function($) {
				$(".scroll").click(function(event){		
					event.preventDefault();
			
			$('html,body').animate({scrollTop:$(this.hash).offset().top},1000);
				});
			});
			var $modal = $("#myModal1");
			$modal.on('show.bs.modal', function getvalue (event) {
				var button = $(event.relatedTarget); 
				var recipient = button.data('whatever');
				var $name = $modal.find(".item_name");
				var $dictric = $modal.find(".item_dictric");
				var $picture = $modal.find(".item_picture");
				var $description = $modal.find(".item_description");
				var $phone = $modal.find(".item_phone");
				var $date = $modal.find(".item_date")
				var $price = $modal.find(".item_price");
				var $id_history = $modal.find(".item_id_history");
				var $typepro = $modal.find(".item_typepro");
				var $address = $modal.find(".item_address");

				$name.html(recipient.name);
				$dictric.html(recipient.dictric);
				$picture.attr("src", recipient.picture);
				$phone.html(recipient.phone);
				$date.html(recipient.date);
				$description.html(recipient.description);
				$price.html(recipient.price);
				$id_history.attr("href",$id_history.attr("href") + recipient.id_history);
				$typepro.html(recipient.typepro);
				$address.html(recipient.address);
				
				
			});
			
	</script>
	<script>
		$(document).ready(function() {
			$("#owl-demo").owlCarousel ({
				items : 5,
				lazyLoad : true,
				autoPlay : true,
				pagination : true,
			});
		});
	</script>
	<script>
		$(document).ready(function() {
			$("#owl-demo-i").owlCarousel ({
				items : 5,
				lazyLoad : true,
				autoPlay : true,
				pagination : true,
			});
		});
	</script>
	<script type="text/javascript">
		$(document).ready(function() {	
			$().UItoTop({ easingType: 'easeOutQuart' });	
		});
	</script>
	<script>
		document.getElementById('shareBtn').onclick = function() {
	  	FB.ui({
	    method: 'share',
	    display: 'popup',
	    href: 'https://developers.facebook.com/docs/',
	 	 }, function(response){});
		}
	</script>
    <!-- Placed at the end of the document so the pages load faster -->
    <%@include file="templates/public/inc/footer.jsp"%>
	<script>(function(d, s, id) {
	  var js, fjs = d.getElementsByTagName(s)[0];
	  if (d.getElementById(id)) return;
	  js = d.createElement(s); js.id = id;
	  js.src = "//connect.facebook.net/vi_VN/sdk.js#xfbml=1&version=v2.9&appId=677729782390952";
	  fjs.parentNode.insertBefore(js, fjs);
	}(document, 'script', 'facebook-jssdk'));
	</script>

</body>
</html>