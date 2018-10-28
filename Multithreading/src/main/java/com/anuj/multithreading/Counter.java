package com.anuj.multithreading;

public class Counter {
	long count = 0;

	
	public synchronized void add(int num) {
		this.count += num;
	}

	public long getCount() {
		return count;
	}
}
