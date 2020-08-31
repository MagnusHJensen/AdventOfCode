package org.adventofcode.cal2015;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import org.adventofcode.templates.Assignment;
import org.adventofcode.templates.CalenderAssignment;

import java.io.IOException;

@CalenderAssignment(calendarName = "2015", assignmentName = "Wrapping presents: Ribbon", number = 4, description = "Get list of boxes(format=LxWxH)\nRibbon for box is: perimeter of smallest face + volume for bow\nHow much ribbon is needed to wrap all the boxes?")
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

    @FXML
    public void run(ActionEvent event) {

        int totalRibbon = 0;

        String[] boxes = input.getText().split("\n");
        int numBoxes = boxes.length;

        for (String box : boxes) {
            String[] dimensions = box.split("x");
            int l = Integer.parseInt(dimensions[0]);
            int w = Integer.parseInt(dimensions[1]);
            int h = Integer.parseInt(dimensions[2]);
            int lw = l + l + w + w;
            int lh = l + l + h + h;
            int wh = w + w + h + h;
            totalRibbon += Math.min(lw, Math.min(lh, wh)) + (l * w * h);
        }

        output.setText("Number of boxes: " + numBoxes + "\nTotal ribbon needed: " + totalRibbon);
    }
}
