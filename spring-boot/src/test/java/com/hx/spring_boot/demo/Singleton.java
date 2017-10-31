package com.hx.spring_boot.demo;

/**
 * 饥饿模式
 * @author chuhx
 * @version 2017年10月19日
 */
public class Singleton {

	//缺点，谁都可以创建；什么时候创建不受控制
	
	private Singleton(){
		System.out.println("create singleton!");
	}
	
	private static Singleton singleton = new Singleton();	
	public static Singleton getInstance(){
		return singleton;
	}
	
}
