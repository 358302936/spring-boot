package com.hx.spring_boot.model.service;

import java.sql.SQLException;

import com.hx.spring_boot.model.pojo.Adminuser;

public interface IAdminuserService {

	/**
	 * 添加管理员
	 * @param record
	 * @throws SQLException
	 */
	public void insertAdmin(Adminuser record) throws SQLException;
}
