package com.anuj.multithreading;

public class CounterThread implements Runnable {

	protected static Counter counter = null;
	protected String name = null;

	public CounterThread(Counter count, String name) {
		counter = count;
		this.name = name;
	}

	public void run() {
		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(1L * 1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			synchronized (counter) {
				counter.add(i);
			}

			System.out.println(name + " -- " + counter.getCount() + " -- " + System.currentTimeMillis());
		}
	}

}
