package com.anuj.java8feature.streaming;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilterApiTest {

	public static void main(String[] args) {
		List<String> strList = Arrays.asList("anuj", "anu", "raj", "raman", "shweta", "saurabh","shyam");
		strList = strList.stream().limit(6).collect(Collectors.toList());
		strList = strList.parallelStream().filter((s) -> {return s.length() >= 4;}).collect(Collectors.toList());
		strList = strList.stream().sorted((s1, s2) -> s1.compareTo(s2)).collect(Collectors.toList());
		System.out.println(strList);
		
	}

}
