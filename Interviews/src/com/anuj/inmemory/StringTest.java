package com.anuj.inmemory;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


class compare implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		
		return ((String)o1).length() - ((String)o2).length();
	}
	
}
public class StringTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String abd = "The lines are here to sort.";
		abd = abd.toLowerCase();
		abd = abd.substring(0, abd.length()-1);
		String[] abdArr = abd.split(" ");
		List<String> list = Arrays.asList(abdArr);
		Collections.sort(list, new compare());
		StringBuilder sb = new StringBuilder();
		
		String fir = list.get(0);
		//list.remove(0);
		sb.append(fir.substring(0, 1).toUpperCase() + fir.substring(1) + " ");
		for(int i=1; i< list.size(); i++){
			sb.append(list.get(i) + " " );
		}
		String result = sb.toString();
		result = result.substring(0, result.length()-1);
		result = result+ ".";
		System.out.println(result);
		
	}

	

}
