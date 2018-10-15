package com.anuj.socketProgamming;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class UDPServer {

	public static void main(String[] args) {
		try {
			DatagramSocket ds = new DatagramSocket(5555);
			byte[] msgFromClient = new byte[1024];
			
			DatagramPacket dp = new DatagramPacket(msgFromClient, msgFromClient.length);
			ds.receive(dp);
			System.out.println(new String(dp.getData()));
			byte[] returnMsg = ("Message to return").getBytes();
			InetAddress id = InetAddress.getLocalHost();
			DatagramPacket returnPkt = new DatagramPacket(returnMsg, returnMsg.length,id, dp.getPort());
			ds.send(returnPkt);
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
