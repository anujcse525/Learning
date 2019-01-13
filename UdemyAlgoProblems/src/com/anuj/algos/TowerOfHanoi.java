package com.anuj.algos;

public class TowerOfHanoi {

	public static void main(String[] args) {
		solveTowerOfHanoi(6);

	}

	public static void solveTowerOfHanoi(int discs) {
		solveTowerOfHanoi(discs, 'A', 'B', 'C');
	}

	private static void solveTowerOfHanoi(int discs, char from, char aux, char to) {
		if (discs == 1) {
			System.out.println("Moved disc 1 from " + from + " to " + to);
			return;
		}

		solveTowerOfHanoi(discs - 1, from, to, aux);

		System.out.println("Moved disc " + discs + " from " + from + " to " + to);

		solveTowerOfHanoi(discs - 1, aux, from, to);
	}

}
