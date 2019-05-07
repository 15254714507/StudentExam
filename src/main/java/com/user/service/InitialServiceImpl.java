package com.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.login.pojo.User;
import com.user.mapper.InitialMapper;

/**
 * @author 孔超
 * @date 2019.4.30
 * 
 * */
@Transactional(rollbackFor=Exception.class)
@Service("initialService")
public class InitialServiceImpl implements InitialService{
	@Autowired
	private InitialMapper  initialMapper;
	@Override
	public void updateStudentMessage(User user) throws Exception {
		try {
			initialMapper.updateStudentMessage(user);
        } catch (Exception ex) {
        	System.out.println("修改信息失败，检查数据库连接是否正常。数据库是否出问题了");
        	TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            throw ex;
        }		
	}
	@Override
	public void updateTeacherMessage(User user) throws Exception {
		try {
			initialMapper.updateTeacherMessage(user);
        } catch (Exception ex) {
        	System.out.println("修改信息失败，检查数据库连接是否正常。数据库是否出问题了");
        	TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            throw ex;
        }		
	}

}
