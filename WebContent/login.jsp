<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@include file="templates/public/inc/header.jsp"%>
	<!-- breadcrumb -->  
	<div class="container">	
		<ol class="breadcrumb w3l-crumbs">
			<li><a href="#"><i class="fa fa-home"></i> Home</a></li> 
			<li class="active">Login</li>
		</ol>
	</div>
	<!-- //breadcrumb -->
	<!-- login-page -->
	<div class="login-page about">
		<img class="login-w3img" src="images/img3.jpg" alt="">
		<div class="container"> 
			<h3 class="w3ls-title w3ls-title1">Đăng nhập</h3>
			<div class="login-agileinfo"> 
				<form action="<%=request.getContextPath() %>/home/login" method ="post"> 
					<div style="color:red">
					<%String msg = request.getParameter("msg");
					if(msg!=null) {out.print(msg);}%>
					</div>
					
					<div style="color:green">
					<%String msg2 = request.getParameter("msg2");
					if(msg2!=null) {out.print(msg2);}%>
					</div>
					<input class="agile-ltext" type="text" name="username" placeholder="Username" required="">
					<input class="agile-ltext" type="password" name="password" placeholder="Password" required="">
					<div class="wthreelogin-text"> 
						<ul> 
							<li>
								<label class="checkbox"><input type="checkbox" name="checkbox"><i></i> 
									<span> Ghi nhớ tôi ?</span> 
								</label> 
							</li>
							<li><a href="#">Quên mật khẩu?</a> </li>
						</ul>
						<div class="clearfix"> </div>
					</div>   
					<input type="submit" value="Đăng Nhập" name ="login">
				</form>
				<p>Bạn chưa có tài khoản? <a href="<%=request.getContextPath()%>/home/sign-up"> Đăng ký ngay!</a></p> 
			</div>	 
		</div>
	</div>
	<!-- //login-page -->  
	<%@include file="templates/public/inc/footer.jsp"%>
	<!-- subscribe -->
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