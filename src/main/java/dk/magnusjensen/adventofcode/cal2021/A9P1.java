package dk.magnusjensen.adventofcode.cal2021;

import dk.magnusjensen.adventofcode.templates.Assignment;
import dk.magnusjensen.adventofcode.templates.CalenderAssignment;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextArea;

import java.io.IOException;
import java.util.ArrayList;

@CalenderAssignment(calendarName = "2021", assignmentName = "placeholder", number = 17, description = "Placeholder.")
public class A9P1 extends Assignment {
	@FXML
	private TextArea input;
	@FXML
	private TextArea output;

	public A9P1(String name) {
		super(name);
	}

	@Override
	public Node getContent() throws IOException {
		Node content = loadDefaultContent(this);
		setInputContent(input, 2021, 9);
		return content;
	}
	ArrayList<Integer> lowPoints = new ArrayList<>();

	public void run(ActionEvent actionEvent) {
		String[] lines = input.getText().split("\n");
		int[][] heightmap = new int[lines.length][lines[0].length()];

		for (int y = 0; y < lines.length; y++) {
			String[] numbers = lines[y].split("");
			for (int x = 0; x < lines[y].toCharArray().length; x++) {
				heightmap[y][x] = Integer.parseInt(numbers[x]);
			}
		}

		boolean isLowPoint = true;
		for (int y = 0; y < heightmap.length; y++) {
			for (int x = 0; x < heightmap[y].length; x++) {
				int currentPoint = heightmap[y][x];
				if (y > 0) {
					isLowPoint = currentPoint < heightmap[y - 1][x];
					if (!isLowPoint) continue;
				}
				if (x > 0) {
					isLowPoint = currentPoint < heightmap[y][x - 1];
					if (!isLowPoint) continue;
				}
				if (y < heightmap.length - 1) {
					isLowPoint = currentPoint < heightmap[y + 1][x];
					if (!isLowPoint) continue;
				}
				if (x < heightmap[y].length - 1) {
					isLowPoint = currentPoint < heightmap[y][x + 1];
					if (!isLowPoint) continue;
				}

				if (isLowPoint) {
					lowPoints.add(currentPoint);
				}

			}
		}

		int sum = 0;
		for (int point : lowPoints) {
			System.out.println("Low point number: " + point);
			sum += point + 1;
		}

		System.out.println("Sum is: " + sum);



	}
}
