package org.adventofcode.templates;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import org.adventofcode.templates.Assignment;
import org.adventofcode.templates.CalenderAssignment;

import java.io.IOException;


//@CalenderAssignment(calendarName = "2015", assignmentName = "TestAssignment", number = 1, description = "Some description")
public class TestAssignment extends Assignment {

    @FXML
    private TextArea input;
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
    public void run(ActionEvent event) {
        output.setText(input.getText());
    }
}
