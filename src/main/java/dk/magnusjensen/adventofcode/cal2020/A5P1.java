package dk.magnusjensen.adventofcode.cal2020;

import dk.magnusjensen.adventofcode.templates.Assignment;
import dk.magnusjensen.adventofcode.templates.CalenderAssignment;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextArea;

import java.io.IOException;

@CalenderAssignment(calendarName = "2020", assignmentName = "DAY 5 PART 1", number = 9, description = "Placeholder.")
public class A5P1 extends Assignment {
	@FXML
	private TextArea input;
	@FXML
	private TextArea output;

	public A5P1(String name) {
		super(name);
	}

	@Override
	public Node getContent() throws IOException {
		Node content = loadDefaultContent(this);
		setInputContent(input, 2020, 5);
		return content;
	}

	// F means take the lower range
	// B Upper range
	// First 7 characters is the rows 0-127(B & F)
	// Last 3 characters is the column 0-7(R & L)
	// R means take the upper range
	// L means take the lower range.

	@FXML
	public void run(ActionEvent event) {
		String[] lines = input.getText().split("\n");

		int highestSeatID = -125125;

		for (String line : lines) {
			int[] rowRange = new int[] {0, 127};
			int[] colRange = new int[] {0, 7};
			String rowChars = line.substring(0, 7);
			String columnChars = line.substring(7);
			for (char rowChr : rowChars.toCharArray()) {
				rowRange = this.maxMin(rowChr, rowRange);
			}

			for (char colChr : columnChars.toCharArray()) {
				colRange = this.maxMin(colChr, colRange);
			}

			if (rowRange[0] == rowRange[1]) {
				if (colRange[0] == colRange[1]) {
					int calc = rowRange[0] * 8 + colRange[0];
					if (highestSeatID < calc) {
						highestSeatID = calc;
					}
				}
			}

		}


		output.setText("Highest ID: " + highestSeatID);
	}

	public int[] maxMin(char chr, int[] range) {
		int half = (int) Math.floor((range[1] - range[0]) / 2) + range[0];
		if (chr == 'F' || chr == 'L') {
			range[1] = half;
		} else if (chr == 'B' || chr == 'R') {
			range[0] = half + 1;
		}

		return range;
	}



}
