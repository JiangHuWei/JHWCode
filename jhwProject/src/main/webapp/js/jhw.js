/*
* @Author: TAO
* @Date:   2017-09-21 17:21:08
* @Last Modified by:   TAO
* @Last Modified time: 2017-09-26 17:19:56
*/
//
var topPadding = 95;
$(function() {
    var offset = $(".jhw-left-nav-hover").offset();  
    $(window).scroll(function() {
        var sideBarHeight = $(".jhw-left-nav-hover").height();
        if ($(window).scrollTop() > 20) {
            var newPosition = ($(window).scrollTop() - offset.top) + topPadding;
           
            $(".jhw-left-nav-hover").stop().animate({
                marginTop: newPosition
            },500);
        } else {
            $(".jhw-left-nav-hover").stop().animate({
                marginTop: 0
            });
        };
    });
    //表格最小高度
        var h =$(window).height()-204;
    $('.jhw-portlet-components').css('min-height',h);
    $(window).resize(function(){  
         $('.jhw-portlet-components').css('min-height',h);
    });
    // var $dpInput = $('.form-datetime').datetimepicker({
    //     format: 'yyyy-mm-dd hh:ii'
    //   });
    //   
    




    var show_count = 20;   //要显示的条数
    var count = 1;    //递增的开始值，这里是你的ID
    $(document).on('click','.comment-add',function(event){
        var length = $(".comment-edit").length;
        //alert(length);
        //alert(length);
        if (length < show_count)    //点击时候，如果当前的数字小于递增结束的条件
        {   var html =$(this).parents(".comment-edit").clone();
            html == $(html).find('.control-label').html('')
            console.log(html)
            //$(this).parents(".comment-edit").clone().appendTo(".jhw-info-body");   //在表格后面添加一行
            $(".comment-edit").parent().append(html)
            changeIndex();//更新行号
        }
    });
    $(document).on('click','.comment-subtract',function(event){
        var length = $(".comment-subtract").length;
        //alert(length);
        if (length <= 1) {
            alert("至少保留一行");
        } else {
            $(this).parent().parent().remove();//移除当前行
            changeIndex();
        }

    });
     function changeIndex() {
    var i = 1;
    $(".comment-edit").each(function () { //循环tab tbody下的tr
        $(this).attr('data-number',i++);//更新行号
        
    });
}
});


(function($){
  // 也可以在页面中引入 amazeui.datetimepicker.zh-CN.js
  $.fn.datetimepicker.dates['zh-CN'] = {
    days: ["星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六", "星期日"],
    daysShort: ["周日", "周一", "周二", "周三", "周四", "周五", "周六", "周日"],
    daysMin:  ["日", "一", "二", "三", "四", "五", "六", "日"],
    months: ["一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月"],
    monthsShort: ["一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月"],
    today: "今日",
    suffix: [],
    meridiem: ["上午", "下午"]
  };

  $('.form-datetime').datetimepicker({
    language:  'zh-CN',
    format: 'yyyy-mm-dd hh:ii'
  });
}(jQuery));

