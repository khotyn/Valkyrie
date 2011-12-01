package com.khotyn.valkyrie.constant;

import java.util.List;

/**
 * User: apple Date: 11-11-21 Time: PM5:51 Dust to dust, earth to earth.
 */
public class ConstantInvokeDynamic extends ConstantPoolInfo {

    public int tag = CONSTANT_INVOKE_DYNAMIC;
    public int bootstrapMethodAttrIndex;
    public int nameAndTypeIndex;

    public ConstantInvokeDynamic(List<ConstantPoolInfo> constantPool){
        super(constantPool);
    }

    public String toString() {
        return "InvokeDynamic(#" + bootstrapMethodAttrIndex + "#" + nameAndTypeIndex + "):" + getString();
    }

    @Override
    public String getString() {
        return constantPool.get(bootstrapMethodAttrIndex - 1) + " " + constantPool.get(nameAndTypeIndex - 1);
    }
}
