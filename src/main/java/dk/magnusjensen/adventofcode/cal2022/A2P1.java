package dk.magnusjensen.adventofcode.cal2022;

import dk.magnusjensen.adventofcode.templates.Assignment;
import dk.magnusjensen.adventofcode.templates.CalenderAssignment;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

@CalenderAssignment(calendarName = 2022, assignmentName = "Rock Paper Scissors", number = 3, description = "")
public class A2P1 extends Assignment {
    
    @FXML
    private TextArea output;
    @FXML
    private Label outputLabel;

    public A2P1(String name) {
        super(name);
    }

    public void partOne(String input) {
        long start = System.nanoTime();
        String[] lines = input.split("\n");
        int total = 0;

        for (String line : lines) {
            String[] parts = line.split(" ");

            char first = parts[0].charAt(0);
            char second = parts[1].charAt(0);

            total += second == 'X' ? 1 : second == 'Y' ? 2 : 3;

            if ((second == 'X' && first == 'A') || (second == 'Y' && first == 'B') || (second == 'Z' && first == 'C')) {
                total += 3;
            }
             else if ((second == 'X' && first == 'C') || (second == 'Y' && first == 'A') || (second == 'Z' && first == 'B')) {
                total += 6;
            }
        }

        long end = System.nanoTime();
        outputLabel.setText("Output - Execution time: " + (end - start) / 1_000_000_000d);
        output.setText("Output: " + total);
    }
}
