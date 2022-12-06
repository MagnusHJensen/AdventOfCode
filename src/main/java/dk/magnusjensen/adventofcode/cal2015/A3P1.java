package dk.magnusjensen.adventofcode.cal2015;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import dk.magnusjensen.adventofcode.maths.Vec2;
import dk.magnusjensen.adventofcode.templates.Assignment;
import dk.magnusjensen.adventofcode.templates.CalenderAssignment;

import java.io.IOException;
import java.util.ArrayList;

@CalenderAssignment(calendarName = 2015, assignmentName = "Houses santa visited", number = 5, description = "Placeholder.")
public class A3P1 extends Assignment {
	
	@FXML
	private TextArea output;

	public A3P1(String name) {
		super(name);
	}

	@FXML
	public void partOne(String input) {
		int currentX = 0;
		int currentY = 0;
		ArrayList<Vec2> houseCords = new ArrayList<>();
		houseCords.add(new Vec2(currentX, currentY));
		for (char chr : input.toCharArray()) {
			if (chr == '^') {
				currentY++;
			} else if (chr == 'v') {
				currentY--;
			} else if (chr == '<') {
				currentX--;
			} else if (chr == '>') {
				currentX++;
			}
			Vec2 cord = new Vec2(currentX, currentY);
			if (!houseCords.contains(cord)) {
				houseCords.add(cord);
			}
		}

		output.setText("Santa visisted " + houseCords.size() + " unique houses.");
	}
}
