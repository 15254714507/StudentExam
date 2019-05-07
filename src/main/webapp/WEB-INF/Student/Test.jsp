<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
 
    
    <title></title>
    
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
	<script type="text/javascript">
		 $(document).ready(function(){
		 		 	var a = $('.a').html();
					timeout(a);
			
				function timeout(obj){
				if(obj<10){
		
				}else{
					var times = obj*60; // 60秒
					countTime = setInterval(function() {
						times = --times < 0 ? 0 : times;
						var hh =Math.floor(times / 3600).toString();
						if(hh.length <= 1) {
							hh = "0" + hh;
						}
						
						var mm = Math.floor((times / 60)%60 ).toString();
						if(mm.length <= 1) {
							mm = "0" + mm;
						}
						var ms = Math.floor(times % 60).toString();
						if(ms.length <= 1) {
							ms = "0" + ms;
						}
						if(times == 0) {
							//时间到，提交试卷
							alert("提交试卷成功，稍后部分成绩可以查询");
							clearInterval(countTime);
							$("#myform").submit();
						}
						// 获取分钟、毫秒数
						$(".h").html(hh);
						$(".a").html(mm);
						$(".b").html(ms);
					}, 1000);
				}
		
			    
			}
		 
		   			//没到时间，主动提交试卷
                    $("#btn").click(function(){  
                   		alert("提交试卷成功，稍后部分成绩可以查询");
                       $("#myform").submit();
                       
                    });
                     
                });  
		
	</script>
  </head>
  
  <body style="height: 500px">
  	<div class="container-fluid">
    <div align="center"><h1>齐鲁工业大学${sessionScope.examQuestion.subject}考试</h1>
     	<div style="background-color:yellow; color: red;display: inline-block;" align="right" >距离考试结束还剩<span class="h">00</span>：<span class="a">120</span>：<span class="b">00</span></div>
    </div>
   
			
	
    <div><h3>一、选择题（40分）</h3></div>
    <form action="./submitTest.action" id="myform" method="post">
    <c:forEach var="item" items="${sessionScope.examQuestion.choiceQuestion}" varStatus="status">
    	<div><h4>${status.count}、${item.topicOne}（4分）</h4></div>
    	<div>
    		<input type="radio" name="t${status.count}"  value="A"/>A、${item.oneA}
    		<input type="radio" name="t${status.count}" value="B"/>B、${item.oneB}	
    		<input type="radio" name="t${status.count}" value="C"/>C、${item.oneC}
    		<input type="radio" name="t${status.count}" value="D"/>D、${item.oneD}
    	</div>
    	<br/>
    </c:forEach>
    <div><h3>二、简答题（60分）</h3></div>
    <c:forEach var="item" items="${sessionScope.examQuestion.shortAnswerQuestion}"  varStatus="status">
    	<div><h4>${status.count+10}、${item.topicTwo}（10分）</h4></div>
    	答：
    	
    	<textarea style="height: 100px;width: 800px" name="t${status.count+10}"></textarea>
    </c:forEach>
    </form>
    </div>
    <br/><br/>
  	<div align="center"><button id="btn" class="btn btn-info">提交试卷</button></div>
  	<br/>
  	<br/>
  </body>
</html>
