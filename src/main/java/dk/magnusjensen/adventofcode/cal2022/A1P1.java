package dk.magnusjensen.adventofcode.cal2022;

import dk.magnusjensen.adventofcode.templates.Assignment;
import dk.magnusjensen.adventofcode.templates.CalenderAssignment;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

@CalenderAssignment(calendarName = 2022, assignmentName = "Calorie Counting", number = 1, description = "")
public class A1P1 extends Assignment {
    @FXML
    private TextArea output;

    public A1P1(String name) {
        super(name);
    }

    protected void partOne(String input) {
        String[] lines = input.split("\n");

        int highestCalorieCount = Integer.MIN_VALUE;
        int currentCalorieCount = 0;
        for (String line : lines) {
            if (line.isEmpty()) {
                if (highestCalorieCount < currentCalorieCount) {
                    highestCalorieCount = currentCalorieCount;
                }
                currentCalorieCount = 0;
                continue;
            }

            int calorieInItem = Integer.parseInt(line);
            currentCalorieCount += calorieInItem;
        }

        output.setText("Output: " + highestCalorieCount);

    }
}
