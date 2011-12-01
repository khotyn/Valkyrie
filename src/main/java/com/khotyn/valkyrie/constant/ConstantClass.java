package com.khotyn.valkyrie.constant;

import java.util.List;

/**
 * User: apple Date: 11-11-18 Time: PM10:41 Dust to dust, earth to earth.
 */
public class ConstantClass extends ConstantPoolInfo {

    public int tag = CONSTANT_CLASS;
    public int nameIndex;

    public ConstantClass(List<ConstantPoolInfo> constantPool){
        super(constantPool);
    }

    @Override
    public String toString() {
        return "class\t#" + nameIndex + "\t// " + getString();
    }

    @Override
    public String getString() {
        return ((ConstantUTF8) constantPool.get(nameIndex - 1)).getContent();
    }
}
