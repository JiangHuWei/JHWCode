<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/common.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/amazeui.cropper.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/custom_up_img.css">
</head>
<body data-type="index">
	<ol class="am-breadcrumb">
		<li><a href="#" class="am-icon-home">首页</a></li>
		<li><a href="#">饭局列表</a></li>
		<li class="am-active">新增饭局</li>
	</ol>
	<div class="jhw-portlet-components">
		<div class="jhw-block">

			<div class="am-g">
				<div class="jhw-form-body jhw-form-line">
					<div class="am-form jhw-form-line-form">

						<form id="submit_edit_table" method="post">
							<div class="am-form-group">
								<label for="user-name" class="am-u-sm-3 am-form-label">
									发起者<span class="jhw-form-line-small-title">Sponsor</span>
								</label>
								<div class="am-u-sm-9">
									<select data-am-selected="{searchBox: 1}" class="select_initiator edit_initiator">
										<c:forEach items="${initiators }" var="item">
											<c:if test="${item.userSelect}">
												<option value="${item.userPoJo.tuid }" selected="selected">${item.userPoJo.nickname }</option>
											</c:if>
											<c:if test="${!item.userSelect}">
												<option value="${item.userPoJo.tuid }">${item.userPoJo.nickname }</option>
											</c:if>
										</c:forEach>
									</select>
									<input type="hidden" name="tablePoJo.initiatorid" id="edit_initiatorId"/>
									<input type="hidden" name="tablePoJo.ttid" value="${table.ttid}"/>
								</div>
							</div>
							<div class="am-form-group">
								<label class="am-u-sm-3 am-form-label">餐厅 <span
									class="jhw-form-line-small-title">Restaurant</span></label>
								<div class="am-u-sm-9">
									<select data-am-selected="{searchBox: 1}" class="select_restaurant edit_restaurant">
										<c:forEach items="${restaurants }" var="item">
											<c:if test="${item.restaurantSelect == true}">
												<option value="${item.restaurant.trid }" selected="selected">${item.restaurant.name }</option>
											</c:if>
											<c:if test="${item.restaurantSelect == false}">
												<option value="${item.restaurant.trid }">${item.restaurant.name }</option>
											</c:if>
										</c:forEach>
									</select>
									<input type="hidden" name="tablePoJo.restaurantid" id="edit_restaurantId"/>
								</div>
							</div>

							<div class="am-form-group">
								<label class="am-u-sm-3 am-form-label">时间 <span
									class="jhw-form-line-small-title">Time</span></label>
								<div class="am-u-sm-9">
									<input size="16" type="text" value="${table.begainDate }" placeholder="请选择日期"
										readonly class="form-datetime am-form-field edit_begindate" name="tablePoJo.begainDate">
								</div>
							</div>
							
							<div class="am-form-group" id="participate_div">
								<label class="am-u-sm-3 am-form-label">参与人 <span
									class="jhw-form-line-small-title">ParticipantS</span></label>
								<div class="am-u-sm-9 chosenBox-multiple">
									<select multiple data-am-selected onchange="changeEditTableParticipate()"
										data-am-selected="{searchBox: 1}" class="participate_people">
										<c:forEach items="${attentUsers }" var="item" varStatus="status">
											<c:if test="${item.userSelect == true }">
												<option value="${item.userPoJo.tuid }" selected="selected">${item.userPoJo.nickname }</option>
											</c:if>
											<c:if test="${item.userSelect == false }">
												<option value="${item.userPoJo.tuid }">${item.userPoJo.nickname }</option>
											</c:if>
										</c:forEach>
									</select>
								</div>
								<div id="participateInput"></div>
							</div>
							<div class="am-form-group">
								<label class="am-u-sm-3 am-form-label">聚会说明 <span
									class="jhw-form-line-small-title">Explain</span></label>
								<div class="am-u-sm-9">
									<textarea class="edit_explain" rows="10" name="tablePoJo.tableExplain" placeholder="请输入聚会说明">${table.tableExplain }</textarea>
								</div>
							</div>
							<input id="tokenVal" name="tokenStr" type="hidden" />
							<div class="am-btn-group am-btn-group-xs">
								<a href="#" onclick="submitEditTable()"
									class="am-btn am-btn-default am-btn-success"> <span
									class="am-icon-plus"></span> 更新饭局
								</a>
							</div>
						</form>
						<div class="am-form-group " style="visibility: hidden;">
							<label for="user-email" class="am-u-sm-3 am-form-label">评论
								<span class="jhw-form-line-small-title">Comment</span>
							</label>
							<div class="am-u-sm-9 select-input-Box">
								<ul class="">
									<li class="comment-edit" data-number="1">
										<div class="am-u-sm-3">
											<select class="">
												<c:forEach items="${users }" var="user">
													<option value="${user.tuid }">${user.nickname }</option>
												</c:forEach>
											</select>
										</div>
										<div class="am-u-sm-7">
											<input type="text" placeholder="请输入评论" maxlength="11">
										</div>
										<div class="am-u-sm-2">
											<button href="javascript:void(0)" class="comment-add">
												<i class="am-icon-plus"></i>
											</button>
											<button href="javascript:void(0)" class="comment-subtract">
												<i class="am-icon-minus"></i>
											</button>
										</div>
									</li>
								</ul>
							</div>
						</div>
						<div class="am-btn-group am-btn-group-xs">
							<a href="#" onclick=""
								class="am-btn am-btn-default am-btn-success"> <span
								class="am-icon-plus"></span> 提交评论
							</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	</div>
</body>
<!-- 管理后台js -->
<script type="text/javascript" src="<%=request.getContextPath()%>/js/amazeui.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/amazeui.datetimepicker.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jhw.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/backstage/bs_table_list_paging.js"></script>
	
</html>