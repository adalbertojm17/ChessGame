package aavv;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Queen extends ChessPiece {

	public Queen(int row, int col, ChessColor color) {
		super(row, col, color);
		if (color== ChessColor.WHITE) {
			photo = new JLabel(new ImageIcon("whitequeen.png"));
		}
		else
			photo = new JLabel(new ImageIcon("balckqueen.png"));

	}

	@Override
	boolean move(int newRow, int newCol, ChessPiece[][] board) {
		if (onBoard(newRow, newCol)==false )
			return false; 
		int tempCol = col;
		int tempRow = row;
		int changeRow= Math.abs(row-newRow);
		int changeCol= Math.abs(col-newCol);
		
		if (changeRow==changeCol) {
			if(row-newRow == col-newCol&& newRow<row){
				tempRow--;
				tempCol--;
		while (tempRow >= newRow ) {
			System.out.println("1");
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
