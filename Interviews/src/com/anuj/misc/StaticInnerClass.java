package com.anuj.misc;

import java.util.ArrayList;

public class StaticInnerClass {

	static int data = 30;
	final int otherData = 22;

	static class Inner {
		void msg() {
			System.out.println("data is " + data );
		}
	}

	public static void main(String args[]) {
		StaticInnerClass.Inner obj = new StaticInnerClass.Inner();
		ArrayList list = new ArrayList<>();
		obj.msg();
	}
}