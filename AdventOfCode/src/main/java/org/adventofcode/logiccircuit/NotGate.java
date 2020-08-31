package org.adventofcode.logiccircuit;

import java.util.HashMap;
import java.util.Map;

public class NotGate implements LogicGate {

    private String input1Channel;
    private String outputChannel;

    private LogicGate input1;
    private int outputVal;

    public NotGate(String input1, String output) {
        input1Channel = input1;
        outputChannel = output;
        outputVal = -1;
    }

    @Override
    public void update() {
        outputVal = input1.getOutputValue() ^ 65535;
    }

    @Override
    public void link(Map<String, LogicGate> gates) {
        input1 = gates.get(input1Channel);
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
