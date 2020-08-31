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

@CalenderAssignment(calendarName = "2015", assignmentName = "Nice strings: new rules", number = 10, description = "Get list of strings\nNice string:\n\ta string of two letters appering twice\n\tdoes  contain double letter with one space\nHow many nice string are there?")
public class A5P2 extends Assignment {

    @FXML
    private TextArea input;
    @FXML
    private TextArea output;

    public A5P2(String name) {
        super(name);
    }

    @Override
    public Node getContent() throws IOException {
        return loadDefaultContent(this);
    }

    @FXML
    public void run(ActionEvent event) throws NoSuchAlgorithmException {

        String[] lines = input.getText().split("\n");
        int niceStringCount = 0;

        for (String line : lines) {
            boolean hasDouble = StringUtils.hasDoubleLetter(line, 1);

            boolean nonOverlappingPair = StringUtils.nonOverlappingPair(line, 2);

            if (hasDouble && nonOverlappingPair) {
                niceStringCount++;
            }
        }

        output.setText("Total string: " + lines.length + "\nNice strings: " + niceStringCount);
    }




}
