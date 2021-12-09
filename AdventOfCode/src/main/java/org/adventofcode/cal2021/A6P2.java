package org.adventofcode.cal2021;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import org.adventofcode.templates.Assignment;
import org.adventofcode.templates.CalenderAssignment;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@CalenderAssignment(calendarName = "2021", assignmentName = "placeholder", number = 12, description = "Placeholder.")
public class A6P2 extends Assignment {
	@FXML
	private TextArea input;
	@FXML
	private TextArea output;

	public A6P2(String name) {
		super(name);
	}

	@Override
	public Node getContent() throws IOException {
		Node content = loadDefaultContent(this);
		setInputContent(input, 2021, 6);
		return content;
	}

	public void run(ActionEvent actionEvent) {
		List<Long> ages = Arrays.stream(input.getText().split("\n")[0].split(",")).map(Long::parseLong).collect(Collectors.toList());

		HashMap<Long, Long> fishByAge = new HashMap<>();

		for (int i = 0; i <= 8; i++) {
			long day = i;
			fishByAge.put(day, ages.stream().filter((val) -> val == day).count());
		}



		for (int i = 0; i < 256; i++) {


			long newFish = 0;

			for (long day = 0; day <= 8; day++) {
				if (day == 0) {
					newFish = fishByAge.get(day);
				} else {
					fishByAge.put(day - 1, fishByAge.get(day));
				}
			}

			fishByAge.put(8L, newFish);
			fishByAge.put(6L, fishByAge.get(6L) + newFish);

		}

		System.out.println(fishByAge.values().stream().mapToLong(Long::longValue).sum());

	}
}
