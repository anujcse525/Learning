package com.anuj.hackerrank;

public class StringReverseWithoutExtraVariable {

	public static String reverseStrRec(String str) {
		if (str.length() <= 1) {
			return str;
		}

		return reverseStrRec(str.substring(1)) + str.charAt(0);

	}

	static String reverseStr(char[] str) {
		int start = 0;
		int end = str.length - 1;

		while (start < end) {
			str[start] = (char) (str[start] ^ str[end]);
			str[end] = (char) (str[start] ^ str[end]);
			str[start] = (char) (str[start] ^ str[end]);
			start++;
			end--;
		}
		return new String(str);

	}

	public static void main(String[] args) {
		//System.out.println(reverseStrRec("ANUJ"));
		//System.out.println(reverseStr("XYZAVC".toCharArray()));
		System.out.println((char) 32);
	}

}
