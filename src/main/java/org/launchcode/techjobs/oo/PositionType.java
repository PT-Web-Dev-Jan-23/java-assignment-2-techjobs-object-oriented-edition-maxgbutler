package org.launchcode.techjobs.oo;

import java.util.*;

public class PositionType extends JobField{

    public PositionType(String value) {
        super(value);
    }
    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if(!(obj instanceof PositionType)) return false;
        PositionType comparePosition = (PositionType) obj;
        return comparePosition.getId() == this.getId();
    }
}
