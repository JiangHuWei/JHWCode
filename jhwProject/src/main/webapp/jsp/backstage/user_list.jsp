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
		<li><a href="#">用户管理</a></li>
		<li class="am-active">文字列表</li>
	</ol>
	<div class="jhw-portlet-components">

		<div class="jhw-block">
			<div class="am-g">
				<div class="am-u-sm-12 am-u-md-6">
					<div class="am-btn-toolbar">
						<div class="am-btn-group am-btn-group-xs">
							<a href="#" onclick="toAddUserPage()"
								class="am-btn am-btn-default am-btn-success"> <span
								class="am-icon-plus"></span> 新增
							</a>

						</div>
					</div>
				</div>
				<div class="am-u-sm-12 am-u-md-3">
					<div class="am-form-group">
						<select data-am-selected="{btnSize: 'sm'}">
							<option value="option1">所有类别</option>
							<option value="option2">正常用户</option>
							<option value="option3">虚拟用户</option>
							<option value="option3">已禁用用户</option>
							<option value="option3">已认证用户</option>
						</select>
					</div>
				</div>
				<div class="am-u-sm-12 am-u-md-3">
					<div class="am-input-group am-input-group-sm">
						<input type="text" class="am-form-field"> <span
							class="am-input-group-btn">
							<button
								class="am-btn  am-btn-default am-btn-success jhw-am-btn-success am-icon-search"
								type="button"></button>
						</span>
					</div>
				</div>
			</div>
			<div class="am-g jhw-list">
				<div class="am-u-sm-12">
					<form class="am-form user-list-form">
						<table class="am-table am-table-striped am-table-hover table-main">
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
										<tr id="userLlist_${user.tuid}">
											<td>${user.actualName }</td>
											<td>
												<a href="javascript:void(0)" data-am-modal="{target: '#user-particulars'}">${user.nickname }</a>
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
								
								</c:if>

							</tbody>
						</table>
						<div class="am-cf">

							<div class="am-fr">
								<ul class="am-pagination jhw-pagination">
									<c:if test="${results.pageNo==0 && results.whetherNextPage==0}">
										<!-- 当前是第一页并且没有下一页 -->
									</c:if>
									<c:if test="${results.pageNo==0 && results.whetherNextPage == 1 }">
										<li class="am-disabled"><a href="#">«</a></li>
										<li onclick="paging(${results.pageNo+1},${results.pageNo})"><a href="#">»</a></li>
									</c:if>
									<c:if test="${results.pageNo>0 && results.whetherNextPage == 1 }">
										<li onclick="paging(${results.pageNo-1},${results.pageNo})"><a href="#">«</a></li>
										<li onclick="paging(${results.pageNo+1},${results.pageNo})"><a href="#">»</a></li>
									</c:if>
								</ul>
							</div>
						</div>

					</form>
				</div>

			</div>
		</div>
	</div>
	<div class="am-modal am-modal-confirm" tabindex="-1" id="jhw-delete-confirm">
	  <div class="am-modal-dialog">
	    <div class="am-modal-hd">江湖味</div>
	    <div class="am-modal-bd">
	      你，确定要删除这条记录吗？
	    </div>
	    <div class="am-modal-footer">
	      <span class="am-modal-btn" data-am-modal-cancel>取消</span>
	      <span class="am-modal-btn" data-am-modal-confirm>确定</span>
	    </div>
	  </div>
	</div>
</body>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/backstage/bs_user_list.js"></script>
</html>