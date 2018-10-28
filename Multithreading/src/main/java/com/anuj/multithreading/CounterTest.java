package com.anuj.multithreading;

public class CounterTest {

	public static void main(String[] args) {
		Counter counter = new Counter();
		
		CounterThread ct1 = new CounterThread(counter, "TH1");
		CounterThread ct2 = new CounterThread(counter, "TH2");

		Thread th1 = new Thread(ct1);

		Thread th2 = new Thread(ct2);

		th1.start();
		th2.start();
	}

}
