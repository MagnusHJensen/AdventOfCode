package dk.magnusjensen.adventofcode.cal2022;

import dk.magnusjensen.adventofcode.templates.Assignment;
import dk.magnusjensen.adventofcode.templates.CalenderAssignment;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

@CalenderAssignment(calendarName = 2022, assignmentName = "", number = 4, description = "")
public class A2P2 extends Assignment {
    
    @FXML
    private TextArea output;
    @FXML
    private Label outputLabel;

    public A2P2(String name) {
        super(name);
    }

    public void partOne(String input) {
        long start = System.nanoTime();
        String[] lines = input.split("\n");

        int total = 0;

        for (String line : lines) {
            String[] parts = line.split(" ");

            char opponent = parts[0].charAt(0);
            char roundOutcome = parts[1].charAt(0);

            total += roundOutcome == 'X' ? 0 : roundOutcome == 'Y' ? 3 : 6;

            total += calculateResponse(opponent, roundOutcome);

        }

        long end = System.nanoTime();
        outputLabel.setText("Output - Execution time: " + (end - start) / 1_000_000_000d);
        output.setText("Output: " + total);
    }

    private int calculateResponse(char opponent, char roundOutcome) {
        if (roundOutcome == 'Y') {
            return opponent == 'A' ? 1 : opponent == 'B' ? 2 : 3;
        }
        if (opponent == 'A' && roundOutcome == 'X') {
            return 3; // Scissors
        } else if (opponent == 'B' && roundOutcome == 'X') {
            return 1; // Rock
        } else if (opponent == 'C' && roundOutcome == 'X') {
            return 2; // Paper;
        } else if (opponent == 'A' && roundOutcome == 'Z') {
            return 2; // Scissors
        } else if (opponent == 'B' && roundOutcome == 'Z') {
            return 3; // Rock
        } else if (opponent == 'C' && roundOutcome == 'Z') {
            return 1; // Paper;
        }
        return 0;
    }
}
