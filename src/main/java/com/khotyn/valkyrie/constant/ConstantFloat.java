package com.khotyn.valkyrie.constant;

import java.util.List;

/**
 * User: apple Date: 11-11-21 Time: PM5:38 Dust to dust, earth to earth.
 */
public class ConstantFloat extends ConstantPoolInfo {

    public int   tag = CONSTANT_FLOAT;
    public float value;

    public ConstantFloat(List<ConstantPoolInfo> constantPool){
        super(constantPool);
    }

    public String toString() {
        return "float\t" + value + ";";
    }

    @Override
    public String getString() {
        return String.valueOf(value);
    }
}
