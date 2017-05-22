package com.hx.spring_boot.model.service.impl;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hx.spring_boot.model.dao.UserDao;
import com.hx.spring_boot.model.pojo.User;
import com.hx.spring_boot.model.service.IUserService;

@Service("userService")
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserDao userDao;
	
	@Override
	public User selectUserById(int id) throws SQLException {
		return this.userDao.selectUserById(id);
	}

}
