package dk.magnusjensen.adventofcode.cal2021;

import dk.magnusjensen.adventofcode.templates.Assignment;
import dk.magnusjensen.adventofcode.templates.CalenderAssignment;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextArea;

import java.io.IOException;

@CalenderAssignment(calendarName = 2021, assignmentName = "Sonar Sweep - Sliding Window", number = 2, description = "Placeholder.")
public class A1P2 extends Assignment {
	
	@FXML
	private TextArea output;

	public A1P2(String name) {
		super(name);
	}

	public void partOne(String input) {
		String[] lines = input.split("\n");

		int amountOfIncreases = 0;
		int currentSumOfDepths = Integer.MAX_VALUE;
		for (int i = 0; i < lines.length - 2; i++) {
			int depthTotal = 0;
			for (int j = i; j < i + 3; j++) {
				depthTotal += Integer.parseInt(lines[j]);
			}
			System.out.println(depthTotal);
			if (depthTotal > currentSumOfDepths) {
				amountOfIncreases++;
			}

			currentSumOfDepths = depthTotal;
		}

		output.setText(Integer.toString(amountOfIncreases));
	}
}
