package N_Queens;


import java.util.ArrayList;
// Exact solution required
import javax.swing.plaf.synth.SynthSeparatorUI;

public class NQueenBackTracking {
	public ArrayList<String[]> solveNQueens(int n) {
		ArrayList<String[]> result = new ArrayList<String[]>();
		ArrayList<Integer> cols = new ArrayList<Integer>();
		if (n <= 0) {
			return result;
		}

		search(result, cols, n);

		return result;
	}

	public void search(ArrayList<String[]> result, ArrayList<Integer> cols, int n) {
		if (cols.size() == n) {
			result.add(drawChessBoard(cols));
			return;
		}

		for (int col = 0; col < n; col++) {
			if (!isValid(cols, col)) {
				continue;
			}

			cols.add(col);
			search(result, cols, n);
			cols.remove(cols.size() - 1);
		}
	}

	public boolean isValid(ArrayList<Integer> cols, int col) {
		int row = cols.size(); // this will be the index of new col.
		for (int i = 0; i < row; i++) {
			// Same column
			if (cols.get(i) == col) {
				return false;
			}
			// left-top to right-bottom
			if (i - cols.get(i) == row - col) {
				return false;
			}
			// right-top to left-bottom
			if (i + cols.get(i) == row + col) {
				return false;
			}
		}
		return true;
	}
// drawing column col by col
	public String[] drawChessBoard(ArrayList<Integer> cols) {
		String[] chessBoard = new String[cols.size()];

		for (int i = 0; i < cols.size(); i++) {
			chessBoard[i] = "";
			for (int j = 0; j < cols.size(); j++) {
				if (j == cols.get(i)) {
					chessBoard[i] += " Q ";
				} else {
					chessBoard[i] += " X ";
				}
			}
		}

		return chessBoard;
	}

	public static void main(String[] args){
		NQueenBackTracking nQ=new NQueenBackTracking();
		ArrayList<String[]> result = new ArrayList<String[]>();
		result=nQ.solveNQueens(4); //number of chess queens
		
		for(int i=0;i<result.size();i++){
		String[] s=result.get(i);
		for(int j=0;j<s.length;j++){
			System.out.println(s[j]+ " ");
		}
		System.out.println(" ");
		}
		//nQ.solveNQueens(4);
	}
}
