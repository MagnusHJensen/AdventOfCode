package dk.magnusjensen.adventofcode.cal2022;

import dk.magnusjensen.adventofcode.templates.Assignment;
import dk.magnusjensen.adventofcode.templates.CalenderAssignment;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

import java.io.IOException;

@CalenderAssignment(calendarName = "2022", assignmentName = "", number = 1, description = "")
public class A1P1 extends Assignment {
    @FXML
    private TextArea input;
    @FXML
    private TextArea output;
    @FXML
    private Label outputLabel;

    public A1P1(String name) {
        super(name);
    }

    @Override
    public Node getContent() throws IOException {
        Node content = loadDefaultContent(this);
        setInputContent(input, 2022, 1);
        return content;
    }

    public void run(ActionEvent actionEvent) {
        long start = System.nanoTime();
        String[] lines = input.getText().split("\n");

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

        long stop = System.nanoTime();

        outputLabel.setText("Output - Execution time: " + ((stop - start) / 1_000_000_000d) + " seconds");
        output.setText("Output: " + highestCalorieCount);

    }
}
