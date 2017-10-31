package com.hx.spring_boot.controller;

import java.util.HashMap;
import java.util.concurrent.locks.ReentrantLock;

public class HashMapMultiThread {

	public static HashMap<Integer,Integer> al = new HashMap<Integer,Integer>();
	
	public static class AddThread implements Runnable{

		public static ReentrantLock lock1 = new ReentrantLock();
		public static ReentrantLock lock2 = new ReentrantLock();
		int lock = 0;
		
		public AddThread(int lock){
			this.lock=lock;
		}
		
		@Override
		public void run() {
			if(lock == 1){
				while(true){
					if(lock1.tryLock()){
						try{
							try{
								Thread.sleep(500);
							}catch(InterruptedException e){
								
							}
							if(lock2.tryLock()){
								try {
									System.out.println(Thread.currentThread().getName()+":My job done");
									return;
								} finally{
									lock2.unlock();
								}
							}
						}finally{
							lock1.unlock();
						}
					}
				}
		}else{
			 while(true){
				 if(lock2.tryLock()){
					 try{
						 try{
							 Thread.sleep(500);
						 }catch(InterruptedException e){}
						 if(lock1.tryLock()){
							 try {
								 System.out.println(Thread.currentThread().getName()+":My job done");
								 return;
							 }finally{
								 lock1.unlock();
							 }
						 }
					 }finally{
						 lock2.unlock();
					 }
				 }
			 }
			}
		}
		
	}
	
	public static void main(String[] args) throws InterruptedException {
		HashMapMultiThread.AddThread at = new HashMapMultiThread.AddThread(1);
		HashMapMultiThread.AddThread at1 = new HashMapMultiThread.AddThread(2);
		Thread t1 = new Thread(at);
		Thread t2 = new Thread(at1);
		t1.setName("t1");
		t2.setName("t2");
		t1.start();
		t2.start();
	}
}
