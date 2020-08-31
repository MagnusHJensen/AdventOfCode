package org.adventofcode.cal2015;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import org.adventofcode.math.Vec2;
import org.adventofcode.templates.Assignment;
import org.adventofcode.templates.CalenderAssignment;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@CalenderAssignment(calendarName = "2015", assignmentName = "Delivering presents: Robo santa", number = 6, description = "Get list of directions(>,v,^,<)\nSanta and robo santa start at 0,0\nAlternately move in direction of arrow\nHow many houses get atleast one present?")
public class A3P2 extends Assignment {

    @FXML
    private TextArea input;
    @FXML
    private TextArea output;

    public A3P2(String name) {
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
        Vec2[] positions = {new Vec2(), new Vec2()};
        int index = 0;

        for (char move : input.getText().toCharArray()) {
            Vec2 pos = positions[index];


            if (!houses.contains(pos)) {
                houses.add(pos);
            }

            positions[index] = pos.copy();
            pos = positions[index];
            if (move == '^') {
                pos.setY(pos.getY()+1);
            }
            else if (move == 'v') {
                pos.setY(pos.getY()-1);
            }
            else if (move == '<') {
                pos.setX(pos.getX()-1);
            }
            else if (move == '>') {
                pos.setX(pos.getX()+1);
            }

            index = index ^ 1;
        }

        output.setText("Number of moves: " + numMoves + "\nHouse with atleast one present: " + houses.size());
    }
}
