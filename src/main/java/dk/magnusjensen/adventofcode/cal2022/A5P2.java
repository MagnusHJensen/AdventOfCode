package dk.magnusjensen.adventofcode.cal2022;

import dk.magnusjensen.adventofcode.templates.Assignment;
import dk.magnusjensen.adventofcode.templates.CalenderAssignment;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

@CalenderAssignment(calendarName = "2022", assignmentName = "", number = 10, description = "")
public class A5P2 extends Assignment {
    @FXML
    private TextArea input;
    @FXML
    private TextArea output;
    @FXML
    private Label outputLabel;

    public A5P2(String name) {
        super(name);
    }

    @Override
    public Node getContent() throws IOException {
        Node content = loadDefaultContent(this);
        setInputContent(input, 2022, 5);
        return content;
    }

    public void run() {
        long start = System.nanoTime();

        String[] lines = input.getText().split("\n");

        String[] moveCommands = Arrays.copyOfRange(lines, 10, lines.length);

        Stack<Character>[] stacks = new Stack[9];
        for (int i = 0; i < stacks.length; i++) {
            stacks[i] = new Stack<>();
        }

        for (int i = 7; i >= 0; i--) {
            for (int k = 0; k < 9; k++) {
                // Check 3 character substring, with an additiona offset of 1 for each index.
                char crateChar = lines[i].charAt(k * 3 + (k) + 1);
                if (Character.isLetter(crateChar)) {
                    stacks[k].push(crateChar);
                }
            }
        }

        for (String line : moveCommands) {
            String[] parts = line.split(" ");
            int amount = Integer.parseInt(parts[1]);
            int from = Integer.parseInt(parts[3]) - 1;
            int to = Integer.parseInt(parts[5]) - 1;
            List<Character> cratesToBeMoved = new ArrayList<>();
            for (int i = 0; i < amount; i++) {
                cratesToBeMoved.add(stacks[from].pop());
            }

            for (int i = amount - 1; i >= 0; i--) {
                stacks[to].push(cratesToBeMoved.get(i));
            }
        }

        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < stacks.length; i++) {
            builder.append(stacks[i].peek());
        }

        long end = System.nanoTime();
        outputLabel.setText("Output - Execution time: " + (end - start) / 1_000_000d + " seconds");
        output.setText("Output: " + builder);
    }
}
