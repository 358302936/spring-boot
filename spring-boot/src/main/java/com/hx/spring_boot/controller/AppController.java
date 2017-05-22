package com.hx.spring_boot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hx.spring_boot.component.ReturnData;


@Controller
@RequestMapping(value="/app")
public class AppController {

	@RequestMapping(value="/hello")
	public ResponseEntity<ReturnData> helloWold(){
		ReturnData ret = ReturnData.newSuccessReturnData(); 
		ret.setData("spring-boot");
		return new ResponseEntity<ReturnData>(ret, HttpStatus.OK);
	}
	
	
}
