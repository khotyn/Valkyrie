package com.khotyn.valkyrie.constant;

import com.khotyn.valkyrie.ConstantPoolInfo;

/**
 * User: apple
 * Date: 11-11-18
 * Time: PM10:18
 * Dust to dust, earth to earth.
 */
public class ConstantFieldRef extends ConstantPoolInfo {
    public int tag = CONSTANT_FIELD_REF;

    public int classIndex;
    public int nameAndTypeIndex;

    public String toString() {
        return "Field Ref{classIndex:" + classIndex + " nameAndTypeIndex:" + nameAndTypeIndex + "}";
    }
}
