/*
* @Author: TAO
* @Date:   2017-09-21 17:35:54
* @Last Modified by:   TAO
* @Last Modified time: 2017-09-26 16:16:07
*/

// 统一管理JS公共文件
(function() {
	var jsList = [
		"../jquery.min.js",
		"../amazeui.min.js",
        "../amazeui.datetimepicker.min.js",
		"../echarts.min.js",
		"../iscroll.js",
		"../cropbox.js",
		"../app.js",
		"../jhw.js"
    
	];
  var obj =  {};
  /**
   * 动态加载脚本函数
   * @param url 要加载的脚本路径
   * @param callback  回调函数
   */
  obj.loadScript = function(url,callback){
    var doc = document;
    var script = doc.createElement("script");
    script.type = "text/javascript";
    if(script.readyState){  //IE
      script.onreadystatechange = function(){
        if(script.readyState=="load"||script.readyState=="complete"){
          script.onreadystatechange = null;
          callback();
        }
      };
    }else{
      script.onload = function(){
        callback();
      };
    }
    script.src = url;
    doc.getElementsByTagName("body")[0].appendChild(script);
  };

  function callback(){
      jsList.length?obj.loadScript(jsList.shift(),callback)
        :(function(){time = null})();
  }
  var time = setTimeout(function(){obj.loadScript(jsList.shift(),callback)},25);
})();