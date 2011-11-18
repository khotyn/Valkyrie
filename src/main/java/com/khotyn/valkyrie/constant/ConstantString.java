package com.khotyn.valkyrie.constant;

import com.khotyn.valkyrie.ConstantPoolInfo;

/**
 * User: apple
 * Date: 11-11-18
 * Time: PM10:21
 * Dust to dust, earth to earth.
 */
public class ConstantString extends ConstantPoolInfo {
    public int tag = CONSTANT_STRING;

    public int stringIndex;

    public String toString() {
        return "String{StringIndex:" + stringIndex + "}";
    }
}
