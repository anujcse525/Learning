package com.anuj.backtracking;

import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class StringPermutation {

	public static void main(String[] args) {
		StringPermutation sp = new StringPermutation();
		sp.permute("ABC".toCharArray());
	}

	public void permute(char[] input) {
		Map<Character, Integer> countMap = new TreeMap<>();
		for (char ch : input) {
			countMap.compute(ch, (key, value) -> {
				if (value == null) {
					return 1;
				} else {
					return value + 1;
				}
			});
		}

		char[] str = new char[countMap.size()];
		int[] count = new int[countMap.size()];

		int index = 0;
		for (Entry<Character, Integer> entry : countMap.entrySet()) {
			str[index] = (char) entry.getKey();
			count[index] = (int) entry.getValue();
			index++;
		}
		char[] result = new char[input.length];

		permuteString(str, count, result, 0);
	}

	private void permuteString(char[] str, int[] count, char[] result, int level) {
		if (level == result.length) {
			System.out.println(new String(result));
			return;
		}

		for (int i = 0; i < str.length; i++) {
			if (count[i] == 0) {
				continue;
			}
			result[level] = str[i];
			count[i]--;
			permuteString(str, count, result, level + 1);
			count[i]++;
		}
	}
}
