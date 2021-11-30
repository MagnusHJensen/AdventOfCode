package org.adventofcode.cal2015;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import org.adventofcode.templates.Assignment;
import org.adventofcode.templates.CalenderAssignment;
import org.adventofcode.utils.IntUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@CalenderAssignment(calendarName = "2015", assignmentName = "DAY 20", number = 41, description = "Placeholder.")
public class A20P1 extends Assignment {
	@FXML
	private TextArea input;
	@FXML
	private TextArea output;

	public A20P1(String name) {
		super(name);
	}

	@Override
	public Node getContent() throws IOException {
		Node content = loadDefaultContent(this);
		setInputContent(input, 2015, 7);
		return content;
	}

	@FXML
	public void run(ActionEvent event) {
		int totalValue = Integer.parseInt(input.getText());

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
