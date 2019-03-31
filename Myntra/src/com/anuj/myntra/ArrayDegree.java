package com.anuj.myntra;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ArrayDegree {

	public static void main(String[] args) {
		int[] nums = new int[] { 1, 2, 2, 3, 1, 4, 2 };
		System.out.println(findShortestSubArrayApp(nums));
	}

	public static int findShortestSubArray(int[] nums) {
		Map<Integer, Integer[]> lookup = new HashMap<>();
		int degree = 0;
		int len = Integer.MAX_VALUE;
		for (int idx = 0; idx < nums.length; idx++) {
			Integer[] res = lookup.get(nums[idx]);
			if (res == null) {
				res = new Integer[] { 1, idx };
			}
			res[0]++;
			if (res[0] >= degree) {
				if (res[0] > degree) {
					degree = res[0];
					len = idx - res[1] + 1;
				} else {
					len = Math.min(len, idx - res[1] + 1);
				}
			}

			lookup.put(nums[idx], res);

		}
		return len;
	}
	
    public static int findShortestSubArrayApp(int[] nums) {
        Map<Integer, Integer> left = new HashMap<Integer, Integer>(),
            right = new HashMap<Integer, Integer>(), count = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            if (left.get(x) == null) left.put(x, i);
            right.put(x, i);
            count.put(x, count.getOrDefault(x, 0) + 1);
        }

        int ans = nums.length;
        int degree = Collections.max(count.values());
        for (int x: count.keySet()) {
            if (count.get(x) == degree) {
                ans = Math.min(ans, right.get(x) - left.get(x) + 1);
            }
        }
        return ans;
    }
}
