package dk.magnusjensen.adventofcode.cal2023;

import dk.magnusjensen.adventofcode.templates.Assignment;
import dk.magnusjensen.adventofcode.templates.CalenderAssignment;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

@CalenderAssignment(calendarName = 2023, assignmentName = "A17P1", number = 33, description = "")
public class A17P1 extends Assignment {

    @FXML
    private TextArea output;

    public A17P1(String name) {
        super(name);
    }

    @Override
    protected void partOne(String input) {
        
    }
}

