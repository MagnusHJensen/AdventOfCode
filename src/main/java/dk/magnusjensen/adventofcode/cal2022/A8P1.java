package dk.magnusjensen.adventofcode.cal2022;

import dk.magnusjensen.adventofcode.templates.Assignment;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import dk.magnusjensen.adventofcode.templates.CalenderAssignment;

import java.io.IOException;

@CalenderAssignment(calendarName = 2022, assignmentName = "", number = 15, description = "")
public class A8P1 extends Assignment {
    
    @FXML
    private TextArea output;

    public A8P1(String name) {
        super(name);
    }


    public void partOne(String input) {
        String[] lines = input.split("\n");

    }
}
