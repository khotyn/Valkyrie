package com.khotyn.valkyrie.attribute;

import java.util.List;

public class BootstrapMethods extends Attribute {

    protected String      name = BOOTSTRAP_METHODS;
    List<BootstrapMethod> bootstrapMethods;

    public List<BootstrapMethod> getBootstrapMethods() {
        return bootstrapMethods;
    }

    public void setBootstrapMethods(List<BootstrapMethod> bootstrapMethods) {
        this.bootstrapMethods = bootstrapMethods;
    }
}
