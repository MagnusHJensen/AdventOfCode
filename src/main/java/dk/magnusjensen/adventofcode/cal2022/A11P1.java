package dk.magnusjensen.adventofcode.cal2022;

import dk.magnusjensen.adventofcode.cal2022.A11.Monkey;
import dk.magnusjensen.adventofcode.cal2022.A11.TestCondition;
import dk.magnusjensen.adventofcode.templates.Assignment;
import dk.magnusjensen.adventofcode.templates.CalenderAssignment;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@CalenderAssignment(calendarName = 2022, assignmentName = "", number = 21, description = "")
public class A11P1 extends Assignment {

    @FXML
    private TextArea output;


    public A11P1(String name) {
        super(name);
    }


    public void partOne(String input) {
        String[] monkeys = input.split("\n\n");

        List<Monkey> monkeyList = new ArrayList<>();

        for (String monkey : monkeys) {
            String[] monkeyParts = monkey.split("\n");
            List<Long> items = new ArrayList<>();
            String operation = "";
            TestCondition condition = null;
            for (int i = 1; i < monkeyParts.length - 2; i++) {
                String monkeyLine = monkeyParts[i].strip();

                if (monkeyLine.startsWith("Starting items:")) {
                    String[] numbers = monkeyLine.split(":")[1].strip().split(", ");
                    for (String number : numbers) {
                        items.add(Long.parseLong(number));
                    }
                } else if (monkeyLine.startsWith("Operation:")) {
                    operation = monkeyLine.split("=")[1].strip();
                } else if (monkeyLine.startsWith("Test:")) {
                    String parts = monkeyLine.split(":")[1].strip();
                    char operator = 0;
                    int value = 0;
                    if (parts.startsWith("divisible by")) {
                        operator = '/';
                        value = Integer.parseInt(parts.split(" ")[parts.split(" ").length - 1]);
                    }

                    int monkeyToThrowIfTrue = Integer.parseInt(monkeyParts[i + 1].split(" ")[monkeyParts[i + 1].split(" ").length - 1]);
                    int monkeyToThrowIfFalse = Integer.parseInt(monkeyParts[i + 2].split(" ")[monkeyParts[i + 2].split(" ").length - 1]);
                    condition = new TestCondition(operator, value, monkeyToThrowIfTrue, monkeyToThrowIfFalse);
                }

            }
            monkeyList.add(new Monkey(items, operation, condition));
        }

        for (int i = 0; i < 20; i++) {
            for (Monkey monkey : monkeyList) {
                monkey.playRound(monkeyList, true);
            }
        }

        long[] topTwo = monkeyList.stream().mapToLong(Monkey::getItemsInspected).sorted().toArray();

        output.setText("Output: " + topTwo[topTwo.length - 2] + " * " + topTwo[topTwo.length - 1] + " = " + (topTwo[topTwo.length - 2] * topTwo[topTwo.length - 1]));

    }
}
