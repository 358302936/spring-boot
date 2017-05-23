package com.hx.spring_boot.model.dao;

import java.sql.SQLException;

import com.hx.spring_boot.model.pojo.Adminuser;

public interface AdminuserDao {
	
	/**
	 * 添加管理员
	 * @param record
	 * @throws SQLException
	 */
	public void insertAdmin(Adminuser record) throws SQLException;
}
