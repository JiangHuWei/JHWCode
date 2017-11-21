<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>江湖味--餐厅检索页面</title>
<meta name="description" content="江湖味">
<meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1,user-scalable=no">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="black">

<!--标准mui.css-->
<link rel="stylesheet" href="<%=request.getContextPath()%>/wxh5assets/css/mui.min.css">
<!--App自定义的css-->
<link rel="stylesheet" href="<%=request.getContextPath()%>/wxh5assets/css/jhw.css">
<style>
.mui-control-content {
	background-color: white;
	/*min-height: 215px;*/
}

.mui-control-content .mui-loading {
	margin-top: 50px;
}
</style>
</head>
<body data-type="index">
	<input id="path" type="hidden" value="<%=request.getContextPath()%>">
	<p>
		餐厅名：<input id="restaurantname" name="restaurantName" type="text" /> <button onclick="searchByRestaurantName()">按餐厅名模糊检索</button> 
	</p>
	<br><br>
	<div id="restaurantform">
		
	</div>
	
</body>
<%@include file="/jsp/common/common_js.jsp"%>
<script type="text/javascript">
	
	
	function searchByRestaurantName(){
		var path = $("#path").val();
		var name = $("#restaurantname").val();
		$.ajax({
			type : "POST",
			url : path + "/restaurant_search/searchbyname",
			data : {"keyword":name},
			async : false,
			success : function(data) {
				$("#restaurantform").html(data);
			},
			error : function(XMLHttpRequest, textStatus, errorThrown) {
				alert("餐厅检索失败");
			}
		});
	}
	
</script>
</html>