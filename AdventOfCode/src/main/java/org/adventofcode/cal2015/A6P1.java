package org.adventofcode.cal2015;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import org.adventofcode.math.Vec2;
import org.adventofcode.templates.Assignment;
import org.adventofcode.templates.CalenderAssignment;
import org.adventofcode.utils.ArrayUtils;
import org.adventofcode.utils.StringUtils;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

@CalenderAssignment(calendarName = "2015", assignmentName = "Light decorations", number = 11, description = "Get list of instructions(turn off, turn on, toggle)\nAfter the instructions how many lights are turned on?")
public class A6P1 extends Assignment {

    @FXML
    private TextArea input;
    @FXML
    private TextArea output;

    public A6P1(String name) {
        super(name);
    }

    @Override
    public Node getContent() throws IOException {
        return loadDefaultContent(this);
    }

    @FXML
    public void run(ActionEvent event) throws NoSuchAlgorithmException {

        String[] lines = input.getText().split("\n");
        Boolean[][] lights = new Boolean[1000][1000];
        ArrayUtils.fillRect2dArray(lights, false, new Vec2(), new Vec2(1000,1000));

        for (String line : lines) {
            String[] tokens = line.split(" ");

            Vec2 minCorner = Vec2.parseVec2(tokens[tokens.length-3]);
            Vec2 maxCorner = Vec2.parseVec2(tokens[tokens.length-1]);
            maxCorner.add(new Vec2(1,1));

            if (tokens[0].equals("turn")) {
                ArrayUtils.fillRect2dArray(lights, tokens[1].equals("on"), minCorner, maxCorner);
            }
            else {
                for (int x = (int)minCorner.getX(); x < maxCorner.getX(); x++) {
                    for (int y = (int)minCorner.getY(); y < maxCorner.getY(); y++) {
                        lights[x][y] = !lights[x][y];
                    }
                }
            }
        }

        int count = 0;
        for (int x = 0; x < lights.length; x++) {
            for (int y = 0; y < lights[x].length; y++) {
                count += (lights[x][y] ? 1 : 0);
            }
        }

        output.setText("After the " + lines.length + " instructions, there are " + count + " lights turned on");
    }




}
