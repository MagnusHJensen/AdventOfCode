package dk.magnusjensen.adventofcode.cal2021;

import dk.magnusjensen.adventofcode.templates.Assignment;
import dk.magnusjensen.adventofcode.templates.CalenderAssignment;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextArea;

import java.io.IOException;
import java.util.Arrays;

@CalenderAssignment(calendarName = "2021", assignmentName = "placeholder", number = 13, description = "Placeholder.")
public class A7P1 extends Assignment {
	@FXML
	private TextArea input;
	@FXML
	private TextArea output;

	public A7P1(String name) {
		super(name);
	}

	@Override
	public Node getContent() throws IOException {
		Node content = loadDefaultContent(this);
		setInputContent(input, 2021, 7);
		return content;
	}

	public void run(ActionEvent actionEvent) {
		int[] positions = Arrays.stream(input.getText().split("\n")[0].split(",")).mapToInt(Integer::parseInt).toArray();

		Arrays.sort(positions);

		int lowestX = positions[0];
		int highestX = positions[positions.length - 1];
		int lowestFuelCost = Integer.MAX_VALUE;
		for (int i = lowestX; i <= highestX; i++) {
			int fuelSum = 0;
			for (int pos : positions) {
				if (pos > i) {
					fuelSum += pos - i;
				} else {
					fuelSum += i - pos;
				}
			}

			if (fuelSum < lowestFuelCost) {
				lowestFuelCost = fuelSum;
			}
		}

		System.out.println(lowestFuelCost);



	}
}
