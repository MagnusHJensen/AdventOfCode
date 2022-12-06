package dk.magnusjensen.adventofcode.cal2021.day_five;

import dk.magnusjensen.adventofcode.templates.Assignment;
import dk.magnusjensen.adventofcode.templates.CalenderAssignment;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextArea;

import java.io.IOException;
import java.util.ArrayList;

@CalenderAssignment(calendarName = 2021, assignmentName = "placeholder", number = 9, description = "Placeholder.")
public class A5P1 extends Assignment {
	
	@FXML
	private TextArea output;

	public A5P1(String name) {
		super(name);
	}

	@Override
	public Node getContent() throws IOException {
		Node content = loadDefaultContent(this);
		setInputContent(input, 2021, 5);
		return content;
	}

	public void partOne(String input) {
		String[] lines = input.split("\n");

		ArrayList<Line> pointLines = new ArrayList<>();

		int highestX = -1;
		int highestY = -1;
		for (String line : lines) {
			String[] points = line.split(" -> ");
			Point start = new Point(Integer.parseInt(points[0].split(",")[0]), Integer.parseInt(points[0].split(",")[1]));
			Point end = new Point(Integer.parseInt(points[1].split(",")[0]), Integer.parseInt(points[1].split(",")[1]));
			highestX = Math.max(highestX, Math.max(start.getX(), end.getX()));
			highestY = Math.max(highestY, Math.max(start.getY(), end.getY()));
			Line pointLine = new Line(start, end, false);
			pointLines.add(pointLine);
		}

		Board board = new Board(highestX + 1, highestY + 1);
		board.setLines(pointLines);


		System.out.println(board.getAmountOfOverlaps());


	}
}
