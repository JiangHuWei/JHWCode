<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
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
<link rel="icon" type="image/png"
	href="<%=request.getContextPath()%>/i/favicon.png">
<link rel="apple-touch-icon-precomposed"
	href="<%=request.getContextPath()%>/i/app-icon72x72@2x.png">
<meta name="apple-mobile-web-app-title" content="江湖味" />
<%@include file="/jsp/common/common_css.jsp"%>
</head>
<body data-type="index" >
	<input id="path" type="hidden" value="<%=request.getContextPath() %>">
	<%@include file="/jsp/backstage/com_index_head.jsp"%>

	<div class="jhw-page-container jhw-page-header-fixed ">

		<%@include file="/jsp/backstage/com_index_menu.jsp"%>


		<!--页面内容区 -->
		<div class="jhw-content-wrapper">
			<!-- <ol class="am-breadcrumb">
				<li>
					<a href="#" class="am-icon-home">首页</a>
				</li>
				<li>
					<a href="#">饭局管理</a>
				</li>
				<li class="am-active">饭局列表</li>
			</ol>
			<div class="jhw-portlet-components">
				
				
			</div> -->
		</div>
		<!--图片上传框-->
				<div class="am-popup " id="update-imgBox">
					<div class="am-popup-inner">
						<div class="am-popup-hd">
							<h4 class="am-popup-title">...</h4>
							<span data-am-modal-close class="am-close">&times;</span>
						</div>
						<div class="am-popup-bd">
							<div class="container">
								<div class="imageBox">
									<div class="thumbBox"></div>
									<div class="spinner" style="display: none">Loading...</div>
								</div>
								<div class="action">
									<!-- <input type="file" id="file" style=" width: 200px">-->
									<input type="button" id="btnCrop" class="Btnsty_peyton" value="裁切">
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="am-dimmer" data-am-dimmer="" style="display: none;"></div>
				<!--页面内容区 END-->
	</div>
</body>
<%@include file="/jsp/common/common_js.jsp"%>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/backstage/bs_index.js"></script>
</html>