<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
</head>
<body>
	<header class="am-topbar am-topbar-inverse admin-header">
	<div class="am-topbar-brand">
		<a href="javascript:;" class="jhw-logo"> <img
			src="<%=request.getContextPath()%>/img/logo.png" alt="">
		</a>
	</div>
	<button
		class="am-topbar-btn am-topbar-toggle am-btn am-btn-sm am-btn-success am-show-sm-only"
		data-am-collapse="{target: '#topbar-collapse'}">
		<span class="am-sr-only">导航切换</span> <span class="am-icon-bars"></span>
	</button>

	<div class="am-collapse am-topbar-collapse" id="topbar-collapse">

		<ul
			class="am-nav am-nav-pills am-topbar-nav am-topbar-right admin-header-list jhw-header-list">

			<li class="am-dropdown" data-am-dropdown data-am-dropdown-toggle>
				<a class="am-dropdown-toggle jhw-header-list-link"
				href="javascript:;"> <span class="jhw-header-list-user-nick">${userInfo.nickname }</span><span
					class="jhw-header-list-user-ico"> <img
						src="<%=request.getContextPath()%>/img/user01.png"></span>
			</a>
				<ul class="am-dropdown-content">
					<li><a href="#"><span class="am-icon-bell-o"></span> 个人中心</a>
					</li>
					<li><a href="#"><span class="am-icon-cog"></span> 设置</a></li>
					<li><a href="#"><span class="am-icon-power-off"></span> 退出</a>
					</li>
				</ul>
			</li>
			<li><a href="#" onclick="doExit()" class="jhw-header-list-link"><span
					class="am-icon-sign-out jhw-header-list-ico-out-size"></span></a></li>
		</ul>
	</div>
	</header>
</body>
</html>