package com.khotyn.valkyrie.attribute;

import java.util.ArrayList;
import java.util.List;

import com.khotyn.valkyrie.TypeTags;

public class ArrayElementValue extends ElementValue {

    {
        List<TypeTags> tags = new ArrayList<TypeTags>();
        tags.add(TypeTags.ARRAY);
        this.tags = tags;
    }

    private Object[] values;

    public Object[] getValues() {
        return values;
    }

    public void setValues(Object[] values) {
        this.values = values;
    }
}
