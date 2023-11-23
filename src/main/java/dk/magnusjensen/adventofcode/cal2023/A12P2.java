package dk.magnusjensen.adventofcode.cal2023;

import dk.magnusjensen.adventofcode.templates.Assignment;
import dk.magnusjensen.adventofcode.templates.CalenderAssignment;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

@CalenderAssignment(calendarName = 2023, assignmentName = "A12P2", number = 24, description = "")
public class A12P2 extends Assignment {

    @FXML
    private TextArea output;

    public A12P2(String name) {
        super(name);
    }

    @Override
    protected void partOne(String input) {
        
    }
}

