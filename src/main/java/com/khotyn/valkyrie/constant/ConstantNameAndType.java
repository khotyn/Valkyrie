package com.khotyn.valkyrie.constant;

import java.util.List;

/**
 * User: apple Date: 11-11-18 Time: PM11:03 Dust to dust, earth to earth.
 */
public class ConstantNameAndType extends ConstantPoolInfo {

    public int tag = CONSTANT_NAME_AND_TYPE;
    public int nameIndex;
    public int descriptorIndex;

    public ConstantNameAndType(List<ConstantPoolInfo> constantPool){
        super(constantPool);
    }

    public String toString() {
        return "NameAndType\t#" + nameIndex + ".#" + descriptorIndex + ";\t// " + getString();
    }

    @Override
    public String getString() {
        return ((ConstantUTF8) constantPool.get(nameIndex - 1)).getContent() + ":"
               + ((ConstantUTF8) constantPool.get(descriptorIndex - 1)).getContent();
    }
}
