package com.searching;

public class SearchAlgo {

	public static int[] numArray = { 2, 4, 6, 8, 10, 12, 14, 15, 16, 18, 20, 21, 22, 23, 24, 26 };

	public static void main(String[] args) {
		// System.out.println(linearSearch(12));
		// System.out.println(linearSearch(11));
		// System.out.println(binarySearch(0, numArray.length-1, 12));
		long start = System.currentTimeMillis();
		System.out.println(binarySearch(25));
		System.out.println("time taken : " + (System.currentTimeMillis() - start));
		start = System.currentTimeMillis();
		System.out.println(recBinarySearch(0, numArray.length -1, 25));
		System.out.println("time taken : " + (System.currentTimeMillis() - start));
	}

	public static int linearSearch(int item) {
		for (int i = 0; i < numArray.length; i++) {
			if (numArray[i] == item) {
				return i;
			}
		}

		return -1;
	}

	public static int binarySearch(int item) {
		int startIndex = 0;
		int endIndex = numArray.length - 1;
		if (item < numArray[startIndex] || item > numArray[endIndex]) {
			return -1;
		}
		while (startIndex < endIndex) {
			if (numArray[startIndex] == item) {
				return startIndex;
			}
			if (numArray[endIndex] == item) {
				return endIndex;
			}

			int midIndex = (startIndex + endIndex) / 2;

			if (midIndex == startIndex || midIndex == endIndex) {
				return -1;
			}

			if (numArray[midIndex] == item) {
				return midIndex;
			}

			if (item < numArray[midIndex]) {
				endIndex = midIndex;
			} else
				startIndex = midIndex;
		}

		return -1;
	}

	public static int recBinarySearch(int start, int end, int item) {
		if (item < numArray[start] || item > numArray[end]) {
			return -1;
		}

		if (end < start) {
			System.out.println("Item not found");
			return -1;
		}

		int mid = (start + end) / 2;
		
		if(numArray[mid] == item){
			return mid;
		}
		else if (item < numArray[mid]) {
			return recBinarySearch(start, mid -1 , item);
		} else {
			return recBinarySearch(mid + 1, end, item);
		}

	}
}
