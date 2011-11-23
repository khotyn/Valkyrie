package com.khotyn.valkyrie.attribute;

import java.util.List;

import com.khotyn.valkyrie.ConstantPoolInfo;
import com.khotyn.valkyrie.constant.ConstantMethodHandle;

public class BootstrapMethod {

    private ConstantMethodHandle   methodRef;
    private List<ConstantPoolInfo> arguments;

    public ConstantMethodHandle getMethodRef() {
        return methodRef;
    }

    public void setMethodRef(ConstantMethodHandle methodRef) {
        this.methodRef = methodRef;
    }

    public List<ConstantPoolInfo> getArguments() {
        return arguments;
    }

    public void setArguments(List<ConstantPoolInfo> arguments) {
        this.arguments = arguments;
    }
}
