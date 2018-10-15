package com.anuj.hackerrank;

import java.util.HashMap;
import java.util.Scanner;

public class RansomNote {

	static void checkMagazine(String[] magazine, String[] note) {
		HashMap<String, Integer> magMap = new HashMap<String, Integer>();

		for (String mag : magazine) {
			if (magMap.containsKey(mag)) {
				magMap.put(mag, magMap.get(mag) + 1);
			} else {
				magMap.put(mag, 1);
			}
		}
		
		for(String no : note){
			if(magMap.containsKey(no)){
				if(magMap.get(no) == 1){
					magMap.remove(no);
				}
				else{
					magMap.put(no, magMap.get(no) - 1);
				}
			}
			else{
				System.out.println("No");
				return;
			}
		}
		System.out.println("Yes");
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		String[] mn = scanner.nextLine().split(" ");

		int m = Integer.parseInt(mn[0]);

		int n = Integer.parseInt(mn[1]);

		String[] magazine = new String[m];

		String[] magazineItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < m; i++) {
			String magazineItem = magazineItems[i];
			magazine[i] = magazineItem;
		}

		String[] note = new String[n];

		String[] noteItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			String noteItem = noteItems[i];
			note[i] = noteItem;
		}

		checkMagazine(magazine, note);

		scanner.close();
	}

}
