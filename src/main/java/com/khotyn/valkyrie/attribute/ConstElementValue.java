package com.khotyn.valkyrie.attribute;

import java.util.ArrayList;
import java.util.List;

import com.khotyn.valkyrie.TypeTags;

public class ConstElementValue extends ElementValue {

    static {
        List<TypeTags> tags = new ArrayList<TypeTags>();
        tags.add(TypeTags.BYTE);
        tags.add(TypeTags.CHAR);
        tags.add(TypeTags.DOUBLE);
        tags.add(TypeTags.FLOAT);
        tags.add(TypeTags.INT);
        tags.add(TypeTags.LONG);
        tags.add(TypeTags.SHORT);
        tags.add(TypeTags.BOOLEAN);
        tags.add(TypeTags.STRING);
        ConstElementValue.tags = tags;
    }

    private int constValueIndex;

    public int getConstValueIndex() {
        return constValueIndex;
    }

    public void setConstValueIndex(int constValueIndex) {
        this.constValueIndex = constValueIndex;
    }

}
