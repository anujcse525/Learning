package com.anuj.interviewCamp;

public class ReverseString {

	public static void main(String[] args) {
		String str = "My name is khan";
		System.out.println("Initial length : " + str.length() + " -- " + str);
		String rev = reverseString("My name is khan");
		System.out.println("Reverse length : " + rev.length() + " -- " + rev);
	}

	public static String reverseString(String S) {
		StringBuilder sb = new StringBuilder();

		int wordEnd = S.length();
		int i = S.length() - 1;

		for (; i >= 0; i--) {
			if (S.charAt(i) == ' ') {
				if (sb.length() > 0) {
					sb.append(' ');
				}
				sb.append(S.substring(i+1, wordEnd));
				wordEnd = i;
			}
		}

		String firstWord = S.substring(0, wordEnd);
		if (firstWord != null && firstWord.length() > 0) {
			if (sb.length() > 0) {
				sb.append(' ');
			}
			sb.append(firstWord);
		}
		return sb.toString();
	}

}
