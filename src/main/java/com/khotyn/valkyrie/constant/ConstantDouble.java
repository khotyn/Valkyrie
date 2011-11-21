package com.khotyn.valkyrie.constant;

import com.khotyn.valkyrie.ConstantPoolInfo;

/**
 * User: apple
 * Date: 11-11-21
 * Time: PM5:41
 * Dust to dust, earth to earth.
 */
public class ConstantDouble extends ConstantPoolInfo {
    public int tag = CONSTANT_DOUBLE;

    public double value;

    public String toString() {
        return "Constant Double{ " + value + "}";
    }
}
