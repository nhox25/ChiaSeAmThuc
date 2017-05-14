<%@page import="bo.DicTrictstBO"%>
<%@page import="bean.Ads"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


	<div class="col-md-3 rsidebar">
		<ul>
			<%
			
			DicTrictstBO dictricts2 = new DicTrictstBO();
				if(!dictricts2.getListDictricts().isEmpty()){
     				for(int i = 0; i < dictricts2.getListDictricts().size();i++ ){%>
			<li><a href="<%=request.getContextPath()%>/home/product-dictricts?id=<%=dictricts2.getListDictricts().get(i).getId_dictricts()%>"><%=dictricts2.getListDictricts().get(i).getNam_dictricts()%> (<%=request.getAttribute("sotin") %>)</a></li>
			<%}}else{ %>
			<li><a></a></li>
			<%} %>
		</ul>
	</div>

	<div class="col-md-3 rsidebar">
			<div class="clear"></div>

		<!-- Begin Quảng cáo -->
		</br>
		<marquee style="color: red; font-weight: bold; font-style : italic; font-size : 20px;">Mời đặt quảng cáo</marquee>
		<div class="advs">
		<%
			ArrayList<Ads> listAds = (ArrayList<Ads>) request.getAttribute("listAds");
				if (listAds != null) {
				for (Ads ads : listAds){
		%>
		<ul><li>
			<marquee id="marq" scrollamount="3" direction="up" loop="50" scrolldelay="0" onmouseover="this.stop()" onmouseout="this.start()">
			<img style="width: 300px;height: 200px;"class="" alt="" src="<%=request.getContextPath()%>/files/<%=ads.getPicture()%>">
			</marquee>
			</li>
		<%}}%>
		</ul>
		</div>
		<!-- Quảng cáo -->
	</div>
	<br/>
	