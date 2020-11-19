package org.adventofcode.cal2016;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import org.adventofcode.templates.Assignment;
import org.adventofcode.templates.CalenderAssignment;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@CalenderAssignment(calendarName = "2016", assignmentName = "Impossible triangles: Columns", number = 6, description = "How many of the given triangles are impossible?")
public class A3P2 extends Assignment {

    @FXML
    private TextArea input;
    @FXML
    private TextArea output;

    public A3P2(String name) {
        super(name);
    }

    @Override
    public Node getContent() throws IOException {
        return loadDefaultContent(this);
    }

    int count = 0;
    List<String>[] columns = new List[3];

    @FXML
    public void run(ActionEvent event) {
        columns[0] = new ArrayList<>();
        columns[1] = new ArrayList<>();
        columns[2] = new ArrayList<>();

        String[] triangles = input.getText().split("\n");

        for (String triangle : triangles) {
            String[] sides = triangle.trim().split(" +");
            columns[0].add(sides[0]);
            columns[1].add(sides[1]);
            columns[2].add(sides[2]);
        }

        List<String> all = mergeLists(columns[0], columns[1], columns[2]);

        for (int i = 0; i < all.size(); i += 3) {
            count += (isImpossible(Integer.parseInt(all.get(i)), Integer.parseInt(all.get(i+1)), Integer.parseInt(all.get(i+2))) ? 0 : 1);
        }

        output.setText("Impossible triangles: " + count);
    }

    private boolean isImpossible(int side1, int side2, int side3) {
        return side1 + side2 <= side3 || side2 + side3 <= side1 || side3 + side1 <= side2;
    }

    private List<String> mergeLists (List<String> list1, List<String> list2, List<String> list3) {
        List<String> all = new ArrayList<>();
        all.addAll(list1);
        all.addAll(list2);
        all.addAll(list3);
        return all;
    }
}
