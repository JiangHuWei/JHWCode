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
		<li class="am-active">饭局详情</li>
	</ol>
	<div class="jhw-portlet-components">
		<div class="jhw-block">
			<div class="am-g">
				<div class="jhw-form-body jhw-form-line">
					<div class="am-form jhw-form-line-form">
						<!--<div class="am-form-group">
									<label for="user-weibo" class="am-u-sm-3 am-form-label">头像 <span class="jhw-form-line-small-title">Images</span></label>
									<div class="am-u-sm-9">
										<div class="up-img-cover">
											<img class="am-circle" alt="点击图片上传" src="assets/img/hu.jpg">
										</div>
									</div>
								</div>-->
						<div class="am-form-group">
							<label for="user-name" class="am-u-sm-3 am-form-label">
								发起者<span class="jhw-form-line-small-title">Sponsor</span>
							</label>
							<div class="am-u-sm-9">
								<article>${uesrInfo.nickname }</article>
							</div>
						</div>
						<div class="am-form-group">
							<label class="am-u-sm-3 am-form-label">餐厅 <span
								class="jhw-form-line-small-title">Restaurant</span></label>
							<div class="am-u-sm-9">
								<article>${result.restaurantPoJo.name }</article>
							</div>
						</div>
						<div class="am-form-group">
							<label class="am-u-sm-3 am-form-label">时间 <span
								class="jhw-form-line-small-title">Time</span></label>
							<div class="am-u-sm-9">
								<article>${result.begainDate }</article>
							</div>
						</div>
						<div class="am-form-group">
							<label class="am-u-sm-3 am-form-label">地点 <span
								class="jhw-form-line-small-title">Site</span></label>
							<div class="am-u-sm-9">
								<article>${result.restaurantPoJo.location }</article>
							</div>
						</div>
						<div class="am-form-group">
							<label class="am-u-sm-3 am-form-label">参与人 <span
								class="jhw-form-line-small-title">ParticipantS</span></label>
							<div class="am-u-sm-9">
								<!-- <article></article> -->
								<c:forEach items="${attentUsers }" var="item">
									${item.userPoJo.nickname },
								</c:forEach>
							</div>
						</div>
						<div class="am-form-group">
							<label class="am-u-sm-3 am-form-label">聚会说明 <span
								class="jhw-form-line-small-title">Explain</span></label>
							<div class="am-u-sm-9">
								<article>${result.tableExplain }</article>
							</div>
						</div>
						<div class="am-form-group">
							<label class="am-u-sm-3 am-form-label">图片 <span
								class="jhw-form-line-small-title">Images</span></label>
							<div class="am-u-sm-9">
								<ul data-am-widget="gallery"
									class="am-gallery am-avg-sm-2
  am-avg-md-3 am-avg-lg-4 am-gallery-default"
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
						<div class="am-form-group">
							<label for="user-email" class="am-u-sm-3 am-form-label">评论
								<span class="jhw-form-line-small-title">Comment</span>
							</label>
							<div class="am-u-sm-9">
								<div class="am-panel-bd am-cf am-collapse am-in"
									id="collapse-panel-3">
									<ul class="am-comments-list admin-content-comment">
										<li class="am-comment"><a href="#"><img
												src="http://s.amazeui.org/media/i/demos/bw-2014-06-19.jpg?imageView/1/w/96/h/96"
												alt="" class="am-comment-avatar" width="48" height="48"></a>
											<div class="am-comment-main">
												<header class="am-comment-hd">
												<div class="am-comment-meta">
													<a href="#" class="am-comment-author">某人</a> 评论于
													<time>2014-7-12 15:30</time>
												</div>
												</header>
												<div class="am-comment-bd">
													<p>666</p>
												</div>
											</div></li>

										<li class="am-comment"><a href="#"><img
												src="http://s.amazeui.org/media/i/demos/bw-2014-06-19.jpg?imageView/1/w/96/h/96"
												alt="" class="am-comment-avatar" width="48" height="48"></a>
											<div class="am-comment-main">
												<header class="am-comment-hd">
												<div class="am-comment-meta">
													<a href="#" class="am-comment-author">某人</a> 评论于
													<time>2014-7-12 15:30</time>
												</div>
												</header>
												<div class="am-comment-bd">
													<p>就是帅</p>
												</div>
											</div></li>

									</ul>
									<ul class="am-pagination am-fr admin-content-pagination">
										<li class="am-disabled"><a href="#">«</a></li>
										<li class="am-active"><a href="#">1</a></li>
										<li><a href="#">2</a></li>
										<li><a href="#">3</a></li>
										<li><a href="#">4</a></li>
										<li><a href="#">5</a></li>
										<li><a href="#">»</a></li>
									</ul>
								</div>

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
<script type="text/javascript" src="<%=request.getContextPath()%>/js/backstage/bs_table_list_paging.js"></script>
</html>