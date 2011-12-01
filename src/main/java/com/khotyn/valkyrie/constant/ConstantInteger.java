package com.khotyn.valkyrie.constant;

import java.util.List;

/**
 * User: apple Date: 11-11-21 Time: PM5:36 Dust to dust, earth to earth.
 */
public class ConstantInteger extends ConstantPoolInfo {

    public int tag = CONSTANT_INTEGER;
    public int value;

    public ConstantInteger(List<ConstantPoolInfo> constantPool){
        super(constantPool);
    }

    public String toString() {
        return "int\t" + value + ";";
    }

    @Override
    public String getString() {
        return String.valueOf(value);
    }
}
