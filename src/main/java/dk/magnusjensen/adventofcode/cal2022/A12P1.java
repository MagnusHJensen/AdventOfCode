package dk.magnusjensen.adventofcode.cal2022;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import dk.magnusjensen.adventofcode.templates.Assignment;
import dk.magnusjensen.adventofcode.templates.CalenderAssignment;

import java.io.IOException;

@CalenderAssignment(calendarName = 2022, assignmentName = "", number = 23, description = "")
public class A12P1 extends Assignment {
    
    @FXML
    private TextArea output;

    public A12P1(String name) {
        super(name);
    }

    @Override
    public Node getContent() throws IOException {
        Node content = loadDefaultContent(this);
        setInputContent(input, 2022, 23);
        return content;
    }

    public void partOne(String input) {
        String[] lines = input.split("\n");

    }
}
