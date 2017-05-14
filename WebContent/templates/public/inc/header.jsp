<%@page import="bo.DicTrictstBO"%>
<%@page import="bean.TypeProduct"%>
<%@page import="bo.TypeProductBO"%>
<%@page import="bean.Users"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
<title>Food VN</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="keywords" content="Staple Food Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
	SmartPhone Compatible web template, free WebDesigns for Nokia, Samsung, LG, Sony Ericsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- Custom Theme files -->

<link href="<%=request.getContextPath()%>/css/bootstrap.css" type="text/css" rel="stylesheet" media="all">
<link href="<%=request.getContextPath()%>/css/owl.carousel.css" rel="stylesheet" type="text/css" media="all"/> 
<link href="<%=request.getContextPath()%>/css/style.css" type="text/css" rel="stylesheet" media="all">
<link href="<%=request.getContextPath()%>/css/font-awesome.css" type="text/css" rel="stylesheet" media="all">

<script src="<%=request.getContextPath()%>/js/ckeditor/ckeditor.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/jquery-2.2.3.min.js" type="text/javascript"></script> 
<script src="<%=request.getContextPath()%>/js/jquery.mousewheel.js"type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/SmoothScroll.min.js"type="text/javascript"></script>  
<script src="<%=request.getContextPath()%>/js/move-top.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/easing.js" type="text/javascript"></script>	
<script src="<%=request.getContextPath()%>/js/owl.carousel.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/jquery.jscrollpane.min.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/bootstrap.min.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/minicart.js" type="text/javascript"></script>
</head>
<body> 
	<!-- banner -->
	<div class="banner">
		<!-- header -->
		<div class="header">
			<div class="w3ls-header"><!-- header-one --> 
				<div class="container">
					<div class="w3ls-header-right">
						<ul> 
							<li class="head-dpdn">
								<i class="fa fa-phone" aria-hidden="true"></i> Liên hệ: +0979 038 274 
							</li> 
							<%Users account =(Users)session.getAttribute("users");
                 				if(account!=null){%>
                 			<li class="head-dpdn">
								<a href="<%=request.getContextPath()%>/home/create-product?type=load"><i class="fa fa-plus-square" aria-hidden="true"></i> Thêm địa điểm</a>
						    </li>
							<li class="head-dpdn">
								Chào, <a href="<%=request.getContextPath()%>/home/edit-users?username=<%=account.getUsername()%>"><%=account.getFullname()%></a></li>
							<li class="head-dpdn">
								<a href="<%=request.getContextPath()%>/home/"><i class="fa fa-sign-in" aria-hidden="true"></i> Đăng Xuất</a>
						    </li>
						    <li class="head-dpdn">
								<a href="<%=request.getContextPath()%>/home/list-product-user"><i class="fa fa-sign-in" aria-hidden="true"></i> Món ăn của bạn</a>
						    </li>
						    <li class="head-dpdn">
								<a href="<%=request.getContextPath()%>/home/help"><i class="fa fa-question-circle" aria-hidden="true"></i> Trợ giúp</a>
							</li>
								<%}else{ %>
						    <li>
								<a href="<%=request.getContextPath()%>/home/login"><i class="fa fa-sign-in" aria-hidden="true"></i> Đăng nhập</a>
							</li> 
							<li class="head-dpdn">
								<a href="<%=request.getContextPath()%>/home/sign-up"><i class="fa fa-user-plus" aria-hidden="true"></i> Đăng ký</a>
							</li> 
							<li class="head-dpdn">
								<a href="<%=request.getContextPath()%>/home/help"><i class="fa fa-question-circle" aria-hidden="true"></i> Trợ giúp</a>
							</li>
						</ul>
							<%} %>
					</div>
					
					<div class="clearfix"> </div> 
				</div>
			</div>
			<!-- //header-one -->    
			<!-- navigation -->
			<div class="navigation agiletop-nav">
				<div class="container">
					<nav class="navbar navbar-default">
						<!-- Brand and toggle get grouped for better mobile display -->
						<div class="navbar-header w3l_logo">
							<button type="button" class="navbar-toggle collapsed navbar-toggle1" data-toggle="collapse" data-target="#bs-megadropdown-tabs">
								<span class="sr-only">Toggle navigaaaaaaaaaaaaaaaaation</span>
								<span class="icon-bar"></span>
								<span class="icon-bar"></span>
								<span class="icon-bar"></span>
							</button>  
							<h1><a href="<%=request.getContextPath()%>/home">Foody Đà Nẵng<span>Sự lựa chọn tốt nhất cho bạn</span></a></h1>
						</div> 
						<div class="collapse navbar-collapse" id="bs-megadropdown-tabs">
							<ul class="nav navbar-nav navbar-right">
								<li><a href="<%=request.getContextPath()%>/home" class="active">Trang chủ</a></li>	
								<!-- Mega Menu -->
								<li class="dropdown">
									<a href="#" class="dropdown-toggle" data-toggle="dropdown">Menu <b class="caret"></b></a>
									<ul class="dropdown-menu multi-column columns-3">
										<div class="row">
											<div class="col-sm-5">
												<ul class="multi-column-dropdown">
													<h6>Quận</h6>  
													<%DicTrictstBO dictricts3 = new DicTrictstBO();
														if(!dictricts3.getListDictricts().isEmpty()){
			            								for(int i = 0; i < dictricts3.getListDictricts().size();i++ ){%>
													<li><a href="<%=request.getContextPath()%>/home/product-dictricts?id=<%=dictricts3.getListDictricts().get(i).getId_dictricts()%>"><%=dictricts3.getListDictricts().get(i).getNam_dictricts()%></a></li>
													<%}}else{ %>
													<li><a></a></li>
													<%} %>
												</ul>
											</div>
											<div class="col-sm-5">
												<ul class="multi-column-dropdown">
													<h6>Phân loại</h6> 
													<%TypeProductBO type3 = new TypeProductBO();
														if(!type3.getListCat().isEmpty()){
			            								for(int i = 0; i < type3.getListCat().size();i++ ){%>
													<li><a href="<%=request.getContextPath()%>/home/product-typroducts?id=<%=type3.getListCat().get(i).getIdTypePro()%>"><%=type3.getListCat().get(i).getNameTypePro()%></a></li>
													<%}}else{ %>
													<li><a></a></li>
													<%} %>
												</ul>
												<div class="clearfix"></div>
											</div>
											<div class="clearfix"></div>
										</div>
									</ul>
								</li>
								<li><a href="<%=request.getContextPath()%>/home/about">Giới thiệu</a></li>  
								<li><a href="<%=request.getContextPath()%>/home/contact">Liên hệ</a></li>
							</ul>
						</div>
					</nav>
				</div>
			</div>
			<!-- //navigation --> 
		</div>
		<!-- //header-end --> 