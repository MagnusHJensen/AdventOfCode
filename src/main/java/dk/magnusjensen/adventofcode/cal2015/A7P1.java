package dk.magnusjensen.adventofcode.cal2015;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import dk.magnusjensen.adventofcode.templates.Assignment;
import dk.magnusjensen.adventofcode.templates.CalenderAssignment;
import dk.magnusjensen.adventofcode.utils.IntUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@CalenderAssignment(calendarName = "2015", assignmentName = "Some Assembly Required", number = 13, description = "Placeholder.")
public class A7P1 extends Assignment {
	@FXML
	private TextArea input;
	@FXML
	private TextArea output;

	public A7P1(String name) {
		super(name);
	}

	@Override
	public Node getContent() throws IOException {
		Node content = loadDefaultContent(this);
		setInputContent(input, 2015, 7);
		return content;
	}

	@FXML
	public void run(ActionEvent event) {
		HashMap<String, Integer> wires = new HashMap<>();

		List<String> lines = new ArrayList<>(Arrays.asList(input.getText().split("\n")));

		ArrayList<Integer> intsToRemove = new ArrayList<>();

		int index = 0;
		for (String line : lines) {
			String[] parts = line.split(" ");
			if (parts.length == 3) {
				try {
					int value = Integer.parseInt(parts[0]);
					wires.put(parts[2], value);
					intsToRemove.add(index);
				} catch (NumberFormatException ex) {
					if (wires.containsKey(parts[0])) {
						wires.put(parts[2], wires.get(parts[0]));
						intsToRemove.add(index);
					}
				}
			}
			index++;
		}


		for (int i = intsToRemove.size() - 1; i > -1; i--) {
			lines.remove(i);
		}

		int decrementor = lines.size() - 1;
		while (lines.size() > 0) {

			System.out.println(lines.get(decrementor));

			String[] sides = lines.get(decrementor).split("->");
			String[] connection = sides[0].stripTrailing().split(" ");
			String output = sides[1].stripLeading();

			try {
				if (connection[0].equals("NOT")) {
					if (wires.containsKey(connection[1])) {
						int value = wires.get(connection[1]);
						value = IntUtil.NOTGate(value);
						wires.put(output, value);
						lines.remove(decrementor);
					}
				} else if (sides[0].contains("AND")) {
					try {
						int value1 = Integer.parseInt(connection[0]);
						if (wires.containsKey(connection[2])) {
							int value2 = wires.get(connection[2]);
							int out = IntUtil.ANDGate(value1, value2);

							wires.put(output, out);
							lines.remove(decrementor);
						}
					} catch (NumberFormatException ex) {
						if (wires.containsKey(connection[0]) && wires.containsKey(connection[2])) {
							int value1 = wires.get(connection[0]);
							int value2 = wires.get(connection[2]);
							int out = IntUtil.ANDGate(value1, value2);
							wires.put(output, out);
							lines.remove(decrementor);
						}
					}

				} else if (sides[0].contains("OR")) {
					if (wires.containsKey(connection[0]) && wires.containsKey(connection[2])) {
						int value1 = wires.get(connection[0]);
						int value2 = wires.get(connection[2]);
						int out = IntUtil.ORGate(value1, value2);
						wires.put(output, out);
						lines.remove(decrementor);
					}



				} else if (sides[0].contains("RSHIFT")) {
					if (wires.containsKey(connection[0])) {
						int value1 = wires.get(connection[0]);
						int amount = Integer.parseInt(connection[2]);
						int out = IntUtil.RIGHTShift(value1, amount);
						wires.put(output, out);
						lines.remove(decrementor);
					}
				} else if (sides[0].contains("LSHIFT")) {
					if (wires.containsKey(connection[0])) {
						int value1 = wires.get(connection[0]);
						int amount = Integer.parseInt(connection[2]);
						int out = IntUtil.RIGHTShift(value1, amount);
						wires.put(output, out);
						lines.remove(decrementor);
					}
				} else {
					if (sides[0].length() == 1) {
						if (wires.containsKey(connection[0])) {
							String supplier = connection[0];
							int value = wires.get(supplier);
							wires.put(output, value);
							lines.remove(decrementor);
						}
					}
				}
			} catch (UnsupportedOperationException ex) {
				System.out.println(ex.getMessage());
			}

			decrementor--;
			if (decrementor == -1) {
				decrementor = lines.size() - 1;
			}
			System.out.println(lines.size());
		}

		wires.forEach((name, value) -> {
			output.appendText(name + " - " + value + "\n");
		});
	}
}
