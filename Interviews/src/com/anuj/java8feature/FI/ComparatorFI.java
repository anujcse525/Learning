package com.anuj.java8feature.FI;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Employee implements Comparable<Employee>{
	String name;
	int id;
	
	public Employee(String na, int id) {
		this.name = na;
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", id=" + id + "]";
	}

	@Override
	public int compareTo(Employee o) {
		if(this.id > o.id)
			return 1;
		else if(this.id < o.id){
			return -1;
		}
		else{
			return this.name.compareTo(o.name);
		}
		
	}
	
}

public class ComparatorFI {

	public static void main(String[] args) {

		ArrayList<Employee> list = new ArrayList<Employee>();
		list.add(new Employee("Ram", 1111));
		list.add(new Employee("Raj", 2222));
		list.add(new Employee("Rajan", 3333));
		list.add(new Employee("Anuj",1111));
		list.add(new Employee("Raka", 4444));
		System.out.println(list);
		int abc = 25;
		Comparator<Employee> comp = (Employee E1, Employee E2) -> {
			int ac = 1;
			System.out.println(ac++);
			return (E1.id > E2.id) ? 1 : (E1.id == E2.id) ? E1.name.compareTo(E2.name) : -1;
		};
		Comparator co = new Comparator<Employee>() {
			int abc = 2;
			@Override
			public int compare(Employee o1, Employee o2) {
				// TODO Auto-generated method stub
				abc = abc +2;
				return 0;
			}
		};
		Collections.sort(list, comp);

		list.stream().forEach(System.out::println);
		
		//List<Integer> list2 = list.stream().filter(i -> i%2 == 0).collect(Collectors.toList());
		
		//System.out.println(list2);
	}

}
