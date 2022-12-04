package dk.magnusjensen.adventofcode.cal2022;

import dk.magnusjensen.adventofcode.templates.Assignment;
import dk.magnusjensen.adventofcode.templates.CalenderAssignment;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextArea;

import java.io.IOException;

@CalenderAssignment(calendarName = "2022", assignmentName = "", number = 8, description = "")
public class A4P2 extends Assignment {
    @FXML
    private TextArea input;
    @FXML
    private TextArea output;

    public A4P2(String name) {
        super(name);
    }

    @Override
    public Node getContent() throws IOException {
        Node content = loadDefaultContent(this);
        setInputContent(input, 2022, 4);
        return content;
    }

    public void run(ActionEvent actionEvent) {
        long start = System.nanoTime();
        String[] lines = input.getText().split("\n");

        int total = 0;

        for (String line : lines) {
            String first = line.split(",")[0];
            String second = line.split(",")[1];
            int lowerFirst = Integer.parseInt(first.split("-")[0]);
            int upperFirst = Integer.parseInt(first.split("-")[1]);
            int lowerSecond = Integer.parseInt(second.split("-")[0]);
            int upperSecond = Integer.parseInt(second.split("-")[1]);

            if (lowerFirst <= lowerSecond && upperFirst >= lowerSecond) {
                total += 1;
            } else if (lowerFirst <= upperSecond && upperFirst >= upperSecond) {
                total += 1;
            } else if (lowerSecond <= lowerFirst && upperSecond >= lowerFirst) {
                total += 1;
            } else if (lowerSecond <= upperFirst && upperSecond >= upperFirst) {
                total += 1;
            }

        }


        long end = System.nanoTime();
        output.setText("Output: " + total);

    }
}
