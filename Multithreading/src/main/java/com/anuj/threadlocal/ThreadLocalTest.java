package com.anuj.threadlocal;

public class ThreadLocalTest {

	public static void main(String[] args) {
		MyRunnable mr1 = new MyRunnable("Thread -- 1");
		MyRunnable mr2 = new MyRunnable("Thread -- 2");

		Thread th1 = new Thread(mr1);
		Thread th2 = new Thread(mr2);

		th1.start();
		
		try {
			th1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		th2.start();
		try {
			th2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		MyRunnableChild ch = new MyRunnableChild("Child");
		System.out.println(ch.getParentvalue());
	}

}
