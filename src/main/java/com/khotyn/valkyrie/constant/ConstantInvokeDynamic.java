package com.khotyn.valkyrie.constant;

import com.khotyn.valkyrie.ConstantPoolInfo;

/**
 * User: apple
 * Date: 11-11-21
 * Time: PM5:51
 * Dust to dust, earth to earth.
 */
public class ConstantInvokeDynamic extends ConstantPoolInfo {
    public int tag = CONSTANT_INVOKE_DYNAMIC;

    public int bootstrapMethodAttrIndex;

    public int nameAndTypeIndex;

    public String toString() {
        return "Constant Invoke Dynamic{BootStrapMethodAttrIndex:" + bootstrapMethodAttrIndex + ";NameAndTypeIndex:" + nameAndTypeIndex + "}";
    }
}
