package dk.magnusjensen.adventofcode.cal2022;

import dk.magnusjensen.adventofcode.templates.Assignment;
import dk.magnusjensen.adventofcode.templates.CalenderAssignment;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

@CalenderAssignment(calendarName = 2022, assignmentName = "", number = 27, description = "")
public class A14P1 extends Assignment {

    @FXML
    private TextArea output;

    public A14P1(String name) {
        super(name);
    }


    public void partOne(String input) {
        String[] lines = input.split("\n\n");

    }
    
}
