package org.adventofcode.cal2015;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import org.adventofcode.templates.Assignment;
import org.adventofcode.templates.CalenderAssignment;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

@CalenderAssignment(calendarName = "2015", assignmentName = "Santa in elevator", number = 1, description = "Santa starts on floor 0.\nOpen parenthesis = +1\nClosing parenthesis = -1\nWhat floor does santa end on?")
public class A1P1 extends Assignment {

    @FXML
    private TextArea input;
    @FXML
    private TextArea output;

    public A1P1(String name) {
        super(name);
    }

    @Override
    public Node getContent() throws IOException {
        Node content = loadDefaultContent(this);
        setInputContent(input, 1);
        return content;
    }

    @FXML
    public void run(ActionEvent event) {
        int open = 0;
        int close = 0;

        for (char c : this.input.getText().toCharArray()) {
            if (c == '(') {
                open++;
            }
            else {
                close++;
            }
        }

        this.output.setText("Open: " + open + "\nClose: " + close + "\nEnd floor: " + (open-close));
    }
}
