package com.accolite;

class Sparent {
	public static void method1() {
		System.out.println("Static parent method1");
	}

	public void method2() {
		System.out.println("Parent method2");
	}
}

class Schild extends Sparent {
	public static void method1() {
		System.out.println("Static Child method1");
	}

	public void method2() {
		System.out.println("Child method2");
	}
}

public class StaticNonStatic {

	public static void main(String[] args) {
		Schild sparent = new Schild();
		sparent.method2();
		sparent.method1();
	}

}
