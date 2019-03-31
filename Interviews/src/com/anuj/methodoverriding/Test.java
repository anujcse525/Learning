package com.anuj.methodoverriding;

import java.util.ArrayList;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		GP gp = new GP();
		gp.printsomething();
		System.out.println(gp.count);

		gp = new Parent();
		gp.printsomething();
		System.out.println(gp.count);

		gp = new Child();
		gp.printsomething();
		System.out.println(gp.count);

		Oldest od = new GP();
		od.printsomething();
		System.out.println(od.count);

		od = new Parent();
		od.printsomething();
		System.out.println(od.count);

		od = new Child();
		od.printsomething();
		System.out.println(od.count);
		
		List list = new ArrayList();
		
		list.add("Anuj");
		list.add(22);
		
		for(Object obj : list){
			System.out.println(obj);
		}

	}

}
