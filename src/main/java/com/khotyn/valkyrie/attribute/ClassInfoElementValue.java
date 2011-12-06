package com.khotyn.valkyrie.attribute;

import java.util.ArrayList;
import java.util.List;

import com.khotyn.valkyrie.TypeTags;

public class ClassInfoElementValue extends ElementValue {

    public static List<TypeTags> tags;
    static {
        List<TypeTags> tags = new ArrayList<TypeTags>();
        tags.add(TypeTags.CLASS);
        ClassInfoElementValue.tags = tags;
    }

    private int                  classInfoIndex;

    public int getClassInfoIndex() {
        return classInfoIndex;
    }

    public void setClassInfoIndex(int classInfoIndex) {
        this.classInfoIndex = classInfoIndex;
    }
}
