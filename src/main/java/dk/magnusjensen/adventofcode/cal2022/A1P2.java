package dk.magnusjensen.adventofcode.cal2022;

import dk.magnusjensen.adventofcode.templates.Assignment;
import dk.magnusjensen.adventofcode.templates.CalenderAssignment;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

@CalenderAssignment(calendarName = 2022, assignmentName = "Calorie Counting - Part Two", number = 2, description = "")
public class A1P2 extends Assignment {
    @FXML
    private TextArea output;

    public A1P2(String name) {
        super(name);
    }

    public void partOne(String input) {
        long start = System.nanoTime();
        String[] lines = input.split("\n");

        int[] topThreeCalorieCount = new int[3];
        int currentCalorieCount = 0;
        for (String line : lines) {
            if (line.isEmpty()) {

                if (currentCalorieCount > topThreeCalorieCount[2]) {
                    topThreeCalorieCount = new int[] {topThreeCalorieCount[1], topThreeCalorieCount[2], currentCalorieCount};
                } else if (topThreeCalorieCount[1] < currentCalorieCount && currentCalorieCount < topThreeCalorieCount[2]) {
                    topThreeCalorieCount = new int[] {topThreeCalorieCount[1], currentCalorieCount, topThreeCalorieCount[2]};
                } else if (currentCalorieCount > topThreeCalorieCount[0] && currentCalorieCount < topThreeCalorieCount[1]) {
                    topThreeCalorieCount = new int[] {currentCalorieCount, topThreeCalorieCount[1], topThreeCalorieCount[2]};
                }
                currentCalorieCount = 0;
                continue;
            }

            int calorieInItem = Integer.parseInt(line);
            currentCalorieCount += calorieInItem;
        }

        long stop = System.nanoTime();

        output.setText(String.format("Output: " + (topThreeCalorieCount[0] + topThreeCalorieCount[1] + topThreeCalorieCount[2])));
    }
}
