package com.altimetrik.NPrimeTableGenerator;

/**
 * 
 * @author anujkumar
 *	Here, I need to create a table of first 10 Prime numbers.
 *	Output needs to be like shown below:
 *	2      | 3      | 5      | 7      | 11     | 13     | 17     | 19     | 23     | 29     | 
 *	4      | 6      | 10     | 14     | 22     | 26     | 34     | 38     | 46     | 58     | 
 *	6      | 9      | 15     | 21     | 33     | 39     | 51     | 57     | 69     | 87     | 
 *	8      | 12     | 20     | 28     | 44     | 52     | 68     | 76     | 92     | 116    | 
 *	10     | 15     | 25     | 35     | 55     | 65     | 85     | 95     | 115    | 145    | 
 *	12     | 18     | 30     | 42     | 66     | 78     | 102    | 114    | 138    | 174    | 
 *	14     | 21     | 35     | 49     | 77     | 91     | 119    | 133    | 161    | 203    | 
 *	16     | 24     | 40     | 56     | 88     | 104    | 136    | 152    | 184    | 232    | 
 *	18     | 27     | 45     | 63     | 99     | 117    | 153    | 171    | 207    | 261    | 
 *	20     | 30     | 50     | 70     | 110    | 130    | 170    | 190    | 230    | 290    | 
 */

public class NPrimeNumbersTable {

	/**
	 * 
	 * @param args : Number of prime numbers
	 * Main method to generate a table of prime numbers
	 */
	public static void main(String[] args) {
		System.out.println("******************************************************");
		System.out.println("***** Welcome to Prime numbers table generator *****");
		System.out.println("******************************************************");

		int primeNumberTableSize = 10/*Integer.parseInt(args[0])*/;
		System.out.println("OK you want prime number table for " + primeNumberTableSize + " prime numbers.");

		if (primeNumberTableSize <= 0) {
			System.out.println("Table size should be greater than 0");
			return;
		}

		primeNumberTableGenerator(primeNumberTableSize);

	}

	/**
	 * 
	 * @param primeNumberTableSize: Numbers of prime numbers for which I need to create a table
	 */
	public static void primeNumberTableGenerator(int primeNumberTableSize) {
		int[] primeNums = primeNumbersGenerator(primeNumberTableSize);

		int[][] table = createTable(primeNums);

		diplayTable(table);
	}

	/**
	 * 
	 * @param num Number of prime numbers
	 * @return An array of prime numbers
	 */
	public static int[] primeNumbersGenerator(int num) {
		int[] primes = new int[num];
		int count = 0;
		int number = 2;
		while (count < num) {
			boolean isPrime = true;
			for (int j = 2; j <= Math.sqrt(number); j++) {
				if (number % j == 0) {
					isPrime = false;
					break;
				}
			}
			if (isPrime) {
				primes[count++] = number;
			}
			number++;
		}

		return primes;
	}

	/**
	 * 
	 * @param primeNumbers array of prime numbers
	 * @return A table of prime numbers
	 */
	public static int[][] createTable(int[] primeNumbers) {
		int[][] table = new int[10][primeNumbers.length];
		for (int i = 0; i < 10; i++) {
			for (int p = 0; p < primeNumbers.length; p++) {
				table[i][p] = primeNumbers[p] * (i + 1);
			}
		}
		return table;
	}

	/**
	 * Display table
	 * @param table
	 */
	public static void diplayTable(int[][] table) {
		int tabIndex = 0;
		for (tabIndex = 0; tabIndex < table.length ; tabIndex++) {
			int[] arr = table[tabIndex];
			for (int a : arr) {
				System.out.format("%-6d | ", a);
			}
			System.out.println();
		}
	}

}