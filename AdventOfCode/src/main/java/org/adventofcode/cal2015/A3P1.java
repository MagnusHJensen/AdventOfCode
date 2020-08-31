package org.adventofcode.cal2015;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import org.adventofcode.math.Vec2;
import org.adventofcode.templates.Assignment;
import org.adventofcode.templates.CalenderAssignment;

import java.io.IOException;
import java.util.*;

@CalenderAssignment(calendarName = "2015", assignmentName = "Delivering presents", number = 5, description = "Get list of directions(>,v,^,<)\nSanta start at 0,0\nMove in direction of arrow\nHow many houses get atleast one present?")
public class A3P1 extends Assignment {

    @FXML
    private TextArea input;
    @FXML
    private TextArea output;

    public A3P1(String name) {
        super(name);
    }

    @Override
    public Node getContent() throws IOException {
        return loadDefaultContent(this);
    }

    @FXML
    public void run(ActionEvent event) {

        List<Vec2> houses = new ArrayList<>();

        int numMoves = input.getText().length();
        Vec2 curPos = new Vec2();

        for (char move : input.getText().toCharArray()) {
            if (!houses.contains(curPos)) {
                houses.add(curPos);
            }

            curPos = curPos.copy();
            if (move == '^') {
                curPos.setY(curPos.getY()+1);
            }
            else if (move == 'v') {
                curPos.setY(curPos.getY()-1);
            }
            else if (move == '<') {
                curPos.setX(curPos.getX()-1);
            }
            else if (move == '>') {
                curPos.setX(curPos.getX()+1);
            }
        }

        output.setText("Number of moves: " + numMoves + "\nHouse with atleast one present: " + houses.size());
    }
}
