package dk.magnusjensen.adventofcode.cal2021;

import dk.magnusjensen.adventofcode.templates.Assignment;
import dk.magnusjensen.adventofcode.templates.CalenderAssignment;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextArea;

import java.io.IOException;

@CalenderAssignment(calendarName = 2021, assignmentName = "placeholder", number = 15, description = "Placeholder.")
public class A8P1 extends Assignment {
	
	@FXML
	private TextArea output;

	public A8P1(String name) {
		super(name);
	}

	@Override
	public Node getContent() throws IOException {
		Node content = loadDefaultContent(this);
		setInputContent(input, 2021, 8);
		return content;
	}

	public void partOne(String input) {
		String[] lines = input.split("\n");

	}
}
