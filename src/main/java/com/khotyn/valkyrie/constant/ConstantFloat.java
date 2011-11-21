package com.khotyn.valkyrie.constant;

import com.khotyn.valkyrie.ConstantPoolInfo;

/**
 * User: apple
 * Date: 11-11-21
 * Time: PM5:38
 * Dust to dust, earth to earth.
 */
public class ConstantFloat extends ConstantPoolInfo {
    public int tag = CONSTANT_FLOAT;

    public float value;

    public String toString() {
        return "Constant Float{value:" + value + "}";
    }
}
