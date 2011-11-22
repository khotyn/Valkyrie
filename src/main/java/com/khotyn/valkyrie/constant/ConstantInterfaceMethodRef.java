package com.khotyn.valkyrie.constant;

import com.khotyn.valkyrie.ConstantPoolInfo;

/**
 * User: apple Date: 11-11-21 Time: PM5:43 Dust to dust, earth to earth.
 */
public class ConstantInterfaceMethodRef extends ConstantPoolInfo {

    public int tag = CONSTANT_INTERFACE_METHOD_REF;

    public int classIndex;

    public int nameAndTypeIndex;

    public String toString() {
        return "Interface Method Ref{classIndex:" + classIndex + ";nameAndTypeIndex:" + nameAndTypeIndex + "}";
    }
}
