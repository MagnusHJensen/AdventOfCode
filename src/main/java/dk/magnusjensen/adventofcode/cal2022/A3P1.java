package dk.magnusjensen.adventofcode.cal2022;

import dk.magnusjensen.adventofcode.templates.Assignment;
import dk.magnusjensen.adventofcode.templates.CalenderAssignment;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

@CalenderAssignment(calendarName = 2022, assignmentName = "", number = 5, description = "")
public class A3P1 extends Assignment {
    
    @FXML
    private TextArea output;
    @FXML
    private Label outputLabel;

    public A3P1(String name) {
        super(name);
    }

    public void partOne(String input) {
        long start = System.nanoTime();
        String[] lines = input.split("\n");

        int sum = 0;

        for (String rucksack : lines) {
            String leftCompartment = rucksack.substring(0, (rucksack.length() / 2));
            String rightCompartment = rucksack.substring((rucksack.length() / 2));

            for (int i = 0; i < leftCompartment.length(); i++) {
                char leftChar = leftCompartment.charAt(i);

                if (rightCompartment.contains("" + leftChar)) {
                    if (Character.isUpperCase(leftChar)) {
                        sum += 27 + (leftChar - 65);
                    } else {
                        sum += 1 + (leftChar - 97);
                    }
                    break;
                }
            }
        }

        long end = System.nanoTime();
        outputLabel.setText("Output - Execution time: " + (end - start) / 1_000_000_000d);
        output.setText("Output: " + sum);

    }
}
