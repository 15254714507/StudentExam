package com.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.login.pojo.StudentUser;
import com.login.pojo.User;
import com.login.mapper.LoginMapper;

/**
 * @author 孔超
 * @date 2019/5/1
 * 
 * */
@Transactional(rollbackFor=Exception.class)
@Service("loginService")
public class LoginServiceImpl implements LoginService{
	@Autowired
	private LoginMapper loginMapper ;
		@Override
		public StudentUser getStudentUser(User user) throws Exception {
			
				StudentUser sUder =loginMapper.getStudentUser(user);
				return sUder;									
		}
		@Override
		public StudentUser getStudentMessage(User user) throws Exception {
				StudentUser sUder =loginMapper.getStudentMessage(user);
				return sUder;									
		}
		@Override
		public void updateStudentMessage(User user) throws Exception {
			//发生修改异常强制手动回滚
			try {
				    loginMapper.updateStudentMessage(user);
	            } catch (Exception ex) {
	            	System.out.println("修改信息失败，检查数据库连接是否正常。数据库是否出问题了");
	            	TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
	                throw ex;
	            }

		}
			
}
