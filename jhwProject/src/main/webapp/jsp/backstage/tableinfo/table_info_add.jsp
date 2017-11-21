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

						<form id="submit_table" method="post">
							<div class="am-form-group">
								<label for="user-name" class="am-u-sm-3 am-form-label">
									发起者<span class="jhw-form-line-small-title">Sponsor</span>
								</label>
								<div class="am-u-sm-9">
									<select data-am-selected="{searchBox: 1}" class="select_initiator">
										<option value="-1">请选择</option>
										<c:forEach items="${users }" var="user">
											<option value="${user.tuid }">${user.nickname }</option>
										</c:forEach>
									</select> <input type="hidden" name="initiatorid" id="initiatorId"/>
								</div>
							</div>
							<div class="am-form-group">
								<label class="am-u-sm-3 am-form-label">餐厅 <span
									class="jhw-form-line-small-title">Restaurant</span></label>
								<div class="am-u-sm-9">
									<select data-am-selected="{searchBox: 1}" class="select_restaurant">
										<option value="-1">请选择</option>
										<c:forEach items="${restaurants }" var="item">
											<option value="${item.restaurant.trid }">${item.restaurant.name }</option>
										</c:forEach>
									</select> <input type="hidden" name="restaurantid" id="restaurantId"/>
								</div>
							</div>

							<div class="am-form-group">
								<label class="am-u-sm-3 am-form-label">时间 <span
									class="jhw-form-line-small-title">Time</span></label>
								<div class="am-u-sm-9">
									<input size="16" type="text" value="" placeholder="请选择日期"
										readonly class="form-datetime am-form-field" name="begainDate">
								</div>
							</div>
							
							<div class="am-form-group" id="participate_div">
								<label class="am-u-sm-3 am-form-label">参与人 <span
									class="jhw-form-line-small-title">ParticipantS</span></label>
								<div class="am-u-sm-9 chosenBox-multiple">
									<select multiple data-am-selected onchange="changeParticipate()"
										data-am-selected="{searchBox: 1}" class="participate_people">
										<c:forEach items="${users }" var="user" varStatus="status">
											<option value="${user.tuid }">${user.nickname }</option>
										</c:forEach>
									</select>
								</div>
								<div id="participateInput"></div>
							</div>
							<div class="am-form-group">
								<label class="am-u-sm-3 am-form-label">聚会说明 <span
									class="jhw-form-line-small-title">Explain</span></label>
								<div class="am-u-sm-9">
									<textarea class="" rows="10" name=tableExplain placeholder="请输入聚会说明"></textarea>
								</div>
							</div>
							<input id="tokenVal" name="token" type="hidden" />
							<div class="am-btn-group am-btn-group-xs">
								<a href="#" onclick="submitTable()"
									class="am-btn am-btn-default am-btn-success"> <span
									class="am-icon-plus"></span> 提交饭局
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