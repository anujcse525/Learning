package com.anuj.threadcommu;

public class Producer implements Runnable {

	PlaceToWrite pw = null;
	MyWaitNotify mwn = null;

	public Producer(PlaceToWrite p, MyWaitNotify m) {
		this.pw = p;
		this.mwn = m;
	}

	public void run() {
		pw.setValue("Setting first value");
		mwn.doNotify();
		mwn.doWait();
		System.out.println(pw.getValue());
	}

}
