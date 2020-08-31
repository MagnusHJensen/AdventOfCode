package org.adventofcode.graph;

public class ValueObject<T> {

    private T value;

    public ValueObject (T value) {
        this.value = value;
    }

    public void setValue(T newVal) {
        value = newVal;
    }

    public T getValue () {
        return value;
    }
}
