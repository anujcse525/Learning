package com.searching;

import java.util.Random;

public class QuickSelect {

	private int[] nums;

	public static void main(String[] args) {
		QuickSelect qSel = new QuickSelect(new int[] { 1, 3, 4, 5, 8, 9, 10 });
		System.out.println(qSel.select(0));
	}

	public QuickSelect(int[] nums) {
		this.nums = nums;
	}

	private void swap(int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	public int select(int item) {
		return select(0, nums.length-1, item - 1);
	}

	private int select(int firstIndex, int lastIndex, int item) {
		int pivot = partition(firstIndex, lastIndex);

		if (pivot > item) {
			return select(firstIndex, pivot - 1, item);
		} else if (pivot < item) {
			select(pivot + 1, lastIndex, item);
		}
		return nums[item];

	}

	private int partition(int firstIndex, int lastIndex) {
		int pivot = new Random().nextInt(lastIndex - firstIndex + 1) + firstIndex;
		swap(lastIndex, pivot);

		for (int index = firstIndex; index < lastIndex; index++) {
			if (nums[index] > nums[lastIndex]) {
				swap(index, firstIndex);
				firstIndex++;
			}
		}

		swap(firstIndex, lastIndex);
		return firstIndex;
	}
}
