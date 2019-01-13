package com.anuj.algos;

public class HamiltonianCycle {

	public static void main(String[] args) {
		int[][] mat = { { 0, 1, 0, 1, 0 }, { 1, 0, 1, 0, 0 }, { 0, 1, 0, 1, 1 }, { 1, 0, 1, 0, 1 }, {0, 0, 1, 1, 0} };
		HamiltonianCycle ham = new HamiltonianCycle(mat);
	}

	private int[][] adjacencyMatrix;
	private int[] hamiltonianPath;
	private int numOfVertices;

	public HamiltonianCycle(int[][] adMatrix) {
		this.adjacencyMatrix = adMatrix;
		this.hamiltonianPath = new int[adMatrix.length];
		this.numOfVertices = adMatrix.length;

		hamiltonianPath[0] = 0;

		if (feasibleSolution(1)) {
			showHamiltonianPath();
		} else {
			System.out.println("Not feasible solution ...");
		}
	}

	private boolean feasibleSolution(int position) {

		if (position == numOfVertices) {
			if (adjacencyMatrix[hamiltonianPath[position - 1]][hamiltonianPath[0]] == 1) {
				return true;
			} else
				return false;
		}

		for (int vertexIndex = 1; vertexIndex < numOfVertices; vertexIndex++) {
			if (isFeasible(vertexIndex, position)) {
				hamiltonianPath[position] = vertexIndex;

				if (feasibleSolution(position + 1)) {
					return true;
				}
			}
		}
		return false;

	}

	private boolean isFeasible(int vertexIndex, int position) {

		if (adjacencyMatrix[hamiltonianPath[position - 1]][vertexIndex] == 0) {
			return false;
		}

		for (int i = 0; i < position; i++) {
			if (hamiltonianPath[i] == vertexIndex) {
				return false;
			}
		}
		return true;
	}

	private void showHamiltonianPath() {
		System.out.println("Hamiltonian cycle : ");

		for (int i = 0; i < numOfVertices; i++) {
			System.out.print(hamiltonianPath[i] + " -- ");
		}

		System.out.println(hamiltonianPath[0]);
	}

}
