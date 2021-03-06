package com.anuj.hackerrank;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Matrix {

	static int countDistinct(List<List<Integer>> matrix) {
		Set<Integer> set = new HashSet<Integer>();
		int cols = 0;
		for (List<Integer> list : matrix) {
			cols = list.size();
			int min = Integer.MAX_VALUE;
			int max = Integer.MIN_VALUE;
			boolean minFlag = false, maxFlag = false;
			for (int temp : list) {
				if (temp == min) {
					minFlag = true;
				}
				if (temp == max) {
					maxFlag = true;
				}
				if (temp < min) {
					min = temp;
					minFlag = false;
				}
				if (temp > max) {
					max = temp;
					maxFlag = false;
				}

			}
			if (minFlag || maxFlag) {
				return -1;
			}
			set.add(min);
			set.add(max);
		}

		for (int col = 0; col < cols; col++) {
			int min = Integer.MAX_VALUE;
			int max = Integer.MIN_VALUE;
			boolean minFlag = false, maxFlag = false;
			for (List<Integer> list : matrix) {
				int temp = list.get(col);
				if (temp == min) {
					minFlag = true;
				}
				if (temp == max) {
					maxFlag = true;
				}
				if (temp < min) {
					min = temp;
					minFlag = false;
				}
				if (temp > max) {
					max = temp;
					maxFlag = false;
				}
			}
			if (minFlag || maxFlag) {
				return -1;
			}
			set.add(min);
			set.add(max);
		}
		return set.size();
	}

	public static void main(String[] args) {
		List<Integer> list1 = Arrays.asList(1, 3, 3, 4);
		List<Integer> list2 = Arrays.asList(5, 2, 9, 6);
		List<Integer> list3 = Arrays.asList(8, 7, 6, 9);
		List<List<Integer>> lists = Arrays.asList(list1, list2, list3);
		System.out.println(countDistinct(lists));
	}

}
