<%@page import="bean.Dictricts"%>
<%@page import="bean.TypeProduct"%>
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
		<h3 class="w3ls-title w3ls-title1">Cho mọi người biết món ăn của bạn</h3>  	
			<div class="login-agileinfo">
			<h1>Thông tin cơ bản</h1> 		
				<form action="<%=request.getContextPath()%>/home/create-product" enctype="multipart/form-data" method="post">
					<div style="color:red">
					<%String msg = request.getParameter("msg");
					if(msg!=null){
					out.print(msg);}%></div>
						<input class="agile-ltext" type="text" name="name_product" placeholder="Tên món ăn" required="">
						<input class="agile-ltext" type="text" name="address_product" placeholder="Địa chỉ" required="">
						<select class="agile-ltext" name="dicrit_product" required="" required=""="Xin chọn quận">
						<%
						ArrayList<Dictricts> listDictricts = (ArrayList<Dictricts>) request.getAttribute("listDictricts");
						if(listDictricts!=null){
						for(Dictricts dictricts: listDictricts){	
						%>
						<option value="<%=dictricts.getId_dictricts()%>"><%=dictricts.getNam_dictricts() %></option>
						<% }} %>
						</select>
						<input class="agile-ltext" type="text" name="price" placeholder="Giá bán" required="">
						<input class="agile-ltext" type="text" name="phone" placeholder="Điện thoại" required="">
						<input class="agile-ltext" type="email" name="email" placeholder="Email" required="">
						<input class="agile-ltext" type="text" name="website" placeholder="Website" required="">
						<br>
						<div>Mô Tả Thêm</div>
						<textarea style="margin: 0px; height: 122px; width: 427px;" 
							class="agile-ltext" name="description" placeholder="Mô tả" required=""></textarea>
						<select class="agile-ltext" name="style" required="" required="Xin chọn loại thức ăn">
						<%
						ArrayList<TypeProduct> listCat = (ArrayList<TypeProduct>) request.getAttribute("listCat");
						if(listCat!=null){
						for(TypeProduct cat: listCat){	
						%>
						<option value="<%=cat.getIdTypePro()%>"><%=cat.getNameTypePro() %></option>
						<% }} %>
						</select>
						
						
						<br/>
						<input type="file" name="picture1" value="" />
						<br/>
						<input type="submit" name="add" value="Đăng Ký">
						<input type="reset" name="reset" value="Làm lại">
				</form>
				</div>
			</div>
			</div>	 
	</div>
	<!-- //sign up-page -->  
	<!-- subscribe -->
	<%@include file="templates/public/inc/footer.jsp"%> 
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
			
			$().UItoTop({ easingType: 'easeOutQuart' });
			
		});
	</script>
	<!-- //smooth-scrolling-of-move-up --> 
	<!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
</body>
</html>