package com.anuj.threadcommu;

public class Test {

	public static void main(String[] args) {
		PlaceToWrite pw = new PlaceToWrite();
		MyWaitNotify mw = new MyWaitNotify();
		Thread prod = new Thread(new Producer(pw, mw));
		Thread con = new Thread(new Consumer(pw, mw));

		prod.start();
		con.start();

		try {
			prod.join();
			con.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
