package aavv;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class King extends ChessPiece {
	

	public King(int row, int col, ChessColor color) {
		super(row, col, color);
		if (color== ChessColor.WHITE) {
			photo = new JLabel(new ImageIcon("whiteking.png"));
		}
		else
			photo = new JLabel(new ImageIcon("blackking.png"));
	
	}

	@Override
	boolean move(int newRow, int newCol, ChessPiece[][] board) {
		int changeRow = Math.abs(newRow-row);
		int changeCol = Math.abs(newCol-col);
		if (onBoard(newRow, newCol) ==false )
			return false; 

			if (changeCol<=1 && changeRow<=1) {
			 if ( board[newRow][newCol] != null && (board[newRow][newCol].color.equals(board[row][col].color))) {
				return false ;
			 }
			 else  {
				 board[newRow][newCol] =  board[row][col];
		           board[row][col]= null;
					row = newRow;
					 col= newCol;
					 return true;
			}
				
				
				
			}
		
		
		
		
			return false;
	}

}
