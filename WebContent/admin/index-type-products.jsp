<%@page import="bean.TypeProduct"%>
<%@ page language="java" contentType="text/html; charset=UTF8"
    pageEncoding="UTF8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@include file="/templates/admin/inc/header.jsp"%>
      <!-- Main content --> 
      <div class="panel panel-default no-border">
        <div class="panel-heading border-radius-10">
                <h2>List Type</h2>
        </div>
      </div>
        
        <div class="templatemo-content-container">
        <a href="<%=request.getContextPath() %>/admin/add-typeproducts" class="">
        <span class="btn btn-success">ADD TYPE</span>
        </a>
          <div class="templatemo-content-widget no-padding">
            <div class="panel panel-default table-responsive">
              <table id="myTable" class="table table-striped table-bordered templatemo-user-table">
                <thead>
                  <tr>
                    <td><a href="" class="white-text templatemo-sort-by"># <span class="caret"></span></a></td>
                    <td><a href="" class="white-text templatemo-sort-by">Type <span class="caret"></span></a></td>
                    <td>Edit</td>
                    <td>Delete</td>
                  </tr>
                </thead>
                <tbody>
                	<%ArrayList<TypeProduct> listType = (ArrayList<TypeProduct>)request.getAttribute("listType");
                		int i = 0;
						if(listType!=null){
							for(TypeProduct type:listType){
							i++;%> 
                   <tr>
                   	<td><%=i%></td>
                    <td><%=type.getNameTypePro() %></td>
                    <td><a href="<%=request.getContextPath()%>/admin/edit-typeproducts?id=<%=type.getIdTypePro()%>" class="templatemo-edit-btn">Edit</a></td>
                    <td><a href="<%=request.getContextPath()%>/admin/del-typeproducts?id=<%=type.getIdTypePro()%>" class="templatemo-link" onclick="return confirm('Bạn muốn xóa : <%=type.getNameTypePro()%> ?')">Delete</a></td>
	                    </tr> 
					<%}}%>
					                
                </tbody>
              </table>    
            </div>                          
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