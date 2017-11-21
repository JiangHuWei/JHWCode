/**
 * 后台登录
 */
var path;

$(document).ready(function(){
//	alert("token登录");
	path = $("#path").val();
	var token = localStorage.token;
	if(token!=null && token.length>0){
//		alert("token:11221 "+token);
		$.ajax({
	        type: "POST",
	        url: path+"/backstage/tologinpage",
	        data: {"token":token},			
	        dataType: "json",
	        async:false,	//同步请求
	        success: function (data) {
//	        	alert("页面初始化事件处理：  "+data.isSuccess);
	            if(data == null){
	        		return;
	            }
	        	if(data.isSuccess== 1){
	        		$(".error_message").css("display","hidden");
	        		//首页重定向
	        		window.location.href = path + "/backstage/toindex?token="+token;
	        	}else{
	        		$(".error_message").css("display","block");
	        		$(".error_msg").text(data.message);
	        		return;
	        	}
	        },
	        error: function (data) {
	        	alert("000");
	        	$(".error_message").css("display","block");
	        	$(".error_msg").text("登录异常");
	        }
	    });
	}

	
});

/**
 * 账号密码登录
 */
function doLoginBypwd(){
	path = $("#path").val();
	//存储访问路径
	localStorage.hostPath = path;
//	alert(localStorage.hostPath);
	$.ajax({
        type: "POST",
        url: path+"/backstage/login_by_pwd",
        data: $("#login_form").serialize(),			//表单序列化提交
        dataType: "json",
        async:false,	//同步请求
        success: function (data) {
//        	alert("success");
            if(data == null){
            	$(".error_message").css("display","block");
            	$(".error_msg").text("登录异常");
            }
        	if(data.isSuccess== 1){
        		$(".error_message").css("display","hidden");
        		localStorage.token=data.resultObj;
//        		alert("重定向地址:  "+redirctPath);
        		window.location = path + "/backstage/toindex?token="+data.resultObj;
        	}else{
//        		alert("success == 0  "+data.message);
        		$(".error_message").css("display","block");
        		$(".error_msg").text(data.message);
        	}
        },
        error: function (XMLHttpRequest,textStatus,errorThrown) {
//        	alert("登录异常");
        	$(".error_message").css("display","block");
        	$(".error_msg").text("登录异常");
        	/*弹出jqXHR对象的信息*/
//            alert(jqXHR.responseText);
//            alert(jqXHR.status);
//            alert(jqXHR.readyState);
//            alert(jqXHR.statusText);
            /*弹出其他两个参数的信息*/
        	if(textStatus == 0){
        		alert("登录异常,请重新登录");
        	}
            alert(textStatus);
//            alert(errorThrown);
        }
    });
}




