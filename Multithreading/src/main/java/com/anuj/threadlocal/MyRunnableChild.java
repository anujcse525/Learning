package com.anuj.threadlocal;

public class MyRunnableChild extends MyRunnable {

	private String childName;

	public MyRunnableChild(String name) {
		super(name);
	}

	public String getChildName() {
		return childName;
	}

	public void setChildName(String childName) {
		this.childName = childName;
	}

	public String getParentvalue() {
		System.out.println(th.get());
		System.out.println(inThLo1.get());
		return inThLo.get();
	}
}
