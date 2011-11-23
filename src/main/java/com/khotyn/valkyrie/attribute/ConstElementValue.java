package com.khotyn.valkyrie.attribute;

import java.util.ArrayList;
import java.util.List;

import com.khotyn.valkyrie.ConstantPoolInfo;
import com.khotyn.valkyrie.TypeTags;

public class ConstElementValue extends ElementValue {

    {
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
        this.tags = tags;
    }

    private ConstantPoolInfo constValue;

    public ConstantPoolInfo getConstValue() {
        return constValue;
    }

    public void setConstValue(ConstantPoolInfo constValue) {
        this.constValue = constValue;
    }
}
