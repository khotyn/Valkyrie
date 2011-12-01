package com.khotyn.valkyrie.constant;

import java.util.List;

/**
 * User: apple Date: 11-11-18 Time: PM10:18 Dust to dust, earth to earth.
 */
public class ConstantFieldRef extends ConstantPoolInfo {

    public int tag = CONSTANT_FIELD_REF;
    public int classIndex;
    public int nameAndTypeIndex;

    public ConstantFieldRef(List<ConstantPoolInfo> constantPool){
        super(constantPool);
    }

    public String toString() {
        return "field\t#" + classIndex + ".#" + nameAndTypeIndex + ";\t// " + getString();
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
