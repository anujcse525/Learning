package com.anuj.backtracking;

public class NQueenProblem {

	public static void main(String[] args) {
		NQueenProblem nQueenProb = new NQueenProblem();
		Position[] positions = nQueenProb.solveNQueenProblem(4);
		if(positions != null){
			for(Position pos : positions){
				System.out.println(pos);
			}
		}
	}

	class Position {
		int row, column;

		public Position(int r, int c) {
			this.row = r;
			this.column = c;
		}

		@Override
		public String toString() {
			return "Position [row=" + row + ", column=" + column + "]";
		}

	}

	public Position[] solveNQueenProblem(int n) {
		Position[] positions = new Position[n];
		boolean hasSolution = solveNQueenProblem(n, 0, positions);
		if (hasSolution) {
			return positions;
		}

		return null;
	}

	private boolean solveNQueenProblem(int n, int row, Position[] positions) {

		if (n == row) {
			return true;
		}

		int col;
		for (col = 0; col < n; col++) {
			boolean foundSafe = true;

			for (int queen = 0; queen < row; queen++) {
				if (positions[queen].column == col || (positions[queen].column + positions[queen].row) == (row + col)
						|| (positions[queen].row - positions[queen].column) == (row - col))
					foundSafe = false;
			}

			if (foundSafe) {
				positions[row] = new Position(row, col);
				if (solveNQueenProblem(n, row + 1, positions))
					return true;
			}
		}
		return false;
	}
}
