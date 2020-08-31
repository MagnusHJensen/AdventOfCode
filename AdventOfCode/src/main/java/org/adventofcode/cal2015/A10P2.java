package org.adventofcode.cal2015;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import org.adventofcode.templates.Assignment;
import org.adventofcode.templates.CalenderAssignment;
import org.adventofcode.utils.StringUtils;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

@CalenderAssignment(calendarName = "2015", assignmentName = "Look-and-Say: Longer", number = 20, description = "Get input\nNext = for each sequence of similar digits put number and the digit itself\nAfter 50 iterations, what's the length of result?")
public class A10P2 extends Assignment {

    @FXML
    private TextArea input;
    @FXML
    private TextArea output;

    public A10P2(String name) {
        super(name);
    }

    @Override
    public Node getContent() throws IOException {
        return loadDefaultContent(this);
    }

    @FXML
    public void run(ActionEvent event) throws NoSuchAlgorithmException {

        Map<String, String > elements = new HashMap<>();
        String result = input.getText();
        for (int i = 0; i < 50; i++) {
            output.setText("Iteration " + i + " / 50");

            result = processElement(result);
        }

        String res = result;
        output.setText("After 50 iterations: " + res.length());
    }

    private String processElement(String input) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < input.length();) {
            int count = StringUtils.countSimilarChars(input, i);
            result.append(count).append(input.charAt(i));
            i += count;
        }

        return result.toString();
    }

    private String processComposite(String composite, Map<String, String> elements) {
        StringBuilder result = new StringBuilder();
        return "";
    }
}
