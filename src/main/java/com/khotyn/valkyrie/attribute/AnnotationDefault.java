package com.khotyn.valkyrie.attribute;

import com.khotyn.valkyrie.constant.ConstantUTF8;

public class AnnotationDefault extends Attribute {

    public static ConstantUTF8 name = ANNOTAION_DEFAULT;
    private ElementValue       defaultValue;

    public ElementValue getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(ElementValue defaultValue) {
        this.defaultValue = defaultValue;
    }
}
