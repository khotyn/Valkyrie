package com.khotyn.valkyrie.constant;

import com.khotyn.valkyrie.ConstantPoolInfo;

/**
 * User: apple
 * Date: 11-11-21
 * Time: PM5:36
 * Dust to dust, earth to earth.
 */
public class ConstantInteger extends ConstantPoolInfo {
    public int tag = CONSTANT_INTEGER;

    public int value;

    public String toString() {
        return "Constant Integer{value: " + value + "}";
    }
}
