package com.khotyn.valkyrie.attribute;

public class AnnotationDefault extends Attribute {

    protected String     name = ANNOTAION_DEFAULT;
    private ElementValue defaultValue;

    public ElementValue getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(ElementValue defaultValue) {
        this.defaultValue = defaultValue;
    }
}
