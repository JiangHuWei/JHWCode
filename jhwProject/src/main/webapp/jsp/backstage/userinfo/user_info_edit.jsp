<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<div class="jhw-portlet-components">
		<div class="jhw-block">

			<div class="am-g">
				<div class="jhw-form-body jhw-form-line">
					<form id="editForm" class="am-form jhw-form-line-form" method="post">
						<div class="am-form-group">
							<label for="user-weibo" class="am-u-sm-3 am-form-label">头像
								<span class="jhw-form-line-small-title">Images</span>
							</label>
							<div class="am-u-sm-9">
								<div class="up-img-cover" id="up-img-touch">
									<img class="am-circle" alt="点击图片上传" src="${result.headimgUrl }"
										data-am-popover="{content: '点击上传', trigger: 'hover focus'}">
								</div>
							</div>
							<input id="headimg" name="headimgUrl" type="hidden" value=""/>
						</div>
						<div class="am-form-group">
							<label for="user-name" class="am-u-sm-3 am-form-label">
								昵称<span class="jhw-form-line-small-title">Name</span>
							</label>
							<div class="am-u-sm-9">
								<input type="text" class="jhw-form-input" id="user-name" name="nickname"
									placeholder="请输入昵称" value="${result.nickname }">
							</div>
						</div>
						<div class="am-form-group">
							<label class="am-u-sm-3 am-form-label">信用分 <span
								class="jhw-form-line-small-title">Grade</span></label>
							<div class="am-u-sm-9">
								<input type="number" placeholder="请输入信用分" value="${result.creditValue }" name="creditValue">
							</div>
						</div>
						<div class="am-form-group">
							<label class="am-u-sm-3 am-form-label">手机号 <span
								class="jhw-form-line-small-title">Phone</span></label>
							<div class="am-u-sm-9">
								<input type="number" placeholder="请输入手机号" maxlength="11" name="phone"
									value="${result.phone }">
							</div>
						</div>
						<div class="am-form-group">
							<label class="am-u-sm-3 am-form-label">身份证号 <span
								class="jhw-form-line-small-title">ID number</span></label>
							<div class="am-u-sm-9">
								<input type="text" placeholder="请输入身份证号" maxlength="11" name="idCardno"
									value="${result.idCardno }">
							</div>
						</div>
						<div class="am-form-group">
							<label class="am-u-sm-3 am-form-label">毕业学校 <span
								class="jhw-form-line-small-title">School</span></label>
							<div class="am-u-sm-9">
								<input type="text" placeholder="请输入毕业学校" name="school"
									value="${result.school }">
							</div>
						</div>
						<div class="am-form-group">
							<label class="am-u-sm-3 am-form-label">性别<span
								class="jhw-form-line-small-title">Sex</span></label>
							<div id="sexSelect" class="am-u-sm-9">
								<c:if test="${result.sex == 73 }">
									<label class="am-radio-inline"> <input type="radio"
										value="75" name="sexSelect" data-am-ucheck>保密
									</label>
									<label class="am-radio-inline"> <input type="radio"
										value="73" name="sexSelect" data-am-ucheck checked="checked">
										男
									</label>
									<label class="am-radio-inline"> <input type="radio"
										value="74" name="sexSelect" data-am-ucheck> 女
									</label>
								</c:if>
								<c:if test="${result.sex == 74 }">
									<label class="am-radio-inline"> <input type="radio"
										value="75" name="sexSelect" data-am-ucheck>保密
									</label>
									<label class="am-radio-inline"> <input type="radio"
										value="73" name="sexSelect" data-am-ucheck> 男
									</label>
									<label class="am-radio-inline"> <input type="radio"
										value="74" name="sexSelect" data-am-ucheck checked="checked">
										女
									</label>
								</c:if>
								<c:if test="${result.sex == 75 }">
									<label class="am-radio-inline"> <input type="radio"
										value="75" name="sexSelect" data-am-ucheck checked="checked">保密
									</label>
									<label class="am-radio-inline"> <input type="radio"
										value="73" name="sexSelect" data-am-ucheck> 男
									</label>
									<label class="am-radio-inline"> <input type="radio"
										value="74" name="sexSelect" data-am-ucheck> 女
									</label>
								</c:if>
							</div>
							<input id="sex" type="hidden" value="" name="sex" /> 
						</div>
						<div class="am-form-group">
							<label class="am-u-sm-3 am-form-label">抽烟${result.smoke} <span
								class="jhw-form-line-small-title">Smoking</span></label>
							<div id="smokeSelect" class="am-u-sm-9">
								<label class="am-radio-inline"> 
									<c:if test="${result.smoke == 45 }">
										<input type="radio" name="smoking" value="45" data-am-ucheck checked="checked"> 经常
									</c:if>
									<c:if test="${result.smoke != 45 }">
										<input type="radio" name="smoking" value="45" data-am-ucheck> 经常
									</c:if>
								</label> 
								<label class="am-radio-inline"> 
									<c:if test="${result.smoke == 46 }">
										<input type="radio" name="smoking" value="46" data-am-ucheck checked="checked">从不
									</c:if> 
									<c:if test="${result.smoke != 46 }">
										<input type="radio" name="smoking" value="46" data-am-ucheck>从不
									</c:if>
								</label> 
								<label class="am-radio-inline"> 
									<c:if test="${result.smoke == 47 }">
										<input type="radio" name="smoking" value="47" data-am-ucheck checked="checked">偶尔
									</c:if>
									<c:if test="${result.smoke != 47 }">
										<input type="radio" name="smoking" value="47" data-am-ucheck>偶尔
									</c:if>
								</label>
							</div>
							<input id="smoke" type="hidden" value="" name="smoke"/> 
						</div>
						<div class="am-form-group">
							<label class="am-u-sm-3 am-form-label">喝酒${result.drink } <span
								class="jhw-form-line-small-title">Drink</span></label>
							<div id="drinkSelect" class="am-u-sm-9">
								<c:if test="${result.drink == 41 }">
									<label class="am-radio-inline"> <input type="radio"
										name="drinkChange" value="42" data-am-ucheck>从不
									</label>
									<label class="am-radio-inline"> <input type="radio"
										name="drinkChange" value="43" data-am-ucheck> 偶尔
									</label>
									<label class="am-radio-inline"> <input type="radio"
										name="drinkChange" value="41" data-am-ucheck checked="checked">
										经常
									</label>
								</c:if>
								<c:if test="${result.drink == 42 }">
									<label class="am-radio-inline"> <input type="radio"
										name="drinkChange" value="42" data-am-ucheck checked="checked">从不
									</label>
									<label class="am-radio-inline"> <input type="radio"
										name="drinkChange" value="43" data-am-ucheck> 偶尔
									</label>
									<label class="am-radio-inline"> <input type="radio"
										name="drinkChange" value="41" data-am-ucheck> 经常
									</label>
								</c:if>
								<c:if test="${result.drink == 43 }">
									<label class="am-radio-inline"> <input type="radio"
										name="drinkChange" value="42" data-am-ucheck>从不
									</label>
									<label class="am-radio-inline"> <input type="radio"
										name="drinkChange" value="43" data-am-ucheck checked="checked">
										偶尔
									</label>
									<label class="am-radio-inline"> <input type="radio"
										name="drinkChange" value="41" data-am-ucheck> 经常
									</label>
								</c:if>
							</div>
							<input id="drink" type="hidden" value="" name="drink"/> 
						</div>
						<div class="am-form-group">
							<label for="user-email" class="am-u-sm-3 am-form-label">生日
								<span class="jhw-form-line-small-title">Birthday</span>
							</label>
							<div class="am-u-sm-9">
								<input type="text" class="am-form-field jhw-form-no-bg" name="birthday"
									value="${result.birthday }" placeholder="请输入生日" data-am-datepicker=""
									readonly />
							</div>
						</div> 
						<div class="am-form-group">
							<label class="am-u-sm-3 am-form-label">年龄 <span
								class="jhw-form-line-small-title">Age</span></label>
							<div class="am-u-sm-9">
								<input type="number" placeholder="输入年龄" value="${result.age }" name="age">
							</div>
						</div>
						<div class="am-form-group">
							<label for="user-intro" class="am-u-sm-3 am-form-label">个人简介</label>
							<div class="am-u-sm-9">
								<textarea class="" rows="10" placeholder="请输入个人简介" name="aboutMe">${result.aboutMe }</textarea>
							</div>
						</div>
						<input id="token" type="hidden" name="tokenStr"/>
						<input name="tuid" type="hidden" value="${result.tuid }"/>
						<div class="am-form-group">
							<div class="am-u-sm-9 am-u-sm-push-3 am-text-right">
								<!-- <button type="button" class="am-btn am-btn-danger">取消</button> -->
								<button type="button" class="am-btn am-btn-success" onclick="editUser()">提交</button>
							</div>
						</div>
					</form>

				</div>
			</div>
		</div>

	</div>
</body>
<%@include file="/jsp/common/common_js.jsp"%>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/backstage/bs_edit_user.js"></script>
</html>