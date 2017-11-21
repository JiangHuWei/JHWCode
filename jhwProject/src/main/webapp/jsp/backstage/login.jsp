<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>江湖味--后台管理系统</title>
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
	<div class="am-g myapp-login">
		<div class="myapp-login-logo-block  jhw-login-max">
			<div class="myapp-login-logo-text">
				<div class="myapp-login-logo-text">
					<img src="<%=request.getContextPath()%>/img/logo2.png" /><span> Login</span>
				</div>
			</div>

			<div class="login-font">
				<i>欢迎使用江湖味后台管理系统 </i>
			</div>
			<div class="am-u-sm-10 login-am-center">
				<form id="login_form" class="am-form" method="post">
					<fieldset>
						<div class="am-form-group">
							<input type="text" required="required" class="" id="" name="nickname"
								placeholder="请输入账号">
						</div>
						<div class="am-form-group">
							<input type="password" required="required" class="" id="" name="pwd"
								placeholder="请输入密码">
						</div>
						<p class="alert-login error_message" >
						    <i class="am-icon-close"></i> <label class="error_msg"></label>
						</p>
						<p>
							<button class="am-btn am-btn-default" onclick="doLoginBypwd()">登录</button>
						</p>
					</fieldset>
				</form>
			</div>
		</div>
	</div>

</body>
<%@include file="/jsp/common/common_js.jsp"%>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/backstage/bs_login.js"></script>
</html>