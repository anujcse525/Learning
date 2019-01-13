package com.anuj.hackerrank;

import java.util.Arrays;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.stream.Collectors;

public class DeleteToAnagram {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String str1 = scan.nextLine();
		String str2 = scan.nextLine();

		int num = findCharsToDelete(str1, str2);
		System.out.println(num);
		scan.close();

	}

	private static int findCharsToDelete(String str1, String str2) {
		int result = 0;
		Map<String, Long> map1 = Arrays.stream(str1.split(""))
				.collect(Collectors.groupingBy(c -> c, Collectors.counting()));
		Map<String, Long> map2 = Arrays.stream(str2.split(""))
				.collect(Collectors.groupingBy(c -> c, Collectors.counting()));
		for (Entry<String, Long> entry : map1.entrySet()) {
			if (map2.containsKey(entry.getKey()))
				result += Math.abs(map2.get(entry.getKey()) - entry.getValue());
			else
				result += entry.getValue();
		}
		for (Entry<String, Long> entry : map2.entrySet()) {
			if (!map1.containsKey(entry.getKey()))
				result += entry.getValue();
		}
		return result;
	}

}
