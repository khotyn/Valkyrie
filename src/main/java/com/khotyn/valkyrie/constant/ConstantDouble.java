package com.khotyn.valkyrie.constant;

import java.util.List;

/**
 * User: apple Date: 11-11-21 Time: PM5:41 Dust to dust, earth to earth.
 */
public class ConstantDouble extends ConstantPoolInfo {

    public int    tag = CONSTANT_DOUBLE;
    public double value;

    public ConstantDouble(List<ConstantPoolInfo> constantPool){
        super(constantPool);
    }

    public String toString() {
        return "double\t" + value + ";";
    }

    @Override
    public String getString() {
        return String.valueOf(value);
    }
}
