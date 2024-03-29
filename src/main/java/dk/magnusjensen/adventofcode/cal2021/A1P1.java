package dk.magnusjensen.adventofcode.cal2021;

import dk.magnusjensen.adventofcode.templates.Assignment;
import dk.magnusjensen.adventofcode.templates.CalenderAssignment;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextArea;

import java.io.IOException;

@CalenderAssignment(calendarName = 2021, assignmentName = "Sonar Sweep", number = 1, description = "Placeholder.")
public class A1P1 extends Assignment {
	
	@FXML
	private TextArea output;

	public A1P1(String name) {
		super(name);
	}

	public void partOne(String input) {
		String[] lines = input.split("\n");

		int amountOfIncreases = 0;
		int currentDepth = Integer.parseInt(lines[0]);
		for (int i = 1; i < lines.length; i++) {
			int depthLine = Integer.parseInt(lines[i]);
			if (depthLine > currentDepth) {
				amountOfIncreases++;
			}

			currentDepth = depthLine;
		}

		output.setText(Integer.toString(amountOfIncreases));
	}
}