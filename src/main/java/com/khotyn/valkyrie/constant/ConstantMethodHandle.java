package com.khotyn.valkyrie.constant;

import java.util.List;

import com.khotyn.valkyrie.BytecodeBehavior;

/**
 * User: apple Date: 11-11-21 Time: PM5:46 Dust to dust, earth to earth.
 */
public class ConstantMethodHandle extends ConstantPoolInfo {

    public int              tag = CONSTANT_METHOD_HANDLE;
    public BytecodeBehavior referenceKind;
    public int              referenceIndex;

    public ConstantMethodHandle(List<ConstantPoolInfo> constantPool){
        super(constantPool);
    }

    public String toString() {
        return "ConstantMethodHandle(#" + referenceKind + "#" + referenceIndex + "):"
               + constantPool.get(referenceIndex - 1);
    }

    @Override
    public String getString() {
        return null;
    }
}
