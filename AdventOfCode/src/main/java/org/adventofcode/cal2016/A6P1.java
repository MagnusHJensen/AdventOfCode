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

@CalenderAssignment(calendarName = "2016", assignmentName = "Signals and Noise", number = 11, description = "Find the error-corrected repetition code")
public class A6P1 extends Assignment {

    @FXML
    private TextArea input;
    @FXML
    private TextArea output;

    public A6P1(String name) {
        super(name);
    }

    @Override
    public Node getContent() throws IOException {
        return loadDefaultContent(this);
    }

    private List<List<AbstractMap.SimpleEntry<Character, Integer>>> counts = new ArrayList<>();

    @FXML
    public void run(ActionEvent event) {

        String[] codes = input.getText().split("\n");

        for (int i = 0; i < codes[0].length(); i++) {
            counts.add(new ArrayList<>());
        }

        //COUNTING
        for (String code : codes) {
            mostCommonCharacters(code);
        }

        //SORTING
        for (int i = 0; i < counts.size(); i++) {
            counts.get(i).sort((o1, o2) -> {
                int diff = o2.getValue() - o1.getValue();

                if (diff == 0) {
                    diff = o1.getKey().compareTo(o2.getKey());
                }

                return diff;
            });
        }

        //BUILDING
        String codeword = "";
        for (int i = 0; i < counts.size(); i++) {
            codeword += counts.get(i).get(0).getKey();
        }

        output.setText("Code: " + codeword);
    }

    private void mostCommonCharacters (String code) {
        char[] chars = code.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            AbstractMap.SimpleEntry<Character, Integer> entry = findItem(chars[i], counts.get(i));
            if (entry != null) {
                entry.setValue(entry.getValue()+1);
            }
            else {
                counts.get(i).add(new AbstractMap.SimpleEntry<>(chars[i], 1));
            }
        }
    }

    private AbstractMap.SimpleEntry<Character, Integer> findItem (char key, List<AbstractMap.SimpleEntry<Character, Integer>> items) {
        for (AbstractMap.SimpleEntry<Character, Integer> item : items) {
            if (item.getKey() == key) return item;
        }

        return null;
    }


}
