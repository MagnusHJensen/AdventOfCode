package dk.magnusjensen.adventofcode.cal2022;

import dk.magnusjensen.adventofcode.templates.Assignment;
import dk.magnusjensen.adventofcode.templates.CalenderAssignment;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

@CalenderAssignment(calendarName = 2022, assignmentName = "", number = 13, description = "")
public class A7P1 extends Assignment {
    
    @FXML
    private TextArea output;

    public A7P1(String name) {
        super(name);
    }

    public void partOne(String input) {
        String[] lines = input.split("\n");

    }
}
