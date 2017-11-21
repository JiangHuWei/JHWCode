/**
 * 
 */

/**
 * 页面刷新检查token有效状态
 */
function checkTokenState(){
	var path = $("#path").val();
	var tokenStr = localStorage.token;
//	alert("令牌："+tokenStr);
	$.ajax({
        type: "post",
        url: path+"/bs_index/refresh",
        data: {"token":tokenStr},	
        async:false,	//同步请求
        success: function (data) {
//        	alert("令牌状态"+data);
            if(data == "invalid"){	
            	alert("令牌失效,请重新登录");
            	location.href = path + "/jsp/backstage/login.jsp";
            }
        },
        error: function (data) {
        	alert("令牌失效,请重新登录");
        	location.href = path + "/jsp/backstage/login.jsp";
        }
    });
}

function doExit(){
	var path = $("#path").val();
	localStorage.token = "";
	location.href = path + "/jsp/backstage/login.jsp";
}

/**
 * 菜单跳转控制
 * @param menuId 菜单id
 */
function menuSkip(url){
	var path = $("#path").val();
	var childMenuUrl = path+url;
	var tokenStr = localStorage.token;
	$.ajax({
        type: "post",
        url: childMenuUrl,
        data: {"token":tokenStr},
        async:false,	//同步请求
        success: function (data) {
        	$(".jhw-content-wrapper").html(data);
        },
        error: function (XMLHttpRequest,textStatus,errorThrown) {
        	alert("error"+textStatus);
        }
    });
	
}