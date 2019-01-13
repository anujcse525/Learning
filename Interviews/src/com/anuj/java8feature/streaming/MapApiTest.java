package com.anuj.java8feature.streaming;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//map will apply the function on the stream and return the stream
public class MapApiTest {

	public static int square(int i){
		return i * i;
	}
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(22, 33, 11, 05, 11);
		List<Integer> squareList = numbers.stream().map(MapApiTest::square).distinct().collect(Collectors.toList());
		System.out.println(squareList);
	}

}
