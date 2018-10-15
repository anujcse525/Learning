package com.anuj.hackerrank;

import java.util.Scanner;

class MaxSum {
	public static void main(String args[])  {

		/*
		 * BufferedReader br = new BufferedReader(new
		 * InputStreamReader(System.in)); String input = br.readLine(); int
		 * inputs = Integer.parseInt(input); String[] inStr = new
		 * String[inputs]; int[] inArr = new int[inputs]; int inputSum = 0; int
		 * numToUpdate = 0; int maxSum = Integer.MAX_VALUE;
		 * 
		 * inStr = br.readLine().split(" "); for (int i = 0; i < inputs; i++) {
		 * inArr[i] = Integer.parseInt(inStr[i]); inputSum += inArr[i]; } int
		 * len = inArr.length;
		 * 
		 * for (int i = 0; i < len; i++) { int currSum = inArr[i] * len; if
		 * (currSum > inputSum && currSum < maxSum) { maxSum = currSum;
		 * numToUpdate = inArr[i];
		 * 
		 * } } System.out.println(numToUpdate); br.close();
		 */
		
		Scanner scan = new Scanner(System.in);
		int num1 = scan.nextInt();
		int num2 = scan.nextInt();
		int count =0;
		while(num1 >= 0){
			if(num2 % num1 == 0){
				count++;
				int temp = num2/num1;
				num2 = num1;
				num1 = temp;
			}
			
		}
		System.out.println(count);
		scan.close();
	}
}
