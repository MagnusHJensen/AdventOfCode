package org.adventofcode.cal2016;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import org.adventofcode.templates.Assignment;
import org.adventofcode.templates.CalenderAssignment;

import java.io.IOException;

@CalenderAssignment(calendarName = "2016", assignmentName = "No time for taxicab", number = 1, description = "How far to goal, for given instructions?\nR/L - Turn, Number - walk amount")
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
        return loadDefaultContent(this);
    }

    int[] moveDirs = new int[4];
    int dir = 0;

    @FXML
    public void run(ActionEvent event) {
        String[] instructions = input.getText().split(", ");

        for (String instruction : instructions) {
            turn(instruction.substring(0, 1));
            move(Integer.parseInt(instruction.substring(1)));
        }

        output.setText("Distance: " + calcDistance());
    }

    private void turn(String direction) {
        if (direction.equals("L")) {
            dir--;
            if (dir < 0) dir += 4;
        }
        else {
            dir = (dir + 1) % 4;
        }
    }

    private void move(int amount) {
        moveDirs[dir] += amount;
    }

    private int calcDistance () {
        return Math.abs(moveDirs[0] - moveDirs[2]) + Math.abs(moveDirs[1] - moveDirs[3]);
    }
}
