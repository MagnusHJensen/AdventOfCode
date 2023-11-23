package dk.magnusjensen.adventofcode.cal2022;

import dk.magnusjensen.adventofcode.cal2022.A11.Monkey;
import dk.magnusjensen.adventofcode.cal2022.A11.TestCondition;
import dk.magnusjensen.adventofcode.templates.Assignment;
import dk.magnusjensen.adventofcode.templates.CalenderAssignment;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@CalenderAssignment(calendarName = 2022, assignmentName = "", number = 22, description = "")
public class A11P2 extends Assignment {

    @FXML
    private TextArea output;


    public A11P2(String name) {
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

        List<Integer> checks = monkeyList.stream().map(m -> m.getTestCondition().getValue()).toList();
        int lcm = lcm(checks, 0);
        monkeyList.forEach(m -> m.setLcm(lcm));

        long[] inspectionCounts = new long[monkeyList.size()];
        for(int iter = 0; iter < 10000; iter++) {
            for(int monkeyNum = 0; monkeyNum < monkeyList.size(); monkeyNum++) {
                Monkey cur = monkeyList.get(monkeyNum);
                if(cur.getItems().size() == 0)
                    continue;
                while(cur.getItems().size() > 0) {
                    long curItem = cur.getItems().remove(0);
                    inspectionCounts[monkeyNum]++;
                    curItem = cur.inspectItem(curItem);
                    curItem %= lcm;
                    if (cur.getTestCondition().testCondition(curItem)) {
                        monkeyList.get(cur.getTestCondition().getMonkeyToThrowIfTrue()).addItem(curItem);
                    } else {
                        monkeyList.get(cur.getTestCondition().getMonkeyToThrowIfFalse()).addItem(curItem);
                    }
                }
            }
        }

        Arrays.sort(inspectionCounts);

        output.setText("Output: " + inspectionCounts[inspectionCounts.length - 2] + " * " + inspectionCounts[inspectionCounts.length - 1] + " = " + (inspectionCounts[inspectionCounts.length - 2] * inspectionCounts[inspectionCounts.length - 1]));

    }

    //recursive calculation of lcm of arraylist nums
    //lcm of two numbers: (a * b) / greatest common factor of a and b
    public static int lcm(List<Integer> nums, int index) {
        if(index == nums.size() - 1)
            return nums.get(index);
        int a = nums.get(index);
        int b = lcm(nums,index+1);
        return (a * b)/gcd(a,b);
    }

    //recursive GCD calculation
    public static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
