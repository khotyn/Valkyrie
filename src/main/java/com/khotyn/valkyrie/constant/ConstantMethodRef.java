package com.khotyn.valkyrie.constant;

import java.util.List;

/**
 * User: apple Date: 11-11-18 Time: PM10:13 Dust to dust, earth to earth.
 */
public class ConstantMethodRef extends ConstantPoolInfo {

    public int tag = CONSTANT_METHOD_REF;
    public int classIndex;
    public int nameAndTypeIndex;

    public ConstantMethodRef(List<ConstantPoolInfo> constantPool){
        super(constantPool);
    }

    public String toString() {
        return "Method\t#" + classIndex + ".#" + nameAndTypeIndex + ";\t// " + getString();
    }

    @Override
    public String getString() {
        return ((ConstantUTF8) constantPool.get(((ConstantClass) constantPool.get(classIndex - 1)).nameIndex - 1)).getContent()
               + "."
               + ((ConstantUTF8) constantPool.get(((ConstantNameAndType) constantPool.get(nameAndTypeIndex - 1)).nameIndex - 1)).getContent()
               + ":"
               + ((ConstantUTF8) constantPool.get(((ConstantNameAndType) constantPool.get(nameAndTypeIndex - 1)).descriptorIndex - 1)).getContent();
    }
}
