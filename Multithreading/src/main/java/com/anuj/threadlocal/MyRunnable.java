package com.anuj.threadlocal;

public class MyRunnable implements Runnable {

	private String name;

	public MyRunnable(String name) {
		this.name = name;
	}

	protected ThreadLocal<String> th=new ThreadLocal<String>(){@Override protected String initialValue(){return"This is the initial value";}};

	ThreadLocal th1 = new ThreadLocal<String>();

	public InheritableThreadLocal<String> inThLo=new InheritableThreadLocal<String>(){

	@Override protected String initialValue(){return"Intial value from parent";}

	};

	public InheritableThreadLocal<String> inThLo1 = new InheritableThreadLocal<String>();

	public void run() {
		// th.set(name + " -- Anuj");
		inThLo.set("Setting from parent");
		try {
			Thread.sleep(2L * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(th.get());
		System.out.println(th1.get());
		System.out.println(inThLo.get());
		System.out.println(inThLo1.get());
	}

}
