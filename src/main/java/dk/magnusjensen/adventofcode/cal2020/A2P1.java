package dk.magnusjensen.adventofcode.cal2020;

import dk.magnusjensen.adventofcode.templates.Assignment;
import dk.magnusjensen.adventofcode.templates.CalenderAssignment;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextArea;

import java.io.IOException;

@CalenderAssignment(calendarName = 2020, assignmentName = "Password Philosophy", number = 3, description = "Each line gives the password policy and then the password. \nThe password policy indicates the lowest and highest number of times a given letter must appear for the password to be valid. \nFor example, 1-3 a means that the password must contain a at least 1 time and at most 3 times.")
public class A2P1 extends Assignment {
	
	@FXML
	private TextArea output;

	public A2P1(String name) {
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
			int lower = Integer.parseInt(values[0].split("-")[0]);
			int higher = Integer.parseInt(values[0].split("-")[1]);

			int counter = 0;
			for (char chr : password.toCharArray()) {
				if (chr == check)
					counter++;
			}
			if (counter >= lower && counter <= higher) {
				total++;
			}

		}

		output.setText("Valid passwords accordingly to the first password policy is: " + total);

	}
}
