package org.adventofcode.cal2015;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import org.adventofcode.templates.Assignment;
import org.adventofcode.templates.CalenderAssignment;

import java.io.IOException;
import java.util.Arrays;

@CalenderAssignment(calendarName = "2015", assignmentName = "Total length of ribbon", number = 4, description = "Calculate how much ribbon, the elves need to order.")
public class A2P2 extends Assignment {

	@FXML
	private TextArea input;
	@FXML
	private TextArea output;

	public A2P2(String name) {
		super(name);
	}

	@Override
	public Node getContent() throws IOException {
		Node content = loadDefaultContent(this);
		setInputContent(input, 2015, 2);
		return content;
	}

	@FXML
	public void run(ActionEvent event) {
		int totalAmountOfRibbon = 0;

		for (String line : input.getText().split("\n")) {

			String[] dimensions = line.split("x");
			int length = Integer.parseInt(dimensions[0]);
			int width = Integer.parseInt(dimensions[1]);
			int height = Integer.parseInt(dimensions[2]);

			int[] sizes = new int[] {length, width, height};

			Arrays.sort(sizes);

			int perimeter = 2 * sizes[0] + 2 * sizes[1];

			int amountOfRibbon = perimeter + length * width * height;

			totalAmountOfRibbon += amountOfRibbon;
		}

		output.setText("The elves need a total feet of " + totalAmountOfRibbon + " to wrap all presents.");
	}
}
