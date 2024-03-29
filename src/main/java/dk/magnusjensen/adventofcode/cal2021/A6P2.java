package dk.magnusjensen.adventofcode.cal2021;

import dk.magnusjensen.adventofcode.templates.Assignment;
import dk.magnusjensen.adventofcode.templates.CalenderAssignment;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@CalenderAssignment(calendarName = 2021, assignmentName = "placeholder", number = 12, description = "Placeholder.")
public class A6P2 extends Assignment {
	
	@FXML
	private TextArea output;
    @FXML
    private Label outputLabel;

	public A6P2(String name) {
		super(name);
	}

	public void partOne(String input) {
        long start = System.nanoTime();
		List<Long> ages = Arrays.stream(input.split("\n")[0].split(",")).map(Long::parseLong).collect(Collectors.toList());

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
        long end = System.nanoTime();
        outputLabel.setText("Output - Execution time: " + (end - start) / 1_000_000_000d);
        output.setText("How many lanternfish would there be after 256 days?\n- " + fishByAge.values().stream().mapToLong(Long::longValue).sum());

	}
}
