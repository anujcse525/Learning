package com.anuj.hackerrank;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Scanner;

class Test{
	static int a;
	static{
		
		a = 20;
		System.out.println("Static block");
	}
	{
		a = 30;
		System.out.println("NON_Static block");
	}
	public Test(int a){
		this.a= a;
		System.out.println("Constructor call");
	}
	static void printst(){
		System.out.println(a);
	}
	
	void print(){
		System.out.println(a);
	}
}


public class StaticTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Test.printst();
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		Iterator<Entry<Integer, Integer>> itr =map.entrySet().iterator();
		Scanner scan = new Scanner(System.in);
		while(itr.hasNext()){
			Entry en = itr.next();
			System.out.println(en.getKey());
		}
		Test st = new Test(9);
		st.print();
		st.printst();
		Test st1 = new Test(10);
		st1.print();
	}

}
