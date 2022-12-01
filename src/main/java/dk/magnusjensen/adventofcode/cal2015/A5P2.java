package dk.magnusjensen.adventofcode.cal2015;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import dk.magnusjensen.adventofcode.templates.Assignment;
import dk.magnusjensen.adventofcode.templates.CalenderAssignment;
import dk.magnusjensen.adventofcode.utils.StringUtils;

import java.io.IOException;

@CalenderAssignment(calendarName = "2015", assignmentName = "Better Word checker", number = 10, description = "Placeholder.")
public class A5P2 extends Assignment {
	@FXML
	private TextArea input;
	@FXML
	private TextArea output;

	public A5P2(String name) {
		super(name);
	}

	@Override
	public Node getContent() throws IOException {
		Node content = loadDefaultContent(this);
		setInputContent(input, 2015, 5);
		return content;
	}

	@FXML
	public void run(ActionEvent event) {

		int niceWords = 0;

		for (String line : input.getText().split("\n")) {
			if (StringUtils.checkStringForPairs(line, 2, 2) && StringUtils.checkCharRepeatsWithSpace(line, 1, 1)) {
				niceWords++;
			}
		}
		output.setText("The nice word list, with the new algorithm now has: " + niceWords + " nice words.");
	}
}
