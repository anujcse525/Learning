package com.anuj.java8feature.FI;

public class MultiThreading {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Runnable rn = () -> {
			for (int i = 0; i < 10; i++) {
				System.out.println(Thread.currentThread().getName() + " is printing " + i);
			}
		};
		
		Thread th = new Thread(rn);
		th.start();
	}

}
