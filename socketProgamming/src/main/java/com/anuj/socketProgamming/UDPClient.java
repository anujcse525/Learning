package com.anuj.socketProgamming;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class UDPClient {

	public static void main(String[] args) {
		try {
			DatagramSocket ds = new DatagramSocket();
			String msg = "Anuj";
			DatagramPacket dp = new DatagramPacket(msg.getBytes(), 0, msg.length(), InetAddress.getLocalHost(), 5555);
			ds.send(dp);
			byte[] returnMsg = new byte[1024];
			DatagramPacket returnPkt = new DatagramPacket(returnMsg, returnMsg.length);
			ds.receive(returnPkt);
			System.out.println(new String(returnPkt.getData()));
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
