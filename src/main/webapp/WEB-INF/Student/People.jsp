<%@ page language="java" import="java.util.*"   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

    
    <title>学生个人信息</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script src="bootstrap-3.3.7-dist/js/jquery-3.3.1.js"></script>
	 <link rel="stylesheet" type="text/css" href="css/demo.css" />
      <link rel="stylesheet" type="text/css" href="css/style2.css" />
	<script type="text/javascript" src="js/modernizr.custom.04022.js"></script>
	<script type="text/javascript">
	
			// 选择图片显示
			function imgChange(obj) {
			//获取点击的文本框
			var file =document.getElementById("file");
			var imgUrl =window.URL.createObjectURL(file.files[0]);
			var img =document.getElementById('imghead');
			img.setAttribute('src',imgUrl); // 修改img标签src属性值
			};

	
	</script>
  </head>
  
  <body>
 	
 		<div>
 			<section class="af-wrapper">
	            <h3 style="text-align: left;">学生个人信息</h3>
		        <br/>
				<input id="af-showreq" class="af-show-input" type="checkbox" name="showreq" />
				<label for="af-showreq" class="af-show">允许修改信息</label>
				
				<form action="./changMesg.action" class="af-form" id="af-form" novalidate method="post" enctype="multipart/form-data">
					<div >
   					
   					<img  id="imghead" src="${sessionScope.userImage}"  width="150px" height="150px" />
   					<input type="file"name="file"id="file" accept="image/*" onchange="imgChange(this);"/> 
   					
   					</div>
					<div class="af-outer">
						<div class="af-inner">
							<label for="input-user">账号</label>
							<input type="text" name="user" id="input-user" value="${sessionScope.UserVO.user}" readonly="readonly" >
						</div>
					</div>
				
					<div class="af-outer ">
						<div class="af-inner">
							<label for="input-pro">专业</label>
							<input type="text" name="professional" id="input-pro" value="${sessionScope.UserVO.professional}" readonly="readonly" >
						</div>
					</div>
					
					<div class="af-outer ">
						<div class="af-inner">
						  <label for="input-name">姓名</label>
						  <input type="text" name="name" id="input-name" value="${sessionScope.UserVO.name}" readonly="readonly" >
						</div>
					</div>
					
					<div class="af-outer">
						<div class="af-inner">
							<label for="input-age">年龄</label>
							<input type="text" name="age" id="input-age" value="${sessionScope.UserVO.age}" readonly="readonly" >
						</div>
					</div>
					
					<div class="af-outer">
						<div class="af-inner">
						  <label for="input-identity">身份证号</label>
						  <input type="text" name="identity" id="input-identity" value="${sessionScope.UserVO.identity}" readonly="readonly" >
						</div>
					</div>
					
					<div class="af-outer af-required">
						<div class="af-inner">
						  <label for="input-one">问题一</label>
						  <input type="text" name="one" id="input-one" value="${sessionScope.UserVO.one}"  required>
						</div>
					</div>
					
					<div class="af-outer af-required">
						<div class="af-inner">
						  <label for="input-one1">答案一</label>
						  <input type="text" name="one1" id="input-one1" value="${sessionScope.UserVO.one1}"  required>
						</div>
					</div>
					
					<div class="af-outer af-required">
						<div class="af-inner">
						  <label for="input-two">问题二</label>
						  <input type="text" name="two" id="input-two"  value="${sessionScope.UserVO.two}" required>
						</div>
					</div>
					<div class="af-outer af-required">
						<div class="af-inner">
						  <label for="input-two1">答案二</label>
						  <input type="text" name="two1" id="input-two1" value="${sessionScope.UserVO.two1}" required>
						</div>
					</div>
					<div class="af-outer af-required">
						<div class="af-inner">
						  <label for="input-three">问题三</label>
						  <input type="text" name="three" id="input-three" value="${sessionScope.UserVO.three}" required>
						</div>
					</div>
					<div class="af-outer af-required">
						<div class="af-inner">
						  <label for="input-three1">答案三</label>
						  <input type="text" name="three1" id="input-three1"  value="${sessionScope.UserVO.three1}" required>
						</div>
					</div>
					<input type="submit" value="确认修改" /> 
					
				</form>
			</section>
 		</div>
  </body>
</html>
