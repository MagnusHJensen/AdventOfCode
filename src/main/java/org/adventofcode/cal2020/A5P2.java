package org.adventofcode.cal2020;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import org.adventofcode.templates.Assignment;
import org.adventofcode.templates.CalenderAssignment;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

@CalenderAssignment(calendarName = "2020", assignmentName = "DAY 5 PART 2", number = 10, description = "Placeholder.")
public class A5P2 extends Assignment {
	@FXML
	private TextArea input;
	@FXML
	private TextArea output;

	public A5P2(String name) {
		super(name);
	}

	@Override
	public Node getContent() throws IOException {
		Node content = loadDefaultContent(this);
		setInputContent(input, 2020, 5);
		return content;
	}

	@FXML
	public void run(ActionEvent event) {
		String[] lines = input.getText().split("\n");

		int seatId = 0;

		ArrayList<Integer> seats = new ArrayList<>();



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
					seats.add(calc);
				}
			}

		}


		Collections.sort(seats);
		int seat = seats.get(0);
		for (int i = 1; i < seats.size(); i++) {
			seat++;
			if (seats.get(i) != seat) {
				if (seatId == 0) {
					seatId = seat;
					break;
				}
			}
		}

		output.setText("My seat ID: " + seatId);
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
