<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
</head>
<body>
	<div class="jhw-left-nav jhw-left-nav-hover" id="navBar">
		<div class="jhw-left-nav-title"></div>
		<div class="jhw-left-nav-list">
			<ul class="jhw-left-nav-menu">
				<li class="jhw-left-nav-item">
					<a href="index.jsp" class="nav-link active"> <i class="am-icon-home"></i> <span>首页</span>
					</a>
				</li>
				<c:forEach items="${menus}" var="menu">
					<li class="jhw-left-nav-item">
						<a class="nav-link jhw-left-nav-link-list"> 
							<i class="am-icon-users"></i> <span>${menu.menuName }</span> 
							<i class="am-icon-angle-right jhw-left-nav-more-ico am-fr am-margin-right"></i>
						</a>
						<c:forEach items="${menu.childrenMenus }" var="child">
							<ul class="jhw-left-nav-sub-menu">
								<li>
									<a onclick="menuSkip('${child.url}')"> 
										<i class="am-icon-angle-right"></i> <span>${child.name}</span> 
										<!-- <i class="am-icon-star jhw-left-nav-content-ico am-fr am-margin-right"></i> -->
									</a>
								</li>
							</ul>
						</c:forEach>
					</li>
				</c:forEach>
				<!-- <li class="jhw-left-nav-item">
					<a onclick="menuSkip(1)" class="nav-link jhw-left-nav-link-list"> 
						<i class="am-icon-users"></i> <span>用户管理</span> 
						<i class="am-icon-angle-right jhw-left-nav-more-ico am-fr am-margin-right"></i>
					</a>
					<ul class="jhw-left-nav-sub-menu">
						<li>
							<a onclick="menuSkip(1001)"> 
								<i class="am-icon-angle-right"></i> <span>用户管理</span> 
								<i class="am-icon-star jhw-left-nav-content-ico am-fr am-margin-right"></i>
							</a>
						</li>
					</ul>
				</li>
				<li class="jhw-left-nav-item">
					<a href="javascript:;" class="nav-link jhw-left-nav-link-list"> 
						<i class="am-icon-list"></i> <span>饭局管理</span> 
						<i class="am-icon-angle-right jhw-left-nav-more-ico am-fr am-margin-right"></i>
					</a>
					<ul class="jhw-left-nav-sub-menu">
						<li>
							<a href="party-List.html"> 
								<i class="am-icon-angle-right"></i> <span>饭局管理1</span>
							</a>
						</li>
						<li>
							<a href="party-List.html"> 
								<i class="am-icon-angle-right"></i> <span>饭局管理2</span>
							</a>
						</li>
					</ul>
				</li>
				<li class="jhw-left-nav-item"><a href="javascript:;"
					class="nav-link jhw-left-nav-link-list"> <i
						class="fa fa-cutlery"></i> <span>餐厅管理</span> <i
						class="am-icon-angle-right jhw-left-nav-more-ico am-fr am-margin-right"></i>
				</a>
					<ul class="jhw-left-nav-sub-menu">
						<li><a href="user-List.html"> <i
								class="am-icon-angle-right"></i> <span>餐厅</span>
						</a></li>
						<li><a href="user-List.html"> <i
								class="am-icon-angle-right"></i> <span>餐厅2</span>
						</a></li>
					</ul></li>
				<li class="jhw-left-nav-item"><a href="javascript:;"
					class="nav-link jhw-left-nav-link-list"> <i
						class="am-icon-bell"></i> <span>消息管理</span> <i
						class="am-icon-angle-right jhw-left-nav-more-ico am-fr am-margin-right"></i>
				</a>
					<ul class="jhw-left-nav-sub-menu">
						<li><a href=""> <i class="am-icon-angle-right"></i> <span>已发送消息</span>
						</a></li>
					</ul></li>
				<li class="jhw-left-nav-item"><a href="javascript:;"
					class="nav-link jhw-left-nav-link-list"> <i
						class="am-icon-area-chart"></i> <span>报表查看</span> <i
						class="am-icon-angle-right jhw-left-nav-more-ico am-fr am-margin-right"></i>
				</a>
					<ul class="jhw-left-nav-sub-menu">
						<li><a href=""> <i class="am-icon-angle-right"></i> <span>PV表</span>
						</a></li>
					</ul></li>
				<li class="jhw-left-nav-item"><a href="javascript:;"
					class="nav-link jhw-left-nav-link-list"> <i
						class="am-icon-lock"></i> <span>权限管理</span> <i
						class="am-icon-angle-right jhw-left-nav-more-ico am-fr am-margin-right"></i>
				</a>
					<ul class="jhw-left-nav-sub-menu">
						<li><a href=""> <i class="am-icon-angle-right"></i> <span>管理员列表</span>
						</a></li>
						<li><a href=""> <i class="am-icon-angle-right"></i> <span>XXX</span>
						</a></li>
					</ul></li>
 -->
				<li class="jhw-left-nav-item"><a href=""
					class="nav-link jhw-left-nav-link-list"> <i
						class="am-icon-sign-out"></i> <span>退出</span>

				</a></li>
			</ul>
		</div>
	</div>
</body>
</html>