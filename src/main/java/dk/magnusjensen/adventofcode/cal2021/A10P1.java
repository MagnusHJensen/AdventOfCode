package dk.magnusjensen.adventofcode.cal2021;

import dk.magnusjensen.adventofcode.templates.Assignment;
import dk.magnusjensen.adventofcode.templates.CalenderAssignment;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextArea;

import java.io.IOException;

@CalenderAssignment(calendarName = "2021", assignmentName = "placeholder", number = 19, description = "Placeholder.")
public class A10P1 extends Assignment {
	@FXML
	private TextArea input;
	@FXML
	private TextArea output;

	public A10P1(String name) {
		super(name);
	}

	@Override
	public Node getContent() throws IOException {
		Node content = loadDefaultContent(this);
		setInputContent(input, 2021, 10);
		return content;
	}

	public void run(ActionEvent actionEvent) {
		String[] lines = input.getText().split("\n");

	}
}
