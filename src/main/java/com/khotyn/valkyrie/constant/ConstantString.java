package com.khotyn.valkyrie.constant;

import java.util.List;

/**
 * User: apple Date: 11-11-18 Time: PM10:21 Dust to dust, earth to earth.
 */
public class ConstantString extends ConstantPoolInfo {

    public int tag = CONSTANT_STRING;
    public int stringIndex;

    public ConstantString(List<ConstantPoolInfo> constantPool){
        super(constantPool);
    }

    public String toString() {
        return "String\t#" + stringIndex + ";\t// " + getString();
    }

    @Override
    public String getString() {
        return ((ConstantUTF8) constantPool.get(stringIndex - 1)).getContent();
    }
}
