<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <%@ page  isELIgnored = "false" %>  
    <title>密码找回页面</title>
    
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
		$(document).ready(function(){
		
			$("#loginBtn").click(function(){					
			//data没有的话也可以运行，后台也能接收到，
			$.ajax({
				url:"./update/verify.action",
				type:"POST",
				dataType:"text",
				success:function(data){
				//不使用evaluation（）方法单独处理，jQuery已经帮助我们将数据封装成js对象了			
				if(data==$("#randCode").val()){	
			 			 $("#from1").submit();
				}else{
				 $("#codeImage").attr("src","./update/image.action?"+new Date);
					alert("验证码输入有误！");
				}
				}
				
			});
		  });
		 
		  $("#codeImage").click(function(){
		  //在？后加参数，就可以比较前面的和后面的是否一样了，不一样可以换
		  $(this).attr("src","./update/image.action?"+new Date);
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
	<style type="text/css">
	body{
    		background: url(img/南门.jpg) no-repeat;
 		 background-size: 100%;
		}
		tr{
		border: 1px solid red;
		}
	</style >
  </head>
  
  <body>
 	<br><br><br><br><br><br><br><br><br><br>
  <form action="./update/retrieve.action" method="post" id="from1" name="from1">
  	<table class="table table-hover " style="width: 30%;border: blue solid 4px;" align="center">
	  <tr >
	  	<td style="width: 10%">学号/教师号:</td><td style="width: 15%"><input class="text" type="text" name="user" /><span style="color: red;">${requestScope.errorMessageVO}</span></td>
	  </tr>
		
	     <tr>
	     <td>
	    验证码：
	    </td>
	    <td>
	    <input class="text" type="text" id="randCode" name="randCode"/>
	    <img title="看不清楚，再点击一次" src="./update/image.action" id="codeImage"/><br/>
	   
	   
	    </td>
	    
	    </tr>
    </table>
   
    </form>
    <div style="margin:0 auto;width:200px;">
     <input type="button" class="btn btn-Info" value="提交" id="loginBtn" style="width: 200px" />
    </div>
    
  </body>
</html>
