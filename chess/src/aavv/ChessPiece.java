package aavv;

import javax.swing.JLabel;

abstract class ChessPiece
{
	protected int row;
	protected int col;
	protected ChessColor color;
	private boolean captured;
	public static final int GRID_SIZE = 8;
	protected JLabel photo;
	
	public ChessPiece(int row,int col,ChessColor color)
	{
		this.row = row;
		this.col = col;
		this.color = color;
		
	}
	
	abstract boolean move(int newRow,int newCol,ChessPiece[][] board);
	
	public boolean onBoard(int newRow,int newCol)
	{
		return newRow >= 0 && newRow < GRID_SIZE && newCol >= 0 && newCol < GRID_SIZE;
	}
	
	public void capture()
	{
		
	}
	

	public String toString()
	{
		return "ChessPiece [row=" + row + ", col=" + col + ", color=" + color + ", captured=" + captured + "]";
	}
	
	
}
