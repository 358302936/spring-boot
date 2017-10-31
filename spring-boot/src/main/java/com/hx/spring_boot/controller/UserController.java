package com.hx.spring_boot.controller;

import java.sql.SQLException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hx.spring_boot.component.ReturnData;
import com.hx.spring_boot.model.pojo.User;
import com.hx.spring_boot.model.service.IUserService;

@Controller
@RequestMapping(value="/user")
public class UserController {

	@Resource
	private IUserService userService;
	
	/**
	 * 获得用户
	 * @return
	 */
	@RequestMapping(value="/getInfo",method=RequestMethod.GET,produces="application/json;charset=UTF-8")
	public ResponseEntity<ReturnData> getUser(HttpServletRequest request,HttpServletResponse response,
			@RequestParam Integer id){
		ReturnData ret = ReturnData.newSuccessReturnData();
		try {
			User user = new User();
			user = this.userService.selectUserById(id);
			ret.setData(user);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return new ResponseEntity<ReturnData>(ret,HttpStatus.OK);
	}
	
}
