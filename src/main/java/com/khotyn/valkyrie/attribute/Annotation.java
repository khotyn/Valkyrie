package com.khotyn.valkyrie.attribute;

import java.util.List;

import com.khotyn.valkyrie.constant.ConstantUTF8;

public class Annotation {

    private ConstantUTF8           typeIndex;
    private List<ElementValuePair> elementValuePairs;

    public ConstantUTF8 getTypeIndex() {
        return typeIndex;
    }

    public void setTypeIndex(ConstantUTF8 typeIndex) {
        this.typeIndex = typeIndex;
    }

    public List<ElementValuePair> getElementValuePairs() {
        return elementValuePairs;
    }

    public void setElementValuePairs(List<ElementValuePair> elementValuePairs) {
        this.elementValuePairs = elementValuePairs;
    }
}
