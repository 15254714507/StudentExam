<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
 
    
    <title>My JSP 'TopicAnswer.jsp' starting page</title>
    
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
	<script src="bootstrap-3.3.7-dist/js/bootstrap.js"></script>
  </head>
  
  <body >
  <div class="container-fluid">
    <div class=".col-lg-10 col-lg-offset-5"><h1>考试答案</h1></div>
   
   <table class="table table-hover table-striped">
    <c:forEach var="item" items="${TopicAnswer}" varStatus="status">
    	
    		<tr class="danger"><th><h4>${status.count}、${item.topic}（4分）</h4></th></tr>
    		<tr class="info">
    			<td>${item.answ}</td>
    		</tr>
    		
    	
    	
    	
    </c:forEach>
    </table>
   
    
    </div>
    <br/><br/>
  
  </body>
</html>
