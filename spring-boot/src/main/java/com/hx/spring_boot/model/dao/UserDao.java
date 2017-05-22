package com.hx.spring_boot.model.dao;

import java.sql.SQLException;

import com.hx.spring_boot.model.pojo.User;

/**
 * 
 * @author chuhx
 * @version 2017年5月22日
 */
public interface UserDao {

	/**
	 * 根据id查找用户信息
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public User selectUserById(int id) throws SQLException;
}
