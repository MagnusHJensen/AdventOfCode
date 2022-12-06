package dk.magnusjensen.adventofcode.cal2021;

import dk.magnusjensen.adventofcode.templates.Assignment;
import dk.magnusjensen.adventofcode.templates.CalenderAssignment;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextArea;

import java.io.IOException;

@CalenderAssignment(calendarName = 2021, assignmentName = "Binary Diagnostic", number = 5, description = "Placeholder.")
public class A3P1 extends Assignment {
	
	@FXML
	private TextArea output;

	public A3P1(String name) {
		super(name);
	}

	@Override
	public Node getContent() throws IOException {
		Node content = loadDefaultContent(this);
		setInputContent(input, 2021, 3);
		return content;
	}

	public void partOne(String input) {
		String[] lines = input.split("\n");

		String finalGammaBinary = "";

		for (int i = 0; i < lines[0].length(); i++) {
			int oneOcurence = 0;
			int zeroOcurence = 0;
			for (String line : lines) {
				if (line.charAt(i) == '1') oneOcurence++;
				else zeroOcurence++;
			}

			if (oneOcurence > zeroOcurence) finalGammaBinary += "1";
			else finalGammaBinary += "0";
		}

		StringBuilder epsilonRate = new StringBuilder();

		for (char chr : finalGammaBinary.toCharArray()) {
			if (chr == '1') {
				epsilonRate.append("0");
			} else {
				epsilonRate.append("1");
			}
		}

		System.out.println(epsilonRate.toString());

		output.setText("Final Gamma Rate is: " + finalGammaBinary + " - Decimal is: " + Integer.parseInt(finalGammaBinary, 2) + "\n Final Epsilon rate is " + epsilonRate + " - Deicmal is " + Integer.parseInt(epsilonRate.toString(), 2) + "\nMultiplied is: " + (Integer.parseInt(finalGammaBinary, 2) * Integer.parseInt(epsilonRate.toString(), 2)));


	}
}
