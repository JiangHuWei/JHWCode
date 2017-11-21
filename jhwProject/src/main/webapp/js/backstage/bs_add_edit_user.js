/**
 * 
 */
$(document).ready(function() {
	
	
//	$('.new-contentarea').on('click', function() {
//		alert(0);
//	})
	var options = {
		thumbBox : '.thumbBox',
		spinner : '.spinner',
		imgSrc : ''
	}
	var cropper = $('.imageBox').cropbox(options);
	$('#upload-file').on('change', function() {
		var reader = new FileReader();
		reader.onload = function(e) {
			options.imgSrc = e.target.result;
			cropper = $('.imageBox').cropbox(options);
		}
		reader.readAsDataURL(this.files[0]);

	})
	$('#btnCrop').on('click', function() {
		var img = cropper.getDataURL();
		$("#headimgUrl").val(img);
		$(".am-circle.via").attr('src', img);
		$(".am-dimmer").removeClass('am-active').hide();
		$("#update-imgBox").removeClass('am-modal-active').hide();
	})
	$('#upload-file').on('change', function() {
		$(".am-dimmer").addClass('am-active').show();
		$("#update-imgBox").addClass('am-modal-active').show();
	})
	getSelectVal();
});

/**
 * 新增用户
 */
function addUser() {
	var path = $("#path").val()+"/user_list/addUser";
	var tokenStr = localStorage.token;
	$("#token").val(tokenStr);
	$.ajax({
		type: "POST",
        url: path,
        data: $("#addAndeditForm").serialize(),
        async:false,	//同步请求
        success: function (data) {
//        	alert(data);
        	$(".jhw-portlet-components").html("");
        	$(".jhw-portlet-components").html(data);
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
        	alert("处理失败");
//        	alert(XMLHttpRequest.status);
//        	alert(XMLHttpRequest.readyState);
//        	alert(textStatus);
//        	alert(errorThrown);
        }	
	});
}

/**
 * 用户信息增删改后回到列表
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

function getSelectVal() {
	var smokeVal = $("#smokeSelect>label>input[checked='checked']").val();
	$("#smoke").val(smokeVal);
	var drinkeVal = $("#drinkSelect>label>input[checked='checked']").val();
	$("#drink").val(drinkeVal);
	var sexVal = $("#sexSelect>label>input[checked='checked']").val();
	$("#sex").val(sexVal);
	var authenticationVal = $("#authenticationSelect:has(option[selected='selected'])").val();
	$("#eduAuthentication").val(authenticationVal); 
	var birthday = $("#birthdaySelect").val();
	$("#birthdayVal").val(birthday);
	
}