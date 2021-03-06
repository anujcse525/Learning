package com.accolite;

import java.io.IOException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;

class Parent {
	void print() throws Exception{ 
		System.out.println("Parent print");
	}
}

class Child extends Parent{
	public void print() throws IOException{
		System.out.println("child print");
	}
}

class Methods{
	public void print1(Parent pa){
		System.out.println("Parent"); 
	}
	
	public void print2(Child ch){
		System.out.println("Child");
	}
}

public class JustChecking {

	public static void main(String[] args) throws Exception {
		//Parent pa = new Child();
	//	pa.print();
		//Collections.sort(null);
		HashMap<String, String> hm = new HashMap<String, String>();
		System.out.println(hm.size());
		Hashtable<String, String> ht = new Hashtable<String, String>();
		ht.put("key", "val");
		//ht.put(null, "test");
		//System.out.println(ht.get(null));
		System.out.println(ht.size());
		LinkedHashMap<String, String> lmap =new LinkedHashMap<String, String>(5, 0.75f, true);
		
		lmap.put("abc", "ABC");
		lmap.put("cde", "CDE");
		lmap.put("abc", "ACC");
		lmap.put("cde", "DE");
		lmap.get("cde");
		lmap.put("aaa", "AAA");
	}

}
