package dk.magnusjensen.adventofcode.cal2020;

import dk.magnusjensen.adventofcode.templates.Assignment;
import dk.magnusjensen.adventofcode.templates.CalenderAssignment;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextArea;

import java.io.IOException;
import java.util.ArrayList;

@CalenderAssignment(calendarName = 2020, assignmentName = "DAY 8 PART 1", number = 15, description = "Placeholder.")
public class A8P1 extends Assignment {
	
	@FXML
	private TextArea output;

	public A8P1(String name) {
		super(name);
	}


	@FXML
	public void partOne(String input) {
		String[] lines = input.split("\n");

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
