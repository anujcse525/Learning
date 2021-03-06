package com.anuj.searching;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;

public class FindRepeatedNumber {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scan.nextInt();
		}

		LinkedHashMap<Integer, Integer> map = new LinkedHashMap<Integer, Integer>();
		for (int temp : arr) {
			if (map.containsKey(temp)) {
				map.put(temp, map.get(temp) + 1);
			} else {
				map.put(temp, 1);
			}
		}

		List<Integer> values= (List<Integer>) map.values();
		scan.close();
	}

}
