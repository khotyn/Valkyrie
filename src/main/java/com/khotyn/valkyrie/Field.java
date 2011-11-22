package com.khotyn.valkyrie;

import java.util.List;

public class Field {

    private List<AccessFlag> accessFlags;
    private int              nameIndex;
    private int              descriptorIndex;
    private int              attributesCount;
    private List<Attribute>  attributes;

    public int getNameIndex() {
        return nameIndex;
    }

    public void setNameIndex(int nameIndex) {
        this.nameIndex = nameIndex;
    }

    public int getDescriptorIndex() {
        return descriptorIndex;
    }

    public void setDescriptorIndex(int descriptorIndex) {
        this.descriptorIndex = descriptorIndex;
    }

    public int getAttributesCount() {
        return attributesCount;
    }

    public void setAttributesCount(int attributesCount) {
        this.attributesCount = attributesCount;
    }

    public List<Attribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<Attribute> attributes) {
        this.attributes = attributes;
    }

    public List<AccessFlag> getAccessFlags() {
        return accessFlags;
    }

    public void setAccessFlags(List<AccessFlag> accessFlags) {
        this.accessFlags = accessFlags;
    }
}
