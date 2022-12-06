package dk.magnusjensen.adventofcode.cal2022;

import dk.magnusjensen.adventofcode.templates.Assignment;
import dk.magnusjensen.adventofcode.templates.CalenderAssignment;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

@CalenderAssignment(calendarName = 2022, assignmentName = "Rucksack Reorganization", number = 7, description = "")
public class A4P1 extends Assignment {
    
    @FXML
    private TextArea output;

    public A4P1(String name) {
        super(name);
    }

    public void partOne(String input) {
        long start = System.nanoTime();
        String[] lines = input.split("\n");

        int total = 0;

        for (String line : lines) {
            String first = line.split(",")[0];
            String second = line.split(",")[1];
            int lowerFirst = Integer.parseInt(first.split("-")[0]);
            int upperFirst = Integer.parseInt(first.split("-")[1]);
            int lowerSecond = Integer.parseInt(second.split("-")[0]);
            int upperSecond = Integer.parseInt(second.split("-")[1]);

            if (lowerFirst <= lowerSecond && upperFirst >= upperSecond) {
                total += 1;
                continue;
            }

            if (lowerSecond <= lowerFirst && upperSecond >= upperFirst) {
                total += 1;
            }
        }


        long end = System.nanoTime();
        output.setText("Output: " + total);
    }
}
