/**
 * 
 */
$(function() {
	
});

/**
 * 分页
 */
function paging(pageNum, originalPage){
	var path = $("#path").val();
	$.ajax({
		type: "post",
        url: path+"/user_list/paging",
        data: {"pageNum":pageNum, "originalPage":originalPage},	
        async:false,	//同步请求
        success: function (data) {
        	$(".user-list-form").html("");
        	$(".user-list-form").html(data);
        },
        error: function (data) {
        	alert("加载数据失败！");
        }	
	});
	
}

/**
 * 前往添加用户页面
 */
function toAddUserPage() {
	var path = $("#path").val();
	var tokenStr = localStorage.token;
	$.ajax({
		type : "POST",
		url : path + "/user_list/to_add_user_page",
		data : {
			"token" : tokenStr
		},
		async : false,
		success : function(data) {
			$(".jhw-portlet-components").html("");
			$(".jhw-portlet-components").html(data);
		},
		error : function(XMLHttpRequest, textStatus, errorThrown) {
			alert("前往登录页面操作异常！");
		}
	});
}

/**
 * 前往用户信息查看页面
 * @param userId
 */
function toUserInfoCheckPage(userId){
	var path = $("#path").val();
	var tokenStr = localStorage.token;
	$.ajax({
		type : "POST",
		url : path + "/user_list/to_user_info_check_page",
		data : {"token" : tokenStr, "userId" : userId},
		async : false,
		success : function(data) {
			$(".jhw-portlet-components").html("");
			$(".jhw-portlet-components").html(data);
		},
		error : function(XMLHttpRequest, textStatus, errorThrown) {
			alert("前往用户信息查看页面异常！");
//			alert(XMLHttpRequest.status);
//        	alert(XMLHttpRequest.readyState);
//        	alert(textStatus);
//        	alert(errorThrown);
		}
	});
}

/**
 * 前往用户信息编辑页面
 * @param userId
 */
function toUserInfoEditPage(userId){
	var path = $("#path").val();
	var tokenStr = localStorage.token;
	$.ajax({
		type : "POST",
		url : path + "/user_list/to_user_info_edit_page",
		data : {"token" : tokenStr, "userId" : userId},
		async : false,
		dataType:"JSON",
		success : function(data) {
			if(data.isSuccess == 1 && data.isOverdue == 1){
				doTransferToUserEdit(data.urlStr, JSON.stringify(data.resultObj));
			}
			if(data.isSuccess == 0){
				alert("处理失败");
			}
			if(data.isOverdue == 0){
				alert("登录已过期");
				localStorage.token = "";
				$(".jhw-portlet-components").html(data.resultObj);
			}
		},
		error : function(XMLHttpRequest, textStatus, errorThrown) {
//			alert("前往用户信息编辑页面异常！");
			alert(XMLHttpRequest.status);
        	alert(XMLHttpRequest.readyState);
        	alert(textStatus);
        	alert(errorThrown);
		}
	});
}

/**
 * 页面中转到用户编辑页面
 * @param urlStr
 * @param resultObj
 */
function doTransferToUserEdit(urlStr, resultObj){
	var path = $("#path").val();
	$.ajax({
		type : "POST",
		url : path + "/util/transfer_2_useredit",
		data : {"urlStr" : urlStr, "resultObj" : resultObj},
		async : true,
		success : function(data) {
			if(data!=null){
				$(".jhw-portlet-components").html(data);
			}else{
				alert("页面中转失败");
			}
		},
		error : function(XMLHttpRequest, textStatus, errorThrown) {
			alert(XMLHttpRequest.status);
			//错误提醒
		}
	});
}

/**
 * 删除用户
 * @param index
 */
function doDeleteUser(userId){
	var path = $("#path").val();
	var tokenStr = localStorage.token;
	$('#jhw-delete-confirm').modal({
		relatedTarget : this,
		onConfirm : function(options) {
			$.ajax({
				type : "POST",
				url : path + "/user_list/deluser",
				data : {"token" : tokenStr ,"userId" : userId},
				async : false,
				dataType:"json",
				success : function(data) {
					if(data == null){
		            	alert("删除失败！");
		            }
		        	if(data.isSuccess == 1){
		        		alert("success");
		        		if(data.isOverdue == 1){
		        			$("#userLlist_"+userId).remove();
		        			transferFunction(data.urlStr, data.resultObj);
		        		}
		        	}else{
		        		alert("操作失败");
		        	}
				},
				error : function(XMLHttpRequest, textStatus, errorThrown) {
					alert("操作异常！");
//					alert(XMLHttpRequest.status);
//		        	alert(XMLHttpRequest.readyState);
//		        	alert(textStatus);
//		        	alert(errorThrown);
				}
			});	
		},
		onCancel : function() {
		}
	});
}

/**
 * 用户信息增删改后回到列表首页
 * @param path
 * @param paramJson
 */
function transferFunction(path, paramJson){
	var hostPath = localStorage.hostPath;
//	alert(hostPath+" --- "+paramJson);
	$.ajax({
		type : "POST",
		url : hostPath + path,
		data : paramJson,
		async : true,
		success : function(data) {
			$(".jhw-portlet-components").html("");
        	$(".jhw-portlet-components").html(data);
		},
		error : function(XMLHttpRequest, textStatus, errorThrown) {
			alert(XMLHttpRequest.status);
			//错误提醒
		}
	});
}

/**
 * 获取微信token
 */
function toGetWeiXinToken(){
	$.ajax({
		type : "GET",
		url : "https://api.weixin.qq.com/cgi-bin/token",
		data : {"grant_type":"client_credential","appid":"wx6b196164128e8a90","secret":"973ede448dc2ec148a439f57498ae312"},
		async : true,
		success : function(data) {
			alert("access_token获取结果："+data);
			$("#tokenVal").html("");
        	$("#tokenVal").html(data);
		},
		error : function(XMLHttpRequest, textStatus, errorThrown) {
//			alert(XMLHttpRequest.status);
//			alert(textStatus);
        	alert(errorThrown);
			//错误提醒
		}
	});
}

