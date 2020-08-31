package org.adventofcode.cal2015;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import org.adventofcode.logiccircuit.*;
import org.adventofcode.templates.Assignment;
import org.adventofcode.templates.CalenderAssignment;
import org.adventofcode.utils.StringUtils;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

@CalenderAssignment(calendarName = "2015", assignmentName = "String literals", number = 15, description = "Get list of string literals\nEscape sequences are:\n\t'\\\\' - a single backslash\n\t'\\\"' - a double quote\n\t'\\x??' - a single character with ascii code\n What is the result of code length minus memory length?")
public class A8P1 extends Assignment {

    @FXML
    private TextArea input;
    @FXML
    private TextArea output;

    public A8P1(String name) {
        super(name);
    }

    @Override
    public Node getContent() throws IOException {
        return loadDefaultContent(this);
    }

    @FXML
    public void run(ActionEvent event) throws NoSuchAlgorithmException {

        String[] lines = input.getText().split("\n");

        int totalCodeLength = 0;
        int totalMemoryLength = 0;

        for (String line : lines) {
            totalCodeLength += line.trim().length();
            totalMemoryLength += StringUtils.memoryStringLength(line.trim().substring(1, line.length()-1));
        }

        output.setText("Result: " + totalCodeLength + " - " + totalMemoryLength + " = " + (totalCodeLength - totalMemoryLength));
    }




}
