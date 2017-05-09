<%@page import="bean.Contact"%>
<%@ page language="java" contentType="text/html; charset=UTF8"
    pageEncoding="UTF8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@include file="/templates/admin/inc/header.jsp"%>
<!-- Main content -->
		<div class="templatemo-content-container">         
          <div class="templatemo-content-widget white-bg">
            <h2 class="margin-bottom-10">Detail Content</h2>          
            <div class="panel panel-default no-border">
            <%Contact contact = (Contact)request.getAttribute("contact");
		 			if(contact!=null){%>
              <div class="panel-heading border-radius-10">
                <h2><%=contact.getTitle() %></h2>
              </div>
              <div class="panel-body">
                <div class="templatemo-flex-row flex-content-row">
                  <div class="col-1">
                    <div id="timeline_div" class="templatemo-chart"></div>
                    
                    <h3 class="text-center margin-bottom-5"><%=contact.getFullname() %></h3>
                    <p class="text-center"><%=contact.getDatecreate() %></p>                
                  </div>              
                </div>
              </div> 
            </div>
            <div class="panel panel-default no-border">
              <div class="panel-heading border-radius-10">
                <h2>Content Main</h2>
              </div>
              <div class="panel-body">
                <div class="templatemo-flex-row flex-content-row">
                  <div class="col-1">
                    <div id="timeline_div" class="templatemo-chart"></div>
                    <h3 class="text-center margin-bottom-5"><%=contact.getContent() %></h3>
                  </div>              
                </div>
              </div> 
				<a href="<%=request.getContextPath()%>/admin/processed-contact?id_contact=<%=contact.getIdcontact() %>" onclick="return confirm('Are you sure?')">Đánh dấu đã xữ lý
              <%} %>
            </div>
          </div>
          <footer class="text-right">
            <p>Copyright &copy; 2084 Company Name 
            | Designed by <a href="http://www.templatemo.com" target="_parent">templatemo</a></p>
          </footer>         
        </div>
        </div>
    </div>
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
