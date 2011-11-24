package com.khotyn.valkyrie.attribute;

import java.util.ArrayList;
import java.util.List;

import com.khotyn.valkyrie.TypeTags;

public class EnumConstElementValue extends ElementValue {

    static {
        List<TypeTags> tags = new ArrayList<TypeTags>();
        tags.add(TypeTags.ENUM);
        EnumConstElementValue.tags = tags;
    }

    private int typeNameIndex;
    private int constNameIndex;

    public int getTypeNameIndex() {
        return typeNameIndex;
    }

    public void setTypeNameIndex(int typeNameIndex) {
        this.typeNameIndex = typeNameIndex;
    }

    public int getConstNameIndex() {
        return constNameIndex;
    }

    public void setConstNameIndex(int constNameIndex) {
        this.constNameIndex = constNameIndex;
    }

}
