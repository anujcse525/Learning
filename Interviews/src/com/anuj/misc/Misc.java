package com.anuj.misc;

import java.util.HashSet;

public class Misc {

	public static void main(String[] args) {
		System.out.println(5.0 % 2);
		 String[] strArray = {"abc", "def", "mno", "xyz", "pqr", "xyz", "def"};
		 
	        HashSet<String> set = new HashSet<String>();
	 
	        for (String arrayElement : strArray)
	        {
	            if(!set.add(arrayElement))
	            {
	                System.out.println("Duplicate Element is : "+arrayElement);
	            }
	        }
	}

}
