package com.khotyn.valkyrie.attribute;

import java.util.ArrayList;
import java.util.List;

import com.khotyn.valkyrie.TypeTags;

public class ArrayElementValue extends ElementValue {

    public static List<TypeTags> tags;
    static {
        List<TypeTags> tags = new ArrayList<TypeTags>();
        tags.add(TypeTags.ARRAY);
        ArrayElementValue.tags = tags;
    }

    private List<ElementValue>   values;

    public List<ElementValue> getValues() {
        return values;
    }

    public void setValues(List<ElementValue> values) {
        this.values = values;
    }

}
