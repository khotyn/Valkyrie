package com.khotyn.valkyrie.attribute;

import com.khotyn.valkyrie.constant.ConstantUTF8;

public class ElementValuePair {

    private ConstantUTF8 name;
    private ElementValue value;

    public ConstantUTF8 getName() {
        return name;
    }

    public void setName(ConstantUTF8 name) {
        this.name = name;
    }

    public ElementValue getValue() {
        return value;
    }

    public void setValue(ElementValue value) {
        this.value = value;
    }
}
