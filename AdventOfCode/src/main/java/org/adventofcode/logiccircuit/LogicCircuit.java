package org.adventofcode.logiccircuit;

import java.util.HashMap;
import java.util.Map;

public class LogicCircuit {
    private Map<String, LogicGate> gates;

    public LogicCircuit () {
        gates = new HashMap<>();
    }

    public void addGate (LogicGate gate) {
        gates.put(gate.getOutputChannel(), gate);
    }

    public void run () {
        for (Map.Entry<String, LogicGate> entry : gates.entrySet()) {
            entry.getValue().link(gates);
        }

        for (int i = 0; i < gates.size(); i++) {
            for (Map.Entry<String, LogicGate> entry : gates.entrySet()) {
                entry.getValue().update();
            }
        }
    }

    public int getValueOfOutput (String channel) {
        return gates.get(channel).getOutputValue();
    }
}
