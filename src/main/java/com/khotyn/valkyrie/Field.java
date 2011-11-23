package com.khotyn.valkyrie;

import java.util.List;

import com.khotyn.valkyrie.attribute.Attribute;

public class Field {

    private List<AccessFlags> accessFlags;
    private int              nameIndex;
    private int              descriptorIndex;
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

    public List<Attribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<Attribute> attributes) {
        this.attributes = attributes;
    }

    public List<AccessFlags> getAccessFlags() {
        return accessFlags;
    }

    public void setAccessFlags(List<AccessFlags> accessFlags) {
        this.accessFlags = accessFlags;
    }
}
