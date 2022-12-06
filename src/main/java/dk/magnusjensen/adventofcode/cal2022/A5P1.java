package dk.magnusjensen.adventofcode.cal2022;

import dk.magnusjensen.adventofcode.templates.Assignment;
import dk.magnusjensen.adventofcode.templates.CalenderAssignment;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

import java.util.Arrays;
import java.util.Stack;

@CalenderAssignment(calendarName = 2022, assignmentName = "", number = 9, description = "")
public class A5P1 extends Assignment {
    
    @FXML
    private TextArea output;
    @FXML
    private Label outputLabel;

    public A5P1(String name) {
        super(name);
    }

    public void partOne(String input) {
        String[] lines = input.split("\n");

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
            Stack<Character> from = stacks[Integer.parseInt(parts[3]) - 1];
            Stack<Character> to = stacks[Integer.parseInt(parts[5]) - 1];

            for (int i = 0; i < amount; i++) {
                Character popped = from.pop();
                to.push(popped);
            }
        }

        StringBuilder builder = new StringBuilder();

        for (Stack<Character> stack : stacks) {
            builder.append(stack.peek());
        }


        output.setText("Output: " + builder);
    }
}
