package com.khotyn.valkyrie;

import java.util.Arrays;
import java.util.List;

import com.khotyn.valkyrie.attribute.Attribute;

/**
 * Representing the the java byte code
 * 
 * @author khotyn 2011-11-17 ����4:45:53
 */
public class Clazz {

    public static final int        U1           = 2;
    public static final int        U2           = U1 * 2;
    public static final int        U4           = U2 * 2;
    public static final String     MAGIC_NUMBER = "CAFEBABE";
    private int                    majorVersion;
    private int                    minorVersion;
    private List<ConstantPoolInfo> constantPoolInfos;
    private List<AccessFlags>       accessFlags;
    private int                    thisClass;
    private int                    superClass;
    private List<Integer>          interfaces;
    private List<Field>            fields;

    public List<Field> getFields() {
        return fields;
    }

    public void setFields(List<Field> fields) {
        this.fields = fields;
    }

    private List<Method>    methods;
    private List<Attribute> attributes;

    public int getMajorVersion() {
        return majorVersion;
    }

    public void setMajorVersion(int majorVersion) {
        this.majorVersion = majorVersion;
    }

    public int getMinorVersion() {
        return minorVersion;
    }

    public void setMinorVersion(int minorVersion) {
        this.minorVersion = minorVersion;
    }

    public List<ConstantPoolInfo> getConstantPoolInfos() {
        return constantPoolInfos;
    }

    public void setConstantPoolInfos(List<ConstantPoolInfo> constantPoolInfos) {
        this.constantPoolInfos = constantPoolInfos;
    }

    public List<AccessFlags> getAccessFlags() {
        return accessFlags;
    }

    public void setAccessFlags(List<AccessFlags> accessFlags) {
        this.accessFlags = accessFlags;
    }

    public List<Method> getMethods() {
        return methods;
    }

    public void setMethods(List<Method> methods) {
        this.methods = methods;
    }

    public List<Attribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<Attribute> attributes) {
        this.attributes = attributes;
    }

    public static String getMagicNumber() {
        return MAGIC_NUMBER;
    }

    public int getThisClass() {
        return thisClass;
    }

    public void setThisClass(int thisClass) {
        this.thisClass = thisClass;
    }

    public int getSuperClass() {
        return superClass;
    }

    public void setSuperClass(int superClass) {
        this.superClass = superClass;
    }

    public List<Integer> getInterfaces() {
        return interfaces;
    }

    public void setInterfaces(List<Integer> interfaces) {
        this.interfaces = interfaces;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Magic Number:" + Clazz.MAGIC_NUMBER);
        sb.append("\nMinor Version:" + this.minorVersion);
        sb.append("\nMajor Version:" + this.majorVersion);
        sb.append("\nConstant Pool(Size:" + constantPoolInfos.size() + "):" + constantPoolInfos);
        sb.append("\nAccess Flags:" + Arrays.toString(accessFlags.toArray()));
        sb.append("\nThis Class(#" + thisClass + "):" + constantPoolInfos.get(thisClass - 1));
        sb.append("\nSuper Class(#" + superClass + "):" + constantPoolInfos.get(superClass - 1));
        return sb.toString();
    }
}
