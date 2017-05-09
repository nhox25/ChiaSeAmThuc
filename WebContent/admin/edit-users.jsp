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
			<%Users users= (Users)request.getAttribute("users");%>
            <form class="templatemo-login-form" action="<%=request.getContextPath()%>/admin/edit-users"  method="post">
              <div class="row form-group">
                <div class="col-lg-6 col-md-6 form-group">                  
                    <label for="inputFirstName">Username</label>
                    <input type="text" value="<%=users.getUsername() %>" name="username" class="form-control" id="" placeholder="Username" required="" readonly>                  
                </div>
                <div class="col-lg-6 col-md-6 form-group">                  
                    <label for="inputLastName">Full name</label>
                    <input type="text" value="<%=users.getFullname() %>" name="fullname" class="form-control" id="" placeholder="Full name" required="">                  
                </div>
                <div class="col-lg-6 col-md-6 form-group">                  
                    <label for="inputLastName">Address</label>
                    <input type="text" value="<%=users.getAddress() %>" name="address" class="form-control" id="" placeholder="Addess" required="">                  
                </div>  
                <div class="col-lg-6 col-md-6 form-group">                  
                    <label for="inputLastName">Phone</label>
                    <input type="text" value="<%=users.getPhone() %>" name="phone" class="form-control" id="" placeholder="Phone" required="">                  
                </div>
                <div class="col-lg-6 col-md-6 form-group">                  
                    <label for="inputLastName">Email</label>
                    <input type="text" value="<%=users.getEmail() %>" name="email" class="form-control" id="" placeholder="Email" required="">                  
                </div>
                <div class="col-lg-6 col-md-6 form-group">                  
                    <label class="control-label templatemo-block">Position</label>                 
                  <select name="position" class="form-control">
                  <% if("1".equals(users.getPosition())){ %>
                    <option value="1">Ban Quản Trị</option>
                    <option value="0">Thành Viên</option> 
                   <%}else{ %>     
                   <option value="0">Thành Viên</option> 
                   <option value="1">Ban Quản Trị</option>
                   <%} %>                 
                  </select>                 
                </div>
                <div class="col-lg-6 col-md-6 form-group">                  
                    <label for="inputNewPassword">Password</label>
                    <input type="password" value="<%=users.getPassword() %>" name="password" class="form-control" placeholder="Password" required="">
                </div>
              </div>
              <div class="form-group text-right">
                <input type="submit" name="edit" class="templatemo-blue-button" value="Edit">
                <a class="templatemo-white-button" href="<%=request.getContextPath()%>/admin/list-users">Cancel</a>
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
    <script type="text/javascript" src="js/jquery-1.11.2.min.js"></script>        <!-- jQuery -->
    <script type="text/javascript" src="js/bootstrap-filestyle.min.js"></script>  <!-- http://markusslima.github.io/bootstrap-filestyle/ -->
    <script type="text/javascript" src="js/templatemo-script.js"></script>        <!-- Templatemo Script -->
  </body>
</html>
