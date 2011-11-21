package com.khotyn.valkyrie.constant;

import com.khotyn.valkyrie.ConstantPoolInfo;

/**
 * User: apple
 * Date: 11-11-21
 * Time: PM5:46
 * Dust to dust, earth to earth.
 */
public class ConstantMethodHandle extends ConstantPoolInfo {
    public int tag = CONSTANT_METHOD_HANDLE;

    public int referenceKind;
    public int referenceIndex;

    public String toString() {
        return "Constant Method Handle{Reference Kind:" + referenceKind + ",Reference Index:" + referenceIndex + "}";
    }
}
