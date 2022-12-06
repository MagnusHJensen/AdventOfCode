package dk.magnusjensen.adventofcode.cal2020;

import dk.magnusjensen.adventofcode.templates.Assignment;
import dk.magnusjensen.adventofcode.templates.CalenderAssignment;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextArea;

import java.io.IOException;

@CalenderAssignment(calendarName = 2020, assignmentName = "DAY 10 PART 2", number = 26, description = "Placeholder.")
public class A13P2 extends Assignment {
	
	@FXML
	private TextArea output;

	public A13P2(String name) {
		super(name);
	}

	@Override
	public Node getContent() throws IOException {
		Node content = loadDefaultContent(this);
		setInputContent(input, 2020, 13);
		return content;
	}

	@FXML
	public void partOne(String input) {
		String[] lines = input.split("\n");


		for (String line : lines) {

		}


	}









}
