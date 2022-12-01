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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CalenderAssignment(calendarName = "2018", assignmentName = "", number = 3, description = "")
public class A2P1 extends Assignment {
    @FXML
    private TextArea input;
    @FXML
    private TextArea output;
    @FXML
    private Label outputLabel;

    public A2P1(String name) {
        super(name);
    }

    @Override
    public Node getContent() throws IOException {
        Node content = loadDefaultContent(this);
        setInputContent(input, 2018, 2);
        return content;
    }

    @FXML
    public void run(ActionEvent event) {
        long start = System.currentTimeMillis();

        int twoLetterCount = 0;
        int threeLetterCount = 0;
        String[] lines = input.getText().split("\n");

        HashMap<Character, Integer> letterCount = new HashMap<>();
        for (String line : lines) {
            char[] letters = line.toCharArray();
            for (char chr : letters) {
                if (letterCount.containsKey(chr)) {
                    letterCount.put(chr, letterCount.get(chr) + 1);
                } else {
                    letterCount.put(chr, 1);
                }
            }

            boolean hasTwoLetterCount = false;
            boolean hasThreeLetterCount = false;
            for (Map.Entry<Character, Integer> entry : letterCount.entrySet()) {
                if (!hasTwoLetterCount && entry.getValue() == 2) {
                    hasTwoLetterCount = true;
                    twoLetterCount++;
                } else if (!hasThreeLetterCount && entry.getValue() == 3) {
                    hasThreeLetterCount = true;
                    threeLetterCount++;
                }

                if (hasThreeLetterCount && hasTwoLetterCount) {
                    break;
                }
            }


            letterCount.clear();
        }

        long stop = System.currentTimeMillis();

        outputLabel.setText("Output - Execution time: " + (stop - start) + "ms");
        output.setText(String.format("Output: %d\nTwo letter count: %d\nThree letter count: %d", (twoLetterCount * threeLetterCount), twoLetterCount, threeLetterCount));
    }
}
