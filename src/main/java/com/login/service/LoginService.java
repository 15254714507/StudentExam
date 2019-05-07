package com.login.service;

import com.login.pojo.StudentUser;
import com.login.pojo.User;

/**
 * @author 孔超
 * @date 2019/5/1
 * */
public interface LoginService {
	 /**
	  * show 把绑定的用对象传给loginMapper，让它去获取数据库的用户对象
	  * @param user登录时绑定的用户账号密码对象，	 
	  * @return 返回学生的对象，当账号或密码错误时返回null
	  * @exception 未知异常
	  * */
	 StudentUser getStudentUser(User user) throws Exception;
	 
	 /**
	  * 
	  * show 把想修改密码的账号传给loginMapper，让它去获得数据库的用户对象
	  * @param user需要修改的账号的对象，获得修改账号的密保信息
	  * @return 修改账号的密保信息，当账号不存在时返回null
	  * @exception 未知异常
	  * */
	 StudentUser getStudentMessage(User user) throws Exception;
	 /***
	  * show 把用户对象里的数据信息传给service
	  * @param user最新的密码保存在这个对象里
	  * @exception 有可能修改失败，可能要添加事务回滚
	  * */
	 void updateStudentMessage(User user)throws Exception;
} 
