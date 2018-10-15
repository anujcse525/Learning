package com.anuj.hackerrank;

import java.util.Arrays;
import java.util.Scanner;

public class SherlockAnagram {

	static SherlockAnagram ob = new SherlockAnagram();

	static int sherlockAndAnagrams(String s) {
		char[] sa;
		int c = 0;
		sa = s.toCharArray();
		for (int index = 1; index < sa.length; index++) {
			for (int i = 0; i < sa.length - index + 1; i++) {
				String s1 = s.substring(i, index + i);
				for (int j = i + 1; j < sa.length - index + 1; j++) {
					String s2 = s.substring(j, index + j);
					// System.out.println(s1+" "+s2);
					if (ob.check_anagram(s1, s2) == 1)
						c++;
				}
			}
		}
		return c;
	}

	public int check_anagram(String s1, String s2) {
		char a[] = s1.toCharArray();
		char b[] = s2.toCharArray();
		// System.out.println(s1+" "+s2);
		int first[] = new int[26];
		int second[] = new int[26];
		Arrays.fill(first, 0);
		Arrays.fill(second, 0);
		int c = 0;
		while (c < a.length) {
			first[a[c] - 'a']++;
			c++;
		}
		c = 0;
		while (c < b.length) {
			second[b[c] - 'a']++;
			c++;
		}

		for (c = 0; c < 26; c++) {
			if (first[c] != second[c])
				return 0;
		}

		return 1;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		String s = sc.nextLine();
		while (t > 0) {
			s = sc.nextLine();

			System.out.println(sherlockAndAnagrams(s));
			t--;
		}
		sc.close();
	}
}
