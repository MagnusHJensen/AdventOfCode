package org.adventofcode.cal2018;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import org.adventofcode.templates.Assignment;
import org.adventofcode.templates.CalenderAssignment;

import java.io.IOException;

@CalenderAssignment(calendarName = "2018", assignmentName = "", number = 1, description = "")
public class A1P1 extends Assignment {
    @FXML
    private TextArea input;
    @FXML
    private TextArea output;
    @FXML
    private Label outputLabel;

    public A1P1(String name) {
        super(name);
    }

    @Override
    public Node getContent() throws IOException {
        Node content = loadDefaultContent(this);
        setInputContent(input, 2018, 1);
        return content;
    }

    @FXML
    public void run(ActionEvent event) {
        long start = System.currentTimeMillis();
        int frequency = 0;
        String[] lines = input.getText().split("\n");
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
