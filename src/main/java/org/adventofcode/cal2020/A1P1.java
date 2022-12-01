package org.adventofcode.cal2020;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import org.adventofcode.templates.Assignment;
import org.adventofcode.templates.CalenderAssignment;

import java.io.IOException;

@CalenderAssignment(calendarName = "2020", assignmentName = "Tropical Island.", number = 1, description = "Placeholder.")
public class A1P1 extends Assignment {
	@FXML
	private TextArea input;
	@FXML
	private TextArea output;

	public A1P1(String name) {
		super(name);
	}

	@Override
	public Node getContent() throws IOException {
		Node content = loadDefaultContent(this);
		setInputContent(input, 2020, 1);
		return content;
	}

	@FXML
	public void run(ActionEvent event) {
		String[] lines = input.getText().split("\n");
		for (String line : lines) {
			int first = Integer.parseInt(line);
			for (String iterator : lines) {
				int second = Integer.parseInt(iterator);
				if (first + second == 2020) {
					output.setText("The multiplied value of " + first + " & " + second + " is: " + (first * second));
					break;
				}
			}
		}

	}
}
