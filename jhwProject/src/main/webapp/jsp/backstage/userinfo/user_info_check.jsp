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
					<div class="am-form jhw-form-line-form">
						<div class="am-form-group">
							<label for="user-weibo" class="am-u-sm-3 am-form-label">头像
								<span class="jhw-form-line-small-title">Images</span>
							</label>
							<div class="am-u-sm-9">
								<div class="up-img-cover">
									<img class="am-circle" alt="点击图片上传" src="${result.resultObj.headimgUrl }">
								</div>
							</div>
						</div>
						<div class="am-form-group">
							<label for="user-name" class="am-u-sm-3 am-form-label">
								昵称<span class="jhw-form-line-small-title">Name</span>
							</label>
							<div class="am-u-sm-9">
								<article>${result.resultObj.nickname }</article>
							</div>
						</div>
						<div class="am-form-group">
							<label class="am-u-sm-3 am-form-label">信用分 <span
								class="jhw-form-line-small-title">Grade</span></label>
							<div class="am-u-sm-9">
								<article>${result.resultObj.creditValue }</article>
							</div>
						</div>
						<div class="am-form-group">
							<label class="am-u-sm-3 am-form-label">手机号 <span
								class="jhw-form-line-small-title">Phone</span></label>
							<div class="am-u-sm-9">
								<article>${result.resultObj.phone }</article>
							</div>
						</div>
						<div class="am-form-group">
							<label class="am-u-sm-3 am-form-label">身份证号 <span
								class="jhw-form-line-small-title">ID number</span></label>
							<div class="am-u-sm-9">
								<article>${result.resultObj.idCardno }</article>
							</div>
						</div>
						<div class="am-form-group">
							<label class="am-u-sm-3 am-form-label">学历 <span
								class="jhw-form-line-small-title">Education</span></label>
							<div class="am-u-sm-9">
								<article>${result.resultObj.school }</article>
							</div>
						</div>
						<div class="am-form-group">
							<label class="am-u-sm-3 am-form-label">性别 <span
								class="jhw-form-line-small-title">Sex</span></label>
							<div class="am-u-sm-9">
								<c:choose>
									<c:when test="${result.resultObj.sex == 73 }">
										<article>男士</article>
									</c:when>
									<c:when test="${result.resultObj.sex == 74 }">
										<article>女士</article>
									</c:when>
									<c:when test="${result.resultObj.sex == 75 }">
										<article>保密</article>
									</c:when>
								</c:choose>
							</div>
						</div>
						<div class="am-form-group">
							<label class="am-u-sm-3 am-form-label">抽烟 <span
								class="jhw-form-line-small-title">Smoking</span></label>
							<div class="am-u-sm-9">
								<c:choose>
									<c:when test="${result.resultObj.smoke == 45 }">
										<article>经常</article>
									</c:when>
									<c:when test="${result.resultObj.smoke == 46 }">
										<article>不吸</article>
									</c:when>
									<c:when test="${result.resultObj.smoke == 47 }">
										<article>有时</article>
									</c:when>
								</c:choose>
							</div>
						</div>
						<div class="am-form-group">
							<label class="am-u-sm-3 am-form-label">喝酒 <span
								class="jhw-form-line-small-title">Drink</span></label>
							<div class="am-u-sm-9">
								<c:choose>
									<c:when test="${result.resultObj.drink == 41 }">
										<article>经常</article>
									</c:when>
									<c:when test="${result.resultObj.drink == 42 }">
										<article>不喝</article>
									</c:when>
									<c:when test="${result.resultObj.drink == 43 }">
										<article>有时</article>
									</c:when>
								</c:choose>
							</div>
						</div>
						<div class="am-form-group">
							<label for="user-email" class="am-u-sm-3 am-form-label">生日
								<span class="jhw-form-line-small-title">Birthday</span>
							</label>
							<div class="am-u-sm-9">
								<article>${result.resultObj.birthday }</article>
							</div>
						</div>
						<div class="am-form-group">
							<label class="am-u-sm-3 am-form-label">年龄 <span
								class="jhw-form-line-small-title">Age</span></label>
							<div class="am-u-sm-9">
								<article>${result.resultObj.age }</article>
							</div>
						</div>
						<div class="am-form-group">
							<label for="user-intro" class="am-u-sm-3 am-form-label">个人简介</label>
							<div class="am-u-sm-9">
								<article>${result.resultObj.aboutMe }</article>
							</div>
						</div>
						<div class="am-form-group">
							<label for="user-intro" class="am-u-sm-3 am-form-label">相册</label>
							<div class="am-u-sm-9">
								<ul data-am-widget="gallery"
									class="am-gallery am-avg-sm-2am-avg-md-3 am-avg-lg-4 am-gallery-default"
									data-am-gallery="{ pureview: true }">
									<li>
										<div class="am-gallery-item">
											<img src="http://s.amazeui.org/media/i/demos/bing-1.jpg" />
										</div>
									</li>
									<li>
										<div class="am-gallery-item">
											<img src="http://s.amazeui.org/media/i/demos/bing-2.jpg" />
										</div>
									</li>
									<li>
										<div class="am-gallery-item">
											<img src="http://s.amazeui.org/media/i/demos/bing-3.jpg" />
										</div>
									</li>
									<li>
										<div class="am-gallery-item">
											<img src="http://s.amazeui.org/media/i/demos/bing-4.jpg" />
										</div>
									</li>
								</ul>

							</div>
						</div>

					</div>

				</div>
			</div>
		</div>

	</div>
</body>
<%@include file="/jsp/common/common_js.jsp"%>
<%-- <script type="text/javascript" src="<%=request.getContextPath() %>/js/backstage/bs_add_edit_user.js"></script> --%>
</html>