package org.adventofcode.cal2018;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import org.adventofcode.templates.Assignment;
import org.adventofcode.templates.CalenderAssignment;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@CalenderAssignment(calendarName = "2018", assignmentName = "", number = 2, description = "")
public class A1P2 extends Assignment {
    @FXML
    private TextArea input;
    @FXML
    private TextArea output;
    @FXML
    private Label outputLabel;

    public A1P2(String name) {
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

        Set<Integer> seenFrequencies = new HashSet<>();
        int frequency = 0;
        String[] lines = input.getText().split("\n");

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
