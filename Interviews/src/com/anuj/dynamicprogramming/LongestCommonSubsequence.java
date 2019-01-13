package com.anuj.dynamicprogramming;

import java.util.Scanner;

public class LongestCommonSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		String str1 = /* scan.nextLine() */"ABCDGH";
		String str2 = /* scan.nextLine() */"AEDFHR";

		System.out.println(lcs(str1, str2, str1.length(), str2.length()));
		scan.close();
	}

	private static String lcs(String str1, String str2, int length1, int length2) {
		int[][] memo = new int[length1 + 1][length2 + 1];
		int i = 0, j = 0;
		for (i=0; i <= length1; i++) {
			for (j=0; j <= length2; j++) {
				if (i == 0 || j == 0) {
					memo[i][j] = 0;
				} else if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
					memo[i][j] = 1 + memo[i - 1][j - 1];
				} else {
					memo[i][j] = Math.max(memo[i - 1][j], memo[i][j - 1]);
				}
			}
		}
		System.out.println("Lenght of LCS : " + memo[length1][length2]);

		char[] lcs = new char[memo[length1][length2]];

		/*i = length1;
		j = length2;
		int index = memo[i][j];
		while (i > 0 && j > 0) {
			if (str1.charAt(i - 1) == str2.charAt(j -1)) {
				lcs[index - 1] = str1.charAt(i - 1);
				i--;
				j--;
				index--;
			} else if (memo[i - 1][j] > memo[i][j - 1]) {
				i--;
			} else {
				j--;
			}
		}*/
		i=j=0;
		int index=0;
		while(i<length1 && j<length2){
			if(str1.charAt(i) == str2.charAt(j)){
				lcs[index++] = str1.charAt(i);
				i++;
				j++;
			}
			else if(memo[i+1][j] > memo[i][j+1]){
				j++;
			}
			else{
				i++;
			}
		}
		return new String(lcs);

	}

}
