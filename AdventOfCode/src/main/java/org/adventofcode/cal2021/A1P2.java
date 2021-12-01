package org.adventofcode.cal2021;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import org.adventofcode.templates.Assignment;
import org.adventofcode.templates.CalenderAssignment;

import java.io.IOException;
import java.util.ArrayList;

@CalenderAssignment(calendarName = "2021", assignmentName = "holder", number = 2, description = "Placeholder.")
public class A1P2 extends Assignment {
	@FXML
	private TextArea input;
	@FXML
	private TextArea output;

	public A1P2(String name) {
		super(name);
	}

	@Override
	public Node getContent() throws IOException {
		Node content = loadDefaultContent(this);
		setInputContent(input, 2021, 1);
		return content;
	}

	public void run(ActionEvent actionEvent) {
		String[] lines = input.getText().split("\n");

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
