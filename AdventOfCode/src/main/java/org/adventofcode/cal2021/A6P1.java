package org.adventofcode.cal2021;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import org.adventofcode.templates.Assignment;
import org.adventofcode.templates.CalenderAssignment;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@CalenderAssignment(calendarName = "2021", assignmentName = "placeholder", number = 11, description = "Placeholder.")
public class A6P1 extends Assignment {
	@FXML
	private TextArea input;
	@FXML
	private TextArea output;

	public A6P1(String name) {
		super(name);
	}

	@Override
	public Node getContent() throws IOException {
		Node content = loadDefaultContent(this);
		setInputContent(input, 2021, 6);
		return content;
	}

	public void run(ActionEvent actionEvent) {
		Integer[] ages = Arrays.stream(input.getText().split("\n")[0].split(",")).map(Integer::parseInt).toArray(Integer[]::new);

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

		System.out.println(ages.length);
	}
}
