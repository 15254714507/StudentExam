<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  
   <%@ page  isELIgnored = "false" %>  
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>考试系统</title>
	<link rel="stylesheet" type="text/css" href="css/normalize.css" />
	<link rel="stylesheet" type="text/css" href="css/default.css">
	<script src='js/prefixfree.min.js'></script>
	<link rel="stylesheet" type="text/css" href="css/styles.css">
	   
	
	<script src="bootstrap-3.3.7-dist/js/jquery-3.3.1.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			$("#LoginBtn").click(function(){	
				
			 			 $("#from1").submit();
						
				});
				});			   
	</script>
</head>
<body>
<div id="logo"> 
  <h1 class="hogo"><i> 考试登录页面</i></h1>
</div> 
<section class="stark-login">
  <form action="./login.action" method="post">	
    <div id="fade-box">
      <input type="text" name="user" id="username" placeholder="学号/教师号" required>
        <input type="password" name="pass" id="password" placeholder="密码" required style="margin: 20px auto -6px;">
		<br/><br/>
          <button style="margin: 8px auto;"id="LoginBtn">登录</button>
          <div style="color: red;">${requestScope.errorMessageVO}</div>
          <br/>
          <div style="text-align: right;">
           <span style="color:white;">由孔超进行设计维护</span><a href="./update/forwardControl.action" style="color: red;">找回密码</a>
          </div>                  
        </div>
      </form>
      <div class="hexagons">
        <span>&#x2B22;</span>
        <span>&#x2B22;</span>
        <span>&#x2B22;</span>
        <span>&#x2B22;</span>
        <span>&#x2B22;</span>
        <span>&#x2B22;</span>
        <span>&#x2B22;</span>
        <span>&#x2B22;</span>
        <span>&#x2B22;</span>
        <span>&#x2B22;</span>
        <span>&#x2B22;</span>
        <span>&#x2B22;</span>
        <br>
          <span>&#x2B22;</span>
          <span>&#x2B22;</span>
          <span>&#x2B22;</span>
          <span>&#x2B22;</span>
          <span>&#x2B22;</span>
          <span>&#x2B22;</span>
          <span>&#x2B22;</span>
          <span>&#x2B22;</span>
          <span>&#x2B22;</span>
          <span>&#x2B22;</span>
          <span>&#x2B22;</span>
          <br>
            <span>&#x2B22;</span>
            <span>&#x2B22;</span>
            <span>&#x2B22;</span>
            <span>&#x2B22;</span> 
            <span>&#x2B22;</span>
            <span>&#x2B22;</span>
            <span>&#x2B22;</span>
            <span>&#x2B22;</span>
            <span>&#x2B22;</span>
            <span>&#x2B22;</span>
            <span>&#x2B22;</span>
            <span>&#x2B22;</span>
            
            <br>
              <span>&#x2B22;</span>
              <span>&#x2B22;</span>
              <span>&#x2B22;</span>
              <span>&#x2B22;</span>
              <span>&#x2B22;</span>
              <span>&#x2B22;</span>
              <span>&#x2B22;</span>
              <span>&#x2B22;</span>
              <span>&#x2B22;</span>
              <span>&#x2B22;</span>
              <span>&#x2B22;</span>
              <br>
                <span>&#x2B22;</span>
                <span>&#x2B22;</span>
                <span>&#x2B22;</span>
                <span>&#x2B22;</span>
                <span>&#x2B22;</span>
                <span>&#x2B22;</span>
                <span>&#x2B22;</span>
                <span>&#x2B22;</span>
                <span>&#x2B22;</span>
                <span>&#x2B22;</span>
                <span>&#x2B22;</span>
                <span>&#x2B22;</span>
              </div>      
        </section> 
    
        <div id="circle1">
          <div id="inner-cirlce1">
            <h2> </h2>
          </div>
        </div>
    <ul>
      <li></li>
      <li></li>
      <li></li>
      <li></li>
      <li></li>
    </ul>
	<header class="htmleaf-header">
			<h1>这个界面是用于学生或老师登录考试系统用的 </h1>
			<div class="htmleaf-links">
				<a class="htmleaf-icon icon-htmleaf-home-outline" href="http://www.sdili.edu.cn/" title="返回学校官网" target="_blank"></a>
				<a class="htmleaf-icon icon-htmleaf-arrow-forward-outline" href="http://www.sdili.edu.cn/5141/list.htm" title="返回上一页" target="_blank"></a>
			</div>
		</header>
</body>
</html>
