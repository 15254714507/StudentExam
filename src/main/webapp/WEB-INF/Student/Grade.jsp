<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  
    
    <title>全部成绩</title>
    
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
	<style>

table tr:first-child{background:#0066CC; color:#fff;font-weight:bold;} /*第一行标题蓝色背景*/
table{border-top:1pt solid #C1DAD7;border-left:1pt solid #C1DAD7;margin: 0 auto;} 
td{ padding:5px 10px; text-align:center;border-right:1pt solid #C1DAD7;border-bottom:1pt solid #C1DAD7;}
tr:nth-of-type(odd){ background:#F5FAFA;} /* odd 标识奇数行，even标识偶数行 */
tr:hover{ background: #E0F0F0;} /*鼠标悬停后表格背景颜色*/
</style>
<script type="text/javascript">
	
		$(document).ready(function(){
			$('.pagination a').click(function(){
			
				$.ajax({
						url:"./studentAllGradeSkip.action?content="+$("#content").val()+"&type="+$(this).text(),
						type:"POST",
						dataType:"text",
						success:function(msg){
						//刷新当前页面
						//获得了a标签里的内容，服务端也响应了,现在只剩下让表格刷新了
						$("#cout").html(msg);
						}
					});	
						
						});
		
		$("#First").click(function(){
			
				$.ajax({
						url:"./studentAllGradeSkip.action?content="+$("#content").val()+"&type=1",
						type:"POST",
						dataType:"text",
						success:function(msg){
						//刷新当前页面
						//获得了a标签里的内容，服务端也响应了,现在只剩下让表格刷新了
						$("#cout").html(msg);
						}
					});	
						
						});
			$("#Last").click(function(){
			
				$.ajax({
						url:"./studentAllGradeSkip.action?content="+$("#content").val()+"&type=${sessionScope.page.totalPage}",
						type:"POST",
						dataType:"text",
						success:function(msg){
						//刷新当前页面
						//获得了a标签里的内容，服务端也响应了,现在只剩下让表格刷新了
						$("#cout").html(msg);
						}
					});	
						
						});	
						
				$("#btn").click(function(){
					$.ajax({
							url:"./studentAllGradeSkip.action?content="+$("#content").val()+"&type=-1",
							type:"POST",
							dataType:"text",
							success:function(msg){
							//刷新当前页面
							//获得了a标签里的内容，服务端也响应了,现在只剩下让表格刷新了
							$("#cout").html(msg);
							}
						});	
				
				
					});				
		});
		</script>
  </head>
  
  <body>
   <div id="cout">
   		<div class="row">
			  <div class="col-lg-6">
			    <div class="input-group">
			      <span class="input-group-addon" id="basic-addon1">科目:</span>
			       <input id="content" type="text" class="form-control" placeholder="按考试科目查例如“毛概”" aria-describedby="basic-addon1" value="${sessionScope.search}">
			    </div><!-- /input-group -->
			  </div><!-- /.col-lg-6 -->
			  <div class="col-lg-1">
			  <button class="btn btn-info" id ="btn" >查找</button>
			  </div>
		</div>	  
   		
   		<br/>
   		
   		
		  <table width='900px' border='0' cellspacing='0' cellpadding='0' align='center'>
		    <tr class="info">
		   <th>序号</th><th>科目</th><th>选择题成绩</th><th>简答题成绩</th><th>总成绩</th> </tr>
		    <c:forEach var="item" items="${sessionScope.page.dataList}" varStatus="status">
		    	<tr >
		    		<td>${status.count}</td>
    				<td>${item.subject}</td>
    		
    				<td>${item.selectgrade}</td>
    			<c:if test="${item.shortgrade==-1}">
    				<td>正在验简答题答案</td>
    				<td>正在核算</td>
    		</c:if>
    		<c:if test="${item.shortgrade>=0}">
    				<td>${item.shortgrade}</td>
    				<td>${item.selectgrade+item.shortgrade}</td>
    		</c:if>
		    	</tr>
		    	
		    </c:forEach>
		   </table>
	   	<nav aria-label="Page navigation">
		  <ul class="pagination">
		    <li>
		      <a href="#" aria-label="Previous" id="First">
		    
		        <span aria-hidden="true">&laquo;</span>
		      </a>
		    </li>
		    <c:choose>
		    	<c:when test="${sessionScope.page.totalPage==1}">
		    		<li><a href="#">1</a></li>
		    	</c:when>
		    	<c:when test="${sessionScope.page.totalPage==2}">
		    	  	<li><a href="#" >1</a></li>
		    		<li><a href="#" >2</a></li>
		    	</c:when>
		    	<c:when test="${sessionScope.page.totalPage==3}">
		    		<li><a href="#">1</a></li>
		    		<li><a href="#">2</a></li>
		    		<li><a href="#">3</a></li>
		    	
		    	</c:when>
		    	<c:when test="${sessionScope.page.totalPage==4}">
		    		<li><a href="#">1</a></li>
		    		<li><a href="#">2</a></li>
		    		<li><a href="#">3</a></li>
		    		<li><a href="#">4</a></li>
		    	
		    	</c:when>
		    	<c:when test="${sessionScope.page.totalPage>=5&&sessionScope.page.currentPage==1}">
		    		<li><a href="#">${sessionScope.page.currentPage}</a></li>
		    		<li><a href="#">${sessionScope.page.currentPage+1}</a></li>
		    		<li><a href="#">${sessionScope.page.currentPage+2}</a></li>
		    		<li><a href="#">${sessionScope.page.currentPage+3}</a></li>
		    		<li><a href="#">${sessionScope.page.currentPage+4}</a></li>
		    	
		    	
		    	</c:when>
		    	<c:when test="${sessionScope.page.totalPage>=5&&sessionScope.page.totalPage-sessionScope.page.currentPage>=4}">
		    		<li><a href="#">${sessionScope.page.currentPage-1}</a></li>
		    		<li><a href="#">${sessionScope.page.currentPage}</a></li>
		    		<li><a href="#">${sessionScope.page.currentPage+1}</a></li>
		    		<li><a href="#">${sessionScope.page.currentPage+2}</a></li>
		    		<li><a href="#">${sessionScope.page.currentPage+3}</a></li>
		    	
		    	</c:when>
		    	<c:when test="${sessionScope.page.totalPage>=5&&sessionScope.page.totalPage-sessionScope.page.currentPage<=4}">
		    		<li><a href="#">${sessionScope.page.totalPage-4}</a></li>
		    		<li><a href="#">${sessionScope.page.totalPage-3}</a></li>
		   			<li><a href="#">${sessionScope.page.totalPage-2}</a></li>
		    		<li><a href="#">${sessionScope.page.totalPage-1}</a></li>
		   			<li><a href="#">${sessionScope.page.totalPage}</a></li>
		    	</c:when>
		    </c:choose> 	
		    <li>
		      <a href="#" aria-label="Next" id ="Last">
		     
		        <span aria-hidden="true">&raquo;</span>
		      </a>
		    </li>
		  </ul>
		</nav>	   
		<div align="right">这是第<span style="color: blue;">${ sessionScope.page.currentPage}</span>页，总共<span style="color: blue;">${ sessionScope.page.totalPage}</span>页</div>	   
   </div>
  </body>
</html>
