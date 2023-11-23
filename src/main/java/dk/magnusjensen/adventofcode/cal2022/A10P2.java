package dk.magnusjensen.adventofcode.cal2022;

import dk.magnusjensen.adventofcode.templates.Assignment;
import dk.magnusjensen.adventofcode.templates.CalenderAssignment;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextArea;

import java.io.IOException;
import java.util.Arrays;

@CalenderAssignment(calendarName = 2022, assignmentName = "", number = 20, description = "")
public class A10P2 extends Assignment {
    
    @FXML
    private TextArea output;

    private int registerX;
    private int clockCycle;
    private String[][] crt;

    public A10P2(String name) {
        super(name);
    }


    public void partOne(String input) {
        String[] lines = input.split("\n");
        registerX = 1;
        clockCycle = 0;
        crt = new String[6][40];
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

        output.setText("Output: " + Arrays.deepToString(crt).replaceAll(",", "").replaceAll(" ", ""));
    }


    private void doCycle() {
        clockCycle++;
        String[] crtRow = crt[(clockCycle - 1) / 40];
        int rowPos = ((clockCycle - 1) % 40);
        crtRow[rowPos] = rowPos >= registerX - 1 && rowPos <= registerX + 1 ? "██" : "░░";
    }
}
