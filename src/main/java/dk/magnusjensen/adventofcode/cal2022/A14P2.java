package dk.magnusjensen.adventofcode.cal2022;

import dk.magnusjensen.adventofcode.templates.Assignment;
import dk.magnusjensen.adventofcode.templates.CalenderAssignment;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

@CalenderAssignment(calendarName = 2022, assignmentName = "", number = 28, description = "")
public class A14P2 extends Assignment {

    @FXML
    private TextArea output;


    public A14P2(String name) {
        super(name);
    }


    public void partOne(String input) {
        String[] lines = input.split("\n");

    }

}
