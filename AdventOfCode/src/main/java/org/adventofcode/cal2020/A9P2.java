package org.adventofcode.cal2020;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import org.adventofcode.templates.Assignment;
import org.adventofcode.templates.CalenderAssignment;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@CalenderAssignment(calendarName = "2020", assignmentName = "DAY 9 PART 2", number = 18, description = "Placeholder.")
public class A9P2 extends Assignment {
	@FXML
	private TextArea input;
	@FXML
	private TextArea output;

	public A9P2(String name) {
		super(name);
	}

	@Override
	public Node getContent() throws IOException {
		Node content = loadDefaultContent(this);
		setInputContent(input, 2020, 9);
		return content;
	}

	@FXML
	public void run(ActionEvent event) {
		String[] lines = input.getText().split("\n");

		ArrayList<Long> numbers = new ArrayList<>();
		for (String line : lines) {
			numbers.add(Long.parseLong(line));
		}

		part2(numbers);


		// 58495652627440 too high
		// 138575702521725 even higher

		output.setText("Total: ");
	}

	public void part2(List<Long> numbers) {
		var queue = new ArrayDeque<Long>(numbers);
		var preamble = new ArrayDeque<Long>();
		var weak = 0l;
		for (int i = 0; i < 25; i++) {
			preamble.add(queue.pop());
		}
		for (var n : queue) {
			var found = false;
			for (var n1 : preamble) {
				for (var n2 : preamble) {
					if (n1 + n2 == n) {
						found = true;
					}
				}
			}
			if (found) {
				preamble.pop();
				preamble.add(n);
			} else {
				weak = n;
				break;
			}
		}
		var contiguous = new ArrayList<Long>();
		int i = 0;
		while (contiguous.stream().mapToLong(x->x).sum() != weak) {
			contiguous = new ArrayList<Long>();
			int j = i;
			while (contiguous.stream().mapToLong(x->x).sum() < weak) {
				contiguous.add(numbers.get(j++));
			}
			i++;
		}
		System.out.println(contiguous.stream().mapToLong(x->x).min().getAsLong()+contiguous.stream().mapToLong(x->x).max().getAsLong());
	}







}
