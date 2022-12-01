package dk.magnusjensen.adventofcode.cal2021.day_five;

import java.util.ArrayList;
import java.util.Arrays;

public class Board {
	private ArrayList<Line> lines;
	private char[][] board;

	public Board(int xSize, int ySize) {
		this.lines = new ArrayList<>();
		this.board = new char[ySize][xSize];
		setupBoard();
	}

	public void setLines(ArrayList<Line> lines) {
		this.lines = lines;
		fillBoard();
	}

	private void fillBoard() {

		for (Line line : this.lines) {
			for (Point point : line.getPoints()) {
				char currentChar = this.board[point.getY()][point.getX()];
				if (currentChar == '.') {
					currentChar = '1';
				} else {
					int digit = Character.digit(currentChar, 10);
					digit++;
					currentChar = Character.forDigit(digit, 10);
				}
				this.board[point.getY()][point.getX()] = currentChar;
			}
		}


	}

	private void setupBoard() {
		for (int i = 0; i < this.board.length; i++) {
			Arrays.fill(this.board[i], '.');
		}
	}

	public void printBoard() {
		System.out.println(Arrays.deepToString(this.board));
	}

	public int getAmountOfOverlaps() {
		int overlaps = 0;

		for (int y = 0; y < this.board.length; y++) {
			for (int x = 0; x < this.board[y].length; x++) {
				if (Character.digit(this.board[y][x], 10) >= 2) {
					overlaps++;
				}
			}
		}
		return overlaps;
	}
}
