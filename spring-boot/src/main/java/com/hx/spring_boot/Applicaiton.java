package com.hx.spring_boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


/**
 * 入口程序
 * @author chuhx
 * @version 2017年5月19日
 */
@Controller
@EnableWebMvc
@EnableAutoConfiguration
@ComponentScan
public class Applicaiton extends WebMvcConfigurerAdapter{
	
	public static void main(String[] args) {
		SpringApplication.run(Applicaiton.class, args);
	}
}
