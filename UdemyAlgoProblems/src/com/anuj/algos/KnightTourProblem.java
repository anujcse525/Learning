package com.anuj.algos;

public class KnightTourProblem {

	private int size;
	private int[][] solutionMatrix;
	private int[] xMoves = { 1, 1, 2, 2, -1, -1, -2, -2 };
	private int[] yMoves = { 2, -2, 1, -1, 2, -2, 1, -1 };

	public static void main(String[] args) {

	}

	public KnightTourProblem(int size) {
		this.size = size;
		this.solutionMatrix = new int[size][size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				solutionMatrix[i][j] = -1;
			}
		}
	}
	
	public void solveTourProblem(){
		solutionMatrix[0][0] = 1;
		
		/*if(solve(1, 0, 0)){
			showTourPath();
		}
		else{
			System.out.println("Not feasible solution..");
		}*/
	}

	private void showTourPath() {
		for(int i=0; i<size; i++){
			
		}
		
	}
}
