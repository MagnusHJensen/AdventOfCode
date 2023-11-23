package dk.magnusjensen.adventofcode.cal2023;

import dk.magnusjensen.adventofcode.templates.Assignment;
import dk.magnusjensen.adventofcode.templates.CalenderAssignment;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

@CalenderAssignment(calendarName = 2023, assignmentName = "A23P2", number = 46, description = "")
public class A23P2 extends Assignment {

    @FXML
    private TextArea output;

    public A23P2(String name) {
        super(name);
    }

    @Override
    protected void partOne(String input) {
        
    }
}

