<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>江湖味</title>
<meta name="description" content="江湖味">
<meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1,user-scalable=no">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="black">

<!--标准mui.css-->
<link rel="stylesheet" href="<%=request.getContextPath()%>/wxh5assets/css/mui.min.css">
<!--App自定义的css-->
<link rel="stylesheet" href="<%=request.getContextPath()%>/wxh5assets/css/jhw.css">
<style>
.mui-control-content {
	background-color: white;
	/*min-height: 215px;*/
}

.mui-control-content .mui-loading {
	margin-top: 50px;
}
</style>
</head>
<body data-type="index">
	<input id="path" type="hidden" value="<%=request.getContextPath()%>">
	<div class="jhw-page">
		<div class="mui-content jhw-content">
			<div class="mui-slider mui-fullscreen jhw-party-slider">
				<div
					class="mui-scroll-wrapper mui-slider-indicator mui-segmented-control mui-segmented-control-inverted">
					<a class="citychange"> 上海 <i class="iconfont icon-arrowdown"></i></a>
					<div class="mui-scroll">
						<a class="mui-control-item mui-active" href="#party-all"> <span>全部</span></a> 
						<a class="mui-control-item" href="#party-outside"> <span>江湖饭局</span></a> 
						<a class="mui-control-item" href="#padty-family"> <span>家庭聚会</span></a>
					</div>
				</div>

				<div class="mui-slider-group jhw-slider-group">
					<div id="party-all" class="mui-slider-item mui-control-content mui-active">
						<div class="mui-scroll-wrapper">
							<div class="mui-scroll">
								<ul class="jhw-party-list">
									<li class="jhw-party-card mui-card" data-href="./party-details.html">
										<output class="jhw-interest-btn" data-interest='1'><!--0是未感兴趣 1是感兴趣--></output>
										<section class="mui-card-header mui-card-media"> 
											<a class="jhw-user-via" data-href="./user-info.html"> 
												<img src="<%=request.getContextPath()%>/wxh5assets/images/logo.png" />
											</a>
											<div class="mui-media-body">小M
												<p>
													<span class="sex" data-sex='0'>24岁</span>
													<!--0是女 1是男-->
													轻工业贸易
												</p>
												<p>上海肠胃炎UI</p>
											</div>
										</section>
										<div class="mui-card-content">
											<p class="jhw-party-cont">
												<!--<i class="iconfont icon-label"></i>-->
												<span class="jhw-party-cont-title"> 
													「 一个人没办法吃的深夜食堂——」 
												</span> 
												<span class="jhw-party-cont-intro">
													上午10点半，你开始一二三四五六七八九十一二三四五六七八九十一二三四五六七八九十，什么样的战术慕白熬 
													<a class="more">...全文</a>
												</span>
											</p>
											<p class="jhw-party-imgBox">
												<img src="<%=request.getContextPath()%>/wxh5assets/images/ceshi.jpg" / style="">
											</p>
											<div class="jhw-meeting-info">
												<p>
													<span class="jhw-text-orange"> <i
														class="iconfont icon-location"></i> 很高兴遇见你（日月光店）
													</span> 
													<span class="jhw-meeting-info-right">人均 &yen; 13220.88</span>
												</p>
												<p>
													<span class=""> 
														<i class="iconfont icon-time"></i>今晚 20:30
													</span> 
													<span class="">
														<i class="iconfont icon-users"></i>3人
													</span>
												</p>
											</div>
										</div> 
										<section class="mui-card-footer">
											<div class="jhw-via-list">
												<a href=""><img src="<%=request.getContextPath()%>/wxh5assets/images/icon_friend.png" /></a>
												<a href=""><img src="<%=request.getContextPath()%>/wxh5assets/images/icon_friend.png" /></a>
												<a href=""><img src="<%=request.getContextPath()%>/wxh5assets/images/icon_friend.png" /></a>
												等5人也报名了
											</div>
	
											<div class="">
												<i class="iconfont icon-love-o"></i>
												<output class="number">5</output>
												人感兴趣 <span>22条评论</span>
											</div>
										</section>
									</li>

									<li class="jhw-party-card mui-card" data-href="./party-details.html">
										<output class="jhw-interest-btn" data-interest='1'></output> 
										<section class="mui-card-header mui-card-media"> 
											<a class="jhw-user-via" href="./user-info.html"> 
												<img src="<%=request.getContextPath()%>/wxh5assets/images/logo.png" />
											</a>
											<div class="mui-media-body">小M
												<p>
													<span class="sex" data-sex='1'>24岁</span> 轻工业贸易
												</p>
												<p>上海肠胃炎UI</p>
											</div>
										</section>
										<div class="mui-card-content">
											<p class="jhw-party-cont">
												<!--<i class="iconfont icon-label"></i>-->
												<span class="jhw-party-cont-title"> 
													「 一个人没办法吃的深夜食堂——」 
												</span> 
												<span class="jhw-party-cont-intro">
													上午10点半，你开始一二三四五六七八九十一二三四五六七八九十一二三四五六七八九十，什么样的战术慕白熬 
													<a class="more">...全文</a>
												</span>
											</p>
											<p class="jhw-party-imgBox">
												<img src="<%=request.getContextPath()%>/wxh5assets/images/ceshi.jpg" / style="">
											</p>
											<div class="jhw-meeting-info">
												<p>
													<span class="jhw-text-orange"> 
														<i class="iconfont icon-location"></i> 很高兴遇见你（日月光店）
													</span> 
													<span class="jhw-meeting-info-right">人均 &yen; 13220.88</span>
												</p>
												<p>
													<span class=""> 
														<i class="iconfont icon-time"></i>今晚 20:30
													</span> 
													<span class=""><i class="iconfont icon-users"></i>3人</span>
												</p>
											</div>
										</div> 
										<section class="mui-card-footer">
											<div class="jhw-via-list">
												<a href=""><img src="<%=request.getContextPath()%>/wxh5assets/images/icon_friend.png" /></a>
												<a href=""><img src="<%=request.getContextPath()%>/wxh5assets/images/icon_friend.png" /></a>
												<a href=""><img src="<%=request.getContextPath()%>/wxh5assets/images/icon_friend.png" /></a>
												等5人也报名了
											</div>
	
											<div class="">
												<i class="iconfont icon-love-o"></i>
												<output class="number">5</output>
												人感兴趣 <span>22条评论</span>
											</div>
										</section>
									</li>
								</ul>
							</div>
						</div>
					</div>
					
					<div id="party-outside" class="mui-slider-item mui-control-content">
						<div class="mui-scroll-wrapper">
							<div class="mui-scroll">
								<ul class="jhw-party-list">
									<li class="mui-table-view-cell">第2个选项卡子项-1</li>

								</ul>
							</div>
						</div>
					</div>
					
					<div id="padty-family" class="mui-slider-item mui-control-content">
						<div class="mui-scroll-wrapper">
							<div class="mui-scroll">
								<ul class="jhw-party-list">
									<li class="mui-table-view-cell">第3个选项卡子项-1</li>

								</ul>
							</div>
						</div>
					</div>
					
				</div>
			</div>
		</div>

		<nav class="mui-bar mui-bar-tab jhw-nav-btm"> 
			<a class="mui-tab-item mui-active" href="#tabbar"> 
				<span class="iconfont icon-restaurant3"></span> 
				<span class="mui-tab-label">饭局</span>
			</a> 
			<a class="mui-tab-item" href="#tabbar-with-chat"> 
				<span class="iconfont icon-issue"></span> 
				<span class="mui-tab-label">发布饭局</span>
			</a> 
			<a class="mui-tab-item" href="#tabbar-with-contact"> 
				<span class="iconfont icon-message"></span> 
				<span class="mui-tab-label">消息</span>
			</a> 
			<a class="mui-tab-item" href="#tabbar-with-map"> 
				<span class="iconfont icon-mine"></span> 
				<span class="mui-tab-label">我的</span>
			</a> 
		</nav>
	</div>
