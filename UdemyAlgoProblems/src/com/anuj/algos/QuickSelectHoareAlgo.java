package com.anuj.algos;

import java.util.Random;

public class QuickSelectHoareAlgo {

	private int[] nums;

	public static void main(String[] args) {
		int[] numbers = { 23, 45, 12, 11, 9, 56, 78, 44 };
		QuickSelectHoareAlgo quiceSelect = new QuickSelectHoareAlgo(numbers);
		System.out.println(quiceSelect.select(9));
	}

	public QuickSelectHoareAlgo(int[] nums) {
		this.nums = nums;
	}

	public int select(int num) {
		if (num > nums.length)
			return -1;
		return select(0, nums.length - 1, num);
	}

	private int select(int first, int last, int orderToFind) {
		int pivot = partition(first, last);

		if (pivot > orderToFind - 1) {
			return select(first, pivot, orderToFind);
		} else if (pivot < orderToFind - 1) {
			return select(pivot, last, orderToFind);
		} else {
			return nums[pivot];
		}

	}

	private int partition(int first, int last) {
		int pivot = new Random().nextInt(last - first + 1) + first;

		swap(pivot, last);

		for (int i = first; i < last; i++) {
			if (nums[i] > nums[last]) {
				swap(i, first);
				first++;
			}
		}
		swap(first, last);

		return first;
	}

	private void swap(int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

}
