package com.anuj.threadcommu;

public class MyWaitNotify {

	private boolean isSignalled = false;

	private static MonitorObject monitor = new MonitorObject();

	public void doWait() {
		synchronized (monitor) {
			while (!isSignalled) {
				synchronized (monitor) {
					try {
						monitor.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			isSignalled = false;
		}
	}

	public void doNotify() {
		synchronized (monitor) {
			isSignalled = true;
			monitor.notifyAll();
		}
	}
}
