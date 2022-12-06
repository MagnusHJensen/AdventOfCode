package dk.magnusjensen.adventofcode.cal2018;

import dk.magnusjensen.adventofcode.templates.Assignment;
import dk.magnusjensen.adventofcode.templates.CalenderAssignment;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@CalenderAssignment(calendarName = 2018, assignmentName = "", number = 2, description = "")
public class A1P2 extends Assignment {
    
    @FXML
    private TextArea output;
    @FXML
    private Label outputLabel;

    public A1P2(String name) {
        super(name);
    }

    

    @FXML
    public void partOne(String input) {
        long start = System.currentTimeMillis();

        Set<Integer> seenFrequencies = new HashSet<>();
        int frequency = 0;
        String[] lines = input.split("\n");

        for (int i = 0; i < lines.length; i++) {
            String line = lines[i];
            if (seenFrequencies.contains(frequency)) {
                break;
            }
            seenFrequencies.add(frequency);
            char sign = line.charAt(0);
            int amount = Integer.parseInt(line.substring(1));

            if (sign == '+') {
                frequency += amount;
            } else {
                frequency -= amount;
            }

            if (i == lines.length - 1) {
                i = -1;
            }
        }

        long stop = System.currentTimeMillis();

        outputLabel.setText("Output - Execution time: " + (stop - start) + "ms");
        output.setText("Current frequency is: " + frequency);
    }
}
