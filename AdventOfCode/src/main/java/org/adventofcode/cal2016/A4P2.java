package org.adventofcode.cal2016;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import org.adventofcode.templates.Assignment;
import org.adventofcode.templates.CalenderAssignment;

import java.io.IOException;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;

@CalenderAssignment(calendarName = "2016", assignmentName = "Security Through Obscurity: Decipher", number = 8, description = "What is the sector ID of the room where north pole objects are stored?")
public class A4P2 extends Assignment {

    @FXML
    private TextArea input;
    @FXML
    private TextArea output;

    public A4P2(String name) {
        super(name);
    }

    @Override
    public Node getContent() throws IOException {
        return loadDefaultContent(this);
    }


    @FXML
    public void run(ActionEvent event) {

        String[] rooms = input.getText().split("\n");

        for (String room : rooms) {
            String name = room.substring(0, room.length()-11);
            String mostCommonChars = mostCommonNameCharacters(name);
            String checksum = room.substring(room.length()-6, room.length()-1);

            if (checksum.equals(mostCommonChars)) {
                String id = room.substring(room.length()-10, room.length()-7);
                String realName = decipher(name, Integer.parseInt(id));
                output.appendText(realName + " - " + id + "\n");
            }
        }
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

    private String decipher (String encrypted, int shifts) {
        System.out.println(encrypted);
        int shift = shifts % 26;
        String result = "";
        for (char letter : encrypted.toCharArray()) {
            if (letter == '-') {
                result += " ";
            }
            else {
                char newLetter = (char)((int)letter + shift);
                if ((int)newLetter > 122) newLetter -= 26;
                result += newLetter;
            }
        }

        return result;
    }
}
