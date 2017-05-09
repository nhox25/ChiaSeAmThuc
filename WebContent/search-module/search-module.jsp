<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div  class="container">
	<div id="cln" class="agileits_search" style="
		position: relative;">
		<form action="#" method="post">
			<input name="Search" type="text" placeholder="hihi" required="">						
			<span id="agileinfo_search" name="agileinfo_search" required="" placeholder="hihi">Tìm kiếm
			</span>
			
			<input type="submit" value="Search">
		</form>
		<div id="search-info" style="z-index: 2">
		 	<div  style="background: #eee;
					    border-bottom: 1px solid #ddd;">
		 		<div  class="col-sm-6" style="width: 100% !important;
								    padding-left: 0px;">
				    <div class="" style="float: left;">
			            <!-- required for floating -->
			            <!-- Nav tabs -->
			            <ul class="nav nav-tabs tabs-left">
			                <li class="active"><a href="#khuvuc" data-toggle="tab">Khu Vực</a></li>
			                <li><a href="#phanloai" data-toggle="tab">Phân Loại</a></li>
			                <li><a href="#messages" data-toggle="tab"></a></li>

			            </ul>
			        </div>
			        <div class="">
			            <!-- Tab panes -->
			            <div class="tab-content">
			                <div class="tab-pane active" id="khuvuc">
				                <div class="form-group ">
									<div class="col-sm-10">
										<div class="checkbox-search"><label><input type="checkbox"> Ngũ Hành Sơn</label></div>
										<div class="checkbox-search"><label><input type="checkbox"> Thanh Khuê</label></div>
										<div class="checkbox-search"><label><input type="checkbox"> Liên Chiểu</label></div>
										<div class="checkbox-search"><label><input type="checkbox"> Cẩm Lệ</label></div>
										<div class="checkbox-search"><label><input type="checkbox"> Ngũ Hành Sơn</label></div>
										<div class="checkbox-search"><label><input type="checkbox"> Thanh Khuê</label></div>
										<div class="checkbox-search"><label><input type="checkbox"> Liên Chiểu</label></div>
										<div class="checkbox-search"><label><input type="checkbox"> Cẩm Lệ</label></div>
									</div>
								</div>
								<div class="clearfix"></div>
			                </div>
			                <div class="tab-pane" id="phanloai">
			                </div>
			                <div class="tab-pane" id="messages">Messages Tab.</div>

			            </div>
			        </div>
			        <div class="clearfix"></div>
			    </div>
		 	</div>
		 	<div class="clearfix"
		 	 style="border-bottom: 1px solid #e0e3e5;"></div>
		 	<div style="margin: 5px auto;
					    display: table;">
		 	 	<button style="margin-right : 5px;" type="button" class="btn btn-success">Tìm kiếm</button>
		 	 	<button type="button" class="btn">Xóa bộ lọc</button>
			
		 	</div>
		</div>
	</div>
</div>
</div>