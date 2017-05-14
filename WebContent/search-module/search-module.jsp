<%@page import="bo.DicTrictstBO"%>
<%@page import="bo.TypeProductBO"%>
<%@page import="bean.Products"%>
<%@page import="bean.TypeProduct"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript">

$(document).ready(function() {
	$('#agileinfo_search').click(function(){
		if($('#search-info').css("display")=='none'){
			$('#search-info').css("display","block");
		}else{
			$('#search-info').css("display","none");
		}
	});
});
</script>
<div  class="container">
	<div class="agileits_search" style="
		position: relative;">
		<form action="<%=request.getContextPath()%>/home/search" method="post">
			<input name="Search" type="text" placeholder="Tìm kiếm địa điểm, món ăn...">						
			<span id="agileinfo_search">Tìm kiếm Nâng Cao
			</span>
			<input type="submit" value="Search">

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
			                <li><a href="#giaca" data-toggle="tab">Giá Cả</a></li>
			            </ul>
			        </div>
			        <div class="">
			            <!-- Tab panes -->
			             <div class="tab-content">
			                <div class="tab-pane active" id="khuvuc">
				                <div class="form-group ">
									<div class="col-sm-10">
			                		<%DicTrictstBO dictrictsBO = new DicTrictstBO();
					            		for(int i = 0; i < dictrictsBO.getListDictricts().size();i++ ){%>
			                			<div class="checkbox-search">
			                				<label><input type="checkbox" value="<%=dictrictsBO.getListDictricts().get(i).getNam_dictricts()%>" name="district" ><%=dictrictsBO.getListDictricts().get(i).getNam_dictricts()%></label>
			                			</div>
			                			<%}%>
			                		</div>
								</div>
								<div class="clearfix"></div>
			                </div>
			                <div class="tab-pane" id="phanloai">
			                	<div class="form-group ">
			                		<div class="col-sm-10">
			                		<%TypeProductBO typeBO = new TypeProductBO();
					            		for(int i = 0; i < typeBO.getListCat().size();i++ ){%>
			                			<div class="checkbox-search">
			                				<label><input type="checkbox" value="<%=typeBO.getListCat().get(i).getNameTypePro()%>" name="typepro" ><%=typeBO.getListCat().get(i).getNameTypePro() %></label>
			                			</div>
			                			<%}%>
			                		</div>
			            	    </div>
			        		</div>
			        		<div class="tab-pane" id="giaca">
			                	<div class="form-group ">
			                		<div class="col-sm-10">
			                		<select name="price" class="form-control1">
										<option value = "50000"> Dưới 50.000    VNĐ</option>
										<option value = "100000">Từ   50.000    VNĐ - 100.000   VNĐ</option>
										<option value = "200000">Từ   100.000   VNĐ - 300.000   VNĐ</option>
										<option value = "300000">Từ   300.000   VNĐ - 500.000   VNĐ</option>
										<option value = "500000">Từ   500.000   VNĐ - 1.000.000 VNĐ</option>
										<option value = "100000">Trên 1.000.000 VNĐ</option>
										<option></option>
									</select>
			                		</div>
			                		</div>
			            	    </div>
			        		</div>
			        	<div class="clearfix"></div>
			    		</div>
		 	</div>
		 	<div class="clearfix"
		 	 style="border-bottom: 1px solid #e0e3e5;"></div>
		 	<div style="margin: 5px auto;
					    display: table;">
		 	 	<button style="margin-right : 5px;" type="submit" name="search-home" class="btn btn-success">Tìm kiếm</button>
		 	 	<button type="reset" class="btn">Xóa bộ lọc</button>
			
		 	</div>
		</div>
	</div>
</div>
		</form>
</div>
</div>
</div>