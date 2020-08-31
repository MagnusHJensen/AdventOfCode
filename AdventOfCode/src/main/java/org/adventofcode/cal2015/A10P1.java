package org.adventofcode.cal2015;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import org.adventofcode.graph.Graph;
import org.adventofcode.graph.GraphAlgorithms;
import org.adventofcode.templates.Assignment;
import org.adventofcode.templates.CalenderAssignment;
import org.adventofcode.utils.ListUtils;
import org.adventofcode.utils.StringUtils;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.*;

@CalenderAssignment(calendarName = "2015", assignmentName = "Look-and-Say", number = 19, description = "Get input\nNext = for each sequence of similar digits put number and the digit itself\nAfter 40 iterations, what's the length of the result?")
public class A10P1 extends Assignment {

    @FXML
    private TextArea input;
    @FXML
    private TextArea output;

    public A10P1(String name) {
        super(name);
    }

    @Override
    public Node getContent() throws IOException {
        return loadDefaultContent(this);
    }

    @FXML
    public void run(ActionEvent event) throws NoSuchAlgorithmException {

        String input = this.input.getText();

        for (int i = 0; i < 40; i++) {
            input = process(input);
        }

        output.setText("After 40 iterations: " + input.length());
    }

    private String process (String input) {
        String result = "";

        for (int i = 0; i < input.length();) {
            int count = StringUtils.countSimilarChars(input, i);
            result += count + "" + input.charAt(i);
            i += count;
        }

        return result;
    }


}
