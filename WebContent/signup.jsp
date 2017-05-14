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
			<h3 class="w3ls-title w3ls-title1">Đăng ký tài khoản</h3>  
			<div class="login-agileinfo"> 
				<form action="<%=request.getContextPath()%>/home/sign-up" method="post">
					<div style="color:red">
					<%String msg = request.getParameter("msg");
					if(msg!=null){
					out.print(msg);}%></div> 
					<input class="agile-ltext" type="text" name="username" placeholder="Tên đăng nhập" required="">
					<input class="agile-ltext" type="email" name="email" placeholder="Địa chỉ email" required="">
					<input class="agile-ltext" type="password" name="password" placeholder="Mật khẩu" required="" id="password">
					<input class="agile-ltext" type="password" name="re_password" placeholder="Xác nhận mật khẩu" required="" id="confirm_password" onChange="isPasswordMatch();">
					<div style="font-family: initial;color: orangered;font-style: italic;" id="PasswordFalse"></div>
					<div style="font-family: initial;color: green;font-style: italic;" id="PasswordTrue"></div>
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
	<script type="text/javascript">
	var password = document.getElementById("password"), confirm_password = document
			.getElementById("confirm_password");

	function validatePassword() {
		if (password.value != confirm_password.value) {
			confirm_password
					.setCustomValidity("Password không khớp? Nhập lại ");
		} else {
			confirm_password.setCustomValidity('');
		}
	}

	password.onchange = validatePassword;
	confirm_password.onkeyup = validatePassword;
</script>
<script type="text/javascript">
	function isPasswordMatch() {
		var password = $("#password").val();
		var confirmPassword = $("#confirm_password").val();

		if (password != confirmPassword) {
			$("#PasswordFalse").html("Password không khớp? Nhập lại ");
			$("#PasswordTrue").html(" ");
		} else if (password == confirmPassword) {
			$("#PasswordTrue").html("Nhập mật khẩu chính xác!");
			$("#PasswordFalse").html(" ");
		}
	}
	$(document).ready(function() {
		$("#confirm_password").keyup(isPasswordMatch);
	});
</script>
</body>
</html>