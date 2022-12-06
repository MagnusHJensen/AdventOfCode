package dk.magnusjensen.adventofcode.cal2022;

import dk.magnusjensen.adventofcode.templates.Assignment;
import dk.magnusjensen.adventofcode.templates.CalenderAssignment;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextArea;

import java.io.IOException;

@CalenderAssignment(calendarName = 2022, assignmentName = "", number = 36, description = "")
public class A18P2 extends Assignment {
    
    @FXML
    private TextArea output;

    public A18P2(String name) {
        super(name);
    }

    @Override
    public Node getContent() throws IOException {
        Node content = loadDefaultContent(this);
        setInputContent(input, 2022, 36);
        return content;
    }

    public void partOne(String input) {
        String[] lines = input.split("\n");

    }
}
