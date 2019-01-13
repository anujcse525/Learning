package com.accolite;

public class SortingPractise {

	public static void main(String[] args) {
		int[] prices = { 50, 20, 10, 60, 30, 1 };
		sortToys(prices);
		for (int t : prices) {
			System.out.print(" " + t + " ");
		}
		System.out.println();
		System.out.println(maximumToys(prices, 31));
	}

	static int maximumToys(int[] prices, int k) {
        sortToys(prices);
        int count = 0, temp = 0;;
        while((temp += prices[count]) <= k)
            count++;
        return count;
    }
	
	static void sortToys(int[] prices) {
		boolean isSwap = false;
		for (int j = 1; j < prices.length; j++) {
			int temp = prices[j];
			int i = j - 1;
			isSwap = false;
			while (prices[i] > temp) {
				prices[i + 1] = prices[i--];
				isSwap = true;
				if(i < 0)
					break;
				
			}
			if (isSwap) {
				prices[++i] = temp;
			}
		}
	}

}
