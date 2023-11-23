package dk.magnusjensen.adventofcode.cal2022;

import dk.magnusjensen.adventofcode.templates.Assignment;
import dk.magnusjensen.adventofcode.templates.CalenderAssignment;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextArea;

import java.io.IOException;

@CalenderAssignment(calendarName = 2022, assignmentName = "", number = 19, description = "")
public class A10P1 extends Assignment {
    
    @FXML
    private TextArea output;

    private int clockCycle;
    private int registerX;
    private int sumOfInterestingSignals;

    public A10P1(String name) {
        super(name);
    }


    public void partOne(String input) {
        String[] lines = input.split("\n");
        registerX = 1;
        sumOfInterestingSignals = 0;
        clockCycle = 0;
        for (String line : lines) {
            String[] parts = line.split(" ");
            if (parts[0].equals("noop")) {
                doCycle();
                continue;
            }
            if (parts[0].equals("addx")) {
                doCycle();
                doCycle();
                registerX += Integer.parseInt(parts[1]);
            }


        }

        output.setText("Output: " + sumOfInterestingSignals);
    }


    private void doCycle() {
        clockCycle++;
        if (isSignalInteresting(clockCycle)) {
            sumOfInterestingSignals += registerX * clockCycle;
        }
    }

    private boolean isSignalInteresting(int clockCycle) {
        return (clockCycle - 20)  % 40 == 0 || clockCycle == 20;
    }
}
