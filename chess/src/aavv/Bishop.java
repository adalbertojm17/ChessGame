package aavv;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Bishop extends ChessPiece {

	public Bishop(int row, int col, ChessColor color) {
		super(row, col, color);
	
		if (color== ChessColor.WHITE) {
			photo = new JLabel(new ImageIcon("whitebishop.png"));
		}
		else
			photo = new JLabel(new ImageIcon("blackbishop.png"));

	}

	@Override
	boolean move(int newRow, int newCol, ChessPiece[][] board) {
		if (onBoard(newRow, newCol)==false )
			return false; 
		int changeRow= Math.abs(row-newRow);
		int changeCol= Math.abs(col-newCol);
		int tempRow =row;
		int tempCol =col;
			if (changeRow==changeCol) {
				if(row-newRow == col-newCol&& newRow<row){
					tempRow--;
					tempCol--;
			while (tempRow >= newRow ) {
			
				if(board[tempRow][tempCol] != null&& tempRow != newRow && tempCol != newCol ) {
					return false;
					}
				
					if(tempRow == newRow && tempCol == newCol) {
						if(board[tempRow][tempCol]==null||!board[tempRow][tempCol].color.equals(board[row][col].color)) {
							board[newRow][newCol] =  board[row][col];
				         board[row][col]= null;
							row = newRow;
							 col= newCol;
							 return true;
						}
					}
					tempRow--;
					tempCol--;
				}
			}
			
				if(row-newRow == col-newCol&& newRow>row) {
					System.out.println("2");
					tempRow++;
					tempCol++;
					while (tempRow <= newRow ) {
						if(board[tempRow][tempCol] != null && tempRow != newRow && tempCol != newCol ) {
							return false;
						}
						if(tempRow == newRow && tempCol == newCol) {
							if( board[tempRow][tempCol]==null||!board[tempRow][tempCol].color.equals(board[row][col].color)) {
								board[newRow][newCol] =  board[row][col];
						         board[row][col]= null;
									row = newRow;
									 col= newCol;
									 return true;
							}
						}
						tempRow++;
						tempCol++;
					}
					
				}
				if(Math.abs(row-newRow) == col-newCol&& newRow>row) {
					tempRow++;
					tempCol--;
					System.out.println("3");
					while (tempRow <= newRow ) {
						if(board[tempRow][tempCol] != null&& tempRow != newRow && tempCol != newCol ) {
							return false;
						}
						if(tempRow == newRow && tempCol == newCol) {
							if( board[tempRow][tempCol]==null||!board[tempRow][tempCol].color.equals(board[row][col].color)) {
								board[newRow][newCol] =  board[row][col];
						         board[row][col]= null;
									row = newRow;
									 col= newCol;
									 return true;
							}
						}
						tempRow++;
						tempCol--;
					}		
				}
				if(row-newRow == Math.abs(col-newCol)&& newRow<row) {
					System.out.println("4");
					tempRow--;
					tempCol++;
					while (tempRow >= newRow ) {
						if(board[tempRow][tempCol] != null&& tempRow != newRow && tempCol != newCol ) {
							return false;
						}
						if(tempRow == newRow && tempCol == newCol) {
							if( board[tempRow][tempCol]==null||!board[tempRow][tempCol].color.equals(board[row][col].color)) {
								board[newRow][newCol] =  board[row][col];
						         board[row][col]= null;
									row = newRow;
									 col= newCol;
									 return true;
							}
						}
						tempRow--;
						tempCol++;
					}		
				}
			}
		
		
		
		
		return false;
	}

}
