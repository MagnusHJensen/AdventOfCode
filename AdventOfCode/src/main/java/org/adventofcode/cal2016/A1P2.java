package org.adventofcode.cal2016;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import org.adventofcode.math.Line;
import org.adventofcode.math.Vec2;
import org.adventofcode.templates.Assignment;
import org.adventofcode.templates.CalenderAssignment;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@CalenderAssignment(calendarName = "2016", assignmentName = "No time for taxicab: pt 2", number = 2, description = "How far to goal, which is first position visited twice, for given instructions?\nR/L - Turn, Number - walk amount")
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

    List<Vec2> points = new ArrayList<>();
    int x = 0;
    int y = 0;
    int dir = 0;

    @FXML
    public void run(ActionEvent event) {
        String[] instructions = input.getText().split(", ");

        boolean intersect = false;
        for (String instruction : instructions) {
            turn(instruction.substring(0, 1));
            Vec2 intersection = move(Integer.parseInt(instruction.substring(1)));
            if (intersection != null) {
                output.setText("Distance: " + calcDistance(intersection));
                intersect = true;
                break;
            }
        }

        if (!intersect) {
            output.setText("No intersection");
        }
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

    private Vec2 move(int amount) {
        for (int i = 0; i < amount; i++) {
            step(dir);
            Vec2 point = new Vec2(x, y);
            if (checkForIntersection(point)) {
                return point;
            }
            points.add(point);
        }

        return null;
    }

    private void step (int direction) {
        switch (direction) {
            case 0:
                y++;
                break;
            case 1:
                x++;
                break;
            case 2:
                y--;
                break;
            case 3:
                x--;
                break;
        }
    }

    private boolean checkForIntersection (Vec2 move) {
        return points.contains(move);
    }

    private int calcDistance(Vec2 point) {
        return (int)(Math.abs(point.getX()) + Math.abs(point.getY()));
    }
}
