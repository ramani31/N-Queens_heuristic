package N_Queens;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

//https://www.openprocessing.org/sketch/131608
//import ApplicationForChess.ChessBoard;

public class NQueensSolutionTest extends JFrame {
	//public static final int squareCount = 64;

	public static void main(String[] args) throws InterruptedException {
		Scanner in = new Scanner(System.in);
		System.out.print("Solve NQueens For #Queens: ");
		int num = in.nextInt();
		new NQueensSolutionTest().execute(num);
		in.close();
	}

	private void execute(int num) throws InterruptedException {
		int[] board = new int[num];
		for (int i = 0; i < num; i++) {
			board[i] = i;
		}
		NQueensSolutionTest nq = new NQueensSolutionTest();
		while (!isFull(board)) {
			permute(board);

			if (isValid(board)) {
				System.out.println("Correct Board: " + Arrays.toString(board));
				nq.frameInit();
				nq.ChessBoardPrint(board);
				Thread.sleep(2500);
				// printBoard(board);
			}
		}
	}

	private boolean isFull(int[] board) {
		Set<Integer> set = new HashSet<>();
		for (int x : board) {
			set.add(x);
		}
		return set.size() == 1 && set.contains(board.length - 1);
	}

	private void permute(int[] board) {
		if (board[board.length - 1] != board.length - 1) {
			++board[board.length - 1];
			return;
		}

		int index = -1;
		for (index = board.length - 1; index >= 0; index--) {
			if (board[index] != board.length - 1) {
				break;
			}
		}

		if (index < 0) {
			return;
		}

		++board[index];
		for (int next = index + 1; next < board.length; next++) {
			board[next] = 0;
		}

		return;
	}

	// 2 0 3 1
	private void printBoard(int[] board) {
		System.out.println();
		for (int row = 0; row < board.length; row++) {
			for (int j = 0; j < board.length; j++) {
				System.out.print(board[row] == j ? " Q " : " X ");
				// if(board[row]==j){
				//
				//
				// ChessBoard cb=new ChessBoard(j);
				// }

			}
			System.out.println();
		}

	}

	public void ChessBoardPrint(int[] board) {
		int n = board.length;
		int squareCount = n * n;
		// Color of chess board this you can change accordingly like black or
		// white
		Color blackColor = Color.BLACK;
		Color whiteColor = Color.WHITE;
		Color redColor = Color.RED;
		JButton chessButton = null;
		int row = 0;
		int col = 0;

		if (n % 2 == 0) { // even
			for (int i = 1; i <= squareCount; i++) {
				// if (board.length % 2 == 0) {
				if (i % 2 == 0) { // Adding color based on the odd and even
					// initially.

					chessButton = new JButton();
					if (board[row] == col) {
						// Image img =
						// ImageIO.read(getClass().getResource("resources/water.bmp"));
					//////
						try {
							Image img = ImageIO.read(getClass().getResource("queen4.jpeg"));
							//image taken from shutterstock
							chessButton.setIcon(new ImageIcon(img));
						} catch (Exception ex) {
							// TODO Auto-generated catch block
							System.out.println(ex);
						}
						 chessButton.setText("Queen");
						chessButton.setBackground(redColor);
					} else {
						chessButton.setBackground(blackColor);
					}

					add(chessButton);
				} else {

					chessButton = new JButton();
					if (board[row] == col) {
						try {
							Image img = ImageIO.read(getClass().getResource("queen4.jpeg"));
							chessButton.setIcon(new ImageIcon(img));
						} catch (Exception ex) {
							// TODO Auto-generated catch block
							System.out.println(ex);
						}
						// chessButton.setText("Queen");
						chessButton.setBackground(redColor);
					} else {
						chessButton.setBackground(whiteColor);
					}
					// chessButton.setBackground();
					add(chessButton);
				}

				col++;
				if (i % n == 0) { // swapping the color when adding the next row

					Color temp = blackColor;
					blackColor = whiteColor;
					whiteColor = temp;
					row++;
					col = 0;
				}

			}
		} else {
			for (int i = 1; i <= squareCount; i++) {

				// if (board.length % 2 == 0) {
				if (i % 2 == 0) { // Adding color based on the odd and even
					// initially.

					chessButton = new JButton();
					if (board[row] == col) {
						try {
							Image img = ImageIO.read(getClass().getResource("queen4.jpeg"));
							chessButton.setIcon(new ImageIcon(img));
						} catch (Exception ex) {
							// TODO Auto-generated catch block
							System.out.println(ex);
						}
						 chessButton.setText("Queen");
						chessButton.setBackground(redColor);
						
						
						
					} else {
						chessButton.setBackground(blackColor);
					}
					// chessButton.setBackground(blackColor);
					add(chessButton);
				} else {

					chessButton = new JButton();
					if (board[row] == col) {
						try {
							Image img = ImageIO.read(getClass().getResource("queen4.jpeg"));
							chessButton.setIcon(new ImageIcon(img));
						} catch (Exception ex) {
							// TODO Auto-generated catch block
							System.out.println(ex);
						}
						 chessButton.setText("Queen");
						chessButton.setBackground(redColor);
					} else {
						chessButton.setBackground(whiteColor);
					}
					// chessButton.setBackground(whiteColor);
					add(chessButton);
				}

				col++;
				if (i + 1 % n == 0) { // swapping the color when adding the next
										// row

					Color temp = blackColor;
					blackColor = whiteColor;
					whiteColor = temp;

				}
				if (i % n == 0) {
					row++;
					col = 0;
				}

			}
		}

		System.out.println();
		for (row = 0; row < board.length; row++) {
			for (int j = 0; j < board.length; j++) {
				if (board[row] == j) {
					System.out.print(" Q ");

				} else {
					System.out.print(" X ");
				}
			}
			System.out.println();
		}

		this.setLayout(new GridLayout(n, n)); // GridLayout will arrange
												// elements in Grid Manager 8 X
												// 8
		this.setSize(650, 650); // Size of the chess board
		// drawQueen(650, 650,n);

		this.setVisible(true);

	}

	private boolean isValid(int[] board) {
		// to check if all values are distinct we use set
		Set<Integer> set = new HashSet<>();
		for (int x : board) {
			set.add(x);
		}
		if (set.size() != board.length) {
			return false;
		}

		// to check if left-top diagonal
		set = new HashSet<>();

		for (int i : board) {
			set.add(board[i] - i);
		}
		if (set.size() != board.length) {
			return false;
		}

		// to check for right-bottom diagonal
		set = new HashSet<>();

		for (int i : board) {
			set.add(board[i] + i);
		}
		if (set.size() != board.length) {
			return false;
		}

		return true;

	}

}
