package com.khotyn.valkyrie.attribute;

import java.util.List;

import com.khotyn.valkyrie.constant.ConstantUTF8;

public class BootstrapMethods extends Attribute {

    public ConstantUTF8   name = BOOTSTRAP_METHODS;
    List<BootstrapMethod> bootstrapMethods;

    public List<BootstrapMethod> getBootstrapMethods() {
        return bootstrapMethods;
    }

    public void setBootstrapMethods(List<BootstrapMethod> bootstrapMethods) {
        this.bootstrapMethods = bootstrapMethods;
    }
}
