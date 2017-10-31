package com.hx.spring_boot.demo;

/**
 * 懒汉模式
 * @author chuhx
 * @version 2017年10月19日
 */
public class LazySingleton {

	//缺点：并发环境下加锁，竞争激烈的场合对性能可能产生一定的影响。
	
	private LazySingleton(){
		System.out.println("create lazySingleton!");
	}
	
	private static LazySingleton singleton = null;
	
	public static synchronized LazySingleton getInstance(){
		if(singleton == null){
			singleton = new LazySingleton();
		}
		return singleton;
	}
}