</body>
		<script src="<%=request.getContextPath()%>/wxh5assets/js/mui.min.js"></script>
		<script src="<%=request.getContextPath()%>/wxh5assets/js/jhw.js"></script>
		<script src="<%=request.getContextPath()%>/wxh5assets/js/jhw.pullToRefresh.js"></script>

		<script>
			mui.init();
			(function($) {
				//阻尼系数
				var deceleration = mui.os.ios ? 0.003 : 0.0009;
				$('.mui-scroll-wrapper').scroll({
					bounce: false,
					indicators: true, //是否显示滚动条
					deceleration: deceleration
				});
				$.ready(function() {
					//循环初始化所有下拉刷新，上拉加载。
					$.each(document.querySelectorAll('.mui-slider-group .mui-scroll'), function(index, pullRefreshEl) {
						$(pullRefreshEl).pullToRefresh({
							down: {
								callback: function() {
									var self = this;
									setTimeout(function() {
										var ul = self.element.querySelector('.jhw-party-list');
										ul.insertBefore(createFragment(ul, index, 10, true), ul.firstChild);
										self.endPullDownToRefresh();
									}, 1000);
								}
							},
							up: {
								callback: function() {
									var self = this;
									setTimeout(function() {
										var ul = self.element.querySelector('.jhw-party-list');
										ul.appendChild(createFragment(ul, index, 5));
										self.endPullUpToRefresh();
									}, 1000);
								}
							}
						});
					});
					var createFragment = function(ul, index, count, reverse) {
						var length = ul.querySelectorAll('li').length;
						var fragment = document.createDocumentFragment();
						var li;
						console.log('加载' + index)
						for(var i = 0; i < count; i++) {
							li = document.createElement('li');
							li.className = 'mui-table-view-cell';
							li.innerHTML = '<span>sss</span>第' + (index + 1) + '个选项卡子项-' + (length + (reverse ? (count - i) : (i + 1)));
							fragment.appendChild(li);
						}
						return fragment;
					};
				});
			})(mui);

			//点击感兴趣按钮
			mui(".jhw-party-list").on('tap', '.jhw-interest-btn', function(e) {
				e.stopPropagation();
				var _parentNode = this.parentNode;
				var _interest = this.getAttribute('data-interest') * 1;
				var num = _parentNode.querySelectorAll('.number')[0].innerText * 1;
				if(_interest == 0) {
					this.children[0].classList.remove('icon-love-o');
					this.children[0].classList.add('icon-love');
					mui.hint('已收藏到感兴趣的饭局', {
						duration: 500,
						_parentNode: _parentNode
					})
					this.setAttribute('data-interest', '1');
					_parentNode.querySelectorAll('.number')[0].innerText = num + 1;

				} else {
					this.children[0].classList.remove('icon-love');
					this.children[0].classList.add('icon-love-o');
					this.setAttribute('data-interest', '0');
					_parentNode.querySelectorAll('.number')[0].innerText = num - 1;
				}

			})
		</script>
</html>