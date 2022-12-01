package org.adventofcode.cal2015;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import org.adventofcode.maths.Vec2;
import org.adventofcode.templates.Assignment;
import org.adventofcode.templates.CalenderAssignment;

import java.io.IOException;
import java.util.ArrayList;

@CalenderAssignment(calendarName = "2015", assignmentName = "Houses santa visited", number = 5, description = "Placeholder.")
public class A3P1 extends Assignment {
	@FXML
	private TextArea input;
	@FXML
	private TextArea output;

	public A3P1(String name) {
		super(name);
	}

	@Override
	public Node getContent() throws IOException {
		Node content = loadDefaultContent(this);
		setInputContent(input, 2015, 3);
		return content;
	}

	@FXML
	public void run(ActionEvent event) {
		int currentX = 0;
		int currentY = 0;
		ArrayList<Vec2> houseCords = new ArrayList<>();
		houseCords.add(new Vec2(currentX, currentY));
		for (char chr : input.getText().toCharArray()) {
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
