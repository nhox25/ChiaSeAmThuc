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
		<img class="login-w3img" src="images/img3.jpg" alt="">
		<div class="container"> 
			<h3 class="w3ls-title w3ls-title1">Đăng ký tài khoản</h3>  
			<div class="login-agileinfo"> 
				<form action="<%=request.getContextPath()%>/home/sign-up" method="post">
					<div style="color:red">
					<%String msg = request.getParameter("msg");
					if(msg!=null){
					out.print(msg);}%></div> 
					<input class="agile-ltext" type="text" name="username" placeholder="Tên đăng nhập" required="">
					<input class="agile-ltext" type="email" name="email" placeholder="Địa chỉ email" required="">
					<input class="agile-ltext" type="password" name="password" placeholder="Mật khẩu" required="">
					<input class="agile-ltext" type="password" name="re_password" placeholder="Xác nhận mật khẩu" required="">
					<input class="agile-ltext" type="text" name="fullname" placeholder="Họ và tên" required="">
					<input class="agile-ltext" type="text" name="phone" placeholder="Số điện thoại" required="">
					<input class="agile-ltext" type="text" name="address" placeholder="Địa chỉ" required="">
					<div class="wthreelogin-text"> 
						<ul> 
							<li>
								<label class="checkbox"><input type="checkbox" name="checkbox"><i></i> 
									<span> Tôi đồng ý các điều khoản sử dụng</span> 
								</label> 
							</li> 
						</ul>
						<div class="clearfix"> </div>
					</div>   
					<input type="submit" name="add" value="Đăng Ký">
					<input type="reset" name="reset" value="Làm lại">
				</form>
				<p>Bạn đã có tài khoản?  <a href="<%=request.getContextPath()%>/home/login"> Đăng nhập ngay!</a></p> 
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