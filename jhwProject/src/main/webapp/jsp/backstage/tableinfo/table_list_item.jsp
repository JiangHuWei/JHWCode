<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/custom_up_img.css">
</head>
<body data-type="index">
	<form class="am-form">
		<table class="am-table am-table-striped am-table-hover table-main">
			<thead>
				<tr>
					<!-- <th class="table-check"><input type="checkbox" class="jhw-table-fz-check"></th>-->
					<!-- <th class="table-id">ID</th> -->
					<th class="table-title">发起者</th>
					<th class="table-type">餐厅</th>
					<th class="table-author ">人均</th>
					<th class="table-date">时间</th>
					<th class="table-date">报名数</th>
					<th class="table-type">状态</th>
					<th class="table-set">操作</th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${result.isSuccess == 1}">
					<c:forEach items="${tables}" var="tableItem">
						<tr>
							<!-- <td>000001</td> -->
							<td><a href="#"> ${tableItem.initiatorid } </a></td>
							<td class="am-hide-sm-only"><a href="">${tableItem.restaurantPoJo.name }</a></td>
							<td class="">无</td>
							<td class="">${tableItem.begainDate }</td>
							<td>${tableItem.peopleNumber }</td>
							<td>
								<form action="" method="post">
									<select data-am-selected="{btnSize: 'sm'}">
										<c:if test="${tableItem.status == 0 }">
											<option value="0" selected="selected">正常</option>
											<option value="-1">禁用</option>
										</c:if>
										<c:if test="${tableItem.status == -1 }">
											<option value="0">正常</option>
											<option value="-1" selected="selected">禁用</option>
										</c:if>
									</select>
								</form>
							</td>
	
							<td>
								<div class="am-btn-toolbar">
									<div class="am-btn-group am-btn-group-xs">
										<a class="am-btn am-text-success" href="#" onclick="toDetailPage(${tableItem.ttid})"> 
											<span class="am-icon-file-text-o "></span> 详情
										</a> 
										<a class="am-btn am-text-secondary" href="#" onclick="toEditPage(${tableItem.ttid})">
											<span class="am-icon-pencil-square-o"></span> 编辑
										</a> 
										<a class="am-btn am-text-danger" onclick="toDelTable(${tableItem.ttid})"> 
											<span class="am-icon-trash-o"></span> 删除
										</a>
									</div>
								</div>
							</td>
						</tr>
					</c:forEach>
				</c:if>
				<c:if test="${result.isSuccess == 0 }">
					<!-- 没数据或加载失败 -->
				</c:if>
			</tbody>
		</table>
		<div class="am-cf">
			<div class="am-fr">
				<ul class="am-pagination jhw-pagination">
					<c:if test="${result.pageNo==0}">
						<li class="am-disabled" onclick="hasFirstPage()"><a href="#">«</a></li>
						<li onclick="paging(${result.pageNo+1},${result.pageNo})"><a
							href="#">»</a></li>
					</c:if>
					<c:if test="${result.pageNo>0 && result.whetherNextPage == 1 }">
						<li onclick="paging(${result.pageNo-1},${result.pageNo})"><a
							href="#">«</a></li>
						<li onclick="paging(${result.pageNo+1},${result.pageNo})"><a
							href="#">»</a></li>
					</c:if>
					<c:if test="${result.pageNo>0 && result.whetherNextPage == 0 }">
						<li onclick="paging(${result.pageNo-1},${result.pageNo})"><a
							href="#">«</a></li>
						<li class="am-disabled" onclick="hasNotMorePage()"><a href="#">»</a></li>
					</c:if>
				</ul>
			</div>
		</div>
	</form>
</body>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/backstage/bs_table_list_paging.js"></script>
</html>