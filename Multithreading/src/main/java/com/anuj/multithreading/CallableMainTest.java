package com.anuj.multithreading;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableMainTest extends CallableTest{

	public CallableMainTest(int count) {
		super(count);
	}

	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool();
		CallableTest ct = new CallableTest("Anuj");
		
		Future<String> response = exec.submit(ct);
		try {
			System.out.println(response.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}

		exec.shutdown();
	}

}
