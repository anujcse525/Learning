package com.anuj.socketProgamming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {

	public static void main(String[] args) {
		ServerSocket ssocket = null;
		try {
			System.out.println("Starting server");
			ssocket = new ServerSocket(4444);
			System.out.println("Server Started");
			while (true) {
				Socket sock = ssocket.accept();
				System.out.println("Received some data");
				BufferedReader bfr = new BufferedReader(new InputStreamReader(sock.getInputStream()));
				String msg = null;
				int counter = 0;
				do {
					msg = bfr.readLine();
					System.out.println("Got ur msg : " + msg);
					OutputStreamWriter osw = new OutputStreamWriter(sock.getOutputStream());
					PrintWriter pw = new PrintWriter(osw);
					pw.println("message number from server : " + ++counter);
					pw.flush();
				} while (!msg.equalsIgnoreCase("over"));

			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				ssocket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
