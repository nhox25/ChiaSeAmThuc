<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@include file="templates/public/inc/header.jsp"%>
	<!-- breadcrumb -->  
	<div class="container">	
		<ol class="breadcrumb w3l-crumbs">
			<li><a href="#"><i class="fa fa-home"></i> Home</a></li> 
			<li class="active">Đăng Ký</li>
		</ol>
	</div>
	<!-- //breadcrumb -->
	<!-- sign up-page -->
	<div class="login-page about">
		<img class="login-w3img" src="" alt="">
		<div class="container"> 
		<h3 class="w3ls-title w3ls-title1">Cho mọi người biết món ăn của bạn</h3>  	
			<div class="login-agileinfo">
			<h1>Thông tin cơ bản</h1> 		
				<form action="<%=request.getContextPath()%>/home/create-product" enctype="multipart/form-data" method="post">
					<div style="color:red">
					<%String msg = request.getParameter("msg");
					if(msg!=null){
					out.print(msg);}%></div>
						<input class="agile-ltext" type="text" name="name_product" placeholder="Tên món ăn" required="">
						<input class="agile-ltext" type="text" name="address_product" placeholder="Địa chỉ" required="">
						<select class="agile-ltext" name="dicrit_product" required="" required=""="Xin chọn quận">
						<option value="">Chọn Quận</option>
						<option value="Cẩm Lệ">Quận Cẩm Lệ</option>
						<option value="Hải Châu">Quận Hải Châu</option>
						<option value="Liên Chiểu">Quận Liên Chiểu</option>
						<option value="Ngũ Hành Sơn">Quận Ngũ Hành Sơn</option>
						<option value="Sơn Trà">Quận Sơn Trà</option>
						<option value="Thanh Khuê">Quận Thanh Khê</option>
						<option value="Hòa Vang">Hòa Vang</option>
						<option value="Hoàng Sa">Hoàng Sa</option></select>
						<input class="agile-ltext" type="text" name="price" placeholder="Giá bán" required="">
						<input class="agile-ltext" type="text" name="phone" placeholder="Điện thoại" required="">
						<input class="agile-ltext" type="email" name="email" placeholder="Email" required="">
						<input class="agile-ltext" type="text" name="website" placeholder="Website" required="">
						<br>
						<div>Mô Tả Thêm</div>
						<textarea class="ckeditor" name="description" placeholder="Mô tả" required=""></textarea>
						<select class="agile-ltext" name="style" required="" required="Xin chọn loại thức ăn">
						<option value="">Thuộc loại</option>
					<option value="Chay">Chay</option>
						<option value="Mặn">Mặn</option>
						<option value="Chay và Mặn">Chay và mặn</option></select>
						<br/>
						<input type="file" name="picture1" value="" />
						<br/>
						<input type="submit" name="add" value="Đăng Ký">
						<input type="reset" name="reset" value="Làm lại">
				</form>
				</div>
			</div>
			</div>	 
	</div>
	<!-- //sign up-page -->  
	<!-- subscribe -->
	<%@include file="templates/public/inc/footer.jsp"%>
	<!-- //subscribe --> 
	<!-- footer -->
	<!-- //footer -->
	<!-- cart-js -->
	<script src="js/minicart.js"></script>
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
	<!-- start-smooth-scrolling -->
	<script src="js/SmoothScroll.min.js"></script>  
	<script type="text/javascript" src="js/move-top.js"></script>
	<script type="text/javascript" src="js/easing.js"></script>	
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
	<script type="text/javascript">
		$(document).ready(function() {
			/*
			var defaults = {
				containerID: 'toTop', // fading element id
				containerHoverID: 'toTopHover', // fading element hover id
				scrollSpeed: 1200,
				easingType: 'linear' 
			};
			*/
			
			$().UItoTop({ easingType: 'easeOutQuart' });
			
		});
	</script>
	<!-- //smooth-scrolling-of-move-up --> 
	<!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="js/bootstrap.js"></script>
</body>
</html>