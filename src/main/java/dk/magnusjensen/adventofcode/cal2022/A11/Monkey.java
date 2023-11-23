package dk.magnusjensen.adventofcode.cal2022.A11;

import java.util.List;

public class Monkey {
    private List<Long> items;
    private long itemsInspected;
    private String operationOnInspect;
    private TestCondition testCondition;
    private int lcm;

    public Monkey(List<Long> items, String operationOnInspect, TestCondition testCondition) {
        this.items = items;
        this.itemsInspected = 0;
        this.operationOnInspect = operationOnInspect;
        this.testCondition = testCondition;
        this.lcm = -1;
    }

    public void setLcm(int lcm) {
        this.lcm = lcm;
    }

    public void addItem(long item) {
        items.add(item);
    }

    private void removeItem(int item) {
        items.remove(item);
    }

    public List<Long> getItems() {
        return items;
    }

    public void playRound(List<Monkey> monkeys, boolean worry) {
        for (int i = 0; i < items.size(); i++) {
            long item = items.get(i);
            long newWorryLevel = inspectItem(item);
            if (worry) {
                newWorryLevel /= 3;
            }
            if (lcm > 0) {
                newWorryLevel %= lcm;
            }
            if (testCondition.testCondition(newWorryLevel)) {
                monkeys.get(testCondition.getMonkeyToThrowIfTrue()).addItem(newWorryLevel);
            } else {
                monkeys.get(testCondition.getMonkeyToThrowIfFalse()).addItem(newWorryLevel);
            }
        }
        items.clear();
    }

    /**
     *
     * @param item The worry level of the item to inspect
     * @return The new worry level after the monkey has inspected it
     */
    public long inspectItem(long item) {
        this.itemsInspected++;
        // old * 7
        String[] parts = operationOnInspect.split(" ");
        long value = 0;
        if (parts[2].equals("old")) {
            value = item;
        } else {
            value = Integer.parseInt(parts[2]);
        }
        switch (parts[1].charAt(0)) {
            case '+' -> {
                return item + value;
            }
            case '*' -> {
                return item * value;
            }
            case '-' -> {
                return item - value;
            }
            case '/' -> {
                return item / value;
            }
            default -> {
                throw new RuntimeException(String.format("Operator %s was not found with value %d", parts[1].charAt(0), value));
            }
        }
    };

    public TestCondition getTestCondition() {
        return testCondition;
    }

    public long getItemsInspected() {
        return itemsInspected;
    }
}
