package dk.magnusjensen.adventofcode.cal2022.A11;

public class TestCondition {
    private char operation;
    private int value;
    private int monkeyToThrowIfTrue;
    private int monkeyToThrowIfFalse;

    public TestCondition(char operation, int value, int monkeyToThrowIfTrue, int monkeyToThrowIfFalse) {
        this.operation = operation;
        this.value = value;
        this.monkeyToThrowIfTrue = monkeyToThrowIfTrue;
        this.monkeyToThrowIfFalse = monkeyToThrowIfFalse;
    }

    public char getOperation() {
        return operation;
    }

    public int getValue() {
        return value;
    }

    public int getMonkeyToThrowIfTrue() {
        return monkeyToThrowIfTrue;
    }

    public int getMonkeyToThrowIfFalse() {
        return monkeyToThrowIfFalse;
    }

    public boolean testCondition(long item) {
        switch (operation) {
            case '/' -> {
                return item % value == 0;
            }
            default -> {
                throw new RuntimeException("Could not find operation to match " + operation);
            }
        }
    }
}
