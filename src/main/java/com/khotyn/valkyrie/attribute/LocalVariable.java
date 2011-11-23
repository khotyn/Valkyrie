package com.khotyn.valkyrie.attribute;

/**
 * TODO: LocalVariable.java
 * 
 * @author khotyn 2011-11-23 上午10:12:16
 */
public class LocalVariable {

    private int startPC;
    private int length;
    private int nameIndex;
    private int descriptorIndex;
    private int index;

    public int getStartPC() {
        return startPC;
    }

    public void setStartPC(int startPC) {
        this.startPC = startPC;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
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

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
