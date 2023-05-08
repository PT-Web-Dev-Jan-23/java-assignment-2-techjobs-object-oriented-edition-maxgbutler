package org.launchcode.techjobs.oo;

import java.util.*;

public class PositionType {

    private int id;
    private static int nextId = 1;
    private String value;

    public PositionType() {
        id = nextId;
        nextId++;
    }

    public PositionType(String value) {
        this();
        this.value = value;
    }

    // TODO: Add a custom toString() method that returns the data stored in 'value'.

    // TODO: Add custom equals and hashCode methods. Consider two PositionType objects "equal" when
    //  their id fields match.

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object compare) {
        if (compare == this) return true;
        if(!(compare instanceof PositionType)) return false;
        PositionType comparePosition = (PositionType) compare;
        return comparePosition.getId() == this.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getId());
    }

    // Getters and Setters:

    public int getId() {
        return id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
