package dk.magnusjensen.adventofcode.cal2021;

import dk.magnusjensen.adventofcode.templates.Assignment;
import dk.magnusjensen.adventofcode.templates.CalenderAssignment;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextArea;

import java.io.IOException;

@CalenderAssignment(calendarName = 2021, assignmentName = "placeholder", number = 16, description = "Placeholder.")
public class A8P2 extends Assignment {
	
	@FXML
	private TextArea output;

	public A8P2(String name) {
		super(name);
	}


	public void partOne(String input) {
		String[] lines = input.split("\n");

	}
}
