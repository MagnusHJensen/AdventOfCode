package dk.magnusjensen.adventofcode.cal2020;

import dk.magnusjensen.adventofcode.templates.Assignment;
import dk.magnusjensen.adventofcode.templates.CalenderAssignment;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextArea;

import java.io.IOException;

@CalenderAssignment(calendarName = 2020, assignmentName = "Password Philosophy - P2", number = 4, description = "Each policy actually describes two positions in the password, where 1 means the first character, 2 means the second character, and so on. (Be careful; Toboggan Corporate Policies have no concept of \"index zero\"!)\n Exactly one of these positions must contain the given letter.\n Other occurrences of the letter are irrelevant for the purposes of policy enforcement.")
public class A2P2 extends Assignment {
	
	@FXML
	private TextArea output;

	public A2P2(String name) {
		super(name);
	}



	@FXML
	public void partOne(String input) {
		String[] lines = input.split("\n");
		int total = 0;
		for (String line : lines) {
			String[] sides = line.split(":");
			String password = sides[1].strip();
			String[] values = sides[0].split(" ");
			char check = values[1].toCharArray()[0];
			int firstIdx = Integer.parseInt(values[0].split("-")[0]);
			int secondIdx = Integer.parseInt(values[0].split("-")[1]);

			int accumulate = 0;
			if (password.charAt(firstIdx - 1) == check)
				accumulate++;
			if (password.charAt(secondIdx - 1) == check)
				accumulate++;
			if (accumulate == 1) {
				total++;
			}
		}

		output.setText("Valid passwords accordingly to the second password policy is: " + total);

	}
}