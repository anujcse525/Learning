
package com.anuj.shutdownhook;

public class ProcessorHook extends Thread {

	@Override
	public void run() {
		System.out.println("Status=" + FilesProcessor.status);
		System.out.println("FileName=" + FilesProcessor.fileName);
		if (!FilesProcessor.status.equals("FINISHED")) {
			System.out.println("Seems some error, sending alert");
		}

	}
}