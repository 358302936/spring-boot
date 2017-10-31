package com.hx.spring_boot.demo;

/**
 * 内部静态类模式
 * @author chuhx
 * @version 2017年10月19日
 */
public class StaticInnerSingleton {

	//优点：1、没有用锁，性能高；2、只有在第一次调用时，实例才会被创建。
	
	private StaticInnerSingleton(){
		System.out.println("create StaticInnerSingleton!");
	}
	
	private static class SingletonHolder{
		private static StaticInnerSingleton instance = new StaticInnerSingleton();
	}
	
	public static StaticInnerSingleton getInstance(){
		return SingletonHolder.instance;
	}
}
