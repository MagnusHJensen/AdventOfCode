package org.adventofcode.cal2020;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import org.adventofcode.templates.Assignment;
import org.adventofcode.templates.CalenderAssignment;

import java.io.IOException;
import java.util.*;

@CalenderAssignment(calendarName = "2020", assignmentName = "DAY 4 PART 2", number = 8, description = "Placeholder.")
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
		setInputContent(input, 2020, 4);
		return content;
	}

	@FXML
	public void run(ActionEvent event) {
		String[] lines = input.getText().split("\n");

		int total = 0;

		ArrayList<Boolean> checks = new ArrayList<>();

		HashMap<String, String> required = new HashMap<>() {
			{
				put("byr", "([1][9][2-9][0-9]|[2][0][0][0-2])");
				put("iyr", "([2][0][1][0-9]|[2][0][2][0])");
				put("eyr", "([2][0][2][0-9]|[2][0][3][0])");
				put("hgt", "");
				put("hcl", "#[a-f0-9]{6}$");
				put("ecl", "\\b(amb|blu|brn|gry|grn|hzl|oth)\\b");
				put("pid", "\\b(\\d{9})\\b");
			}
		};


		for (String line : lines) {
			if (line.equals("")) {
				// reset or so.
				if (checks.size() == 7) {
					total++;
				}
				if (checks.size() > 0) {
					checks.subList(0, checks.size()).clear();
				}
				continue;
			}

			HashMap<String, String> pairs = new HashMap<>();
			for (String keyVal : line.split(" ")) {
				String[] parts = keyVal.split(":");
				pairs.put(parts[0], parts[1]);
			}

			pairs.forEach((key, value) -> {
				if (required.containsKey(key)) {
					if (key.equals("hgt")) {
						if (value.contains("cm")) {
							int index = value.indexOf("cm");
							if (value.substring(0, index).matches("([1][5-8][0-9]|[1][9][0-3])")) {
								checks.add(true);
							}
						} else if (value.contains("in")) {
							int index = value.indexOf("in");
							if (Integer.parseInt(value.substring(0, index)) >= 59 && Integer.parseInt(value.substring(0, index)) <= 76)  {
								checks.add(true);
							}
						}
					}
					if (value.matches(required.get(key))) {
						checks.add(true);
					}
				}
			});

		}

		if (checks.size() == 7) {
			total++;
		}
		// 130 too low.
		output.setText("Total: " + total);
	}
}
