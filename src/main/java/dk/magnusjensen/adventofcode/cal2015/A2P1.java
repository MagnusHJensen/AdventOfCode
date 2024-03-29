package dk.magnusjensen.adventofcode.cal2015;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import dk.magnusjensen.adventofcode.templates.Assignment;
import dk.magnusjensen.adventofcode.templates.CalenderAssignment;

import java.io.IOException;

@CalenderAssignment(calendarName = 2015, assignmentName = "I was told there would be no math.", number = 3, description = "Calculate how much ")
public class A2P1 extends Assignment {

	@FXML
	private TextArea output;

	public A2P1(String name) {
		super(name);
	}

	@FXML
	public void partOne(String input) {
		int totalAmountOfRibbon = 0;

		for (String line : input.split("\n")) {

			String[] dimensions = line.split("x");
			int length = Integer.parseInt(dimensions[0]);
			int width = Integer.parseInt(dimensions[1]);
			int height = Integer.parseInt(dimensions[2]);

			int face1 = length * width;
			int face2 = width * height;
			int face3 = length * height;

			int amountOfRibbon = 2*face1 + 2*face2 + 2*face3 + Math.min(face1, Math.min(face2, face3));


			totalAmountOfRibbon += amountOfRibbon;

		}

		output.setText(String.format("The elves needs a total of %d square feet of ribbon, to wrap all the presents.", totalAmountOfRibbon));
	}
}
