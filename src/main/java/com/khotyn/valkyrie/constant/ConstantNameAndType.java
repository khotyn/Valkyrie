package com.khotyn.valkyrie.constant;

import com.khotyn.valkyrie.ConstantPoolInfo;

/**
 * User: apple Date: 11-11-18 Time: PM11:03 Dust to dust, earth to earth.
 */
public class ConstantNameAndType extends ConstantPoolInfo {

    public int tag = CONSTANT_NAME_AND_TYPE;

    public int nameIndex;
    public int descriptorIndex;

    public String toString() {

        return "ConstantNameAndType{nameIndex:" + nameIndex + ";descriptorIndex:" + descriptorIndex + "}";
    }
}
