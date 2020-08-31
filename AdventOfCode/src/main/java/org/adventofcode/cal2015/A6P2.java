package org.adventofcode.cal2015;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import org.adventofcode.math.Vec2;
import org.adventofcode.templates.Assignment;
import org.adventofcode.templates.CalenderAssignment;
import org.adventofcode.utils.ArrayUtils;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

@CalenderAssignment(calendarName = "2015", assignmentName = "Light decorations: Brightness", number = 12, description = "Get list of instructions(turn on(add 1), turn off(sub 1), toggle(add 2))\nWhat are the brightness of the grid at the end?")
public class A6P2 extends Assignment {

    @FXML
    private TextArea input;
    @FXML
    private TextArea output;

    public A6P2(String name) {
        super(name);
    }

    @Override
    public Node getContent() throws IOException {
        return loadDefaultContent(this);
    }

    @FXML
    public void run(ActionEvent event) throws NoSuchAlgorithmException {

        String[] lines = input.getText().split("\n");
        int[][] lights = new int[1000][1000];

        for (String line : lines) {
            String[] tokens = line.split(" ");

            Vec2 minCorner = Vec2.parseVec2(tokens[tokens.length-3]);
            Vec2 maxCorner = Vec2.parseVec2(tokens[tokens.length-1]);
            maxCorner.add(new Vec2(1,1));

            if (tokens[0].equals("turn")) {
                for (int x = (int)minCorner.getX(); x < maxCorner.getX(); x++) {
                    for (int y = (int)minCorner.getY(); y < maxCorner.getY(); y++) {
                        lights[x][y] += (tokens[1].equals("on") ? 1 : -1);
                        lights[x][y] = Math.max(lights[x][y], 0);
                    }
                }
            }
            else {
                for (int x = (int)minCorner.getX(); x < maxCorner.getX(); x++) {
                    for (int y = (int)minCorner.getY(); y < maxCorner.getY(); y++) {
                        lights[x][y] += 2;
                    }
                }
            }
        }

        int count = 0;
        for (int x = 0; x < lights.length; x++) {
            for (int y = 0; y < lights[x].length; y++) {
                count += lights[x][y];
            }
        }

        output.setText("After the " + lines.length + " instructions, the total brightness are " + count);
    }




}
