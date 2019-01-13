package com.anuj.misc;

public class ArrayOddSum {

	public static void main(String[] args) {
		int[] nums = {1,2,3,4,5,6};
		int sum = 0;
		for(int a: nums){
			sum += a * (a%2);
		}
		System.out.println(sum);
	}

}
