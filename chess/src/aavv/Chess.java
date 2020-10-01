package aavv;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
public class Chess extends JFrame  {
	
	static JPanel chessBoard;
	static ChessPiece[][] board;
	JLabel gray;
	static JLabel white;
	int i =0;
	int j =0;
	int Row =0;
	int Col=0;
	JLabel[] spaces;
	int position=0;
	StageChess state = StageChess.WhiteWaiting;
	public Chess() throws FileNotFoundException
	{
		
		setSize(700, 700);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		chessBoard = new JPanel(new GridLayout(8,8));	
		 spaces = new  JLabel[64] ;
		
		int count = 0;
		for (int i = 0; i < ChessPiece.GRID_SIZE; i++){
			
			for (int j = 0; j < ChessPiece.GRID_SIZE; j++)  {
				if (board[i][j] != null) { 
						spaces[count]=new JLabel();
						spaces[count].addMouseListener(new MouseHandler());
						spaces[count].setIcon(board[i][j].photo.getIcon());
						spaces[count].setBorder(BorderFactory.createLineBorder(Color.black));
						spaces[count].setOpaque(true);
						
						if (i%2==0) {
							spaces[count].setBackground(j % 2==0 ? Color.white: Color.gray);
						}
						else {
							spaces[count].setBackground(j % 2==0 ? Color.gray: Color.white);
						}
						
						chessBoard.add(spaces[count]);
						count++;
				}
				
				else {
					if (i%2==0) {
						spaces[count]=new JLabel(new ImageIcon(j % 2==0 ? "white.png": "gray.png"));
					}
					else {
						spaces[count]=new JLabel(new ImageIcon(j % 2==0 ? "gray.png": "white.png"));
					}
					
							if (i%2==0) {
								spaces[count].setBackground(j % 2==0 ? Color.white: Color.gray);
							}
							else {
								spaces[count].setBackground(j % 2==0 ? Color.gray: Color.white);
							}
							
							spaces[count].addMouseListener(new MouseHandler());
							spaces[count].setBorder(BorderFactory.createLineBorder(Color.black));
							spaces[count].setOpaque(true);
						chessBoard.add(spaces[count]);
							count++;
						}
				}
			}
			
		add(chessBoard,BorderLayout.CENTER);
		setVisible(true);
	}
	public class MouseHandler implements MouseListener
	{
		@Override
		public void mouseClicked(MouseEvent e)
		{
			 switch (state){
			case BlackMove:
				Row=chessBoard.getComponentZOrder(e.getComponent())/8;
				Col =chessBoard.getComponentZOrder(e.getComponent())%8;
				if (board[i][j].move(Row, Col, board) == true) {
					spaces[position].setIcon(spaces[position].getBackground()== Color.white ? new ImageIcon("white.png") : new ImageIcon( "gray.png"));
					spaces[position].setBorder(BorderFactory.createLineBorder(Color.black));
					spaces[chessBoard.getComponentZOrder(e.getComponent())].setIcon(board[Row][Col].photo.getIcon());
					state = StageChess.WhiteWaiting;
				}
				else if (board[Row][Col].color == ChessColor.BLACK && board[Row][Col] != board[i][j] ) {
					spaces[chessBoard.getComponentZOrder(e.getComponent())].setBorder(BorderFactory.createLineBorder(Color.red,3));
					spaces[position].setBorder(BorderFactory.createLineBorder(Color.black));
					i=Row;
					j =Col;
					position =chessBoard.getComponentZOrder(e.getComponent());
					
				}
					
				break;
			case BlackWaiting:
				position=chessBoard.getComponentZOrder(e.getComponent());
				i = chessBoard.getComponentZOrder(e.getComponent())/8;
				 j = chessBoard.getComponentZOrder(e.getComponent())%8;
				 if (state == StageChess.BlackWaiting && board[i][j].color == ChessColor.BLACK) {
					 spaces[position].setBorder(BorderFactory.createLineBorder(Color.red,3));
					}
				if ( board[i][j].color == ChessColor.BLACK) {
					state = StageChess.BlackMove;
				}
				break;
			case WhiteMove:
				Row=chessBoard.getComponentZOrder(e.getComponent())/8;
				Col =chessBoard.getComponentZOrder(e.getComponent())%8;
				if (board[i][j].move(Row, Col, board) == true) {
					System.out.println(spaces[position].getBackground());
					spaces[position].setIcon(spaces[position].getBackground()== Color.white ? new ImageIcon("white.png") : new ImageIcon( "gray.png"));
					spaces[position].setBorder(BorderFactory.createLineBorder(Color.black));
					spaces[chessBoard.getComponentZOrder(e.getComponent())].setIcon(board[Row][Col].photo.getIcon());
					state = StageChess.BlackWaiting;
				}
				else if (board[Row][Col].color == ChessColor.WHITE && board[Row][Col] != board[i][j]) {
					spaces[chessBoard.getComponentZOrder(e.getComponent())].setBorder(BorderFactory.createLineBorder(Color.red,3));
					spaces[position].setBorder(BorderFactory.createLineBorder(Color.black));
					i=Row;
					j =Col;
					position =chessBoard.getComponentZOrder(e.getComponent());
					
				}
				
				break;
			case WhiteWaiting:
				position=chessBoard.getComponentZOrder(e.getComponent());
				i = chessBoard.getComponentZOrder(e.getComponent())/8;
				 j = chessBoard.getComponentZOrder(e.getComponent())%8;
				 if (state == StageChess.WhiteWaiting && board[i][j].color == ChessColor.WHITE) {
					     spaces[position].setBorder(BorderFactory.createLineBorder(Color.red,3));
					}
				if ( board[i][j]!=null  &&board[i][j].color == ChessColor.WHITE) {
					state = StageChess.WhiteMove;
				}	
				break;
			default:
				break;
			
			 
			 }
			 
		}
	
		@Override
		public void mousePressed(MouseEvent e)
		{
		}

		@Override
		public void mouseReleased(MouseEvent e)
		{
		}

		@Override
		public void mouseEntered(MouseEvent e)
		{
		}

		@Override
		public void mouseExited(MouseEvent e)
		{
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		 board = new ChessPiece[ChessPiece.GRID_SIZE][ChessPiece.GRID_SIZE];
		 File file = new File(args[0]);
		 Scanner inputFile = new Scanner(file);
		 Scanner in = new Scanner(System.in);
		 while (inputFile.hasNext())
		 {
		 	String line = inputFile.nextLine();
		 	String[] lineSplit = line.split("\t");
		 	System.out.println(Arrays.toString(lineSplit));
		 	int row = Integer.valueOf(lineSplit[2]);
		 	int col = Integer.valueOf(lineSplit[3]);
		 	String piece = lineSplit[0];
		 	ChessColor color = lineSplit[1].equals("WHITE") ? ChessColor.WHITE : ChessColor.BLACK;
		 	switch (piece.charAt(0))
		 	{
		 	case 'p':
		 		board[row][col] = new Pawn(row, col, color);
		 		break;
		 	case 'k':
		 		board[row][col] = new King(row, col, color);
		 		break;
		 	case 'r':
		 		board[row][col] = new Rook(row, col, color);
		 		break;
		 	case 'b':
		 		board[row][col] = new Bishop(row, col, color);
		 		break;
		 	case 'q':
		 		board[row][col] = new Queen(row, col, color);
		 		break;
		 	case 'h':
		 		board[row][col] = new Horse(row, col, color);
		 		break;
		 	
		 	}
		 }
            Chess game = new Chess();
          

	}
}

