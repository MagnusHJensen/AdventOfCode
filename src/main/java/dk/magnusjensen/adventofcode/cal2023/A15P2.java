package dk.magnusjensen.adventofcode.cal2023;

import dk.magnusjensen.adventofcode.templates.Assignment;
import dk.magnusjensen.adventofcode.templates.CalenderAssignment;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

@CalenderAssignment(calendarName = 2023, assignmentName = "A15P2", number = 30, description = "")
public class A15P2 extends Assignment {

    @FXML
    private TextArea output;

    public A15P2(String name) {
        super(name);
    }

    @Override
    protected void partOne(String input) {
        
    }
}

