<%@page import="bean.Products"%>
<%@ page language="java" contentType="text/html; charset=UTF8"
    pageEncoding="UTF8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@include file="/templates/admin/inc/header.jsp"%>
      <!-- Main content --> 
      <div class="panel panel-default no-border">
        <div class="panel-heading border-radius-10">
                <h2>List Products</h2>
        </div>
      </div>
          <div class="templatemo-content-widget no-padding">
            <div class="panel panel-default table-responsive">
              <table id="myTable" class="table table-striped table-bordered templatemo-user-table">
                <thead>
                  <tr>
                    <td><a href="" class="white-text templatemo-sort-by"># <span class="caret"></span></a></td>
                    <td><a href="" class="white-text templatemo-sort-by">Name<span class="caret"></span></a></td>
                    <td><a href="" class="white-text templatemo-sort-by">Type<span class="caret"></span></a></td>
                    <td><a href="" class="white-text templatemo-sort-by">Address<span class="caret"></span></a></td>
                    <td><a href="" class="white-text templatemo-sort-by">District<span class="caret"></span></a></td>
                    <td><a href="" class="white-text templatemo-sort-by">Picture<span class="caret"></span></a></td>
                    <td><a href="" class="white-text templatemo-sort-by">Time<span class="caret"></span></a></td>
                    <td><a href="" class="white-text templatemo-sort-by">Users<span class="caret"></span></a></td>
                    <td><a href="" class="white-text templatemo-sort-by">Phone<span class="caret"></span></a></td>
                    <td>Delete</td>
                  </tr>
                </thead>
                <tbody>
                	<%ArrayList<Products> listPro = (ArrayList<Products>)request.getAttribute("listPro");
                		int i = 0;
						if(listPro!=null){
							for(Products pro:listPro){
							i++;%> 
                   <tr>
                   	<td><%=i%></td>
                    <td><%=pro.getName_product() %></td>
                    <td><%=pro.getNameCat() %></td>
                    <td><%=pro.getAddress_product() %></td>
                    <td><%=pro.getNameDictricts() %></td>
                    <td>
                    <%if(pro.getPicture1_product() != null){%>
						<img style="height: 100px;
							    width: 150px;
							    border-radius: 5px;
							    border: solid 3px #c1c1c1;"
						 src="<%=request.getContextPath()%>/files/<%=pro.getPicture1_product()%>"/>
						<% }else{out.print("-No Picture");} %>
					</td>
                    <td><%=pro.getTimecreate_product() %></td>
                    <td><%=pro.getUser_product() %></td>
                    <td><%=pro.getPhone_product() %></td>
                    <td><a href="<%=request.getContextPath()%>/admin/del-products?id=<%=pro.getId_product()%>" class="templatemo-link" onclick="return confirm('Bạn muốn xóa : <%=pro.getName_product()%> ?')">Delete</a></td>
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