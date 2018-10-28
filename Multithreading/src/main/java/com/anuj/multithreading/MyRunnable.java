package com.anuj.multithreading;

public class MyRunnable implements Runnable {

	private boolean doStop = false;

	public synchronized void doStop() {
		this.doStop = true;
	}

	private synchronized boolean keepRunning() {
		return doStop == false;
	}

	public void run() {
		while (keepRunning()) {
			System.out.println("Running");

			try {
				Thread.sleep(3L * 1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}
