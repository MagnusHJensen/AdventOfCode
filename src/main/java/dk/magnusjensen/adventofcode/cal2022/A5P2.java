package dk.magnusjensen.adventofcode.cal2022;

import dk.magnusjensen.adventofcode.templates.Assignment;
import dk.magnusjensen.adventofcode.templates.CalenderAssignment;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

@CalenderAssignment(calendarName = 2022, assignmentName = "", number = 10, description = "")
public class A5P2 extends Assignment {
    
    @FXML
    private TextArea output;

    public A5P2(String name) {
        super(name);
    }

    public void partOne(String input) {
        String[] lines = input.split("\n");

        String[] moveCommands = Arrays.copyOfRange(lines, 10, lines.length);

        Stack<Character>[] stacks = new Stack[9];
        for (int i = 0; i < stacks.length; i++) {
            stacks[i] = new Stack<>();
        }

        // This is very specific input parsing.

        for (int i = 7; i >= 0; i--) {
            for (int k = 0; k < 9; k++) {
                char crateChar = moveCommands[i].charAt(k * 3 + (k) + 1);
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

        for (Stack<Character> stack : stacks) {
            builder.append(stack.peek());
        }

        output.setText("Output: " + builder);
    }
}
