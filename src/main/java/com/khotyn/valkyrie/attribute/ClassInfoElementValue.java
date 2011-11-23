package com.khotyn.valkyrie.attribute;

import java.util.ArrayList;
import java.util.List;

import com.khotyn.valkyrie.TypeTags;
import com.khotyn.valkyrie.constant.ConstantUTF8;

public class ClassInfoElementValue extends ElementValue {

    {
        List<TypeTags> tags = new ArrayList<TypeTags>();
        tags.add(TypeTags.CLASS);
        this.tags = tags;
    }

    private ConstantUTF8 classInfo;

    public ConstantUTF8 getClassInfo() {
        return classInfo;
    }

    public void setClassInfo(ConstantUTF8 classInfo) {
        this.classInfo = classInfo;
    }
}
