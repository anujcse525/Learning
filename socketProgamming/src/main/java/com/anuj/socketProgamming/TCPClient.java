package com.anuj.socketProgamming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class TCPClient {

	public static void main(String[] args) {
		Socket socket = null;
		Scanner scan = null;
		try {
			scan = new Scanner(System.in);
			System.out.println("Starting client");
			socket = new Socket("localhost", 4444);
			while (true) {
				OutputStreamWriter osw = new OutputStreamWriter(socket.getOutputStream());
				PrintWriter pw = new PrintWriter(osw);
				String msg = scan.nextLine();
				pw.println(msg);
				pw.flush();
				BufferedReader bfr = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				System.out.println(bfr.readLine());
				if (msg.equalsIgnoreCase("over"))
					break;
			}
			System.out.println("Sent data");
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				socket.close();
				scan.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
