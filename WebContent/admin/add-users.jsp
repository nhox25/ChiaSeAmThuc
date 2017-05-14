<%@page import="bean.Users"%>
<%@ page language="java" contentType="text/html; charset=UTF8"
    pageEncoding="UTF8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@include file="/templates/admin/inc/header.jsp"%>
<!-- Main content -->
        <div class="templatemo-content-container">
          <div class="templatemo-content-widget white-bg">
            <h2 class="margin-bottom-10">Thêm mới người dùng</h2>
            <p>Vui lòng nhập đầy đủ thông tin cần thiết.</p>
            <div style="color:red">
					<%String msg = request.getParameter("msg");
					if(msg!=null){out.print(msg);}%>
			</div>
            <form class="templatemo-login-form" action="<%=request.getContextPath()%>/admin/add-users"  method="post">
              <div class="row form-group">
                <div class="col-lg-6 col-md-6 form-group">                  
                    <label for="inputFirstName">Username</label>
                    <input type="text" name="username" class="form-control" id="" placeholder="Username" required="">                  
                </div>
                <div class="col-lg-6 col-md-6 form-group">                  
                    <label for="inputLastName">Full name</label>
                    <input type="text" name="fullname" class="form-control" id="" placeholder="Full name" required="">                  
                </div>
                <div class="col-lg-6 col-md-6 form-group">                  
                    <label for="inputLastName">Address</label>
                    <input type="text" name="address" class="form-control" id="" placeholder="Addess" required="">                  
                </div>  
                <div class="col-lg-6 col-md-6 form-group">                  
                    <label for="inputLastName">Phone</label>
                    <input type="text" name="phone" class="form-control" id="" placeholder="Phone" required="">                  
                </div>
                <div class="col-lg-6 col-md-6 form-group">                  
                    <label for="inputLastName">Email</label>
                    <input type="text" name="email" class="form-control" id="" placeholder="Email" required="">                  
                </div>
                <div class="col-lg-6 col-md-6 form-group">                  
                    <label class="control-label templatemo-block">Position</label>                 
                  <select name="position" class="form-control">
                    <option value="0">Thành viên</option>
                    <option value="1">Ban quản trị</option>                      
                  </select>                 
                </div>
                <div class="col-lg-6 col-md-6 form-group">                  
                    <label for="inputNewPassword">Password</label>
                    <input type="password" name="password" class="form-control" id="password" placeholder="Password" required="">
                </div>
                <div class="col-lg-6 col-md-6 form-group">                  
                    <label for="inputConfirmNewPassword">Confirm Password</label>
                    <input type="password" name="confirm-password"class="form-control" id="confirm_password" placeholder="Confirm Password" required="">
                    <div style="font-family: initial;color: orangered;font-style: italic;" id="PasswordFalse"></div>
					<div style="font-family: initial;color: green;font-style: italic;" id="PasswordTrue"></div>
                </div>
              </div>
              <div class="form-group text-right">
                <input type="submit" name="add" class="templatemo-blue-button" value="Submit">
                <input type="reset" class="templatemo-white-button" value="Reset">
              </div>                           
            </form>
          </div>
          <footer class="text-right">
            <p>Copyright &copy; 2084 Company Name 
            | Designed by <a href="http://www.templatemo.com" target="_parent">templatemo</a></p>
          </footer>
        </div>
      </div>
    </div>
    <!-- JS -->
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
