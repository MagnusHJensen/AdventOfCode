package dk.magnusjensen.adventofcode.cal2015;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import dk.magnusjensen.adventofcode.templates.Assignment;
import dk.magnusjensen.adventofcode.templates.CalenderAssignment;

import java.io.IOException;

@CalenderAssignment(calendarName = 2015, assignmentName = "", number = 14, description = "Placeholder.")
public class A7P2 extends Assignment {
	
	@FXML
	private TextArea output;

	public A7P2(String name) {
		super(name);
	}

	

	@FXML
	public void partOne(String input) {
		output.setText("");
	}
}
