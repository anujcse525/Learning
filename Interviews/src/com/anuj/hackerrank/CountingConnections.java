package com.anuj.hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountingConnections {

	static int countConnections(List<List<Integer>> matrix) {
		int count = 0;

		// Single element
		if (matrix.size() == 1 && matrix.get(0).size() == 1) {
			return 0;
		}

		for (int i = 0; i <= matrix.size() - 1; i++) {

			if (i == (matrix.size() - 1)) {
				// Single row
				if (i == 0) {
					for (int j = 0; j < matrix.get(i).size() - 1; j++) {
						if (matrix.get(i).get(j) == 1 && matrix.get(i).get(j + 1) == 1) {
							count++;
						}
					}
				}
				// last row
				else {
					for (int j = 0; j < matrix.get(i).size() - 1; j++) {
						if (matrix.get(i).get(j) == 1 && matrix.get(i).get(j + 1) == 1) {
							count++;
						}
						if (matrix.get(i).get(j) == 1 && matrix.get(i - 1).get(j + 1) == 1) {
							count++;
						}
					}
				}

			} else {
				for (int j = 0; j < matrix.get(i).size() - 1; j++) {

					if (matrix.get(i).get(j) == 1) {
						if (matrix.get(i).get(j + 1) == 1) {
							count++;
						}
						if (matrix.get(i + 1).get(j) == 1) {
							count++;
						}
						if (matrix.get(i + 1).get(j + 1) == 1) {
							count++;
						}
					}
				}

			}
		}

		// last col
		List<Integer> lastCol = new ArrayList<Integer>();
		for (int i = 0; i <= matrix.size() - 1; i++) {
			lastCol.add(matrix.get(i).get(matrix.get(i).size() - 1));
		}
		for(int i=0; i<lastCol.size()-1; i++){
			if(lastCol.get(i) == 1 && lastCol.get(i+1) == 1){
				count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		List<Integer> list1 = Arrays.asList(1, 0, 0, 1);
		//System.out.println(list1.size());
		List<Integer> list2 = Arrays.asList(0, 1, 1, 1);
		List<Integer> list3 = Arrays.asList(1, 0, 0, 1);
		List<List<Integer>> lists = Arrays.asList(list1, list2, list3);
		System.out.println(countConnections(lists));

	}

}
