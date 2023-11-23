package dk.magnusjensen.adventofcode.cal2023;

import dk.magnusjensen.adventofcode.templates.Assignment;
import dk.magnusjensen.adventofcode.templates.CalenderAssignment;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

@CalenderAssignment(calendarName = 2023, assignmentName = "A22P1", number = 43, description = "")
public class A22P1 extends Assignment {

    @FXML
    private TextArea output;

    public A22P1(String name) {
        super(name);
    }

    @Override
    protected void partOne(String input) {
        
    }
}

