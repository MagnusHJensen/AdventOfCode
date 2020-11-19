package org.adventofcode.cal2016;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import org.adventofcode.templates.Assignment;
import org.adventofcode.templates.CalenderAssignment;

import java.io.IOException;

@CalenderAssignment(calendarName = "2016", assignmentName = "Impossible triangles", number = 5, description = "How many of the given triangles are impossible?")
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

    int count = 0;

    @FXML
    public void run(ActionEvent event) {
        String[] triangles = input.getText().split("\n");

        for (String triangle : triangles) {
            String[] sides = triangle.trim().split(" +");
            count += (isImpossible(Integer.parseInt(sides[0]), Integer.parseInt(sides[1]), Integer.parseInt(sides[2])) ? 0 : 1);
        }

        output.setText("Impossible triangles: " + count);
    }

    private boolean isImpossible(int side1, int side2, int side3) {
        return side1 + side2 <= side3 || side2 + side3 <= side1 || side3 + side1 <= side2;
    }
}
