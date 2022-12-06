package dk.magnusjensen.adventofcode.cal2020;

import dk.magnusjensen.adventofcode.templates.Assignment;
import dk.magnusjensen.adventofcode.templates.CalenderAssignment;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextArea;

import java.io.IOException;

@CalenderAssignment(calendarName = 2020, assignmentName = "DAY 3 PART 2", number = 6, description = "Placeholder.")
public class A3P2 extends Assignment {
	
	@FXML
	private TextArea output;

	public A3P2(String name) {
		super(name);
	}

	@Override
	public Node getContent() throws IOException {
		Node content = loadDefaultContent(this);
		setInputContent(input, 2020, 3);
		return content;
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

		long first = this.checkTrees(1, 1, map);
		long second = this.checkTrees(3, 1, map);
		long three = this.checkTrees(5, 1, map);
		long four = this.checkTrees(7, 1, map);
		long five = this.checkTrees(1, 2, map);

		long total = first * second * three * four * five;

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