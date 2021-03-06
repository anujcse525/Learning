package com.anuj.threadcommu;

import java.util.concurrent.Semaphore;

public class Consumer implements Runnable {

	MyWaitNotify mwn = null;
	PlaceToWrite pw = null;
	Semaphore sem = new Semaphore(0);

	public Consumer(PlaceToWrite p, MyWaitNotify m) {
		this.pw = p;
		this.mwn = m;
	}

	public void run() {

		// while (true) {
		mwn.doWait();
		System.out.println(pw.getValue());
		pw.setValue("I read ur msg");
		mwn.doNotify();
		// }
	}

}
