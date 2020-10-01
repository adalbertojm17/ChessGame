package aavv;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Pawn extends ChessPiece {
	private boolean alreadymove;
	private final int startRow;
	JLabel pawn;

	public Pawn(int row, int col, ChessColor color) {
		super(row, col, color);
		startRow = row;
		if (color == ChessColor.WHITE) {
			photo = new JLabel(new ImageIcon("whitepawn.png"));
		} else
			photo = new JLabel(new ImageIcon("blackpawn.png"));
	}

	@Override
	boolean move(int newRow, int newCol, ChessPiece[][] board) {

		if (onBoard(newRow, newCol) == false)
			return false;

		if (startRow == 1) {
			if (newRow == row + 2 && alreadymove == false && board[newRow][newCol] == null && board[row+1][col] == null) {
				board[newRow][newCol] = board[row][col];
				board[row][col] = null;
				row = newRow;
				col = newCol;
				alreadymove = true;
				return true;
			}
			if (board[newRow][newCol] != null) {
				if (newRow == row + 1 && Math.abs(newCol - col) == 1
						&& !(board[newRow][newCol].color.equals(board[row][col].color))) {
					board[newRow][newCol] = board[row][col];
					board[row][col] = null;
					row = newRow;
					col = newCol;
					alreadymove = true;
					return true;
				}
			}
			if (newRow == row + 1 && newCol == col && board[newRow][newCol] == null) {
				board[newRow][newCol] = board[row][col];
				board[row][col] = null;
				row = newRow;
				col = newCol;
				alreadymove = true;
				return true;
			}
		}

		if (startRow == 6) {
			if (newRow == row - 2 && alreadymove == false && board[newRow][newCol] == null && board[row-1][col] == null ) {
				board[newRow][newCol] = board[row][col];
				board[row][col] = null;
				row = newRow;
				col = newCol;
				alreadymove = true;
				return true;
			}

			if (board[newRow][newCol] != null) {
				if (newRow == row - 1 && Math.abs(newCol - col) == 1
						&& !(board[newRow][newCol].color.equals(board[row][col].color))) {
					board[newRow][newCol] = board[row][col];
					board[row][col] = null;
					row = newRow;
					col = newCol;
					alreadymove = true;
					return true;
				}
			}

			if (newRow == row - 1 && newCol == col && board[newRow][newCol] == null) {
				board[newRow][newCol] = board[row][col];
				board[row][col] = null;
				row = newRow;
				col = newCol;
				alreadymove = true;
				return true;
			}

		}

		return false;
	}

}
