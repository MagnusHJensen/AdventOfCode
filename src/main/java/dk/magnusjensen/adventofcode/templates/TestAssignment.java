package dk.magnusjensen.adventofcode.templates;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextArea;

import java.io.IOException;


//@CalenderAssignment(calendarName = 2015, assignmentName = "TestAssignment", number = 1, description = "Some description")
public class TestAssignment extends Assignment {

    @FXML
    private TextArea output;

    public TestAssignment(String name) {
        super(name);
    }

    @Override
    public Node getContent() throws IOException {
        return loadDefaultContent(this);
    }

    @FXML
    public void partOne(String input) {
        output.setText(input);
    }
}
