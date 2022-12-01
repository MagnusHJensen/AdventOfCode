package dk.magnusjensen.adventofcode.cal2022;

import dk.magnusjensen.adventofcode.templates.Assignment;
import dk.magnusjensen.adventofcode.templates.CalenderAssignment;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextArea;

import java.io.IOException;

@CalenderAssignment(calendarName = "2022", assignmentName = "", number = 40, description = "")
public class A20P2 extends Assignment {
    @FXML
    private TextArea input;
    @FXML
    private TextArea output;

    public A20P2(String name) {
        super(name);
    }

    @Override
    public Node getContent() throws IOException {
        Node content = loadDefaultContent(this);
        setInputContent(input, 2022, 40);
        return content;
    }

    public void run(ActionEvent actionEvent) {
        String[] lines = input.getText().split("\n");

    }
}
