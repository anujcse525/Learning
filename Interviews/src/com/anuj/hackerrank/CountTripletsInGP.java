package com.anuj.hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/*
 * You are given an array and you need to find number of tripets of indices (i, j, k) such that the elements at those indices are in geometric progression for a given common ratio r and i < j < k.
For example, arr= [1, 4, 16, 64]. if r=4, we have [1,4,16] and [4,16,64] at indices (0,1,2) and (1,2,3)
 */
/*5 5
1 5 5 25 125*/
public class CountTripletsInGP {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int r = sc.nextInt();
		List<Long> list = new ArrayList<Long>();
		long[] input = new long[n];
		for (int i = 0; i < n; i++) {
			long data = sc.nextLong();
			list.add(data);
			input[i] = data;
		}

		System.out.println(countTriplets(list, r));
		sc.close();
	}

	static long countTriplets(List<Long> arr, long r) {
		long cnt = 0;
		Map<Long, Long> map = new HashMap<>();
		Map<Long, Long> rMap = new HashMap<>();
		for (long n : arr) {
			if (n % r == 0) {
				long pre = n / r;
				Long cnt2 = rMap.get(pre);
				if (cnt2 != null)
					cnt += cnt2;

				Long cnt1 = map.get(pre);
				if (cnt1 != null)
					rMap.put(n, rMap.getOrDefault(n, 0L) + cnt1);
			}
			map.put(n, map.getOrDefault(n, 0L) + 1);
		}
		return cnt;
	}

}
