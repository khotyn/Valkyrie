package com.khotyn.valkyrie.constant;

import java.util.List;

/**
 * User: apple Date: 11-11-21 Time: PM5:49 Dust to dust, earth to earth.
 */
public class ConstantMethodType extends ConstantPoolInfo {

    public ConstantMethodType(List<ConstantPoolInfo> constantPool){
        super(constantPool);
    }

    public int tag = CONSTANT_METHOD_TYPE;

    public int descriptorIndex;

    public String toString() {
        return "Constant Method Type{DescriptorIndex:" + descriptorIndex + "}";
    }

    @Override
    public String getString() {
        // TODO Auto-generated method stub
        return null;
    }
}
