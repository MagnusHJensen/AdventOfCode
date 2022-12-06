package dk.magnusjensen.adventofcode.cal2015;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import dk.magnusjensen.adventofcode.templates.Assignment;
import dk.magnusjensen.adventofcode.templates.CalenderAssignment;
import dk.magnusjensen.adventofcode.utils.StringUtils;

import java.io.IOException;

@CalenderAssignment(calendarName = 2015, assignmentName = "MD5", number = 7, description = "Placeholder.")
public class A4P1 extends Assignment {

	
	@FXML
	private TextArea output;

	public A4P1(String name) {
		super(name);
	}

	

	@FXML
	public void partOne(String input) {
		output.setText("Running...");
		int counter = 0;
		String sequence = "";
		String text = input.replaceAll("[\\n\\t ]", "");
		while (!sequence.contentEquals("0".repeat(5))) {
			String sum = StringUtils.getMD5(text + counter);
			sequence = sum.substring(0, 5);
			++counter;
		}
		output.setText("The counter is: " + counter);
	}
}
