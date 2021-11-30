package org.adventofcode.cal2020;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import org.adventofcode.templates.Assignment;
import org.adventofcode.templates.CalenderAssignment;

import java.io.IOException;

@CalenderAssignment(calendarName = "2020", assignmentName = "DAY 7 PART 2", number = 14, description = "Placeholder.")
public class A7P2 extends Assignment {
	@FXML
	private TextArea input;
	@FXML
	private TextArea output;

	public A7P2(String name) {
		super(name);
	}

	@Override
	public Node getContent() throws IOException {
		Node content = loadDefaultContent(this);
		setInputContent(input, 2020, 7);
		return content;
	}

	@FXML
	public void run(ActionEvent event) {
		String[] lines = input.getText().split("\n");

		int total = 0;



		for (String line : lines) {

		}


		output.setText("Total: " + total);
	}


}
