package com.anuj.hackerrank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;

public class CommonSubstring {
	// Complete the twoStrings function below.
	static String twoStrings(String s1, String s2) {
		char[] str1Char = s1.toCharArray();
		char[] str2Char = s2.toCharArray();
		if (str1Char.length == 0 || str2Char.length == 0) {
			return "NO";
			
		}

		HashSet<Character> setStr1 = new HashSet<Character>();
		for(char ch: str1Char){
			setStr1.add(ch);
		}
		
		for(char ch : str2Char){
			if(setStr1.contains(ch)){
				return "YES";
			}
		}
		return "NO";

	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		//BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int q = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int qItr = 0; qItr < q; qItr++) {
			String s1 = scanner.nextLine();

			String s2 = scanner.nextLine();

			String result = twoStrings(s1, s2);

			System.out.println(result);
			//bufferedWriter.write(result);
			//bufferedWriter.newLine();
		}

//		bufferedWriter.close();

		scanner.close();
	}
}
