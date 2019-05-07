<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
      <%@ page  isELIgnored = "false" %>
    <title>密保问题验证界面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script src="bootstrap-3.3.7-dist/js/jquery-3.3.1.js"></script>
	<link rel="stylesheet" type="text/css" href="bootstrap-3.3.7-dist/css/bootstrap.css" />
	<script src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
	<script type="text/javascript">
	$(document).click(function(){
	 $("#bt1").click(function(){
		  	 $("#from2").submit();
		  });
	});
	var curIndex = 0;
			//时间间隔(单位毫秒)，每秒钟显示一张，数组共有3张图片放在img文件夹下
			var timeInterval = 6000;
			
			                        //定义一个存放照片位置的数组，可以放任意个，在这里放3个
			var arr = new Array();
			arr[0] = "img/南门.jpg";
			arr[1] = "img/学校.jpg";
			arr[2] = "img/庆典.jpg";
			setInterval(changeImg, timeInterval);
			function changeImg() {
			if (curIndex == arr.length - 1) {
			curIndex = 0;
			} else {
			curIndex += 1;
			}
			
			                                  //设置body的背景图片
			document.body.style.backgroundImage = "URL("+arr[curIndex]+")";  //显示对应的图片
			}
	</script>
  </head>
  <style type="text/css">
	body{
    		background: url(img/南门.jpg) no-repeat;
 		 background-size: 100%;
		}
		</style >
  <body>
  <br><br><br><br><br><br><br><br>
     <form action="./update/updatePass.action" method="post" id="from2" name="from2">
     	<table class="table table-hover" style="width: 30%;border: blue solid 4px;" align="center" >
     	<tr><td>号：</td><td><input type="text"  name="user" readonly="readonly"  value="${sessionScope.ChangePassVO.user}" /></td></tr>
     	<tr><td>问题1：</td><td><input type="text" disabled="disabled" value="${sessionScope.ChangePassVO.one}"/></td></tr>
     	<tr><td>答案：</td><td><input type="text" name="one1" value="${requestScope.newUserVO.one1}" /></td></tr>
     	<tr><td>问题2：</td><td><input type="text" disabled="disabled" value="${sessionScope.ChangePassVO.two}"/></td></tr>
     	<tr><td>答案：</td><td><input type="text" name="two1" value="${requestScope.newUserVO.two1}" /></td></tr>
     	<tr><td>问题3：</td><td><input type="text" disabled="disabled" value="${sessionScope.ChangePassVO.three}"/></td></tr>
     	<tr><td>答案：</td><td><input type="text" name="three1" value="${requestScope.newUserVO.three1}" /></td></tr>
     	<tr><td>新密码：</td><td><input type="password" name="pass"/><span style="font-size: 10px;color: red;"> ${requestScope.errorMessageVO}</span></td></tr>
     	
     	</table>
     	</form>
     	
     	<div style="margin:0 auto;width:200px;">
     	<button class="btn btn-Info" id="bt1" style="width: 200px">更改密码</button>
     	 </div>
  </body>
</html>
