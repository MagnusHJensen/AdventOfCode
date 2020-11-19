package org.adventofcode.cal2016;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import org.adventofcode.templates.Assignment;
import org.adventofcode.templates.CalenderAssignment;
import org.adventofcode.utils.ConstrainedGrid;

import java.io.IOException;

@CalenderAssignment(calendarName = "2016", assignmentName = "Bathroom Security: Romb grid", number = 4, description = "On a keypad follow direction on each line of input, what is the code?")
public class A2P2 extends Assignment {

    @FXML
    private TextArea input;
    @FXML
    private TextArea output;

    public A2P2(String name) {
        super(name);
    }

    @Override
    public Node getContent() throws IOException {
        return loadDefaultContent(this);
    }

    ConstrainedGrid<String> keypad = new ConstrainedGrid<>(new String[][] {
            {"", "", "1", "", ""},
            {"", "2", "3", "4", ""},
            {"5", "6", "7", "8", "9"},
            {"", "A", "B", "C", ""},
            {"", "", "D", "", ""}}, 0, 2, "");
    String code = "";

    @FXML
    public void run(ActionEvent event) {
        keypad.reset();
        code = "";

        String[] instructions = input.getText().split("\n");

        for (String instruction : instructions) {

            for (char move : instruction.toCharArray()) {
                move(move);
            }
            code += keypad.getContentAtPosition();
        }

        output.setText("Code: " + code);
    }

    private void move(char move) {
        if (move == 'U') {
            keypad.moveY(-1);
        }
        else if (move == 'D') {
            keypad.moveY(1);
        }
        else if (move == 'L') {
            keypad.moveX(-1);
        }
        else if (move == 'R') {
            keypad.moveX(1);
        }
    }
}
