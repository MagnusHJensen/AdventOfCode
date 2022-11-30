package org.adventofcode.cal2022;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import org.adventofcode.templates.Assignment;
import org.adventofcode.templates.CalenderAssignment;

import java.io.IOException;

@CalenderAssignment(calendarName = "2022", assignmentName = "", number = 3, description = "")
public class A2P1 extends Assignment {
    @FXML
    private TextArea input;
    @FXML
    private TextArea output;

    public A2P1(String name) {
        super(name);
    }

    @Override
    public Node getContent() throws IOException {
        Node content = loadDefaultContent(this);
        setInputContent(input, 2022, 3);
        return content;
    }

    public void run(ActionEvent actionEvent) {
        String[] lines = input.getText().split("\n");

    }
}
