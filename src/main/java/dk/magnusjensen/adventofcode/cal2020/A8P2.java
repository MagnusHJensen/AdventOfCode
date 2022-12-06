package dk.magnusjensen.adventofcode.cal2020;

import dk.magnusjensen.adventofcode.templates.Assignment;
import dk.magnusjensen.adventofcode.templates.CalenderAssignment;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextArea;

import java.io.IOException;
import java.util.ArrayList;

@CalenderAssignment(calendarName = 2020, assignmentName = "DAY 8 PART 2", number = 16, description = "Placeholder.")
public class A8P2 extends Assignment {
	
	@FXML
	private TextArea output;

	public A8P2(String name) {
		super(name);
	}

	@Override
	public Node getContent() throws IOException {
		Node content = loadDefaultContent(this);
		setInputContent(input, 2020, 8);
		return content;
	}

	@FXML
	public void partOne(String input) {
		String[] lines = input.split("\n");

		ArrayList<Integer> linesExecuted = new ArrayList<>();

		int index = 0;
		int accumulator = 0;

		while (!linesExecuted.contains(index)) {
			linesExecuted.add(index);
			if (index >= lines.length) {
				return;
			}
			String currentLine = lines[index];
			String[] parts = currentLine.split(" ");
			String actor = parts[0];
			int value = Integer.parseInt(parts[1]);

			if (actor.equals("jmp")) {
				actor = "nop";
			} else if (actor.equals("nop")) {
				actor = "jmp";
			}

			if (actor.equals("acc"))
				accumulator += value;
			else if (actor.equals("jmp")) {
				linesExecuted.add(index);
				index += value++;
				continue;
			}



			index++;
		}

		// 1098 too high.
		output.setText("Total: " + accumulator);
	}
}
