package com.khotyn.valkyrie.attribute;

import java.util.ArrayList;
import java.util.List;

import com.khotyn.valkyrie.TypeTags;
import com.khotyn.valkyrie.constant.ConstantUTF8;

public class EnumConstElementValue extends ElementValue {

    {
        List<TypeTags> tags = new ArrayList<TypeTags>();
        tags.add(TypeTags.ENUM);
        this.tags = tags;
    }

    private ConstantUTF8 typeName;
    private ConstantUTF8 constName;

    public ConstantUTF8 getTypeName() {
        return typeName;
    }

    public void setTypeName(ConstantUTF8 typeName) {
        this.typeName = typeName;
    }

    public ConstantUTF8 getConstName() {
        return constName;
    }

    public void setConstName(ConstantUTF8 constName) {
        this.constName = constName;
    }
}
