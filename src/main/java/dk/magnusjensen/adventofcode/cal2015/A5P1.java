package dk.magnusjensen.adventofcode.cal2015;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import dk.magnusjensen.adventofcode.templates.Assignment;
import dk.magnusjensen.adventofcode.templates.CalenderAssignment;
import dk.magnusjensen.adventofcode.utils.StringUtils;

import java.io.IOException;

@CalenderAssignment(calendarName = 2015, assignmentName = "Nice or Naughty Strings", number = 9, description = "Placeholder.")
public class A5P1 extends Assignment {
	
	@FXML
	private TextArea output;

	public A5P1(String name) {
		super(name);
	}

	

	@FXML
	public void partOne(String input) {

		char[] vowels = new char[] {'a', 'e', 'i', 'o', 'u'};
		String[] naughtyWords = new String[] {"ab", "cd", "pq", "xy"};

		int niceWords = 0;

		for (String line : input.split("\n")) {

			boolean flagged = StringUtils.checkStringForWords(line, naughtyWords);
			if (flagged) {
				continue;
			}

			if (StringUtils.countCharactersInString(line, vowels) >= 3 && StringUtils.checkCharsInRow(line, 2)) {
				niceWords++;
			}
		}
		output.setText("Naughty & Nice word list contains: " + niceWords + " nice words.");
	}
}
