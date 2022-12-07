package dk.magnusjensen.adventofcode.cal2021;

import dk.magnusjensen.adventofcode.templates.Assignment;
import dk.magnusjensen.adventofcode.templates.CalenderAssignment;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextArea;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

@CalenderAssignment(calendarName = 2021, assignmentName = "Let Giant Squid Win", number = 8, description = "Placeholder.")
public class A4P2 extends Assignment {
	
	@FXML
	private TextArea output;

	public A4P2(String name) {
		super(name);
	}


	public void partOne(String input) {
		String[] lines = input.split("\n");

		String[] numbersToDraw = lines[0].split(",");
		ArrayList<int[][]> boards = new ArrayList<>();
		ArrayList<boolean[][]> filledSlots = new ArrayList<>();
		ArrayList<Integer> wonBoards = new ArrayList<>();
		lines = Arrays.copyOfRange(lines, 2, lines.length);


		// initialize boards
		for (int board = 0; board < lines.length; board += 6) {
			int[][] currentBoard = new int[5][5];
			boolean[][] slots = new boolean[5][5];
			for (int x = 0; x < 5; x++) {
				Arrays.fill(slots[x], false);
				String[] row = lines[board + x].split(" ");
				int blankSpaces = 0;
				for (int y = 0; y < row.length; y++) {

					if (row[y].equals("")) {
						blankSpaces++;
						continue;
					}
					currentBoard[x][y - blankSpaces] = Integer.parseInt(row[y]);
				}
			}
			boards.add(currentBoard);
			filledSlots.add(slots);
		}


		int lastWinNumber = -1;

		// Draw numbers and check for winner.
		for (String stringNum : numbersToDraw) {
			if (wonBoards.size() == boards.size()) break;
			int number = Integer.parseInt(stringNum);
			// Set slot to true on the board where the number is found.
			for (int boardIdx = 0; boardIdx < boards.size(); boardIdx++) {
				int[][] board = boards.get(boardIdx);
				for (int x = 0; x < board.length; x++) {
					for (int y = 0; y < board[x].length; y++) {
						if (board[x][y] == number) {
							filledSlots.get(boardIdx)[x][y] = true;
						}
					}
				}
			}


			// Check for winner board.
			for (int boardIdx = 0; boardIdx < boards.size(); boardIdx++) {
				boolean[][] slotBoard = filledSlots.get(boardIdx);

				for (int x = 0; x < slotBoard.length; x++) {

					// Row checking logic.
					boolean rowFilled = true;
					for (int y = 0; y < slotBoard[x].length; y++) {

						// Column checking
						if (x == 0) {
							boolean columnFilled = true;
							if (!slotBoard[x][y] || !slotBoard[x + 1][y] || !slotBoard[x+2][y] || !slotBoard[x+3][y] || !slotBoard[x+4][y]) {
								columnFilled = false;
							}
							if (columnFilled) {
								if (!wonBoards.contains(boardIdx)) {
									wonBoards.add(boardIdx);
									if (wonBoards.size() == boards.size()) {
										lastWinNumber = number;
									}
								}
								break;
							}
						}

						if (!slotBoard[x][y]) {
							rowFilled = false;
							if (x != 0) {
								break;
							}
						}
					}
					if (rowFilled) {
						if (!wonBoards.contains(boardIdx)) {
							wonBoards.add(boardIdx);
						}
						if (wonBoards.size() == boards.size()) {
							lastWinNumber = number;
						}
						break;
					}
				}
			}



		}


		int[][] winnerBoard = boards.get(wonBoards.get(wonBoards.size() - 1));
		boolean[][] winnerBoardSlots = filledSlots.get(wonBoards.get(wonBoards.size() - 1));

		int unmarkedSum = 0;
		for (int x = 0; x < winnerBoard.length; x++) {
			for (int y = 0; y < winnerBoard[x].length; y++) {
				if (!winnerBoardSlots[x][y]) {
					unmarkedSum += winnerBoard[x][y];
				}
			}
		}

		output.setText("Board last win number: " + (wonBoards.get(wonBoards.size() - 1) + 1) + "\nLast number drawn: " + lastWinNumber + "\nResult: " + (unmarkedSum * lastWinNumber));

	}
}
