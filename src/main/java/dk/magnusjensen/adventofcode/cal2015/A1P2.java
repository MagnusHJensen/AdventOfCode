package dk.magnusjensen.adventofcode.cal2015;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import dk.magnusjensen.adventofcode.templates.Assignment;
import dk.magnusjensen.adventofcode.templates.CalenderAssignment;

import java.io.IOException;

@CalenderAssignment(calendarName = 2015, assignmentName = "Santa Entering Basement Floor", number = 2, description = "Santa starts on floor 0.\nOpen parenthesis = +1\nClosing parenthesis = -1\nWhen does santa enter the basement floor?")
public class A1P2 extends Assignment {
	@FXML
	private TextArea output;

	public A1P2(String name) {
		super(name);
	}

	@FXML
	public void partOne(String input) {
		int open = 0;
		int close = 0;
		int index = 0;
		int savedIndex = -1;

		for (char c : input.toCharArray()) {
			if (c == '(') {
				open++;
			}
			else {
				close++;
			}
			index++;

			if (open-close == -1 && savedIndex == -1) {
				savedIndex = index;
			}
		}

		output.setText("Open: " + open + "\nClose: " + close + "\nEnd floor: " + (open-close) + "\nIndex basement floor entered: " + savedIndex);
	}
}
