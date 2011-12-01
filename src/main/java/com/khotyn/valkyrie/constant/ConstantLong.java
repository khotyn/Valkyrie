package com.khotyn.valkyrie.constant;

import java.util.List;

/**
 * User: apple Date: 11-11-21 Time: PM5:40 Dust to dust, earth to earth.
 */
public class ConstantLong extends ConstantPoolInfo {

    public int  tag = CONSTANT_LONG;
    public long value;

    public ConstantLong(List<ConstantPoolInfo> constantPool){
        super(constantPool);
    }

    public String toString() {
        return "long\t" + value + ";";
    }

    @Override
    public String getString() {
        return String.valueOf(value);
    }
}
