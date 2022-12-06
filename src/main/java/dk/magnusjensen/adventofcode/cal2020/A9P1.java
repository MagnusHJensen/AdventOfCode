package dk.magnusjensen.adventofcode.cal2020;

import dk.magnusjensen.adventofcode.templates.Assignment;
import dk.magnusjensen.adventofcode.templates.CalenderAssignment;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextArea;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@CalenderAssignment(calendarName = 2020, assignmentName = "DAY 9 PART 1", number = 17, description = "Placeholder.")
public class A9P1 extends Assignment {
	
	@FXML
	private TextArea output;

	public A9P1(String name) {
		super(name);
	}

	@Override
	public Node getContent() throws IOException {
		Node content = loadDefaultContent(this);
		setInputContent(input, 2020, 9);
		return content;
	}

	@FXML
	public void partOne(String input) {
		String[] lines = input.split("\n");

		ArrayList<Integer> preamble = new ArrayList<>();

		// Populate the preamble
		for (int i = 0; i < 25; i++) {
			preamble.add(Integer.parseInt(lines[i]));
		}

		int numberNotFollowing = 0;

		List<String> linesAfterPreamble = Arrays.stream(lines).skip(25).collect(Collectors.toList());

		for (String line : linesAfterPreamble) {
			int value = Integer.parseInt(line);

			if (!checkNumber(preamble, value)) {
				numberNotFollowing = value;
				break;
			}

			preamble.remove(0);
			preamble.add(value);
		}




		output.setText("Total: " + numberNotFollowing);
	}


	public boolean checkNumber(ArrayList<Integer> preamble, int value) {
		for (int i = 0; i < preamble.size(); i++) {
			int first = preamble.get(i);
			for (int j = 0; j < preamble.size(); j++) {
				int second = preamble.get(j);
				if (first != second && (first + second == value)) {
					return true;
				}
			}
		}
		return false;
	}




}
