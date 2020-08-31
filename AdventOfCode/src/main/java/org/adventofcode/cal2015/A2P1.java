package org.adventofcode.cal2015;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import org.adventofcode.templates.Assignment;
import org.adventofcode.templates.CalenderAssignment;

import java.io.IOException;

@CalenderAssignment(calendarName = "2015", assignmentName = "Wrapping presents", number = 3, description = "Get list of boxes(format=LxWxH)\nPaper for box is: surface area + smallest surface as slack\nHow much wrapping paper is needed to wrap all the boxes?")
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
        return loadDefaultContent(this);
    }

    @FXML
    public void run(ActionEvent event) {

        int totalPaper = 0;

        String[] boxes = input.getText().split("\n");
        int numBoxes = boxes.length;

        for (String box : boxes) {
            String[] dimensions = box.split("x");
            int l = Integer.parseInt(dimensions[0]);
            int w = Integer.parseInt(dimensions[1]);
            int h = Integer.parseInt(dimensions[2]);
            int lw = l * w;
            int lh = l * h;
            int wh = w * h;
            totalPaper += 2*lw + 2*lh + 2*wh + Math.min(lw, Math.min(lh, wh));
        }

        output.setText("Number of boxes: " + numBoxes + "\nTotal wrapping paper needed: " + totalPaper);
    }
}
