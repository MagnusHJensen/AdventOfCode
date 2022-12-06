package dk.magnusjensen.adventofcode.cal2018;

import dk.magnusjensen.adventofcode.templates.Assignment;
import dk.magnusjensen.adventofcode.templates.CalenderAssignment;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

import java.io.IOException;

@CalenderAssignment(calendarName = 2018, assignmentName = "", number = 1, description = "")
public class A1P1 extends Assignment {
    
    @FXML
    private TextArea output;
    @FXML
    private Label outputLabel;

    public A1P1(String name) {
        super(name);
    }

    

    @FXML
    public void partOne(String input) {
        long start = System.currentTimeMillis();
        int frequency = 0;
        String[] lines = input.split("\n");
        for (String line : lines) {
            char sign = line.charAt(0);
            int amount = Integer.parseInt(line.substring(1));

            if (sign == '+') {
                frequency += amount;
            } else {
                frequency -= amount;
            }
        }

        long stop = System.currentTimeMillis();

        outputLabel.setText("Output - Execution time: " + (stop - start) + "ms");

        output.setText("Current frequency is: " + frequency);
    }
}
