package com.anuj.websocketServer;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/serverendpointdemo")
public class ServerEndPointDemo {

	@OnOpen
	public void handleOpen() {
		System.out.println("Client is now connected");
	}

	@OnClose
	public void handleClose() {
		System.out.println("Client is now disconnected");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@OnError
	public void handleError(Throwable t) {
		t.printStackTrace();
	}

	@OnMessage
	public String handleMessage(String msg) {
		System.out.println("Received from client : " + msg);
		String reply = "echo " + msg;
		System.out.println("Sending to client : " + reply);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return reply;
	}
}
