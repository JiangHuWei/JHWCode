<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<div class="jhw-block">
		<div class="am-g">
			<div class="jhw-form-body jhw-form-line">
				<form id="addAndeditForm" class="am-form jhw-form-line-form" method="post">
					<div class="am-form-group">
						<label for="user-weibo" class="am-u-sm-3 am-form-label">头像
							<span class="jhw-form-line-small-title">Images</span>
						</label>
						<div class="am-u-sm-9">
							<img class="am-circle via" src="<%=request.getContextPath() %>/img/hu.jpg">
							<div class="new-contentarea tc">
								<a href="javascript:void(0)" class="upload-img">
									<label for="upload-file">上传图像</label>
								</a>
								<input type="file" class="" name="upload-file" id="upload-file" />
							</div>
						</div>
						<input id="headimgUrl" name="userPoJo.headimgUrl" type="hidden" value=""/>
					</div>
					<div class="am-form-group">
						<label for="real-name" class="am-u-sm-3 am-form-label"> 真实姓名<span
							class="jhw-form-line-small-title">Name</span>
						</label>
						<div class="am-u-sm-9">
							<input type="text" class="jhw-form-input" id="real-name" name="userPoJo.actualName"
								placeholder="请输入真实姓名" value="">
						</div>
					</div>
					<div class="am-form-group">
						<label for="user-name" class="am-u-sm-3 am-form-label"> 昵称<span
							class="jhw-form-line-small-title">Name</span>
						</label>
						<div class="am-u-sm-9">
							<input type="text" class="jhw-form-input" id="user-name" name="userPoJo.nickname"
								placeholder="请输入昵称" value="">
						</div>
					</div>
					<div class="am-form-group">
						<label class="am-u-sm-3 am-form-label">信用分 <span
							class="jhw-form-line-small-title">Grade</span></label>
						<div class="am-u-sm-9">
							<input type="number" placeholder="请输入信用分" value="" name="userPoJo.creditValue"/>
						</div>
					</div>
					<div class="am-form-group">
						<label class="am-u-sm-3 am-form-label">手机号 <span
							class="jhw-form-line-small-title">Phone</span></label>
						<div class="am-u-sm-9">
							<input type="number" placeholder="请输入手机号" maxlength="11" name="userPoJo.phone"
								value="">
						</div>
					</div>
					<div class="am-form-group">
						<label class="am-u-sm-3 am-form-label">身份证号 <span
							class="jhw-form-line-small-title">ID number</span></label>
						<div class="am-u-sm-9">
							<input type="number" placeholder="请输入身份证号" maxlength="18" name="userPoJo.idCardno"
								value="">
						</div>
					</div>
					<div class="am-form-group">
						<label class="am-u-sm-3 am-form-label">学历 <span
							class="jhw-form-line-small-title">Education</span></label>
						<div class="am-u-sm-9 select-input-Box">
							<div class="am-u-sm-3">
								<select id="authenticationSelect" data-am-selected>
									<option value="122">已认证</option>
									<option value="123" selected="selected">未认证</option>
								</select>
							</div>
							<input id="eduAuthentication" type="hidden" name="userPoJo.eduAuthentication"/>
							<div class="am-u-sm-9">
								<input type="text" placeholder="请输入毕业学校" value="" maxlength="11" name="userPoJo.school">
							</div>
						</div>
					</div>
					<div class="am-form-group">
						<label class="am-u-sm-3 am-form-label">性别 <span
							class="jhw-form-line-small-title">Sex</span></label>
						<div id="sexSelect" class="am-u-sm-9">
							<label class="am-radio-inline"> 
								<input type="radio" value="75" name="sexChange" data-am-ucheck checked="checked">保密
							</label> 
							<label class="am-radio-inline"> 
								<input type="radio" value="73" name="sexChange"  data-am-ucheck> 男
							</label> 
							<label class="am-radio-inline"> 
								<input type="radio" value="74" name="sexChange"  data-am-ucheck> 女
							</label>
						</div>
						<input id="sex" type="hidden" value="" name="userPoJo.sex" /> 
					</div><!-- -->
					<div class="am-form-group">
						<label class="am-u-sm-3 am-form-label">抽烟 <span
							class="jhw-form-line-small-title">Smoking</span></label>
						<div id="smokeSelect" class="am-u-sm-9">
							<label class="am-radio-inline"> 
								<input type="radio" value="46" name="smokeChange" data-am-ucheck checked="checked">从不
							</label> 
							<label class="am-radio-inline"> 
								<input type="radio" value="47" name="smokeChange" data-am-ucheck> 偶尔
							</label> 
							<label class="am-radio-inline"> 
								<input type="radio" value="45" name="smokeChange" data-am-ucheck> 经常
							</label>
						</div>
						<input id="smoke" type="hidden" value="" name="userPoJo.smoke"/> 
					</div>
					<div class="am-form-group">
						<label class="am-u-sm-3 am-form-label">喝酒 <span
							class="jhw-form-line-small-title">Drink</span></label>
						<div id="drinkSelect" class="am-u-sm-9">
							<label class="am-radio-inline"> 
								<input type="radio" value="42" name="drinkChange" data-am-ucheck checked="checked">从不
							</label> 
							<label class="am-radio-inline"> 
								<input type="radio" value="43" name="drinkChange" data-am-ucheck> 偶尔
							</label> 
							<label class="am-radio-inline"> 
								<input type="radio" value="41" name="drinkChange" data-am-ucheck> 经常
							</label>
						</div>
						<input id="drink" type="hidden" value="" name="userPoJo.drink"/> 
					</div>
					<div class="am-form-group">
						<label for="user-email" class="am-u-sm-3 am-form-label">生日
							<span class="jhw-form-line-small-title">Birthday</span>
						</label>
						<div class="am-u-sm-9">
							<input name="userPoJo.birthday" type="text" class="am-form-field jhw-form-no-bg"
								placeholder="请输入生日" data-am-datepicker="" readonly />
						</div>
					</div> 
					<div class="am-form-group">
						<label class="am-u-sm-3 am-form-label">年龄 <span
							class="jhw-form-line-small-title">Age</span></label>
						<div class="am-u-sm-9">
							<input type="number" placeholder="输入年龄" value="" name="userPoJo.age">
						</div>
					</div>
					<div class="am-form-group">
						<label for="user-intro" class="am-u-sm-3 am-form-label">个人简介</label>
						<div class="am-u-sm-9">
							<textarea class="" name="userPoJo.aboutMe" rows="10" placeholder="请输入个人简介"></textarea>
						</div>
					</div>
					<input id="token" type="hidden" name="tokenStr"/>
					<div class="am-form-group">
						<div class="am-u-sm-9 am-u-sm-push-3 am-text-right">
							<button class="am-btn am-btn-danger">取消</button>
							<button class="am-btn am-btn-success" onclick="addUser()">提交</button>
						</div>
					</div>
				</form>

			</div>
		</div>
	</div>
</body>
<%@include file="/jsp/common/common_js.jsp"%>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/backstage/bs_add_edit_user.js"></script>
</html>