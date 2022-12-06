package dk.magnusjensen.adventofcode.cal2015;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import dk.magnusjensen.adventofcode.templates.Assignment;
import dk.magnusjensen.adventofcode.templates.CalenderAssignment;

import java.io.IOException;

@CalenderAssignment(calendarName = 2015, assignmentName = "DAY 20", number = 41, description = "Placeholder.")
public class A20P1 extends Assignment {
	
	@FXML
	private TextArea output;

	public A20P1(String name) {
		super(name);
	}

	@FXML
	public void partOne(String input) {
		int totalValue = Integer.parseInt(input);

		int houseValue = 0;
		int index = 1;
		while (houseValue < totalValue) {
			int currentHouseValue = 0;
			for (int i = 1; i <= index; i++) {
				if (i % index == 0) {
					currentHouseValue += i * 10;
				}
			}

			if (currentHouseValue > houseValue) {
				houseValue = currentHouseValue;
			}

			System.out.println(currentHouseValue + " - Index: " + index);
			index++;
		}

		output.setText("Total: " + houseValue);

	}
}
