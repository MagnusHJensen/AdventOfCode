package org.adventofcode.cal2021;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import org.adventofcode.templates.Assignment;
import org.adventofcode.templates.CalenderAssignment;

import java.io.IOException;

@CalenderAssignment(calendarName = "2021", assignmentName = "Dive but AIM!", number = 4, description = "Placeholder.")
public class A2P2 extends Assignment {
	@FXML
	private TextArea input;
	@FXML
	private TextArea output;

	public A2P2(String name) {
		super(name);
	}

	@Override
	public Node getContent() throws IOException {
		Node content = loadDefaultContent(this);
		setInputContent(input, 2021, 2);
		return content;
	}

	public void run(ActionEvent actionEvent) {
		String[] lines = input.getText().split("\n");

		int depth = 0;
		int aim = 0;
		int horizontal = 0;


		for (String line : lines) {
			String[] parts = line.split(" ");
			int value = Integer.parseInt(parts[1]);

			if (parts[0].equalsIgnoreCase("forward")) {
				horizontal += value;
				depth += (value * aim);
			} else if (parts[0].equalsIgnoreCase("up")) {
				aim -= value;
			} else if (parts[0].equalsIgnoreCase("down")) {
				aim += value;
			}

		}

		output.setText("Depth is: " + depth + "\nHorizontal value is: " + horizontal + "\nResult: " + (horizontal * depth));

	}
}
