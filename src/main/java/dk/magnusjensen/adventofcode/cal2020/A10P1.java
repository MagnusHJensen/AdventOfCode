package dk.magnusjensen.adventofcode.cal2020;

import dk.magnusjensen.adventofcode.templates.Assignment;
import dk.magnusjensen.adventofcode.templates.CalenderAssignment;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextArea;

import java.io.IOException;
import java.util.Arrays;

@CalenderAssignment(calendarName = 2020, assignmentName = "DAY 10 PART 1", number = 19, description = "Placeholder.")
public class A10P1 extends Assignment {
	
	@FXML
	private TextArea output;

	public A10P1(String name) {
		super(name);
	}

	@Override
	public Node getContent() throws IOException {
		Node content = loadDefaultContent(this);
		setInputContent(input, 2020, 10);
		return content;
	}

	@FXML
	public void partOne(String input) {
		String[] lines = input.split("\n");

		int[] numbers = new int[lines.length];

		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = Integer.parseInt(lines[i]);
		}

		Arrays.sort(numbers);


		int oneDiff = 0;
		int threeDiff = 0;
		int currentVoltage = 0;

		for (int i = 0; i < numbers.length; i++) {
			int value = numbers[i];
			if (value == currentVoltage + 1) {
				oneDiff++;
				currentVoltage++;
			} else if (value == currentVoltage + 3) {
				threeDiff++;
				currentVoltage += 3;
			}
		}
		
		threeDiff++;


		// 2240 too low.
		output.setText("Mutliply is: " + (oneDiff * threeDiff));

	}









}
