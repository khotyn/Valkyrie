package com.khotyn.valkyrie.attribute;

import java.util.List;

public class BootstrapMethod {

    private int           methodRef;
    private List<Integer> arguments;

    public int getMethodRef() {
        return methodRef;
    }

    public void setMethodRef(int methodRef) {
        this.methodRef = methodRef;
    }

    public List<Integer> getArguments() {
        return arguments;
    }

    public void setArguments(List<Integer> arguments) {
        this.arguments = arguments;
    }
}
