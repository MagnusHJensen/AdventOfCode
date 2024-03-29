package dk.magnusjensen.adventofcode.cal2020;

import dk.magnusjensen.adventofcode.templates.Assignment;
import dk.magnusjensen.adventofcode.templates.CalenderAssignment;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextArea;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

@CalenderAssignment(calendarName = 2020, assignmentName = "DAY 6 PART 2", number = 12, description = "Placeholder.")
public class A6P2 extends Assignment {
	
	@FXML
	private TextArea output;

	public A6P2(String name) {
		super(name);
	}

	

	@FXML
	public void partOne(String input) {
		String[] lines = input.split("\n");
		int total = 0;

		ArrayList<Character> answers = new ArrayList<>();
		HashSet<Character> counted = new HashSet<>();

		int groupSize = 0;

		for (String line : lines) {
			if (line.equals("")) {
				for (char chr : answers) {
					if (counted.contains(chr))
						continue;
					if (Collections.frequency(answers, chr) == groupSize) {
						total++;
						counted.add(chr);
					}
				}
				answers.subList(0, answers.size()).clear();
				counted.clear();
				groupSize = 0;
				continue;
			}

			for (char chr : line.toCharArray()) {
				answers.add(chr);
			}
			groupSize++;
		}

		for (char chr : answers) {
			if (counted.contains(chr))
				continue;
			if (Collections.frequency(answers, chr) == groupSize) {
				total++;
				counted.add(chr);
			}
		}


		output.setText("Total: " + total);
	}




}
