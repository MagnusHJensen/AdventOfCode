package dk.magnusjensen.adventofcode.cal2020;

import dk.magnusjensen.adventofcode.templates.Assignment;
import dk.magnusjensen.adventofcode.templates.CalenderAssignment;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextArea;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

@CalenderAssignment(calendarName = 2020, assignmentName = "DAY 7 PART 1", number = 13, description = "Placeholder.")
public class A7P1 extends Assignment {
	
	@FXML
	private TextArea output;

	public A7P1(String name) {
		super(name);
	}

	

	@FXML
	public void partOne(String input) {
		String[] lines = input.split("\n");

		int total = 0;

		ArrayList<String> bagsHoldingGold = new ArrayList<>();

		for (String line : lines) {

		}


		output.setText("Total: " + total);
	}

	public class Bag {
		public String color;
		public HashMap<String, Integer> contains = new HashMap<>();

		public Bag (String color) {
			this.color = color;
		}

		public void addContains(String color, Integer amount) {
			contains.put(color, amount);
		}
	}


}
