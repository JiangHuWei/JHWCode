/**
 * 拼桌管理
 */
$(document).ready(function(){
	
	
	
});

/**
 * 拼桌分页
 * @param pageNum
 * @param originalPage
 */
function paging(pageNum, originalPage){
	var path = $("#path").val();
	var tokenStr = localStorage.token;
	$.ajax({
		type: "post",
        url: path+"/table/tablepaging",
        data: {"token":tokenStr, "pageNum":pageNum, "originalPage":originalPage,"isInitialLoad":"0"},
        async:false,	//同步请求
        success: function (data) {
        	$(".table-list-form").html("");
        	$(".table-list-form").html(data);
        	var tables = data.tables;
        	for(var i=0;i<tables.size(); i++){
        		alert(tables[i]);
        	}
        },
        error: function (data) {
        	alert("加载数据失败！");
        }	
	});
}

function toAddPage(){
	var path = $("#path").val();
	var tokenStr = localStorage.token;
	$.ajax({
		type: "post",
        url: path+"/table/toaddpage",
        data: {"token":tokenStr},
        async:false,	//同步请求
        success: function (data) {
        	$(".jhw-content-wrapper").html("");
        	$(".jhw-content-wrapper").html(data);
        },
        error: function (data) {
        	alert("加载数据失败！");
        }	
	});
}

/**
 * 添加拼桌
 */
function submitTable(){
	var path = $("#path").val();
	var tokenStr = localStorage.token;
	$("#tokenVal").val(tokenStr);
	//选择设置拼桌发起人
	var initiator = $(".select_initiator option:selected").val();
	$("#initiatorId").val(initiator);
	//选择餐厅
	var restaurant = $(".select_restaurant option:selected").val();
	$("#restaurantId").val(restaurant);
//	alert("参与人："+participate);
	$.ajax({
		type: "post",
        url: path+"/table/add_table",
        data: $("#submit_table").serialize(),
        async:false,	//同步请求
        success: function (data) {
        	alert("data.isOverdue："+data.isOverdue+"  ---  data.isSuccess："+data.isSuccess);
        	if (data!=null && data.isOverdue == 1 && data.isSuccess == 1) {
				//这是个神奇的方法啊
				$(".jhw-content-wrapper").load(path+data.urlStr,{"token":tokenStr},function(data){
					alert("完成拼桌"+data);
				});
//				window.location = path+data.urlStr+"?token="+tokenStr;
			} else if(data!=null && data.isOverdue == 0){
				windwo.location = path+data.urlStr;
				alert(data.message);
			}else {
				alert(data.message);
			}
        },
        error: function (data) {
        	alert("加载数据失败！");
        }	
	});
}

/**
 * 筛选出选中的参加饭局人id
 */
function changeParticipate(){
	$("#participateInput").html("");
	var participate = ""+$(".participate_people").val();
	var participateArray = new Array();
	participateArray  = participate.split(",");
	$("#participateInput").css("visibility","hidden");
	for(var i=0; i<participateArray.length; i++){
		$("#participateInput").append("<input name='userAttentPoJo["+i+"].userId' value='"+participateArray[i]+"'/>");
	}
}

function hasFirstPage(){
	alert("已经是第一页了");
}

function hasNotMorePage(){
	alert("已经是最后一页了");
}

/**
 * 查看拼桌详情页面
 */
function toDetailPage(tableId){
	var path = $("#path").val();
	var tokenStr = localStorage.token;
	
	$.ajax({
		type: "post",
        url: path+"/table/table_detail",
        data: {"token":tokenStr, "tableId":tableId},
        async:false,	//同步请求
        success: function (data) {
        	if(data == null){			//登录失效
        		alert("处理失败");
        	}
        	if(data.isOverdue == 0){	//登录失效
        		alert("登录失效");
        		localStorage.token = "";
        		location.href = path + "/jsp/backstage/login.jsp";
        	}
        	if(data.isSuccess == 0){	//处理失败 
        		alert(data.message);
        	}else{
        		$(".jhw-content-wrapper").html(data);
        	}
        },
        error : function(XMLHttpRequest, textStatus, errorThrown) {
        	alert("加载数据失败！");
//			alert(XMLHttpRequest.status);
//        	alert(XMLHttpRequest.readyState);
//        	alert(textStatus);
//        	alert(errorThrown);
		}
	});
}

