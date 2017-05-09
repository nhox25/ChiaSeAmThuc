<%@page import="bean.Contact"%>
<%@page import="bean.Users"%>
<%@ page language="java" contentType="text/html; charset=UTF8"
    pageEncoding="UTF8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@include file="/templates/admin/inc/header.jsp"%>
      <!-- Main content --> 
      <div class="panel panel-default no-border">
        <div class="panel-heading border-radius-10">
                <h2>Contact List</h2>
        </div>
      </div>
        
        <div class="templatemo-content-container">
          <div class="templatemo-content-widget no-padding">
            <div class="panel panel-default table-responsive">
              <table class="table table-striped table-bordered templatemo-user-table">
                <thead>
                  <tr>
                    <td><a href="" class="white-text templatemo-sort-by"># <span class="caret"></span></a></td>
                    <td><a href="" class="white-text templatemo-sort-by">Title <span class="caret"></span></a></td>
                    <td><a href="" class="white-text templatemo-sort-by">Full name <span class="caret"></span></a></td>
                    <td><a href="" class="white-text templatemo-sort-by">Email <span class="caret"></span></a></td>
                    <td><a href="" class="white-text templatemo-sort-by">Phone <span class="caret"></span></a></td>
                    <td><a href="" class="white-text templatemo-sort-by">Web site <span class="caret"></span></a></td>
                    <td><a href="" class="white-text templatemo-sort-by">Date<span class="caret"></span></a></td>
                    <td>Delete</td>
                    <td>Satus</td>
                  </tr>
                </thead>
                <tbody>
                	<%ArrayList<Contact> listContact = (ArrayList<Contact>)request.getAttribute("listContact");
					if(listContact!=null){
						int i = 0;
						for(Contact ctt:listContact){
							i++;
							%>
                   		<tr>
                   			<td><%=i%></td>
                   			<td><a href="<%=request.getContextPath()%>/admin/view-contact?idContact=<%=ctt.getIdcontact()%>" title=""><%=ctt.getTitle() %></a></td>
							<td><%=ctt.getFullname()%></td>
							<td><%=ctt.getEmail() %></td>
							<td><%=ctt.getPhone()%></td>
							<td><%=ctt.getWebsite()%></td>
							<td><%=ctt.getDatecreate()%></td>
							<%if(ctt.getStatus() == 0){ %>
							<td></td>
							<td>Chờ xử lý</td>
							<%} else{%>
							<td>
							<a href="<%=request.getContextPath()%>/admin/del-contact?id_contact=<%=ctt.getIdcontact()%>" onclick="return confirm('Are you sure? Delete #<%=i%> ?')">Delete </a>
							</td>
							<td>Đã xử lý</td>
							
							<%} %>
						</tr>
						<% }} %>
					                
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