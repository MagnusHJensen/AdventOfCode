package dk.magnusjensen.adventofcode.cal2023;

import dk.magnusjensen.adventofcode.templates.Assignment;
import dk.magnusjensen.adventofcode.templates.CalenderAssignment;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

@CalenderAssignment(calendarName = 2023, assignmentName = "A7P2", number = 14, description = "")
public class A7P2 extends Assignment {

    @FXML
    private TextArea output;

    public A7P2(String name) {
        super(name);
    }

    @Override
    protected void partOne(String input) {
        
    }
}

