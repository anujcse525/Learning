package com.anuj.algos;

public class ColorProblem {

	private int[][] adjacencyMatrix;
	private int numOfColors;
	private int[] colors;
	private int numberOfVerices;

	public ColorProblem(int[][] matrix, int colors) {
		this.adjacencyMatrix = matrix;
		this.numberOfVerices = matrix.length;
		this.numOfColors = colors;
		this.colors = new int[matrix.length];
	}

	public static void main(String[] args) {
		int[][] matrix = { { 0, 1, 0, 0, 1, 1 }, { 1, 0, 1, 1, 0, 1 }, { 0, 1, 0, 1, 0, 0 }, { 0, 1, 1, 0, 1, 1 },
				{ 1, 0, 0, 1, 0, 1 }, { 1, 1, 0, 1, 1, 0 } };
		ColorProblem colorProb = new ColorProblem(matrix, 5);
		colorProb.solve();
	}

	private void solve() {
		colors[0] = 0;
		if (solveColorProblem(1)) {
			showResults();
		} else {
			System.out.println("No Solutions ...");
		}
	}

	private boolean solveColorProblem(int vertexIndex) {
		if (vertexIndex == numberOfVerices) {
			return true;
		}

		for (int colorIndex = 0; colorIndex < numOfColors; colorIndex++) {
			if (isColorValid(colorIndex, vertexIndex)) {
				colors[vertexIndex] = colorIndex;

				if (solveColorProblem(vertexIndex + 1)) {
					return true;
				}
			}
		}

		return false;
	}

	private boolean isColorValid(int colorIndex, int vertexIndex) {
		for (int i = 0; i < numberOfVerices; i++) {
			if (adjacencyMatrix[vertexIndex][i] == 1 && colors[i] == colorIndex) {
				return false;
			}
		}
		return true;
	}

	private void showResults() {
		for (int i = 0; i < numberOfVerices; i++) {
			System.out.println("Node " + (i + 1) + " has color index " + colors[i]);
		}
	}
}
