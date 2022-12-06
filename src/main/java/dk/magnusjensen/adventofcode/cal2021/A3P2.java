package dk.magnusjensen.adventofcode.cal2021;

import dk.magnusjensen.adventofcode.templates.Assignment;
import dk.magnusjensen.adventofcode.templates.CalenderAssignment;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextArea;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@CalenderAssignment(calendarName = 2021, assignmentName = "Life support rating", number = 6, description = "Placeholder.")
public class A3P2 extends Assignment {
	
	@FXML
	private TextArea output;

	public A3P2(String name) {
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

		StringBuilder sb = new StringBuilder();


		List<String> oxygenRating = findOxygenGeneratorRating(List.of(lines), 0);
		List<String> co2Rating = findCO2ScrubberRating(List.of(lines), 0);

		sb.append("Oxygen rating binary is: ").append(oxygenRating.get(0));
		sb.append(" - Decimal is: ").append(Integer.parseInt(oxygenRating.get(0), 2)).append("\n");
		sb.append("CO2 rating binary is: ").append(co2Rating.get(0));
		sb.append(" - Decimal is: ").append(Integer.parseInt(co2Rating.get(0), 2)).append("\n");
		sb.append("Multiplied is: ").append((Integer.parseInt(oxygenRating.get(0), 2) * Integer.parseInt(co2Rating.get(0), 2)));
		output.setText(sb.toString());
	}

	public List<String> findOxygenGeneratorRating(List<String> validNumbers, int bitPosition) {
		if (validNumbers.size() == 1) return validNumbers;

		ArrayList<String> keptNumbers = new ArrayList<>();
		int oneOcurence = 0;
		int zeroOcurence = 0;
		for (String line : validNumbers) {
			if (line.charAt(bitPosition) == '1') oneOcurence++;
			else zeroOcurence++;
		}

		boolean keepOnesFlag = false;
		boolean sortOutOnes = oneOcurence > zeroOcurence;
		if (oneOcurence == zeroOcurence) keepOnesFlag = true;

		for (String line : validNumbers) {
			if (keepOnesFlag && line.charAt(bitPosition) == '1') {
				keptNumbers.add(line);
			}
			else if (line.charAt(bitPosition) == '1' && sortOutOnes && !keepOnesFlag) {
				keptNumbers.add(line);
			} else if (line.charAt(bitPosition) == '0' && !sortOutOnes && !keepOnesFlag) {
				keptNumbers.add(line);
			}
		}

		return findOxygenGeneratorRating(keptNumbers, bitPosition + 1);
	}

	public List<String> findCO2ScrubberRating(List<String> validNumbers, int bitPosition) {
		if (validNumbers.size() == 1) return validNumbers;

		ArrayList<String> keptNumbers = new ArrayList<>();
		int oneOcurence = 0;
		int zeroOcurence = 0;
		for (String line : validNumbers) {
			if (line.charAt(bitPosition) == '1') oneOcurence++;
			else zeroOcurence++;
		}

		boolean keepZeroFlag = false;
		boolean sortOutOnes = oneOcurence < zeroOcurence;
		if (oneOcurence == zeroOcurence) keepZeroFlag = true;

		for (String line : validNumbers) {
			if (keepZeroFlag && line.charAt(bitPosition) == '0') {
				keptNumbers.add(line);
			}
			else if (line.charAt(bitPosition) == '1' && sortOutOnes && !keepZeroFlag) {
				keptNumbers.add(line);
			} else if (line.charAt(bitPosition) == '0' && !sortOutOnes && !keepZeroFlag) {
				keptNumbers.add(line);
			}
		}

		return findCO2ScrubberRating(keptNumbers, bitPosition + 1);
	}
}
