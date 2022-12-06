package dk.magnusjensen.adventofcode.cal2015;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import dk.magnusjensen.adventofcode.templates.Assignment;
import dk.magnusjensen.adventofcode.templates.CalenderAssignment;

import java.io.IOException;

@CalenderAssignment(calendarName = 2015, assignmentName = "Santa in elevator", number = 1, description = "Santa starts on floor 0.\nOpen parenthesis = +1\nClosing parenthesis = -1\nWhat floor does santa end on?")
public class A1P1 extends Assignment {

    
    @FXML
    private TextArea output;

    public A1P1(String name) {
        super(name);
    }

    public void partOne(String input) {
        int open = 0;
        int close = 0;

        for (char c : input.toCharArray()) {
            if (c == '(') {
                open++;
            }
            else {
                close++;
            }
        }

        this.output.setText("Open: " + open + "\nClose: " + close + "\nEnd floor: " + (open-close));
    }
}
