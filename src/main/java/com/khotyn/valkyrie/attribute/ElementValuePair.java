package com.khotyn.valkyrie.attribute;

public class ElementValuePair {

    private int          nameIndex;
    private ElementValue value;

    public int getNameIndex() {
        return nameIndex;
    }

    public void setNameIndex(int nameIndex) {
        this.nameIndex = nameIndex;
    }

    public ElementValue getValue() {
        return value;
    }

    public void setValue(ElementValue value) {
        this.value = value;
    }
}
