<%@page import="bean.TypeProduct"%>
<%@ page language="java" contentType="text/html; charset=UTF8"
    pageEncoding="UTF8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@include file="/templates/admin/inc/header.jsp"%>
<!-- Main content -->
        <div class="templatemo-content-container">
          <div class="templatemo-content-widget white-bg">
            <h2 class="margin-bottom-10">Thêm loại món ăn</h2>
            <p>Vui lòng nhập đầy đủ thông tin cần thiết.</p>
            <div style="color:red">
					<%String msg = request.getParameter("msg");
					if(msg!=null){out.print(msg);}%>
			</div>
			<%TypeProduct cat = (TypeProduct) request.getAttribute("editcat");
			 %>
            <form class="templatemo-login-form" action="<%=request.getContextPath()%>/admin/edit-typeproducts"  method="post">
              <div class="row form-group">
                <div class="col-lg-6 col-md-6 form-group">
                	<input type="hidden" name="id" value="<%=cat.getIdTypePro()%>"/>                  
                    <label for="inputFirstName">Type Name</label>
                    <input type="text" name="name" class="form-control" placeholder="Type Name" value="<%=cat.getNameTypePro()%>" required="">                  
                </div>
              </div>
              <div class="form-group text-right">
                <input type="submit" name="edit" class="templatemo-blue-button" value="Submit">
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
    <script type="text/javascript" src="js/jquery-1.11.2.min.js"></script>        <!-- jQuery -->
    <script type="text/javascript" src="js/bootstrap-filestyle.min.js"></script>  <!-- http://markusslima.github.io/bootstrap-filestyle/ -->
    <script type="text/javascript" src="js/templatemo-script.js"></script>        <!-- Templatemo Script -->
  </body>
</html>
