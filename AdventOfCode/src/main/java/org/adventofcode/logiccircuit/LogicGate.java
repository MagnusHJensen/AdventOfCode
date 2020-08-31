package org.adventofcode.logiccircuit;

import java.util.HashMap;
import java.util.Map;

public interface LogicGate {
    public void update();
    public void link(Map<String, LogicGate> gates);
    public int getOutputValue();
    public String getOutputChannel();
}
