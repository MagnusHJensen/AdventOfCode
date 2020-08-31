package org.adventofcode.cal2015;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import org.adventofcode.templates.Assignment;
import org.adventofcode.templates.CalenderAssignment;
import org.adventofcode.utils.StringUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@CalenderAssignment(calendarName = "2015", assignmentName = "Nice strings", number = 9, description = "Get list of strings\nNice string:\n\thas 3 vovels\n\ta letter twice in a row\n\tdoes not contain [ab,cd,pq, xy]\nHow many nice string are there?")
public class A5P1 extends Assignment {

    @FXML
    private TextArea input;
    @FXML
    private TextArea output;

    public A5P1(String name) {
        super(name);
    }

    @Override
    public Node getContent() throws IOException {
        return loadDefaultContent(this);
    }

    @FXML
    public void run(ActionEvent event) throws NoSuchAlgorithmException {

        String[] lines = input.getText().split("\n");
        String[] disallowedStrings = {"ab", "cd", "pq", "xy"};
        int niceStringCount = 0;

        for (String line : lines) {
            int[] vovelCounts = StringUtils.countChars(line, "aeiou".toCharArray());
            int totalVovels = 0;
            for (int i : vovelCounts) {
                totalVovels += i;
            }

            boolean hasDouble = StringUtils.hasDoubleLetter(line, 0);

            boolean containsDisallowed = false;
            for (String disAllowed : disallowedStrings) {
                containsDisallowed = line.contains(disAllowed);
                if (containsDisallowed)
                    break;
            }

            if (totalVovels >= 3 && hasDouble && !containsDisallowed) {
                niceStringCount++;
            }
        }

        output.setText("Total string: " + lines.length + "\nNice strings: " + niceStringCount);
    }




}
