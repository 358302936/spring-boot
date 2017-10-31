package com.hx.spring_boot.controller;

public class PriorityDemo {

	public final static int MIN_PRIORITY=1;
	public final static int NORM_PRIORITY=1;
	public final static int MAX_PRIORITY=1;
	
	public static class HightPriority extends Thread{
		static int count=0;
		@Override
		public void run(){
			while(true){
				synchronized (PriorityDemo.class) {
					count++;
					if(count>10000000){
						System.out.println("HightPriority is complete!");
						break;
					}
				}
			}
		}
	}
	
	public static class LowPriority extends Thread{
		static int count=0;
		@Override
		public void run(){
			while(true){
				synchronized (PriorityDemo.class) {
					count++;
					if(count>10000000){
						System.out.println("LowPriority is complete!");
						break;
					}
				}
			}
		}
	}
	
	public static void main(String[] args){
		Thread high = new HightPriority();
		Thread low = new LowPriority();
		high.setPriority(MAX_PRIORITY);
		low.setPriority(MIN_PRIORITY);
		high.start();
		low.start();
	}
}
