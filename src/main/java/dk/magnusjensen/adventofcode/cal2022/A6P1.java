package dk.magnusjensen.adventofcode.cal2022;

import dk.magnusjensen.adventofcode.templates.Assignment;
import dk.magnusjensen.adventofcode.templates.CalenderAssignment;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

import java.util.HashSet;
import java.util.Set;

@CalenderAssignment(calendarName = 2022, assignmentName = "", number = 11, description = "")
public class A6P1 extends Assignment {
    
    @FXML
    private TextArea output;

    public A6P1(String name) {
        super(name);
    }

    public void partOne(String input) {
        String line = input;

        String outputText = "";

        for (int i = 4; i < line.length(); i++) {
            Set<Character> seenChars = new HashSet<>();
            for (int k = i - 4; k < i; k++) {
                seenChars.add(line.charAt(k));
            }

            if (seenChars.size() == 4) {
                outputText = line.substring(0, i);
                break;
            }
        }



        output.setText("Output: " + outputText.length());
    }
}
