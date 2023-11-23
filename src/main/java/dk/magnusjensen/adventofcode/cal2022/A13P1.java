package dk.magnusjensen.adventofcode.cal2022;

import dk.magnusjensen.adventofcode.templates.Assignment;
import dk.magnusjensen.adventofcode.templates.CalenderAssignment;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

import java.util.ArrayList;
import java.util.List;

@CalenderAssignment(calendarName = 2022, assignmentName = "", number = 25, description = "")
public class A13P1 extends Assignment {

    @FXML
    private TextArea output;

    public A13P1(String name) {
        super(name);
    }


    public void partOne(String input) {
        String[] lines = input.split("\n\n");

        int sum = 0;

        for (int index = 0; index < lines.length; index++) {
            String pairOne = lines[index].split("\n")[0];
            String pairTwo = lines[index].split("\n")[1];

            List<List> pairOneList = new ArrayList<>();
            List<List> tempList = new ArrayList<>();
            for (int i = 0; i < pairOne.length(); i++) {
                if (pairOne.charAt(i) == '[') {

                }
            }
        }

    }
    
}
