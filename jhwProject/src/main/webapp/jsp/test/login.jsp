<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>江湖味--测试页</title>
<meta name="description" content="江湖味">
<meta name="keywords" content="index">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="renderer" content="webkit">
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="icon" type="image/png" href="<%=request.getContextPath()%>/i/favicon.png">
<link rel="apple-touch-icon-precomposed" href="<%=request.getContextPath()%>/i/app-icon72x72@2x.png">
<meta name="apple-mobile-web-app-title" content="江湖味" />
<%@include file="/jsp/common/common_css.jsp"%>

</head>
<body data-type="login" >
	<input id="path" type="hidden" value="<%=request.getContextPath() %>">
	<input type="button" onclick="GaoDeTest()" value="高德测试"/>
	<br><br>
	<div id="result" style="width: 100%; height: 500px;background-color:silver;">
	检索结果：
	</div>
</body>
<script type="text/javascript">
/* url: "http://restapi.amap.com/v3/place/text?key=2218472a9c1d25dec425c8a7349f514e&keywords=麻辣烫&output=json&city=310106&citylimit=true&extensions=all&page=10&offset=5", */
	function GaoDeTest(){
		alert("666");
		$.ajax({
			type: "get",
	        url : "http://192.168.1.101:8080/jhw/h5index/toindex",
	        async : false,	//同步请求
	        success: function (data) {
	        	alert(data);
	        	$("#result").html(data);
	        },
	        error: function (data) {
	        	alert("加载数据失败！");
	        }	
		});
	}
</script>
</html>