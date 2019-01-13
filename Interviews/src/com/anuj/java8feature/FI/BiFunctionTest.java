package com.anuj.java8feature.FI;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

class Employees {
	String name;
	int age;

	Employees(String na, int ag) {
		this.name = na;
		this.age = ag;
	}
}

public class BiFunctionTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Employees> empList = new ArrayList<Employees>();
		
		BiConsumer<String, Integer> bf = (nam, ag) -> empList.add(new Employees(nam, ag));
		
		bf.accept("ABC", 22);
		bf.accept("ABCd", 33);
		bf.accept("ABCe", 44);
		System.out.println(empList.size());
	}

}
