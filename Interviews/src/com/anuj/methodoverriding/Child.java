package com.anuj.methodoverriding;

public class Child extends Parent{
	public int count = 6;

	public void printsomething() {
		System.out.println("Child");
	}
	
	public void parentName(){
		System.out.println("My parent name");
	}
}
