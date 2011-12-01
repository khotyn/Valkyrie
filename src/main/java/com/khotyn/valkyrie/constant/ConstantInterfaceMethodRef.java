package com.khotyn.valkyrie.constant;

import java.util.List;

/**
 * User: apple Date: 11-11-21 Time: PM5:43 Dust to dust, earth to earth.
 */
public class ConstantInterfaceMethodRef extends ConstantPoolInfo {

    public int tag = CONSTANT_INTERFACE_METHOD_REF;
    public int classIndex;
    public int nameAndTypeIndex;

    public ConstantInterfaceMethodRef(List<ConstantPoolInfo> constantPool){
        super(constantPool);
    }

    public String toString() {
        return "InterfaceMethodRef(#" + classIndex + "#" + nameAndTypeIndex + "):" + getString();
    }

    @Override
    public String getString() {
        return constantPool.get(classIndex - 1) + " " + constantPool.get(nameAndTypeIndex - 1);
    }
}
