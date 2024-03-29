package dk.magnusjensen.adventofcode.cal2020;

import dk.magnusjensen.adventofcode.templates.Assignment;
import dk.magnusjensen.adventofcode.templates.CalenderAssignment;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextArea;

import java.io.IOException;
import java.util.ArrayList;

@CalenderAssignment(calendarName = 2020, assignmentName = "DAY 6 PART 1", number = 11, description = "Placeholder.")
public class A6P1 extends Assignment {
	
	@FXML
	private TextArea output;

	public A6P1(String name) {
		super(name);
	}

	

	@FXML
	public void partOne(String input) {
		String[] lines = input.split("\n");

		int total = 0;

		ArrayList<Character> answers = new ArrayList<>();

		for (String line : lines) {
			if (line.equals("")) {
				total += answers.size();
				answers.subList(0, answers.size()).clear();
			}

			for (char chr : line.toCharArray()) {
				if (!answers.contains(chr)) {
					answers.add(chr);
				}
			}
		}

		total += answers.size();


		output.setText("Total: " + total);
	}


}
