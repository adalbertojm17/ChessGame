package aavv;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class ChessGame {
	public static void main(String[] args) throws FileNotFoundException {
		ChessPiece[][] board = new ChessPiece[ChessPiece.GRID_SIZE][ChessPiece.GRID_SIZE];
		File file = new File("/Users/adalb/Desktop/programing class/chess/src/Pieces.txt");

		Scanner inputFile = new Scanner(file);
		Scanner in = new Scanner(System.in);

		while (inputFile.hasNext()) {
			String line = inputFile.nextLine();
			String[] lineSplit = line.split("\t");
			System.out.println(Arrays.toString(lineSplit));

			int row = Integer.valueOf(lineSplit[2]);
			int col = Integer.valueOf(lineSplit[3]);
			String piece = lineSplit[0];
			ChessColor color = lineSplit[1].equals("WHITE") ? ChessColor.WHITE : ChessColor.BLACK;

			switch (piece.charAt(0)) {
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

		inputFile.close();

		System.out.println(displayBoard(board));

		while (true) {
			System.out.println("Input row and column of a piece to move");
			int row = in.nextInt();
			int col = in.nextInt();
			ChessPiece myPiece = board[row][col];

			System.out.println("Input row and column to move to");
			System.out.println(myPiece.move(in.nextInt(), in.nextInt(), board));
			System.out.println(displayBoard(board));
		}
	}

	public static String displayBoard(ChessPiece[][] board) {
		String result = " ";

		for (int i = 0; i < ChessPiece.GRID_SIZE; i++)
			result += "  " + i;
		result += "\n";
		for (int i = 0; i < ChessPiece.GRID_SIZE; i++) {
			result += i + " ";
			for (int j = 0; j < ChessPiece.GRID_SIZE; j++)
				if (board[i][j] != null)
					result += "" + board[i][j].getClass().getName().charAt(5) + board[i][j].color.toString().charAt(0)
							+ " ";
				else
					result += "-- ";
			result += "\n";
		}
		return result;
	}
}