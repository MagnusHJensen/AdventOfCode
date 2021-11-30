package org.adventofcode.cal2015;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import org.adventofcode.templates.Assignment;
import org.adventofcode.templates.CalenderAssignment;
import org.adventofcode.utils.MD5;
import org.adventofcode.utils.StringUtils;

import java.io.IOException;

@CalenderAssignment(calendarName = "2015", assignmentName = "MD5, with 6 zeroes", number = 8, description = "Placeholder.")
public class A4P2 extends Assignment {

	@FXML
	private TextArea input;
	@FXML
	private TextArea output;

	public A4P2(String name) {
		super(name);
	}

	@Override
	public Node getContent() throws IOException {
		Node content = loadDefaultContent(this);
		setInputContent(input, 2015, 4);
		return content;
	}

	@FXML
	public void run(ActionEvent event) {
		output.setText("Running...");
		int counter = 0;
		String sequence = "";
		String text = input.getText().replaceAll("[\\n\\t ]", "");
		while (!sequence.contentEquals("0".repeat(6))) {
			String sum = StringUtils.getMD5(text + counter);
			sequence = sum.substring(0, 6);
			++counter;
		}
		output.setText("The counter is: " + counter);
	}
}
