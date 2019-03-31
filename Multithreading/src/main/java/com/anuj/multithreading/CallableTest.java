package com.anuj.multithreading;

import java.util.concurrent.Callable;

public class CallableTest implements Callable<String> {

	String stringParam;
int count;
	public CallableTest(String abc) {
		this.stringParam = abc;
	}
	
	public CallableTest(int count) {
		this.count = count;
	}

	public String call() throws Exception {
		System.out.println(stringParam);
		Thread.sleep(10000);
		return "Returning " + stringParam;
		
	}

}
