package org.adventofcode.graph;

import java.util.HashMap;
import java.util.Map;

public class Node {
    private ValueObject<?> value;
    private Map<String, ValueObject<?>> attributes;

    public Node () {
        this(new ValueObject<>(1));
    }

    public Node (ValueObject<?> value) {
        this.value = value;
        this.attributes = new HashMap<>();
    }

    public <T> T getValue() {
        return (T)value.getValue();
    }

    public void setValue (ValueObject<?> newVal) {
        this.value = newVal;
    }

    public <T> void setAttribute (String name, T value) {
        attributes.put(name, new ValueObject<>(value));
    }

    public <T> T getAttribute(String name) {
        return (T)attributes.get(name).getValue();
    }
}
