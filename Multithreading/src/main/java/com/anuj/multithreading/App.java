package com.anuj.multithreading;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		MyRunnable my = new MyRunnable();
		Thread th = new Thread(my);
		th.start();
		try {
			Thread.sleep(10L * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		my.doStop();
	}
}
