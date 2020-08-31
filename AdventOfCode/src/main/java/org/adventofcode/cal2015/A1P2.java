package org.adventofcode.cal2015;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import org.adventofcode.templates.Assignment;
import org.adventofcode.templates.CalenderAssignment;

import java.io.IOException;

@CalenderAssignment(calendarName = "2015", assignmentName = "Santa in elevator: basement", number = 2, description = "Santa starts on floor 0.\nOpen parenthesis = +1\nClosing parenthesis = -1\nAt what index does he enter the basement?")
public class A1P2 extends Assignment {

    @FXML
    private TextArea input;
    @FXML
    private TextArea output;

    public A1P2(String name) {
        super(name);
    }

    @Override
    public Node getContent() throws IOException {
        return loadDefaultContent(this);
    }

    @FXML
    public void run(ActionEvent event) {
        int open = 0;
        int close = 0;

        int index = -1;

        char[] inputs = input.getText().toCharArray();

        for (int i = 0; i < inputs.length; i++) {
            if (inputs[i] == '(') {
                open++;
            }
            else {
                close++;
            }

            if (open - close == -1) {
                index = i+1;
                break;
            }
        }

        output.setText("Basement index: " + index);
    }
}
