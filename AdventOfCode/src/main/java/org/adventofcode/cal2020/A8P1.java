package org.adventofcode.cal2020;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import org.adventofcode.templates.Assignment;
import org.adventofcode.templates.CalenderAssignment;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

@CalenderAssignment(calendarName = "2020", assignmentName = "DAY 8 PART 1", number = 15, description = "Placeholder.")
public class A8P1 extends Assignment {
	@FXML
	private TextArea input;
	@FXML
	private TextArea output;

	public A8P1(String name) {
		super(name);
	}

	@Override
	public Node getContent() throws IOException {
		Node content = loadDefaultContent(this);
		setInputContent(input, 2020, 8);
		return content;
	}

	@FXML
	public void run(ActionEvent event) {
		String[] lines = input.getText().split("\n");

		ArrayList<Integer> linesExecuted = new ArrayList<>();

		int index = 0;
		int accumulator = 0;

		while (!linesExecuted.contains(index)) {
			String currentLine = lines[index];
			String[] parts = currentLine.split(" ");
			String actor = parts[0];
			int value = Integer.parseInt(parts[1]);

			if (actor.equals("acc"))
				accumulator += value;
			else if (actor.equals("jmp")) {
				linesExecuted.add(index);
				index += value++;
				continue;
			}


			linesExecuted.add(index);
			index++;

		}


		output.setText("Total: " + accumulator);
	}




}
