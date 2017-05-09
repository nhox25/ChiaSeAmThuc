<%@page import="bean.Users"%>
<%@ page language="java" contentType="text/html; charset=UTF8"
    pageEncoding="UTF8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@include file="/templates/admin/inc/header.jsp"%>
      <!-- Main content --> 
      <div class="panel panel-default no-border">
        <div class="panel-heading border-radius-10">
                <h2>List Users</h2>
        </div>
      </div>
        
        <div class="templatemo-content-container">
        <a href="<%=request.getContextPath() %>/admin/add-users" class="">
        <span class="btn btn-success">ADD USER</span>
        </a>
          <div class="templatemo-content-widget no-padding">
            <div class="panel panel-default table-responsive">
              <table class="table table-striped table-bordered templatemo-user-table">
                <thead>
                  <tr>
                    <td><a href="" class="white-text templatemo-sort-by"># <span class="caret"></span></a></td>
                    <td><a href="" class="white-text templatemo-sort-by">User Name <span class="caret"></span></a></td>
                    <td><a href="" class="white-text templatemo-sort-by">Full Name <span class="caret"></span></a></td>
                    <td><a href="" class="white-text templatemo-sort-by">Address <span class="caret"></span></a></td>
                    <td><a href="" class="white-text templatemo-sort-by">Phone <span class="caret"></span></a></td>
                    <td><a href="" class="white-text templatemo-sort-by">Email <span class="caret"></span></a></td>
                    <td>Edit</td>
                    <td>Delete</td>
                  </tr>
                </thead>
                <tbody>
                	<%ArrayList<Users> listUsers = (ArrayList<Users>)request.getAttribute("listUsers");
                		int i = 0;
						if(listUsers!=null){
							for(Users users:listUsers){
							i++;%> 
                   <tr>
                   	<td><%=i%></td>
                    <td><%=users.getUsername() %></td>
                    <td><%=users.getFullname() %></td>
                    <td><%=users.getAddress() %></td>
                   	<td><%=users.getPhone() %></td>
                 	<td><%=users.getEmail()%></td> 
                    <%
                   	Users userLogin = (Users)session.getAttribute("usersadmin");
                   if(!"admin".equals(userLogin.getUsername())){
                    if(userLogin.getUsername().equals(users.getUsername())){%>	
                    <td><a href="<%=request.getContextPath()%>/admin/edit-users?username=<%=users.getUsername()%>" class="templatemo-edit-btn">Edit</a></td>
                    <td></td>
                    <%}else if(("admin".equals(users.getUsername())) || ("1".equals(users.getPosition()))){%>
                   	<td></td>
                    <td></td>
                    <%}else{ %>
                    <td><a href="<%=request.getContextPath()%>/admin/edit-users?username=<%=users.getUsername()%>" class="templatemo-edit-btn">Edit</a></td>
                    <td><a href="<%=request.getContextPath()%>/admin/del-users?username=<%=users.getUsername()%>" class="templatemo-link" onclick="return confirm('Bạn muốn xóa : <%=users.getUsername()%> ?')">Delete</a></td>
					<%}}
                   else if("admin".equals(userLogin.getUsername())){
                	 if("admin".equals(users.getUsername())){%>
					<td><a href="<%=request.getContextPath()%>/admin/edit-users?username=<%=users.getUsername()%>" class="templatemo-edit-btn">Edit</a></td>
					<td></td>
					<%}else if(!"admin".equals(users.getUsername())){%>
						<td><a href="<%=request.getContextPath()%>/admin/edit-users?username=<%=users.getUsername()%>" class="templatemo-edit-btn">Edit</a></td>
	                    <td><a href="<%=request.getContextPath()%>/admin/del-users?username=<%=users.getUsername()%>" class="templatemo-link" onclick="return confirm('Bạn muốn xóa : <%=users.getUsername()%> ?')">Delete</a></td>
	                    </tr> 
					<%}}}}%>
					                
                </tbody>
              </table>    
            </div>                          
          </div>          
          <div class="pagination-wrap">
            <ul class="pagination">
              <li><a href="#">1</a></li>
              <li><a href="#">2</a></li>
              <li class="active"><a href="#">3 <span class="sr-only">(current)</span></a></li>
              <li><a href="#">4</a></li>
              <li><a href="#">5</a></li>
              <li>
                <a href="#" aria-label="Next">
                  <span aria-hidden="true"><i class="fa fa-play"></i></span>
                </a>
              </li>
            </ul>
          </div>          
          <footer class="text-right">
            <p>Copyright &copy; 2084 Company Name 
            | Designed by <a href="http://www.templatemo.com" target="_parent">templatemo</a></p>
          </footer>         
        </div>
    
    <!-- JS -->
    <script type="text/javascript" src="js/jquery-1.11.2.min.js"></script>      <!-- jQuery -->
    <script type="text/javascript" src="js/templatemo-script.js"></script>      <!-- Templatemo Script -->
    <script>
      $(document).ready(function(){
        // Content widget with background image
        var imageUrl = $('img.content-bg-img').attr('src');
        $('.templatemo-content-img-bg').css('background-image', 'url(' + imageUrl + ')');
        $('img.content-bg-img').hide();        
      });
    </script>
  </body>
</html>