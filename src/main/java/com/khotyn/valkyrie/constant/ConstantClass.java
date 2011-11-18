package com.khotyn.valkyrie.constant;

import com.khotyn.valkyrie.ConstantPoolInfo;

/**
 * User: apple
 * Date: 11-11-18
 * Time: PM10:41
 * Dust to dust, earth to earth.
 */
public class ConstantClass extends ConstantPoolInfo {
    public int tag = CONSTANT_CLASS;

    public int nameIndex;

    public String toString() {
        return "Class{nameIndex: " + nameIndex + "}";
    }
}
