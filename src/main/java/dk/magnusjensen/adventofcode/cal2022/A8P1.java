package dk.magnusjensen.adventofcode.cal2022;

import dk.magnusjensen.adventofcode.maths.Coord;
import dk.magnusjensen.adventofcode.templates.Assignment;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import dk.magnusjensen.adventofcode.templates.CalenderAssignment;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@CalenderAssignment(calendarName = 2022, assignmentName = "", number = 15, description = "")
public class A8P1 extends Assignment {
    
    @FXML
    private TextArea output;

    public A8P1(String name) {
        super(name);
    }


    public void partOne(String input) {

        int[][] map = new int[24][30];
        for (int i = 0; i < 24; i++) {
            for (int j = 0; j < 30; j++) {
                map[i][j] = Character.getNumericValue(input.charAt(i * 30 + j));
            }
        }

        int visibleTrees = 0;

        for (int row = 0; row < map.length; row++) {
            int maxHeight = 0;

            for (int col = 0; col < map[row].length; col++) {
                if (map[row][col] > maxHeight) {
                    maxHeight = map[row][col];
                }
            }

            visibleTrees += maxHeight;
        }

        for (int col = 0; col < map[0].length; col++) {
            int maxHeight = 0;

            for (int row = 0; row < map.length; row++) {
                if (map[row][col] > maxHeight) {
                    maxHeight = map[row][col];
                }
            }

            visibleTrees += maxHeight;
        }


        output.setText("Visible trees: " + visibleTrees);

    }
}
