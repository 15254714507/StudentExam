# StudentExam
这个项目主要是本人自己写的关于学生考试系统的，用java的SSM框架实现的
实现的功能：学生的登录，修改密码，ajax异步验证，异步通讯，学生修改信息，上传图片，学生查询自己的考试信息，开始考试，随机发卷，到时自动交卷，查询自己的成绩，可以按科目条件进行查找，没参加考试没成绩，等老师端决定补考还是0，成绩当考完就可以知道自己的选择题部分的成绩，简答题还是要老师修改后才能出成绩，学生的提交的卷子和标准的答案解析都单独存下来，给查看自己的错题提供依据(没做这一部分)
###### 环境依赖
java语言版本：1.8  Tomcat：8.5       
```
├─src
│  ├─main
│  │  ├─java
│  │  │  └─com
│  │  │      ├─ecxeption                //抛出错误问题处理
│  │  │      │      CustomException.java
│  │  │      │      HandlerException.java    
│  │  │      ├─interceptor              //拦截器
│  │  │      │      HandlerInterceptor1.java    
│  │  │      ├─login                    //登录页面的操作和类
│  │  │      │  ├─controller
│  │  │      │  │      LoginAction.java   
│  │  │      │  ├─mapper
│  │  │      │  │      LoginMapper.java
│  │  │      │  │      LoginMapper.xml     
│  │  │      │  ├─pojo
│  │  │      │  │      StudentUser.java  //学生信息，继承User
│  │  │      │  │      User.java         //用户信息，学生和老师共有的
│  │  │      │  └─service
│  │  │      │          LoginService.java
│  │  │      │          LoginServiceImpl.java    
│  │  │      ├─topic
│  │  │      │  └─pojo
│  │  │      │          ChoiceQuestion.java  //选择题部分
│  │  │      │          ExamQuestion.java    //试题卷
│  │  │      │          ModelAnswer.java     //标准答案
│  │  │      │          ModelAnswerList.java //标准答案的集合
│  │  │      │          ShortAnswerQuestion.java  //简答题部分
│  │  │      │          StudentTest.java     //学生提交的试卷 
│  │  │      └─user
│  │  │          ├─controller
│  │  │          │      InitialController.java //登录进去的页面里的学生和老师共有的操作
│  │  │          │      StudentController.java  //学生独有的操作
│  │  │          ├─mapper
│  │  │          │      InitialMapper.java
│  │  │          │      InitialMapper.xml
│  │  │          │      StudentMapper.java
│  │  │          │      StudentMapper.xml    
│  │  │          ├─pojo
│  │  │          │      ExamArrange.java       //考试安排信息
│  │  │          │      StudentGrade.java      //学生成绩信息
│  │  │          ├─service
│  │  │          │      InitialService.java
│  │  │          │      InitialServiceImpl.java
│  │  │          │      StudentService.java
│  │  │          │      StudentServiceImpl.java    
│  │  │          └─unit                        //分页信息，里面有list集合，可以把比如考试信息进行分页
│  │  │                  Page.java         
│  │  ├─resources
│  │  │      conn.properties                     //数据库连接信息
│  │  │      errorMessage.properties             //和pojo的校验器进行匹配，报告错误信息，比如某个信息不能为空
│  │  │      log4j2.xml		            //日志系统
│  │  │      spring-dao.xml 			    //这三个是SSM整合
│  │  │      spring-mvc.xml
│  │  │      spring-service.xml
│  │  │      sqlMapConfig.xml   		    //mybatis全局配置
│  │  └─webapp               
│  │      │  index.html
│  │      │  index.jsp
│  │      │  Login.jsp			    //登录页面
│  │      ├─bootstrap-3.3.7-dist		    //下面的是样式和样式中需要的图片
│  │      ├─css
│  │      ├─fonts
│  │      ├─img
│  │      ├─js
│  │      ├─uploadimage             //用户头像默认图片(没有头像的用户)
│  │      │      1.jpg
│  │      │      
│  │      └─WEB-INF
│  │          │  error.jsp 		  //出错回显页面
│  │          │  web.xml
│  │          ├─Login		 //登录页面附属功能页面
│  │          │      ChangePass.jsp   //修改密码
│  │          │      Retrieve.jsp	 //验证用户
│  │          │      
│  │          └─Student
│  │                  ComingSoonTest.jsp  //即将考试
│  │                  FailGrade.jsp       //不及格成绩
│  │                  Grade.jsp	    //全部成绩
│  │                  PassGrade.jsp       //及格成绩
│  │                  People.jsp          //学生的个人信息
│  │                  StudLogin.jsp       //学生登录进去的大页面
│  │                  Test.jsp            //考试页面
│  │                  TimePassedTest.jsp   //时间过了的考试(没参加)  
│  │                  TopicAnswer.jsp      //考试答案(已考，已出全部成绩，没做呢)
│  │                  UnderwayExamTest.jsp  //到考试时间的
│  │                  
│  .gitignore
│  pom.xml  
```

