package org.adventofcode.cal2016;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import org.adventofcode.templates.Assignment;
import org.adventofcode.templates.CalenderAssignment;

import java.io.IOException;
import java.util.*;

@CalenderAssignment(calendarName = "2016", assignmentName = "Security Through Obscurity", number = 7, description = "What is the sum of the sector IDs of the real rooms")
public class A4P1 extends Assignment {

    @FXML
    private TextArea input;
    @FXML
    private TextArea output;

    public A4P1(String name) {
        super(name);
    }

    @Override
    public Node getContent() throws IOException {
        return loadDefaultContent(this);
    }

    int sum = 0;

    @FXML
    public void run(ActionEvent event) {

        String[] rooms = input.getText().split("\n");

        for (String room : rooms) {
            String mostCommonChars = mostCommonNameCharacters(room.substring(0, room.length()-11));
            String checksum = room.substring(room.length()-6, room.length()-1);

            if (checksum.equals(mostCommonChars)) {
                sum += Integer.parseInt(room.substring(room.length()-10, room.length()-7));
            }
        }


        output.setText("Sum: " + sum);
    }

    private String mostCommonNameCharacters (String roomName) {
        List<AbstractMap.SimpleEntry<Character, Integer>> charCount = new ArrayList<>();

        String[] nameParts = roomName.split("-");
        for (String part : nameParts) {
            for (char letter : part.toCharArray()) {
                AbstractMap.SimpleEntry<Character, Integer> entry = findItem(letter, charCount);
                if (entry != null) {
                    entry.setValue(entry.getValue()+1);
                }
                else {
                    charCount.add(new AbstractMap.SimpleEntry<>(letter, 1));
                }
            }
        }

        charCount.sort((o1, o2) -> {
            int diff = o2.getValue() - o1.getValue();

            if (diff == 0) {
                diff = o1.getKey().compareTo(o2.getKey());
            }

            return diff;
        });

        String commonChars = "";
        for (AbstractMap.SimpleEntry<Character, Integer> pair : charCount) {
            if (commonChars.length() == 5) break;
            commonChars += pair.getKey();
        }

        return commonChars;
    }

    private AbstractMap.SimpleEntry<Character, Integer> findItem (char key, List<AbstractMap.SimpleEntry<Character, Integer>> items) {
        for (AbstractMap.SimpleEntry<Character, Integer> item : items) {
            if (item.getKey() == key) return item;
        }

        return null;
    }
}
