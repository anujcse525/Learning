package com.anuj.algos;

import java.util.Arrays;

/**
 * To find index of a pattern in a String
 * 
 * @author anujkumar
 *
 */
public class KnuthMorrisPrattAlgo {

	public static void main(String[] args) {

		KnuthMorrisPrattAlgo kmp = new KnuthMorrisPrattAlgo();

		String pattern = "ababac";

		int[] expected = new int[] { 0, 0, 1, 2, 3, 0 };

		int[] result = kmp.computeLSPTable(pattern);

		if (Arrays.equals(expected, result)) {
			System.out.println("Yes");
		}

		String input = "abazacabababac";
		pattern = "ababac";

		System.out.println(kmp.searchPattern(input, pattern));
	}

	/**
	 * This method returns the index for the first match of the pattern into the
	 * index. It will return -1 in case it does not match
	 *
	 * <pre>
	 *                 i
	 * 0 1 2 3 4 5 6 7 8 9 10111213
	 * a b a z a c a b a b a b a c
	 *
	 *                 a b a b a c
	 *                 0 0 1 2 3 0
	 *                           j
	 * this example returns index of 8
	 * </pre>
	 *
	 * @param array
	 * @param pattern
	 * @return
	 */

	public int searchPattern(String input, String pattern) {
		char[] inputArr = input.toCharArray();
		char[] patternArr = pattern.toCharArray();
		int[] lspTable = computeLSPTable(pattern);

		int j = 0;
		for (int i = 0; i < input.length(); i++) {
			while (j > 0 && patternArr[j] != inputArr[i]) {
				j = lspTable[j - 1];
			}
			if (patternArr[j] == inputArr[i]) {
				j++;
				if (j == patternArr.length) {
					return (i - (j - 1));
				}
			}
		}
		return -1;
	}

    /**
     * This computes the table of the longest suffix and longest preffix on the pattern.
     * This is to be used by Knuth-Morris-Pratt main method of the algorithm
     *
     *
     * @param pattern
     * @return
     */
	public int[] computeLSPTable(String pattern) {
		if (pattern == null || pattern.isEmpty()) {
			return null;
		}
		char[] pat = pattern.toCharArray();
		int[] lspTable = new int[pat.length];

		int j = 0;
		for (int i = 1; i < pattern.length(); i++) {
			while (j > 0 && pat[i] != pat[j]) {
				j = lspTable[j - 1];
			}
			if (pat[i] == pat[j]) {
				lspTable[i] = j + 1;
				j++;
			} else {
				lspTable[i] = 0;
			}
		}

		return lspTable;
	}
}
