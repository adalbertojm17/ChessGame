package aavv;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Horse extends ChessPiece {

	public Horse(int row, int col, ChessColor color) {
		super(row, col, color);
		if (color== ChessColor.WHITE) {
			photo = new JLabel(new ImageIcon("whiteknight.png"));
		}
		else
			photo = new JLabel(new ImageIcon("blackknight.png"));
	}

	@Override
	boolean move(int newRow, int newCol, ChessPiece[][] board) {
		int changeRow = Math.abs(newRow-row);
		int changeCol = Math.abs(newCol-col);
		if (newCol == col+2 && board[row][col+2] == null && changeRow == 1) {
			 board[newRow][newCol] =  board[row][col];
	           board[row][col]= null;
				row = newRow;
				 col= newCol;
			return true;
		}
		if (newCol == col-2 && board[row][col-2] == null && changeRow == 1) {
			 board[newRow][newCol] =  board[row][col];
	           board[row][col]= null;
				row = newRow;
				 col= newCol;
			return true ;
		}
		if(newRow == row+2 && board[row+2][col] == null && changeCol == 1 ) {
			
			 board[newRow][newCol] =  board[row][col];
	           board[row][col]= null;
				row = newRow;
				 col= newCol;
				 return true;
		}
		
		if(newRow == row-2 && board[row-2][col] == null && changeCol == 1 ) {
			 board[newRow][newCol] =  board[row][col];
	           board[row][col]= null;
				row = newRow;
				 col= newCol;
			return true;
		}
		
		return false;
	}

}
