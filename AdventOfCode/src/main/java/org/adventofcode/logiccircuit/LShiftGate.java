package org.adventofcode.logiccircuit;

import java.util.HashMap;
import java.util.Map;

public class LShiftGate implements LogicGate {

    private String input1Channel;
    private String input2Channel;
    private String outputChannel;

    private LogicGate input1;
    private LogicGate input2;
    private int outputVal;

    public LShiftGate(String input1, String input2, String output) {
        input1Channel = input1;
        input2Channel = input2;
        outputChannel = output;
        outputVal = -1;
    }

    @Override
    public void update() {
        outputVal = input1.getOutputValue() << input2.getOutputValue();
    }

    @Override
    public void link(Map<String, LogicGate> gates) {
        input1 = gates.get(input1Channel);
        input2 = gates.get(input2Channel);
    }

    @Override
    public int getOutputValue() {
        return outputVal;
    }

    @Override
    public String getOutputChannel() {
        return outputChannel;
    }
}
