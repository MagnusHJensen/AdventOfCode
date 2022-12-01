package dk.magnusjensen.adventofcode.cal2020;

import dk.magnusjensen.adventofcode.templates.Assignment;
import dk.magnusjensen.adventofcode.templates.CalenderAssignment;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextArea;

import java.io.IOException;

@CalenderAssignment(calendarName = "2020", assignmentName = "DAY 13 PART 1" + "", number = 25, description = "Placeholder.")
public class A13P1 extends Assignment {
	@FXML
	private TextArea input;
	@FXML
	private TextArea output;

	private int n = 0;
	private int e = 0;
	private int s = 0;
	private int w = 0;
	private int angle = 90;


	public A13P1(String name) {
		super(name);
	}

	@Override
	public Node getContent() throws IOException {
		Node content = loadDefaultContent(this);
		setInputContent(input, 2020, 13);
		return content;
	}

	@FXML
	public void run(ActionEvent event) {
		String[] lines = input.getText().split("\n");

		for (String line : lines) {
			char action = line.charAt(0);
			int value = Integer.parseInt(line.substring(1));

			switch (action) {
				case 'N':
				case 'S': {
					processNorthOrSouth(action, value);
					break;
				}
				case 'W':
				case 'E': {
					processWestOrEast(action, value);
					break;
				}
				case 'L':
				case 'R': {
					processLeftOrRight(action, value);
					break;
				}
				case 'F': {
					processForward(value);
					break;
				}
			}
		}

		// 122 TOO LOW.

		// 996 TOO HIGH.

		output.setText("Sum of Position: " + (Math.max(w, e) + Math.max(n, s)));


	}



	public void processNorthOrSouth(char action, int value) {
		if (action == 'N') {
			this.n += value;
		} else {
			this.s += value;
		}
	}

	public void processWestOrEast(char action, int value) {
		if (action == 'E') {
			this.e += value;
		} else {
			this.w += value;
		}
	}

	public void processLeftOrRight(char action, int value) {
		if (action == 'L') {
			int sum = this.angle - value;
			if (sum < 0) {
				this.angle = 360 - sum;
			} else {
				this.angle = sum;
			}
		} else {
			int sum = this.angle + value;
			if (sum > 360) {
				this.angle = 360 - sum;
			} else {
				this.angle = sum;
			}
		}
	}

	public void processForward(int value) {
		switch (this.angle) {
			case 0: {
				this.n += value;
				break;
			}
			case 90: {
				this.e += value;
				break;
			}
			case 180: {
				this.s += value;
				break;
			}
			case 270: {
				this.w += value;
				break;
			}
		}
	}


}
