package com.anuj.java8feature.FI;

interface Intf1{
	public default void m1(){
		System.out.println("Intf1 m1");
	}
	public static void staticMe(){
		System.out.println("Static method is called");
	}
}

interface Intf2{
	default void m1(){
		System.out.println("Intf1 m1");
	}
}

public class MulitInterfaceTest implements Intf1, Intf2{

	public static void main(String[] args) {
		MulitInterfaceTest mit = new MulitInterfaceTest();
		mit.m1();
	
		Intf1.staticMe();
	}

	@Override
	public void m1() {
		System.out.println("Our own method");
		Intf1.super.m1();
	}

}
