package org.adventofcode.cal2020;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import org.adventofcode.templates.Assignment;
import org.adventofcode.templates.CalenderAssignment;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@CalenderAssignment(calendarName = "2020", assignmentName = "DAY 4", number = 7, description = "Placeholder.")
public class A4P1 extends Assignment {
	@FXML
	private TextArea input;
	@FXML
	private TextArea output;

	public A4P1(String name) {
		super(name);
	}

	@Override
	public Node getContent() throws IOException {
		Node content = loadDefaultContent(this);
		setInputContent(input, 2020, 4);
		return content;
	}

	@FXML
	public void run(ActionEvent event) {
		String[] lines = input.getText().split("\n");

		int total = 0;

		ArrayList<Boolean> checks = new ArrayList<>();

		ArrayList<String> required = new ArrayList<>(List.of("byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid"));


		for (String line : lines) {
			ArrayList<String> keys = new ArrayList<>();
			for (String keyVal : line.split(" ")) {
				keys.add(keyVal.split(":")[0]);
			}

			for (String key : keys) {
				if (required.contains(key))
					checks.add(true);
			}

			if (line.equals("")) {
				// reset or so.
				if (checks.size() == 7) {
					total++;
				}
				for (int i = checks.size() - 1; i > -1; i--) {
					checks.remove(i);
				}
			}


		}
		if (checks.size() == 7) {
			total++;
		}
		// 209 is too low.
		output.setText("Total: " + total);
	}

}
