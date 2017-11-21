/*
* @Author: TAO
* @Date:   2017-10-12 15:52:25
* @Last Modified by:   TAO
* @Last Modified time: 2017-11-07 15:39:11
*/
//控制body字体
var _fontsize ;
if (100 * innerWidth / 414 > 150) {
	_fontsize = 150;
} else {
	_fontsize = 100 * innerWidth / 414;
}
document.documentElement.style.fontSize = _fontsize+ 'px';


//根据分数自动生成星星
var star_grade = '<i class="mui-icon"></i><i class="mui-icon"></i><i class="mui-icon"></i><i class="mui-icon"></i><i class="mui-icon"></i>';

mui(".jhw-user-evaluate-grade .jhw-grade-number").each(function() {
	this.innerHTML = star_grade;
	var _grade = this.dataset.grade;//取值	
	
	var _integer = Math.floor(_grade);//向下取整
	var _decimal = (_grade - _integer).toFixed(1);
	
	
  	var children = this.children; 
	for(var i=0;i<_integer;i++){ 				
		children[i].classList.add('mui-icon-star-filled');
	}
	if (_decimal == 0.5 ) {
		
			children[i].classList.add('mui-icon-starhalf');
			for (var i = _integer+1; i < 5; i++) {
				children[i].classList.add('mui-icon-star')		
			}
	}else{
		
		for (var i = _integer; i < 5; i++) {
			children[i].classList.add('mui-icon-star')		
		}
	}
	
});

var isInterest = '<i class="iconfont"></i>';

mui(".jhw-interest-btn").each(function() {
	this.innerHTML = isInterest;
	var _interest = this.dataset.interest * 1;//取值	
	var children = this.children; 
	if (_interest == 1 ) {
		children[0].classList.add('icon-love');
	}else{	
		children[0].classList.add('icon-love-o');
	}
	
});
mui("#jhw-quitParty").each(function() {
	var _author = this.dataset.delete * 1;//取值	
	if (_author == 0 ) {
		this.innerHTML = '删除饭局';
	}else{	
		this.innerHTML = '退出饭局';
	}
	
});
mui(".sex").each(function() {
	var _sex = this.dataset.sex * 1;//取值	
	if (_sex == 1 ) {
		this.classList.add('male');
	}else if(_sex == 0){	
		this.classList.add('female');
	}
	
});
//餐厅关注按钮
mui(".jhw-restaurant-attentionBtn").each(function() {
	var _attention = this.dataset.attention * 1;//取值	
	if (_attention == 0 ) {
		this.innerHTML = '关注餐厅';
	}else{	
		this.innerHTML = '已关注';
	}
	
});
//详情评论 隐藏
mui('body').on('tap','#jhw-comment-backdrop',function(){  
    this.nextElementSibling.style.display = 'none';
    this.style.display = 'none';

});

mui('.jhw-party-list').on('tap','.jhw-party-card',function(){  
    window.top.location.href=this.dataset.href;

});
mui('body').on('tap','.mui-icon-left-nav',function(e){  
    window.history.back();

});
/*mui('body').on('tap','.jhw-cell',function(e){  
    this.classList.add('mui-active')

});
mui('body').on('release','.jhw-cell',function(e){  
    this.classList.remove('mui-active')

});*/
//评论 发送按钮变色
mui('.jhw-comment-input').on('keyup','#content',function(){  
    if (this.value !== '') {
    	this.nextElementSibling.classList.add('submit');  
    } else{
    	this.nextElementSibling.classList.remove('submit');  
    }
});
//是否通过报名
mui(".jhw-apply-operation").each(function() {
	var _sex = this.dataset.pass * 1;//取值	
	if (_sex == 1 ) {
		this.innerHTML='已通过';
	}
	
});
//console.log(oTop);
mui(".touchBody").on('drag','.jhw-page',function(){
	var oTop = document.querySelectorAll('.jhw-party-fever')[0].offsetTop*1 -43;
	var fixed_box = document.getElementById('jhw-slider-indicator');
    var top = document.querySelectorAll('.jhw-content')[0].scrollTop*1;
     
 
     if(top > oTop) {
     	//console.log('ok');
		
		fixed_box.classList.add('jhw-content-fixed');
		
	}else{
		fixed_box.classList.remove('jhw-content-fixed');
		
	}
	
});
mui(".touchBody").on('dragend','.jhw-page',function(){
	var oTop = document.querySelectorAll('.jhw-party-fever')[0].offsetTop*1 -44;
	var fixed_box = document.getElementById('jhw-slider-indicator');
    var top = document.querySelectorAll('.jhw-content')[0].scrollTop*1;

     if(top > oTop) {
     	//console.log('ok');
		
		fixed_box.classList.add('jhw-content-fixed');
		
	}else{
		fixed_box.classList.remove('jhw-content-fixed');
		
	}
	
});
//评论字数统计
mui('.jhw-textInputBox').on('keyup','textarea',function(e){  
    this.parentNode.querySelectorAll('span')[0].innerHTML =this.value.length;
});