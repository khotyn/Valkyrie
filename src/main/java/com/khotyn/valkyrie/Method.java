package com.khotyn.valkyrie;

import java.util.List;

import com.khotyn.valkyrie.attribute.Attribute;

/**
 * Representing a method
 * 
 * @author khotyn 2011-11-17 PM 5:16:00
 */
public class Method {
    private List<AccessFlags> accessFlags;
    private int               nameIndex;
    private int               descriptorIndex;
    private List<Attribute>   attributes;

    public List<AccessFlags> getAccessFlags() {
        return accessFlags;
    }

    public void setAccessFlags(List<AccessFlags> accessFlags) {
        this.accessFlags = accessFlags;
    }

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

}
