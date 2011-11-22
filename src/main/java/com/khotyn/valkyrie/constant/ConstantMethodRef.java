package com.khotyn.valkyrie.constant;

import com.khotyn.valkyrie.ConstantPoolInfo;

/**
 * User: apple Date: 11-11-18 Time: PM10:13 Dust to dust, earth to earth.
 */
public class ConstantMethodRef extends ConstantPoolInfo {

    public int tag = CONSTANT_METHOD_REF;
    public int classIndex;
    public int nameAndTypeIndex;

    public String toString() {
        return "Method Ref{classIndex:" + classIndex + ";nameAndTypeIndex:" + nameAndTypeIndex + "}";
    }
}
