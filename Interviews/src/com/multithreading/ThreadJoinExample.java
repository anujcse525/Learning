package com.multithreading;

public class ThreadJoinExample {

	
	public static void main(String[] args) {
		Counter count = new Counter();
		ThreadGroup tg = new ThreadGroup("MY");
		Thread t1 = new Thread(tg, new MyRunnable(count), "t1");
		Thread t2 = new Thread(tg, new MyRunnable(count), "t2");
		Thread t3 = new Thread(tg, new MyRunnable(count), "t3");
		
		t1.start();
		t2.start();
		t3.start();
		// ThreadLocal abc = new ThreadLocal<>();
//		t1.start();
//		System.out.println(tg.activeGroupCount());
//		// start second thread after waiting for 2 seconds or if it's dead
//		try {
//			t1.join(2000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//
//		t2.start();
//		// start third thread only when first thread is dead
//		try {
//			t1.join();
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//
//		t3.start();
//		//tg.interrupt();
//		// let all threads finish execution before finishing main thread
//		try {
//			t1.join();
//			t2.join();
//			t3.join();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		System.out.println("All threads are dead, exiting main thread");
	}

}

class MyRunnable implements Runnable {
	Counter counter = null;
	
	public MyRunnable(Counter count) {
		this.counter = count;
	}
	@Override
	public void run() {
		System.out.println("Thread started:::" + Thread.currentThread().getName());
		try {
			Counter.add(20);
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Thread ended:::" + Thread.currentThread().getName());
	}

}

 class Counter {

    protected static long count = 0;

    public static synchronized void add(long value){
        count = count + value;
        System.out.println(Thread.currentThread() + " -- "+count);
    }
 }
