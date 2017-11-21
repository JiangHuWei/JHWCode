<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/custom_up_img.css">
</head>
<body>
	<input id="path" type="hidden" value="<%=request.getContextPath() %>">
	<!--用户列表内容区 -->
	<ol class="am-breadcrumb">
		<li><a href="#" class="am-icon-home">首页</a></li>
		<li><a href="#">系统设置</a></li>
		<li class="am-active">微信token获取</li>
	</ol>
	<div class="jhw-portlet-components">

		<div class="jhw-block">
			<div class="am-g">
				<div class="am-u-sm-12 am-u-md-6">
					<div class="am-btn-toolbar">
						<div class="am-btn-group am-btn-group-xs">
							<a href="#" onclick="toGetWeiXinToken()"
								class="am-btn am-btn-default am-btn-success"> <span
								class="am-icon-plus"></span> 获取微信token
							</a>

						</div>
					</div>
				</div>
			</div>
			<div class="am-g jhw-list">
				<div class="am-u-sm-12">
					<p>tips: 微信服务号token只有白名单ip的服务器请求才可以获取到该token，所以本服务只有部署到http://101.132.155.221的服务器才可以获取到微信的token</p>
				</div>
				<div id="tokenVal" class="am-u-sm-12">
				</div>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/backstage/bs_user_list.js"></script>
</html>