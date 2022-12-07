package dk.magnusjensen.adventofcode.cal2021;

import dk.magnusjensen.adventofcode.templates.Assignment;
import dk.magnusjensen.adventofcode.templates.CalenderAssignment;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

import java.io.IOException;
import java.util.Arrays;

@CalenderAssignment(calendarName = 2021, assignmentName = "placeholder", number = 11, description = "Placeholder.")
public class A6P1 extends Assignment {
	
	@FXML
	private TextArea output;
    @FXML
    private Label outputLabel;

	public A6P1(String name) {
		super(name);
	}

	public void partOne(String input) {
        long start = System.nanoTime();
		Integer[] ages = Arrays.stream(input.split("\n")[0].split(",")).map(Integer::parseInt).toArray(Integer[]::new);

		for (int i = 0; i < 80; i++) {

			Integer[] copyList = Arrays.copyOf(ages, ages.length);
			int amountOfNew = 0;
			for (int idx = 0; idx < copyList.length; idx++) {
				if (copyList[idx] == 0) {
					copyList[idx] = 6;
					amountOfNew++;
				} else {
					copyList[idx] = copyList[idx] - 1;
				}

			}

			if (amountOfNew > 0) {
				copyList = Arrays.copyOf(copyList, copyList.length + amountOfNew);
				for (int idx = copyList.length - amountOfNew; idx < copyList.length; idx++) {
					copyList[idx] = 8;
				}
			}

			ages = copyList;

			System.out.println(i);
		}

        long end = System.nanoTime();
        outputLabel.setText("Output - Execution time: " + ((end - start) / 1_000_000_000d));
        output.setText("How many lanternfish would there be after 80 days?\n- " + ages.length);
	}
}