/**
 * 删除table
 * @param ttid
 */
function toDelTable(ttid){
	var path = $("#path").val();
	var tokenStr = localStorage.token;
	alert("您即将删除拼桌！");
	$.ajax({
		type: "post",
        url: path+"/table/del_table",
        data: {"token":tokenStr, "tableId":ttid},
        async:false,	//同步请求
        success: function (data) {
        	if(data == null){			//登录失效
        		alert("处理失败");
        	}
        	if(data.isOverdue == 0){	//登录失效
        		alert("登录失效");
        		localStorage.token = "";
        		location.href = path + "/jsp/backstage/login.jsp";
        	}
        	if(data.isSuccess == 0){	//处理失败 
        		alert(data.message);
        	}else{
        		$(".jhw-content-wrapper").html(data);
        	}
        },
        error : function(XMLHttpRequest, textStatus, errorThrown) {
        	alert("加载数据失败！");
//			alert(XMLHttpRequest.status);
//        	alert(XMLHttpRequest.readyState);
//        	alert(textStatus);
//        	alert(errorThrown);
		}
	});
}

/**
 * 前往拼桌编辑页面
 * @param ttid
 */
function toEditPage(ttid){
	var path = $("#path").val();
	var tokenStr = localStorage.token;
	$.ajax({
		type: "post",
        url: path+"/table/to_editpage",
        data: {"token":tokenStr, "tableId":ttid},
        async:false,	//同步请求
        success: function (data) {
//        	alert("isSuccess："+data.isSuccess+" -- "+data.isOverdue)
        	if(data == null){			//登录失效
        		alert("处理失败");
        	}
        	if(data.isOverdue == 0){	//登录失效
        		alert("登录失效");
        		localStorage.token = "";
        		location.href = path + "/jsp/backstage/login.jsp";
        	}
        	if(data.isSuccess == 0){	//处理失败 
        		alert(data.message);
        	}else{
        		$(".jhw-content-wrapper").html(data);
        	}
        },
        error : function(XMLHttpRequest, textStatus, errorThrown) {
        	alert("加载数据失败！");
//			alert(XMLHttpRequest.status);
//        	alert(XMLHttpRequest.readyState);
//        	alert(textStatus);
//        	alert(errorThrown);
		}
	});
}

/**
 * 提交更新拼桌
 * $(".select_initiator option:selected").val();
 */
function submitEditTable(){
	var path = $("#path").val();
	var tokenStr = localStorage.token;
	$("#tokenVal").val(tokenStr);
	changeEditTableParticipate();	//获取初始参加饭局人
	$("#edit_initiatorId").val($(".edit_initiator option:selected").val());	//发起人
	$("#edit_restaurantId").val($(".edit_restaurant option:selected").val());	//餐厅
//	alert("更新拼桌："+path+" -- "+tokenStr);
	$.ajax({
		type: "post",
        url: path+"/table/update_table",
        data: $("#submit_edit_table").serialize(),
        async:false,	//同步请求
        success: function (data) {
        	alert("isSuccess："+data.isSuccess+" -- "+data.isOverdue)
        	if(data == null){			//登录失效
        		alert("处理失败");
        	}
        	if(data.isOverdue == 0){	//登录失效
        		alert("登录失效");
        		localStorage.token = "";
        		window.location.href = path + "/jsp/backstage/login.jsp";
        	}
        	if(data.isSuccess == 0){	//处理失败 
        		alert(data.message);
        	}else{		//更新成功
        		//跳转到拼桌列表页面
//        		$(".jhw-content-wrapper").html(data);
        	}
        },
        error : function(XMLHttpRequest, textStatus, errorThrown) {
//        	alert("加载数据失败！");
			alert(XMLHttpRequest.status);
        	alert(XMLHttpRequest.readyState);
        	alert(textStatus);
        	alert(errorThrown);
		}
	});
}

/**
 * 更新拼桌中筛选出选中的参加饭局人id
 */
function changeEditTableParticipate(){
	$("#participateInput").html("");
	var participate = ""+$(".participate_people").val();
	var participateArray = new Array();
	participateArray  = participate.split(",");
	$("#participateInput").css("visibility","hidden");
	for(var i=0; i<participateArray.length; i++){
		$("#participateInput").append("<input name='tablePoJo.userAttentPoJo["+i+"].userId' value='"+participateArray[i]+"'/>");
	}
}




