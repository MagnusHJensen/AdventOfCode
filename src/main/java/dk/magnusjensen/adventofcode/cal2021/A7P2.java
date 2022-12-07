package dk.magnusjensen.adventofcode.cal2021;

import dk.magnusjensen.adventofcode.templates.Assignment;
import dk.magnusjensen.adventofcode.templates.CalenderAssignment;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextArea;

import java.io.IOException;
import java.util.Arrays;

@CalenderAssignment(calendarName = 2021, assignmentName = "placeholder", number = 14, description = "Placeholder.")
public class A7P2 extends Assignment {
	
	@FXML
	private TextArea output;

	public A7P2(String name) {
		super(name);
	}

	public void partOne(String input) {
		int[] positions = Arrays.stream(input.split("\n")[0].split(",")).mapToInt(Integer::parseInt).toArray();

		Arrays.sort(positions);

		int lowestX = positions[0];
		int highestX = positions[positions.length - 1];
		int lowestFuelCost = Integer.MAX_VALUE;
		for (int i = lowestX; i <= highestX; i++) {
			int fuelSum = 0;
			for (int pos : positions) {
				int distance;
				if (pos > i) {
					distance = pos - i;
				} else {
					distance = i - pos;
				}

				for (int j = 1; j <= distance; j++) {
					fuelSum += j;
				}
			}

			if (fuelSum < lowestFuelCost) {
				lowestFuelCost = fuelSum;
			}
		}

		System.out.println(lowestFuelCost);

	}
}
