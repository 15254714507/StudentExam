<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
     <%@ page  isELIgnored = "false" %> 
    
    <title>学生考试系统</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	
	<link rel="stylesheet" href="css/reset1.css"> 
	<link rel="stylesheet" type="text/css" href="css/default1.css">
	<link rel="stylesheet" href="css/style1.css"> 
	<script src="js/modernizr.js"></script> 
	<script type="text/javascript" src="bootstrap-3.3.7-dist/js/jquery-3.3.1.js"></script>
	<script type="text/javascript">

			$(document).ready(function(){
				
			
				$("#PeopleMesg").click(function(){
					$.ajax({
						url:"./jumpPersonal.action",
						type:"POST",
						dataType:"text",
						success:function(msg){
						//列表数据页面渲染
						$("#courseList").html(msg);
						}
					});
				});
				$("#one").click(function(){
					$.ajax({
						url:"./comingSoon.action",
						type:"POST",
						dataType:"text",
						success:function(msg){
						//列表数据页面渲染
						$("#courseList").html(msg);
						}
					});
				});
				
				
				
				$("#two").click(function(){
					$.ajax({
						url:"./underwayExam.action",
						type:"POST",
						dataType:"text",
						success:function(msg){
						//列表数据页面渲染
						$("#courseList").html(msg);
						}
					});
				});
				$("#three").click(function(){
					$.ajax({
						url:"./timePassed.action",
						type:"POST",
						dataType:"text",
						success:function(msg){
						//列表数据页面渲染
						$("#courseList").html(msg);
						}
					});
				});
				$("#four").click(function(){
					$.ajax({
						url:"./studentAllGrade.action",
						type:"POST",
						dataType:"text",
						success:function(msg){
						//列表数据页面渲染
						$("#courseList").html(msg);
						}
					});
				});
				$("#five").click(function(){
					$.ajax({
						url:"./failGrade.action",
						type:"POST",
						dataType:"text",
						success:function(msg){
						//列表数据页面渲染
						$("#courseList").html(msg);
						}
					});
				});
				$("#six").click(function(){
					$.ajax({
						url:"./passGrade.action",
						type:"POST",
						dataType:"text",
						success:function(msg){
						//列表数据页面渲染
						$("#courseList").html(msg);
						}
					});
				});
				
			});
	</script>
	
  </head>
  
  <body>
    <header class="cd-main-header" >
		<a href="#0" ><img src="img/school2.jpg" style="width: 200px;height: 55px;" alt="Logo"></a>
		<nav class="cd-nav">
			<ul class="cd-top-nav" >
				<li class="has-children account" >
					<a href="#0" style="width: 144px;" id="img">
						<img src="${sessionScope.userImageVO}" alt="avatar" style="left: 1.0em;width: 30px;height: 30px;">
						<span style="color: white;">${sessionScope.userNameVO}</span>
					</a>
					<ul >
						<li><a href="#0" id="PeopleMesg" >修改个人信息</a></li>
						<li><a href="#0" >问题反馈</a></li>
						<li><a href="./exitNumber.action">退出当前账户</a></li>
						
					</ul>
				</li>
			</ul>
		</nav>
	</header> 

	<main class="cd-main-content">
		<nav class="cd-side-nav" >
			<ul>
				<li class="cd-label" style="font-size: 20px;font-weight: bold;">学生考试信息</li>
				<li class="has-children overview active">
					<a href="#0">科目考试安排</a>
					<ul>
						<li><a href="#0" id="one">即将考试安排</a></li>
						<li><a href="#0" id="two">正在进行考试</a></li>
						<li><a href="#0" id="three">考试时间已过</a></li>
					</ul>
				</li>
				<li class="has-children notifications active">
					<a href="#0">查看考试成绩</a>
					
					<ul>
						<li><a href="#0" id="four">全部成绩</a></li>
						<li><a href="#0" id="five">不及格成绩</a></li>
						<li><a href="#0" id="six">及格成绩</a></li>
					</ul>
				</li>

				<li class="has-children comments">
					<a href="#0" id ="seven">查看考试答案</a>
				</li>
			</ul>

			
			
		</nav>

		<div class="content-wrapper">
			<header class="htmleaf-header">
				<div id="courseList">
				
				
				</div>
				
			</header>
			
		</div> 
	</main> 
	
	
	<script src="js/jquery.menu-aim.js"></script>
	<script src="js/main.js"></script> <!-- Resource jQuery -->
  </body>
</html>
