package dk.magnusjensen.adventofcode.cal2015;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import dk.magnusjensen.adventofcode.maths.Vec2;
import dk.magnusjensen.adventofcode.templates.Assignment;
import dk.magnusjensen.adventofcode.templates.CalenderAssignment;

import java.io.IOException;
import java.util.ArrayList;

@CalenderAssignment(calendarName = 2015, assignmentName = "Santa & Robo-Santa", number = 6, description = "Placeholder.")
public class A3P2 extends Assignment {
	
	@FXML
	private TextArea output;

	public A3P2(String name) {
		super(name);
	}

	

	@FXML
	public void partOne(String input) {
		int santaX = 0;
		int santaY = 0;
		int roboX = 0;
		int roboY = 0;

		boolean roboTurn = false;
		ArrayList<Vec2> houseCords = new ArrayList<>();
		houseCords.add(new Vec2(santaX, santaY));
		for (char chr : input.toCharArray()) {
			if (chr == '^') {
				if (roboTurn) {
					roboY++;
				} else {
					santaY++;
				}
			} else if (chr == 'v') {
				if (roboTurn) {
					roboY--;
				} else {
					santaY--;
				}
			} else if (chr == '<') {
				if (roboTurn) {
					roboX--;
				} else {
					santaX--;
				}
			} else if (chr == '>') {
				if (roboTurn) {
					roboX++;
				} else {
					santaX++;
				}
			}
			Vec2 cord;
			if (roboTurn) {
				cord = new Vec2(roboX, roboY);
			} else {
				cord = new Vec2(santaX, santaY);
			}

			roboTurn = !roboTurn;

			if (!houseCords.contains(cord)) {
				houseCords.add(cord);
			}

		}

		output.setText("Santa visisted " + houseCords.size() + " unique houses.");
	}
}
