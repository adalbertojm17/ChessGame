package aavv;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Rook extends ChessPiece {
	
	public Rook(int row, int col, ChessColor color) {
		super(row, col, color);
		if (color== ChessColor.WHITE) {
			photo = new JLabel(new ImageIcon("whiterook.png"));
		}
		else
			photo = new JLabel(new ImageIcon("blackrook.png"));
	
	}

	@Override
	boolean move(int newRow, int newCol, ChessPiece[][] board) {
		int tempCol = col;
		int tempRow = row;
		if (onBoard(newRow, newCol) == false )
			return false; 
		
		
		if (newRow == row ) {
			
			if (newCol< col)
				while(tempCol >= newCol) {
					
					if( tempCol==newCol){
						if(board[newRow][newCol] != null && (board[newRow][newCol].color.equals(board[row][col].color))) {
						return false;
						}
						else 
							board[newRow][newCol] =  board[row][col];
				           board[row][col]= null;
							row = newRow;
							 col= newCol;
							return true;
					}
					
					if (board[row][tempCol] !=null && tempCol!= col) {
						return false ;
					}
				
					
					tempCol--;
				}
			else 
				
				while(tempCol <= newCol) {
					if( tempCol == newCol){
						if(board[newRow][newCol] != null && (board[newRow][newCol].color.equals(board[row][col].color))) {
							return false;
							}
							else 
								
								board[newRow][newCol] =  board[row][col];
					           board[row][col]= null;
								row = newRow;
								 col= newCol;
								return true;
						
					}
					
					
					if (board[row][tempCol+1] !=null) {
						return false ;
					}
					
					
					tempCol++;
				}
				
		}
		else if( newCol == col) {
			
			if (newRow< row) {
				while(tempRow >= newRow) {
					
					if( tempRow==newRow){
						if(board[newRow][newCol] != null && (board[newRow][newCol].color.equals(board[row][col].color))) {
							return false;
							}
							else 
								
								board[newRow][newCol] =  board[row][col];
					           board[row][col]= null;
								row = newRow;
								 col= newCol;
								return true;
					}
					
					if (board[tempRow ][col] !=null && tempRow!= row) {
						return false ;
					}
					
					
					tempRow--;
				}
			}
			else 
				
				while(tempRow <= newRow) {
					
					if( tempRow==newRow){
						if(board[newRow][newCol] != null && (board[newRow][newCol].color.equals(board[row][col].color))) {
							return false;
							}
							else 
								board[newRow][newCol] =  board[row][col];
					           board[row][col]= null;
								row = newRow;
								 col= newCol;
								return true;
					}
					
					
					
					if (board[tempRow+1][col] !=null && tempCol!= col) {
						return false ;
					}
					
					tempRow++;
				}
			
			
			
			
		}
	
		
		return false;
	}

}
