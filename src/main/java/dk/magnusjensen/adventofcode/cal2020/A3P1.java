package dk.magnusjensen.adventofcode.cal2020;

import dk.magnusjensen.adventofcode.templates.Assignment;
import dk.magnusjensen.adventofcode.templates.CalenderAssignment;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextArea;

import java.io.IOException;

@CalenderAssignment(calendarName = 2020, assignmentName = "DAY 3 PART 1", number = 5, description = "Placeholder.")
public class A3P1 extends Assignment {
	
	@FXML
	private TextArea output;

	public A3P1(String name) {
		super(name);
	}

	@FXML
	public void partOne(String input) {
		String[] lines = input.split("\n");

		String[][] map = new String[lines[0].length()][lines.length];


		for (int y = 0; y < map[0].length; y++) {
			for (int x = 0; x < map.length; x++) {
				map[x][y] = lines[y].substring(x, x+1);
			}
		}

		long total = this.checkTrees(3, 1, map);

		output.setText("Total trees hit: " + total);
	}

	public long checkTrees(int slopeX, int slopeY, String[][] map) {
		int currentX = 0;
		int currentY = 0;
		int total = 0;

		while (currentY < map[0].length - 1) {
			currentY += slopeY;
			currentX = (currentX + slopeX) % map.length;


			if (map[currentX][currentY].equals("#"))
				total++;
		}

		return total;
	}
}
