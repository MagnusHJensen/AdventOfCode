package org.adventofcode.logiccircuit;

import java.util.HashMap;
import java.util.Map;

public class NumberGate implements LogicGate {

    private int number;
    private String inputchannel;
    private LogicGate input;

    private String outputChannel;
    private int output;

    public NumberGate (int number, String output) {
        this.number = number;
        outputChannel = output;
        this.output = -1;
    }

    public NumberGate (String input, String output) {
        this.inputchannel = input;
        outputChannel = output;
        this.output = -1;
    }

    public void updateNumber (int number) {
        this.number = number;
    }

    @Override
    public void update() {
        if (input == null) {
            output = number;
        }
        else {
            output = input.getOutputValue();
        }
    }

    @Override
    public void link(Map<String, LogicGate> gates) {
        input = gates.get(inputchannel);
    }

    @Override
    public int getOutputValue() {
        return output;
    }

    @Override
    public String getOutputChannel() {
        return outputChannel;
    }
}
