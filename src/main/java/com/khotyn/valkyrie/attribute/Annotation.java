package com.khotyn.valkyrie.attribute;

import java.util.List;

public class Annotation {

    private int                    typeIndex;
    private List<ElementValuePair> elementValuePairs;

    public int getTypeIndex() {
        return typeIndex;
    }

    public void setTypeIndex(int typeIndex) {
        this.typeIndex = typeIndex;
    }

    public List<ElementValuePair> getElementValuePairs() {
        return elementValuePairs;
    }

    public void setElementValuePairs(List<ElementValuePair> elementValuePairs) {
        this.elementValuePairs = elementValuePairs;
    }
}
