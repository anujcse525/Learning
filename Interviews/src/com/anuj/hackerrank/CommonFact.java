package com.anuj.hackerrank;

import java.util.Scanner;

public class CommonFact {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int num1 = scan.nextInt();
		int num2 = scan.nextInt();
		int count = 1;
		while (num1 > 1) {
			if (num2 % num1 == 0) {
				count++;
				int temp = num2 / num1;
				num2 = num1;
				num1 = temp;
			} else {
				int temp = num2 % num1;
				num2 = num1;
				num1 = temp;
			}
		}
		System.out.println(count);
		scan.close();
	}

}
