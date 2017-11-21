<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<table class="am-table am-table-striped am-table-hover table-main jhw-list">
		<thead>
			<tr>
				<!-- <th class="table-check"><input type="checkbox" class="jhw-table-fz-check"></th>-->
				<th class="table-title">真实姓名</th>
				<th class="table-title">昵称</th>
				<th class="table-type">手机号</th>
				<th class="table-author am-hide-sm-only">身份证</th>
				<th class="table-date am-hide-sm-only">信用值</th>
				<th class="table-date am-hide-sm-only">状态</th>
				<th class="table-set">操作</th>

			</tr>
		</thead>
		<tbody>
			<c:if test="${results.isSuccess == 1 }">
				<c:forEach items="${results.resultObj }" var="user">
					<input id="user_list_${user.tuid }" type="hidden" value="${user.tuid}" />
					<tr class="user_tr_${user.tuid }">
						<td>${user.actualName }</td>
						<td><a href="javascript:void(0)"
							data-am-modal="{target: '#user-particulars'}">${user.nickname }</a>
						</td>
						<td>${user.phone }</td>
						<td class="am-hide-sm-only">${user.idCardno }</td>
						<td class="am-hide-sm-only">${user.creditValue }</td>
						<td>
							<select data-am-selected="{btnSize: 'sm'}">
								<c:if test="${user.status == 0}">
									<option value="${user.status}" selected="selected">正常</option>
									<option value="${user.status}">禁用</option>
								</c:if>
								<c:if test="${user.status == 1}">
									<option value="${user.status}">正常</option>
									<option value="${user.status}" selected="selected">禁用</option>
								</c:if>
							</select>
						</td>
						<td>
							<div class="am-btn-toolbar">
								<div class="am-btn-group am-btn-group-xs">
									<a class="am-btn am-text-success" href="#" onclick="toUserInfoCheckPage(${user.tuid})"> 
										<span class="am-icon-file-text-o"></span> 详情
									</a> 
									<a class="am-btn am-text-secondary" href="#" onclick="toUserInfoEditPage(${user.tuid})">
										<span class="am-icon-pencil-square-o"></span> 编辑
									</a> 
									<a class="am-btn am-text-danger jhw-list-delete" onclick="doDeleteUser(${user.tuid })"> 
										<span class="am-icon-trash-o"></span> 删除
									</a>
								</div>
							</div>
						</td>
					</tr>
				</c:forEach>
			</c:if>
			<c:if test="${results.isSuccess == 0 }">
				<!-- 没数据或加载失败 -->
				<h2>没有找到任何用户信息</h2>
			</c:if>

		</tbody>
	</table>
	<div class="am-cf">
		<div class="am-fr">
			<ul class="am-pagination jhw-pagination">
				<c:if test="${results.pageNo==0}">
					<li class="am-disabled"><a href="#">«</a></li>
					<li onclick="paging(${results.pageNo+1},${results.pageNo})"><a href="#">»</a></li>
				</c:if>
				<c:if test="${results.pageNo>0 && results.whetherNextPage == 1 }">
					<li onclick="paging(${results.pageNo-1},${results.pageNo})"><a href="#">«</a></li>
					<li onclick="paging(${results.pageNo+1},${results.pageNo})"><a href="#">»</a></li>
				</c:if>
				<c:if test="${results.pageNo>0 && results.whetherNextPage == 0 }">
					<li onclick="paging(${results.pageNo-1},${results.pageNo})"><a href="#">«</a></li>
					<li class="am-disabled"><a href="#">»</a></li>
				</c:if>
			</ul>
		</div>
	</div>
	
</body>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/backstage/bs_user_list.js"></script>
</html>