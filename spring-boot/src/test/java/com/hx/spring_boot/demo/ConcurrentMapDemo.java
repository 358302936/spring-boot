package com.hx.spring_boot.demo;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class ConcurrentMapDemo {

	public static void main(String[] args) {
		ConcurrentMap<String, Object> cMap = new ConcurrentHashMap<>();
		System.out.println(Integer.parseInt("0001111", 2) & 12);
		System.out.println(Integer.parseInt("0011111", 2) & 15);
		System.out.println(Integer.parseInt("0111111", 2) & 15);
		System.out.println(Integer.parseInt("1111111", 2) & 15);
	}
}
