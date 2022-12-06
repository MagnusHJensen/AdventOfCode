package dk.magnusjensen.adventofcode.cal2022;

import dk.magnusjensen.adventofcode.templates.Assignment;
import dk.magnusjensen.adventofcode.templates.CalenderAssignment;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@CalenderAssignment(calendarName = 2022, assignmentName = "", number = 6, description = "")
public class A3P2 extends Assignment {
    
    @FXML
    private TextArea output;
    @FXML
    private Label outputLabel;

    public A3P2(String name) {
        super(name);
    }

    public void partOne(String input) {
        long start = System.nanoTime();
        String[] lines = input.split("\n");

        AtomicInteger sum = new AtomicInteger();
        HashMap<Character, Integer> chars = new HashMap<>();
        int counter = 1;

        for (String line : lines) {
            if (counter == 4) {
                for (Map.Entry<Character, Integer> entry : chars.entrySet()) {
                    if (entry.getValue() == 3) {
                        if (Character.isUpperCase(entry.getKey())) {
                            sum.addAndGet(27 + (entry.getKey() - 65));
                        } else {
                            sum.addAndGet(1 + (entry.getKey() - 97));
                        }
                        chars.clear();
                        counter = 1;
                        break;
                    }
                }
            }
            Set<Character> filteredChars = new HashSet<>();
            for (char chr : line.toCharArray()) {
                filteredChars.add(chr);
            }

            for (char chr : filteredChars) {
                chars.put(chr, chars.getOrDefault(chr, 0) + 1);
            }


            counter += 1;
        }

        for (Map.Entry<Character, Integer> entry : chars.entrySet()) {
            if (entry.getValue() == 3) {
                if (Character.isUpperCase(entry.getKey())) {
                    sum.addAndGet(27 + (entry.getKey() - 65));
                } else {
                    sum.addAndGet(1 + (entry.getKey() - 97));
                }
                chars.clear();
                break;
            }
        }

        long end = System.nanoTime();
        outputLabel.setText("Output - Execution time: " + (end - start) / 1_000_000_000d);
        output.setText("Output: " + sum);
    }
}
